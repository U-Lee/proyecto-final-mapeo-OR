/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos.impl;

import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import mx.uacm.curso.daos.GenericDAO;


public abstract class GenericDAOImpl<T, PK> implements GenericDAO<T, PK> {

    protected EntityManager em;

    private Class<T> clase;

    public GenericDAOImpl(EntityManager em) {
        this.em = em;
        this.clase = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T buscarPorId(PK id) {
        return this.em.find(this.clase, id);
    }

    public T guardar(T a) {
        return this.em.merge(a);
    }

    public void remover(T a) {
        this.em.remove(a);
    }
}
