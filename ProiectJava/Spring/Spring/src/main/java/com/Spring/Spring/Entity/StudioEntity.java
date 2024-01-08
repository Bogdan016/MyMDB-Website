package com.Spring.Spring.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "studio")
@NoArgsConstructor
@AllArgsConstructor
public class StudioEntity {
    @Id
    @Column(name = "nume")
    private String nume;

    @Column(name = "adresa")
    private String adresa;

    // Remove this as we will be using the PersoanaEntity object
    // @Column(name = "id_presedinte")
    // private int id_presedinte;

    @ManyToOne
    @JoinColumn(name = "id_presedinte", referencedColumnName = "id_persoana")
    private PersoanaEntity presedinte;
}
