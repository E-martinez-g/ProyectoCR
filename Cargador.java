import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Cargador {

    private Cargador() {}

    public static ArrayList<Tarea> cargaT() {
        try {
            BufferedReader in = new BufferedReader(
				    new InputStreamReader(
					new FileInputStream("Tareas.txt"), "utf-8"));
            Tarea t = null;
            ArrayList<Tarea> tareas = new ArrayList<Tarea>();
            while ((t = Tarea.deseria(in.readLine())) != null)
                tareas.add(t);
            return tareas;
        } catch (IOException ioe) {
            System.err.println("Ocurrió un problema al cargar las tareas.");
	    System.exit(3);
	}
    }

    public static ArrayList<Usuario> cargaU() {
        try {
	    BufferedReader in = new BufferedReader(
				    new InputStreamReader(
					new FileInputStream("Usuarios.txt"), "utf-8"));
            Usuario u = null;
            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
            while ((u = Usuario.deseria(in.readLine())) != null)
                usuarios.add(u);
            return usuarios;
        } catch (IOException ioe) {
            System.err.println("Ocurrió un problema al cargar los usuarios.");
	    System.exit(3);
	}
    }

}
