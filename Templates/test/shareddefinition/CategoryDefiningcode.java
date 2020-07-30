package test.m3.test.shareddefinition;

import java.lang.String;
import org.ehrbase.client.classgenerator.EnumValueSet;

public enum CategoryDefiningcode implements EnumValueSet {
  PERSISTENT("persistent", "persistent", "openehr", "431"),

  EVENT("event", "event", "openehr", "433"),

  EPISODIC("episodic", "episodic", "openehr", "435");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  CategoryDefiningcode(String value, String description, String terminologyId, String code) {
    this.value = value;
    this.description = description;
    this.terminologyId = terminologyId;
    this.code = code;
  }

  public String getValue() {
     return this.value ;
  }

  public String getDescription() {
     return this.description ;
  }

  public String getTerminologyId() {
     return this.terminologyId ;
  }

  public String getCode() {
     return this.code ;
  }
}
