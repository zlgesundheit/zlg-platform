import requests
import json
import csv
import os
import os.path
import sys
from tqdm import tqdm

#check if hostname is provided

try:
    base_url = sys.argv[1]
except Exception as E:
    print(E)
    print("No Hostname provided - e.g.: http://141.5.100.99/ehrbase/")
auth_cred = ''
username = ''
password = ''
if len(sys.argv) >=4:
    username = sys.argv[2]
    password = sys.argv[3]
    auth_cred = 1
else:
    auth_cred = 0
#openehr API REST endpoint for posting operational templates
rest_endpoint = "definition/template/adl1.4/"

headers = {
    'accept': '*/*',
    'Content-Type': 'application/xml',
    'Prefer': 'return=representation',
}


current_dir_path = os.getcwd()
url = base_url+rest_endpoint

for dirpath, dirnames, filenames in os.walk(current_dir_path):
    for filename in [f for f in filenames if f.endswith(".opt")]:
        with open(os.path.join(dirpath, filename),"r") as file:
            try: 
                data = file.read().encode("utf-8")
                if auth_cred:
                    response = requests.post(url, headers=headers, data=data, auth=(username, password))
                else:
                    response = requests.post(url, headers=headers, data=data)
            except Exception as E:
                print(E)
            file.close()
