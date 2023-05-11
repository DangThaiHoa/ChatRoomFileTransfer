/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package dangthaihoa.com.vn.server;

import java.io.IOException;

/**
 *
 * @author QuafBanhMi
 */
public class ServerMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        // TODO code application logic here
        ServerGUI view = new ServerGUI();
        new ServerControler(view);
        view.execute();
    }
}
