package org.ehrbase.client.classgenerator.examples.ehrbasemultioccurrencedev1composition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.Participation;
import com.nedap.archie.rm.generic.PartyIdentified;
import com.nedap.archie.rm.generic.PartyProxy;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.client.classgenerator.examples.ehrbasemultioccurrencedev1composition.definition.BodyTemperatureObservation;
import org.ehrbase.client.classgenerator.examples.shareddefinition.CategoryDefiningcode;
import org.ehrbase.client.classgenerator.examples.shareddefinition.Language;
import org.ehrbase.client.classgenerator.examples.shareddefinition.SettingDefiningcode;
import org.ehrbase.client.classgenerator.examples.shareddefinition.Territory;

import java.time.temporal.TemporalAccessor;

public class EhrbaseMultiOccurrenceDeV1CompositionContainment extends Containment {
  public SelectAqlField<EhrbaseMultiOccurrenceDeV1Composition> EHRBASE_MULTI_OCCURRENCE_DE_V1_COMPOSITION = new AqlFieldImp<EhrbaseMultiOccurrenceDeV1Composition>(EhrbaseMultiOccurrenceDeV1Composition.class, "", "EhrbaseMultiOccurrenceDeV1Composition", EhrbaseMultiOccurrenceDeV1Composition.class, this);

  public SelectAqlField<TemporalAccessor> END_TIME_VALUE = new AqlFieldImp<TemporalAccessor>(EhrbaseMultiOccurrenceDeV1Composition.class, "/context/end_time|value", "endTimeValue", TemporalAccessor.class, this);

  public ListSelectAqlField<Participation> PARTICIPATIONS = new ListAqlFieldImp<Participation>(EhrbaseMultiOccurrenceDeV1Composition.class, "/context/participations", "participations", Participation.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(EhrbaseMultiOccurrenceDeV1Composition.class, "/language", "language", Language.class, this);

  public SelectAqlField<PartyIdentified> HEALTH_CARE_FACILITY = new AqlFieldImp<PartyIdentified>(EhrbaseMultiOccurrenceDeV1Composition.class, "/context/health_care_facility", "healthCareFacility", PartyIdentified.class, this);

  public SelectAqlField<PartyProxy> COMPOSER = new AqlFieldImp<PartyProxy>(EhrbaseMultiOccurrenceDeV1Composition.class, "/composer", "composer", PartyProxy.class, this);

  public SelectAqlField<SettingDefiningcode> SETTING_DEFININGCODE = new AqlFieldImp<SettingDefiningcode>(EhrbaseMultiOccurrenceDeV1Composition.class, "/context/setting|defining_code", "settingDefiningcode", SettingDefiningcode.class, this);

  public SelectAqlField<Territory> TERRITORY = new AqlFieldImp<Territory>(EhrbaseMultiOccurrenceDeV1Composition.class, "/territory", "territory", Territory.class, this);

  public ListSelectAqlField<BodyTemperatureObservation> BODY_TEMPERATURE = new ListAqlFieldImp<BodyTemperatureObservation>(EhrbaseMultiOccurrenceDeV1Composition.class, "/content[openEHR-EHR-OBSERVATION.body_temperature.v2]", "bodyTemperature", BodyTemperatureObservation.class, this);

  public SelectAqlField<String> LOCATION = new AqlFieldImp<String>(EhrbaseMultiOccurrenceDeV1Composition.class, "/context/location", "location", String.class, this);

  public SelectAqlField<CategoryDefiningcode> CATEGORY_DEFININGCODE = new AqlFieldImp<CategoryDefiningcode>(EhrbaseMultiOccurrenceDeV1Composition.class, "/category|defining_code", "categoryDefiningcode", CategoryDefiningcode.class, this);

  public SelectAqlField<TemporalAccessor> START_TIME_VALUE = new AqlFieldImp<TemporalAccessor>(EhrbaseMultiOccurrenceDeV1Composition.class, "/context/start_time|value", "startTimeValue", TemporalAccessor.class, this);

  public ListSelectAqlField<Cluster> EXTENSION = new ListAqlFieldImp<Cluster>(EhrbaseMultiOccurrenceDeV1Composition.class, "/context/other_context[at0001]/items[at0002]", "extension", Cluster.class, this);

  private EhrbaseMultiOccurrenceDeV1CompositionContainment() {
    super("openEHR-EHR-COMPOSITION.encounter.v1");
  }

  public static EhrbaseMultiOccurrenceDeV1CompositionContainment getInstance() {
    return new EhrbaseMultiOccurrenceDeV1CompositionContainment();
  }
}
