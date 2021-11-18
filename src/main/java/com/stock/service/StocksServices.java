package com.stock.service;

import java.util.List;

import com.stock.entity.Stocks;

public interface StocksServices {
	public List<Stocks> getStocks();					//get's the List of Stocks
	public Object getStock(int stockId);				//get's a single Stock from the list by its ID
	public void addSock(Stocks stock); 					//adds new stock
	public void updateStock(Stocks stock, int stockId);	//Updates existing stock in the database
	public void removeStock(int stockId);				//removes stock from list of stock in the database
}
