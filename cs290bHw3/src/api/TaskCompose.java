/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

/**
 *
 * @author Peter Cappello
 */
public abstract class TaskCompose extends Task
{
    private int numUnsetArgs;
    private Object[] args;
    
    @Override
    abstract public ReturnValue call();
    
    public Object[] args() { return args; }
    
    public void arg( int argNum, Object argValue ) 
    { 
        args[ argNum ] = argValue;
        numUnsetArgs--;
    }
    
    public void numArgs( int numArgs )
    {
        numUnsetArgs = numArgs;
        args = new Object[ numArgs ];
    }
    
    public boolean isReady() { return numUnsetArgs == 0; }
}
