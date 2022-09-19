package com.exercicios.cursospring.services;

import com.exercicios.cursospring.domain.Pedido;
import com.exercicios.cursospring.repositories.PedidoRepository;
import com.exercicios.cursospring.services.execptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido find(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+
                ", Tipo: "+Pedido.class.getName()));
    }
}
