package br.com.msansone.apistockscontrol.control;

import br.com.msansone.apistockscontrol.model.Login;
import br.com.msansone.apistockscontrol.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping(value="")
    public ResponseEntity<List<Login>> getAll(){
        List<Login> logins = loginService.getAll();
        return ResponseEntity.ok(logins);
    }
    
    @PostMapping(value="")
    public ResponseEntity<Login> addLogin(@RequestBody Login login){
        return ResponseEntity.ok(loginService.add(login));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Login> changeLogin(@RequestBody Login login, @PathVariable Long id) throws Exception {
        return ResponseEntity.ok(loginService.update(login, id));
    }
    
    
}
