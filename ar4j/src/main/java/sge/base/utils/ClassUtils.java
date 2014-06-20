package sge.base.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class ClassUtils {
	static public Method getStaticMethod(Class<?> type, String methodName,
			Class<?>... params) {
		try {
			Method method = type.getDeclaredMethod(methodName, params);
			if ((method.getModifiers() & Modifier.STATIC) != 0) {
				return method;
			}
		} catch (NoSuchMethodException e) {
		}
		return null;
	}
}
