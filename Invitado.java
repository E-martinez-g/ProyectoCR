public class Invitado {

    public Invitado(String nombre, String apodo, String correo, String contrasena) {
	super(nombre, apodo, correo, contrasena);
    }

    public Invitado(int iD, String nombre, String apodo, String correo, String contrasena) {
	super(iD, nombre, apodo, correo, contrasena);
    }

    @Override
    public String seria() {
	String s = iD + "\t" + nombre + "\t";
	s += apodo + "\t" + correo + "\t";
	s += contrasena + "\tinv";
	return s;
    }

    @Override
    public void menu() {
	while (true) {
	    System.out.println("\n¡Bienvenida/o, " + nombre + "!");
	    System.out.println("A continuación elige qué acción deseas realizar:");
	    System.out.println("1. Ver tareas.");
	    System.out.println("2. Salir");
	    switch (escaner.nextLine()) {
	    case "1" : verTareas();
		break;
	    case "2" : return;
	    default : System.out.println("Esa no es una opción válida.");
	    }
	}
    }
}
