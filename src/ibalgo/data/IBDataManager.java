/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ibalgo.data;

import com.ib.client.CommissionReport;
import com.ib.client.Contract;
import com.ib.client.ContractDetails;
import com.ib.client.EClientSocket;
import com.ib.client.EWrapper;
import com.ib.client.Execution;
import com.ib.client.Order;
import com.ib.client.OrderState;
import com.ib.client.UnderComp;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wayne
 */
public class IBDataManager implements EWrapper, Runnable {
    private EClientSocket sock = new EClientSocket(this);
    private Map<String, TrackedTicker > datamap = new HashMap<>();
    private int numberOfSecondsBetweenDataPoints = 5;
    private int numberOfSecondsToRemember = 3600;
    
    /**
     * keeps track of a new stock that we are concerned with trading on. 
     * @param ticker the ticker of the stock.
     * @return 
     */
    public boolean addTrackedTicker(String ticker) {
        if(datamap.containsKey(ticker)) {
            return false;
        } else {
            datamap.put(ticker, 
                    new TrackedTicker(numberOfSecondsBetweenDataPoints, numberOfSecondsToRemember, ticker));
            return true;
        }
    }
    
    //these are the most important
    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet.");
        //get all the key sets
    }
    
    
    @Override
    public void realtimeBar(int reqId, long time, double open, double high, double low, double close, long volume, double wap, int count) {
        
    }
    
    
    //the rest of these functions aren't very important to us right now. 
    
    @Override
    public void tickPrice(int tickerId, int field, double price, int canAutoExecute) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void tickSize(int tickerId, int field, int size) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void tickOptionComputation(int tickerId, int field, double impliedVol, double delta, double optPrice, double pvDividend, double gamma, double vega, double theta, double undPrice) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void tickGeneric(int tickerId, int tickType, double value) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void tickString(int tickerId, int tickType, String value) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void tickEFP(int tickerId, int tickType, double basisPoints, String formattedBasisPoints, double impliedFuture, int holdDays, String futureExpiry, double dividendImpact, double dividendsToExpiry) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void orderStatus(int orderId, String status, int filled, int remaining, double avgFillPrice, int permId, int parentId, double lastFillPrice, int clientId, String whyHeld) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void openOrder(int orderId, Contract contract, Order order, OrderState orderState) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void openOrderEnd() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateAccountValue(String key, String value, String currency, String accountName) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updatePortfolio(Contract contract, int position, double marketPrice, double marketValue, double averageCost, double unrealizedPNL, double realizedPNL, String accountName) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateAccountTime(String timeStamp) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void accountDownloadEnd(String accountName) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void nextValidId(int orderId) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void contractDetails(int reqId, ContractDetails contractDetails) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void bondContractDetails(int reqId, ContractDetails contractDetails) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void contractDetailsEnd(int reqId) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void execDetails(int reqId, Contract contract, Execution execution) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void execDetailsEnd(int reqId) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateMktDepth(int tickerId, int position, int operation, int side, double price, int size) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateMktDepthL2(int tickerId, int position, String marketMaker, int operation, int side, double price, int size) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateNewsBulletin(int msgId, int msgType, String message, String origExchange) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void managedAccounts(String accountsList) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void receiveFA(int faDataType, String xml) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void historicalData(int reqId, String date, double open, double high, double low, double close, int volume, int count, double WAP, boolean hasGaps) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void scannerParameters(String xml) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void scannerData(int reqId, int rank, ContractDetails contractDetails, String distance, String benchmark, String projection, String legsStr) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void scannerDataEnd(int reqId) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public void currentTime(long time) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void fundamentalData(int reqId, String data) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deltaNeutralValidation(int reqId, UnderComp underComp) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void tickSnapshotEnd(int reqId) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void marketDataType(int reqId, int marketDataType) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void commissionReport(CommissionReport commissionReport) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void error(Exception e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void error(String str) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void error(int id, int errorCode, String errorMsg) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void connectionClosed() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
