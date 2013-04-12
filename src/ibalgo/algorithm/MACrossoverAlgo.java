/*
 * To change this template, Wayne Cant Spell to save his life.
 * and open the template in the editor.
 */
package ibalgo.algorithm;

/**
 * The parameters for this class are
 * String parameters:
 *   ticker -- ticker is the symbol for the asset that will be traded. 
 * Double parameters:
 *   maLongLag -- the long lag in minutes
 *   maShortLag -- the short lag in minutes
 *     Note: maLongLag > maShortLag
 * 
 * @author wayne
 */
public class MACrossoverAlgo extends Algo {
    private double maLong;
    private double maShort;
    
    public MACrossoverAlgo() {
        super();
        updateMAs();
    }
    
    /**
     * this updates the moving averages based on the history and the periods. 
     */
    private void updateMAs() {
        
    }
    
    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet.");
        
        // BLABLABLABLA
        //Dhruv Smells!
        
    }

    @Override
    public boolean setStringParameter(String param, String val) {
        if(param.equals("ticker")) {
            sParams.put(param, val);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getStringParameter(String param) {
        if(param.equals("ticker")) {
            return sParams.get(param);
        } else {
            return "No such parameter : " + param;
        }
    }

    @Override
    public boolean setDoubleParameter(String param, double val) {
        if(param.equals("maLongLag")) {
            if(dParams.containsKey("maShortLag")) { //short lag already set
                if(dParams.get("maShortLag") < val) {
                    //set it 
                    dParams.put(param, val);
                    return true;
                } else {
                    return false;
                }
            } else { // short lag not set, doesn't matter what long lag is.
                dParams.put(param, val);
                return true;
            }
        } else if(param.equals("maShortLag")) {
            if(dParams.containsKey("maLongLag")) { //short lag already set
                if(dParams.get("maLongLag") > val) {
                    //set it 
                    dParams.put(param, val);
                    return true;
                } else {
                    return false;
                }
            } else { // long lag not set, doesn't matter what long lag is.
                dParams.put(param, val);
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public double getDoubleParameter(String param) {
        if(param.equals("maLongLag") || param.equals("maShortLag")) {
            return dParams.get(param);
        } else {
            return -1;
        }
    }
    
}
