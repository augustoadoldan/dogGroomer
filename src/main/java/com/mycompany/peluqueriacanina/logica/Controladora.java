
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistence.ControladoraPersistence;
import java.util.List;

public class Controladora {
    ControladoraPersistence controlPersis=new ControladoraPersistence();
    
    //funcion para el boton guardar
    public void guardar(String nombreMasco, String razaMasco, String colorMasco, String nombreDuenio, String telDuenio, String observac, String alergico, String atenEsp) {
        
        //carga de datos del duenio
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(telDuenio);
        //carga de datos de la mascota
        Mascota masc=new Mascota();
        masc.setNombrePerro(nombreMasco);
        masc.setRaza(razaMasco);
        masc.setColor(colorMasco);
        masc.setObservaciones(observac);
        masc.setAlergico(alergico);
        masc.setAtencionEspecial(atenEsp);
        masc.setDuenio_masc(duenio);
        
        controlPersis.guardar(duenio,masc);
        
    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
    }
    
}
