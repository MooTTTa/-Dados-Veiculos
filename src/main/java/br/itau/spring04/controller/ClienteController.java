package br.itau.spring04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.spring04.dto.ClienteDTO;
import br.itau.spring04.model.Cliente;
import br.itau.spring04.repository.ClienteRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepo repo;

    @GetMapping
    public List<Cliente> ListarTodos(){
        List<Cliente> lista = (List<Cliente>) repo.findAll(); //casting
        return lista;
    }
    
    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<Cliente> buscarCliente (@PathVariable int codigo){
        Cliente cliente = repo.findById(codigo).orElse(null); // busca um cliente com esse codigo, e se nao encontrar preenche null

        if(cliente != null){ // achou o cliente 
            return ResponseEntity.ok(cliente); //ok = status 200
        }
        return ResponseEntity.notFound().build(); // notFound = retorna erro 404, sem conteudo 
    }

    @GetMapping("/cod/{codigo}")
    public ResponseEntity<ClienteDTO> buscarClienteResumo (@PathVariable int codigo){
        Cliente cliente = repo.findById(codigo).orElse(null); // busca um cliente com esse codigo, e se nao encontrar preenche null

        if(cliente != null){ // achou o cliente 
            ClienteDTO clienteDTO = new ClienteDTO(cliente);
            return ResponseEntity.ok(clienteDTO); //ok = status 200
        }
        return ResponseEntity.notFound().build(); // notFound = retorna erro 404, sem conteudo 
    }


    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente novoCliente){
        Cliente cliente = repo.save(novoCliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Cliente> apagar(@PathVariable int codigo){

        Cliente cliente = repo.findById(codigo).orElse(null);

        if(cliente != null){
            repo.delete(cliente);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/email")
    public ResponseEntity<Cliente> buscarPorEmail(@RequestBody Cliente clienteProcurado) {

        Cliente clienteEncontrado = repo.findByEmail(clienteProcurado.getEmail());

        if(clienteEncontrado != null) {  
             return ResponseEntity.ok(clienteEncontrado);
        }

        return ResponseEntity.notFound().build();
    }

}
