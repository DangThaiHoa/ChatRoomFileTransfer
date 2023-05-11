/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package dangthaihoa.com.vn.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author QuafBanhMi
 */
public class ServerControler implements ActionListener{

    private ServerGUI view;
    
    public ServerControler(ServerGUI view) {
        this.view = view;
        view.getBtnSend().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(view.getBtnSend().getText())){
            view.write();
        }
    }
}
