package net.dodo.hotel.repository;

import java.util.List;
import net.dodo.hotel.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

  List<Booking> findByRoomId(Long roomId);

  List<Booking> findByUserId(Long userId);

  List<Booking> findByBookConfirmationCode(String bookingConfirmationCode);

}