package br.com.hmb_user.dto;

import lombok.Data;
import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String cpf;
    private String login;
    private String password;
    private String token;
    private List<RoleDto> roles;

}
