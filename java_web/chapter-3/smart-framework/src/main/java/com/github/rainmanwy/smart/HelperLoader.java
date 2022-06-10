package com.github.rainmanwy.smart;

import com.github.rainmanwy.smart.helper.BeanHelper;
import com.github.rainmanwy.smart.helper.ClassHelper;
import com.github.rainmanwy.smart.helper.ControllerHelper;
import com.github.rainmanwy.smart.helper.IocHelper;
import com.github.rainmanwy.smart.util.ClassUtil;

public final class HelperLoader {
    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for(Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(), true);
        }
    }

    public static void main(String[] args) {
        init();
    }
}
