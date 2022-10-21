# Pseudonymisation and Anonymisation

A pseudonymization service provides a service that can be used to pseudonymize (patient) data. Pseudonymization involves masking certain identifying data points in personal data that allow conclusions to be drawn about the identity of the person belonging to the data (such as the name of a patient). 

Masking is done by replacing the name and other identifying characteristics with another identifier. The aim is to make identification of the data subject impossible or at least considerably more difficult. In contrast to anonymization, in which personal data is changed in such a way that personal or factual circumstances could only be restored with disproportionate effort, re-identification is possible with pseudonymization if a pseudonym list is available. The pseudonym list (also known as the patient list) allows the identifying data (IDAT) and the corresponding pseudonym (PSN) to be assigned. The relevant terms are defined in §46 BDSG. 

A generally accepted procedure for pseudonymization has been developed by the TMF in the form of generic data protection concepts. The basic idea of this procedure is the outsourcing of knowledge necessary for re-identification to a trusted third party (TTP). The two-stage procedure is illustrated in the figure below. In the figure, it can be seen that the IDAT remain with the data collector and the medical data (MDAT) are only delivered together with a patient-specific PID. The TTP generates a PSN (second stage of pseudonymization) for each PID, which is used to transmit the MDAT to a research database, for example.

![TMF Pseudonymisation](/img/tmf_pseudo.jpg)
(https://www.tmf-ev.de/Arbeitsgruppen_Foren/AGDS.aspx)


---
[![Creative Commons Attribution-ShareAlike 4.0 International License](https://i.creativecommons.org/l/by-sa/4.0/88x31.png "Creative Commons Attribution-ShareAlike 4.0 International License")](http://creativecommons.org/licenses/by-sa/4.0/)