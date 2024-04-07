package br.unigran.persistencia;

import br.unigran.model.Task;
import br.unigran.model.Users;
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
   public List listarUsers(String condicao) {
        String queryString = "SELECT * FROM Users";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, Users.class)
                 .getResultList();
    }
   
   public List listarTask(String condicao) {
       String queryString = "SELECT * FROM Task";
       if (condicao != null && !condicao.isEmpty()) {
           queryString += " WHERE " + condicao;
       }
       return em.createNativeQuery(queryString, Task.class)
               .getResultList();
   }
    public List listarOO(){
        return em.createNativeQuery("select p from Users p")
                .getResultList();
    }
    
}
