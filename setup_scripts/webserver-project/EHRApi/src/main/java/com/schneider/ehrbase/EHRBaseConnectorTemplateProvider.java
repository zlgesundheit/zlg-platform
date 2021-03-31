package com.schneider.ehrbase;

import java.io.IOException;
import java.util.Optional;

import org.apache.xmlbeans.XmlException;
import org.ehrbase.test_data.operationaltemplate.OperationalTemplateTestData;
import org.ehrbase.webtemplate.templateprovider.TemplateProvider;
import org.openehr.schemas.v1.OPERATIONALTEMPLATE;
import org.openehr.schemas.v1.TemplateDocument;

/**
 * 
 * @author schneider Custom TemplateProvider implementation to give the SDK
 *         access to the templates used.
 *
 * @see <a
 *      href="EHR SDK Docs">https://ehrbase.readthedocs.io/en/latest/04_sdk/02_reference/01_client_module/01_client/index.html#template-provider</a>
 *
 */
public class EHRBaseConnectorTemplateProvider implements TemplateProvider {

	// TODO evtl nicht ueber enum sondern aus der Template-REST schnittstelle laden
	// ? Sonst muss enum immer
	// haendisch erweitert werden -> unschoen
	
	// aktuell enthaelt das Enum nur simple BP (da dies auch die einzigen erzeugten
	// Klassen sind, die aus dem SDK rueber kopiert wurden)
	@Override
	public Optional<OPERATIONALTEMPLATE> find(String templateId) {
		// aus den SDK docs kopiert und angepasst
		return Optional.ofNullable(EHRBaseConnectorOperationalTemplates.findByTemplateId(templateId))
				.map(EHRBaseConnectorOperationalTemplates::getStream).map(s -> {
					try {
						return TemplateDocument.Factory.parse(s);
					} catch (XmlException | IOException e) {
						throw new RuntimeException(e.getMessage(), e);
					}
				}).map(TemplateDocument::getTemplate);
	}

}
