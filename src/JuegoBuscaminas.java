
import java.util.Scanner;

public class JuegoBuscaminas {

    private Celda[][] tablero;
    private int huecosTotales=0;
    private int huecosDestapados=0;
    


    public JuegoBuscaminas(){

        this.tablero= new Celda[10][10];
        llenaTablero();
        actualizaTablero();

    }

    private void actualizaTablero() {

        for (int i=0; i<tablero.length; i++) {
            for (int j=0 ; j<tablero[0].length; j++) {
                tablero[i][j].actualizaVecinos(tablero);
            }


        }
    }


    private void llenaTablero() {

        for (int i=0; i<tablero.length; i++) {
            for (int j=0 ; j<tablero[0].length; j++) {

                int numeroAleatorio = (int) (Math.random() * 2);
                Coordenada posicion= new Coordenada(i, j);

                if (numeroAleatorio == 0) {
                    tablero[i][j] = new Celda(true,  posicion);
                } else {
                    tablero[i][j] = new Celda(false, posicion);
                    huecosTotales++;
                }

            }
        }

    }


    public void run() {


        comenzarJuego();

    }

    private void comenzarJuego() {

        do {
            muestraTablero();
            Coordenada coordenada = preguntaDestapar();
            destapa(coordenada);
        }while(!bombaDestapada() && quedanEspaciosLibres());

        //Muestra tablero
        //Pregunta donde destapar
        //Destapa
    }


    private boolean quedanEspaciosLibres() {
        return huecosDestapados < huecosTotales;

    }

    private boolean bombaDestapada() {
        for (int i=0; i<tablero.length; i++) {
            for (int j=0 ; j<tablero[0].length; j++) {
                if (tablero[i][j].isDescubierto() && tablero[i][j].isBomba()){
                    System.out.println("Bomba");
                    return true;
                }
            }



        }
        return false;

    }

    private void destapa(Coordenada coordenada) {

        tablero[coordenada.getX()][coordenada.getY()].setDescubierto(true);
        huecosDestapados++;

    }

    private Coordenada preguntaDestapar() {
        Scanner lector= new Scanner(System.in);
        Coordenada coordenada= new Coordenada(0,0);
        System.out.println("Que casillas quieres destapar?");
        coordenada.setY( lector.nextInt());
        coordenada.setX(lector.nextInt());
        return coordenada;

    }

    private void muestraTablero() {

        for (int i=0; i<tablero.length; i++) {
            for (int j=0 ; j<tablero[0].length; j++) {
                tablero[i][j].imprime();
            }
            System.out.println("");


        }


    }


}
