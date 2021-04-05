package br.com.msansone.apistockscontrol.service;

import br.com.msansone.apistockscontrol.model.Stock;
import br.com.msansone.apistockscontrol.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StockServiceImpl implements  StockService{

    @Autowired
    StockRepository stockRepository;

    @Override
    public List<Stock> getAll() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public Stock add(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock change(Stock stock, Long id) throws NoSuchElementException {
        Stock atual = this.getById(id);
        if (atual==null){
            throw  new NoSuchElementException("Stock not found");
        }
        atual.setName(stock.getName());
        atual.setDescription(stock.getDescription());
        atual.setCod(stock.getCod());
        atual.setType(stock.getType());
        return stockRepository.save(atual);
    }

    @Override
    public void delete(Long id) {
        stockRepository.deleteById(id);
    }
}
