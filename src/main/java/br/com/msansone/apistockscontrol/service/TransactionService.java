package br.com.msansone.apistockscontrol.service;

import br.com.msansone.apistockscontrol.model.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getAll();
    List<Transaction> getByAccountId(Long id);
    List<Transaction> getByStockId(Long id);


    Transaction getById(Long id);
    Transaction add(Transaction transaction);
    Transaction change(Transaction transaction, Long id) throws NoSuchFieldException;


}
