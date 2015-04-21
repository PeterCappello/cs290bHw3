/*
 * The MIT License
 *
 * Copyright 2015 petercappello.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package applications.fibonacci;

import api.Job;
import api.JobRunner;
import api.ReturnValue;
import api.Space;
import api.Task;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Peter Cappello
 */
public class JobFibonacci implements Job<Integer>
{
    // configure application
    static private final int N = 16; // F(16) = 987
    static private final Task TASK = new TaskFibonacci( N );
    static private       String TITLE = "Fibonacci number";
    private ReturnValue<Integer> result;
        
    public JobFibonacci() {}
    
    @Override
    public JLabel viewSolution( Integer number ) 
    {
        return new JLabel( "    The " + N +  "th Fibonacci number is " + number + "    ", SwingConstants.CENTER ) ;
    }
    
    public static void main( String[] args ) throws Exception
    {
        final JobFibonacci job = new JobFibonacci();
        final JobRunner jobRunner = new JobRunner( job, TITLE, "" );
        jobRunner.run( TASK );
    }
}