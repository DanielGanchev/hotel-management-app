package net.dodo.hotel.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import lombok.Data;
import net.dodo.hotel.model.entity.Booking;

@Data
@JsonInclude(Include.NON_NULL)
public final class BookingDto {

  private  Long id;
  private  LocalDate checkInDate;
  private  LocalDate checkOutDate;
  private  int numberOfAdults;
  private  int numberOfChildren;
  private  int totalNumberOfGuests;
  private  String bookConfirmationCode;
  private  UserDto user;
  private  RoomDto room;




}