package cn.com.hesc.daemon.thread;

import cn.com.hesc.daemon.MyProcess;

/**
 * Created with IntelliJ IDEA.
 * User: louyh
 * Date: 16-3-18
 * Time: ÏÂÎç2:57
 * To change this template use File | Settings | File Templates.
 */
public abstract class ProcessThread implements Runnable
{
    protected String threadName = "";
    protected MyProcess process = null;


    protected Boolean isOpen;

    public ProcessThread(String name,MyProcess process)
    {
        threadName = name;
        this.process = process;
    }

    public void setIsOpen(Boolean isOpen)
    {
        this.isOpen = isOpen;
    }

    public boolean getIsOpen()
    {
        return isOpen;
    }

    @Override
    public void run()
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
