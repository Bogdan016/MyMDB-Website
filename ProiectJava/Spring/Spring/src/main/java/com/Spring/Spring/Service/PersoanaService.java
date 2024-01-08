package com.Spring.Spring.Service;

import com.Spring.Spring.Entity.PersoanaEntity;
import com.Spring.Spring.Repository.PersoanaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersoanaService {
    @Autowired
    private PersoanaInterface persoanaInterface;

    public PersoanaEntity saveDetails(PersoanaEntity entry) {
        return persoanaInterface.save(entry);

    }

    public List<PersoanaEntity> getDetails() {
        return persoanaInterface.findAll();
    }

    public List<PersoanaEntity> findByCastigNetGreaterThanAndMoneda(long castig_net, String moneda) {
        return persoanaInterface.findByCastigNetGreaterThanAndMoneda(castig_net, moneda);
    }

    public List<String> findLeastPaidActress() {
        return persoanaInterface.findLeastPaidActress();
    }

    public List<Object[]> findMoviesByGenre(String gen) {
        return persoanaInterface.findMoviesByGenre(gen);
    }

    public List<Object[]> findMinMaxEarnings() {
        return persoanaInterface.findMinMaxEarnings();
    }

}
