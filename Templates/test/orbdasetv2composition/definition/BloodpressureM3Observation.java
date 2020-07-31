package test.orbdasetv2composition.definition;

import com.nedap.archie.rm.generic.PartyProxy;
import java.lang.Double;
import java.lang.String;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import test.shareddefinition.Language;

@Entity
@Archetype("openEHR-EHR-OBSERVATION.bloodpressure_m3.v0")
public class BloodpressureM3Observation {
  @Path("/data[at0001]/events[at0002]/time|value")
  private TemporalAccessor timeValue;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0012]/items[at0010]/value|magnitude")
  private Double diastolicBloodPressureMagnitude;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0012]/items[at0010]/value|units")
  private String diastolicBloodPressureUnits;

  @Path("/subject")
  private PartyProxy subject;

  @Path("/data[at0001]/origin|value")
  private TemporalAccessor originValue;

  @Path("/language")
  private Language language;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0012]/items[at0009]/value|magnitude")
  private Double systolicBloodPressureMagnitude;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0012]/items[at0009]/value|units")
  private String systolicBloodPressureUnits;

  public void setTimeValue(TemporalAccessor timeValue) {
     this.timeValue = timeValue;
  }

  public TemporalAccessor getTimeValue() {
     return this.timeValue ;
  }

  public void setDiastolicBloodPressureMagnitude(Double diastolicBloodPressureMagnitude) {
     this.diastolicBloodPressureMagnitude = diastolicBloodPressureMagnitude;
  }

  public Double getDiastolicBloodPressureMagnitude() {
     return this.diastolicBloodPressureMagnitude ;
  }

  public void setDiastolicBloodPressureUnits(String diastolicBloodPressureUnits) {
     this.diastolicBloodPressureUnits = diastolicBloodPressureUnits;
  }

  public String getDiastolicBloodPressureUnits() {
     return this.diastolicBloodPressureUnits ;
  }

  public void setSubject(PartyProxy subject) {
     this.subject = subject;
  }

  public PartyProxy getSubject() {
     return this.subject ;
  }

  public void setOriginValue(TemporalAccessor originValue) {
     this.originValue = originValue;
  }

  public TemporalAccessor getOriginValue() {
     return this.originValue ;
  }

  public void setLanguage(Language language) {
     this.language = language;
  }

  public Language getLanguage() {
     return this.language ;
  }

  public void setSystolicBloodPressureMagnitude(Double systolicBloodPressureMagnitude) {
     this.systolicBloodPressureMagnitude = systolicBloodPressureMagnitude;
  }

  public Double getSystolicBloodPressureMagnitude() {
     return this.systolicBloodPressureMagnitude ;
  }

  public void setSystolicBloodPressureUnits(String systolicBloodPressureUnits) {
     this.systolicBloodPressureUnits = systolicBloodPressureUnits;
  }

  public String getSystolicBloodPressureUnits() {
     return this.systolicBloodPressureUnits ;
  }
}
