/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.daos.impl.PaisDAOImpl;
import mx.uacm.curso.entidades.Pais;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PaisDAOTest {

    private static EntityManager em;

    private static PaisDAO paisDAO;

    @AfterAll
    //ejecuta antes de todos los tests
    public static void antes() {
        System.out.println("iniciando tests");
    }

    @AfterAll
    //ejecuta despues de todos los tests
    public static void terminar() {
        System.out.println("tests terminados");
    }

    @BeforeAll
    public static void inicializar() throws Exception {
        System.out.println("inicializando..");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("base-proyecto-memoria");
        em = emf.createEntityManager();
        paisDAO = new PaisDAOImpl(em);
        System.out.println("inicializado");
    }

    @BeforeEach
    public void antesDeCadaTest() {
        System.out.println("antes del test");
        em.getTransaction().begin(); //iniciamos transaccion
    }

    @AfterEach
    public void despuesDeCadaTest() {
        em.flush();
        System.out.println("despues del test");
        em.getTransaction().rollback();
    }

    @Test
    public void buscarPorIdTest() throws Exception {
        Pais p = paisDAO.buscarPorId(2);
        Assertions.assertNotNull(p);

        //Propar mapeo de Pais a Lugar (1-n)
        assertEquals(12, p.getLugar().size());

    }

    @Test
    public void obtenPorTweetsIds() {
        List<Integer> tweetIds = new ArrayList<>();
        tweetIds.add(1);
        tweetIds.add(2);
        tweetIds.add(3);
        tweetIds.add(4);
        tweetIds.add(7);
        List<Pais> paises = paisDAO.obtenPorTweetsIds(tweetIds);
        assertEquals(3, paises.size());
    }

}
