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
 * @author Sari Herawati
 */


public class Oray implements CommandListener{


   private MainMidlet midlet;
     Image imgbg;

   // private Image imgnurisayaphitam;
    Ticker tickerMenu;

     private String teksTickerMenu =
    "Selamat Datang di Sistem Informasi Kaulinan Barudak Sunda";


    private Command cKembali = new Command("Kembali",Command.SCREEN, 1);
//    private Command cExit = new Command("Exit",Command.SCREEN, 1);


    private Command command;

    public Oray(MainMidlet midlet) {
        this.midlet = midlet;
            try {

        imgbg = Image.createImage("/Gambar/Oray-orayan.jpg");
        } catch (IOException ex) { ex.printStackTrace(); }
            
    Form f = new Form("");
        f = new Form("Oray-orayan");
        f.addCommand(cKembali);
//        f.addCommand(cExit);
        f.setCommandListener(this);
        tickerMenu = new Ticker(teksTickerMenu);
        f.setTicker(tickerMenu);
        f.append(imgbg);
        f.append("Permainan ini dimainkan beberapa anak perempuan maupun lelaki di lapangan terbuka. Para pemain saling memegang ujung baju bagian belakang teman didepannya untuk membentuk barisan panjang. Pemain terdepan berusaha menangkap pemain yang paling belakang yang akan menghindar, sehingga barisan bergerak-meliuk-liuk seperti ular, tetapi barisan itu tidak boleh terputus. Sambil bermain, pemain melantunkan kawih. Oray-orayan luar leor ka sawah …, Tong ka sawah parena keur sedeng beukah Oray-orayan luar leor ka kebon …, Tong ka kebon aya barudak keur ngangon.");
        this.midlet.myDisplay.setCurrent(f);
    }

    public void commandAction(Command command, Displayable displayable) {
        if(command == cKembali){
            this.midlet.menuawal();
        }
    }

}