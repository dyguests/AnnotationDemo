package com.fanhl.annotation;

import java.lang.reflect.Field;

/**
 * desc:
 * date: 2017/8/4
 *
 * @author fanhl
 */
public class CacheProvider {
    public static void bind(Object object) {
        Field fields[] = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Cache.class)) {
                Cache cache = field.getAnnotation(Cache.class);
                try {
                    field.set(object,cache.value());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
