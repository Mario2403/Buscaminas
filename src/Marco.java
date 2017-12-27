import javax.swing.*;
import java.awt.*;

public class Marco extends JFrame{

    JPanel[] laminas = new JPanel[8];


    public Marco(Tablero tablero){
        setTitle("Buscaminas");
        setBounds(300, 300, 300 , 300);
        setVisible(true);
        setLayout(new GridLayout(8,0));



        for (int i = 0; i < laminas.length; i++) {
            laminas[i] = new JPanel();
            //laminas[i].setLayout(new BoxLayout(laminas[i], BoxLayout.LINE_AXIS));
            this.add(laminas[i]);

        }
        aniadir(tablero);
    pack();

    }

    private void aniadir(Tablero tablero){

        for (int i = 0; i <tablero.getTamañoX() ; i++) {
            for (int j = 0; j < tablero.getTamañoY(); j++) {

                laminas[i].add(tablero.obtenerBotonCelda(i, j));
            }
        }




    }






}
