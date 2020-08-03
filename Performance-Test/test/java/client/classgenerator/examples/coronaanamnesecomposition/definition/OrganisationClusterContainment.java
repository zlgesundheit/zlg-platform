package org.ehrbase.client.classgenerator.examples.coronaanamnesecomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;

public class OrganisationClusterContainment extends Containment {
  public SelectAqlField<OrganisationCluster> ORGANISATION_CLUSTER = new AqlFieldImp<OrganisationCluster>(OrganisationCluster.class, "", "OrganisationCluster", OrganisationCluster.class, this);

  public SelectAqlField<String> NAME_VALUE = new AqlFieldImp<String>(OrganisationCluster.class, "/items[at0012]/name|value", "nameValue", String.class, this);

  public ListSelectAqlField<Cluster> TELEFON = new ListAqlFieldImp<Cluster>(OrganisationCluster.class, "/items[at0014]", "telefon", Cluster.class, this);

  public SelectAqlField<String> NAME_VALUE_VALUE = new AqlFieldImp<String>(OrganisationCluster.class, "/items[at0012]/value|value", "nameValueValue", String.class, this);

  public ListSelectAqlField<Cluster> TEIL_VON = new ListAqlFieldImp<Cluster>(OrganisationCluster.class, "/items[at0017]", "teilVon", Cluster.class, this);

  public ListSelectAqlField<Cluster> KONTAKT = new ListAqlFieldImp<Cluster>(OrganisationCluster.class, "/items[at0016]", "kontakt", Cluster.class, this);

  public ListSelectAqlField<AdresseCluster> ADRESSE = new ListAqlFieldImp<AdresseCluster>(OrganisationCluster.class, "/items[openEHR-EHR-CLUSTER.address_cc.v0]", "adresse", AdresseCluster.class, this);

  public ListSelectAqlField<Cluster> IDENTIFIER = new ListAqlFieldImp<Cluster>(OrganisationCluster.class, "/items[at0018]", "identifier", Cluster.class, this);

  private OrganisationClusterContainment() {
    super("openEHR-EHR-CLUSTER.organisation_cc.v0");
  }

  public static OrganisationClusterContainment getInstance() {
    return new OrganisationClusterContainment();
  }
}
