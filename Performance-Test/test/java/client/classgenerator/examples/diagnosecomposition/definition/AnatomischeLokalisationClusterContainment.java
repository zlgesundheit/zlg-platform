package org.ehrbase.client.classgenerator.examples.diagnosecomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;

public class AnatomischeLokalisationClusterContainment extends Containment {
  public SelectAqlField<AnatomischeLokalisationCluster> ANATOMISCHE_LOKALISATION_CLUSTER = new AqlFieldImp<AnatomischeLokalisationCluster>(AnatomischeLokalisationCluster.class, "", "AnatomischeLokalisationCluster", AnatomischeLokalisationCluster.class, this);

  public ListSelectAqlField<Cluster> ALTERNATIVE_STRUKTUR = new ListAqlFieldImp<Cluster>(AnatomischeLokalisationCluster.class, "/items[at0053]", "alternativeStruktur", Cluster.class, this);

  public SelectAqlField<String> NAME_DER_KORPERSTELLE_VALUE = new AqlFieldImp<String>(AnatomischeLokalisationCluster.class, "/items[at0001]/value|value", "nameDerKorperstelleValue", String.class, this);

  public ListSelectAqlField<Cluster> MULTIMEDIALE_DARSTELLUNG = new ListAqlFieldImp<Cluster>(AnatomischeLokalisationCluster.class, "/items[at0054]", "multimedialeDarstellung", Cluster.class, this);

  public SelectAqlField<LateralitatDefiningcode> LATERALITAT_DEFININGCODE = new AqlFieldImp<LateralitatDefiningcode>(AnatomischeLokalisationCluster.class, "/items[at0002]/value|defining_code", "lateralitatDefiningcode", LateralitatDefiningcode.class, this);

  private AnatomischeLokalisationClusterContainment() {
    super("openEHR-EHR-CLUSTER.anatomical_location.v1");
  }

  public static AnatomischeLokalisationClusterContainment getInstance() {
    return new AnatomischeLokalisationClusterContainment();
  }
}
