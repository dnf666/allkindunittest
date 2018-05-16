package example.privatemethod.demo;


import java.lang.reflect.Method;

public class Util {

    public static Method getMethod(Class<?> clazz, String methodName,
                                   final Class<?>[] classes) throws Exception {
        Method method = null;
        try {
            method = clazz.getDeclaredMethod(methodName, classes);
        } catch (NoSuchMethodException e) {
            try {
                method = clazz.getMethod(methodName, classes);
            } catch (NoSuchMethodException ex) {
                if (clazz.getSuperclass() == null) {
                    return method;
                } else {
                    method = getMethod(clazz.getSuperclass(), methodName,
                            classes);
                }
            }
        }
        return method;
    }

    public static Object invoke(final Object obj, final String methodName,
                                final Class<?>[] classes, final Object[] objects) throws Exception {
        Method method = getMethod(obj.getClass(), methodName, classes);
        method.setAccessible(true);
        return method.invoke(obj, objects);
    }

}
