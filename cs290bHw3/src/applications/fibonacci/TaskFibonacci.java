/*
 * The MIT License
 *
 * Copyright 2015 peter.
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
 * FITNESS FOR ONE PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package applications.fibonacci;

import api.ReturnDecomposition;
import api.ReturnValue;
import api.Task;
import api.TaskDecompose;
import java.util.ArrayList;
import java.util.List;

/**
 * Compute the nth Fibonacci number.
 * @author Peter Cappello
 */
public class TaskFibonacci extends TaskDecompose<Integer>
{ 
    final private int n;
            
    /**
     * 
     * @param n the Fibonacci number to be computed.
     */
    public TaskFibonacci( final int n ) 
    { 
        if ( n < 0 )
        {
            throw new IllegalArgumentException( "number " + n + " is < 0.");
        }
        this.n = n; 
    }

    /**
     * 
     * @return true if and only if n is less than 2.
     */
    @Override
    public boolean isAtomic() { return n < 2; }

    /**
     * 
     * @return f( 0 ) = 0; f( 1 ) = 1.
     */
    @Override
    public ReturnValue<Integer> solve() { return new ReturnValue<>( this, n ); }

    /**
     * f( n ) = f( n - 1 ) + f( n - 2 ), n greater than 1.
     * @return 2 TaskFibonacci subtasks, 1 for n - 1 and one for n - 2, 
     * as well as a SumIntegers TaskCompose to sum the return values of the 
     * subtasks.
     */
    @Override
    public ReturnDecomposition divideAndConquer() 
    {
        List<Task> subtasks = new ArrayList<>();
        subtasks.add( new TaskFibonacci( n - 2 ) );
        subtasks.add( new TaskFibonacci( n - 1 ) );
        
        return new ReturnDecomposition( new SumIntegers(), subtasks ); 
    }
    
    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( super.toString() );
        stringBuilder.append( getClass() );
        stringBuilder.append( ": number: " );
        stringBuilder.append( n );
        return stringBuilder.toString();
    }
}
