package com.richter.composition;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.ehrbase.client.classgenerator.shareddefinition.*;
import com.richter.composition.ehrbasebloodpressuresimpledev0composition.*;

public class TestGenericCompositionGeneration {

	public static void main(String[] args) throws NoSuchFieldException, Exception{

		EhrbaseBloodPressureSimpleDeV0Composition test = new EhrbaseBloodPressureSimpleDeV0Composition();
		test.setTerritory(Territory.DE);
		//test.setCategoryDefiningCode(Category.EPISODIC);
		
		Field[] fields = EhrbaseBloodPressureSimpleDeV0Composition.class.getDeclaredFields();
		
		System.out.printf("Modifier | Type-Simple-Name \t| Field-Name: %n");
		for (Field field : fields) {
			System.out.printf("%s  | %s \t\t| %s%n",
                Modifier.toString(field.getModifiers()),
                field.getType().getSimpleName(),
                field.getName()
            );
		}
		
		/*
		 * Set Fields via Reflection
		 * https://www.baeldung.com/java-set-private-field-value
		 * 
		 * Werte selbst müssen aus "dem Mapping" kommen <- Noch zu definieren
		 * Wie geht man bei Objekten in Objekten vor?
		 */

	    //Aus Mapping kommt, dass ein "bestimmter Wert" aus der CSV auf "categoryDefiningCode" gemappt wird 
		//-> Hier dann den Wert aus der CSV der Variablen aus dem OPT/POCO zuweisen, danach dann per Reflection setzen
		// 1. Get JSON-Object via Parser from Mapping-JSON-File-Directory
		// 1. Get JSON-Object of the CSV that was uploaded (Maybe store it as JSON or convert it here)
		// 2. Iterate over all items
		// 	 2.1 Store respective values of the items from the CSV in a temp variable
		//   2.2 Set the temp variable in the composition object via reflection <-- Problem: More Complex Objects need to be created before they can be added
		// See example below
		Category categoryDefiningCode = Category.EPISODIC;
		
		//Weird setting of a field within the test-object using reflection //Fields[] durchlaufen -> Rekursion bei Objekten in Objekten?
		Field nameField = test.getClass().getDeclaredField(fields[0].getName()); //fields 0 ist "categoryDefiningCode" = fields[0].getName()
		nameField.setAccessible(true);
		nameField.set(test, categoryDefiningCode); //Category is hardcoded atm -> get the category with reflection  field.getType().getSimpleName()
		
		// Category.EPISODIC === 435 fuer Asserts müssten wir JUnit einbinden
		System.out.print("Wert im Objekt: " + test.getCategoryDefiningCode().getCode() + "\n" + "Wert von Category.EPISODIC: " + Category.EPISODIC.getCode()); 
	}

}