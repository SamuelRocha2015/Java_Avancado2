package br.com.codeshouse.locadora4.MB;

import br.com.codeshouse.locadora4.modelo.Categoria;
import br.com.codeshouse.locadora4.util.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@ManagedBean(name = "categoriaMB")
public class CategoriaMB {

    private Categoria categoria = new Categoria();

    public void salvar() {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(this.categoria);
        em.getTransaction().commit();
        em.close();
        this.categoria = new Categoria();
    }

    public Categoria getCategoria() {
        return categoria;
    }

}
