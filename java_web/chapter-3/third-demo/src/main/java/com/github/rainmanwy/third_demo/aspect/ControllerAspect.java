package com.github.rainmanwy.third_demo.aspect;

import com.github.rainmanwy.smart.annotation.Aspect;
import com.github.rainmanwy.smart.annotation.Controller;
import com.github.rainmanwy.smart.proxy.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);
    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        LOGGER.debug("---------begin-----");
        LOGGER.debug("Class: {}", cls.getName());
        LOGGER.debug("Method: {}", method.getName());
        LOGGER.debug("Params: {}", params.toString());
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        LOGGER.debug("Result: {}", result);
        LOGGER.debug("Cost time: {}", String.format("%dms", System.currentTimeMillis() - begin));
        LOGGER.debug("---------end-----");
    }

}
