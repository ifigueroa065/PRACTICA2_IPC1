
package p2_201904013;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javafx.scene.control.RadioButton;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import static p2_201904013.ANIMACION.PANELITO2;
import static p2_201904013.INTERFAZ.CONTDATOS;
import static p2_201904013.INTERFAZ.title;
import static p2_201904013.P2_201904013.DATOSGRA;


public class OP_ORDENAMIENTO extends JFrame{
 static JPanel PANELITO; 
static String TIPORD="",VELOZ="",ALGORIT="";
static  ChartPanel pan2;
static ButtonGroup ALGORITMO,TIPO,VELOCIDAD;
static JRadioButton ascendente,descendente,baja,media,alta;
static JRadioButton bubble,quick,shell;
     
public OP_ORDENAMIENTO (){
 /*Se declara el tamaño y titulo de la ventana nueva */
    setSize(670, 475);
    setTitle("Opciones de Ordenamiento");
    setLocationRelativeTo(null);
    /*llamamos al metodo que agrega botones al panel */
    iniciar();
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
}
private void iniciar(){

    crearpanel();
   VENTANA();
}

private void  crearpanel(){
    /*se crea el panel y se le da color*/
this.PANELITO=new JPanel();
this.PANELITO.setBackground(new Color(50,50,80));
this.PANELITO.setLayout(null);
this.add(PANELITO);

}
public void VENTANA(){
 Label N1 =new Label("Tipo de Ordenamiento");
   N1.setBounds(210,10,225,30);
   N1.setForeground(Color.white);
   N1.setFont(new Font ("Tahoma",Font.BOLD,18));
   PANELITO.add(N1);

Label N2 =new Label("Velocidad de Ordenamiento");
   N2.setBounds(20,125,225,30);
   N2.setForeground(Color.white);
   N2.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N2); 
   
   Label N3 =new Label("Algoritmo de Ordenamiento");
   N3.setBounds(400,125,225,30);
   N3.setForeground(Color.white);
   N3.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N3); 
   
    /*TIPO DE ORDENAMIENTO*/
    
     ascendente = new JRadioButton("Ascendente", true);
      ascendente.setBounds(150,60, 125, 30);
     PANELITO.add(ascendente);
     
     descendente = new JRadioButton("Descendente", true);
      descendente.setBounds(325,60, 125, 30);
     PANELITO.add(descendente);
   
     TIPO=new ButtonGroup();
     TIPO.add(ascendente);
     TIPO.add(descendente);
     
     /*VELOCIDAD*/
     
      baja = new JRadioButton("Baja", true);
      baja.setBounds(30,190, 90, 30);
     PANELITO.add(baja);
     
     media = new JRadioButton("Media", false);
      media.setBounds(30,240, 90, 30);
     PANELITO.add(media);
     
     alta = new JRadioButton("Alta", false);
      alta.setBounds(30,290, 90, 30);
     PANELITO.add(alta);
     
     VELOCIDAD=new ButtonGroup();
     VELOCIDAD.add(baja);
     VELOCIDAD.add(media);
     VELOCIDAD.add(alta);
     
    /*ALGORITMO*/
    
      bubble = new JRadioButton("Bubble Sort", true);
      bubble.setBounds(420,190, 130, 30);
     PANELITO.add(bubble);
     
      quick = new JRadioButton("Quick Sort", false);
      quick.setBounds(420,240, 130, 30);
     PANELITO.add(quick);
     
      shell = new JRadioButton("Shell Sort", false);
      shell.setBounds(420,290, 130, 30);
     PANELITO.add(shell);
     
     ALGORITMO=new ButtonGroup();
     ALGORITMO.add(bubble);
     ALGORITMO.add(quick);
     ALGORITMO.add(shell);
     
     /*Botones con Acciones*/
     
     JButton EMPEZAR = new JButton("EMPEZAR");
        EMPEZAR.setBounds(440, 360, 150, 40);
        EMPEZAR.setFont(new Font ("Arial",Font.BOLD,16));
        PANELITO.add(EMPEZAR);
   
         JButton volver = new JButton("CANCELAR");
         volver.setFont(new Font ("Arial",Font.BOLD,16));
        volver.setBounds(260, 360, 150, 40);
        PANELITO.add(volver);
    volver.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
         setVisible(false);
     }
 });
   EMPEZAR.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
       //DELTA_GRAFOS();
       setVisible(false);
       PROCESS_ANIMACION PICHULA= new PROCESS_ANIMACION(new ANIMACION());
       PICHULA.start();
         
      
     }
 });
    
} 

    static void ORDENAR(String algoritmo, String velocidad, String tipo) {
        if (tipo.equalsIgnoreCase("ascendente")) {
            TIPORD = "ascendente";

            if (velocidad.equalsIgnoreCase("baja")) {
                VELOZ = "baja";
                if (algoritmo.equalsIgnoreCase("bubble")) {
                    ALGORIT = "bubble";

                } else if (algoritmo.equalsIgnoreCase("quick")) {
                    ALGORIT = "quick";
                } else {
                    ALGORIT = "shell";
                }
            } else if (velocidad.equalsIgnoreCase("media")) {
                VELOZ = "media";

                if (algoritmo.equalsIgnoreCase("bubble")) {
                    ALGORIT = "bubble";
                } else if (algoritmo.equalsIgnoreCase("quick")) {
                    ALGORIT = "quick";
                } else {
                    ALGORIT = "shell";
                }
            } else {
                VELOZ = "alta";
                if (algoritmo.equalsIgnoreCase("bubble")) {
                    ALGORIT = "bubble";
                } else if (algoritmo.equalsIgnoreCase("quick")) {
                    ALGORIT = "quick";
                } else {
                    ALGORIT = "shell";
                }
            }

            System.out.println("***************");
        } else {
            TIPORD = "descendente";
            if (velocidad.equalsIgnoreCase("baja")) {
                VELOZ = "baja";
                if (algoritmo.equalsIgnoreCase("bubble")) {
                    ALGORIT = "bubble";
                } else if (algoritmo.equalsIgnoreCase("quick")) {
                    ALGORIT = "quick";
                } else {
                    ALGORIT = "shell";
                }
            } else if (velocidad.equalsIgnoreCase("media")) {
                VELOZ = "media";

                if (algoritmo.equalsIgnoreCase("bubble")) {
                    ALGORIT = "bubble";
                } else if (algoritmo.equalsIgnoreCase("quick")) {
                    ALGORIT = "quick";
                } else {
                    ALGORIT = "shell";
                }
            } else {
                VELOZ = "alta";
                if (algoritmo.equalsIgnoreCase("bubble")) {
                    ALGORIT = "bubble";
                } else if (algoritmo.equalsIgnoreCase("quick")) {
                    ALGORIT = "quick";
                } else {
                    ALGORIT = "shell";
                }
            }
        }
    }

    public void BUBBLE_SORT(String TIPO) {

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

    static void SHELL_SORT(String TIPO) {

        if (TIPO.equalsIgnoreCase("ascendente")) {
            int salto, j, k;
            float auxcant, auxcant2;
            String AUXCANT;
            String AUXCAT;

            salto = ((CONTDATOS - 1) / 2);
            while (salto > 0) {
                for (int i = salto + 1; i < CONTDATOS; i++) {
                    j = (i - salto);
                    while (j >= 1) {

                        auxcant = Float.parseFloat(DATOSGRA[j].getCANTIDAD());
                        auxcant2 = Float.parseFloat(DATOSGRA[j + salto].getCANTIDAD());

                        if (auxcant <= auxcant2) {
                            break;
                        } else {
                            AUXCANT = DATOSGRA[j].getCANTIDAD();
                            AUXCAT = DATOSGRA[j].getCATEGORIA();

                            DATOSGRA[j].setCANTIDAD(DATOSGRA[j + salto].getCANTIDAD());
                            DATOSGRA[j].setCATEGORIA(DATOSGRA[j + salto].getCATEGORIA());

                            DATOSGRA[j + salto].setCANTIDAD(AUXCANT);
                            DATOSGRA[j + salto].setCATEGORIA(AUXCAT);
                            j = j - salto;
                        }

                    }
                }
                salto = salto / 2;
            }

            for (int i = 0; i < DATOSGRA.length - 1; i++) {
                System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                System.out.println("************************************");

            }
        } else {

            /*ORDENAMIENTO DESCENDENTE*/
            int salto, j;
            float auxcant, auxcant2;
            String AUXCANT;
            String AUXCAT;

            salto = ((CONTDATOS - 1) / 2);
            while (salto > 0) {
                for (int i = salto + 1; i < CONTDATOS; i++) {
                    j = (i - salto);
                    while (j >= 1) {

                        auxcant = Float.parseFloat(DATOSGRA[j].getCANTIDAD());
                        auxcant2 = Float.parseFloat(DATOSGRA[j + salto].getCANTIDAD());

                        if (auxcant >= auxcant2) {
                            break;
                        } else {

                            AUXCANT = DATOSGRA[j].getCANTIDAD();
                            AUXCAT = DATOSGRA[j].getCATEGORIA();

                            DATOSGRA[j].setCANTIDAD(DATOSGRA[j + salto].getCANTIDAD());
                            DATOSGRA[j].setCATEGORIA(DATOSGRA[j + salto].getCATEGORIA());

                            DATOSGRA[j + salto].setCANTIDAD(AUXCANT);
                            DATOSGRA[j + salto].setCATEGORIA(AUXCAT);
                            j = j - salto;
                        }

                    }
                }
                salto = salto / 2;
            }

            for (int i = 0; i < DATOSGRA.length - 1; i++) {
                System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                System.out.println("************************************");

            }
        }

    }

    public static void quick_srt(int iz, int der) {
        String auxCAT;
        int lo = iz;
        int hi = der;
        if (lo >= der) {
            return;
        }
        int mid = Integer.parseInt(DATOSGRA[(lo + hi) / 2].getCANTIDAD());
        while (lo < hi) {
            while (lo < hi && Integer.parseInt(DATOSGRA[lo].getCANTIDAD()) < mid) {
                lo++;
            }
            while (lo < hi && Integer.parseInt(DATOSGRA[hi].getCANTIDAD()) > mid) {
                hi--;
            }
            if (lo < hi) {
                int T = Integer.parseInt(DATOSGRA[lo].getCANTIDAD());
                auxCAT = DATOSGRA[lo].getCATEGORIA();

                DATOSGRA[lo].setCANTIDAD(DATOSGRA[hi].getCANTIDAD());
                DATOSGRA[lo].setCATEGORIA(DATOSGRA[hi].getCATEGORIA());

                DATOSGRA[hi].setCANTIDAD(String.valueOf(T));
                DATOSGRA[hi].setCATEGORIA(auxCAT);
            }
        }
        if (hi < lo) {
            int T = hi;
            hi = lo;
            lo = T;
        }
        quick_srt(iz, lo);
        quick_srt(lo == iz ? lo + 1 : lo, der);
        for (int i = 0; i < DATOSGRA.length - 1; i++) {

            System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
            System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
            System.out.println("************************************");

        }
    }

    public static void quick_srt2(int iz, int der) {
        String auxCAT;
        int lo = iz;
        int hi = der;
        if (lo >= der) {
            return;
        }
        int mid = Integer.parseInt(DATOSGRA[(lo + hi) / 2].getCANTIDAD());
        while (lo < hi) {
            while (lo < hi && Integer.parseInt(DATOSGRA[lo].getCANTIDAD()) > mid) {
                lo++;
            }
            while (lo < hi && Integer.parseInt(DATOSGRA[hi].getCANTIDAD()) < mid) {
                hi--;
            }
            if (lo < hi) {
                int T = Integer.parseInt(DATOSGRA[lo].getCANTIDAD());
                auxCAT = DATOSGRA[lo].getCATEGORIA();

                DATOSGRA[lo].setCANTIDAD(DATOSGRA[hi].getCANTIDAD());
                DATOSGRA[lo].setCATEGORIA(DATOSGRA[hi].getCATEGORIA());

                DATOSGRA[hi].setCANTIDAD(String.valueOf(T));
                DATOSGRA[hi].setCATEGORIA(auxCAT);
            }
        }
        if (hi < lo) {
            int T = hi;
            hi = lo;
            lo = T;
        }
        quick_srt2(iz, lo);
        quick_srt2(lo == iz ? lo + 1 : lo, der);

        for (int i = 0; i < DATOSGRA.length - 1; i++) {

            System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
            System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
            System.out.println("************************************");

        }
    }

    static void GENERARGRAFO(String Tipo) {

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
        pan2.setVisible(true);
        pan2.setEnabled(false);
        PANELITO2.add(pan2);
        PANELITO2.repaint();

    }
    
     public void GRAFO_INICIAL(){
    
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
     
     public void GRAFO_FINAL(){
    
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
     
     public void DELTA_GRAFOS(){
         
            
             BUBBLE_SORT("ascendente");
             GRAFO_INICIAL();
       
             BUBBLE_SORT("descendente");
             GRAFO_FINAL();
         
     
     }
}

