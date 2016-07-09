/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.codeshouse.locadora4.MB;

import br.com.codeshouse.locadora4.modelo.Categoria;
import br.com.codeshouse.locadora4.modelo.Filme;
import br.com.codeshouse.locadora4.util.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author asa
 */
@ManagedBean(name = "filmeMB")
public class FilmeMB {

    private Filme filme = new Filme();
    
    private int idCategoria;
    
    public void salvar() {
        System.err.println("========================================================================================================================================================================");
        System.out.println("Metodo Salvar Ivocado");
        EntityManager em = JPAUtil.getEntityManager();
        this.vinculaCategoriaComFilme();
        
        
        em.getTransaction().begin();
        em.persist(this.filme);
        em.getTransaction().commit();
        em.close();
        System.out.println("Cateogira " + this.filme.getTitulo() + " Salva com sucesso!");
        this.filme = new Filme();
        System.err.println("========================================================================================================================================================================");

    }

    public List<Categoria> getCategorias() {
        List<Categoria> lista = new ArrayList<>();
        EntityManager em = JPAUtil.getEntityManager();

        Query query = em.createQuery("Select c from Categoria c");

        lista = query.getResultList();
        
        return lista;
    }

    
    public List<Filme> getFilmes() {
        List<Filme> lista = new ArrayList<>();
        EntityManager em = JPAUtil.getEntityManager();

        Query query = em.createQuery("Select f from Filme f");

        lista = query.getResultList();
        
        return lista;
    }
    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    private void vinculaCategoriaComFilme() {
       Categoria c = new Categoria();
       c.setId(this.idCategoria);
       this.filme.setCategoria(c);
    }

    
}
