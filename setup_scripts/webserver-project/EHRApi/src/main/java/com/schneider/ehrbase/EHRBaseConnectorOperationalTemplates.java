package com.schneider.ehrbase;

import java.io.InputStream;
import java.util.Arrays;

import org.ehrbase.test_data.operationaltemplate.OperationalTemplateTestData;

/**
 * Enum to make OPT files accessible
 * 
 * @see <a
 *      href="EHR SDK Docs">https://ehrbase.readthedocs.io/en/latest/04_sdk/02_reference/01_client_module/01_client/index.html#template-provider</a>
 */
public enum EHRBaseConnectorOperationalTemplates {
	
	// zum Testen erstmal nur das simple BP template + generierte Klasse in den EHRBaseConnector gezogen
	BLOOD_PRESSURE_SIMPLE(
			"Very simple blood_pressure template",
			"ehrbase_blood_pressure_simple.de.v0.opt",
			"ehrbase_blood_pressure_simple.de.v0");

	private final String description;
	private final String filename;
	private final String templateId;

	EHRBaseConnectorOperationalTemplates(String description, String filename, String templateId) {
		this.filename = filename;
		this.description = description;
		this.templateId = templateId;
	}

	public InputStream getStream() {
		return getClass().getResourceAsStream("/operationaltemplate/" + filename);
	}

	public static EHRBaseConnectorOperationalTemplates findByTemplateId(String templateId) {
		return Arrays.stream(EHRBaseConnectorOperationalTemplates.values())
				.filter(o -> o.getTemplateId().equals(templateId)).findAny().orElse(null);
	}

	public String getTemplateId() {
		return templateId;
	}

}
