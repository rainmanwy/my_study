package com.github.rainmanwy.smart.helper;

import com.github.rainmanwy.smart.annotation.Inject;
import com.github.rainmanwy.smart.util.CollectionUtil;
import com.github.rainmanwy.smart.util.ReflectionUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.Map;

public final class IocHelper {

    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            for (Map.Entry<Class<?>, Object> entry : beanMap.entrySet()) {
                Class<?> beanClass = entry.getKey();
                Object beanInstance = entry.getValue();

                Field[] fields = beanClass.getDeclaredFields();
                if (ArrayUtils.isNotEmpty(fields)) {
                    for (Field field : fields) {
                        if (field.isAnnotationPresent(Inject.class)) {
                            Class<?> beanFieldClass = field.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                ReflectionUtil.setField(beanInstance, field, beanFieldInstance);
                            }

                        }
                    }
                }

            }
        }
    }

}
