package com.schneider.ehrbase;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.openehrclient.OpenEhrClientConfig;
import org.ehrbase.client.openehrclient.defaultrestclient.DefaultRestClient;
import org.ehrbase.webtemplate.templateprovider.TemplateProvider;

import com.schneider.ehrbase.utils.EHRBaseConnectorUtils;
import com.schneider.restendpoint.data.defines.EHRBaseConnectorDefines;
import com.schneider.restendpoint.data.ehrbasebloodpressuresimpledev0composition.EhrbaseBloodPressureSimpleDeV0Composition;

/**
 * {@link ServletContextListener} Class that is being called on server startup.
 * Used to intitialize client & template provider (and other stuff that has to
 * be done before the REST endpoint should be used)
 * 
 * @author schneider
 *
 */
public class EHRBaseConnectorInit implements ServletContextListener {

	private TemplateProvider templateProvider;
	public static DefaultRestClient client;

	// Zu castender Testwert
	@Path("/context/location")
	public String testValue = "test";

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		// initRestClient();

		/* TESTING ONLY no clean programming can be found */

		try {
			fillBPtest();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* TESTING ONLY no clean programming can be found */

	}

	/**
	 * methode zum testen des fuellens eines
	 * {@link EhrbaseBloodPressureSimpleDeV0Composition} objekts ueber die
	 * path-annotations
	 * 
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	private void fillBPtest() throws NoSuchFieldException, SecurityException {

		EhrbaseBloodPressureSimpleDeV0Composition testComp = new EhrbaseBloodPressureSimpleDeV0Composition();

		// Felder der Klasse
		Field[] fields = testComp.getClass().getDeclaredFields();

		// Annoations des jeweiligen felds
		List<Annotation> annots;

		// Path des testValues (muesste dann zu jedem feld in erzeugtem objekt
		// hinzugefuegt werden (??) )
		// TODO ist das umsetzbar?
		Field[] classFields = this.getClass().getFields();
		System.out.println(Arrays.toString(classFields));
		Annotation testPath = this.getClass().getFields()[1].getAnnotations()[0];
		System.out.println(testPath);

		// durch alle felder gehen
		for (Field field : fields) {

			// annots des felds holen (ist nur eins und zwar @Path)
			annots = Arrays.asList(field.getAnnotations());
			System.out.println(annots.toString());

			// gucken ob das feld mit der @Path annot das gesuchte ist (in diesem Fall
			// einfach "/context/location")
			// TODO: geht das so?? -> JA
			if (annots.contains(testPath)) {

				// gucken ob man die location setzen kann durch die annotation
				// an der Stelle muesste eig ein vorbereitetes Objekt sein, da wir ja
				// wissen, welche Werte in das Objekt kommen - dann funktioniert der
				// cast vermutlich auch
				field.getType().cast(testValue);
				
				// Wert setzen ueber reflection
				Method methodLocation = EHRBaseConnectorUtils.getMethod("location", testComp.getClass(),
						EHRBaseConnectorDefines.METHOD_SETTER);
				EHRBaseConnectorUtils.invokeSetter(testComp, testValue, methodLocation);
			}
		}
	}

	/**
	 * Method to initialize the Rest Client - uses the SDK's
	 * {@link DefaultRestClient} atm
	 */
	private void initRestClient() {

		templateProvider = new EHRBaseConnectorTemplateProvider();
		try {
			client = new DefaultRestClient(
					new OpenEhrClientConfig(new URI("http://localhost/ehrbase/rest/openehr/v1/")), templateProvider);

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

//	public void uploadTemplate() {
//		
//		OPERATIONALTEMPLATE template = null;
//		try {
//			template = (OPERATIONALTEMPLATE) TemplateDocument.Factory
//					.parse(OperationalTemplateTestData.BLOOD_PRESSURE_SIMPLE.getStream()).getTemplate();
//		} catch (XmlException | IOException e) {
//			e.printStackTrace();
//		}
//		String templateId = "ehrbase_blood_pressure_simple.de.v" + RandomStringUtils.randomNumeric(10);
//		template.getTemplateId().setValue(templateId);
//		//String actual = new DefaultRestTemplateEndpoint(client).upload(template);
//
//	}

}
