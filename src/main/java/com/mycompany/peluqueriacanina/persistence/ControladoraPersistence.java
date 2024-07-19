
package com.mycompany.peluqueriacanina.persistence;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistence {
    MascotaJpaController mascoJpa=new MascotaJpaController();
    DuenioJpaController duenioJpa=new DuenioJpaController();

    public void guardar(Duenio duenio, Mascota masc) {
        //creacion del dueño en la DB
        duenioJpa.create(duenio);
        //creacion de la mascota en la DB
        mascoJpa.create(masc); //se hace primero el dueño porque Mascota tiene un objeto de tipo dueño
        
    }

    public List<Mascota> traerMascotas() {
        return mascoJpa.findMascotaEntities();
        
    }

    public void borrarMascota(int num_cliente) {
        try {
            mascoJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascota(int num_cliente) {
        return mascoJpa.findMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco) {
        try {
            mascoJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Duenio bringOwner(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio owner) {
        try {
            duenioJpa.edit(owner);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
