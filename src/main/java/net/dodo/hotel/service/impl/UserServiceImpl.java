package net.dodo.hotel.service.impl;

import net.dodo.hotel.model.dto.LoginRequest;
import net.dodo.hotel.model.dto.Response;
import net.dodo.hotel.model.entity.User;
import net.dodo.hotel.service.interfc.UserService;

public class UserServiceImpl implements UserService {

  @Override
  public Response register(User loginRequest) {
    return null;
  }

  @Override
  public Response login(LoginRequest loginRequest) {
    return null;
  }

  @Override
  public Response getAllUsers() {
    return null;
  }

  @Override
  public Response getUserBookingHistory(String userId) {
    return null;
  }

  @Override
  public Response deleteUser(String userId) {
    return null;
  }

  @Override
  public Response getUserById(String userId) {
    return null;
  }

  @Override
  public Response getMyInfo(String userId) {
    return null;
  }
}
