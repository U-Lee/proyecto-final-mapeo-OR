/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.daos.impl.HashtagDAOImpl;
import mx.uacm.curso.dtos.ConteoHashtagDTO;
import mx.uacm.curso.entidades.Hashtag;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HashtagDAOTest {

    private static EntityManager em;

    private static HashtagDAO hashtagDAO;

    private static ConteoHashtagDTO conteoHashtagDTO;

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
        hashtagDAO = new HashtagDAOImpl(em);
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
        Hashtag h = hashtagDAO.buscarPorId(2);
        Assertions.assertNotNull(h);
    }

    @Test
    public void probarMapeoHashtagTweet() {
        Hashtag h = hashtagDAO.buscarPorId(2);
        assertEquals(6, h.getTweets().size());
    }

    @Test
    public void obtenerTodosTest() {
        List<Hashtag> h = hashtagDAO.nombresHashtags();
        assertEquals(48, h.size());
    }

    @Test
    public void conteoHashtagDTO() {
        List<ConteoHashtagDTO> h = hashtagDAO.conteoHashtags();
        System.out.println("Hashtag con tweets:" + h);

        assertEquals(10, h.size());
    }

}
