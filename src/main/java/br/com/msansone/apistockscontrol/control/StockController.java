package br.com.msansone.apistockscontrol.control;

import br.com.msansone.apistockscontrol.exception.RegisterNotFoundException;
import br.com.msansone.apistockscontrol.model.Stock;
import br.com.msansone.apistockscontrol.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("stock")
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping(value="")
    public ResponseEntity<List<Stock>> getAll(){
        return ResponseEntity.ok(stockService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Stock> getById(@PathVariable Long id){
        return ResponseEntity.ok(stockService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Stock> add(@RequestBody Stock stock){
        return ResponseEntity.ok(stockService.add(stock));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Stock> change(@RequestBody Stock stock, @PathVariable Long id) {
        try {
            return ResponseEntity.ok(stockService.change(stock, id));
        } catch (RegisterNotFoundException e) {
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public void delete (@PathVariable Long id){
        stockService.delete(id);
    }
}
