package br.com.msansone.apistockscontrol.model.rest;

import br.com.msansone.apistockscontrol.model.dto.LoginDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

    private Long id;
    private String password;
    private String email;
    private String name;

    @JsonIgnore
    public LoginDTO getLoginDTO() {
        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setId(id);
        loginDTO.setName(name);
        loginDTO.setEmail(email);
        loginDTO.setPassword(password);

        return loginDTO;
    }
}
