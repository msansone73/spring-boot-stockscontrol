package br.com.msansone.apistockscontrol.service;

import br.com.msansone.apistockscontrol.model.Login;
import br.com.msansone.apistockscontrol.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    LoginRepository loginRepository;

    @Override
    public List<Login> getAll() {
        return loginRepository.findAll();
    }

    @Override
    public Login getOne(Long id) {
        return loginRepository.findById(id).orElse(null);
    }

    @Override
    public Login add(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public Login update(Login login, Long id) throws Exception {
        Login atual= getOne(id);
        if (atual==null){
            throw new Exception("login inexistente");
        }
        atual.setLogin(login.getLogin());
        atual.setName(login.getName());
        atual.setPassword(login.getPassword());
        atual.setEmail(login.getEmail());
        return loginRepository.save(atual);
    }

    @Override
    public Login login(Login login) {
        return loginRepository.findByLoginAndPassword(login.getLogin(), login.getPassword());
    }

}
