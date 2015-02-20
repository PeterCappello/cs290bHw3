/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applications.fibonacci;

import api.ReturnValue;
import api.TaskCompose;

/**
 *
 * @author Peter Cappello
 */
public class TaskSumIntegers extends TaskCompose
{    
    @Override
    public ReturnValue call() 
    {
//        System.out.println("TaskSumIntegers.call: task.id(): " + id() + " args()[ 0 ]: " + args()[ 0 ] );
        int value = ((Integer ) args()[ 0 ] ) + (Integer ) args()[ 1 ];
        return new ReturnValue<>( this, value );
    }
}
