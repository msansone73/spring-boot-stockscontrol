package br.com.msansone.apistockscontrol.service;

import br.com.msansone.apistockscontrol.exception.RegisterNotFoundException;
import br.com.msansone.apistockscontrol.model.Login;
import br.com.msansone.apistockscontrol.model.dto.LoginDTO;
import br.com.msansone.apistockscontrol.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    LoginRepository loginRepository;

    @Override
    public List<LoginDTO> getAll() {
        List<Login> logins = loginRepository.findAll();
        return logins.stream().map(l -> new LoginDTO(l)).collect(Collectors.toList());
        //return logins.stream().map(LoginDTO.class::cast).collect(Collectors.toList());
    }

    @Override
    public LoginDTO getOne(Long id) {
        Login login = loginRepository.findById(id).orElse(null);
        return login==null?null:new LoginDTO(login);
    }

    @Override
    public LoginDTO add(LoginDTO loginDTO) {
        return new LoginDTO(loginRepository.save(loginDTO.getDBLogin()));
    }

    @Override
    public LoginDTO update(LoginDTO login, Long id) throws RegisterNotFoundException {
        LoginDTO atual= getOne(id);
        if (atual==null){
            throw new RegisterNotFoundException();
        }
        atual.setName(login.getName());
        atual.setPassword(login.getPassword());
        atual.setEmail(login.getEmail());
        return new LoginDTO(loginRepository.save(atual.getDBLogin()));
    }

    @Override
    public LoginDTO login(LoginDTO login) {
        List<Login> logins = loginRepository.findByEmailAndPassword(login.getEmail(), login.getPassword());
        List<LoginDTO> loginDTIOs = logins.stream().map(l -> new LoginDTO(l)).collect(Collectors.toList());
        return loginDTIOs.isEmpty()?null:loginDTIOs.get(0);
    }

}
