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
 * @author fadli
 */


public class about extends Canvas implements CommandListener{


    private MainMidlet midlet;
    private DesignBackground designBackgound;
    private TiledLayer myTiled;
    Image imgbg;
    private Command cKembali = new Command("Kembali",Command.SCREEN, 1);


    int activeMenu;
    int tOpa = 1;
    String teks = "";
    Timer t = new Timer();
    TimerTask tt = new TimerTask() {
        public void run() {
            refresh();
        }
    };
    private Command command;

    public about(MainMidlet midlet) {
        this.midlet = midlet;
        t.schedule(tt, 0, 10);

  try {

            imgbg = Image.createImage("/Gambar/about.jpg");
        } catch (IOException ex) { ex.printStackTrace(); }

        designBackgound = new DesignBackground();
        myTiled = designBackgound.getBackGorundConten();

         this.addCommand(cKembali);
         setCommandListener(this);
    }

    protected void paint(Graphics g) {
        drawBackground(g);

    }

    private void drawBackground(Graphics g) {
        g.setColor(51, 185, 208);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(tOpa, tOpa, tOpa);
        g.drawString(teks, getWidth() / 2, getHeight() / 2,
                Graphics.TOP | Graphics.HCENTER);
        g.drawImage(imgbg, 0, 0, 0);
    }

      private void refresh() {
        if(tOpa > 5)
            tOpa -= 5;
        else
            tOpa = 0;
        repaint();
    }


    protected void keyRepeated(int keyCode) {
        this.keyPressed(keyCode);
    }


    public void commandAction(Command command, Displayable displayable) {
          if(command == cKembali){
            this.midlet.canvasmenu();
        }
    }
}
