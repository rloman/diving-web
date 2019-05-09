package nl.capgemini.divingweb.api;

import com.sun.org.apache.regexp.internal.RE;
import nl.capgemini.divingweb.model.Suit;
import nl.capgemini.divingweb.service.SuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("api/suits")

// this must be done for Angular Security using withSecurity in the httClient::get(...{withSecurity: true})
@CrossOrigin(origins = "http://localhost:4200",
        allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class SuitController {

    @Autowired
    private SuitService suitService;

    @GetMapping
    public ResponseEntity<Iterable<Suit>> list() {
        return ResponseEntity.ok(this.suitService.findAll());
    }

    @PostMapping
    public ResponseEntity<Suit> create(@RequestBody Suit suit) {
        return ResponseEntity.ok(this.suitService.save(suit));
    }

    @GetMapping("{id}")
    public ResponseEntity<Suit> findById(@PathVariable long id) {

        Optional<Suit> optionalSuit = this.suitService.findById(id);
        if(optionalSuit.isPresent()) {
            Suit result = optionalSuit.get();
            return ResponseEntity.ok(result);
        }
        else {
           return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Suit> updateById(@PathVariable long id, @RequestBody Suit suitIn) {

       Optional<Suit> optionalSuit = this.suitService.edit(id, suitIn);
       if(optionalSuit.isPresent()) {
           return ResponseEntity.ok(optionalSuit.get());
       }
       else {
           return ResponseEntity.notFound().build();
       }
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        this.suitService.deleteById(id);
    }



}
