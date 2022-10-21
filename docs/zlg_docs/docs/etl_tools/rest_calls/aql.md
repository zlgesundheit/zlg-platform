---
title: Query Resources
sidebar_position: 5
---

# Querying Resources and AQL-Queries

## Query Data
Data can be queried using AQL ([Archetype Query Language](https://specifications.openehr.org/releases/QUERY/latest/AQL.html)) or using the i.e the compositionID of specific compositions.

- by [CompositionID](https://specifications.openehr.org/releases/ITS-REST/latest/ehr.html#composition-composition-get)
- by [AQL-Query](https://specifications.openehr.org/releases/ITS-REST/latest/query.html#query-execute-query-get)

## Querying Data via AQL

The following request sends an AQL-Query to the relevant endpoint.
AQL is a declarative query language that allows the user to query for data stored as compositions (as instances of data templates) without knowing where it is stored in the server. This means that in the AQL Query the Elements from the Template are used to identify data attributes.

In depth reasoning and explanation can be found in the [Specification of AQL](https://specifications.openehr.org/releases/QUERY/latest/AQL.html).

## Example
(taken from the AQL-Specification)

```
SELECT                                                       -- Select clause
   o/data[at0001]/.../items[at0004]/value AS systolic,       -- Identified path with alias
   o/data[at0001]/.../items[at0005]/value AS diastolic,
   c/context/start_time AS date_time
FROM                                                         -- From clause
   EHR[ehr_id/value=$ehrUid]                                 -- RM class expression
      CONTAINS                                               -- containment
         COMPOSITION c                                       -- RM class expression
            [openEHR-EHR-COMPOSITION.encounter.v1]           -- archetype predicate
         CONTAINS
            OBSERVATION o [openEHR-EHR-OBSERVATION.blood_pressure.v1]
WHERE                                                        -- Where clause
   o/data[at0001]/.../items[at0004]/value/value >= 140 OR    -- value comparison
   o/data[at0001]/.../items[at0005]/value/value >= 90
ORDER BY                                                     -- order by datetime, latest first
   c/context/start_time DESC
```

#### Pitfalls
While the Language and REST-API are standardized there may occur deviations from the standard in todays tools and servers. Some Servers like EHRBase or Better offer additional APIs with Features that are not covered by the openEHR-Standard-API.

Also the fault tolerance or already implement features of the different servers might differ leading to one server being more graceful when interpreting requests than others!

## Example Request 

#### POST-Request
Endpoint:
> ```"{{host}}/rest/openehr/v1/query/aql"```

Header(s):
```
Content-Type: application/json
Prefer: return={representation|minimal}
```

Body:
```json
{
"q":"
    SELECT
        e/ehr_id/value,
        e/ehr_status/subject/external_ref/id/value,
        c/context/other_context[at0001]/items[at0002]/value/defining_code/code_string
    FROM EHR e
        CONTAINS COMPOSITION c[openEHR-EHR-COMPOSITION.report.v1]
    WHERE
        c/context/other_context[at0001]/items[at0002]/value/defining_code/code_string = 'T3a' OR
        c/context/other_context[at0001]/items[at0002]/value/defining_code/code_string = 'T3b'
    "
}
```

Result:  
> ```"200 OK"``` is the returned HTTP Code together with a tabular representation of the selected attributes from the matching resources if the query works as intended.

---
[![Creative Commons Attribution-ShareAlike 4.0 International License](https://i.creativecommons.org/l/by-sa/4.0/88x31.png "Creative Commons Attribution-ShareAlike 4.0 International License")](http://creativecommons.org/licenses/by-sa/4.0/)