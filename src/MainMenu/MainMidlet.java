/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MainMenu;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Sari Herawati
 */
public class MainMidlet extends MIDlet {

    public Display myDisplay;



  CanvasMenu myCanvasMenu = new CanvasMenu(this);

    public MainMidlet(){
        String data="";
        splash splash = new splash(this);
        splash.start();
        myDisplay = Display.getDisplay(this);
        myDisplay.setCurrent(splash);
    }

    public void splash(){
        splash spl = new splash(this);
        spl.start();
        myDisplay.setCurrent(spl);
    }
    public void startApp() {

    }

    public void pauseApp() {

    }

    public void destroyApp(boolean unconditional) {

    }

     public void exitMidlet() {
        myDisplay.setCurrent(null);
        destroyApp(true);
        notifyDestroyed();
    }
    
     public void menuawal() {
        menu myContent2 = new menu(this);
        myDisplay.setCurrent(myContent2);
    }
 
     public void menujajangkungan() {
        Jajangkungan myContent5 = new Jajangkungan(this);
       // myDisplay.setCurrent(myContent5);
    }

      public void menupaciwit() {
        Paciwit myContent5 = new Paciwit(this);
    }

      public void menugatrik() {
        Gatrik myContent5 = new Gatrik(this);
    }
      
        public void menuperepet() {
        Perepet myContent5 = new Perepet(this);
    }
        public void menuOray() {
        Oray myContent5 = new Oray (this);
       //myDisplay.setCurrent(myContent5);
    }
      public void menuabout() {
        about myContent6 = new about(this);
       myDisplay.setCurrent(myContent6);
    }


    public void MainMenu(){
        myDisplay.setCurrent(myCanvasMenu);
    }

    public void canvasmenu(){
        CanvasMenu cm = new CanvasMenu(this);
        myDisplay.setCurrent(cm);
    }

    public void menukuis() {
        Soal1 soal1 = new Soal1(this);
        myDisplay.setCurrent(soal1);
    }

    void soal2() {
        Soal2 soal2 = new Soal2(this);
        myDisplay.setCurrent(soal2);    
    }

    void salah() {
        Salah salah = new Salah(this);
        myDisplay.setCurrent(salah);
    }

    void benar() {
        Selamat benar = new Selamat(this);
        myDisplay.setCurrent(benar);
    }



}
