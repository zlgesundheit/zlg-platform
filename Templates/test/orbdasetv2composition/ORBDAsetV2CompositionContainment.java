package test.orbdasetv2composition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.Participation;
import com.nedap.archie.rm.generic.PartyIdentified;
import com.nedap.archie.rm.generic.PartyProxy;
import java.lang.String;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import test.orbdasetv2composition.definition.DiagnosisM3Evaluation;
import test.orbdasetv2composition.definition.VitalsignsM3Section;
import test.shareddefinition.CategoryDefiningcode;
import test.shareddefinition.Language;
import test.shareddefinition.SettingDefiningcode;
import test.shareddefinition.Territory;

public class ORBDAsetV2CompositionContainment extends Containment {
  public SelectAqlField<ORBDAsetV2Composition> O_R_B_D_ASET_V2_COMPOSITION = new AqlFieldImp<ORBDAsetV2Composition>(ORBDAsetV2Composition.class, "", "ORBDAsetV2Composition", ORBDAsetV2Composition.class, this);

  public SelectAqlField<TemporalAccessor> END_TIME_VALUE = new AqlFieldImp<TemporalAccessor>(ORBDAsetV2Composition.class, "/context/end_time|value", "endTimeValue", TemporalAccessor.class, this);

  public ListSelectAqlField<Participation> PARTICIPATIONS = new ListAqlFieldImp<Participation>(ORBDAsetV2Composition.class, "/context/participations", "participations", Participation.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(ORBDAsetV2Composition.class, "/language", "language", Language.class, this);

  public SelectAqlField<PartyIdentified> HEALTH_CARE_FACILITY = new AqlFieldImp<PartyIdentified>(ORBDAsetV2Composition.class, "/context/health_care_facility", "healthCareFacility", PartyIdentified.class, this);

  public ListSelectAqlField<VitalsignsM3Section> VITALSIGNS_M3 = new ListAqlFieldImp<VitalsignsM3Section>(ORBDAsetV2Composition.class, "/content[openEHR-EHR-SECTION.vitalsigns_m3.v0]", "vitalsignsM3", VitalsignsM3Section.class, this);

  public SelectAqlField<Territory> TERRITORY = new AqlFieldImp<Territory>(ORBDAsetV2Composition.class, "/territory", "territory", Territory.class, this);

  public ListSelectAqlField<DiagnosisM3Evaluation> DIAGNOSIS_M3 = new ListAqlFieldImp<DiagnosisM3Evaluation>(ORBDAsetV2Composition.class, "/content[openEHR-EHR-EVALUATION.diagnosis_m3.v0]", "diagnosisM3", DiagnosisM3Evaluation.class, this);

  public SelectAqlField<TemporalAccessor> START_TIME_VALUE = new AqlFieldImp<TemporalAccessor>(ORBDAsetV2Composition.class, "/context/start_time|value", "startTimeValue", TemporalAccessor.class, this);

  public SelectAqlField<PartyProxy> COMPOSER = new AqlFieldImp<PartyProxy>(ORBDAsetV2Composition.class, "/composer", "composer", PartyProxy.class, this);

  public SelectAqlField<SettingDefiningcode> SETTING_DEFININGCODE = new AqlFieldImp<SettingDefiningcode>(ORBDAsetV2Composition.class, "/context/setting|defining_code", "settingDefiningcode", SettingDefiningcode.class, this);

  public SelectAqlField<String> LOCATION = new AqlFieldImp<String>(ORBDAsetV2Composition.class, "/context/location", "location", String.class, this);

  public SelectAqlField<CategoryDefiningcode> CATEGORY_DEFININGCODE = new AqlFieldImp<CategoryDefiningcode>(ORBDAsetV2Composition.class, "/category|defining_code", "categoryDefiningcode", CategoryDefiningcode.class, this);

  public ListSelectAqlField<Cluster> ERWEITERUNG = new ListAqlFieldImp<Cluster>(ORBDAsetV2Composition.class, "/context/other_context[at0001]/items[at0002]", "erweiterung", Cluster.class, this);

  private ORBDAsetV2CompositionContainment() {
    super("openEHR-EHR-COMPOSITION.encounter.v1");
  }

  public static ORBDAsetV2CompositionContainment getInstance() {
    return new ORBDAsetV2CompositionContainment();
  }
}
