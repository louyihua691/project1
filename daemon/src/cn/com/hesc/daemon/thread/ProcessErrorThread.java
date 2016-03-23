package cn.com.hesc.daemon.thread;

import cn.com.hesc.daemon.MyProcess;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: louyh
 * Date: 16-3-18
 * Time: 下午3:03
 * To change this template use File | Settings | File Templates.
 */
public class ProcessErrorThread extends ProcessThread
{
    private static Logger logger = Logger.getLogger(ProcessExitThread.class);

    public ProcessErrorThread(String name,MyProcess myProcess)
    {
        super(name,myProcess);
    }

    public void run()
    {
        InputStream inputStream = process.getProcess().getErrorStream();
        while (true)
        {
            if(!getIsOpen())
                return;
            try
            {
                if(inputStream.available() > 0)
                {
                    byte[] bytes = new byte[inputStream.available()];
                    inputStream.read(bytes);
                    logger.info(threadName + ":程序发生异常-----" + new String(bytes));
                    bytes = null;
                }
                Thread.sleep(1000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                if(inputStream != null)
                {
                    try
                    {
                        inputStream.close();
                    }
                    catch (IOException e)
                    {
//                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                    finally
                    {
                        if(process.getProcess() != null)
                            inputStream = process.getProcess().getErrorStream();
                    }
                }
            }
        }

    }
}
