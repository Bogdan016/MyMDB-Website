package com.Spring.Spring.Repository;

import com.Spring.Spring.Entity.DistributieEntity;
import com.Spring.Spring.Entity.PersoanaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DistributieInterface extends JpaRepository<DistributieEntity, String> {
    @Query(value = "    SELECT P1.nume as nume_actrita, P1.id_persoana AS id_actrita, P2.nume as nume_actor,  P2.id_persoana AS id_actor\n" +
            "        FROM Distributie D1\n" +
            "        JOIN Distributie D2 ON D1.titlu_film = D2.titlu_film AND D1.an_film = D2.an_film\n" +
            "        JOIN Persoana P1 ON D1.id_actor = P1.id_persoana\n" +
            "        JOIN Persoana P2 ON D2.id_actor = P2.id_persoana\n" +
            "        WHERE P1.sex != P2.sex AND P1.id_persoana < P2.id_persoana;", nativeQuery = true)
    List<Object[]> findActorPairs();
}
