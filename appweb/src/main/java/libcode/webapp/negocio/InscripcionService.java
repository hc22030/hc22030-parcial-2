/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.webapp.negocio;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import libcode.webapp.entidades.Inscripcion;

@Stateless
public class InscripcionService {
    
    @PersistenceContext(unitName = "pu")
    EntityManager entityManager;
    
    public List<Inscripcion> getAllInscripciones() {
        Query query = entityManager.createQuery("SELECT e FROM Inscripcion e ORDER BY e.id DESC");
        List<Inscripcion> inscripciones = query.getResultList();
        return inscripciones;
    }
    
    @Transactional
    public void guardarInscripcion(Inscripcion inscripcion) {
        entityManager.persist(inscripcion);
    }
    
    @Transactional
    public void editarInscripcion(Inscripcion inscripcion) {
        entityManager.merge(inscripcion);
    }
    
    @Transactional
    public void eliminarInscripcion(Inscripcion inscripcion) {
        Inscripcion inscripcionEliminar = entityManager.find(Inscripcion.class, inscripcion.getId());
        entityManager.remove(inscripcionEliminar);
    }
}
