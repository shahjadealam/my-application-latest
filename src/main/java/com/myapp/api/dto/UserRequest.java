package com.myapp.api.dto;

import com.myapp.api.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {
  private User user;
}
