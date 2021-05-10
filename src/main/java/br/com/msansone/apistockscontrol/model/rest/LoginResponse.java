package br.com.msansone.apistockscontrol.model.rest;

import br.com.msansone.apistockscontrol.model.dto.LoginDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponse  extends  AbstractResponse{

    @JsonProperty("login")
    private LoginDTO loginDTO;

    public LoginResponse(LoginDTO loginDTO) {
        this.loginDTO=loginDTO;
    }
}
