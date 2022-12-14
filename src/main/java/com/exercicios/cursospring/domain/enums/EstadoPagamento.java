package com.exercicios.cursospring.domain.enums;


public enum EstadoPagamento {

    PENDENTE(1, "Pagamento Pendente"),
    QUITADO(2, "Pagamento Quitado"),
    CANCELADO(3, "Pagamento Cancelado");

    private int cod;
    private String desc;

    EstadoPagamento() {

    }

    EstadoPagamento(int cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public int getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }

    public static EstadoPagamento toEnum(Integer cod){
        if (cod == null){
            return null;
        }

        for (EstadoPagamento x : EstadoPagamento.values()) {
            if (cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: "+ cod);
    }
}
