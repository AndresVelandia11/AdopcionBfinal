import java.util.ArrayList;
import java.util.List;

public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private String documento;
    private List<Perro> perrosAdoptados;



    public Persona(String nombre, String apellido, int edad, String documento, List<Perro> perrosAdoptados) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.perrosAdoptados = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public List<Perro> getPerrosAdoptados() {
        return perrosAdoptados;
    }

    public void setPerrosAdoptados(List<Perro> perrosAdoptados) {
        this.perrosAdoptados = perrosAdoptados;
    }

    public boolean adoptarPerro(Perro perro){
        if (perrosAdoptados.size()<3){
            perrosAdoptados.add(perro);
            return true;
        }
        return false;
    }

    public Perro perroMasGrande(){
        if (perrosAdoptados.isEmpty()) return null;
        Perro Mayor = perrosAdoptados.get(0);
        for (Perro perro: perrosAdoptados){
            if(perro.getEdad()> Mayor.getEdad()){
                Mayor = perro;
            }
        }
        return Mayor;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", documento='" + documento + '\'' +
                ", perrosAdoptados=" + perrosAdoptados +
                '}';
    }
}
