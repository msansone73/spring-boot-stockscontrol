package br.com.msansone.apistockscontrol.model.dto;
import br.com.msansone.apistockscontrol.model.Login;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginDTO {

    private Long id;
    private String password;
    private String email;
    private String name;

    public LoginDTO(Login login) {
        this.id=login.getId();
        this.password = login.getPassword();
        this.email = login.getEmail();
        this.name = login.getName();
    }

    @JsonIgnore
    public Login getDBLogin(){
        Login login = new Login();
        login.setId(this.id);
        login.setName(this.name);
        login.setEmail(this.email);
        login.setPassword(this.password);
        return login;
    }
}
