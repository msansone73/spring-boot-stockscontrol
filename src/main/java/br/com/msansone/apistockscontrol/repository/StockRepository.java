package br.com.msansone.apistockscontrol.repository;

import br.com.msansone.apistockscontrol.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
