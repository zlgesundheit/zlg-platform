# Plain Python ETL - Example

The following code gives an example on how to process the CSV-Input and how to build the composition-String.

**Pitfalls**  
You are mapping data in your CSV to Data Fields in the Template. Sometimes the Template has constraints on the Data Fields or has some mandatory Data Fields which do not match the data you have in your CSV. 

> In some cases you need to transform specific data entries or enrich the data you have with missing meta data or missing terminology codes.

**Preparing a Case-Objekt for the data to be stored in and also to build the composition from**  
Note the "_def composition(self) -> dict:_"-Function which is building a dict with paths and the respective data (i.e. setting the _fall-kennung_ to self.case_id)!

```python
class Case(object):
    patient_id: str
    case_id: str
    start_time: datetime = None
    end_time: datetime = None

    def __init__(self, **kwargs):
        for k in kwargs:
            self.__setattr__(k, kwargs[k])

    def __str__(self):
        attrs = vars(self)
        return ", ".join("%s: %s" % item for item in attrs.items())

    def composition(self) -> dict:
        tpl = json.loads(openehr_json_statversorgungsfall)
        tpl[
            "stationärer_versorgungsfall/context/start_time"
        ] = self.start_time.isoformat()
        tpl[
            "stationärer_versorgungsfall/aufnahmedaten/datum_uhrzeit_der_aufnahme"
        ] = self.start_time.isoformat()
        tpl[
            "stationärer_versorgungsfall/entlassungsdaten/datum_uhrzeit_der_entlassung"
        ] = self.end_time.isoformat()
        tpl["stationärer_versorgungsfall/context/fall-kennung"] = self.case_id
        return tpl

openehr_json_statversorgungsfall = """{
    "ctx/language": "de",
    "ctx/territory": "DE",
    "ctx/composer_name": "UMG-MeDIC",
    "stationärer_versorgungsfall/context/start_time": "2021-06-01",
    "stationärer_versorgungsfall/context/falltyp": "Einrichtungskontakt",
    "stationärer_versorgungsfall/context/fallklasse": "Stationär",
    "stationärer_versorgungsfall/context/fall-kennung": "Fall-Kennung 76",
    "stationärer_versorgungsfall/aufnahmedaten/datum_uhrzeit_der_aufnahme": "2021-06-03T11:30:16.658Z",
    "stationärer_versorgungsfall/entlassungsdaten/datum_uhrzeit_der_entlassung": "2021-06-03T11:30:16.658Z",
    "stationärer_versorgungsfall/aufnahmedaten/aufnahmegrund|code": "01",
    "stationärer_versorgungsfall/aufnahmedaten/aufnahmeanlass|code": "E"
}"""

```

**Reading data from a CSV-File**  
```python
def load_cases_from_csv(filename="input-csv.csv") -> List[Case]:
    case_list = []
    with open(filename, "r") as file:
        data = csv.reader(file, delimiter=";")
        header = ""
        for row in data:
            if not header:
                header = row
            else:
                case_data = {
                    "patient_id": row[22],
                    "case_id": row[3],
                    "start_time": datetime.strptime(str(row[12]), "%Y%m%d%H%M"),
                    "end_time": datetime.strptime(str(row[18]), "%Y%m%d%H%M"),
                }
                case_list.append(Case(**case_data))
    return case_list
```

**Uploading Compositions to an OpenEHR-Repository**  
(build a map of EHR-IDs and Cases first)
```python
case_lookup: Dict[str, utils.Case] = {}
for c in cases:
    case_lookup[c.case_id] = c

case_id_list = []
for c in cases:
    if c.case_id not in case_id_list:
        case_id_list.append(c.case_id)


for case in cases:
    params = {
        "ehrId": ehr_id_map[case.case_id],
        "templateId": "Stationärer Versorgungsfall",
    }
    response = post(
        openehr_url + "/composition",
        json=case.composition(),
        params=params,
        auth=openehr_auth,
    )
    if response.status_code != 201:
        print(response.content.decode(), file=sys.stderr)

```

---
[![Creative Commons Attribution-ShareAlike 4.0 International License](https://i.creativecommons.org/l/by-sa/4.0/88x31.png "Creative Commons Attribution-ShareAlike 4.0 International License")](http://creativecommons.org/licenses/by-sa/4.0/)