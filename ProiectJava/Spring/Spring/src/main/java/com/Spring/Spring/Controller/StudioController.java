package com.Spring.Spring.Controller;

import com.Spring.Spring.Entity.DistributieEntity;
import com.Spring.Spring.Entity.StudioEntity;
import com.Spring.Spring.Service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
public class StudioController {
    @Autowired
    private StudioService studioService;

    @PostMapping("/addStudio")
    public StudioEntity postDetails(@RequestBody StudioEntity entry) {
        return studioService.saveDetails(entry);
    }

    @GetMapping("/getStudio")
    public List<StudioEntity> getDetails() {
        return studioService.getDetails();
    }

}
