package com.exercicios.cursospring.services;

import com.exercicios.cursospring.domain.Categoria;
import com.exercicios.cursospring.repositories.CategoriaRepository;
import com.exercicios.cursospring.services.execptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+
                ", Tipo: "+Categoria.class.getName()));
    }
}
