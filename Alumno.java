package sgu_ucaju;

public class Alumno extends Persona {

    private String email;

    public Alumno(String nombre,
                  String apellido,
                  String dni,
                  String email) {

        super(nombre, apellido, dni);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void mostrarDatos() {

        System.out.println(
                "Alumno: "
                + getNombre()
                + " "
                + getApellido()
                + " - DNI: "
                + getDni());
    }
}