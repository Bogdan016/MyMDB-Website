package com.Spring.Spring.Service;

import com.Spring.Spring.Controller.StudioController;
import com.Spring.Spring.Entity.StudioEntity;
import com.Spring.Spring.Repository.StudioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioService {
    @Autowired
    private StudioInterface studioInterface;

    public StudioEntity saveDetails(StudioEntity entry) {
        return studioInterface.save(entry);

    }

    public List<StudioEntity> getDetails() {
        return studioInterface.findAll();
    }


}
