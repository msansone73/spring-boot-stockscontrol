package br.com.msansone.apistockscontrol.control;

import br.com.msansone.apistockscontrol.model.Transaction;
import br.com.msansone.apistockscontrol.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping()
    public ResponseEntity<List<Transaction>> getAtt(){
        return ResponseEntity.ok(transactionService.getAll());
    }
    
    @PostMapping
    public ResponseEntity<Transaction> add(@RequestBody Transaction transaction){
        return ResponseEntity.ok(transactionService.add(transaction));
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<Transaction> change(@RequestBody Transaction transaction, @PathVariable Long id)  {
        try {
            return ResponseEntity.ok(transactionService.change(transaction, id));
        } catch (NoSuchFieldException e) {
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
