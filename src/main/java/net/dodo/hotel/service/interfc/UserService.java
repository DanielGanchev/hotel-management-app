package net.dodo.hotel.service.interfc;

import net.dodo.hotel.model.dto.LoginRequest;
import net.dodo.hotel.model.dto.Response;
import net.dodo.hotel.model.entity.User;

public interface UserService {

  Response register(User loginRequest);

  Response login(LoginRequest loginRequest);

  Response getAllUsers();

  Response getUserBookingHistory(String userId);

  Response deleteUser(String userId);

  Response getUserById(String userId);

  Response getMyInfo(String userId);

}
