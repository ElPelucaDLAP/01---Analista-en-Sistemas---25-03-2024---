import org.w3c.dom.ls.LSOutput;

public class Estudiantes {
    String nombre;
    String apellido;
    int edad;
    double nota;

    public Estudiantes(String nombre, String apellido, int edad, double nota) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public double getNota() {
        return nota;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String toString() {
        return ("Nombre: " + getNombre() + "\n" +
                "Apellido: " + getApellido() + "\n" +
                "Edad: " + getEdad() + "\n" +
                "Nota: " + getNota());
    }

}
