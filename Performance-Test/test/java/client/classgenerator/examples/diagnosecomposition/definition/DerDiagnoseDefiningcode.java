package org.ehrbase.client.classgenerator.examples.diagnosecomposition.definition;

import org.ehrbase.client.classgenerator.EnumValueSet;

public enum DerDiagnoseDefiningcode implements EnumValueSet {
  COVID19_VIRUS_NICHT_NACHGEWIESEN("COVID-19, Virus nicht nachgewiesen", null, "ICD-10-GM-2020", "U07.2"),

  KORONAVIREN_ALS_URSACHE_VON_KRANKHEITEN_DIE_IN_ANDEREN_KAPITELN_KLASSIFIZIERT_SIND("Koronaviren als Ursache von Krankheiten, die in anderen Kapiteln klassifiziert sind", null, "ICD-10-GM-2020", "B97.2"),

  INFEKTION_DURCH_KORONAVIREN_NICHT_NAHER_BEZEICHNETER_LOKALISATION("Infektion durch Koronaviren nicht näher bezeichneter Lokalisation", null, "ICD-10-GM-2020", "B34.2"),

  COVID19_VIRUS_NACHGEWIESEN("COVID-19, Virus nachgewiesen", null, "ICD-10-GM-2020", "U07.1");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  DerDiagnoseDefiningcode(String value, String description, String terminologyId, String code) {
    this.value = value;
    this.description = description;
    this.terminologyId = terminologyId;
    this.code = code;
  }

  public String getValue() {
    return this.value;
  }

  public String getDescription() {
    return this.description;
  }

  public String getTerminologyId() {
    return this.terminologyId;
  }

  public String getCode() {
    return this.code;
  }
}
