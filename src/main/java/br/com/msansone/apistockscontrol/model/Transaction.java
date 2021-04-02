package br.com.msansone.apistockscontrol.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Account account;

    @ManyToOne(fetch = FetchType.EAGER)
    private Stock stock;

    private Long quantity;
    private BigDecimal unitPrice;

    @Enumerated(EnumType.ORDINAL)
    private TransactionType transactionType;
}
