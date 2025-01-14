import java.util.Scanner;

public class tresenraya {
    static final String JUGADOR = "•";
    static final String ORDENADOR = "X";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[][] tablero = new String[3][3];
        int i;
        int j;
        int movimientos = 0;
        boolean jugadorGana = false;
        boolean ordenadorGana = false;
        String nombreFila = "cba";
        String coordenadas;


        for(i = 0; i < 3; i++) {
            for(j = 0; j < 3; j++) {
                tablero[i][j] = " ";
            }
        }



        do {


            System.out.println("  ░░░░░░░░░░░░░░░");
            for(i = 0; i < 3; i++) {
                System.out.print(nombreFila.charAt(i)+ " ░");
                for(j = 0; j < 3; j++) {
                    System.out.print("░ " + tablero[i][j] + " ");
                }
                System.out.println("░░");
                System.out.println("  ░░░░░░░░░░░░░░░");
            }
            System.out.println("     1   2   3\n");


            System.out.print("Introduzca las coordenadas, por ejemplo b2: ");
            coordenadas = sc.nextLine();
            int fila = nombreFila.indexOf(coordenadas.charAt(0));
            int columna = coordenadas.charAt(1) - 1 - 48;
            tablero[fila][columna] = JUGADOR;
            movimientos++;


            jugadorGana = (
                    (tablero[0][0] == JUGADOR) && (tablero[0][1] == JUGADOR) && (tablero[0][2] == JUGADOR) ||
                            (tablero[1][0] == JUGADOR) && (tablero[1][1] == JUGADOR) && (tablero[1][2] == JUGADOR) ||
                            (tablero[2][0] == JUGADOR) && (tablero[2][1] == JUGADOR) && (tablero[2][2] == JUGADOR) ||
                            (tablero[0][0] == JUGADOR) && (tablero[1][0] == JUGADOR) && (tablero[2][0] == JUGADOR) ||
                            (tablero[0][1] == JUGADOR) && (tablero[1][1] == JUGADOR) && (tablero[2][1] == JUGADOR) ||
                            (tablero[0][2] == JUGADOR) && (tablero[1][2] == JUGADOR) && (tablero[2][2] == JUGADOR) ||
                            (tablero[0][0] == JUGADOR) && (tablero[1][1] == JUGADOR) && (tablero[2][2] == JUGADOR) ||
                            (tablero[0][2] == JUGADOR) && (tablero[1][1] == JUGADOR) && (tablero[2][0] == JUGADOR)
            );

            if (!jugadorGana && (movimientos < 9)) {
                // juega el ordenador
                do {
                    fila = (int)(Math.random() * 3);
                    columna = (int)(Math.random() * 3);
                } while (!tablero[fila][columna].equals(" "));

                tablero[fila][columna] = ORDENADOR;
                movimientos++;

                ordenadorGana = (
                        (tablero[0][0] == ORDENADOR) && (tablero[0][1] == ORDENADOR) && (tablero[0][2] == ORDENADOR) ||
                                (tablero[1][0] == ORDENADOR) && (tablero[1][1] == ORDENADOR) && (tablero[1][2] == ORDENADOR) ||
                                (tablero[2][0] == ORDENADOR) && (tablero[2][1] == ORDENADOR) && (tablero[2][2] == ORDENADOR) ||
                                (tablero[0][0] == ORDENADOR) && (tablero[1][0] == ORDENADOR) && (tablero[2][0] == ORDENADOR) ||
                                (tablero[0][1] == ORDENADOR) && (tablero[1][1] == ORDENADOR) && (tablero[2][1] == ORDENADOR) ||
                                (tablero[0][2] == ORDENADOR) && (tablero[1][2] == ORDENADOR) && (tablero[2][2] == ORDENADOR) ||
                                (tablero[0][0] == ORDENADOR) && (tablero[1][1] == ORDENADOR) && (tablero[2][2] == ORDENADOR) ||
                                (tablero[0][2] == ORDENADOR) && (tablero[1][1] == ORDENADOR) && (tablero[2][0] == ORDENADOR)
                );
            }

        } while (!jugadorGana && !ordenadorGana && (movimientos < 9));


        System.out.println("  ░░░░░░░░░░░░░░░");
        for(i = 0; i < 3; i++) {
            System.out.print(nombreFila.charAt(i)+ " ░");
            for(j = 0; j < 3; j++) {
                System.out.print("░ " + tablero[i][j] + " ");
            }
            System.out.println("░░");
            System.out.println("  ░░░░░░░░░░░░░░░");
        }
        System.out.println("     1   2   3\n");

        if (jugadorGana) {
            System.out.println("¡Enhorabuena! ¡Has ganado!");
        } else if (ordenadorGana) {
            System.out.println("Gana el ordenador.");
        } else {
            System.out.println("Empate. No gana nadie.");
        }
    }
}

