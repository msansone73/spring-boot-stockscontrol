package br.com.msansone.apistockscontrol.service;

import br.com.msansone.apistockscontrol.model.Account;
import br.com.msansone.apistockscontrol.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account getOne(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account add(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Account account, Long id) throws Exception {
        Account atual = getOne(id);
        if(atual==null){
            throw new Exception("Account not found");
        }
        atual.setName(account.getName());
        atual.setDescription(account.getDescription());
        return accountRepository.save(atual);
    }

    @Override
    public List<Account> getByLoginId(Long loginId) {
        return accountRepository.findAllByLoginId(loginId);
    }
}
