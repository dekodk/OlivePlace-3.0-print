package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserView extends javax.swing.JFrame {

    private JFrame frame;
    private JTextField idLoginField;
    private JTextField idSenhaField;
    private JTextField userNivelField;
    private JTextField idUserField;
    
    public UserView() {
        frame = new JFrame("User Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(6, 2));
        
        JLabel idLoginLabel = new JLabel("ID Login:");
        idLoginField = new JTextField();
        JLabel idSenhaLabel = new JLabel("ID Senha:");
        idSenhaField = new JTextField();
        JLabel userNivelLabel = new JLabel("User Nivel:");
        userNivelField = new JTextField();
        JLabel idUserLabel = new JLabel("ID User (for update or inativar):");
        idUserField = new JTextField();

        JButton insertButton = new JButton("Inserir");
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chame o método inserir do UserDao aqui
            }
        });

        JButton updateButton = new JButton("Atualizar");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chame o método atualizar do UserDao aqui
            }
        });

        JButton inativarButton = new JButton("Inativar");
        inativarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chame o método inativar do UserDao aqui
            }
        });

        frame.add(idLoginLabel);
        frame.add(idLoginField);
        frame.add(idSenhaLabel);
        frame.add(idSenhaField);
        frame.add(userNivelLabel);
        frame.add(userNivelField);
        frame.add(idUserLabel);
        frame.add(idUserField);
        frame.add(insertButton);
        frame.add(updateButton);
        frame.add(inativarButton);

        frame.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new UserView());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
