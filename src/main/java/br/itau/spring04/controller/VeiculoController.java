package br.itau.spring04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.spring04.model.Veiculo;
import br.itau.spring04.repository.VeiculoRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepo repo;
    
    @GetMapping
    public List<Veiculo> ListarTodos(){
        List<Veiculo> lista = (List<Veiculo>) repo.findAll();
        return lista;
    }
}
