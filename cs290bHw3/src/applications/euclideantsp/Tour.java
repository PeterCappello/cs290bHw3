/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package applications.euclideantsp;

import api.Task;
import system.Return;
import java.util.List;
import system.SpaceImpl;

/**
 *
 * @author Peter Cappello
 */
public class Tour extends Return implements Comparable<Tour>
{
    final private List<Integer> tour;
    final private double cost;
    
    /**
     * Return container for TaskEuclideanTsp.
     * @param tour
     * @param cost
     */
    public Tour( List<Integer> tour, double cost ) 
    {
        this.tour = tour;
        this.cost = cost;
    } 

    @Override
    public void process(Task task, SpaceImpl space) 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List<Integer> tour() { return tour; }
    
    public double cost() { return cost; }

    @Override
    public int compareTo( Tour tour )
    { 
        
        return this.cost < tour.cost ? -1 : this.cost > tour.cost ? 1 : 0;
    }
}
