/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso;

import java.io.*;
import java.util.*;
import javax.persistence.*;
//los siguientes paquetes requieren la dependencia de maven
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author iarobles
 */
public class ConsultorJPQLQueries {

    public static void main(String[] args) throws IOException {

        //Para usar la base de datos en memoria:
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("base-proyecto-memoria");
        //Para usar la base de datos "de verdad", comente la linea de arriba y descomente la siguiente linea.
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("base-pruebas");
        EntityManager em = emf.createEntityManager();
        escucharConsultas(em);
    }

    public static void escucharConsultas(EntityManager em) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (;;) {
            System.out.println("JPQL> ");
            String consulta = reader.readLine().replace(";", "");
            System.out.print("\n");
            if (consulta.equals("quitar")) {
                break;
            }
            if (consulta.length() == 0) {
                continue;
            }
            try {
                List resultado = em.createQuery(consulta).getResultList();
                System.out.println("\nResultados (" + resultado.size() + " renglones):\n");
                if (resultado.size() > 0) {
                    int count = 0;
                    for (Object o : resultado) {
                        System.out.println("Renglón " + (++count) + ": ");
                        imprimirResultado(o);
                    }
                } else {
                    System.out.println("0 resultados regresados");
                }

                System.out.print("\n");
            } catch (Exception e) {
                //imprimir el error en pantalla, pero continuar la ejecucion del programa
                e.printStackTrace();
            }
        }
    }

    private static void imprimirResultado(Object resultado) {
        if (resultado == null) {
            System.out.print("NULL");
        } else if (resultado instanceof Object[]) {
            Object[] renglon = (Object[]) resultado;
            System.out.print("[");
            for (Object columna : renglon) {
                //llamada recursiva para imprimir columnas del renglón
                imprimirResultado(columna);
            }
            System.out.print("]");
        } else if (resultado instanceof Long
                || resultado instanceof Double
                || resultado instanceof String) {
            System.out.print(resultado.getClass().getName() + ": " + resultado);
        } else {
            System.out.print(ReflectionToStringBuilder.toString(resultado,
                    ToStringStyle.SHORT_PREFIX_STYLE));
        }
        System.out.println();
    }
}
