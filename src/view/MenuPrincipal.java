package view;

import connection.FabricaConexao;
import java.sql.*;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import main.Principal;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import util.Alexa;

/**
 *
 * @author deko_
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuCadCli = new javax.swing.JMenuItem();
        jMenuCadInsu = new javax.swing.JMenuItem();
        jMenuCadProced = new javax.swing.JMenuItem();
        jMenuCadColab = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItemRelClie = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 890));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 890));

        jMenu5.setText("AGENDAR");

        jMenuItem1.setText("AGENDAMENTOS");
        jMenu5.add(jMenuItem1);

        jMenuBar2.add(jMenu5);

        jMenu6.setText("CADASTRAR");

        jMenuCadCli.setText("CLIENTES");
        jMenuCadCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadCliActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuCadCli);

        jMenuCadInsu.setText("INSUMOS");
        jMenuCadInsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadInsuActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuCadInsu);

        jMenuCadProced.setText("PROCEDIMENTOS");
        jMenuCadProced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadProcedActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuCadProced);

        jMenuCadColab.setText("COLABORADOR");
        jMenu6.add(jMenuCadColab);

        jMenuBar2.add(jMenu6);

        jMenu7.setText("RELAT�RIOS");

        jMenuItemRelClie.setText("CLIENTES");
        jMenuItemRelClie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelClieActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItemRelClie);

        jMenuItem7.setText("INSUMOS");
        jMenu7.add(jMenuItem7);

        jMenuItem8.setText("PROCEDIMENTOS");
        jMenu7.add(jMenuItem8);

        jMenuItem9.setText("USU�RIOS");
        jMenu7.add(jMenuItem9);

        jMenuBar2.add(jMenu7);

        jMenu8.setText("SAIR");

        jMenuItem2.setText("SAIR");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem2);

        jMenuBar2.add(jMenu8);

        setJMenuBar(jMenuBar2);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuCadCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadCliActionPerformed
        // TODO add your handling code here:
        CadCliente objtelacadclie = new CadCliente();
        objtelacadclie.setVisible(true);
    }//GEN-LAST:event_jMenuCadCliActionPerformed

    private void jMenuCadInsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadInsuActionPerformed
        // TODO add your handling code here:
        CadInsumo objtelacadinsu = new CadInsumo();
        objtelacadinsu.setVisible(true);
    }//GEN-LAST:event_jMenuCadInsuActionPerformed

    private void jMenuCadProcedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadProcedActionPerformed
        // TODO add your handling code here:
        CadProced objtelacadproced = new CadProced();
        objtelacadproced.setVisible(true);
    }//GEN-LAST:event_jMenuCadProcedActionPerformed

    private void jMenuItemRelClieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelClieActionPerformed
        // TODO add your handling code here:
        Principal.clientes = Principal.clienteDao.getListaCliente();
        if(Principal.clientes.isEmpty()){
            Alexa.escrevaJanela("N�o existe nenhum cliente cadastrado ");
        }else{
            RelClie relclie = new RelClie();
            relclie.setLocationRelativeTo(null);
            relclie.setVisible(true);
        }

    }//GEN-LAST:event_jMenuItemRelClieActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        System.exit(WIDTH);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuCadCli;
    private javax.swing.JMenuItem jMenuCadColab;
    private javax.swing.JMenuItem jMenuCadInsu;
    private javax.swing.JMenuItem jMenuCadProced;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemRelClie;
    // End of variables declaration//GEN-END:variables
}