package org.ehrbase.client.classgenerator.examples.coronaanamnesecomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.client.classgenerator.examples.shareddefinition.Language;

import java.time.temporal.TemporalAccessor;

public class DiganoseCoronovirusEvaluationContainment extends Containment {
  public SelectAqlField<DiganoseCoronovirusEvaluation> DIGANOSE_CORONOVIRUS_EVALUATION = new AqlFieldImp<DiganoseCoronovirusEvaluation>(DiganoseCoronovirusEvaluation.class, "", "DiganoseCoronovirusEvaluation", DiganoseCoronovirusEvaluation.class, this);

  public ListSelectAqlField<Cluster> ERWEITERUNG = new ListAqlFieldImp<Cluster>(DiganoseCoronovirusEvaluation.class, "/protocol[at0032]/items[at0071]", "erweiterung", Cluster.class, this);

  public SelectAqlField<String> KOMMENTAR_VALUE = new AqlFieldImp<String>(DiganoseCoronovirusEvaluation.class, "/data[at0001]/items[at0069]/value|value", "kommentarValue", String.class, this);

  public SelectAqlField<String> DER_DIAGNOSE_VALUE = new AqlFieldImp<String>(DiganoseCoronovirusEvaluation.class, "/data[at0001]/items[at0002]/value|value", "derDiagnoseValue", String.class, this);

  public ListSelectAqlField<Cluster> ANATOMISCHE_STELLE_STRUKTURIERT = new ListAqlFieldImp<Cluster>(DiganoseCoronovirusEvaluation.class, "/data[at0001]/items[at0039]", "anatomischeStelleStrukturiert", Cluster.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(DiganoseCoronovirusEvaluation.class, "/language", "language", Language.class, this);

  public SelectAqlField<StatusCluster> STATUS = new AqlFieldImp<StatusCluster>(DiganoseCoronovirusEvaluation.class, "/data[at0001]/items[openEHR-EHR-CLUSTER.problem_qualifier.v1 and name/value='Status']", "status", StatusCluster.class, this);

  public SelectAqlField<TemporalAccessor> ZULETZT_AKTUALISIERT_VALUE = new AqlFieldImp<TemporalAccessor>(DiganoseCoronovirusEvaluation.class, "/protocol[at0032]/items[at0070]/value|value", "zuletztAktualisiertValue", TemporalAccessor.class, this);

  public SelectAqlField<PartyProxy> SUBJECT = new AqlFieldImp<PartyProxy>(DiganoseCoronovirusEvaluation.class, "/subject", "subject", PartyProxy.class, this);

  public ListSelectAqlField<Cluster> SPEZIFISCHE_ANGABEN = new ListAqlFieldImp<Cluster>(DiganoseCoronovirusEvaluation.class, "/data[at0001]/items[at0043]", "spezifischeAngaben", Cluster.class, this);

  public SelectAqlField<StatusDiagnostischeSicherheitChoice> DIAGNOSTISCHE_SICHERHEIT = new AqlFieldImp<StatusDiagnostischeSicherheitChoice>(DiganoseCoronovirusEvaluation.class, "/data[at0001]/items[at0073]/value", "diagnostischeSicherheit", StatusDiagnostischeSicherheitChoice.class, this);

  private DiganoseCoronovirusEvaluationContainment() {
    super("openEHR-EHR-EVALUATION.problem_diagnosis_covid.v1");
  }

  public static DiganoseCoronovirusEvaluationContainment getInstance() {
    return new DiganoseCoronovirusEvaluationContainment();
  }
}
