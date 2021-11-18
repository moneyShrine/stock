package com.stock.controller;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stock.entity.Stocks;
import com.stock.repository.StocksRepository;
import com.stock.service.impl.StocksServiceImpl;


@RestController
public class StockController {
	@Autowired
	private StocksServiceImpl stockServiceImpl;
	
	@Autowired
	private StocksRepository stockRepository;
	
	Date date_timestamp = Calendar.getInstance().getTime();
	
	
	
	@RequestMapping(method=RequestMethod.GET, value="/api/stocks")
	public List<Stocks> getStocks(){
		return stockServiceImpl.getStocks();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/api/stocks/{stockId}")
	public Object getStock(@PathVariable int stockId) {
		return stockServiceImpl.getStock(stockId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/api/stocks")
	public void addStock(@RequestBody Stocks stock) {
		stock.setCreate_date(date_timestamp);
		stock.setLast_update(date_timestamp);
		stockServiceImpl.addSock(stock);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/api/stocks/{stockId}")
	public void addStock(@RequestBody Stocks stock, @PathVariable int stockId) {
		Stocks stocks = (Stocks) stockServiceImpl.getStock(stockId);
		
		stock.setId(stocks.getId());
		stock.setLast_update(date_timestamp);
		stock.setCreate_date(stocks.getCreate_date());
		stockServiceImpl.addSock(stock);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/api/stocks/{stockId}")
	public void deleteStock(@PathVariable int stockId) {
		if(stockRepository.findById(stockId).isPresent()) {
			stockServiceImpl.removeStock(stockId);
		}
	}
	
}
