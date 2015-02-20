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

import system.Return;
import system.SpaceImpl;

public class ReturnSubtasks extends Return
{    
    final private Subtasks subtasks;
    
    public ReturnSubtasks( Subtasks subtasks ) { this.subtasks = subtasks; }
    
    /**
     *
     * @param parentTask the task whose result is to be processed.
     * @param space the Space that holds the Task and Results.
     */
    @Override
    public void process( Task parentTask, SpaceImpl space ) 
    {
        final TaskCompose compose = subtasks.compose();
        final Task[]      tasks   = subtasks.tasks();
        final int composeId = space.makeTaskId();
        compose.id( composeId );
        compose.composeId( parentTask.composeId() );
        compose.composeArgNum( parentTask.composeArgNum() );
        compose.numArgs( tasks.length );
        space.putCompose( compose );
//        System.out.println("ReturnSubtasks.process compose: compose.id(): " + compose.id()
//                + " compose.composeId(): " + compose.composeId());
        for ( int i = 0; i < tasks.length; i++  )
        {
            Task task = tasks[ i ];
            task.id( space.makeTaskId() );
            task.composeId( composeId );
            task.composeArgNum( i );
            space.putReadyTask( task ); 
//            System.out.println(" task: task.id(): " + task.id()
//                    + " task.composeId(): " + task.composeId()
//                    + " task.composeArgNum( " + i + " ): " + task.composeArgNum()
//                    + " task: " + task
//             );
        }
        
    }
}
