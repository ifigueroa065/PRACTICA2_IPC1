
package p2_201904013;

import com.sun.org.apache.bcel.internal.generic.IfInstruction;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import static p2_201904013.ANIMACION.CONTPASOS;
import static p2_201904013.ANIMACION.MILESIMAS;
import static p2_201904013.ANIMACION.MINUTOS;
import static p2_201904013.ANIMACION.N10;
import static p2_201904013.ANIMACION.N11;
import static p2_201904013.ANIMACION.N12;
import static p2_201904013.ANIMACION.N6;
import static p2_201904013.ANIMACION.N7;
import static p2_201904013.ANIMACION.N8;
import static p2_201904013.ANIMACION.N9;
import static p2_201904013.ANIMACION.PANELITO2;
import static p2_201904013.ANIMACION.REPORTE;
import static p2_201904013.ANIMACION.SEGUNDOS;
import static p2_201904013.ANIMACION.condicion;
import static p2_201904013.ANIMACION.volverP;
import static p2_201904013.INTERFAZ.CONTDATOS;
import static p2_201904013.INTERFAZ.title;
import static p2_201904013.OP_ORDENAMIENTO.TIPORD;
import static p2_201904013.P2_201904013.DATOSGRA;
import static p2_201904013.OP_ORDENAMIENTO.*;


public class PROCESS_ANIMACION extends Thread{
 ANIMACION ventana;

    public PROCESS_ANIMACION(ANIMACION ventana) {
        this.ventana = ventana;
        this.start();
    }
    public void run() {
       
        if (ascendente.isSelected()) {
            TIPORD = "ascendente";

            if (baja.isSelected()) {
                VELOZ = "baja";
                if (bubble.isSelected()) {
                    ALGORIT = "bubble";

                    ventana.setVisible(true);
                    OBTENER_DATOS();
                    BUBBLE_SORT_BAJA(TIPORD);
                    

                    
                } else if (quick.isSelected()) {
                    ALGORIT = "quick";
                    ventana.setVisible(true);
                    OBTENER_DATOS();
                    QUICK_BAJA(1, CONTDATOS - 1);
                } else {
                    ALGORIT = "shell";
                    ventana.setVisible(true);
                    OBTENER_DATOS();
                    SHELL_SORT_BAJA(TIPORD);
                }
            } else if (media.isSelected()) {
                VELOZ = "media";

                if (bubble.isSelected()) {
                    ALGORIT = "bubble";
                    ventana.setVisible(true);
                    OBTENER_DATOS();
                    BUBBLE_SORT_MEDIA(TIPORD);
                } else if (quick.isSelected()) {
                    ALGORIT = "quick";
                    ventana.setVisible(true);
                    OBTENER_DATOS();
                    QUICK_MEDIA(1, CONTDATOS - 1);
                } else {
                    ALGORIT = "shell";
                    ventana.setVisible(true);
                    OBTENER_DATOS();
                    SHELL_SORT_MEDIA(TIPORD);
                }

            } else {
                VELOZ = "alta";
                if (bubble.isSelected()) {
                    ALGORIT = "bubble";
                    ventana.setVisible(true);
                    OBTENER_DATOS();
                    BUBBLE_SORT_ALTA(TIPORD);
                } else if (quick.isSelected()) {
                    ALGORIT = "quick";
                    ventana.setVisible(true);
                    OBTENER_DATOS();
                    QUICK_ALTA(1, CONTDATOS - 1);
                } else {
                    ALGORIT = "shell";
                    ventana.setVisible(true);
                    OBTENER_DATOS();
                    SHELL_SORT_ALTA(TIPORD);
                }
            }

            System.out.println("***************");
        } else {
            TIPORD = "descendente";

            if (baja.isSelected()) {
                VELOZ = "baja";
                if (bubble.isSelected()) {
                    ALGORIT = "bubble";
                    ventana.setVisible(true);
                    OBTENER_DATOS();
                    BUBBLE_SORT_BAJA(TIPORD);
                } else if (quick.isSelected()) {
                    ALGORIT = "quick";
                    ventana.setVisible(true);
                    OBTENER_DATOS();
                    QUICK_BAJA2(1, CONTDATOS - 1);
                } else {
                    ALGORIT = "shell";
                    ventana.setVisible(true);
                    OBTENER_DATOS();
                    SHELL_SORT_BAJA(TIPORD);
                }
            } else if (media.isSelected()) {
                VELOZ = "media";

                if (bubble.isSelected()) {
                    ALGORIT = "bubble";
                    ventana.setVisible(true);
                    OBTENER_DATOS();
                    BUBBLE_SORT_MEDIA(TIPORD);
                } else if (quick.isSelected()) {
                    ALGORIT = "quick";
                    ventana.setVisible(true);
                    OBTENER_DATOS();
                    QUICK_MEDIA2(1, CONTDATOS - 1);
                } else {
                    ALGORIT = "shell";
                    ventana.setVisible(true);
                    OBTENER_DATOS();
                    SHELL_SORT_MEDIA(TIPORD);
                }
            } else {
                VELOZ = "alta";
                if (bubble.isSelected()) {
                    ALGORIT = "bubble";
                    ventana.setVisible(true);
                    OBTENER_DATOS();
                    BUBBLE_SORT_ALTA(TIPORD);
                } else if (quick.isSelected()) {
                    ALGORIT = "quick";
                    ventana.setVisible(true);
                    OBTENER_DATOS();
                    QUICK_ALTA2(1, CONTDATOS - 1);
                } else {
                    ALGORIT = "shell";
                    ventana.setVisible(true);
                    OBTENER_DATOS();
                    SHELL_SORT_ALTA(TIPORD);
                }
            }
        }
    }
   

    /*ORDENAMIENTOS DE BURBUJA*/
    public void BUBBLE_SORT_BAJA(String TIPO) {
        ANIMATION crono = new ANIMATION(N9);
        Thread TIMER = new Thread(crono);
        TIMER.start();
        if (TIPO.equalsIgnoreCase("ascendente")) {
            while (condicion = !false) {
                try {
                    String auxCAT;
                    String auxCANT;
                    //APLICANDO EL ORDENAMIENTO BURBUJA
                    GENERARGRAFO();
                    pan2.setVisible(false);
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

                                /*CONTANDO PASOS*/
                                CONTPASOS++;
                                N10.setText(Integer.toString(CONTPASOS));

                                /*GENERANDO EL NUEVO GRAFO*/
                                GENERARGRAFO();
                                Thread.sleep(1000);
                                pan2.setVisible(false);

                            }
                        }
                    }
                    condicion = false;
                    pan2.setVisible(true);
                    ANIMACION.iniciarCrono = false;
                    REPORTE.setEnabled(true);
                     volverP.setEnabled(true);
                } catch (Exception e) {
                }
            }

            for (int i = 0; i < DATOSGRA.length - 1; i++) {

                System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                System.out.println("************************************");

            }
        } else {
            while (condicion = !false) {
                try {
                    String auxCAT;
                    String auxCANT;
                    //APLICANDO EL ORDENAMIENTO BURBUJA
                    GENERARGRAFO();
                    pan2.setVisible(false);
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

                                /*CONTANDO PASOS*/
                                CONTPASOS++;
                                N10.setText(Integer.toString(CONTPASOS));

                                /*GENERANDO EL NUEVO GRAFO*/
                                GENERARGRAFO();
                                Thread.sleep(1000);
                                pan2.setVisible(false);
                            }
                        }
                    }
                    condicion = false;
                    pan2.setVisible(true);
                    ANIMACION.iniciarCrono = false;
                    REPORTE.setEnabled(true);
                     volverP.setEnabled(true);
                } catch (Exception e) {
                }

            }
            for (int i = 0; i < DATOSGRA.length - 1; i++) {

                System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                System.out.println("************************************");

            }
        }

    }

    public void BUBBLE_SORT_MEDIA(String TIPO) {
        ANIMATION crono = new ANIMATION(N9);
        Thread TIMER = new Thread(crono);
        TIMER.start();
        if (TIPO.equalsIgnoreCase("ascendente")) {
            while (condicion = !false) {
                try {
                    String auxCAT;
                    String auxCANT;
                    //APLICANDO EL ORDENAMIENTO BURBUJA
                    GENERARGRAFO();
                    pan2.setVisible(false);
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

                                /*CONTANDO PASOS*/
                                CONTPASOS++;
                                N10.setText(Integer.toString(CONTPASOS));

                                /*GENERANDO EL NUEVO GRAFO*/
                                GENERARGRAFO();
                                Thread.sleep(500);
                                pan2.setVisible(false);

                            }
                        }
                    }
                    condicion = false;
                    pan2.setVisible(true);
                    ANIMACION.iniciarCrono = false;
                    REPORTE.setEnabled(true);
                     volverP.setEnabled(true);
                } catch (Exception e) {
                }
            }
            for (int i = 0; i < DATOSGRA.length - 1; i++) {

                System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                System.out.println("************************************");

            }
        } else {
            while (condicion = !false) {
                try {
                    String auxCAT;
                    String auxCANT;
                    //APLICANDO EL ORDENAMIENTO BURBUJA
                    GENERARGRAFO();
                    pan2.setVisible(false);
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

                                /*CONTANDO PASOS*/
                                CONTPASOS++;
                                N10.setText(Integer.toString(CONTPASOS));

                                /*GENERANDO EL NUEVO GRAFO*/
                                GENERARGRAFO();
                                Thread.sleep(500);
                                pan2.setVisible(false);
                            }
                        }
                    }
                    condicion = false;
                    pan2.setVisible(true);
                    ANIMACION.iniciarCrono = false;
                    REPORTE.setEnabled(true);
                     volverP.setEnabled(true);
                } catch (Exception e) {
                }

            }
            for (int i = 0; i < DATOSGRA.length - 1; i++) {

                System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                System.out.println("************************************");

            }
        }

    }
    
    public void BUBBLE_SORT_ALTA(String TIPO) {
        ANIMATION crono = new ANIMATION(N9);
        Thread TIMER = new Thread(crono);
        TIMER.start();
        if (TIPO.equalsIgnoreCase("ascendente")) {
            while (condicion = !false) {
                try {
                    String auxCAT;
                    String auxCANT;
                    //APLICANDO EL ORDENAMIENTO BURBUJA
                    GENERARGRAFO();
                    pan2.setVisible(false);
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

                                /*CONTANDO PASOS*/
                                CONTPASOS++;
                                N10.setText(Integer.toString(CONTPASOS));

                                /*GENERANDO EL NUEVO GRAFO*/
                                GENERARGRAFO();
                                Thread.sleep(250);
                                pan2.setVisible(false);

                            }
                        }
                    }
                    condicion = false;
                    pan2.setVisible(true);
                    ANIMACION.iniciarCrono = false;
                    REPORTE.setEnabled(true);
                    volverP.setEnabled(true);
                    
                } catch (Exception e) {
                }
            }
            for (int i = 0; i < DATOSGRA.length - 1; i++) {

                System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                System.out.println("************************************");

            }
        } else {
           while (condicion = !false) {
                try {
                    String auxCAT;
                    String auxCANT;
                    //APLICANDO EL ORDENAMIENTO BURBUJA
                    GENERARGRAFO();
                    pan2.setVisible(false);
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

                                /*CONTANDO PASOS*/
                                CONTPASOS++;
                                N10.setText(Integer.toString(CONTPASOS));

                                /*GENERANDO EL NUEVO GRAFO*/
                                GENERARGRAFO();
                                Thread.sleep(250);
                                pan2.setVisible(false);
                            }
                        }
                    }
                    condicion = false;
                    pan2.setVisible(true);
                    ANIMACION.iniciarCrono = false;
                    REPORTE.setEnabled(true);
                    volverP.setEnabled(true);
                } catch (Exception e) {
                }

            }
            for (int i = 0; i < DATOSGRA.length - 1; i++) {

                System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                System.out.println("************************************");

            }
        }

    }

    /*FUNCIONES EXTRA*/
    public void GENERARGRAFO() {

        JFreeChart barras = null;
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        String Y = DATOSGRA[0].getCANTIDAD();
        String X = DATOSGRA[0].getCATEGORIA();

        for (int i = 1; i < CONTDATOS ; i++) {
            float cantidad = Float.parseFloat(DATOSGRA[i].getCANTIDAD());
            String categoria = DATOSGRA[i].getCATEGORIA();
            datos.addValue(cantidad, "", categoria);
        }

        barras = ChartFactory.createBarChart3D(title, X, Y, datos, PlotOrientation.VERTICAL, true, true, false);

        pan2 = new ChartPanel(barras);
        pan2.setBounds(30, 260, 750, 350);
        pan2.setVisible(true);
        pan2.setEnabled(false);
        PANELITO2.add(pan2);
        PANELITO2.repaint();

    }

    static void OBTENER_DATOS() {
        N6.setText(ALGORIT);
        N7.setText(VELOZ);
        N8.setText(TIPORD);
    }

    /*ORDENAMIENTOS SHELL*/
    public void SHELL_SORT_BAJA(String TIPO) {
        ANIMATION crono = new ANIMATION(N9);
        Thread TIMER = new Thread(crono);
        TIMER.start();
        if (TIPO.equalsIgnoreCase("ascendente")) {
            while (condicion = !false) {
                try {
                    int salto, j, k;
                    float auxcant, auxcant2;
                    String AUXCANT;
                    String AUXCAT;

                    GENERARGRAFO();
                    pan2.setVisible(false);

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
                                    
                                    /*CONTANDO PASOS*/
                                    CONTPASOS++;
                                    N10.setText(Integer.toString(CONTPASOS));

                                    /*GENERANDO EL NUEVO GRAFO*/
                                    GENERARGRAFO();
                                    Thread.sleep(1000);
                                    pan2.setVisible(false);
                                    
                                    DATOSGRA[j + salto].setCANTIDAD(AUXCANT);
                                    DATOSGRA[j + salto].setCATEGORIA(AUXCAT);
                                    
                                     

                                    j = j - salto;
                                }

                            }
                        }
                        salto = salto / 2;
                    }
                    condicion = false;
                    pan2.setVisible(true);
                    ANIMACION.iniciarCrono = false;
                    REPORTE.setEnabled(true);
                     volverP.setEnabled(true);
                    for (int i = 0; i < DATOSGRA.length - 1; i++) {
                        System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                        System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                        System.out.println("************************************");

                    }
                } catch (Exception e) {
                }
            }

        } else {
            while (condicion != false) {
                try {
                    /*ORDENAMIENTO DESCENDENTE*/
                    int salto, j;
                    float auxcant, auxcant2;
                    String AUXCANT;
                    String AUXCAT;
                    GENERARGRAFO();
                    pan2.setVisible(false);
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
                                    /*CONTANDO PASOS*/
                                    CONTPASOS++;
                                    N10.setText(Integer.toString(CONTPASOS));

                                    /*GENERANDO EL NUEVO GRAFO*/
                                    GENERARGRAFO();
                                    Thread.sleep(1000);
                                    pan2.setVisible(false);

                                    DATOSGRA[j + salto].setCANTIDAD(AUXCANT);
                                    DATOSGRA[j + salto].setCATEGORIA(AUXCAT);
                                    j = j - salto;
                                }

                            }
                        }
                        salto = salto / 2;
                    }
                    condicion = false;
                    pan2.setVisible(true);
                    ANIMACION.iniciarCrono = false;
                    REPORTE.setEnabled(true);
                     volverP.setEnabled(true);
                    
                    for (int i = 0; i < DATOSGRA.length - 1; i++) {
                        System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                        System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                        System.out.println("************************************");

                    }
                } catch (Exception e) {
                }
            }

        }

    }

    public void SHELL_SORT_MEDIA(String TIPO) {
        ANIMATION crono = new ANIMATION(N9);
        Thread TIMER = new Thread(crono);
        TIMER.start();
        if (TIPO.equalsIgnoreCase("ascendente")) {
            while (condicion = !false) {
                try {
                    int salto, j, k;
                    float auxcant, auxcant2;
                    String AUXCANT;
                    String AUXCAT;

                    GENERARGRAFO();
                    pan2.setVisible(false);

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
                                    /*CONTANDO PASOS*/
                                    CONTPASOS++;
                                    N10.setText(Integer.toString(CONTPASOS));

                                    /*GENERANDO EL NUEVO GRAFO*/
                                    GENERARGRAFO();
                                    Thread.sleep(500);
                                    pan2.setVisible(false);

                                    DATOSGRA[j + salto].setCANTIDAD(AUXCANT);
                                    DATOSGRA[j + salto].setCATEGORIA(AUXCAT);
                                    j = j - salto;
                                }

                            }
                        }
                        salto = salto / 2;
                    }
                    condicion = false;
                    pan2.setVisible(true);
                    ANIMACION.iniciarCrono = false;
                    REPORTE.setEnabled(true);
                     volverP.setEnabled(true);
                    for (int i = 0; i < DATOSGRA.length - 1; i++) {
                        System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                        System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                        System.out.println("************************************");

                    }
                } catch (Exception e) {
                }
            }

        } else {
            while (condicion != false) {
                try {
                    /*ORDENAMIENTO DESCENDENTE*/
                    int salto, j;
                    float auxcant, auxcant2;
                    String AUXCANT;
                    String AUXCAT;
                    GENERARGRAFO();
                    pan2.setVisible(false);
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
                                    /*CONTANDO PASOS*/
                                    CONTPASOS++;
                                    N10.setText(Integer.toString(CONTPASOS));

                                    /*GENERANDO EL NUEVO GRAFO*/
                                    GENERARGRAFO();
                                    Thread.sleep(500);
                                    pan2.setVisible(false);

                                    DATOSGRA[j + salto].setCANTIDAD(AUXCANT);
                                    DATOSGRA[j + salto].setCATEGORIA(AUXCAT);
                                    j = j - salto;
                                }

                            }
                        }
                        salto = salto / 2;
                    }
                    condicion = false;
                    pan2.setVisible(true);
                    ANIMACION.iniciarCrono = false;
                    REPORTE.setEnabled(true);
                     volverP.setEnabled(true);
                    for (int i = 0; i < DATOSGRA.length - 1; i++) {
                        System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                        System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                        System.out.println("************************************");

                    }
                } catch (Exception e) {
                }
            }

        }

    }

    public void SHELL_SORT_ALTA(String TIPO) {
        ANIMATION crono = new ANIMATION(N9);
        Thread TIMER = new Thread(crono);
        TIMER.start();
        if (TIPO.equalsIgnoreCase("ascendente")) {
            while (condicion = !false) {
                try {
                    int salto, j, k;
                    float auxcant, auxcant2;
                    String AUXCANT;
                    String AUXCAT;

                    GENERARGRAFO();
                    pan2.setVisible(false);

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
                                    /*CONTANDO PASOS*/
                                    CONTPASOS++;
                                    N10.setText(Integer.toString(CONTPASOS));

                                    /*GENERANDO EL NUEVO GRAFO*/
                                    GENERARGRAFO();
                                    Thread.sleep(250);
                                    pan2.setVisible(false);

                                    DATOSGRA[j + salto].setCANTIDAD(AUXCANT);
                                    DATOSGRA[j + salto].setCATEGORIA(AUXCAT);
                                    j = j - salto;
                                }

                            }
                        }
                        salto = salto / 2;
                    }
                    condicion = false;
                    pan2.setVisible(true);
                    ANIMACION.iniciarCrono = false;
                    REPORTE.setEnabled(true);
                    volverP.setEnabled(true);

                    for (int i = 0; i < DATOSGRA.length - 1; i++) {
                        System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                        System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                        System.out.println("************************************");

                    }
                } catch (Exception e) {
                }
            }

        } else {
            while (condicion != false) {
                try {
                    /*ORDENAMIENTO DESCENDENTE*/
                    int salto, j;
                    float auxcant, auxcant2;
                    String AUXCANT;
                    String AUXCAT;
                    GENERARGRAFO();
                    pan2.setVisible(false);
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
                                    /*CONTANDO PASOS*/
                                    CONTPASOS++;
                                    N10.setText(Integer.toString(CONTPASOS));

                                    /*GENERANDO EL NUEVO GRAFO*/
                                    GENERARGRAFO();
                                    Thread.sleep(250);
                                    pan2.setVisible(false);

                                    DATOSGRA[j + salto].setCANTIDAD(AUXCANT);
                                    DATOSGRA[j + salto].setCATEGORIA(AUXCAT);
                                    j = j - salto;
                                }

                            }
                        }
                        salto = salto / 2;
                    }
                    condicion = false;
                    pan2.setVisible(true);
                    ANIMACION.iniciarCrono = false;
                    REPORTE.setEnabled(true);
                     volverP.setEnabled(true);
                    for (int i = 0; i < DATOSGRA.length - 1; i++) {
                        System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                        System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                        System.out.println("************************************");

                    }
                } catch (Exception e) {
                }
            }

        }

    }

    /*ORDENAMIENTOS QUICK ASCEDENTE*/
    public void QUICK_BAJA(int iz, int der) {
        ANIMATION crono = new ANIMATION(N9);
        Thread TIMER = new Thread(crono);
        TIMER.start();
        while (condicion != false) {
            try {
                String auxCAT;
                int lo = iz;
                int hi = der;
                if (lo >= der) {

                    return;
                }
                /*Grafica Inicial*/
                GENERARGRAFO();
                pan2.setVisible(false);

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

                        /*CONTANDO PASOS*/
                        CONTPASOS++;
                        N10.setText(Integer.toString(CONTPASOS));

                        /*GENERANDO EL NUEVO GRAFO*/
                        GENERARGRAFO();
                        Thread.sleep(1000);
                        pan2.setVisible(false);

                    }

                }
                if (hi < lo) {
                    int T = hi;
                    hi = lo;
                    lo = T;
                }

                QUICK_BAJA(iz, lo);

                QUICK_BAJA(lo == iz ? lo + 1 : lo, der);

                condicion = false;
                pan2.setVisible(true);
                ANIMACION.iniciarCrono = false;
                REPORTE.setEnabled(true);
                 volverP.setEnabled(true);

                for (int i = 0; i < DATOSGRA.length - 1; i++) {

                    System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                    System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                    System.out.println("************************************");

                }
            } catch (Exception e) {
            }
        }

    }

    public void QUICK_MEDIA(int iz, int der) {
        ANIMATION crono = new ANIMATION(N9);
        Thread TIMER = new Thread(crono);
        TIMER.start();
        while (condicion != false) {
            try {
                String auxCAT;
                int lo = iz;
                int hi = der;
                if (lo >= der) {
                    return;
                }
                /*Grafica Inicial*/
                GENERARGRAFO();
                pan2.setVisible(false);

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
                        /*CONTANDO PASOS*/
                        CONTPASOS++;
                        N10.setText(Integer.toString(CONTPASOS));

                        /*GENERANDO EL NUEVO GRAFO*/
                        GENERARGRAFO();
                        Thread.sleep(500);
                        pan2.setVisible(false);

                    }
                }
                if (hi < lo) {
                    int T = hi;
                    hi = lo;
                    lo = T;
                }
                quick_srt(iz, lo);
                quick_srt(lo == iz ? lo + 1 : lo, der);

                condicion = false;
                pan2.setVisible(true);
                ANIMACION.iniciarCrono = false;
                REPORTE.setEnabled(true);
                 volverP.setEnabled(true);
                for (int i = 0; i < DATOSGRA.length - 1; i++) {

                    System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                    System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                    System.out.println("************************************");

                }
            } catch (Exception e) {
            }
        }

    }

    public void QUICK_ALTA(int iz, int der) {
        ANIMATION crono = new ANIMATION(N9);
        Thread TIMER = new Thread(crono);
        TIMER.start();
        while (condicion != false) {
            try {

                String auxCAT;
                int lo = iz;
                int hi = der;
                if (lo >= der) {
                    return;
                }

                int mid = Integer.parseInt(DATOSGRA[(lo + hi) / 2].getCANTIDAD());
                /*Grafica Inicial*/
                GENERARGRAFO();
                pan2.setVisible(false);

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
                        
                         /*CONTANDO PASOS*/
                        CONTPASOS++;
                        N10.setText(Integer.toString(CONTPASOS));

                        /*GENERANDO EL NUEVO GRAFO*/
                        GENERARGRAFO();
                        Thread.sleep(250);
                        pan2.setVisible(false);
                        
                        DATOSGRA[hi].setCANTIDAD(String.valueOf(T));
                        DATOSGRA[hi].setCATEGORIA(auxCAT);
                        

                    }

                }
               
                if (hi < lo) {
                    int T = hi;
                    hi = lo;
                    lo = T;
                }
                QUICK_ALTA(iz, lo);
                QUICK_ALTA(lo == iz ? lo + 1 : lo, der);

                condicion = false;
                pan2.setVisible(true);
                ANIMACION.iniciarCrono = false;
                REPORTE.setEnabled(true);
                volverP.setEnabled(true);

                for (int i = 0; i < DATOSGRA.length - 1; i++) {

                    System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                    System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                    System.out.println("************************************");

                }
            } catch (Exception e) {
            }
        }

    }

    /*ORDENAMIENTOS QUICK DESCENDENTE*/
    public void QUICK_BAJA2(int iz, int der) {
        ANIMATION crono = new ANIMATION(N9);
        Thread TIMER = new Thread(crono);
        TIMER.start();
        while (condicion != false) {
            try {
                String auxCAT;
                int lo = iz;
                int hi = der;
                if (lo >= der) {
                    return;
                }

                /*Grafica Inicial*/
                GENERARGRAFO();
                pan2.setVisible(false);

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
                        /*CONTANDO PASOS*/
                        CONTPASOS++;
                        N10.setText(Integer.toString(CONTPASOS));

                        /*GENERANDO EL NUEVO GRAFO*/
                        GENERARGRAFO();
                        Thread.sleep(1000);
                        pan2.setVisible(false);
                    }
                }
                if (hi < lo) {
                    int T = hi;
                    hi = lo;
                    lo = T;
                }
                quick_srt2(iz, lo);
                quick_srt2(lo == iz ? lo + 1 : lo, der);
                condicion = false;
                pan2.setVisible(true);
                ANIMACION.iniciarCrono = false;
                REPORTE.setEnabled(true);
                 volverP.setEnabled(true);
                for (int i = 0; i < DATOSGRA.length - 1; i++) {

                    System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                    System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                    System.out.println("************************************");

                }
            } catch (Exception e) {
            }
        }

    }

    public void QUICK_MEDIA2(int iz, int der) {
        ANIMATION crono = new ANIMATION(N9);
        Thread TIMER = new Thread(crono);
        TIMER.start();
        while (condicion != false) {
            try {
                String auxCAT;
                int lo = iz;
                int hi = der;
                if (lo >= der) {
                    return;
                }

                /*Grafica Inicial*/
                GENERARGRAFO();
                pan2.setVisible(false);

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
                        /*CONTANDO PASOS*/
                        CONTPASOS++;
                        N10.setText(Integer.toString(CONTPASOS));

                        /*GENERANDO EL NUEVO GRAFO*/
                        GENERARGRAFO();
                        Thread.sleep(500);
                        pan2.setVisible(false);
                    }
                }
                if (hi < lo) {
                    int T = hi;
                    hi = lo;
                    lo = T;
                }
                quick_srt2(iz, lo);
                quick_srt2(lo == iz ? lo + 1 : lo, der);

                condicion = false;
                pan2.setVisible(true);
                ANIMACION.iniciarCrono = false;
                REPORTE.setEnabled(true);
                  volverP.setEnabled(true);
                for (int i = 0; i < DATOSGRA.length - 1; i++) {

                    System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                    System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                    System.out.println("************************************");

                }
            } catch (Exception e) {
            }
        }

    }

    public void QUICK_ALTA2(int iz, int der) {
        ANIMATION crono = new ANIMATION(N9);
        Thread TIMER = new Thread(crono);
        TIMER.start();
        while (condicion != false) {
            try {
                String auxCAT;
                int lo = iz;
                int hi = der;
                if (lo >= der) {
                    return;
                }

                /*Grafica Inicial*/
                GENERARGRAFO();
                pan2.setVisible(false);

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
                        /*CONTANDO PASOS*/
                        CONTPASOS++;
                        N10.setText(Integer.toString(CONTPASOS));

                        /*GENERANDO EL NUEVO GRAFO*/
                        GENERARGRAFO();
                        Thread.sleep(250);
                        pan2.setVisible(false);
                    }
                }
                if (hi < lo) {
                    int T = hi;
                    hi = lo;
                    lo = T;
                }
                quick_srt2(iz, lo);
                quick_srt2(lo == iz ? lo + 1 : lo, der);

                condicion = false;
                pan2.setVisible(true);
                ANIMACION.iniciarCrono = false;
                REPORTE.setEnabled(true);
                 volverP.setEnabled(true);
                for (int i = 0; i < DATOSGRA.length - 1; i++) {

                    System.out.println(" CANTIDAD: " + DATOSGRA[i].getCANTIDAD());
                    System.out.println(" CATEGORIA: " + DATOSGRA[i].getCATEGORIA());
                    System.out.println("************************************");

                }
            } catch (Exception e) {
            }
        }

    }

    public void GRAFOS_REPO(String Tipo) {
        if (Tipo.equalsIgnoreCase("ascendente")) {
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
         if (ascendente.isSelected()) {
             TIPORD = "ascendente";
             GRAFO_INICIAL();
             BUBBLE_SORT(TIPORD);
             GRAFO_FINAL();
         } else {
              TIPORD = "descendente";
             GRAFO_INICIAL();
             BUBBLE_SORT(TIPORD);
             GRAFO_FINAL();
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

    
    

}
