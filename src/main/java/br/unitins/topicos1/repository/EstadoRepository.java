package br.unitins.topicos1.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

import br.unitins.topicos1.model.Estado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class EstadoRepository implements PanacheRepository<Estado> {
    
    public List<Estado> findByNome(String nome) {

        if (nome == null)
            return null;

        return find("FROM Estado WHERE UPPER(nome) LIKE UPPER(?1)", "%" + nome.toUpperCase() + "%").list();
    }

    public List<Estado> findBySigla(String sigla) {

        if (sigla == null)
            return null;

        return find("FROM Estado WHERE UPPER(sigla) LIKE UPPER(?1)", "%" + sigla.toUpperCase() + "%").list();
    }
}
