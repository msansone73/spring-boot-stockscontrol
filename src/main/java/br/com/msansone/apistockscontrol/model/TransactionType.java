package br.com.msansone.apistockscontrol.model;

public enum TransactionType {
    VENDA(0), COMPRA(1);

    private final int valor;
    TransactionType(int valorOpcao) {
        valor=valorOpcao;
    }
    public int getValor(){ return valor;}

}
