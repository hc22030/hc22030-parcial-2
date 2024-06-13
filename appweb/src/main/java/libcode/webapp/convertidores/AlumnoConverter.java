/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.webapp.convertidores;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import libcode.webapp.entidades.Alumno;
import libcode.webapp.negocio.DataService;
import java.util.List;

@Named
@FacesConverter(value="alumnoConverter", managed = true)
@ApplicationScoped
public class AlumnoConverter implements Converter {

    @Inject
    private DataService dataService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.isEmpty()) {
            List<Alumno> alumnos = dataService.getAlumnos();
            for (Alumno alumno : alumnos) {
                if (String.valueOf(alumno.getId()).equals(value)) {
                    return alumno;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Alumno) {
            return String.valueOf(((Alumno) value).getId());
        }
        return null;
    }
}
