package net.dodo.hotel.repository;

import java.time.LocalDate;
import java.util.List;
import net.dodo.hotel.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

  @Query("SELECT DISTINCT r.roomType FROM Room r")
  List<String> findDistinctRoomTypes();

  @Query("SELECT r From Room r WHERE r.id NOT IN (SELECT b.room.id from Booking b)")
  List<Room> getAllAvailableRooms();


  @Query("SELECT r from Room r where r.roomType LIKE %:roomType% AND r.id NOT IN (SELECT bk.room.id from Booking bk WHERE"
      + "(bk.checkInDate <= :checkOutDate AND bk.checkOutDate >= :checkInDate))")
  List<Room> findAvailableRoomsByDateAndType(LocalDate checkInDate, LocalDate checkOutDate, String roomType);

}