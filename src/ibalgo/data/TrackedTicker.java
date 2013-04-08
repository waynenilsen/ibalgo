/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ibalgo.data;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author wayne
 */
public class TrackedTicker {
    private int numberOfSecondsBetweenDataPoints;
    private int numberOfSecondsToRemember;
    private LinkedList<Double> prices;
    private String ticker;
    
    /**
     * defaults for other parameters, just supply the ticker and you're good to
     * go. 
     * @param ticker the stock ticker, assuming type is STK. 
     */
    public TrackedTicker(String ticker) {
        this(5, 60*60, ticker); // gives 1 hour stored. 
    }
    
    /**
     * adds a price to the list of prices. The last element is the newest.
     * @param price 
     */
    public void addPrice(double price) {
        if(prices.size() < numberOfSecondsToRemember/numberOfSecondsBetweenDataPoints) {
            prices.addLast(price); // last is the newest
        } else {
            prices.removeFirst();//dump the oldest one
            prices.addLast(price);
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
    }
    
}
