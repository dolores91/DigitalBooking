package pfig3.bookingg3.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfig3.bookingg3.model.entity.Booking;

import java.util.List;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Long> {
    public List<Booking> findByUserId(Long userId);
}
