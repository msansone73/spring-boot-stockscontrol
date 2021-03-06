package br.com.msansone.apistockscontrol.control;

import br.com.msansone.apistockscontrol.exception.RegisterNotFoundException;
import br.com.msansone.apistockscontrol.model.Account;
import br.com.msansone.apistockscontrol.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountController {
    
    @Autowired
    AccountService accountService;
    
    @GetMapping(value="")
    public ResponseEntity<List<Account>> getAll(){
        return ResponseEntity.ok(accountService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Account> getById(@PathVariable Long id){
        Account accout = accountService.getOne(id);
               
        if (accout==null){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(accout);
        }
    }

    @GetMapping(value = "/login/{id}")
    public ResponseEntity<List<Account>> getByLoginId(@PathVariable Long id){
        return ResponseEntity.ok(accountService.getByLoginId(id));
    }

    @PostMapping("")
    public ResponseEntity<Account> add(@RequestBody Account account){
        return ResponseEntity.ok(accountService.add(account));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> change(@RequestBody Account account, @PathVariable Long id)  {
        try {
            Account acc=accountService.update(account, id);
            return  ResponseEntity.ok(acc);
        } catch (RegisterNotFoundException e) {
            return (ResponseEntity<Account>) ResponseEntity.notFound();
        }
    }
    

 
    
}
