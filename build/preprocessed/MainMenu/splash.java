/*
 * splash.java
 *
 * Created on May 7, 2010, 2:32 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package MainMenu;

import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;

/**
 *
 * @author Uday
 */
public class splash extends GameCanvas implements Runnable{
    
    /** Creates a new instance of splash */
    Thread thread = new Thread(this);
    MainMidlet midlet;
    boolean running;
    Image imageSplash;
    int Konter;

    private int timer1=0;
    private boolean bool_draw1=false;
    private boolean bool_draw2=false;
    private boolean bool_terang=true;
    
    public splash(MainMidlet midlet) {
        super(true);
        
        this.midlet = midlet;
        running = true;
        
        try {
            imageSplash = Image.createImage("/Gambar/kaulinan barudak.JPG");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        Konter = 0;
    }

  
    public void run() {
        while(running == true){
            Graphics g = getGraphics();
            Konter+=1;
            DrawSplash(g);
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            if(Konter >= 100){
                running=false;
            }

        }
        
      midlet.canvasmenu();
    }
    
    public void start(){
        thread.start();
    }

    private void timer_1(){
        timer1++;
        if(timer1==50){//100 = 1 detik
            bool_draw1=true;
        }else if((timer1==100)&&(bool_terang)){
            bool_draw2=true;
        }else if(timer1==250){
            bool_draw2=false;
            bool_terang=false;
        }
    }


    private void DrawSplash(Graphics g) {
        //g.setColor(0xB2A285);
        
        g.setColor(255,255,255);
        g.fillRect(0,0,getWidth(),getHeight());
        
        g.setColor(32,32,32);
        g.fillRoundRect((getWidth()/2)-120,20,180,230,20,20);
        
        g.drawImage(imageSplash,0,0,0);
        
        // mengatur font
        g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        
        g.setColor(253, 4, 16);
        g.drawString("LODING...", getWidth()/2, getHeight()-90, g.HCENTER|g.BASELINE);
        
        // menampilkan persentase
        g.drawString( Integer.toString(Konter) + " %", getWidth()/2, getHeight()-70, g.HCENTER|g.BASELINE);
        
        // membuat loading
        g.drawRect((getWidth()/2)-100, getHeight()-60, 200, 10);
        g.fillRect((getWidth()/2)-100, getHeight()-60, (200*Konter)/100, 10);
        
        // menggambar ke canvas
        flushGraphics();
    }
    
}
