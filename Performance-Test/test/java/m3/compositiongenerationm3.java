package test.m3;

import com.nedap.archie.rm.datavalues.DvText;
import com.nedap.archie.rm.generic.Participation;
import com.nedap.archie.rm.generic.PartyIdentified;
import org.ehrbase.client.openehrclient.CompositionEndpoint;
import org.ehrbase.client.openehrclient.defaultrestclient.DefaultRestClientTestHelper;
import test.m3.test.orbdasetv2composition.ORBDAsetV2Composition;
import test.m3.test.orbdasetv2composition.definition.BloodpressureM3Observation;
import test.m3.test.orbdasetv2composition.definition.DiagnosisM3Evaluation;
import test.m3.test.orbdasetv2composition.definition.HeartrateM3Observation;
import test.m3.test.orbdasetv2composition.definition.VitalsignsM3Section;
import test.m3.test.shareddefinition.CategoryDefiningcode;
import test.m3.test.shareddefinition.Language;
import test.m3.test.shareddefinition.SettingDefiningcode;
import test.m3.test.shareddefinition.Territory;

import org.ehrbase.client.openehrclient.OpenEhrClient;

import java.net.URISyntaxException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.UUID;

public class compositiongenerationm3 {

    private static OpenEhrClient openEhrClient;

    public static void main(String[] args) throws URISyntaxException{
        // Setup EhrClient before
        openEhrClient = DefaultRestClientTestHelper.setupDefaultRestClient();

        // //TIME START
        long startTime = System.nanoTime();

        for (int i=0;i<=100000;i++) {
            // Create EHR
            UUID ehr = openEhrClient.ehrEndpoint().createEhr();
                //ehr = UUID.fromString("c98cd25a-a66c-4485-a641-cb4790e4c2a9");
                // System.out.println(ehr.toString());
            ORBDAsetV2Composition myComposition = buildCompositionExample();
            sendIt(ehr, myComposition);
        }

        long endTime = System.nanoTime();
        // //TIME END
        long timeElapsed = endTime - startTime;

        System.out.println("Execution time in milliseconds : " + timeElapsed / 1000000);
        //System.out.println("Execution time in seconds : " + timeElapsed / 1000000 / 1000);
    }

    public static void sendIt(UUID ehr,ORBDAsetV2Composition myComposition) {
        CompositionEndpoint compositionEndpoint = openEhrClient.compositionEndpoint(ehr);
        openEhrClient.compositionEndpoint(ehr).mergeCompositionEntity(myComposition);
    }

    public static ORBDAsetV2Composition buildCompositionExample() {
        ORBDAsetV2Composition set = new ORBDAsetV2Composition();
        OffsetDateTime startTime = OffsetDateTime.of(2019, 9, 10, 12, 0, 0, 0, ZoneOffset.ofHours(2));
        set.setStartTimeValue(startTime);
        set.setStartTimeValue(OffsetDateTime.of(2019, 04, 03, 22, 00, 00, 00, ZoneOffset.UTC));
        set.setEndTimeValue(OffsetDateTime.now());
        set.setVitalsignsM3(new ArrayList<>());
        set.setDiagnosisM3(new ArrayList<>());
        set.setLanguage(Language.DE);
        set.setTerritory(Territory.DE);
        set.setCategoryDefiningcode(CategoryDefiningcode.EVENT);
        set.setSettingDefiningcode(SettingDefiningcode.NURSINGHOMECARE);
        set.setComposer(new PartyIdentified(null, "Test", null));
        set.setParticipations(new ArrayList<>());
        set.getParticipations().add(new Participation(new PartyIdentified(null, "Test", null), new DvText("Pos1"), null, null));
        set.getParticipations().add(new Participation(new PartyIdentified(null, "Test2", null), new DvText("Pos2"), null, null));

        //Popularize the vitalsignssection and set a diagnosis
        set.getVitalsignsM3().add(fillExampleVitalSigns());
        set.getDiagnosisM3().add(fillExampleDiagnosis());

        return set;
    }

    protected static VitalsignsM3Section fillExampleVitalSigns() {
        VitalsignsM3Section section = new VitalsignsM3Section();
        section.setBloodpressureM3(new ArrayList<>());
        section.setHeartrateM3(new ArrayList<>());
        section.getBloodpressureM3().add(fillExampleBP());
        section.getHeartrateM3().add(fillExampleHR());
        return section;
    }

    protected static BloodpressureM3Observation fillExampleBP() {
        BloodpressureM3Observation bp = new BloodpressureM3Observation();
        bp.setSubject(new PartyIdentified(null, "Test", null));
        bp.setOriginValue(OffsetDateTime.now());
        bp.setTimeValue(OffsetDateTime.now());
        bp.setLanguage(Language.DE);
        bp.setSystolicBloodPressureMagnitude(22d);
        bp.setSystolicBloodPressureUnits("mm[Hg]");
        bp.setDiastolicBloodPressureMagnitude(22d);
        bp.setDiastolicBloodPressureUnits("mm[Hg]");
        return bp;
    }

    protected static HeartrateM3Observation fillExampleHR() {
        HeartrateM3Observation hr = new HeartrateM3Observation();
        hr.setSubject(new PartyIdentified(null, "Test", null));
        hr.setLanguage(Language.DE);
        hr.setTimeValue(OffsetDateTime.now());
        hr.setOriginValue(OffsetDateTime.now());
        hr.setHeartRateMagnitude(120.0);
        hr.setHeartRateUnits("1/min");
        return hr;
    }

    protected static DiagnosisM3Evaluation fillExampleDiagnosis() {
        DiagnosisM3Evaluation di = new DiagnosisM3Evaluation();
        di.setSubject(new PartyIdentified(null, "Test", null));
        di.setLanguage(Language.DE);
        di.setDiagnosisValue("Das ist kein Bluthochdruck");
        return di;
    }

}
