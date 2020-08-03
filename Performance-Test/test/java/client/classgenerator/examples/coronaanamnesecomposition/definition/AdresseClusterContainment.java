package org.ehrbase.client.classgenerator.examples.coronaanamnesecomposition.definition;

import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.SelectAqlField;

public class AdresseClusterContainment extends Containment {
  public SelectAqlField<AdresseCluster> ADRESSE_CLUSTER = new AqlFieldImp<AdresseCluster>(AdresseCluster.class, "", "AdresseCluster", AdresseCluster.class, this);

  public SelectAqlField<String> STADT_VALUE = new AqlFieldImp<String>(AdresseCluster.class, "/items[at0012]/value|value", "stadtValue", String.class, this);

  public SelectAqlField<String> LAND_VALUE = new AqlFieldImp<String>(AdresseCluster.class, "/items[at0015]/value|value", "landValue", String.class, this);

  private AdresseClusterContainment() {
    super("openEHR-EHR-CLUSTER.address_cc.v0");
  }

  public static AdresseClusterContainment getInstance() {
    return new AdresseClusterContainment();
  }
}
