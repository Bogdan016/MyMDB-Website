package com.Spring.Spring.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "distributie")
@NoArgsConstructor
@AllArgsConstructor
public class DistributieEntity {
    @Id
    @Column(name = "titlu_film")
    private String titlu_film;

    @Column(name = "an_film")
    private int an_film;

    @Column(name = "id_actor")
    private int id_actor;
}
