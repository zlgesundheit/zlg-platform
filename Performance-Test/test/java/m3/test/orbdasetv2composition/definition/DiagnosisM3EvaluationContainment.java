package test.m3.test.orbdasetv2composition.definition;

import com.nedap.archie.rm.generic.PartyProxy;
import java.lang.String;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.SelectAqlField;
import test.m3.test.shareddefinition.Language;

public class DiagnosisM3EvaluationContainment extends Containment {
  public SelectAqlField<DiagnosisM3Evaluation> DIAGNOSIS_M3_EVALUATION = new AqlFieldImp<DiagnosisM3Evaluation>(DiagnosisM3Evaluation.class, "", "DiagnosisM3Evaluation", DiagnosisM3Evaluation.class, this);

  public SelectAqlField<PartyProxy> SUBJECT = new AqlFieldImp<PartyProxy>(DiagnosisM3Evaluation.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(DiagnosisM3Evaluation.class, "/language", "language", Language.class, this);

  public SelectAqlField<String> DIAGNOSIS_VALUE = new AqlFieldImp<String>(DiagnosisM3Evaluation.class, "/data[at0001]/items[at0002]/items[at0003]/value|value", "diagnosisValue", String.class, this);

  private DiagnosisM3EvaluationContainment() {
    super("openEHR-EHR-EVALUATION.diagnosis_m3.v0");
  }

  public static DiagnosisM3EvaluationContainment getInstance() {
    return new DiagnosisM3EvaluationContainment();
  }
}
