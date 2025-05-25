import java.util.Scanner;
import java.util.ArrayList;

public class ListaDeTareas {
    
    private ArrayList<Usuario> usuarios;
    private ArrayList<Tarea> tareas;
    private Scanner escaner;
    
    public ListaDeTareas() {
	tareas = Cargador.cargaT();
	usuarios = Cargador.cargaU();
	escaner = new Scanner(System.in);
	Usuario.setLDT(this);
    }
    
    public void inicia() {
	if (usuarios.isEmpty())
	    nuevoUsuario();
	if (!usuarios.isEmpty())
	    menuPrincipal();
    }
    
    private void nuevoUsuario() {
	while (true) {
	    System.out.println("\nNo existe ningún usuario, ¿desea registrarse como administrador? [s/n]");
	    switch (escaner.nextLine()) {
	    case "s" : registraAdmin();
		break;
	    case "n" : return;
	    default  : System.out.println("\nEsa no es una opción válida.");
	    }
	}
    }
    
    private void registraAdmin() {
	System.out.println("\nIngrese su nombre:\n");
	String nombre = escaner.nextLine();
	System.out.println("\nIngrese su apodo:\n");
	String apodo = escaner.nextLine();
	String correo;
	while (true) {
	    System.out.println("\nIngrese su correo electrónico:\n");
	    correo = escaner.nextLine();
	    if (Administrador.correoValido(correo))
		break;
	}
	System.out.println("\nIngrese su contraseña:\n");
	String contrasena = escaner.nextLine();
	Administrador nuevo = new Administrador(nombre, apodo, correo, contrasena);
	usuarios.add(nuevo);
	nuevo.setLDT(this);
    }
    
    private void menuPrincipal() {
	while (true) {
	    System.out.println("\n¡Bienvenida/o al sistema de administración de tareas!");
	    System.out.println("Elija una de las siguientes opciones:");
	    System.out.println("1. Iniciar Sesión.");
	    System.out.println("2. Salir.");
	    try {
		switch (escaner.nextInt()) {
		case 1 : logIn();
		    break;
		case 2 : save();
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
	    System.out.println("\nEse usuario no existe.");
	    return;
	}
	System.out.println("\nIngresa tu contraseña:");
	if (usu.getPW.equals(scanner.nextLine()))
	    usu.menu(this);
	else
	    System.out.println("\nEl usuario o la contraseña no son válidos.");
    }
    
    private void save() {
	Guardador.guardaT(tareas);
	Guardador.guardaU(usuarios);
    }

    public ArrayList<Usuario> getUsuarios() {
	return usuarios;
    }

    public ArrayList<Tarea> getTareas() {
	return tareas;
    }
}
