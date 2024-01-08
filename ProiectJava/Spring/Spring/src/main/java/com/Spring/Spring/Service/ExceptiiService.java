package com.Spring.Spring.Service;

import com.Spring.Spring.Entity.ExceptiiEntity;
import com.Spring.Spring.Repository.ExceptiiInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExceptiiService {
    @Autowired
    private ExceptiiInterface exceptiiInterface;

    public List<ExceptiiEntity> getAllExceptii() {
        return exceptiiInterface.findAll();
    }
}
