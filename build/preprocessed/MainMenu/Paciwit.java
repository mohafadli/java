/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MainMenu;

import MainMenu.MainMidlet;
import java.io.IOException;
import javax.microedition.lcdui.*;
/**
 *
 * @author Sari Herawati
 */


public class Paciwit implements CommandListener{


   private MainMidlet midlet;
   Image imgbg;

   // private Image;
    Ticker tickerMenu;

     private String teksTickerMenu =
    "Selamat Datang di Sistem Informasi Kaulinan Barudak Sunda";


    private Command cKembali = new Command("Kembali",Command.SCREEN, 1);
//    private Command cExit = new Command("Exit",Command.SCREEN, 1);


    Form f = new Form("");

    private Command command;

    public Paciwit(MainMidlet midlet) {
        this.midlet = midlet;
                    try {

        imgbg = Image.createImage("/Gambar/paciwit2.jpg");
        } catch (IOException ex) { ex.printStackTrace(); }
        f = new Form("Paciwit-ciwit Lutung");
        f.addCommand(cKembali);
//        f.addCommand(cExit);
        f.setCommandListener(this);
        tickerMenu = new Ticker(teksTickerMenu);
        f.setTicker(tickerMenu);
        f.append(imgbg);
        f.append("Permainan ini dilakukan oleh 3-4 orang anak, baik anak perempuan maupun lelaki. Setiap pemain berusaha saling mendahului mencubit (nyiwit) punggung tangan di urutan teratas sambil melantunkan kawih (nyanyian): Paciwit-ciwit lutung, Si Lutung pindah ka tungtung, Paciwit-ciwit lutung, Si Lutung pindah ka tungtung. Pada umumnya, tidak ada pihak yang dinyatakan menang atau kalah. Jadi, jenis permainan ini semata-mata dilakukan hanya untuk bersenang-senang dan mengisi waktu pada malam terang bulan.");
                this.midlet.myDisplay.setCurrent(f);
    }



    public void commandAction(Command command, Displayable displayable) {
        if(command == cKembali){
            this.midlet.menuawal();
        }
    }
}