import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Guardador {

    private Guardador() {}

    public static void guarda(ArrayList<? extends Serializable> lista, String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                                         new FileOutputStream(fileName));
            for (Serializable s : lista)
                out.write(s);
            out.flush();
            out.close();
        } catch (IOException ioe) {
            System.out.println("\nOcurrió un problema al intentar guardar " + error(fileName));
        }
    }

    private String error(String fileName) {
        return fileName.equals("Tareas.txt") ? "las tareas." : "los usuarios.";
    }
}