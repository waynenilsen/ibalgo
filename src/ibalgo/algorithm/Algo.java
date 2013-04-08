/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ibalgo.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author wayne
 */
public abstract class Algo implements Runnable {
    protected Map<String, String> sParams;
    protected Map<String, Double> dParams;
    
    protected Algo() {
        sParams = new HashMap<>();
        dParams = new HashMap<>();
    }
    
    @Override
    public abstract void run();
    
    public abstract boolean setStringParameter(String param, String val);
    public abstract String getStringParameter(String param);
    public abstract boolean setDoubleParameter(String param, double val);
    public abstract double getDoubleParameter(String param);
}
