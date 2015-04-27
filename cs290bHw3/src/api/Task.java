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
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package api;
import java.io.Serializable;
import system.Return;
import java.util.concurrent.Callable;

/**
 *
 * @author Peter Cappello
 */
abstract public class Task implements Serializable, Callable<Return> 
{ 
    private int id;
    private int composeId;
    private int composeArgNum;
    
    /**
    * Task is an encapsulation of some computation.
    * @author Peter Cappello
    */
    @Override
    abstract public Return call(); 
        
    /**
     *
     * @return the task id.
     */
    public int  id() { return id; }

    /**
     *
     * @param id set the task id.
     */
    public void id( int id ) { this.id = id; }
    
    /**
     * 
     * @return the number of the input (this task execute method return value)
     * to the successor task.
     */
    public int  composeArgNum() { return composeArgNum; }

    /**
     *
     * @param composeArgNum set the number of the input (this task execute 
     * method return value) to the successor task.
     */
    public void composeArgNum( int composeArgNum ) { this.composeArgNum = composeArgNum; }
    
    /**
     * Get the id of this task's successor task.
     * @return the id of this task's successor task.
     */
    public int  composeId() { return composeId; }

    /**
     * Set the id of this task's successor task.
     * @param composeId the id of this task's successor task.
     */
    public void composeId( int composeId ) { this.composeId = composeId; }
    
    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( " id: ").append( id );
        stringBuilder.append( " composeId: ").append( composeId );
        stringBuilder.append( " composeArgNum: ").append( composeArgNum );
        stringBuilder.append( ' ' );
        return stringBuilder.toString();
    }
}
