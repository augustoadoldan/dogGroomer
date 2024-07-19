
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

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }
    
    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    public void editarDatosMascota(Mascota masco, String nombreMasco, String razaMasco, String colorMasco, String observac, String alergico, String atenEsp, String nombreDuenio, String telDuenio) {
        masco.setNombrePerro(nombreMasco);
        masco.setRaza(razaMasco);
        masco.setColor(colorMasco);
        masco.setObservaciones(observac);
        masco.setAlergico(alergico);
        masco.setAtencionEspecial(atenEsp);
        //modificar mascota primero y despues el dueño
        controlPersis.modificarMascota(masco);
        //seteo nuevos valores del dueño
        Duenio owner = this.findOwner(masco.getDuenio_masc().getId_duenio());
        owner.setNombre(nombreDuenio);
        owner.setCelDuenio(telDuenio);
        this.modificarDuenio(owner);
    }

    private Duenio findOwner(int id_duenio) {
        return controlPersis.bringOwner(id_duenio);
        
    }

    private void modificarDuenio(Duenio owner) {
        controlPersis.modificarDuenio(owner);
    }
    
}
