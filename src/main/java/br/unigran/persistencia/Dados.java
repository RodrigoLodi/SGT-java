package br.unigran.persistencia;

import br.unigran.model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Dados {
    EntityManagerFactory emf=
            Persistence.
                    createEntityManagerFactory("br.unigran_AtividadeProva_jar_1.0-SNAPSHOTPU");
    EntityManager em =emf.createEntityManager();
    EntityTransaction etx = em.getTransaction();
    
    public void salvar(Object o){
        etx.begin();
        em.persist(o);
        etx.commit();
    }
    public void atualiza(Object o){
        etx.begin();
        em.merge(o);
        etx.commit();
    }
     public void remove(Object o){
        etx.begin();
        em.remove(o);
        etx.commit();
    }
    public List listar(){
        return em.createNativeQuery("select * from User p",User.class)
                .getResultList();
    }
    public List listarOO(){
        return em.createNativeQuery("select p from User p")
                .getResultList();
    }
    
    public List Login(String campos, String tabela, String condicao) {
        return em.createNativeQuery("select " + campos + " from " + tabela + " " + condicao)
                .getResultList();
    }
    
}
