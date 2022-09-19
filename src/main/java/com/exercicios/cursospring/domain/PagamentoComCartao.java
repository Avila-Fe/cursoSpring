package com.exercicios.cursospring.domain;

import com.exercicios.cursospring.domain.enums.EstadoPagamento;

import javax.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento{

    private Integer numerosDeParcelas;

    public PagamentoComCartao(){
    }

    public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numerosDeParcelas) {
        super(id, estado, pedido);
        this.numerosDeParcelas = numerosDeParcelas;
    }

    public Integer getNumerosDeParcelas() {
        return numerosDeParcelas;
    }

    public void setNumerosDeParcelas(Integer numerosDeParcelas) {
        this.numerosDeParcelas = numerosDeParcelas;
    }
}
