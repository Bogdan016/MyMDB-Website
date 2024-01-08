package com.Spring.Spring.Controller;

import com.Spring.Spring.Entity.ExceptiiEntity;
import com.Spring.Spring.Service.ExceptiiService;
import com.Spring.Spring.Service.ExceptiiService;
import jakarta.persistence.spi.PersistenceProviderResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:63342")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class ExceptiiController {
    @Autowired
    private ExceptiiService exceptiiService;

    @GetMapping("/exceptii")
    public List<ExceptiiEntity> getAllExceptii() {
        return exceptiiService.getAllExceptii();
    }

}
