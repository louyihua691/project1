package cn.com.hesc.daemon.util;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: louyh
 * Date: 16-3-21
 * Time: ÉÏÎç9:02
 * To change this template use File | Settings | File Templates.
 */
public class PropertyUtils
{
    private static final String filePath = "/file/file.properties";
    private static final String configPath = "/file/config.properties";

    private static Logger logger = Logger.getLogger(PropertyUtils.class);

    private static Properties configProperties = new Properties();

    private static Properties fileProperties = new Properties();

    private static void configInit()
    {
        try
        {
            InputStream inputStream = new FileInputStream(configPath);
            configProperties.load(inputStream);
        }
        catch (Exception e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            logger.error(e);
            System.exit(1);
        }
    }

    private static void fileInit()
    {
        try
        {
            InputStream inputStream = new FileInputStream(filePath);
            fileProperties.load(inputStream);
        }
        catch (Exception e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            logger.error(e);
            System.exit(1);
        }
    }

    public static Properties getConfigProperties()
    {
        return configProperties;
    }

    public static Properties getFileProperties()
    {
        return fileProperties;
    }

    public void saveFileProperties(Properties properties)
    {
        try
        {
            OutputStream fileOutputStream = new FileOutputStream(filePath);
            properties.store(fileOutputStream,"");
        }
        catch (Exception e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            logger.error(e);
        }

    }
}
