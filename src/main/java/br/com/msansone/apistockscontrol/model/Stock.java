package br.com.msansone.apistockscontrol.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cod;
    private String name;
    private String description;

    @Enumerated(EnumType.ORDINAL)
    private StockType type;
}
