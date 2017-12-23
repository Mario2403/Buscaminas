public class Tablero {

    private Celda[][] tablero= new Celda[3][3];
    private int huecosTotales=0;
    private int huecosDestapados=0;




    public void llenar() {

        for (int i=0; i<tablero.length; i++) {

            for (int j=0 ; j<tablero[0].length; j++) {

                double numeroAleatorio = Math.random();
                Coordenada posicion= new Coordenada(i, j);

                if (numeroAleatorio < 0.2) {
                    tablero[i][j] = new Celda(true,  posicion);
                } else {
                    tablero[i][j] = new Celda(false, posicion);
                    huecosTotales++;
                }

            }
        }
    }

    public void actualizarTablero() {

        for (int i = 0; i < tablero.length; i++) {

            for (int j = 0; j < tablero[0].length; j++) {

                actualizaVecinos(tablero[i][j].getPosicion());
            }

        }




    }
    public void actualizaVecinos(Coordenada coordenada){


        int i=coordenada.getX();
        int j=coordenada.getY();

        int iDesde=i-1, iHasta=i+1, jDesde=j-1, jHasta=j+1;

        if(i==0) iDesde=0;
        if(i==tablero.length-1) iHasta=tablero.length-1;
        if(j==0) jDesde=0;
        if (j==tablero[0].length-1) jHasta=tablero.length-1;

        for (i=iDesde; i<=iHasta; i++) {
            for (j=jDesde ; j<=jHasta; j++) {
                if(tablero[i][j].isBomba()) {
                    tablero[coordenada.getX()][coordenada.getY()].sumaBombaVecina();
                }
            }

        }


    }

    public void mostrarTablero() {


        for (int i=0; i<tablero.length; i++) {
            for (int j=0 ; j<tablero[0].length; j++) {
                tablero[i][j].imprime();
            }
            System.out.println("");


        }
    }

    public void destapa(Coordenada coordenada) {

        tablero[coordenada.getX()][coordenada.getY()].setDescubierto(true);
        huecosDestapados++;

        if(tablero[coordenada.getX()][coordenada.getY()].getBombasVecinas()==0) {
            destapaAdyacenciasSinBomba(coordenada);
        }
    }

    private void destapaAdyacenciasSinBomba(Coordenada coordenada) {


        int i=coordenada.getX();
        int j=coordenada.getY();

        int iDesde=i-1, iHasta=i+1, jDesde=j-1, jHasta=j+1;

        if(i==0) iDesde=0;
        if(i==tablero.length-1) iHasta=tablero.length-1;
        if(j==0) jDesde=0;
        if (j==tablero[0].length-1) jHasta=tablero.length-1;

        for (i=iDesde; i<=iHasta; i++) {
            for (j=jDesde ; j<=jHasta; j++) {
                Coordenada vecino = new Coordenada(i, j);

                if(!tablero[i][j].isDescubierto() && !tablero[i][j].isBomba()) {
                    destapa(vecino);
                }
            }

        }

    }

    public boolean quedanEspaciosLibres() {
        return huecosDestapados<huecosTotales;
    }

    public boolean compruebaBombaDestapada() {

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j].isDescubierto() && tablero[i][j].isBomba()) {
                    return true;
                }
            }
        }
        return false;
    }
}
