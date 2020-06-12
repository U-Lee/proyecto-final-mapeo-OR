/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.daos.impl.TweetDAOImpl;
import mx.uacm.curso.entidades.Pais;
import mx.uacm.curso.entidades.Tweet;
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
public class TweetDAOTest {

    private static EntityManager em;

    private static TweetDAO tweetDAO;

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
        tweetDAO = new TweetDAOImpl(em);
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
        Tweet t1 = tweetDAO.buscarPorId(1);
        Assertions.assertNotNull(t1);

        //Probar mapeo de Tweet a Usuario (n-1)
        assertEquals(1, t1.getId());

        //Probar mapeo de Tweet a Hashtag (n-n)
        Tweet t2 = tweetDAO.buscarPorId(2);
        assertEquals(5, t2.getHashtags().size());

        //Probar mapeo de Tweet a Lugar (1-1)
        assertEquals(1, t1.getLugar().getId());

        //Probar mapeo de Tweet a Emocion (1-1)
        assertEquals(1, t1.getEmocion().getId());
    }

    @Test
    public void tweetsPorHashtags() {
        List<String> nombresHashtags = new ArrayList<>();
        nombresHashtags.add("github");
        nombresHashtags.add("gitlab");
        List<Tweet> t = tweetDAO.tweetsPorHashtags(nombresHashtags);
        assertEquals(7, t.size());

    }

    @Test
    public void tweetsIdsPorHashtagsYFecha() {
        List<String> nombresHashtags = new ArrayList<>();
        nombresHashtags.add("github");
        nombresHashtags.add("gitlab");
        //Los meses inician desde 0(enero)
        //2020/febrero/01 = 2020-02-01(jpql) = 2020-01-01(GregorianCalendar)
        GregorianCalendar cal = new GregorianCalendar(2020, 01, 01);
        Date fechaMinima = cal.getTime();
        //2020/marzo/10 = 2020-03-10(jpql) = 2020-02-10(GregorianCalendar)
        GregorianCalendar cal2 = new GregorianCalendar(2020, 02, 10);
        Date fechaMaxima = cal2.getTime();
        //System.out.println("fechaMin" + fechaMinima);
        //System.out.println("fechaMax" + fechaMaxima);
        List<Integer> listaIds = tweetDAO.tweetsIdsPorHashtagsYFecha(nombresHashtags, fechaMinima, fechaMaxima);
        assertEquals(2, listaIds.size());
    }

    @Test
    public void filtrarTweetsIdsPorPais() {
        List<Integer> filtarTweetsIdsPorPais = new ArrayList<>();
        filtarTweetsIdsPorPais.add(1);
        filtarTweetsIdsPorPais.add(2);
        filtarTweetsIdsPorPais.add(4);
        filtarTweetsIdsPorPais.add(5);
        filtarTweetsIdsPorPais.add(7);
        Pais pais = new Pais();
        pais.setId(2);
        List<Integer> listaIds = tweetDAO.filtrarTweetsIdsPorPais(filtarTweetsIdsPorPais, pais);
        assertEquals(3, listaIds.size());
    }
}
