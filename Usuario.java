import java.io.IOException;

public abstract class Usuario {

    protected static int generaID = 0;
    protected static ListaDeTareas lDT = null;
    protected int iD;
    protected String nombre;
    protected String apodo;
    protected String correo;
    protected String contrasena;
    protected Scanner escaner;
    
    protected Usuario(String nombre, String apodo, String correo, String contrasena) {
	iD = generaID++;
	this.nombre = nombre;
	this.apodo = apodo;
	this.correo = correo;
	this.contrasena = contrasena;
	escaner = new Scanner(System.in);
    }

    protected Usuario(int iD, String nombre, String apodo, String correo, String contrasena) {
	this iD = iD;
	this.nombre = nombre;
	this.apodo = apodo;
	this.correo = correo;
	this.contrasena = contrasena;
	escaner = new Scanner(System.in);
    }

    public static void setLTD(ListaDeTareas lDT) {
	this.lDT = lDT;
	int gID = 0;
	for (Usuario u : lDT.getUsuarios())
	    if (u.getID() > gID)
		gID = u.getID();
	generaID = gID + 1;
    }

    public int getID() {
	return iD;
    }

    public String getNombre() {
	return nombre;
    }

    public String getNN() {
	return apodo;
    }

    public String getCorreo() {
	return correo;
    }

    public String getContrasena() {
	return contrasena;
    }

    public static Usuario deseria(String seriado) throws IOException {
	String[] a = seriado.split("\t");
	if (a.length != 6)
	    throw new IOException();
	switch (a[5]) {
	case "inv" : return deseriaInv(a);
	case "des" : return deseriaDes(a);
	case "adm" : return deseriaAdm(a);
	default : throw new IOException();
	}
    }

    private static Invitado deseriaInv(String[] a) {
	try {
	    int iD = Integer.parseInt(a[0]);
	    return new Invitado(iD, a[1], a[2], a[3], a[4]);
	} catch (InputMismatchException ime) {
	    throw new IOException();
	}
    }
    
    private static Desarrollador deseriaDes(String[] a) {
	try {
	    int iD = Integer.parseInt(a[0]);
	    return new Desarrollador(iD, a[1], a[2], a[3], a[4]);
	} catch (InputMismatchException ime) {
	    throw new IOException();
	}
    }
    
    private static Administrador deseriaAdm(String[] a) {
	try {
	    int iD = Integer.parseInt(a[0]);
	    return new Administrador(iD, a[1], a[2], a[3], a[4]);
	} catch (InputMismatchException ime) {
	    throw new IOException();
	}
    }

    protected void verTareas() {
	if (lDT.getTareas().isEmpty())
	    System.out.println("No hay tareas en el sistema.");
	else {
	    for (Tarea tarea : lDT.getTareas())
		System.out.println(tarea);
	    while (true) {
		System.out.println("\n¿Desea filtrar las tareas?");
		System.out.println("1. Filtrar por estado.");
		System.out.println("2. Filtrar por usuario.");
		System.out.println("3. Salir");
		switch (escaner.nextLine()) {
		case "1" : filtroEstado();
		    break;
		case "2" : filtroUsuario();
		    break;
		case "3" : return;
		default : System.out.println("\nEsa opción no es válida.");
		}
	    }
	}
    }

    private void filtroEstado() {
	while (true) {
	    System.out.println("\n¿Qué estado está buscando?");
	    System.out.println("1. Pendiente.");
	    System.out.println("2. En curso");
	    System.out.println("3. Completada.");
	    System.out.println("4. Salir")
	    switch (escaner.nextLine()) {
	    case "1" : fPE("Pendiente");
		break;
	    case "2" : fPE("En curso");
		break;
	    case "3" : fPE("Completada");
		break;
	    case "4" : return;
	    default : System.out.println("\nEsa opción no es válida.");
	    }
	}
    }

    private void filtroUsuario() {
	while (true) {
	    System.out.println("Ingrese el nombre o el apodo del usuario que busca.");
	    fPU(escaner.nextLine());
	}
    }
    
    protected void fPU(String nONN) {
	for (Tarea tarea : lDT.getTareas())
	    if (nONN.equals(tarea.getUsuario().getNombre()) ||
		nONN.equals(tarea.getUsuario().getNN()))
		System.out.println(tarea);
    }

    protected void fPE(String estado) {
	for (Tarea tarea : lDT.getTareas())
	    if (estado.equals(tarea.getEstado()))
		System.out.println(tarea);
    }

    public abstract String seria();

    public abstract void menu();
}
