/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.codeshouse.locadora4.MB;

import br.com.codeshouse.locadora4.modelo.Categoria;
import br.com.codeshouse.locadora4.util.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author asa
 */
public class teste {

    public static void main(String[] args) {

        List<Categoria> lista = new ArrayList<>();
        EntityManager em = JPAUtil.getEntityManager();
        
     

        Query query = em.createQuery("Select c from Categoria c");

        lista = query.getResultList();

        for (Categoria categoria : lista) {
            System.out.println(categoria.getNome());
        }
    }
}
