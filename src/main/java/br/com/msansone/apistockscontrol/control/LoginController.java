package br.com.msansone.apistockscontrol.control;

import br.com.msansone.apistockscontrol.exception.RegisterNotFoundException;
import br.com.msansone.apistockscontrol.model.dto.LoginDTO;
import br.com.msansone.apistockscontrol.model.rest.Erro;
import br.com.msansone.apistockscontrol.model.rest.LoginListResponse;
import br.com.msansone.apistockscontrol.model.rest.LoginRequest;
import br.com.msansone.apistockscontrol.model.rest.LoginResponse;
import br.com.msansone.apistockscontrol.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping(value="")
    public ResponseEntity<LoginListResponse> getAll(){
        LoginListResponse loginListResponse = new LoginListResponse();
        loginListResponse.setLoginDTOList(loginService.getAll());
        return ResponseEntity.ok(loginListResponse);
    }
    
    @PostMapping(value="")
    public ResponseEntity<LoginResponse> addLogin(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = new LoginResponse();
        LoginDTO loginDTO = loginService.add(loginRequest.getLoginDTO());
        loginResponse.setLoginDTO(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping(value="/autenticar")
    public ResponseEntity<LoginResponse> autenticLogin(@RequestBody LoginRequest loginRequest){
        LoginDTO retLogin=loginService.login(loginRequest.getLoginDTO());
        LoginResponse loginResponse= new LoginResponse();
        if (retLogin != null) {
            loginResponse.setLoginDTO(retLogin);
        } else {
            loginResponse.setErro(new Erro(-1L,"Invalid Login."));
        }
        return ResponseEntity.ok(loginResponse);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<LoginResponse> changeLogin(@RequestBody LoginRequest loginRequest, @PathVariable Long id) {

        LoginResponse loginResponse= new LoginResponse();
        try {
            LoginDTO logi = loginService.update(loginRequest.getLoginDTO(), id);
            loginResponse.setLoginDTO(logi);
        } catch (RegisterNotFoundException e) {
            loginResponse.setErro(new Erro(-1L, "Register Not Found."));
        }
        return ResponseEntity.ok(loginResponse);

    }
    
    
}
