import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class FrmCounter extends javax.swing.JFrame implements Observer{

    public FrmCounter() {
        initComponents();
    }

    private void initComponents() {
        lblTimer = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DIGITAL CLOCK");
        lblTimer.setFont(new java.awt.Font("Arial", Font.BOLD, 48)); // NOI18N
        btnStart.setFont(new java.awt.Font("Arial", Font.PLAIN, 18)); // NOI18N
        btnStart.setText("START");
        btnStart.addActionListener(this::btnStartActionPerformed);
        javax.swing.GroupLayout layout = new
                javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lblTimer,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 246,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)

                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, 97,
                                        Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()

                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING
                                        )
                                        .addComponent(lblTimer,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                129, Short.MAX_VALUE))
                                .addContainerGap())
        );
        pack();
    }

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {
        this.btnStart.setEnabled(false);
        DigitalClock r = new DigitalClock(0, 0, 0);
        r.addObserver(this);
        Thread t = new Thread(r);
        t.start();
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {

            java.util.logging.Logger.getLogger(FrmCounter.class.getName()).log(java.util.logging
                    .Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new FrmCounter().setVisible(true));
    }
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel lblTimer;
    @Override
    public void update(Observable o, Object arg) {
        lblTimer.setText((String) arg);
    }
}
