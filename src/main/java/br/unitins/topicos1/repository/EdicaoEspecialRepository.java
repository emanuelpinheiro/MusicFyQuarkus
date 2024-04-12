package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.EdicaoEspecial;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EdicaoEspecialRepository implements PanacheRepository<EdicaoEspecial>{
        
            public List<EdicaoEspecial> findByDescricao(String descricao) {
                return find("descricao", descricao).firstResult();
            }

            public List<EdicaoEspecial> findByConteudoAdicional(String conteudoAdicional) {
                return find("conteudoAdicional", conteudoAdicional).firstResult();
            }

            public List<EdicaoEspecial> findByPrecoExtra(Float precoExtra) {
                return find("precoExtra", precoExtra).firstResult();
            }
}
