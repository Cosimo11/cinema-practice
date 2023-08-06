package pm.practice.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pm.practice.cinema.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


}
