/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ibalgo.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wayne
 */
public class Parameters {
    private Map<String, String> sparams;
    private Map<String, Double> dparams;
    
    public Parameters() {
        sparams = new HashMap<>();
        dparams = new HashMap<>();
    }
    
    /**
     * this method is meant to be overridden, the nieve implementation will 
     * just set the parameter and always return true without checking anything
     * if that is ok, then, don't override
     * @param param the parameter to set
     * @param val the value to set it to
     * @return true if this value for that parameter is valid and set, false 
     *  otherwise
     */
    public boolean setParameter(String param, String val) {
        sparams.put(param, val);
        return true;
    }
    
    /**
     * this method is meant to be overridden, the nieve implementation will 
     * just set the parameter and always return true without checking anything
     * if that is ok, then, don't override
     * @param param the parameter to set
     * @param val the value to set it to
     * @return true if this value for that parameter is valid and set, false 
     *  otherwise
     */
    public boolean setParameter(String param, double val) {
        dparams.put(param, val);
        return true;
    }
    
}
