package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Faixa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FaixaRepository implements PanacheRepository<Faixa>{
    public List<Faixa> findByName(String nome){
    return find("nome LIKE ?1", "%"+nome+"%").list();
}
}
