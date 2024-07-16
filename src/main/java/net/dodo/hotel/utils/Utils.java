package net.dodo.hotel.utils;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;
import net.dodo.hotel.model.dto.BookingDto;
import net.dodo.hotel.model.dto.RoomDto;
import net.dodo.hotel.model.dto.UserDto;
import net.dodo.hotel.model.entity.Booking;
import net.dodo.hotel.model.entity.Room;
import net.dodo.hotel.model.entity.User;

public class Utils {

  private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  private static final SecureRandom secureRandom = new SecureRandom();

  private static String generateRandomAlphaNumeric(int length) {
    StringBuilder builder = new StringBuilder();
   for (int i = 0; i < length; i++) {
      int randomIndex = secureRandom.nextInt(ALPHA_NUMERIC_STRING.length());
      builder.append(ALPHA_NUMERIC_STRING.charAt(randomIndex));
    }
    return builder.toString();
  }

  public static UserDto mapUserEntityToUserDTO(User user) {

     UserDto userDto = new UserDto();
    userDto.setId(user.getId());
    userDto.setEmail(user.getEmail());
    userDto.setName(user.getName());
    userDto.setPhoneNumber(user.getPhoneNumber());
    userDto.setRole(user.getRole());
    return userDto;
  }

  public static UserDto mapUserEntityToUserDTOplusBookingsAndRoom(User user) {

    UserDto userDto = new UserDto();
    userDto.setId(user.getId());
    userDto.setEmail(user.getEmail());
    userDto.setName(user.getName());
    userDto.setPhoneNumber(user.getPhoneNumber());
    userDto.setRole(user.getRole());

    if (!user.getBookings().isEmpty()) {
      userDto.setBookings(user.getBookings().stream()
          .map(booking -> mapBookingEntityToBookingDtoPlusBookedRoom(booking, false))
          .collect(Collectors.toList()));
    }
    return userDto;

  }

 public static RoomDto mapRoomEntityToRoomDto(Room room) {
   RoomDto roomDto = new RoomDto();
    roomDto.setId(room.getId());
    roomDto.setRoomType(room.getRoomType());
    roomDto.setRoomPrice(room.getRoomPrice());
    roomDto.setRoomPhotoUrl(room.getRoomPhotoUrl());
    roomDto.setRoomDescription(room.getRoomDescription());
    return roomDto;
  }

  public static RoomDto mapRoomEntityToRoomDtoPlusBookings(Room room) {
    RoomDto roomDto = new RoomDto();
    roomDto.setId(room.getId());
    roomDto.setRoomType(room.getRoomType());
    roomDto.setRoomPrice(room.getRoomPrice());
    roomDto.setRoomPhotoUrl(room.getRoomPhotoUrl());
    roomDto.setRoomDescription(room.getRoomDescription());
    if (!room.getBookings().isEmpty()) {
      roomDto.setBookings(room.getBookings().stream()
          .map(Utils::mapBookingEntityToBookingDto)
          .collect(Collectors.toList()));
    }
    return roomDto;
  }

  public static BookingDto mapBookingEntityToBookingDto(Booking booking) {
   BookingDto bookingDto = new BookingDto();
    bookingDto.setId(booking.getId());
    bookingDto.setCheckInDate(booking.getCheckInDate());
    bookingDto.setCheckOutDate(booking.getCheckOutDate());
    bookingDto.setNumberOfAdults(booking.getNumberOfAdults());
    bookingDto.setNumberOfChildren(booking.getNumberOfChildren());
    bookingDto.setTotalNumberOfGuests(booking.getTotalNumberOfGuests());
    bookingDto.setBookConfirmationCode(booking.getBookConfirmationCode());
    return bookingDto;
  }

  public static BookingDto mapBookingEntityToBookingDtoPlusBookedRoom(Booking booking, boolean includeUser) {
    BookingDto bookingDto = new BookingDto();
    bookingDto.setId(booking.getId());
    bookingDto.setCheckInDate(booking.getCheckInDate());
    bookingDto.setCheckOutDate(booking.getCheckOutDate());
    bookingDto.setNumberOfAdults(booking.getNumberOfAdults());
    bookingDto.setNumberOfChildren(booking.getNumberOfChildren());
    bookingDto.setTotalNumberOfGuests(booking.getTotalNumberOfGuests());
    bookingDto.setBookConfirmationCode(booking.getBookConfirmationCode());
    if (includeUser && booking.getUser() != null) {
      bookingDto.setUser(mapUserEntityToUserDTO(booking.getUser()));
    }
    if (booking.getRoom() != null) {
      RoomDto roomDto = mapRoomEntityToRoomDto(booking.getRoom());

    }
    return bookingDto;
  }

  public static List<UserDto> mapUserListToUserDtoList(List<User> users) {
    return users.stream().map(Utils::mapUserEntityToUserDTO).collect(Collectors.toList());
  }

  public static List<RoomDto> mapRoomListToRoomDtoList(List<Room> rooms) {
    return rooms.stream().map(Utils::mapRoomEntityToRoomDto).collect(Collectors.toList());
  }

  public static List<BookingDto> mapBookingListToBookingDtoList(List<Booking> bookings) {
    return bookings.stream().map(Utils::mapBookingEntityToBookingDto).collect(Collectors.toList());
  }

  }



