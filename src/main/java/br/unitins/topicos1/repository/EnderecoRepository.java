package br.unitins.topicos1.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import br.unitins.topicos1.model.Endereco; 


@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco>{
    public PanacheQuery<Endereco> findByCep(String cep){
        if(cep == null)
            return null;
        return find("UPPER(cep) LIKE ?1 ", "%" + cep.toUpperCase() + "%");
    }
}
