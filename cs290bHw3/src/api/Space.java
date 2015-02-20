/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package api;

import system.Return;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Peter Cappello
 */
public interface Space extends Remote 
{
    public static int PORT = 8001;
    public static String SERVICE_NAME = "Space";

    Return compute( Task task ) throws RemoteException;
    
    void put( Task task ) throws RemoteException;

    Return take() throws RemoteException;

    void exit() throws RemoteException;
}
