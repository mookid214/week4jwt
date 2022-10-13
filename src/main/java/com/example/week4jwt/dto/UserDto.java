package com.example.week4jwt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import com.example.week4jwt.entity.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

   @NotNull(message = "아이디는 Null일 수 없습니다.")
   @NotBlank(message = "아이디는 공백일 수 없습니다.")
   @Pattern(regexp="[a-zA-Z1-9]{4,12}", message = "아이디는 4-12 개의 영문자와 숫자만 허용합니다.")
   private String username;

   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   @NotNull(message = "패스워드는 Null일 수 없습니다.")
   @NotBlank(message = "패스워드는 공백일 수 없습니다.")
   @Pattern(regexp="[a-zA-Z1-9]{4,32}", message = "패스워드는 4-32 개의 영문자와 숫자만 허용합니다.")
   private String password;

   @NotNull
   @Size(min = 3, max = 50)
   private String nickname;

   private String passwordCheck;

   private Set<AuthorityDto> authorityDtoSet;

   public static UserDto from(User user) {
      if(user == null) return null;

      return UserDto.builder()
              .username(user.getUsername())
              .nickname(user.getNickname())
              .authorityDtoSet(user.getAuthorities().stream()
                      .map(authority -> AuthorityDto.builder().authorityName(authority.getAuthorityName()).build())
                      .collect(Collectors.toSet()))
              .build();
   }
}