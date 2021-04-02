package br.com.msansone.apistockscontrol.model;

public enum StockType {

    STOCK(1), FII(2);

    private final int valor;
    StockType(int valorOpcao){
        valor = valorOpcao;
    }
    public int getValor(){
        return valor;
    }

}
