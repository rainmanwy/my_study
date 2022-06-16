package com.github.rainmanwy.smart;

import com.github.rainmanwy.smart.helper.*;
import com.github.rainmanwy.smart.util.ClassUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class HelperLoader {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelperLoader.class);

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for(Class<?> cls : classList) {
            LOGGER.debug("SF HelperLoader load: {}", cls.getName());
            ClassUtil.loadClass(cls.getName(), true);
        }
    }

    public static void main(String[] args) {
        init();
    }
}
