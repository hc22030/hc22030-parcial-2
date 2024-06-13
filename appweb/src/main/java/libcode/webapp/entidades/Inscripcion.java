package libcode.webapp.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import java.util.List;


@Entity
@Table(name = "inscripciones")
public class Inscripcion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscripciones_id_seq")
    @SequenceGenerator(name = "inscripciones_id_seq", sequenceName = "inscripciones_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idalumno", nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "idmateria", nullable = false)
    private Materia materia;

    @Column(name = "ciclo", nullable = false)
    private String ciclo;

    @Column(name = "anio", nullable = false)
    private int anio;

    @Column(name = "fechainscripcion", nullable = false)
    private LocalDate fechaInscripcion;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscripcion other = (Inscripcion) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "id=" + id + ", alumno=" + alumno + ", materia=" + materia + ", ciclo=" + ciclo + ", anio=" + anio + ", fechainscripcion=" + fechaInscripcion + "}";
    }

    public Inscripcion(Integer id) {
        this.id = id;
    }

    public Inscripcion(Integer id, Alumno alumno, Materia materia, String ciclo, int anio, LocalDate fechainscripcion) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
        this.ciclo = ciclo;
        this.anio = anio;
        this.fechaInscripcion = fechainscripcion;
    }

    public Inscripcion() {
    }

    public Inscripcion(Alumno alumno, Materia materia, String ciclo, int anio, LocalDate fechainscripcion) {
        this.alumno = alumno;
        this.materia = materia;
        this.ciclo = ciclo;
        this.anio = anio;
        this.fechaInscripcion = fechainscripcion;
    }

}
