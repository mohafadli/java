/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MainMenu;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.lcdui.*;

/**
 *
 * @author Sari Herawati
 */
public class CanvasMenu extends Canvas{
    MainMidlet midlet;
    Image imgbg;
    String[] menu = {
        "Menu Utama",
        "Kuis",
        "Tentang Program",
        "Keluar",
    };
    
    int activeMenu;
    int tOpa = 1;
    String teks = "";
    Timer t = new Timer();
    TimerTask tt = new TimerTask() {
        public void run() {
            refresh();
        }
    };

    public CanvasMenu(MainMidlet midlet) {
        this.midlet = midlet;
        t.schedule(tt, 0, 10);

        try {

            imgbg = Image.createImage("/Gambar/kaulinan barudak.JPG");
        } catch (IOException ex) { ex.printStackTrace(); }
    }

    protected void paint(Graphics g) {
        drawBackground(g);
//        drawLogo(g);
        drawMenu(g);
    }

    private void drawBackground(Graphics g) {
        g.setColor(51, 185, 208);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(tOpa, tOpa, tOpa);
        g.drawString(teks, getWidth() / 2, getHeight() / 2,
                Graphics.TOP | Graphics.HCENTER);
        g.drawImage(imgbg, 0, 0, 0);
    }

     private void drawMenu(Graphics g) {
        g.setFont(Font.getFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_MEDIUM));

        for(int i = menu.length - 1; i >= 0; i--){
             g.setColor(0, 0, 1);
            if(i == activeMenu){
                g.setColor(253, 4, 16);
            }
            g.drawString(menu[i], getWidth()/2, getHeight() -
                    (((menu.length - 1) - i) * 15) - 63,
                    Graphics.TOP | Graphics.HCENTER);
        }
    }

    private void refresh() {
        if(tOpa > 5)
            tOpa -= 5;
        else
            tOpa = 0;
        repaint();
    }

    protected void keyPressed(int keyCode) {
        switch(getGameAction(keyCode)){
            case DOWN:
                activeMenu = (activeMenu + 1) % menu.length;
                break;
            case UP:
                if(activeMenu == 0)
                    activeMenu = menu.length;
                activeMenu = (activeMenu - 1) % menu.length;
                break;
            case FIRE:
                sendRequest();
                break;
        }
    }

    protected void keyRepeated(int keyCode) {
        this.keyPressed(keyCode);
    }

    private void sendRequest() {
        switch(activeMenu){
            case 0: midlet.menuawal();
                
                break;
            case 1:
                    midlet.menukuis();
                break;
            case 2:
                midlet.menuabout();
                break;
            case 3:
                midlet.exitMidlet();
                break;
        }
    }

}
