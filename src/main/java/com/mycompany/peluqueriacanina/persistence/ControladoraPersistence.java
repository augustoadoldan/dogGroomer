
package com.mycompany.peluqueriacanina.persistence;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import java.util.List;

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
}
