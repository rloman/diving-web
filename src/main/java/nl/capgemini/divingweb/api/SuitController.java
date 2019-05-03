package nl.capgemini.divingweb.api;

import com.sun.org.apache.regexp.internal.RE;
import nl.capgemini.divingweb.model.Suit;
import nl.capgemini.divingweb.service.SuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/suits")
@CrossOrigin("*")
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

    // put
    // find the Suit by id
    // set the properties of the suitIn to the saved suit
    @PutMapping("{id}")
    public Suit updateById(@PathVariable long id, @RequestBody Suit suitIn) {


        return this.suitService.edit(id, suitIn); // FIX THIS 
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        this.suitService.deleteById(id);
    }



}
