package com.Spring.Spring.Repository;

import com.Spring.Spring.Entity.ExceptiiEntity;
import com.Spring.Spring.Entity.PersoanaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ExceptiiInterface extends JpaRepository<ExceptiiEntity, Long> {
    @Procedure("AdaugaExceptii")
    void callAdaugaExceptii();
}






