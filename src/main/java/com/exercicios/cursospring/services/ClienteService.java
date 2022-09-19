package com.exercicios.cursospring.services;

import com.exercicios.cursospring.domain.Cliente;
import com.exercicios.cursospring.repositories.ClienteRepository;
import com.exercicios.cursospring.services.execptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+
                ", Tipo: "+Cliente.class.getName()));
    }
}
