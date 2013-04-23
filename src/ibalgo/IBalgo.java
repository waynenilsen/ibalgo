/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ibalgo;

import com.sun.xml.internal.ws.message.saaj.SAAJHeader;
import ibalgo.data.IBDataManager;
import ibalgo.data.TrackedTicker;
import java.util.NoSuchElementException;

/**
 *
 * @author wayne
 */
public class IBalgo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //a demonstration of data management
        IBDataManager mgr = new IBDataManager();
        mgr.addTrackedTicker("AAPL");
        
        Thread t = new Thread(mgr);
        
        t.start();
        
        TrackedTicker aapltick = mgr.getTrackedTicker("AAPL");
        
        //show 10 prices
        for(int i = 1; i < 10; i++ ) {
            try {
                Thread.sleep(1000);
                System.out.println("wap: " + aapltick.getLastPrice());
            } catch(Exception e) {
                System.out.println("nothing good");
            }
        }
    }
}
