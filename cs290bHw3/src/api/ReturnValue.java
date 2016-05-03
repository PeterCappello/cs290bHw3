/*
 * The MIT License
 *
 * Copyright 2016 Peter Cappello.
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
import system.Task;
import system.Return;
import system.SpaceImpl;

/**
 * The return value of some task execute method that does NOT decompose into 
 * subtasks.
 * @author Peter Cappello
 * @param <T>
 */
public class ReturnValue<T> extends Return
{    
    static final public int FINAL_RETURN_VALUE = -1;
    
    final private int composeId;
    final private int composeArgNum;
    final private T value;
    
    /**
     *
     * @param task whose return value is contained in this object
     * @param value the task execute method return value.
     */
    public ReturnValue( final Task task, final T value ) 
    { 
        composeId = task.composeId();
        composeArgNum = task.composeArgNum();
        this.value = value; 
    }
    
    /**
     *
     * @return the return value.
     */
    public T value() { return value; }
       
    /**
     * Update the compose task that is waiting for this input.
     * @param parentTask unused - the task whose Result is to be processed.
     * @param space containing the compose task that is waiting for this value.
     */
    @Override
    public void process( final Task parentTask, final SpaceImpl space )
    {
        if ( composeId == FINAL_RETURN_VALUE )
        {
            space.addResult( this );
            return;
        }
        TaskCompose taskCompose = space.getCompose( composeId );
        assert taskCompose != null;
        taskCompose.arg( composeArgNum, value, space );
    }
}
