package com.Spring.Spring.Repository;

import com.Spring.Spring.Entity.StudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudioInterface extends JpaRepository<StudioEntity, String> {
}
