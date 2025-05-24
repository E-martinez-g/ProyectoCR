import java.util.Scanner;
import mx.unam.ciencias.edd.Lista;

public class Classroom {
    
    private Lista<Usuario> usuarios;
    private Lista<Tarea> tareas;
    private Scanner escaner;
    
    public Classroom() {
	usuarios = new Lista<Usuario>();
	tareas = new Lista<Tarea>();
	escaner = new Scanner();
    }
    
}
