package lenuel.Apps.admin.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import lenuel.Apps.admin.entity.Piece;

public interface PieceRepository  extends JpaRepository<Piece, Long> {

    @Query("SELECT p FROM Piece p WHERE p.trakingId = :x")
    Optional<Piece> findByTrakingId(@Param("x") UUID trakingId);

    @Query("SELECT p FROM Piece p ORDER BY p.piece")
    List<Piece> findAllPiecesOrdonnerParPiece();
}
