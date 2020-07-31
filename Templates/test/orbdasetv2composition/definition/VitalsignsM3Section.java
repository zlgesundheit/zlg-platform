package test.orbdasetv2composition.definition;

import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;

@Entity
@Archetype("openEHR-EHR-SECTION.vitalsigns_m3.v0")
public class VitalsignsM3Section {
  @Path("/items[openEHR-EHR-OBSERVATION.heartrate_m3.v0]")
  private List<HeartrateM3Observation> heartrateM3;

  @Path("/items[openEHR-EHR-OBSERVATION.bloodpressure_m3.v0]")
  private List<BloodpressureM3Observation> bloodpressureM3;

  public void setHeartrateM3(List<HeartrateM3Observation> heartrateM3) {
     this.heartrateM3 = heartrateM3;
  }

  public List<HeartrateM3Observation> getHeartrateM3() {
     return this.heartrateM3 ;
  }

  public void setBloodpressureM3(List<BloodpressureM3Observation> bloodpressureM3) {
     this.bloodpressureM3 = bloodpressureM3;
  }

  public List<BloodpressureM3Observation> getBloodpressureM3() {
     return this.bloodpressureM3 ;
  }
}
