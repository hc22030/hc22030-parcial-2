package libcode.webapp.controladores;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import libcode.webapp.entidades.Materia;
import libcode.webapp.negocio.MateriaService;

@Named
@RequestScoped
public class MateriaController {

    private List<Materia> materiasList;

    private Materia materia = new Materia();

    @EJB
    MateriaService servicio;

    @PostConstruct
    public void cargarMaterias() {
        materiasList = servicio.getMaterias();
        if (materiasList == null) {
            materiasList = new ArrayList<>();
        }
    }

    public void guardarMateria() {
        if (materia.getId() != null) {
            servicio.editMateria(materia);
        } else {
            servicio.saveMateria(materia);
        }
        materia = new Materia();
        cargarMaterias();
    }

    public void llenarFormEditar(Materia materia) {
        this.materia.setId(materia.getId());
        this.materia.setNombre(materia.getNombre());
        this.materia.setDescripcion(materia.getDescripcion()); 
        this.materia.setCodigoMateria(materia.getCodigoMateria()); 
    }

    public void eliminarMateria(Materia materia) {
        servicio.deleteMateria(materia);
        cargarMaterias(); 
    }

    public List<Materia> getMateriasList() {
        return materiasList;
    }

    public void setMateriasList(List<Materia> materiasList) {
        this.materiasList = materiasList;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
