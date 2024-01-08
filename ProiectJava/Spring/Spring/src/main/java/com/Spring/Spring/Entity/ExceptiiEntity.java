package com.Spring.Spring.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "exceptii")
@NoArgsConstructor
@AllArgsConstructor
public class ExceptiiEntity {
    @Id
    @Column(name = "id_persoana")
    private long id_persoana;

    @Column(name = "nume")
    private String nume;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "sex")
    private char gender;

    @Column(name = "data_nasterii")
    private Date data;

    @Column(name = "castig_net")
    private Long castigNet;

    @Column(name = "moneda")
    private String moneda;

    @Column(name = "natura_exceptiei")
    private String naturaExceptiei;
}
