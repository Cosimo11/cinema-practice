package pm.practice.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pm.practice.cinema.domain.Screening;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    List<Screening> findByOrderByScreeningDate();

    @Query("select a from Screening a where a.id = :screeningId")
    Screening findScreeningById(@Param("screeningId") Long screeningId);

}
