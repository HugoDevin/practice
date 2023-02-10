package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Currency;


public interface CurrencyRepository extends CrudRepository<Currency, Integer>{
	
    List<Currency> findByCodeIn(@Param("codeList")  List<String> codeList);
    
    boolean existsByCode(String code);
    
}

