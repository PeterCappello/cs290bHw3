/*
 * The MIT License
 *
 * Copyright 2015 Peter Cappello.
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import system.SpaceImpl;

/**
 *
 * @author Peter Cappello
 * @param <I> input type.
 */
public abstract class TaskCompose<I> extends Task
{
    private AtomicInteger numUnsetArgs;
    private List<I> args;
    
    @Override
    abstract public ReturnValue call();
    
    /**
     *
     * @return
     */
    synchronized public List<I> args() { return args; }
    
    synchronized public void arg( int argNum, I argValue, SpaceImpl space ) 
    { 
        assert numUnsetArgs.get() > 0 && numUnsetArgs.intValue() != 0 && argValue != null && args.get( argNum ) == null;
        args.set( argNum, argValue );
        assert args.get( argNum ) == argValue;
        numUnsetArgs.getAndDecrement();
        if ( numUnsetArgs.intValue() == 0 )
        {
            space.putReadyTask( this );
            space.removeWaitingTask( id() );
        }
    }
    
    synchronized public void numArgs( int numArgs )
    {
        numUnsetArgs = new AtomicInteger( numArgs );
        args = Collections.synchronizedList( new ArrayList<>( numArgs ) );
        for ( int i = 0; i < numArgs; i++ )
        {
            assert args.size() == i;
            args.add( null );
            assert args.get( i ) == null;
        }
        assert args.size() == numArgs;
    }
    
//    synchronized public boolean isReady() { return numUnsetArgs.intValue() == 0; }
} 
