package com.Spring.Spring.Controller;

import com.Spring.Spring.Entity.DistributieEntity;
import com.Spring.Spring.Service.DistributieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class DistributieController {

    @Autowired
    private DistributieService distributieService;

    @PostMapping("/addDistributie")
    public DistributieEntity postDetails(@RequestBody DistributieEntity entry) {
        return distributieService.saveDetails(entry);
    }

    @GetMapping("/getDistributie")
    public List<DistributieEntity> getDetails() {
        List<DistributieEntity> list = distributieService.getAllDetails();

        Comparator<DistributieEntity> comparator1 = Comparator.comparing(DistributieEntity::getAn_film);
        Comparator<DistributieEntity> comparator2 = Comparator.comparing(DistributieEntity::getTitlu_film);
        Comparator<DistributieEntity> compfinal = comparator1.thenComparing(comparator2);

        list.sort(compfinal);
        return list;
    }

    @GetMapping("/getActorPairs")
    public List<Object[]> getActorPairs() {
        return distributieService.findActorPairs();
    }
}
