import java.util.Scanner;

public class Ahorcado {

    static Scanner numeros = new Scanner(System.in);
    static Scanner lineas = new Scanner(System.in);
    static String[] palabras = new String[5];
    static int opt_menu = 0;
    static int opt_fichero = 0;

    void menu() {
        System.out.println("Bienvenido al juego del ahorcado por favor elija una de las opciones siguientes: ");
        System.out.println("\n1. Gestionar palabras\n2. Jugar\n3. Salir");
        do {
            opt_menu = numeros.nextInt();
            if (opt_menu < 1 || opt_menu > 3) {
                System.out.println("La opciones son de el 1 al 3, por favor elija una opción correcta");
            }
        } while (opt_menu < 1 || opt_menu > 3);
    }

    void ficheroPalabras() {
        do {
            System.out.println("Este es el menu de gestion de las palabras del juego, elija una de las opciones siguientes: ");
            System.out.println("\n1) Añadir palabra\n2) Listar palabras\n3) Buscar palabra\n4) Eliminar palabra\n5) Salir");
            opt_fichero = numeros.nextInt();

            switch (opt_fichero) {
                case 1:
                    addPalabra();
                    break;
                case 2:
                    listarPalabras();
                    break;
                case 3:
                    buscarPalabra();
                    break;
                case 4:
                    eliminarPalabra();
                    break;
                case 5:
                    System.out.println("Saliendo del menu...");
            }
        } while (opt_fichero != 5);

    }

    void addPalabra() {
        String finalizar;
        String entrada;
        int cont = 0;
        for (String palabra : palabras) {
            if (palabra != null) {
                cont++;
            }
        }
        if ((palabras.length - cont) == 0) {
            System.out.println("Ha llegado al limite de palabras admitidas, si desea añadir mas palabras por favor elimine algunas palabras");
        } else {
            System.out.println("Bienvenido a la interfaz para añadir palabras");
            for (int i = 0; i < palabras.length; i++) {
                System.out.println("\nPor favor añada una palabra " + "(" + (palabras.length - cont) + " palabras " +
                        "restantes)");
                entrada = lineas.nextLine().toUpperCase();

                if (!entrada.isEmpty()) {
                    palabras[i] = entrada;
                } else {
                    palabras[i] = null;
                }

                cont = 0;

                for (String palabra : palabras) {
                    if (palabra != null) {
                        cont++;
                    }
                }

                if ((palabras.length - cont) == 0) {
                    System.out.println("Ha llegado al limite de palabras admitidas");
                } else {
                    System.out.println("Desea añadir alguna palabra más? (Max 5)");
                    finalizar = lineas.nextLine().toUpperCase();

                    do {
                        if (!finalizar.equals("SI") && !finalizar.equals("NO")) {
                            System.out.println("Por favor responda con un si o no");
                            finalizar = lineas.nextLine().toUpperCase();
                        }
                    } while (!finalizar.equals("SI") && !finalizar.equals("NO"));

                    if (finalizar.equals("NO")) {
                        i = palabras.length;
                    }
                }
            }
        }

    }

    void listarPalabras() {
        System.out.println("Las palabras guardadas actualmente son: ");
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
    }

    void buscarPalabra() {
        System.out.println("Bienvenido a la interfaz de búsqueda de palabras guardadas.");
        System.out.println("Por favor introduzca la palabra a buscar");
        String busca = lineas.nextLine().toUpperCase();
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].equals(busca)) {
                System.out.println(i +" "+ palabras[i]);
                i = palabras.length;
            }
        }
    }

    void eliminarPalabra() {
        System.out.println("Bienvenido a la interfaz para eliminar palabras.");
        for (int i = 0; i < palabras.length; i++) {
            System.out.println(i+" "+palabras[i]);
        }
        System.out.println("\nPor favor introduzca el numero de la palabra a eliminar de la lista");
        int num = numeros.nextInt();
        palabras[num] = null;
    }

    public static void main(String[] args) {

        Ahorcado m = new Ahorcado();

        do {
            m.menu();
            if (opt_menu == 1) {
                m.ficheroPalabras();
            }
        } while (opt_menu != 3);

        System.out.println("Gracias por jugar al ahorcado😊");


    }
}
