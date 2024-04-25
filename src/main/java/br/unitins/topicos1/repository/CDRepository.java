package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.CD;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CDRepository implements PanacheRepository<CD> {
    public PanacheQuery<CD> findByNome(String nome) {
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%" + nome.toUpperCase() + "%");
    }
    
}
