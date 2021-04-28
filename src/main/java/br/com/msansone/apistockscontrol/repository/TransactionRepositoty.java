package br.com.msansone.apistockscontrol.repository;

import br.com.msansone.apistockscontrol.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepositoty extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByAccountId(Long accountId);
    List<Transaction> findAllByStockId(Long accountId);

}
