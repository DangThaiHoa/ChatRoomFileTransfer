/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dangthaihoa.com.vn.client;

/**
 *
 * @author QuafBanhMi
 */
public class ClientMain {
    public static void main(String args[]) {
        // TODO code application logic here
        ClientGUI view = new ClientGUI();
        new ClientControler(view);
    }
}
