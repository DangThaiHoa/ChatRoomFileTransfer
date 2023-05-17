/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dangthaihoa.com.vn.client;

import dangthaihoa.com.vn.common.FileInfo;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author QuafBanhMi
 */
public class ClientGUI extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    private Socket client;
    DefaultListModel model;
    private int port;
    /**
     * Creates new form ClientGUI
     */
    public ClientGUI() {
        initComponents();
        model = new DefaultListModel();
        setVisible(true);
        setTitle("Client");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnConnect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lsHistory = new javax.swing.JList<>();
        txtSend = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        btnDisconnect = new javax.swing.JButton();
        btnChooserFile = new javax.swing.JButton();
        txtPart = new javax.swing.JTextField();
        btnSendFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Port:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Tên:");

        btnConnect.setText("Kết Nối");

        jScrollPane1.setViewportView(lsHistory);

        btnSend.setText("Gửi");

        btnDisconnect.setText("Ngắt Kết Nối");

        btnChooserFile.setText("Chọn File");

        btnSendFile.setText("Gửi File");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPart, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtSend, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 14, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnDisconnect)
                                        .addGap(110, 110, 110))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtName)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(107, 107, 107)))))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnChooserFile, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSendFile, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDisconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSend, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPart, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnChooserFile, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSendFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(client.getOutputStream());
            if(dos != null){
                dos.writeUTF("exit");
                model.addElement("Ngắt kết nối với Server");
                lsHistory.setModel(model);
            }
        } catch (Exception e) {
                System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing


    public void execute() throws IOException {
        port = Integer.parseInt(txtPort.getText().toString());
        client = new Socket(InetAddress.getLocalHost(), Integer.parseInt(txtPort.getText().toString()));
        model.addElement("Kết nối với Server ở Port " + txtPort.getText().toString());
        lsHistory.setModel(model);
        ReadClient read = new ReadClient(client);
        read.start();
        setTitle("Client - " + txtName.getText().toString());
    }

    public void disconnect() {
        DataOutputStream dos = null;
        try {
            if(dos == null){
                dos = new DataOutputStream(client.getOutputStream());
                dos.writeUTF("exit");
                model.addElement("Ngắt kết nối với Server");
                lsHistory.setModel(model);
            }
        } catch (Exception e) {
                try {
                        dos.close();
                        client.close();
                } catch (IOException ex) {
                        System.out.println("Ngắt kết nối Server");
                }
        }
    }

    class ReadClient extends Thread{
        private Socket client;

        public ReadClient(Socket client) {
                this.client = client;
        }

        @Override
        public void run() {
            DataInputStream dis = null;
            ObjectInputStream ois = null;
            try {
                dis = new DataInputStream(client.getInputStream());
                while(true) {
                        String sms = dis.readUTF();
                        model.addElement(sms);
                        lsHistory.setModel(model);
                        if(sms.contains("file")){
                            ois = new ObjectInputStream(client.getInputStream());
                            FileInfo fileInfo = (FileInfo) ois.readObject();
                            if (fileInfo != null) {
                                createFile(fileInfo);
                            }
                        }
                }
            } catch (Exception e) {
                try {
                        dis.close();
                        client.close();
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
                File fileReceive = new File("F:\\test\\" + fileInfo.getFilename());
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
        WriteClient write = new WriteClient(client, txtName.getText().toString());
        write.start();	
    }
    
    public void File() throws IOException{
        DataOutputStream dos = null;
        dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("file");
        String destinationDir = "F:\\server\\";
        sendFile(txtPart.getText().toString(), destinationDir);
        File sourceFile = new File(txtPart.getText().toString());
        dos.writeUTF("SendFile:" + sourceFile.getName());
    }

    class WriteClient extends Thread{
            private Socket client;
            private String name;

            public WriteClient(Socket client, String name) {
                    this.client = client;
                    this.name = name;
            }

            @Override
            public void run() {
                    DataOutputStream dos = null;
                    try {
                        dos = new DataOutputStream(client.getOutputStream());
                        String sms = txtSend.getText().toString();
                        if(sms.equals("")){
                            JOptionPane.showMessageDialog(null, "Vui lòng nhập nội dung tin nhắn", "Cảnh báo", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            dos.writeUTF(name + ": " + sms);
                            model.addElement(name + ": " + sms);
                            lsHistory.setModel(model);
                        }

                    } catch (Exception e) {
                            try {
                                    dos.close();
                                    client.close();
                            } catch (IOException ex) {
                                    System.out.println("Ngắt kết nối Server");
                            }
                    }
            }

    }
  
    public void sendFile(String sourceFilePath, String destinationDir) throws UnknownHostException, IOException {
        DataOutputStream outToServer = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
 
        try {
            // make greeting
            outToServer = new DataOutputStream(client.getOutputStream());
 
            // get file info
            FileInfo fileInfo = getFileInfo(sourceFilePath, destinationDir);
 
            // send file
            oos = new ObjectOutputStream(client.getOutputStream());
            oos.writeObject(fileInfo);
 
       
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private FileInfo getFileInfo(String sourceFilePath, String destinationDir) {
        FileInfo fileInfo = null;
        BufferedInputStream bis = null;
        try {
            File sourceFile = new File(sourceFilePath);
            bis = new BufferedInputStream(new FileInputStream(sourceFile));
            fileInfo = new FileInfo();
            byte[] fileBytes = new byte[(int) sourceFile.length()];
            // get file info
            bis.read(fileBytes, 0, fileBytes.length);
            fileInfo.setFilename(sourceFile.getName());
            fileInfo.setDataBytes(fileBytes);
            fileInfo.setDestinationDirectory(destinationDir);
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
        return fileInfo;
    }
    
    public void chooseFile() {
        final JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        try {
            if (fc.getSelectedFile() != null) {
                txtPart.setText(fc.getSelectedFile().getPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JButton getBtnConnect() {
        return btnConnect;
    }

    public void setBtnConnect(JButton btnConnect) {
        this.btnConnect = btnConnect;
    }

    public JButton getBtnSend() {
        return btnSend;
    }

    public void setBtnSend(JButton btnSend) {
        this.btnSend = btnSend;
    }

    public JButton getBtnDisconnect() {
        return btnDisconnect;
    }

    public void setBtnDisconnect(JButton btnDisconnect) {
        this.btnDisconnect = btnDisconnect;
    }

    public JButton getBtnChooserFile() {
        return btnChooserFile;
    }

    public void setBtnChooserFile(JButton btnChooserFile) {
        this.btnChooserFile = btnChooserFile;
    }

    public JButton getBtnSendFile() {
        return btnSendFile;
    }

    public void setBtnSendFile(JButton btnSendFile) {
        this.btnSendFile = btnSendFile;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChooserFile;
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnDisconnect;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnSendFile;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lsHistory;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPart;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtSend;
    // End of variables declaration//GEN-END:variables
}
