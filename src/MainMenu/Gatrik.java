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


public class Gatrik implements CommandListener{


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

    public Gatrik(MainMidlet midlet) {
        this.midlet = midlet;
        try {

        imgbg = Image.createImage("/Gambar/Gatrik.jpg");
        } catch (IOException ex) { ex.printStackTrace(); }

        designBackgound = new DesignBackground();
        myTiled = designBackgound.getBackGorundConten();

        f = new Form("Gatrik");
        f.addCommand(cKembali);
//        f.addCommand(cExit);
        f.setCommandListener(this);
        tickerMenu = new Ticker(teksTickerMenu);
        f.setTicker(tickerMenu);
        f.append(imgbg);
        f.append("Permainan dimainkan oleh dua orang atau dua regu yang beranggotakan beberapa orang. Alat yang dimainkan adalah tongkat pemukul terbuat dari kayu dan potongan kayu sepanjang seperempat tongkat pemukul, yang biasa disebut “anak gatrik”. Anak gatrik diletakkan di lubang miring dan sempit dengan setengah panjangnya menyembul di permukaan tanah. Ujung anak gatrik dipukul dengan tongkat pemukul. Anak gatrik kembali dipukul sejauh-jauhnya ketika terlontar ke udara. Bila anak gatrik tertangkap lawan, pemain dinyatakan kalah. Bila tidak tertangkap, jarak antara lubang dan tempat jatuhnya dihitung untukmenentukan pemenangnya.");
        this.midlet.myDisplay.setCurrent(f);
    }

    public void commandAction(Command command, Displayable displayable) {
        if(command == cKembali){
            this.midlet.menuawal();
        }
    }

}