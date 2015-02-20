/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package applications.mandelbrotset;

import system.Return;

/**
 * Return container for TaskMandelbrotSet.
 * @author peter
 */
public class ResultMandelbrotSet extends Return<ResultValueMandelbrotSet>
{
    public ResultMandelbrotSet( ResultValueMandelbrotSet taskReturnValue, long taskRunTime ) 
    {
        super(taskReturnValue, taskRunTime);
    }
}
