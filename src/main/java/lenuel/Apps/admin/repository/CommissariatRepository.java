 package lenuel.Apps.admin.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lenuel.Apps.admin.entity.Commissariat;



public interface CommissariatRepository extends JpaRepository<Commissariat, Long> {

    @Query("SELECT c FROM Commissariat c WHERE c.trakingId = :x")
    Optional<Commissariat> findByTrakingId(@Param("x") UUID trakingId);

    @Query("SELECT c FROM Commissariat c ORDER BY c.arrondissement")
    List<Commissariat> findAllCommissariatsOrderedByArrondissement();
}
