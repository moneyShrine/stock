package com.stock.repository;

import org.springframework.data.repository.CrudRepository;

import com.stock.entity.Stocks;


public interface StocksRepository extends CrudRepository<Stocks, Integer>{

}
