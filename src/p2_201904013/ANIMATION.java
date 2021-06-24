
package p2_201904013;

import java.awt.Label;
import javax.swing.JOptionPane;

public class ANIMATION implements Runnable{
Label etiqueta;

    public ANIMATION(Label cronometro) {
        this.etiqueta = cronometro;
    }

    @Override
    public void run() {
        
       try {
           int x=0;
           while (ANIMACION.iniciarCrono) {               
               Thread.sleep(1);
               Ejec(x);
               x++;
           }
        } catch (Exception e) {
        }
    }

    private void Ejec(int x) {
    ANIMACION.MILESIMAS++;
    
        if (ANIMACION.MILESIMAS>999) {
            ANIMACION.MILESIMAS=0;
            ANIMACION.SEGUNDOS++;
            if (ANIMACION.SEGUNDOS>59) {
                ANIMACION.SEGUNDOS=0;
            ANIMACION.MINUTOS++;
                if (ANIMACION.MINUTOS>4) {
                    JOptionPane.showMessageDialog(null,"Alfedo camate pofavo");
                }
            }
        }
     String TMIL="", TSEG="", TMIN="";   
     
        if (ANIMACION.MILESIMAS<10) {
            TMIL="0"+ANIMACION.MILESIMAS;
        }else{
         TMIL=""+ANIMACION.MILESIMAS;
        }
        
        if (ANIMACION.SEGUNDOS<10) {
            TSEG="0"+ANIMACION.SEGUNDOS;
        }else{
         TSEG=""+ANIMACION.SEGUNDOS;
        }
        
        if (ANIMACION.MINUTOS<10) {
            TMIN="0"+ANIMACION.MINUTOS;
        }else{
         TMIN=""+ANIMACION.MINUTOS;
        }
     
     
     String relojito= TMIN+":"+TSEG+":"+TMIL;
     etiqueta.setText(relojito);
    }
    
    
    
}
