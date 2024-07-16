package net.dodo.hotel.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;
import lombok.Builder;
import lombok.Data;
import net.dodo.hotel.model.entity.Booking;
import net.dodo.hotel.model.entity.User;

@Data
@JsonInclude(Include.NON_NULL)
public final class UserDto {

  private  Long id;
  private  String email;
  private  String name;
  private   String phoneNumber;
  private  String role;
  private  List<BookingDto> bookings;



}