/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.webapp.convertidores;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import libcode.webapp.entidades.Materia;
import libcode.webapp.negocio.MateriaService;

@Named
@FacesConverter(value = "materiaConverter", managed = true)
@ApplicationScoped
public class MateriaConverter implements Converter{

    @Inject
    private MateriaService materiaService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.isEmpty()) {
            List<Materia> materias = materiaService.getMaterias();
            for (Materia materia : materias) {
                if (String.valueOf(materia.getId()).equals(value)) {
                    return materia;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Materia) {
            return String.valueOf(((Materia) value).getId());
        }
        return null;
    }
}

