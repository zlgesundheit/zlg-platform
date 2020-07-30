package test.orbdasetcomposition;

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
import test.orbdasetcomposition.definition.DiagnosisM3Evaluation;
import test.orbdasetcomposition.definition.VitalsignsM3Section;
import test.shareddefinition.CategoryDefiningcode;
import test.shareddefinition.Language;
import test.shareddefinition.SettingDefiningcode;
import test.shareddefinition.Territory;

public class ORBDAsetCompositionContainment extends Containment {
  public SelectAqlField<ORBDAsetComposition> O_R_B_D_ASET_COMPOSITION = new AqlFieldImp<ORBDAsetComposition>(ORBDAsetComposition.class, "", "ORBDAsetComposition", ORBDAsetComposition.class, this);

  public SelectAqlField<TemporalAccessor> END_TIME_VALUE = new AqlFieldImp<TemporalAccessor>(ORBDAsetComposition.class, "/context/end_time|value", "endTimeValue", TemporalAccessor.class, this);

  public ListSelectAqlField<Participation> PARTICIPATIONS = new ListAqlFieldImp<Participation>(ORBDAsetComposition.class, "/context/participations", "participations", Participation.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(ORBDAsetComposition.class, "/language", "language", Language.class, this);

  public SelectAqlField<PartyIdentified> HEALTH_CARE_FACILITY = new AqlFieldImp<PartyIdentified>(ORBDAsetComposition.class, "/context/health_care_facility", "healthCareFacility", PartyIdentified.class, this);

  public ListSelectAqlField<VitalsignsM3Section> VITALSIGNS_M3 = new ListAqlFieldImp<VitalsignsM3Section>(ORBDAsetComposition.class, "/content[openEHR-EHR-SECTION.vitalsigns_m3.v0]", "vitalsignsM3", VitalsignsM3Section.class, this);

  public SelectAqlField<Territory> TERRITORY = new AqlFieldImp<Territory>(ORBDAsetComposition.class, "/territory", "territory", Territory.class, this);

  public ListSelectAqlField<DiagnosisM3Evaluation> DIAGNOSIS_M3 = new ListAqlFieldImp<DiagnosisM3Evaluation>(ORBDAsetComposition.class, "/content[openEHR-EHR-EVALUATION.diagnosis_m3.v0]", "diagnosisM3", DiagnosisM3Evaluation.class, this);

  public SelectAqlField<TemporalAccessor> START_TIME_VALUE = new AqlFieldImp<TemporalAccessor>(ORBDAsetComposition.class, "/context/start_time|value", "startTimeValue", TemporalAccessor.class, this);

  public SelectAqlField<PartyProxy> COMPOSER = new AqlFieldImp<PartyProxy>(ORBDAsetComposition.class, "/composer", "composer", PartyProxy.class, this);

  public SelectAqlField<SettingDefiningcode> SETTING_DEFININGCODE = new AqlFieldImp<SettingDefiningcode>(ORBDAsetComposition.class, "/context/setting|defining_code", "settingDefiningcode", SettingDefiningcode.class, this);

  public SelectAqlField<String> LOCATION = new AqlFieldImp<String>(ORBDAsetComposition.class, "/context/location", "location", String.class, this);

  public SelectAqlField<CategoryDefiningcode> CATEGORY_DEFININGCODE = new AqlFieldImp<CategoryDefiningcode>(ORBDAsetComposition.class, "/category|defining_code", "categoryDefiningcode", CategoryDefiningcode.class, this);

  public ListSelectAqlField<Cluster> ERWEITERUNG = new ListAqlFieldImp<Cluster>(ORBDAsetComposition.class, "/context/other_context[at0001]/items[at0002]", "erweiterung", Cluster.class, this);

  private ORBDAsetCompositionContainment() {
    super("openEHR-EHR-COMPOSITION.encounter.v1");
  }

  public static ORBDAsetCompositionContainment getInstance() {
    return new ORBDAsetCompositionContainment();
  }
}
