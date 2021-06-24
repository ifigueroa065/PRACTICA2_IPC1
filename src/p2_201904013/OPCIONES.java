
package p2_201904013;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import static p2_201904013.INTERFAZ.CONTDATOS;
import static p2_201904013.INTERFAZ.title;
import static p2_201904013.OP_ORDENAMIENTO.TIPORD;
import static p2_201904013.OP_ORDENAMIENTO.ascendente;
import static p2_201904013.OP_ORDENAMIENTO.pan2;
import static p2_201904013.P2_201904013.DATOSGRA;


public class OPCIONES extends JFrame{
     JPanel PANELITO; 
static String T1;
     
public OPCIONES (){
 /*Se declara el tamaño y titulo de la ventana nueva */
    setSize(440, 280);
    setTitle("");
    setLocationRelativeTo(null);
    /*llamamos al metodo que agrega botones al panel */
    iniciar();
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
}
private void iniciar(){

    crearpanel();
    LOGIN();
}

private void  crearpanel(){
    /*se crea el panel y se le da color*/
this.PANELITO=new JPanel();
this.PANELITO.setBackground(new Color(50,50,80));
this.PANELITO.setLayout(null);
this.add(PANELITO);

}
public void LOGIN(){
 
   Label N5 =new Label("¿Desea Ordenar la Gráfica?");
   N5.setBounds(90,50,400,30);
   N5.setForeground(Color.white);
   N5.setFont(new Font ("Tahoma",Font.BOLD,20));
   PANELITO.add(N5); 
   
JButton si =new JButton("SI");
    si.setBounds(125,125,75,40);
    si.setFont(new Font ("Arial",Font.BOLD,16));
    PANELITO.add(si);
   
 JButton no =new JButton("NO");
 no.setFont(new Font ("Arial",Font.BOLD,16));
no.setBounds(225,125,75,40);
    PANELITO.add(no);
    
  si.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
          
          OP_ORDENAMIENTO ventana3=new OP_ORDENAMIENTO();
          ventana3.setVisible(true);
          ventana3.repaint();
           setVisible(false);
            //DELTA_GRAFOS();
           
       }
   });
  
  
  no.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           setVisible(false);
       }
   });
    
}
public void GRAFO_INICIAL() {

        JFreeChart barras = null;
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        String Y = DATOSGRA[0].getCANTIDAD();
        String X = DATOSGRA[0].getCATEGORIA();

        for (int i = 1; i < DATOSGRA.length - 1; i++) {
            float cantidad = Float.parseFloat(DATOSGRA[i].getCANTIDAD());
            String categoria = DATOSGRA[i].getCATEGORIA();
            datos.addValue(cantidad, "", categoria);
        }

        barras = ChartFactory.createBarChart(title, X, Y, datos, PlotOrientation.VERTICAL, true, true, false);

        pan2 = new ChartPanel(barras);
        pan2.setBounds(30, 260, 750, 350);
        try {
            BufferedImage imagen = new BufferedImage(pan2.getWidth(), pan2.getHeight(), BufferedImage.TYPE_INT_ARGB);

            pan2.paint(imagen.getGraphics());
            ImageIO.write(imagen, "png", new File("INICIAL.png"));
        } catch (Exception e) {
        }

    }

    public void GRAFO_FINAL() {

        JFreeChart barras = null;
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        String Y = DATOSGRA[0].getCANTIDAD();
        String X = DATOSGRA[0].getCATEGORIA();

        for (int i = 1; i < DATOSGRA.length - 1; i++) {
            float cantidad = Float.parseFloat(DATOSGRA[i].getCANTIDAD());
            String categoria = DATOSGRA[i].getCATEGORIA();
            datos.addValue(cantidad, "", categoria);
        }

        barras = ChartFactory.createBarChart(title, X, Y, datos, PlotOrientation.VERTICAL, true, true, false);

        pan2 = new ChartPanel(barras);
        pan2.setBounds(30, 260, 750, 350);
        try {
            BufferedImage imagenF = new BufferedImage(pan2.getWidth(), pan2.getHeight(), BufferedImage.TYPE_INT_ARGB);

            pan2.paint(imagenF.getGraphics());
            ImageIO.write(imagenF, "png", new File("FINAL.png"));
        } catch (Exception e) {
        }

    }

    public void DELTA_GRAFOS() {

        
        
        BUBBLE_SORTCRE("ascendente");
        GRAFO_INICIAL();

        
        BUBBLE_SORTCRE("descendente");
        GRAFO_FINAL();

    }

    public void BUBBLE_SORTCRE(String TIPO) {

        if (TIPO.equalsIgnoreCase("ascendente")) {
            String auxCAT;
            String auxCANT;
            //APLICANDO EL ORDENAMIENTO BURBUJA
            for (int i = 1; i < (CONTDATOS - 1); i++) {
                for (int j = 1; j < (CONTDATOS - 1); j++) {
                    float num1 = Float.parseFloat(DATOSGRA[j].getCANTIDAD());
                    float num2 = Float.parseFloat(DATOSGRA[j + 1].getCANTIDAD());
                    if (num1 > num2) {
                        //OBTENIENDO VALORES Y GUARDANDOLOS
                        auxCANT = DATOSGRA[j].getCANTIDAD();
                        auxCAT = DATOSGRA[j].getCATEGORIA();

                        //SETEANDO LA POSICION ACTUAL EL VALOR  DE LA POSICION SIGUIENTE
                        DATOSGRA[j].setCANTIDAD(DATOSGRA[j + 1].getCANTIDAD());
                        DATOSGRA[j].setCATEGORIA(DATOSGRA[j + 1].getCATEGORIA());

                        //SETEANDO LA POSICION SIGUIENTE CON LA POSICION ACTUAL
                        DATOSGRA[j + 1].setCANTIDAD(auxCANT);
                        DATOSGRA[j + 1].setCATEGORIA(auxCAT);

                    }
                }
            }
            for (int i = 0; i < DATOSGRA.length - 1; i++) {

                System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                System.out.println("************************************");

            }
        } else {

            String auxCAT;
            String auxCANT;
            //APLICANDO EL ORDENAMIENTO BURBUJA
            for (int i = 1; i < (CONTDATOS - 1); i++) {
                for (int j = 1; j < (CONTDATOS - 1); j++) {
                    float num1 = Float.parseFloat(DATOSGRA[j].getCANTIDAD());
                    float num2 = Float.parseFloat(DATOSGRA[j + 1].getCANTIDAD());
                    if (num1 < num2) {
                        //OBTENIENDO VALORES Y GUARDANDOLOS
                        auxCANT = DATOSGRA[j].getCANTIDAD();
                        auxCAT = DATOSGRA[j].getCATEGORIA();

                        //SETEANDO LA POSICION ACTUAL EL VALOR  DE LA POSICION SIGUIENTE
                        DATOSGRA[j].setCANTIDAD(DATOSGRA[j + 1].getCANTIDAD());
                        DATOSGRA[j].setCATEGORIA(DATOSGRA[j + 1].getCATEGORIA());

                        //SETEANDO LA POSICION SIGUIENTE CON LA POSICION ACTUAL
                        DATOSGRA[j + 1].setCANTIDAD(auxCANT);
                        DATOSGRA[j + 1].setCATEGORIA(auxCAT);

                    }
                }
            }
            for (int i = 0; i < DATOSGRA.length - 1; i++) {

                System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                System.out.println("************************************");

            }
        }

    }

    
    
    
}
