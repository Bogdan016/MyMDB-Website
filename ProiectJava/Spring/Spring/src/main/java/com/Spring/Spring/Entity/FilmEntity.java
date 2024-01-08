package com.Spring.Spring.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "film")
@NoArgsConstructor
@AllArgsConstructor
public class FilmEntity {
    @Id
    @Column(name = "titlu")
    private String titlu;

    @Column(name = "an")
    private int an;

    @Column(name = "durata")
    private int durata;

    @Column(name = "gen")
    private String gen;


//     @Column(name = "studio")
//     private String studio;
//
//
//    @Column(name = "id_producator")
//    private int id_producator;

    @ManyToOne
    @JoinColumn(name = "studio", referencedColumnName = "nume")
    private StudioEntity studioEntity;


    @ManyToOne
    @JoinColumn(name = "id_producator", referencedColumnName = "id_persoana")
    private PersoanaEntity producator;
}
