# zlg-ehrbase

## Kontext
The ZLG is using the [EHRBase](https://github.com/ehrbase/ehrbase) a Clinical Data Repository to store data in an interopable way using the openEHR-Technology Framework.

EHRbase is an openEHR Clinical Data Repository, providing a standard-based backend for interoperable clinical applications. It implements the latest version of the openEHR Reference Model (RM 1.0.4) and version 1.4 of the Archetype Definition Language (ADL). Applications can use the capabilities of EHRbase through the latest version of the openEHR REST API and model-based queries using the Archetype Query Language.

## Documentation
- [openEHR-Specification](https://specifications.openehr.org)
- [openEHR REST API-Documentation](https://specifications.openehr.org/releases/ITS-REST/Release-1.0.0/ehr.html)
- [EHRBase Documentation](https://ehrbase.readthedocs.io/en/latest/01_release_notes/index.html)
- [EHRBase REST API Documentation](http://141.5.100.115/ehrbase/swagger-ui.html)

## Branches

| Branch | Use | Link |
| ------ | ------ | -----|
| master | ... | [Link](https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit/zlg-ehrbase/-/tree/master) |
| zl-prod  | Docker und Skripte für Inbetriebnahme einer Instanz | [Link](https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit/zlg-ehrbase/-/tree/zl-prod) |
| zl-dev-test | Testumgebung mit Notizen, Anleitungen und Testdateien | [Link](https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit/zlg-ehrbase/-/tree/zl-dev-test) |

---
We can merge specific merged files into master/prod by using:
```
$ git branch
* master
  twitter_integration

$ git checkout twitter_integration app/models/avatar.rb db/migrate/20090223104419_create_avatars.rb test/unit/models/avatar_test.rb test/functional/models/avatar_test.rb

$ git status
# On branch master
# Changes to be committed:
#   (use "git reset HEAD <file>..." to unstage)
#
#	new file:   app/models/avatar.rb
#	new file:   db/migrate/20090223104419_create_avatars.rb
#	new file:   test/functional/models/avatar_test.rb
#	new file:   test/unit/models/avatar_test.rb

$ git commit -m "'Merge' avatar code from 'twitter_integration' branch"
[master]: created 4d3e37b: "'Merge' avatar code from 'twitter_integration' branch"
4 files changed, 72 insertions(+), 0 deletions(-)
create mode 100644 app/models/avatar.rb
create mode 100644 db/migrate/20090223104419_create_avatars.rb
create mode 100644 test/functional/models/avatar_test.rb
create mode 100644 test/unit/models/avatar_test.rb
```
