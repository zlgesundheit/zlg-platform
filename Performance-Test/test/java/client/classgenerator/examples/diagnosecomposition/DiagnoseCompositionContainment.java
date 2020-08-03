package org.ehrbase.client.classgenerator.examples.diagnosecomposition;

import com.nedap.archie.rm.generic.Participation;
import com.nedap.archie.rm.generic.PartyIdentified;
import com.nedap.archie.rm.generic.PartyProxy;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.client.classgenerator.examples.diagnosecomposition.definition.DiagnoseEvaluation;
import org.ehrbase.client.classgenerator.examples.diagnosecomposition.definition.FallidentifikationCluster;
import org.ehrbase.client.classgenerator.examples.shareddefinition.CategoryDefiningcode;
import org.ehrbase.client.classgenerator.examples.shareddefinition.Language;
import org.ehrbase.client.classgenerator.examples.shareddefinition.SettingDefiningcode;
import org.ehrbase.client.classgenerator.examples.shareddefinition.Territory;

import java.time.temporal.TemporalAccessor;

public class DiagnoseCompositionContainment extends Containment {
  public SelectAqlField<DiagnoseComposition> DIAGNOSE_COMPOSITION = new AqlFieldImp<DiagnoseComposition>(DiagnoseComposition.class, "", "DiagnoseComposition", DiagnoseComposition.class, this);

  public SelectAqlField<TemporalAccessor> END_TIME_VALUE = new AqlFieldImp<TemporalAccessor>(DiagnoseComposition.class, "/context/end_time|value", "endTimeValue", TemporalAccessor.class, this);

  public ListSelectAqlField<Participation> PARTICIPATIONS = new ListAqlFieldImp<Participation>(DiagnoseComposition.class, "/context/participations", "participations", Participation.class, this);

  public SelectAqlField<DiagnoseEvaluation> DIAGNOSE = new AqlFieldImp<DiagnoseEvaluation>(DiagnoseComposition.class, "/content[openEHR-EHR-EVALUATION.problem_diagnosis.v1]", "diagnose", DiagnoseEvaluation.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(DiagnoseComposition.class, "/language", "language", Language.class, this);

  public SelectAqlField<PartyIdentified> HEALTH_CARE_FACILITY = new AqlFieldImp<PartyIdentified>(DiagnoseComposition.class, "/context/health_care_facility", "healthCareFacility", PartyIdentified.class, this);

  public SelectAqlField<String> BERICHT_ID_VALUE = new AqlFieldImp<String>(DiagnoseComposition.class, "/context/other_context[at0001]/items[at0002]/value|value", "berichtIdValue", String.class, this);

  public SelectAqlField<Territory> TERRITORY = new AqlFieldImp<Territory>(DiagnoseComposition.class, "/territory", "territory", Territory.class, this);

  public SelectAqlField<TemporalAccessor> START_TIME_VALUE = new AqlFieldImp<TemporalAccessor>(DiagnoseComposition.class, "/context/start_time|value", "startTimeValue", TemporalAccessor.class, this);

  public SelectAqlField<FallidentifikationCluster> FALLIDENTIFIKATION = new AqlFieldImp<FallidentifikationCluster>(DiagnoseComposition.class, "/context/other_context[at0001]/items[openEHR-EHR-CLUSTER.case_identification.v0]", "fallidentifikation", FallidentifikationCluster.class, this);

  public SelectAqlField<PartyProxy> COMPOSER = new AqlFieldImp<PartyProxy>(DiagnoseComposition.class, "/composer", "composer", PartyProxy.class, this);

  public SelectAqlField<SettingDefiningcode> SETTING_DEFININGCODE = new AqlFieldImp<SettingDefiningcode>(DiagnoseComposition.class, "/context/setting|defining_code", "settingDefiningcode", SettingDefiningcode.class, this);

  public SelectAqlField<String> LOCATION = new AqlFieldImp<String>(DiagnoseComposition.class, "/context/location", "location", String.class, this);

  public SelectAqlField<CategoryDefiningcode> CATEGORY_DEFININGCODE = new AqlFieldImp<CategoryDefiningcode>(DiagnoseComposition.class, "/category|defining_code", "categoryDefiningcode", CategoryDefiningcode.class, this);

  private DiagnoseCompositionContainment() {
    super("openEHR-EHR-COMPOSITION.report.v1");
  }

  public static DiagnoseCompositionContainment getInstance() {
    return new DiagnoseCompositionContainment();
  }
}
