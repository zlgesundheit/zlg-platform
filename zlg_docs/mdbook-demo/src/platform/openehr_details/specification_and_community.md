# Community and Specification

## openEHR Community
The openEHR-Specification as well as the [ISO-Standard](http://www.en13606.org/information.html) are heavily influenced by the ongoing work and usage of the approach in the openEHR-Community. Users all of the world (especially in spain, netherland, germany, japan, china, sweden and brazil) work on the further development of the approach.

A good place to get information and to participate in the development of the standard and tools is the [openEHR-Forum](https://discourse.openehr.org). You can also check the Github-Pages of the available tools to get in touch with the development and related people.

## openEHR Specification
The openEHR Specification can be found at [https://specifications.openehr.org](https://specifications.openehr.org). It covers all aspects of openEHR and allow an in depth read about the different components and concepts of openEHR.

#### Primitive Types
OpenEHR knows different primitive data types that are used in archetypes. A comprehensive list of those types can be found in the [Primitive Types Section](https://specifications.openehr.org/releases/BASE/latest/foundation_types.html#_primitive_types) of the specification.

#### Data Types
Based upon the primitive types you can find the more abstract data types in the packages in the section about [Data Type Information Models](https://specifications.openehr.org/releases/RM/latest/data_types.html#_basic_package). 

The DV_CODED_TEXT Class for example is a Data Type that is used often. It contains of a list of CODE_PHRASES with code, display value and terminology-name:
> ```json
> {
>     "[FLAT-Path]|value" : "Female",   
>     "[FLAT-Path]|code" : "female",    
>     "[FLAT-Path]|terminology" : "http://hl7.org/fhir/ValueSet/administrative-gender"  
> }
> ```  

Another example is the DV_QUANTITY Data Type. It contains scientific quantities, i.e. quantities expressed as a magnitude and units:

> ```json
> {
>     "[FLAT-Path]|magnitude" : "120",   
>     "[FLAT-Path]|unit" : "mm[Hg]"  
> }
> ```

#### Date Formatting
Dates are formatted in [ISO 8601](https://specifications.openehr.org/releases/BASE/latest/foundation_types.html#_iso8601_date_time_class).

- DV_DATE as  

> ```json
> {
>     "geburtsdatum": "1964-02-02"
> }
> ```

- DV_TIME as  
hh:mm:ss[(,|.)sss][Z|±hh[:mm]] (extended, preferred) or  
hhmmss[(,|.)sss][Z|±hh[mm]] (compact)
> ```json
> {
>     "uhrzeit_testbeginn": "10:20"
> }
> ```

- DV_DATE_TIME as  
YYYY-MM-DDThh:mm:ss[(,|.)sss][Z | ±hh[:mm]] (extended, preferred) or  
YYYYMMDDThhmmss[(,|.)sss][Z | ±hh[mm]] (compact)
> ```json
> {
>     "context/start_time": "2020-02-02T00:00:00"
> }
> ```