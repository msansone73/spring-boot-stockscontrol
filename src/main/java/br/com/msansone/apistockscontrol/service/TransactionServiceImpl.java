package br.com.msansone.apistockscontrol.service;

import br.com.msansone.apistockscontrol.model.Transaction;
import br.com.msansone.apistockscontrol.repository.TransactionRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionRepositoty transactionRepositoty;


    @Override
    public List<Transaction> getAll() {
        return transactionRepositoty.findAll();
    }

    @Override
    public List<Transaction> getByAccountId(Long id) {
        return transactionRepositoty.findAllByAccountId(id);
    }

    @Override
    public List<Transaction> getByStockId(Long id) {
        return transactionRepositoty.findAllByStockId(id);
    }

    @Override
    public Transaction getById(Long id) {
        return transactionRepositoty.findById(id).orElse(null);
    }

    @Override
    public Transaction add(Transaction transaction) {
        return transactionRepositoty.save(transaction);
    }

    @Override
    public Transaction change(Transaction transaction, Long id) throws NoSuchFieldException {
        Transaction atual = this.getById(id);
        if (atual==null){
            throw  new NoSuchFieldException("Transaction not found");
        }
        atual.setTransactionType(transaction.getTransactionType());
        atual.setQuantity(transaction.getQuantity());
        atual.setStock(transaction.getStock());
        atual.setAccount(transaction.getAccount());
        atual.setUnitPrice(transaction.getUnitPrice());
        return transactionRepositoty.save(atual);
    }
}
