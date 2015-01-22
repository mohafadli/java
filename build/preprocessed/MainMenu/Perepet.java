/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainMenu;

import Content.DesignBackground;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.TiledLayer;


/**
 *
 * @author Muhammad Adam Suryana
 */
public class Perepet implements CommandListener{


   private MainMidlet midlet;
   private DesignBackground designBackgound;
    private TiledLayer myTiled;
    Image imgbg;


   // private Image imgnurisayaphitam;
    Ticker tickerMenu;

     private String teksTickerMenu =
    "Selamat Datang di Sistem Informasi Kaulinan Barudak Sunda";


    private Command cKembali = new Command("Kembali",Command.SCREEN, 1);
//    private Command cExit = new Command("Exit",Command.SCREEN, 1);


    Form f = new Form("");

    private Command command;

    public Perepet(MainMidlet midlet) {
        this.midlet = midlet;
        
        try {

        imgbg = Image.createImage("/Gambar/Perepet-Jengkol.jpg");
        } catch (IOException ex) { ex.printStackTrace(); }

        designBackgound = new DesignBackground();
        myTiled = designBackgound.getBackGorundConten();

        f = new Form("Perepet Jengkol");
        f.addCommand(cKembali);
//        f.addCommand(cExit);
        f.setCommandListener(this);
        tickerMenu = new Ticker(teksTickerMenu);
        f.setTicker(tickerMenu);
        
        f.append("Permainan ini dilakukan oleh 3-4 anak perempuan atau lelaki. Pemain berdiri saling membelakangi, berpegangan tangan, dan salah satu kaki saling berkaitan di arah belakang. Dengan berdiri dengan sebelah kaki, pemain harus menjaga keseimbangannya agar tidak terjatuh, sambil bergerak berputar ke arah kiri atau kanan menuruti aba-aba si “dalang”, yang bertepuk tangan sambil melantunkan kawih."
                + "Perepet jengkol jajahean.., Kadempet kohkol jejeretean…"
                + "Tidak ada pihak yang dinyatakan menang atau kalah dalam permainan ini."
                + "Jadi, jenis permainan ini hanya dimainkan untuk bersenang-senang pada saat terang bulan.");
        this.midlet.myDisplay.setCurrent(f);
    }

    public void commandAction(Command command, Displayable displayable) {
        if(command == cKembali){
            this.midlet.menuawal();
        }
    }

}