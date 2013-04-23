/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ibalgo.data;

import com.ib.client.Contract;
import java.awt.List;
import java.util.LinkedList;
import samples.base.StkContract;

/**
 *
 * @author wayne
 */
public class TrackedTicker {
    private static int currentTickerId = 0;
    private int numberOfSecondsBetweenDataPoints;
    private int numberOfSecondsToRemember;
    private LinkedList<Double> prices;
    private String ticker;
    private int tickerId;
    
    
    /**
     * This is the full constructor. 
     * @param numberOfSecondsBetweenDataPoints defaults to 5 seconds
     * @param numberOfSecondsToRemember defaults to one hour = 60*60 seconds
     * @param ticker 
     */
    public TrackedTicker(int numberOfSecondsBetweenDataPoints, int numberOfSecondsToRemember, String ticker) {
        this.numberOfSecondsBetweenDataPoints = numberOfSecondsBetweenDataPoints;
        this.numberOfSecondsToRemember = numberOfSecondsToRemember;
        this.ticker = ticker;
        this.tickerId = currentTickerId++;
        prices = new LinkedList<>();
    }
    
    /**
     * defaults for other parameters, just supply the ticker and you're good to
     * go. 
     * @param ticker the stock ticker, assuming type is STK. 
     */
    public TrackedTicker(String ticker) {
        this(5, 60*60, ticker); // gives 1 hour stored. 
    }
    
    /**
     * @return the contract associated with this ticker. Right now we are using
     * the stock contract
     */
    public Contract getContract() {
        return new StkContract(ticker);
    }
    
    public int getTickerId() {
        return tickerId;
    }
    
    /**
     * adds a price to the list of prices. The last element is the newest.
     * @param price 
     */
    public void addPrice(double price) {
        //this code has to be thread safe. 
        synchronized(prices) {
            if(prices.size() < numberOfSecondsToRemember/numberOfSecondsBetweenDataPoints) {
                prices.addLast(price); // last is the newest
            } else {
                prices.removeFirst();//dump the oldest one
                prices.addLast(price);
            }
        }
    }

    public int getNumberOfSecondsBetweenDataPoints() {
        return numberOfSecondsBetweenDataPoints;
    }

    public int getNumberOfSecondsToRemember() {
        return numberOfSecondsToRemember;
    }

    public LinkedList<Double> getPrices() {
        return prices;
    }

    public String getTicker() {
        return ticker;
    }
    
    public double getLastPrice() {
        return prices.getLast();
    }
    
}
