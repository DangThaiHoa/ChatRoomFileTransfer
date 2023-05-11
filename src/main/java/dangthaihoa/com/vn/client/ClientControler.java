/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dangthaihoa.com.vn.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QuafBanhMi
 */
public class ClientControler implements ActionListener{
    
    private ClientGUI view;
    
    public ClientControler(ClientGUI view) {
        this.view = view;
        view.getBtnConnect().addActionListener(this);
        view.getBtnSend().addActionListener(this);
        view.getBtnDisconnect().addActionListener(this);
        view.getBtnChooserFile().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(view.getBtnConnect().getText())){
            try {
                view.execute();
            } catch (IOException ex) {
                Logger.getLogger(ClientControler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getActionCommand().equals(view.getBtnSend().getText())){
            view.write();
        }
        if(e.getActionCommand().equals(view.getBtnDisconnect().getText())){
            view.disconnect();
        }
        if(e.getActionCommand().equals(view.getBtnChooserFile().getText())){
            view.chooseFile();
        }
    }
}
