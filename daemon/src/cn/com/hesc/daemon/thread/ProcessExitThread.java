package cn.com.hesc.daemon.thread;

import cn.com.hesc.daemon.MyProcess;
import cn.com.hesc.daemon.util.PropertyUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;


/**
 * Created with IntelliJ IDEA.
 * User: louyh
 * Date: 16-3-18
 * Time: 下午3:03
 * To change this template use File | Settings | File Templates.
 */
public class ProcessExitThread extends ProcessThread
{
    private static Logger logger = Logger.getLogger(ProcessExitThread.class);

    public ProcessExitThread(String name,MyProcess myProcess)
    {
        super(name,myProcess);
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                int result = process.getProcess().waitFor();
                if(result == 0)
                {
                    logger.info(threadName + ":程序正常终止");
                }
                else
                {
                    logger.info(threadName + ":程序异常终止");
                }
                if(!reOpen())
                {
                    setIsOpen(false);
                    return;
                }

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

    }

    private boolean reOpen()
    {
        Properties properties = PropertyUtils.getConfigProperties();
        String isAutoOpen = properties.getProperty("isAutoOpen");
        if("1".equals(isAutoOpen))
        {
            try
            {
                process.setProcess(Runtime.getRuntime().exec("cmd /c start " + process.getProgramPath()));
                return true;
            }
            catch (IOException e)
            {
                logger.error(e);
                System.out.println(process.getProgramName() + "重启失败");
            }
        }
        return false;
    }
}
