package com.github.rainmanwy.smart.helper;

import com.github.rainmanwy.smart.annotation.Action;
import com.github.rainmanwy.smart.bean.Handler;
import com.github.rainmanwy.smart.bean.Request;
import com.github.rainmanwy.smart.util.CollectionUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class ControllerHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerHelper.class);
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            for(Class<?> controllerClass : controllerClassSet) {
                Method[] methods = controllerClass.getDeclaredMethods();
                if(ArrayUtils.isNotEmpty(methods)) {
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(Action.class)) {
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            LOGGER.info("mapping: {}, matched: {}", action.value(), mapping.matches("\\w+:/\\w*"));
                            if (mapping.matches("\\w+:/\\w*")) {
                                String[] array = mapping.split(":");
                                LOGGER.info("ControllerHelper: get actions, {}", array);
                                if (ArrayUtils.isNotEmpty(array) && array.length == 2) {
                                    // 获取请求方法与请求路径
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(controllerClass, method);
                                    // 初始化 Action Map
                                    ACTION_MAP.put(request, handler);
                                }
                            }
                        }
                    }
                }
            }
        }
        LOGGER.info("ControllerHelper: {}", ACTION_MAP);
    }

    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }
}
