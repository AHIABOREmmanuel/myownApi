package lenuel.Apps.admin.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lenuel.Apps.admin.entity.Vehicule;

public interface VehiculeRepository  extends JpaRepository<Vehicule, Long> {

    @Query("SELECT v FROM Vehicule v WHERE v.trakingId = :x")
    Optional<Vehicule> findByTrakingId(@Param("x") UUID trakingId);

    @Query("SELECT v FROM Vehicule v ORDER BY v.modele")
    List<Vehicule>findAllVehiculesOrderedByVehicule();
}
