package net.dodo.hotel.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

   private int status;
    private String message;
    private String token;
    private String role;
    private String expirationTime;
    private int totalNumberOfGuests;

    private String bookConfirmationCode;
    private UserDto user;
    private RoomDto room;

}
