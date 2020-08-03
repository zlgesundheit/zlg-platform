package org.ehrbase.client.classgenerator.examples.diagnosecomposition.definition;

import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.SelectAqlField;

public class FallidentifikationClusterContainment extends Containment {
  public SelectAqlField<FallidentifikationCluster> FALLIDENTIFIKATION_CLUSTER = new AqlFieldImp<FallidentifikationCluster>(FallidentifikationCluster.class, "", "FallidentifikationCluster", FallidentifikationCluster.class, this);

  public SelectAqlField<String> FALL_KENNUNG_VALUE = new AqlFieldImp<String>(FallidentifikationCluster.class, "/items[at0001]/value|value", "fallKennungValue", String.class, this);

  private FallidentifikationClusterContainment() {
    super("openEHR-EHR-CLUSTER.case_identification.v0");
  }

  public static FallidentifikationClusterContainment getInstance() {
    return new FallidentifikationClusterContainment();
  }
}
