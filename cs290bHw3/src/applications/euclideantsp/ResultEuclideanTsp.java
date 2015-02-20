/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package applications.euclideantsp;

import system.Return;
import java.util.List;

/**
 *
 * @author Peter Cappello
 */
public class ResultEuclideanTsp extends Return<List<Integer>>
{

    /**
     * Return container for TaskEuclideanTsp.
     * @param taskReturnValue
     * @param taskRunTime
     */
    public ResultEuclideanTsp( List<Integer> taskReturnValue, long taskRunTime) 
    {
        super(taskReturnValue, taskRunTime);
    } 
}
