
package p2_201904013;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import static p2_201904013.OP_ORDENAMIENTO.pan2;
import static p2_201904013.P2_201904013.AUX;
import static p2_201904013.P2_201904013.DATOSGRA;

public class INTERFAZ extends JFrame{
 static JPanel PANELITO,PANEL2; 
 static  JTextField RUTA,TITULO,PANELAZO;
   static int CONT1=0,CONTDATOS=0; 
 static  ChartPanel pan;
static String title;

     
public INTERFAZ (){
 /*Se declara el tamaño y titulo de la ventana nueva */
    setSize(950, 700);
    setTitle("USAC");
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
 Label N1 =new Label("Ruta del Archivo");
   N1.setBounds(30,30,150,30);
   N1.setForeground(Color.white);
   N1.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N1);

Label N2 =new Label("Titulo para Gráfica");
   N2.setBounds(30,120,150,30);
   N2.setForeground(Color.white);
   N2.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N2);   
   
 RUTA = new JTextField();
    RUTA.setBounds(40, 70, 575, 30);
    RUTA.setFont(new Font ("Arial",Font.BOLD,13));
PANELITO.add(RUTA);

 TITULO = new JTextField();
    TITULO.setBounds(40, 160, 575, 30);
    TITULO.setFont(new Font ("Arial",Font.BOLD,16));
PANELITO.add(TITULO);


    
    JButton buscar = new JButton("Buscar");
    buscar.setBounds(660, 70, 125, 30);
    buscar.setFont(new Font ("Arial",Font.BOLD,16));
    PANELITO.add(buscar);

    JButton aceptar = new JButton("Aceptar");
    aceptar.setBounds(660,160, 125, 30);
    aceptar.setFont(new Font ("Arial",Font.BOLD,16));
    PANELITO.add(aceptar);
    
     JButton NEWGRAF = new JButton("New");
    NEWGRAF.setBounds(840,20, 75, 25);
    NEWGRAF.setFont(new Font ("Arial",Font.BOLD,16));
    PANELITO.add(NEWGRAF);
    
    
    
    /*Buscar un archivo*/
 buscar.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
         String RUTITA;
   JFileChooser fc =new JFileChooser();
            int op=fc.showDialog(PANELITO,null);
            if(op==JFileChooser.APPROVE_OPTION){
                try {
                    File archivo=fc.getSelectedFile();
                    RUTITA=archivo.toString();
                    RUTA.setText(RUTITA);
                    JOptionPane.showMessageDialog(null,"SE CARGÓ LA RUTA CORRECTAMENTE");
                } catch (Exception e2) {
                  e2.getStackTrace();
                }
  
            }
     }
 });
 
 /*Leer el archivo*/
 aceptar.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
         String RUTALEER=RUTA.getText().trim();
         
         if (TITULO.getText().equals("")) {
             JOptionPane.showMessageDialog(null, "Debe llenar todos los Campos");
         } else {
           try {
                    
                    FileReader fr=new FileReader(RUTALEER);
                    BufferedReader br=new BufferedReader(fr);
                    
                    String linea;
                    while ((linea=br.readLine())!= null) {
                       CONT1++;  
                    }
                    
                    System.out.println("el contador es :"+CONT1);
                    DATOSGRA=new DATOS[CONT1];
                    AUX=new DATOS[CONT1];
                    System.out.println("se seteo el tamaño "+DATOSGRA.length);
                    
                    FileReader LR=new FileReader(RUTALEER);
                   BufferedReader bF=new BufferedReader(LR);
                   
                   String linea2;
                    while ((linea2=bF.readLine())!= null) {
                       String [] datos2=linea2.split(",");
                       String CATEGO=datos2[0];
                       String CANTI=datos2[1];
                      DATOSGRA[CONTDATOS]=new DATOS(CATEGO, CANTI);
                      AUX[CONTDATOS]=new DATOS(CATEGO, CANTI);
                       CONTDATOS++;         
                      
                    }
        
                } catch (Exception e2) {
                  e2.getStackTrace();
                }
                
                 for (int i = 0; i <DATOSGRA.length-1; i++) {
                        System.out.println("CATEGORIA:"+ DATOSGRA[i].getCATEGORIA());
                        System.out.println("CANTIDAD:"+ DATOSGRA[i].getCANTIDAD());
                        System.out.println("************************************");
                    }
                 System.out.println("el segundo contador es: "+CONTDATOS);
  //BUBBLE_SORT();
  GENERARGRAFO();
  GRAFO_INICIAL();
  OPCIONES();
             
         }
              
         
         
         
     }
 });
 NEWGRAF.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
         RUTA.setText("");
         TITULO.setText("");
         pan.setVisible(false);
         
            }
 });
 
    
}

static void GENERARGRAFO(){

        JFreeChart barras=null;
        DefaultCategoryDataset datos=new DefaultCategoryDataset();
       String Y =DATOSGRA[0].getCANTIDAD();
       String X =DATOSGRA[0].getCATEGORIA();
 title=TITULO.getText();
        for (int i = 1; i < DATOSGRA.length-1; i++) {
        float cantidad=Float.parseFloat(DATOSGRA[i].getCANTIDAD());
        String categoria=DATOSGRA[i].getCATEGORIA();
        datos.addValue(cantidad, "", categoria);
    }
      
       barras=ChartFactory.createBarChart(title, X, Y, datos, PlotOrientation.VERTICAL, true,true,false);
           
     pan=new ChartPanel(barras);
     pan.setBounds(30, 260, 750,350);
     pan.setVisible(true);
     pan.setEnabled(false);
     PANELITO.add(pan);
     PANELITO.repaint();
     
  
     
    
}
static void BUBBLE_SORT(){
String auxCAT;
String auxCANT;
        //APLICANDO EL ORDENAMIENTO BURBUJA
        for (int i = 1; i < (CONTDATOS - 1); i++) {
            for (int j = 1; j < (CONTDATOS - 1); j++) {
                float num1=Float.parseFloat(DATOSGRA[j].getCANTIDAD());
                float num2=Float.parseFloat(DATOSGRA[j + 1].getCANTIDAD());
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
 System.out.println("DATOS ORDENADOS POR CANTIDAD: ");
        System.out.println("************************************");
        for (int i =0; i<CONTDATOS; i++) {
            System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
            System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
           
            System.out.println("************************************");
        }
}
static void OPCIONES(){
    
   OPCIONES ventana2= new OPCIONES();
           ventana2.setVisible(true);
           ventana2.repaint();
                  



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
            BufferedImage imagen4 = new BufferedImage(pan2.getWidth(), pan2.getHeight(), BufferedImage.TYPE_INT_ARGB);

            pan2.paint(imagen4.getGraphics());
            ImageIO.write(imagen4, "png", new File("H.png"));
        } catch (Exception e) {
        }

    }

}
