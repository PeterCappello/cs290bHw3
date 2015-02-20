/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import system.Return;

/**
 *
 * @author Peter Cappello
 * @param <T> type of the solution to this recursive problem.
 */
abstract public class TaskRecursive<T> extends Task
{    
    @Override
    public Return call() { return isAtomic() ? solve() : decompose(); }
    
    abstract public boolean isAtomic();
    
    abstract public ReturnValue<T> solve();
    
    abstract public ReturnSubtasks decompose();
    
//    /**
//     * Give SpaceProxy these tasks: This is NOT a remote method.
//     * @param compose
//     * @param tasks
//     */
//    protected void compute( TaskCompose compose, Task[] tasks )
//    {
//        compose.composeId( this.composeId() );
//        System.out.println("TaskRecursive.compute: TaskId: " + id() + " composeId: " + this.composeId() + " tasks.length: " + tasks.length);
//        try { space.compute( compose, tasks ); } catch ( RemoteException ignore ){}
//    }
}
