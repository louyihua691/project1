package cn.com.hesc.daemon;

/**
 * Created with IntelliJ IDEA.
 * User: louyh
 * Date: 16-3-21
 * Time: 上午10:03
 * To change this template use File | Settings | File Templates.
 */
public class MyProcess
{
    //程序标识符
    String programKey;

    Process process;

    //程序名称
    String programName;

    //程序启动路径
    String programPath;

    public MyProcess(String programKey, Process process, String programName, String programPath)
    {
        this.programKey = programKey;
        this.process = process;
        this.programName = programName;
        this.programPath = programPath;
    }

    public String getProgramKey()
    {
        return programKey;
    }

    public void setProgramKey(String programKey)
    {
        this.programKey = programKey;
    }

    public Process getProcess()
    {
        return process;
    }

    public void setProcess(Process process)
    {
        this.process = process;
    }

    public String getProgramName()
    {
        return programName;
    }

    public void setProgramName(String programName)
    {
        this.programName = programName;
    }

    public String getProgramPath()
    {
        return programPath;
    }

    public void setProgramPath(String programPath)
    {
        this.programPath = programPath;
    }
}
