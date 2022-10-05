# Create an EHR
EHRs are the core part of a data set. An EHR can be seen as the representation of a patient and each patient should be represented by one EHR with his specific IDs.

#### POST-Request
Endpoint:
> ```"{baseUrl}/v1/ehr"```

Header(s):
```
Content-Type: application/json
Prefer: return={representation|minimal}
```

Body (can be empty or can contain EHR-Definition with external reference ID as seen below): 
```json
{
  "_type": "EHR_STATUS",
  "archetype_node_id": "openEHR-EHR-EHR_STATUS.generic.v1",
  "name": {
    "value": "EHR"
  },
  "subject": {
    "external_ref": {
      "id": {
        "_type": "GENERIC_ID",
        "value": "{{subject_id}}",
        "scheme": "id_scheme"
      },
      "namespace": "{{subject_namespace}}",
      "type": "PERSON"
    }
  },
  "is_modifiable": true,
  "is_queryable": true
}
```

Result:  
> ```"201 Created"``` is the returned HTTP Code when the EHR has been successfully created.

---
[![Creative Commons Attribution-ShareAlike 4.0 International License](https://i.creativecommons.org/l/by-sa/4.0/88x31.png "Creative Commons Attribution-ShareAlike 4.0 International License")](http://creativecommons.org/licenses/by-sa/4.0/)