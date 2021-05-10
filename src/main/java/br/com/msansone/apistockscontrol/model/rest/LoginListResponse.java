package br.com.msansone.apistockscontrol.model.rest;

import br.com.msansone.apistockscontrol.model.dto.LoginDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class LoginListResponse extends  AbstractResponse{

    List<LoginDTO> loginDTOList;

}
