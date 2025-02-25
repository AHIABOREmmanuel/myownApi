package lenuel.Apps.admin.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lenuel.Apps.admin.entity.Commissariat;
import lenuel.Apps.admin.entity.Engin;

public interface EnginRepository extends JpaRepository<Engin, Long> {

    @Query("SELECT e FROM Engin e WHERE e.trakingId = :x")
    Optional<Engin> findByTrakingId(@Param("x") UUID trakingId);

    @Query("SELECT e FROM Engin e ORDER BY e.immatriculation")
    List<Engin> findAllEnginOrderedByImmatriculation();
    
    @Query("SELECT e FROM Engin e WHERE e.immatriculation= :x ORDER BY e.immatriculation")
    List<Engin> findEnginOrderedByImmatriculation(@Param("x") String immatriculation);
}