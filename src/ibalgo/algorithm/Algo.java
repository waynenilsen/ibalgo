/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ibalgo.algorithm;

/**
 * 
 * @author wayne
 */
public abstract class Algo implements Runnable {
    
    
    
    @Override
    public abstract void run();
    
    public abstract void setParameters(Parameters p);
    public abstract Parameters getParameters();
}
