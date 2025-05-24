import java.util.Scanner;
import java.util.ArrayList;

public class Classroom {
    
    private List<Usuario> usuarios;
    private List<Tarea> tareas;
    private Scanner escaner;
    
    public Classroom() {
	Cargador cargador = new Cargador();
	tareas = cargador.cargaTareas();
	usuarios = cargador.cargaUsuarios();
	escaner = new Scanner();
    }

    
    public void carga() {
	menuPrincipal();
    }

    private void menuPrincipal() {
	while (true) {
	    System.out.println("\n¡Bienvenido al sistema de administración de tareas!");
	    System.out.println("Elija una de las siguientes opciones:");
	    System.out.println("1. Iniciar Sesión.");
	    System.out.println("2. Salir.");
	    try {
		int opcion = escaner.nextInt();
		switch (opcion) {
		case 1 : logIn();
		    break;
		case 2 : gYS();
		    return;
		default : throw new InputMismatchException();
		}
	    } catch (InputMismatchException ime) {
		System.err.println("\nEsa no es una opción válida.");
	    }
	}
    }

    private void logIn() {
	System.out.println("\nIngresa tu nombre de usuario o apodo:");
	String usr = escaner.nextLine();
	Usuario usu;
	for (Usuario usuario : usuarios)
	    if (usuario.getNN().equals(usr) || usuario.getNombre().equals(usr))
		usu = usuario;
	if (usu == null) {
	    System.out.println("Ese usuario no existe.");
	    return;
	}
	System.out.println("\nIngresa tu contraseña:");
	if (usu.getPW.equals(scanner.nextLine()))
	    usu.menu(this);
	else
	    System.out.println("El usuario o la contraseña no son válidos.");
	return;
    }

    private void gYS() {
	Guardador guardador = new Guardador();
	guardador.guardaTareas(tareas);
	guardador.guardaUsuarios(usuarios);
    }
}
