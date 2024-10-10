import javax.swing.*;

public class Main {


    public static void main(String[] args) {

        String resultado = "";
        JOptionPane.showMessageDialog(null,
                "El juego tiene únicamente tres participaciones, \nen cada partida se mostrará el resultado de la \nmisma " +
                        "y al final se motrará el resultado del juego.",
                "Juego: piedra, papel o tijera",JOptionPane.INFORMATION_MESSAGE);

        Juego juego = new Juego(); //creando instancia de la clase juego
        juego.mostrarMenu(); //llamada al metodo para mostrar el menu

        //Validando el resultado final del juego
        if (juego.getJugador1() > juego.getJugador2()){
            resultado = "¡Felicitaciones has ganado!";
        }else if (juego.getJugador1() < juego.getJugador2()){
            resultado = "Perdiste, suerte para la próxima.";
        }else if (juego.getJugador1() == juego.getJugador2()){
            resultado = "Hay un empate.";
        }

        //Mostrando el resultado final del juego
        JOptionPane.showMessageDialog(null,
                resultado + "\nTus victorias: "+juego.getJugador1()+
                        "\nVictorias del segundo jugador: "+juego.getJugador2()+
                        "\nTotal de empates durante el juego: "+juego.getEmpates(),
                "Fin y resumen del juego",JOptionPane.INFORMATION_MESSAGE);
    }
}
