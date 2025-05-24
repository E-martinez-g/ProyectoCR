import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Cargador {

    private Cargador() {}

    public static ArrayList<Tarea> cargaT() {
        try {
            ObjectInputStream in = new ObjectInputStream(
                                       new FileInputStream("Tareas.txt"));
            Tarea t = null;
            ArrayList<Tarea> tareas = new ArrayList<Tarea>();
            while ((t = (Tarea)in.readLine()) != null)
                tareas.add(t);
            return tareas;
        } catch (IOException ioe) {
            System.out.println("Ocurrió un problema al cargar las tareas.");
        }
    }

    public static ArrayList<Usuario> cargaU() {
        try {
            ObjectInputStream in = new ObjectInputStream(
                                       new FileInputStream("Usuarios.txt"));
            Usuario u = null;
            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
            while ((u = (Usuario)in.readLine()) != null)
                usuarios.add(u);
            return usuarios;
        } catch (IOException ioe) {
            System.out.println("Ocurrió un problema al cargar los usuarios.");
        }
    }

}