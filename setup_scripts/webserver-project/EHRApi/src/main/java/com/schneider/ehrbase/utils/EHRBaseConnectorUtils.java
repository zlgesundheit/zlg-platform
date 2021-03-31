package com.schneider.ehrbase.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.schneider.restendpoint.data.defines.EHRBaseConnectorDefines;

/**
 * Class containing helpful methods
 * 
 * @author schneider
 *
 */
public class EHRBaseConnectorUtils {

	/**
	 * Returns a desired getter or setter from a class
	 * 
	 * @param variableName
	 * @param aClass
	 * @param getterOrSetter
	 * @return
	 */
	public static Method getMethod(String variableName, Class aClass, String getterOrSetter) {

		Method[] declaredMethods = aClass.getDeclaredMethods();
		for (Method method : declaredMethods) {
			if (getterOrSetter.equalsIgnoreCase(EHRBaseConnectorDefines.METHOD_GETTER)) {
				if (isGetter(method) && method.getName().toUpperCase().contains(variableName.toUpperCase())) {
					return method;
				}
			}
			if (getterOrSetter.equalsIgnoreCase(EHRBaseConnectorDefines.METHOD_GETTER)) {
				if (isSetter(method) && method.getName().toUpperCase().contains(variableName.toUpperCase())) {
					return method;
				}
			}
		}
		return null;
	}

	private static boolean isGetter(Method method) {
		// check for getter methods
		if ((method.getName().startsWith("get") || method.getName().startsWith("is")) && method.getParameterCount() == 0
				&& !method.getReturnType().equals(void.class)) {
			return true;
		}
		return false;
	}

	private static boolean isSetter(Method method) {
		// check for setter methods
		if (method.getName().startsWith("set") && method.getParameterCount() == 1
				&& method.getReturnType().equals(void.class)) {
			return true;
		}
		return false;
	}

	public static void invokeSetter(Object obj, Object variableValue, Method setter) {
		try {
			setter.invoke(obj, variableValue);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	public static void invokeGetter(Object obj, Method getter) {
		try {
			Object f = getter.invoke(obj);
			System.out.println(f);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
