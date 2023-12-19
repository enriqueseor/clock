import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class FrmContador extends javax.swing.JFrame implements Observer{

    public FrmContador() {
        initComponents();
    }

    private void initComponents() {
        lblCronometro = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reloj digital");
        lblCronometro.setFont(new java.awt.Font("Tahoma", Font.BOLD, 48)); // NOI18N
        btnIniciar.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(this::btnIniciarActionPerformed);
        javax.swing.GroupLayout layout = new
                javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lblCronometro,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 246,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)

                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 97,
                                        Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()

                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING
                                        )
                                        .addComponent(lblCronometro,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                129, Short.MAX_VALUE))
                                .addContainerGap())
        );
        pack();
    }

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {
        this.btnIniciar.setEnabled(false);
        RelojDigital r = new RelojDigital(23, 59, 50);
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

            java.util.logging.Logger.getLogger(FrmContador.class.getName()).log(java.util.logging
                    .Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new FrmContador().setVisible(true));
    }
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel lblCronometro;
    @Override
    public void update(Observable o, Object arg) {
        lblCronometro.setText((String) arg);
    }
}
