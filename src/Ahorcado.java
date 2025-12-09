import java.util.Arrays;
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
        System.out.println("Este es el menu de gestion de las palabras del juego, elija una de las opciones siguientes: ");
        System.out.println("\n1) Añadir palabra\n2) Listar palabras\n3) Buscar palabra\n4) Eliminar palabra\n5) Salir");
        opt_fichero = numeros.nextInt();

        switch (opt_fichero) {
            case 1:
                añadirPalabra();
                break;
            case 2:
                listarPalabras();
                break;
        }
    }

    void añadirPalabra() {
        String finalizar = "";
        String entrada = "";
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
                System.out.println("\nPor favor añada una palabra "+"("+(palabras.length - cont)+" palabras " +
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

                if ((palabras.length - cont) == 0){
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
        for (int i = 0; i < palabras.length; i++) {
                    System.out.println(palabras[i]);
        }
    }

    public static void main(String[] args) {

        Ahorcado m = new Ahorcado();

        m.menu();
        if (opt_menu == 1) {
            m.ficheroPalabras();
        }

    }
}
