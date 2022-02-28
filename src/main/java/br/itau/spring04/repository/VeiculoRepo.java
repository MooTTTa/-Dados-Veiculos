package br.itau.spring04.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.itau.spring04.model.Veiculo;

@Repository
public interface VeiculoRepo extends CrudRepository <Veiculo, Integer> {
    
}
