package com.Spring.Spring.Repository;

import com.Spring.Spring.Entity.PersoanaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersoanaInterface extends JpaRepository<PersoanaEntity, Long> {
    List<PersoanaEntity> findByCastigNetGreaterThanAndMoneda(long castig_net, String moneda);

    @Query("SELECT p.nume FROM PersoanaEntity p WHERE p.gender = 'F' AND p.castigNet = (SELECT MIN(p2.castigNet) FROM PersoanaEntity p2 WHERE p2.gender = 'F')")
    List<String> findLeastPaidActress();

    @Query(value = "SELECT P.id_persoana, P.nume, COUNT(*) AS numar_filme_SF\n" +
            "FROM Persoana P\n" +
            "JOIN Film F ON P.id_persoana = F.id_producator\n" +
            "WHERE F.gen = :gen\n" +
            "GROUP BY P.id_persoana, P.nume;\n", nativeQuery = true)
    List<Object[]> findMoviesByGenre(@Param("gen") String gen);

    @Query(value = "SELECT MIN(P.castig_net) AS castig_minim, " +
            "MAX(P.castig_net) AS castig_maxim FROM Persoana P JOIN Studio S ON P.id_persoana = S.id_presedinte", nativeQuery = true)
    List<Object[]> findMinMaxEarnings();

}



