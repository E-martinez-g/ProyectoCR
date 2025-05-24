public class Main {
    public static void main(Strin[] args) {
	if (args.length != 0)
	    uso();
	new ListaDeTareas().inicia();
    }

    /**
     * Se asegura de que el programa no tenga argumentos al ejecutar.
     */
    private static void uso() {
		System.err.println("\nNo se admiten argumentos en el programa.");
		System.exit(1);
    }
}
