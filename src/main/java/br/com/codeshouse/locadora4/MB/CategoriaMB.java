package br.com.codeshouse.locadora4.MB;

import br.com.codeshouse.locadora4.modelo.Categoria;
import br.com.codeshouse.locadora4.util.JPAUtil;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

@ManagedBean(name = "categoriaMB")
public class CategoriaMB {

    private Categoria categoria = new Categoria();

    public void salvar() {
        System.err.println("========================================================================================================================================================================");
        System.out.println("Metodo Salvar Ivocado");
//        JPAUtil jpa = new JPAUtil();
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(this.categoria);
        em.getTransaction().commit();
        em.close();
        System.out.println("Cateogira " + this.categoria.getNome() + " Salva com sucesso!");
        this.categoria = new Categoria();
        System.err.println("========================================================================================================================================================================");

    }

    public Categoria getCategoria() {
        return categoria;
    }

}
