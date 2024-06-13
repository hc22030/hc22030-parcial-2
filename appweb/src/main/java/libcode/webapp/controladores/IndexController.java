package libcode.webapp.controladores;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import libcode.webapp.entidades.Alumno;
import libcode.webapp.negocio.DataService;

@Named
@RequestScoped
public class IndexController {

    private List<Alumno> alumnosList;
    
    private Alumno alumno = new Alumno();

    @EJB
    DataService servicio;

    @PostConstruct
    public void cargarAlumnos() {
        alumnosList = servicio.getAlumnos();
        if (alumnosList == null) {
            alumnosList = new ArrayList<>();
        }
    }
    
    public void guardarAlumno(){
        if (alumno.getId() != null){
            servicio.editAlumno(alumno);
        } else{
            servicio.saveAlumno(alumno);
        }
        alumno = new Alumno ();
        cargarAlumnos();
    }
    
    public void llenarFormEditar(Alumno alumno){
        this.alumno.setId(alumno.getId());
        this.alumno.setNombre(alumno.getNombre());
        this.alumno.setCarnet(alumno.getCarnet());
    }
    
    public void eliminarAlumno(Alumno alumno){
        servicio.deleteAlumno(alumno);
        cargarAlumnos();
    }
    
    
    public List<Alumno> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(List<Alumno> alumnosList) {
        this.alumnosList = alumnosList;
    }
    
    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
}
