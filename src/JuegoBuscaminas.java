
import java.util.InputMismatchException;
import java.util.Scanner;

public class JuegoBuscaminas {

    private Tablero tablero= new Tablero();


    public JuegoBuscaminas(){

        tablero.llenar();
        tablero.actualizarTablero();

    }

    public void run() {

        comenzarJuego();

    }

    private void comenzarJuego() {

        tablero.mostrarTablero();

        do {
            Coordenada coordenada = preguntaDestapar();
            destapa(coordenada);
            tablero.mostrarTablero();
        }while(!bombaDestapada() && quedanEspaciosLibres());

        escribeResultado();


        //Muestra tablero
        //Pregunta donde destapar
        //Destapa
        //Muestra tablero

        //Se ha ganado o perdido?

    }

    private void escribeResultado() {
        if(bombaDestapada()) System.out.println("Has perdido");
        else if(!quedanEspaciosLibres()) System.out.println("Has ganado");
    }


    private boolean quedanEspaciosLibres() {
        return tablero.quedanEspaciosLibres();

    }

    private boolean bombaDestapada() {

        return tablero.compruebaBombaDestapada();

    }

    private void destapa(Coordenada coordenada) {

        tablero.destapa(coordenada);

    }

    private Coordenada preguntaDestapar() {


        Scanner lector= new Scanner(System.in);
        Coordenada coordenada= new Coordenada(0,0);
        try {
            do {
                System.out.println("Que casillas quieres destapar?");
                coordenada.setX(lector.nextInt());
                coordenada.setY(lector.nextInt());
            } while (!coordenadaEsValida(coordenada));
        }catch(InputMismatchException e){
            System.out.println("\nIntroduce unicamente numeros por favor\n");
            return preguntaDestapar();
        }

        return coordenada;

    }

    private boolean coordenadaEsValida(Coordenada coordenada) {

        boolean xCorrecta= coordenada.getX()>=0 && coordenada.getX()<tablero.getTamañoX();
        boolean yCorrecta = coordenada.getY()>=0 && coordenada.getY()<tablero.getTamañoY();

        return xCorrecta && yCorrecta && !casillaDestapada(coordenada);
    }

    private boolean casillaDestapada(Coordenada coordenada) {
        return tablero.getElemento(coordenada.getX(), coordenada.getY()).isDescubierto();
    }

}
