package pm.practice.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pm.practice.cinema.domain.Screening;

import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    List<Screening> findByOrderByScreeningDate();
    
    @Query("select distinct a.title from Screening a")
    List<String> findAllDistinctTitles();

    List<Screening> findByTitle(String title);

}
