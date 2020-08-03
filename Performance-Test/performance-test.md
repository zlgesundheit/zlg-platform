# openEHR - Performance Tests

1. Measure time for the creation of 100.000 EHRs with 1 Composition per EHR
2. Load Balance with multiple servers in front of the same DB 
3. Measure time with an other openEHR-Server-Solution in the back

### Environment

Maybe this should be run on a server to measure better performance times

### How

- Use test.m3 - package to generate EHRs and Compositions (JAVA)

- Time measured via System.nanoTime();

```Java
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
}
```

