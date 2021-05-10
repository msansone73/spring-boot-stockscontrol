package br.com.msansone.apistockscontrol.service;

import br.com.msansone.apistockscontrol.exception.RegisterNotFoundException;
import br.com.msansone.apistockscontrol.model.dto.LoginDTO;

import java.util.List;

public interface LoginService {

    List<LoginDTO> getAll();
    LoginDTO getOne(Long id);
    LoginDTO add(LoginDTO login);
    LoginDTO update(LoginDTO login, Long id) throws RegisterNotFoundException;
    LoginDTO login(LoginDTO login);
}
