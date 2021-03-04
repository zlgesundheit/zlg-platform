#!/bin/bash

echo "Supplied arguments #1:BaseURL, #2:Username, #3:Password"

if [ $# -eq 0 ]
  then
    echo "No arguments supplied"
    echo "Usage: arg1=ehr-system-hostname_or_ip-address_with_port_and_path_to_openehr_rest_endpoint"
    echo "e.g.: http://141.5.100.155:8080/ehrbase" 
    exit 1
fi

#
# Test connection
#
response_code=$(curl -X GET --write-out %{http_code} -u $2:$3 --silent --output /dev/null $1"/rest/openehr/v1/status")
echo "Connection url: $1/rest/openehr/v1/status"
echo "Connection test response code: $response_code"
if [ $response_code -gt 200 ] #-gt
  then
    echo "There might be a problem with the hostname or the path to the ehr endpoint."
#    exit 1
fi

#
# operational templates ------------------------------------
#

# start monitoring scripts for posting opts
echo "Start posting operational templates"
# post opts
echo $(date +"%T")
python3 post_opts.py $1"/rest/openehr/v1/" $2 $3 &
PID=$!
i=1
sp="/-\|"
echo -n ' '
while [ -d /proc/$PID ]
do
  printf "\b${sp:i++%${#sp}:1}"
done
sleep 1

echo -n ' '
echo "Finished running Template-Upload-Script!"
exit 0
