package br.com.msansone.apistockscontrol.service;

import br.com.msansone.apistockscontrol.exception.RegisterNotFoundException;
import br.com.msansone.apistockscontrol.model.Login;

import java.util.List;

public interface LoginService {

    List<Login> getAll();
    Login getOne(Long id);
    Login add(Login login);
    Login update(Login login, Long id) throws RegisterNotFoundException;
    Login login(Login login);
}
