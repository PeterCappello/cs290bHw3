/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
    
    synchronized public void arg( int argNum, I argValue ) 
    { 
        args.set( argNum, argValue );
        numUnsetArgs.decrementAndGet();
    }
    
    synchronized public void numArgs( int numArgs )
    {
        numUnsetArgs = new AtomicInteger( numArgs );
        args = Collections.synchronizedList( new ArrayList<>( numArgs ) );
        // !! rework this so that loop is unnecessary.
        for ( int i = 0; i < numArgs; i++ )
        {
            args.add( null );
        }
    }
    
    synchronized public boolean isReady() { return numUnsetArgs.intValue() == 0; }
} 
