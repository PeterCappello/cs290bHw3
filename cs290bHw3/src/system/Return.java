package system;

import api.Task;
import java.io.Serializable;
import system.SpaceImpl;

/**
 *
 * @author Peter Cappello
 */
abstract public class Return implements Serializable
{
    private long taskRunTime;

    public long taskRunTime() { return taskRunTime; }
    public void taskRunTime( long taskRunTime ) { this.taskRunTime = taskRunTime; }
    
    /**
     *
     * @param task the task whose Result is to be processed.
     * @param space the receiving the Temp objects.
     */
    abstract public void process( Task task, SpaceImpl space );
    
    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( getClass() );
        stringBuilder.append( "\n\tExecution time:\t" ).append( taskRunTime );
        return stringBuilder.toString();
    }
}
