package br.com.msansone.apistockscontrol.service;

import br.com.msansone.apistockscontrol.exception.RegisterNotFoundException;
import br.com.msansone.apistockscontrol.model.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAll();
    Account getOne(Long id);
    Account add(Account account);
    Account update(Account account, Long id) throws RegisterNotFoundException;
    List<Account> getByLoginId(Long loginId);

}
