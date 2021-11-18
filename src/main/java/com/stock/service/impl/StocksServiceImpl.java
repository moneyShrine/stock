package com.stock.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.entity.Stocks;
import com.stock.repository.StocksRepository;
import com.stock.service.StocksServices;


@Service
public class StocksServiceImpl implements StocksServices{

	@Autowired
	private StocksRepository stockRepository;
	
	
	@Override
	public List<Stocks> getStocks() {
		List<Stocks> stocks = new ArrayList<>();
		stockRepository.findAll().forEach(stocks::add);
		return stocks;
	}

	@Override
	public Optional<Stocks> getStock(int stockId) {
		return stockRepository.findById(stockId);
	}

	@Override
	public void addSock(Stocks stock) {
		stockRepository.save(stock);		
	}

	@Override
	public void updateStock(Stocks stock, int stockId) {
		stockRepository.save(stock);
		
	}

	@Override
	public void removeStock(int stockId) {
		stockRepository.deleteById(stockId);
		
	}
	

}
