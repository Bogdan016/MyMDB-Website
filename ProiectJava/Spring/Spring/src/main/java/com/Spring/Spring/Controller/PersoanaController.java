package com.Spring.Spring.Controller;

import com.Spring.Spring.Entity.PersoanaEntity;
import com.Spring.Spring.Service.PersoanaService;
import jakarta.persistence.spi.PersistenceProviderResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:63342")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class PersoanaController {
    @Autowired
    private PersoanaService persoanaService;

    @PostMapping("/addPersoana")
    public PersoanaEntity postDetails(@RequestBody PersoanaEntity entry) {
        return persoanaService.saveDetails(entry);
    }

    @GetMapping("/getPersoana")
    public List<PersoanaEntity> getDetails() {
        return persoanaService.getDetails();
    }

    @GetMapping("/getPersoanaByCastigNetAndMoneda")
    public List<PersoanaEntity> getPersoanaByCastigNetAndMoneda(@RequestParam long castig_net, @RequestParam String moneda) {
        return persoanaService.findByCastigNetGreaterThanAndMoneda(castig_net, moneda);
    }

    @GetMapping("/getLeastPaidActress")
    public List<String> getLeastPaidActress() {
        return persoanaService.findLeastPaidActress();
    }

    @GetMapping("/getMoviesByGenre2")
    public List<Object[]> getMoviesByGenre(@RequestParam String gen) {
        return persoanaService.findMoviesByGenre(gen);
    }

    @GetMapping("/getMinMaxEarnings")
    public List<Object[]> getMinMaxEarnings() {
        return persoanaService.findMinMaxEarnings();
    }

}
