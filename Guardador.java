import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Guardador {

    private Guardador() {}

    public static void guardaT(ArrayList<Tarea> tareas) {
        try {
	    BufferedWriter out = new BufferedWriter(
				     new OutputStreamWriter(
					 new FileOutputStream("Tareas.txt"), "utf-8"));
	    for (Tarea t : tareas)
                out.write(t.seria());
            out.flush();
            out.close();
        } catch (IOException ioe) {
            System.err.println("\nOcurrió un problema al guardar las tareas");
	    System.exit(4);
        }
    }

    public static void guardaU(ArrayList<Usuario> usuarios) {
        try {
	    BufferedWriter out = new BufferedWriter(
				     new OutputStreamWriter(
					 new FileOutputStream("Usuarios.txt"), "utf-8"));
	    for (Usuario u : usuarios)
                out.write(u.seria());
            out.flush();
            out.close();
        } catch (IOException ioe) {
            System.err.println("\nOcurrió un problema al guardar los usuarios");
	    System.exit(4);
        }
    }
}
