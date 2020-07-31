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
@Archetype("openEHR-EHR-OBSERVATION.heartrate_m3.v0")
public class HeartrateM3Observation {
  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0004]/items[at0006]/value|magnitude")
  private Double heartRateMagnitude;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0004]/items[at0006]/value|units")
  private String heartRateUnits;

  @Path("/data[at0001]/events[at0002]/time|value")
  private TemporalAccessor timeValue;

  @Path("/subject")
  private PartyProxy subject;

  @Path("/data[at0001]/origin|value")
  private TemporalAccessor originValue;

  @Path("/language")
  private Language language;

  public void setHeartRateMagnitude(Double heartRateMagnitude) {
     this.heartRateMagnitude = heartRateMagnitude;
  }

  public Double getHeartRateMagnitude() {
     return this.heartRateMagnitude ;
  }

  public void setHeartRateUnits(String heartRateUnits) {
     this.heartRateUnits = heartRateUnits;
  }

  public String getHeartRateUnits() {
     return this.heartRateUnits ;
  }

  public void setTimeValue(TemporalAccessor timeValue) {
     this.timeValue = timeValue;
  }

  public TemporalAccessor getTimeValue() {
     return this.timeValue ;
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
}
