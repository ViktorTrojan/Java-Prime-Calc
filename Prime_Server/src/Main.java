
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Main extends javax.swing.JFrame {

    PrimeServer server;

    public Main() {
        FlatLightLaf.setup();
        initComponents();

        // start the thread that checks if we are online
        new Thread(() -> {
            addText("[+] Started the checkInternetStatusThread");
            checkInternetStatusThread();
        }).start();

        server = new PrimeServer(PORT);
        new Thread(() -> {
            server.start();
        }).start();
        
        addText("[+] Started the UDP Server Thread");
    }

    public static void addText(String str) {
        jTextArea1.append(str + "\n");
    }

    // Define the PORT number as a constant integer
    public static final int PORT = 65432;

    // Method to set the status of the internet connection
    public void setStatus(boolean status) {
        if (status) {
            // If the status is true (online), change the text and color of the online_status component
            online_status.setForeground(new Color(0, 70, 0));
            online_status.setText("Online");
            return;
        }

        // If the status is false (offline), change the text and color of the online_status component
        online_status.setForeground(new Color(150, 0, 0));
        online_status.setText("Offline");
    }

    // Method to check the internet connection status
    public void checkInternetStatusThread() {
        while (true) {
            try {
                // Create a new socket and connect to Google.com on port 80
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress("google.com", 80));

                // Get the IP address of the local machine and save it to ipAddress variable
                String ipAddress = socket.getLocalAddress().getHostAddress();
                socket.close(); // Close the socket connection after saving ipAddress

                // Set the IP address and port number in the ip_and_port component and set the status to true (online)
                ip_and_port.setText(ipAddress + " : " + PORT);
                setStatus(true);
            } catch (Exception ex) {
                // If the connection fails, clear the ip_and_port component and set the status to false (offline)
                ip_and_port.setText("");
                setStatus(false);
            }
            try {
                Thread.sleep(5 * 1000); // Sleep the thread for 5 seconds
            } catch (InterruptedException ex) {
                // If the thread is interrupted, do nothing
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new components.panel.Panel();
        panel2 = new components.panel.Panel();
        panel3 = new components.panel.Panel();
        jLabel1 = new javax.swing.JLabel();
        online_status = new javax.swing.JLabel();
        ip_and_port = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prime Server UDP");

        panel1.setBackground(new java.awt.Color(243, 243, 251));
        panel1.setRounded(0);

        panel2.setBackground(new java.awt.Color(230, 230, 244));

        panel3.setBackground(new java.awt.Color(220, 220, 234));
        panel3.setRounded(10);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("Status:");

        online_status.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        online_status.setForeground(new java.awt.Color(0, 70, 0));
        online_status.setText("Online");

        ip_and_port.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        ip_and_port.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ip_and_port.setText(" ");

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(online_status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ip_and_port, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(online_status)
                    .addComponent(ip_and_port))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextArea1.setBackground(new java.awt.Color(220, 220, 234));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ip_and_port;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel online_status;
    private components.panel.Panel panel1;
    private components.panel.Panel panel2;
    private components.panel.Panel panel3;
    // End of variables declaration//GEN-END:variables
}
