package sgu_ucaju;

public class Docente extends Persona {

    public Docente(String nombre,
                   String apellido,
                   String dni) {

        super(nombre, apellido, dni);
    }

    @Override
    public void mostrarDatos() {

        System.out.println(
                "Docente: "
                + getNombre()
                + " "
                + getApellido());
    }
}