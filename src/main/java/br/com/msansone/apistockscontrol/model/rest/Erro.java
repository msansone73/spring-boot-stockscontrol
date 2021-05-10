package br.com.msansone.apistockscontrol.model.rest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Erro {
    private Long id;
    private String description;

    public Erro(Long id, String message) {
        this.id=id;
        this.description=message;
    }
}
