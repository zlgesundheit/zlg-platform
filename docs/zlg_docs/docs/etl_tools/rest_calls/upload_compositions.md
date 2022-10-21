---
title: Upload Composition
sidebar_position: 4
---

# Upload a Composition for a specific EHR

#### POST-Request
Endpoint:
> ```"{baseUrl}/v1/ehr/>>ehr_id<</composition"```

Header(s):
```
Content-Type: application/json
Prefer: return={representation|minimal}
```

Body:
```json
{
  "_type": "COMPOSITION",
  "archetype_node_id": "openEHR-EHR-COMPOSITION.encounter.v1",
  "name": {
    "value": "Vital Signs"
  },
  "uid": {
    "_type": "OBJECT_VERSION_ID",
    "value": "8849182c-82ad-4088-a07f-48ead4180515::openEHRSys.example.com::1"
  },
  "archetype_details": {
    "archetype_id": {
      "value": "openEHR-EHR-COMPOSITION.encounter.v1"
    },
    "template_id": {
      "value": "Example.v1::c7ec861c-c413-39ff-9965-a198ebf44747"
    },
    "rm_version": "1.0.2"
  },
  "language": {
    "terminology_id": {
      "value": "ISO_639-1"
    },
    "code_string": "en"
  },
  "territory": {
    "terminology_id": {
      "value": "ISO_3166-1"
    },
    "code_string": "NL"
  },
  "category": {
    "value": "event",
    "defining_code": {
      "terminology_id": {
        "value": "openehr"
      },
      "code_string": "433"
    }
  },
  "composer": {
    "_type": "PARTY_IDENTIFIED",
    "external_ref": {
      "id": {
        "_type": "GENERIC_ID",
        "value": "16b74749-e6aa-4945-b760-b42bdc07098a"
      },
      "namespace": "openEHRSys.example.com",
      "type": "PERSON"
    },
    "name": "A name"
  },
  "context": {
    "start_time": {
      "value": "2014-11-18T09:50:35.000+01:00"
    },
    "setting": {
      "value": "other care",
      "defining_code": {
        "terminology_id": {
          "value": "openehr"
        },
        "code_string": "238"
      }
    }
  },
  "content": []
}
```

Result:  
> ```"201 Created"``` is the returned HTTP Code when the Composition has been successfully created.

---
[![Creative Commons Attribution-ShareAlike 4.0 International License](https://i.creativecommons.org/l/by-sa/4.0/88x31.png "Creative Commons Attribution-ShareAlike 4.0 International License")](http://creativecommons.org/licenses/by-sa/4.0/)