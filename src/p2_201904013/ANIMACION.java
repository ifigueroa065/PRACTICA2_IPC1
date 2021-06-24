
package p2_201904013;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import static p2_201904013.ANIMACION.condicion;
import static p2_201904013.INTERFAZ.CONT1;
import static p2_201904013.INTERFAZ.CONTDATOS;
import static p2_201904013.INTERFAZ.title;
import static p2_201904013.OP_ORDENAMIENTO.ALGORIT;
import static p2_201904013.OP_ORDENAMIENTO.TIPORD;
import static p2_201904013.OP_ORDENAMIENTO.VELOZ;
import static p2_201904013.OP_ORDENAMIENTO.pan2;
import static p2_201904013.P2_201904013.AUX;
import static p2_201904013.P2_201904013.DATOSGRA;


public class ANIMACION extends JFrame {
static   JPanel PANELITO2; 
static int MINUTOS=0,SEGUNDOS=0,MILESIMAS=0,CONTPASOS=0;  
static Label N9,N11,N12;
static Label N6,N7,N8,N10;
static boolean condicion=true;
static boolean iniciarCrono=true;
static JButton REPORTE,volverP;
 static  ChartPanel pan3;
     
public ANIMACION (){
 /*Se declara el tamaño y titulo de la ventana nueva */
    setSize(850, 700);
    setTitle("PROCESO DE ORDENAMIENTO");
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
this.PANELITO2=new JPanel();
this.PANELITO2.setBackground(new Color(50,50,80));
this.PANELITO2.setLayout(null);
this.add(PANELITO2);

}
public void VENTANA(){
 Label N1 =new Label("ALGORITMO:");
   N1.setBounds(20,20,105,30);
   N1.setForeground(Color.white);
   N1.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO2.add(N1);

Label N2 =new Label("VELOCIDAD:");
   N2.setBounds(20,75,100,30);
   N2.setForeground(Color.white);
   N2.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO2.add(N2);   
   
   Label N3 =new Label("ORDEN:");
   N3.setBounds(20,130,80,30);
   N3.setForeground(Color.white);
   N3.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO2.add(N3); 
   
Label N4 =new Label("TIEMPO:");
   N4.setBounds(475,20,80,30);
   N4.setForeground(Color.white);
   N4.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO2.add(N4);   
   
   Label N5 =new Label("PASOS:");
   N5.setBounds(475,75,80,30);
   N5.setForeground(Color.white);
   N5.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO2.add(N5);
   
    N6 =new Label(ALGORIT);
   N6.setBounds(140,20,100,30);
   N6.setForeground(Color.white);
   N6.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO2.add(N6);

   N7 =new Label(VELOZ);
   N7.setBounds(130,75,100,30);
   N7.setForeground(Color.white);
   N7.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO2.add(N7);   
   
   N8 =new Label(TIPORD);
   N8.setBounds(110,130,120,30);
   N8.setForeground(Color.white);
   N8.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO2.add(N8); 
   
   N9 =new Label("00:00:00");
   N9.setBounds(575,20,400,30);
   N9.setForeground(Color.white);
   N9.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO2.add(N9);  
   
   
   
   N10 =new Label(Integer.toString(CONTDATOS));
   N10.setBounds(575,75,80,30);
   N10.setForeground(Color.white);
   N10.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO2.add(N10);
   
        REPORTE = new JButton("REPORTE");
        REPORTE.setBounds(620, 150, 150, 40);
        REPORTE.setEnabled(false);
        REPORTE.setFont(new Font ("Arial",Font.BOLD,16));
        PANELITO2.add(REPORTE);
        
        volverP = new JButton("VOLVER");
        volverP.setBounds(1000, 20, 100, 25);
        volverP.setEnabled(false);
        PANELITO2.add(volverP);
        
        volverP.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
      CONTDATOS=0;
      CONT1=0;
      DATOSGRA=new DATOS[0];
      AUX=new DATOS[0];
      CONTPASOS=0;
      condicion=true;
       MINUTOS=0;SEGUNDOS=0;MILESIMAS=0;
      pan2.setVisible(false);
      
      
         setVisible(false);
         
     }
 });
        
        /*GENERAR REPORTE*/
     REPORTE.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
         GRAFO_FINAL1();
         
         try {
            
            
             
             String ruta = "REPORTE_USAC_DATA_PLOTTER.html";
             PrintWriter writer = new PrintWriter(ruta, "UTF-8");
             writer.println("<!DOCTYPE HTML>");
             writer.println("<html>");
             writer.println("<head>");
             writer.println("<meta charset= " + " utf-8 " + " > ");
             writer.println("<title>REPORTE DE DATOS </title>");

             writer.println("</head>");

             writer.println("<body bgcolor= " + " #102030 " + "text=" + "white" + ">");
             
                          writer.println("<H1 "+ " align= " + "center" + ">" + "Marlon Isai Figueroa Farfán</H1>");
                          
                          writer.println("<H2 "+ " align= " + "center" + ">" + "201904013</H2>");
              writer.println("<HR "+ "align = " + " CENTER" + " size = " + "4" + " width ="+ " 100% " + "color= " +" White" + " noshade>");
                            writer.println("<br>");
                            
              
             writer.println("<pre>"+"  ALGORITMO : "+ N6.getText()+ "                          TIEMPO :"+N9.getText() +"</pre>");
             writer.println("<pre>"+"  VELOCIDAD : "+ N7.getText()+ "                          PASOS  :"+N10.getText() +"</pre>");
             writer.println("<pre>"+"  ORDEN     : "+ N8.getText());  
             writer.println("<br>");
            writer.println("<HR "+ "align = " + " CENTER" + " size = " + "4" + " width ="+ " 100% " + "color= " +" White" + " noshade>");
           
            
             if (N8.getText().equalsIgnoreCase("ascendente")) {
                 String CatminA = DATOSGRA[1].getCANTIDAD();
                 String CantminA = DATOSGRA[1].getCATEGORIA();
                 String CatmaxA = DATOSGRA[CONTDATOS - 1].getCANTIDAD();
                 String CantmaxA = DATOSGRA[CONTDATOS - 1].getCATEGORIA();
                

writer.println("<div>");
                 writer.println("<div style='float: left; margin: 0px 200px 0px 300px; padding: 10px; text-align: left; '>");
                 writer.println("<TABLE BORDER WIDTH=200% >");
                 writer.println("<TR>");
                 writer.println("<TD>DATO MINIMO</TD>");
                 writer.println("</TR>");
                 writer.println("<TR>");
                 writer.println("<TD>");
                 writer.println("<TABLE BORDER WIDTH=100%>");
                 writer.println("<TR>");
                 writer.println("<TD>"+CantminA+"</TD>");
                 writer.println("<TD>"+CatminA+"</TD>");
                 writer.println("</TR>");
                 writer.println("</TABLE>");
                 writer.println("</TD>");

                 writer.println("</TR>");
                 writer.println("</TABLE>");
                 writer.println("</div>");
                 writer.println("<div style='float: right; margin: -20px 400px 0px 10px; padding: 10px; text-align: left; '>");
               writer.println("<TABLE BORDER WIDTH=200% >");
                 writer.println("<TR>");
                 writer.println("<TD>DATO MAX</TD>");
                 writer.println("</TR>");
                 writer.println("<TR><TD>");
                 writer.println("<TABLE BORDER WIDTH=100%>");
                 writer.println("<TR>");
                 writer.println("<TD>"+CantmaxA+"</TD>");
                 writer.println("<TD>"+CatmaxA+"</TD>");
                 writer.println("</TR>");
                 writer.println("</TABLE>");
                 writer.println("</TD>");

                 writer.println("</TR>");
                 writer.println("</TABLE>");
                 writer.println("</div>");
                  writer.println("</div>");

writer.println("<br>");

             } else {
                  String CatminD= DATOSGRA[CONTDATOS-1].getCANTIDAD();
                  String CantminD=DATOSGRA[CONTDATOS-1].getCATEGORIA();
                   String CatmaxD= DATOSGRA[1].getCANTIDAD();
                  String CantmaxD=DATOSGRA[1].getCATEGORIA();
             writer.println("<div>");
                 writer.println("<div style='float: left; margin: 0px 200px 0px 300px; padding: 10px; text-align: left; '>");
                 writer.println("<TABLE BORDER WIDTH=200% >");
                 writer.println("<TR>");
                 writer.println("<TD>DATO MINIMO</TD>");
                 writer.println("</TR>");
                 writer.println("<TR>");
                 writer.println("<TD>");
                 writer.println("<TABLE BORDER WIDTH=100%>");
                 writer.println("<TR>");
                 writer.println("<TD>"+CantminD+"</TD>");
                 writer.println("<TD>"+CatminD+"</TD>");
                 writer.println("</TR>");
                 writer.println("</TABLE>");
                 writer.println("</TD>");

                 writer.println("</TR>");
                 writer.println("</TABLE>");
                 writer.println("</div>");
                 writer.println("<div style='float: right; margin: -20px 400px 0px 10px; padding: 10px; text-align: left; '>");
               writer.println("<TABLE BORDER WIDTH=200% >");
                 writer.println("<TR>");
                 writer.println("<TD>DATO MAX</TD>");
                 writer.println("</TR>");
                 writer.println("<TR><TD>");
                 writer.println("<TABLE BORDER WIDTH=100%>");
                 writer.println("<TR>");
                 writer.println("<TD>"+CantmaxD+"</TD>");
                 writer.println("<TD>"+CatmaxD+"</TD>");
                 writer.println("</TR>");
                 writer.println("</TABLE>");
                 writer.println("</TD>");

                 writer.println("</TR>");
                 writer.println("</TABLE>");
                 writer.println("</div>");
                  writer.println("</div>");
             }
             
             writer.println("<HR "+ "align = " + " CENTER" + " size = " + "4" + " width ="+ " 100% " + "color= " +" White" + " noshade>");
              writer.println("<br>");
             writer.println("<br>");
             writer.print("<div "+ "align =" + "center" + ">");
             writer.print(" <img " + " src= "+"H.png" + ">");
             writer.print("</div>"); 
             writer.println("<br>");
             
             writer.println("<h1>DATOS DESORDENADOS :</h1>");
             writer.println("<div style= " + " text-align:center; " + ">");
             writer.println(" <table border= " + " 2 " + " width= " + " 50% " + " > ");
             writer.println("<thead>");
             writer.println("<tr>");
             writer.println("<th>CATEGORÍA</th>");
             writer.println("<th>CANTIDAD</th>");
             writer.println("</tr>");
             writer.println("</thead>");
             writer.println("<tbody>	");

             for (int i = 0; i < CONTDATOS; i++) {
                 writer.println("<tr>");
                 String categoria = AUX[i].getCATEGORIA();
                 writer.println("<td>" + categoria + "</td>");

                 String cantidad = AUX[i].getCANTIDAD();
                 writer.println("<td>" + cantidad + "</td>");

                 writer.println("</tr>");
             }

             writer.println("</tbody>");

             writer.println("</table>");
             writer.println("</div>");
             
            writer.println("<HR "+ "align = " + " CENTER" + " size = " + "4" + " width ="+ " 100% " + "color= " +" White" + " noshade>");
             writer.println("<br>");
             
             
             writer.println("<h1>DATOS ORDENADOS : </h1>");
             writer.println("<div style= " + " text-align: center; " + " > ");
             writer.println(" <table border= " + "2" + " width= " + " 50% " + ">");
             writer.println("<thead>");
             writer.println("<tr>");
             writer.println("<th>CATEGORÍA</th>");
             writer.println("<th>CANTIDAD</th>");
             writer.println("</tr>");
             writer.println("</thead>");
             writer.println("<tbody>	");
             for (int i = 0; i < CONTDATOS; i++) {
                 writer.println("<tr>");
                 String categoria = DATOSGRA[i].getCATEGORIA();
                 writer.println("<td>" + categoria + "</td>");

                 String cantidad = DATOSGRA[i].getCANTIDAD();
                 writer.println("<td>" + cantidad + "</td>");

                 writer.println("</tr>");
             }
             writer.println("</tbody>");

             writer.println("</table>");
             writer.println("</div>");

             writer.println("<br>");
             
             
                 writer.println("<br>");
             writer.print("<div "+ "align =" + "center" + ">");
             writer.print(" <img " + " src= "+"FINAL.png" + ">");
             writer.print("</div>"); 
             writer.println("<br>");
             
             
             writer.println("</body>");
             writer.println("</html>");
             writer.close();
             JOptionPane.showMessageDialog(null, "Se creó correctamente");
         } catch (Exception e2) {
             e2.getStackTrace();
            }
         
        
     }
 });
  
}


 public void GRAFO_FINAL1(){
    
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

        pan3 = new ChartPanel(barras);
        pan3.setBounds(30, 260, 750, 350);
        try {
            BufferedImage imagen = new BufferedImage(pan3.getWidth(), pan3.getHeight(), BufferedImage.TYPE_INT_ARGB);

            pan3.paint(imagen.getGraphics());
            ImageIO.write(imagen, "png", new File("FINAL.png"));
        } catch (Exception e) {
        }

    }
     
     static void GRAFO_FINAL12(){
    
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

        pan3 = new ChartPanel(barras);
        pan3.setBounds(30, 260, 750, 350);
        try {
            BufferedImage imagenF = new BufferedImage(pan3.getWidth(), pan3.getHeight(), BufferedImage.TYPE_INT_ARGB);

            pan3.paint(imagenF.getGraphics());
            ImageIO.write(imagenF, "png", new File("FINAL.png"));
        } catch (Exception e) {
        }

    }
     
     


}
