/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.servicios;

import java.util.Date;
import java.util.List;
import mx.uacm.curso.dtos.PaisYEmocionPredominanteDTO;

public interface EstadisticasServicio {

    List<PaisYEmocionPredominanteDTO> emocionesPredominantesAgrupadasPorPais(List<String> hashtags, Date fechaMin, Date fechaMax);
}
