package br.com.msansone.apistockscontrol.service;

import br.com.msansone.apistockscontrol.model.Login;

import java.util.List;

public interface LoginService {

    List<Login> getAll();
    Login getOne(Long id);
    Login add(Login login);
    Login update(Login login, Long id) throws Exception;

}
