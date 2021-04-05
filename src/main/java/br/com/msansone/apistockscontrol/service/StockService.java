package br.com.msansone.apistockscontrol.service;

import br.com.msansone.apistockscontrol.model.Stock;

import java.util.List;

public interface StockService {

    List<Stock> getAll();
    Stock getById(Long id);
    Stock add(Stock stock);
    Stock change(Stock stock, Long id) throws Exception;
    void delete(Long id);
}
