/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.daos.impl.EmocionDAOImpl;
import mx.uacm.curso.dtos.EmocionPredominanteDTO;
import mx.uacm.curso.entidades.Emocion;
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
public class EmocionDAOTest {

    private static EntityManager em;

    private static EmocionDAO emocionDAO;

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
        emocionDAO = new EmocionDAOImpl(em);
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
        Emocion e = emocionDAO.buscarPorId(1);
        Assertions.assertNotNull(e);

        //Probar mapeo de Emocion a Tweet (1-1)
        assertEquals(1, e.getTweet().getId());
    }

    @Test
    public void emocionPredominantePorTweetsIds() {
        List<Integer> tweetsIds = new ArrayList<>();
        tweetsIds.add(1);
        tweetsIds.add(2);
        tweetsIds.add(3);
        tweetsIds.add(4);
        tweetsIds.add(5);

        EmocionPredominanteDTO e = emocionDAO.emocionPredominantePorTweetsIds(tweetsIds);

        assertEquals("animado", e.getEmocion());
        assertEquals(0.5999822, e.getPromedio());
    }

}
