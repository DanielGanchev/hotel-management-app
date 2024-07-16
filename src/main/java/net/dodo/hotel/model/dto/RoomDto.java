package net.dodo.hotel.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public final class RoomDto {

  private  Long id;
  private  String roomType;
  private  BigDecimal roomPrice;
  private  String roomPhotoUrl;
  private  String roomDescription;
  private  List<BookingDto> bookings;





}