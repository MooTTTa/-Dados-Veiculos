package br.itau.spring04.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.itau.spring04.model.Cliente;

@Repository
public interface ClienteRepo extends CrudRepository<Cliente, Integer> {
    public Cliente findByEmail(String email);
}
