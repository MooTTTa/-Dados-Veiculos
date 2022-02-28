package br.itau.spring04.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //indica que essa classe será armazenada no banco de dados
@Table(name = "tb_cliente")

public class Cliente {
    @Id // indica que a chave e primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1, 2, 3 ....
    private int codigo;

    @Column(name = "nome", length = 120, nullable = false) // nullable = campo obrigatorio 
    private String nome;
    
    @Column(length = 20)
    private String telefone;

    @Column(length = 20, nullable = false, unique = true) // unique não pode ter repetição
    private String email;

    @OneToMany(mappedBy = "proprietario")
    @JsonIgnoreProperties("proprietario")
    private List<Veiculo> veiculos;

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
    
}
