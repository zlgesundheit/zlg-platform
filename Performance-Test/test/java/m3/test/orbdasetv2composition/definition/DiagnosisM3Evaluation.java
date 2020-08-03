package test.m3.test.orbdasetv2composition.definition;

import com.nedap.archie.rm.generic.PartyProxy;
import java.lang.String;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import test.m3.test.shareddefinition.Language;

@Entity
@Archetype("openEHR-EHR-EVALUATION.diagnosis_m3.v0")
public class DiagnosisM3Evaluation {
  @Path("/subject")
  private PartyProxy subject;

  @Path("/language")
  private Language language;

  @Path("/data[at0001]/items[at0002]/items[at0003]/value|value")
  private String diagnosisValue;

  public void setSubject(PartyProxy subject) {
     this.subject = subject;
  }

  public PartyProxy getSubject() {
     return this.subject ;
  }

  public void setLanguage(Language language) {
     this.language = language;
  }

  public Language getLanguage() {
     return this.language ;
  }

  public void setDiagnosisValue(String diagnosisValue) {
     this.diagnosisValue = diagnosisValue;
  }

  public String getDiagnosisValue() {
     return this.diagnosisValue ;
  }
}
