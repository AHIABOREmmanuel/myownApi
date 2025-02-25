package lenuel.Apps.admin.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import lenuel.Apps.admin.entity.Motif;

public interface MotifRepository  extends JpaRepository<Motif, Long> {

    @Query("SELECT m FROM Motif m WHERE m.trakingId = :x")
    Optional<Motif> findByTrakingId(@Param("x") UUID trakingId);

    @Query("SELECT m FROM Motif m ORDER BY m.motif")
    List<Motif> findAllMotifsOrderedByMotif ();
}
