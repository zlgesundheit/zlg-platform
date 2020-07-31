package test.orbdasetv2composition.definition;

import com.nedap.archie.rm.generic.PartyProxy;
import java.lang.Double;
import java.lang.String;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.SelectAqlField;
import test.shareddefinition.Language;

public class HeartrateM3ObservationContainment extends Containment {
  public SelectAqlField<HeartrateM3Observation> HEARTRATE_M3_OBSERVATION = new AqlFieldImp<HeartrateM3Observation>(HeartrateM3Observation.class, "", "HeartrateM3Observation", HeartrateM3Observation.class, this);

  public SelectAqlField<Double> HEART_RATE_MAGNITUDE = new AqlFieldImp<Double>(HeartrateM3Observation.class, "/data[at0001]/events[at0002]/data[at0003]/items[at0004]/items[at0006]/value|magnitude", "heartRateMagnitude", Double.class, this);

  public SelectAqlField<String> HEART_RATE_UNITS = new AqlFieldImp<String>(HeartrateM3Observation.class, "/data[at0001]/events[at0002]/data[at0003]/items[at0004]/items[at0006]/value|units", "heartRateUnits", String.class, this);

  public SelectAqlField<TemporalAccessor> TIME_VALUE = new AqlFieldImp<TemporalAccessor>(HeartrateM3Observation.class, "/data[at0001]/events[at0002]/time|value", "timeValue", TemporalAccessor.class, this);

  public SelectAqlField<PartyProxy> SUBJECT = new AqlFieldImp<PartyProxy>(HeartrateM3Observation.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<TemporalAccessor> ORIGIN_VALUE = new AqlFieldImp<TemporalAccessor>(HeartrateM3Observation.class, "/data[at0001]/origin|value", "originValue", TemporalAccessor.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(HeartrateM3Observation.class, "/language", "language", Language.class, this);

  private HeartrateM3ObservationContainment() {
    super("openEHR-EHR-OBSERVATION.heartrate_m3.v0");
  }

  public static HeartrateM3ObservationContainment getInstance() {
    return new HeartrateM3ObservationContainment();
  }
}
