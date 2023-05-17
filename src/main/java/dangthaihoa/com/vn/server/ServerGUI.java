/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dangthaihoa.com.vn.server;

import dangthaihoa.com.vn.common.FileInfo;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author QuafBanhMi
 */
public class ServerGUI extends javax.swing.JFrame  {
    private static final long serialVersionUID = 1L;

    private int port;
    public static ArrayList<Socket> listSK;
    private DefaultListModel model;
    /**
     * Creates new form ServerGUI
     */
    public ServerGUI() {
        initComponents();
        model = new DefaultListModel();
        setVisible(true);
        setTitle("Server");
        ServerGUI.listSK = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtSend = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lsHistory = new javax.swing.JList<>();
        btnSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(lsHistory);

        btnSend.setText("Gửi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSend, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSend, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    public JButton getBtnSend() {
        return btnSend;
    }

    public void setBtnSend(JButton btnSend) {
        this.btnSend = btnSend;
    } 

    public void execute() throws IOException {
        port = 8080;
        ServerSocket server = new ServerSocket(port);
        model.addElement("Server Đang Lắng Nghe Ở Port: " + port);
        lsHistory.setModel(model);
        while (true) {
            Socket socket = server.accept();
            model.addElement("Đã kết nối với " + socket);
            lsHistory.setModel(model);
            ServerGUI.listSK.add(socket);
            ReadServer read = new ReadServer(socket);
            read.start();
        }
    }	

    class ReadServer extends Thread {
            private Socket socket;

            public ReadServer(Socket socket) {
                    this.socket = socket;
            }

            @Override
            public void run() {
                    try {
                            DataInputStream dis = new DataInputStream(socket.getInputStream());
                            ObjectInputStream ois = null;
                            while (true) {
                                    String sms = dis.readUTF();
                                    if(sms.contains("file")){
                                        ois = new ObjectInputStream(socket.getInputStream());
                                        FileInfo fileInfo = (FileInfo) ois.readObject();
                                        if (fileInfo != null) {
                                            createFile(fileInfo);
                                        }
                                    }
                                    if(sms.contains("exit")) {
                                            ServerGUI.listSK.remove(socket);
                                            model.addElement("Đã ngắt kết nối với " + socket);
                                            lsHistory.setModel(model);
                                            dis.close();
                                            socket.close();
                                            continue; //Ngắt kết nối rồi
                                    }
                                    for (Socket item : ServerGUI.listSK) {
                                            if(item.getPort() != socket.getPort()) {
                                                    DataOutputStream dos = new DataOutputStream(item.getOutputStream());
                                                    dos.writeUTF(sms);
                                            }
                                    }
                                    model.addElement(sms);
                                    lsHistory.setModel(model);
                            }
                    } catch (Exception e) {
                            try {
                                    socket.close();
                            } catch (IOException ex) {
                                    System.out.println("Ngắt kết nối Server");
                            }
                    }
            }
    }
    
    private boolean createFile(FileInfo fileInfo) {
        BufferedOutputStream bos = null;
         
        try {
            if (fileInfo != null) {
                File fileReceive = new File(fileInfo.getDestinationDirectory() + fileInfo.getFilename());
                bos = new BufferedOutputStream(new FileOutputStream(fileReceive));
                // write file content
                bos.write(fileInfo.getDataBytes());
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public void write(){
        WriteServer write = new WriteServer();
        write.start();
    }

    class WriteServer extends Thread {

        @Override
        public void run() {
            DataOutputStream dos = null;
            String sms = txtSend.getText().toString();
            try {

                for (Socket item : ServerGUI.listSK) {
                dos = new DataOutputStream(item.getOutputStream());
                dos.writeUTF("Server: " + sms);
                }
                model.addElement("Server: " + txtSend.getText().toString());
                lsHistory.setModel(model);
            } catch (IOException e) {
                    e.printStackTrace();
            }
        }
    }
        


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lsHistory;
    private javax.swing.JTextField txtSend;
    // End of variables declaration//GEN-END:variables

}