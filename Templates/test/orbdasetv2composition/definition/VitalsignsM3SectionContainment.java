package test.orbdasetv2composition.definition;

import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;

public class VitalsignsM3SectionContainment extends Containment {
  public SelectAqlField<VitalsignsM3Section> VITALSIGNS_M3_SECTION = new AqlFieldImp<VitalsignsM3Section>(VitalsignsM3Section.class, "", "VitalsignsM3Section", VitalsignsM3Section.class, this);

  public ListSelectAqlField<HeartrateM3Observation> HEARTRATE_M3 = new ListAqlFieldImp<HeartrateM3Observation>(VitalsignsM3Section.class, "/items[openEHR-EHR-OBSERVATION.heartrate_m3.v0]", "heartrateM3", HeartrateM3Observation.class, this);

  public ListSelectAqlField<BloodpressureM3Observation> BLOODPRESSURE_M3 = new ListAqlFieldImp<BloodpressureM3Observation>(VitalsignsM3Section.class, "/items[openEHR-EHR-OBSERVATION.bloodpressure_m3.v0]", "bloodpressureM3", BloodpressureM3Observation.class, this);

  private VitalsignsM3SectionContainment() {
    super("openEHR-EHR-SECTION.vitalsigns_m3.v0");
  }

  public static VitalsignsM3SectionContainment getInstance() {
    return new VitalsignsM3SectionContainment();
  }
}
