import javax.swing.JOptionPane;
import java.util.Random;

public class Juego {

    private int jugador1; //Variable utilizada para guardar el numero de victorias del jugador 1
    private int jugador2; //Variable utilizada para guardar el numero de victorias del jugador 2
    private int empates; //Variable utilizada para guardar el numero de empates

    //Metodo constructor de la clase juego
    public Juego(){
        this.jugador1 = 0;
        this.jugador2 = 0;
        this.empates = 0;
    }


    //Método utilizado para mostrar el menú principal del juego
    public void mostrarMenu(){
        int numPartida = 1;
        int opcion;

        while (numPartida <= 3) {//Bucle utilizado para mostrar el menú durante las tres partidas que contiene el juego
            try {
                //Menú principal del juego
                String entrada = JOptionPane.showInputDialog(null,"             Partida No. "+numPartida+"\n" +
                        "Seleccione una opcion:\n" +
                        "1 - Piedra\n" +
                        "2 - Papel\n" +
                        "3 - Tijera\n" +
                        "4 - Salir");
                opcion = Integer.parseInt(entrada);
                if (opcion == 4){//opcion para salir del juego
                    String seleccion = (String) JOptionPane.showInputDialog(null, "¿Seguro que desea salir?", "Seleccione una opcion", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, "si");
                    if (seleccion.equals("Si")) {
                        System.exit(0);
                        break;
                    }
                } else if (opcion < 1 || opcion > 4) {
                    JOptionPane.showMessageDialog(null,"La opcción: "+opcion+" es incorrecta, intenta de nuevo.","Mensaje De Informacion",JOptionPane.INFORMATION_MESSAGE);
                }else {//Si la opción ingresada es entre 1 y 3 se procede a validar la partida
                    int opcionMaquina = this.opcionJugadorDos(); //Almacenando la opción generada para el jugador dos
                    this.validarPartida(opcion, opcionMaquina);
                    numPartida++;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en algun dato de entrada", "Error", JOptionPane.ERROR_MESSAGE);
                String seleccion = (String) JOptionPane.showInputDialog(null, "Desea Salir", "Seleccione una opcion", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, "si");
                if (seleccion.equals("Si")) {
                    System.exit(0);
                    break;
                }
            }//fin de catch
        }//fin de while
    }



    //Método utilizado para validar la partida, recibe como parámetros las opciones correspondientes a cada jugador
    public void validarPartida(int jugador1, int jugador2){

        String[] opciones = {"Piedra","Papel","Tijera"};

        //Comprobando las posibles victorias del jugador 1
        if (jugador1 == 1 && jugador2 == 3
                || jugador1 == 3 && jugador2 == 2
                || jugador1 == 2 && jugador2 == 1){
            this.setJugador1(this.getJugador1() + 1); //Aumentado en uno el contador de victorias para el jugador 1
            //Mostrando el resultado de la partida
            JOptionPane.showMessageDialog(null,
                    "Tu selección: "+opciones[jugador1 - 1]+
                            "\nSegundo jugador: "+opciones[jugador2 - 1]+
                            "\n¡Has ganado la partida!",
                    "Resultado de la partida",JOptionPane.INFORMATION_MESSAGE);

            //Comprobando los empates entre jugadores
        }else if (jugador1 == 1 && jugador2 == 1
                || jugador1 == 2 && jugador2 == 2
                || jugador1 == 3 && jugador2 == 3){
            this.setEmpates(this.getEmpates() + 1); //Aumentado en uno el contador de empates
            //Mostrando el resultado de la partida
            JOptionPane.showMessageDialog(null,
                    "Tu selección: "+opciones[jugador1 - 1]+
                            "\nSegundo jugador: "+opciones[jugador2 - 1]+
                            "\nHubo un empate en la partida",
                    "Resultado de la partida",JOptionPane.INFORMATION_MESSAGE);
        }else {
            this.setJugador2(this.getJugador2() + 1); //Aumentado en uno el contador de victorias para el jugador 2
            //Mostrando el resultado de la partida
            JOptionPane.showMessageDialog(null,
                    "Tu selección: "+opciones[jugador1 - 1]+
                            "\nSegundo jugador: "+opciones[jugador2 - 1]+
                            "\nHas perdido la partida",
                    "Resultado de la partida",JOptionPane.INFORMATION_MESSAGE);
        }
    }



    //Método que retorna un valor aleatorio entre 1 y 3 representando la selección del jugador número dos del juego
    public int opcionJugadorDos(){
        Random random = new Random();
        return random.nextInt(3) + 1;
    }




    //Metodos gette y setter para las propiedades de la clase
    public int getJugador1() {
        return jugador1;
    }

    public void setJugador1(int jugador1) {
        this.jugador1 = jugador1;
    }

    public int getJugador2() {
        return jugador2;
    }

    public void setJugador2(int jugador2) {
        this.jugador2 = jugador2;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }
}