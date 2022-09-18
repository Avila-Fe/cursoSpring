package com.exercicios.cursospring;

import com.exercicios.cursospring.domain.*;
import com.exercicios.cursospring.domain.enums.TipoCliente;
import com.exercicios.cursospring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository catRepo;

    @Autowired
    private ProdutoRepository prodRepo;

    @Autowired
    private EstadoRepository estRepo;

    @Autowired
    private CidadeRepository cidRepo;

    @Autowired
    private ClienteRepository cliRepo;

    @Autowired
    private EnderecoRepository endRepo;

    public static void main(String[] args) {
        SpringApplication.run(CursoSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null,"Informática");
        Categoria cat2 = new Categoria(null,"Escritório");

        Produto p1 = new Produto(null,"Computador", 2000.00);
        Produto p2 = new Produto(null,"Impressora", 800.00);
        Produto p3 = new Produto(null,"Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        catRepo.saveAll(Arrays.asList(cat1, cat2));
        prodRepo.saveAll(Arrays.asList(p1,p2,p3));

        Estado est1 = new Estado(null,"Minas Gerais");
        Estado est2 = new Estado(null,"São Paulo");

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2,c3));

        estRepo.saveAll(Arrays.asList(est1, est2));
        cidRepo.saveAll(Arrays.asList(c1, c2, c3));

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com",
                "363.789.123-77", TipoCliente.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

        Endereco e1 = new Endereco(null, "Rua Flores", "300",
                "Apto 300", "Jardim", "38220-834", cli1, c1);

        Endereco e2 = new Endereco(null, "Avenida Matos", "105",
                "Sala 800", "Centro", "38777-012", cli1, c2);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

        cliRepo.saveAll(Arrays.asList(cli1));
        endRepo.saveAll(Arrays.asList(e1, e2));

    }
}
