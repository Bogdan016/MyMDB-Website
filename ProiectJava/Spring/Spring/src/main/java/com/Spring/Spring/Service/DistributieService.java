package com.Spring.Spring.Service;

import com.Spring.Spring.Entity.DistributieEntity;
import com.Spring.Spring.Repository.DistributieInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributieService {
    @Autowired
    private DistributieInterface distributieInterface;

    public DistributieEntity saveDetails(DistributieEntity entry) {
        return distributieInterface.save(entry);
    }

    public List<DistributieEntity> getAllDetails() {
        return distributieInterface.findAll();
    }

    public List<Object[]> findActorPairs() {
        return distributieInterface.findActorPairs();
    }
}
