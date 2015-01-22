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
 * @author Muhammad Adam Suryana
 */

public class Jajangkungan implements CommandListener{


    private MainMidlet midlet;
    Image imgbg;

   // private Image imgnurisayaphitam;
    Ticker tickerMenu;

     private String teksTickerMenu =
    "Selamat Datang di Sistem Informasi Kaulinan Barudak Sunda";


    private Command cKembali = new Command("Kembali",Command.SCREEN, 1);
//    private Command cExit = new Command("Exit",Command.SCREEN, 1);


    Form f = new Form("");

    private Command command;

    public Jajangkungan(MainMidlet midlet) {
        this.midlet = midlet;
                    try {

        imgbg = Image.createImage("/Gambar/Jajangkungan.jpg");
        } catch (IOException ex) { ex.printStackTrace(); }
        f = new Form("Jajangkungan");
        f.addCommand(cKembali);
//        f.addCommand(cExit);
        f.setCommandListener(this);
        tickerMenu = new Ticker(teksTickerMenu);
        f.setTicker(tickerMenu);
        f.append(imgbg);
        f.append("Permainan Jajangkungan dimainkan dengan sepasang tongkat atau galah, yang terbuat dari kayu atau bambu. Tumpuan untuk pijakan kaki dibuat pada ketinggian 30 – 60 cm dari ujung bawah tongkat. Beberapa orang pemain dapat serentak memainkannya bersama-sama. Permainan ini biasa digabungkan dengan jenis permainan lain, seperti adu lari atau sepak bola. Ada kalanya, penilaian hanya pada adu ketahanan berjalan di atas jajangkungan sambil saling menendang kaki jajangkungan lawan bermain. Pemain yang terjatuh dinyatakan kalah.");
        this.midlet.myDisplay.setCurrent(f);
    }



    public void commandAction(Command command, Displayable displayable) {
        if(command == cKembali){
            this.midlet.menuawal();
        }
    }
}
