public class Celda {

    private boolean bomba;
    private boolean descubierto=false;
    private int bombasVecinas=0;
    private Coordenada posicion;


    public Celda(boolean bomba, Coordenada posicion) {
        this.bomba = bomba;
        this.posicion= posicion;
    }

    public Celda(boolean bomba, boolean descubierto, Coordenada posicion) {
        this.bomba = bomba;
        this.descubierto = descubierto;
        this.posicion = posicion;
    }

    public boolean isBomba() {
        return bomba;
    }

    public boolean isDescubierto() {
        return descubierto;
    }

    public int getBombasVecinas() {
        return bombasVecinas;
    }

    public void setDescubierto(boolean descubierto) {
        this.descubierto = descubierto;
    }

    public void setBombasVecinas(int bombasVecinas) {
        this.bombasVecinas = bombasVecinas;
    }


    public Coordenada getPosicion() {
        return posicion;
    }
/*
    public void actualizaVecinos(Celda[][] tablero) {

        if (this.isBomba()) setBombasVecinas(getBombasVecinas()-1);
        int i=posicion.getX();

        int j=posicion.getY();

        int iDesde=i-1, iHasta=i+1, jDesde=j-1, jHasta=j+1;

        if(i==0) iDesde=0;
        if(i==tablero.length-1) iHasta=tablero.length-1;
        if(j==0) jDesde=0;
        if (j==tablero[0].length-1) jHasta=tablero.length-1;

        for (int r = iDesde; r <=iHasta ; r++) {
            for (int s = jDesde; s <=jHasta ; s++) {
                if(tablero[r][s].isBomba()){
                    this.sumaBombaVecina();
                }
            }
        }




    }
*/
    public void sumaBombaVecina() {
        this.setBombasVecinas(this.getBombasVecinas()+1);
    }


    public void imprime() {

        if(isDescubierto()) {
            if (isBomba()){
                System.out.print("*");
            }else {
                System.out.print(getBombasVecinas());
            }
        }
        else{
            System.out.print("#");
        }
    }
}
