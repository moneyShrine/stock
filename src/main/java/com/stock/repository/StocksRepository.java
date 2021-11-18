package com.stock.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.stock.entity.Stocks;


public interface StocksRepository extends CrudRepository<Stocks, Integer>{
	Optional<Stocks> findById(int id);

}
