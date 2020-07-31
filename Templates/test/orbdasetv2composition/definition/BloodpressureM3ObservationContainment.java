package test.orbdasetv2composition.definition;

import com.nedap.archie.rm.generic.PartyProxy;
import java.lang.Double;
import java.lang.String;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.SelectAqlField;
import test.shareddefinition.Language;

public class BloodpressureM3ObservationContainment extends Containment {
  public SelectAqlField<BloodpressureM3Observation> BLOODPRESSURE_M3_OBSERVATION = new AqlFieldImp<BloodpressureM3Observation>(BloodpressureM3Observation.class, "", "BloodpressureM3Observation", BloodpressureM3Observation.class, this);

  public SelectAqlField<TemporalAccessor> TIME_VALUE = new AqlFieldImp<TemporalAccessor>(BloodpressureM3Observation.class, "/data[at0001]/events[at0002]/time|value", "timeValue", TemporalAccessor.class, this);

  public SelectAqlField<Double> DIASTOLIC_BLOOD_PRESSURE_MAGNITUDE = new AqlFieldImp<Double>(BloodpressureM3Observation.class, "/data[at0001]/events[at0002]/data[at0003]/items[at0012]/items[at0010]/value|magnitude", "diastolicBloodPressureMagnitude", Double.class, this);

  public SelectAqlField<String> DIASTOLIC_BLOOD_PRESSURE_UNITS = new AqlFieldImp<String>(BloodpressureM3Observation.class, "/data[at0001]/events[at0002]/data[at0003]/items[at0012]/items[at0010]/value|units", "diastolicBloodPressureUnits", String.class, this);

  public SelectAqlField<PartyProxy> SUBJECT = new AqlFieldImp<PartyProxy>(BloodpressureM3Observation.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<TemporalAccessor> ORIGIN_VALUE = new AqlFieldImp<TemporalAccessor>(BloodpressureM3Observation.class, "/data[at0001]/origin|value", "originValue", TemporalAccessor.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(BloodpressureM3Observation.class, "/language", "language", Language.class, this);

  public SelectAqlField<Double> SYSTOLIC_BLOOD_PRESSURE_MAGNITUDE = new AqlFieldImp<Double>(BloodpressureM3Observation.class, "/data[at0001]/events[at0002]/data[at0003]/items[at0012]/items[at0009]/value|magnitude", "systolicBloodPressureMagnitude", Double.class, this);

  public SelectAqlField<String> SYSTOLIC_BLOOD_PRESSURE_UNITS = new AqlFieldImp<String>(BloodpressureM3Observation.class, "/data[at0001]/events[at0002]/data[at0003]/items[at0012]/items[at0009]/value|units", "systolicBloodPressureUnits", String.class, this);

  private BloodpressureM3ObservationContainment() {
    super("openEHR-EHR-OBSERVATION.bloodpressure_m3.v0");
  }

  public static BloodpressureM3ObservationContainment getInstance() {
    return new BloodpressureM3ObservationContainment();
  }
}
