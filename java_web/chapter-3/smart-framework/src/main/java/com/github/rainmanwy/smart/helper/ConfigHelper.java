package com.github.rainmanwy.smart.helper;

import com.github.rainmanwy.smart.constants.ConfigConstants;
import com.github.rainmanwy.smart.util.PropsUtil;

import java.util.Properties;

public class ConfigHelper {

    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstants.CONFIG_FILE);

    public static String getJdbcDriver() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstants.JDBC_DRIVER);
    }

    public static String getJdbcUrl() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstants.JDBC_URL);
    }

    public static String getJdbcUsername() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstants.JDBC_USERNAME);
    }

    public static String getJdbcPassword() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstants.JDBC_PASSWORD);
    }

    public static String getBasePackage() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstants.APP_BASE_PACKAGE);
    }

    public static String getJspPath() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstants.APP_JSP_PATH);
    }

    public static String getAssetPath() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstants.APP_ASSET_PATH);
    }

}
