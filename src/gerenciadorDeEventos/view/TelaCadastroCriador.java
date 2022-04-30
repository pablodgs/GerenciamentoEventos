/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.view;

import gerenciadorDeEventos.controller.CriadorController;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class TelaCadastroCriador extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroCriados
     */
    public TelaCadastroCriador() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextFieldNomeCriador = new javax.swing.JTextField();
        jButtonCancelarCadastroCriador = new javax.swing.JButton();
        jTextFieldEnderecoCriador = new javax.swing.JTextField();
        jTextFieldEmailCriador = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxSexoCriador = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPasswordFieldSenhaCriador = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPasswordFieldConfirmarSenhaCriador = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jButtonCadastrarCriador = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jFormattedTextFieldTelfoneCriados = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCpfCriador = new javax.swing.JFormattedTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextFieldNomeCriador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeCriadorActionPerformed(evt);
            }
        });

        jButtonCancelarCadastroCriador.setText("Cancelar");
        jButtonCancelarCadastroCriador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarCadastroCriadorActionPerformed(evt);
            }
        });

        jTextFieldEnderecoCriador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEnderecoCriadorActionPerformed(evt);
            }
        });

        jLabel6.setText("Selecione o sexo: ");

        jComboBoxSexoCriador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        jLabel7.setText("Entre com a senha: ");

        jLabel8.setText("Confirme a senha: ");

        jLabel1.setText("Tela de Cadastro do Criador");

        jLabel2.setText("Entre com o nome do Usuário:");

        jLabel3.setText("Entre com o CPF:");

        jLabel4.setText("Entre com o endereço do Usuário: ");

        jLabel5.setText("Entre com o email do Usuário: ");

        jButtonCadastrarCriador.setText("Cadastrar");
        jButtonCadastrarCriador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarCriadorActionPerformed(evt);
            }
        });

        jLabel10.setText("Telefone:");

        try {
            jFormattedTextFieldTelfoneCriados.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldCpfCriador.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jLabel1)
                .addContainerGap(237, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldEmailCriador, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addComponent(jTextFieldNomeCriador)
                        .addComponent(jTextFieldEnderecoCriador)
                        .addComponent(jLabel2)
                        .addComponent(jLabel7)
                        .addComponent(jPasswordFieldSenhaCriador)
                        .addComponent(jButtonCadastrarCriador, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel5))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordFieldConfirmarSenhaCriador, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6)
                        .addComponent(jLabel3)
                        .addComponent(jLabel8)
                        .addComponent(jComboBoxSexoCriador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormattedTextFieldTelfoneCriados, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addComponent(jFormattedTextFieldCpfCriador))
                    .addComponent(jButtonCancelarCadastroCriador))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeCriador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldCpfCriador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEnderecoCriador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldTelfoneCriados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmailCriador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSexoCriador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldSenhaCriador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordFieldConfirmarSenhaCriador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelarCadastroCriador)
                    .addComponent(jButtonCadastrarCriador))
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeCriadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeCriadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeCriadorActionPerformed

    private void jButtonCancelarCadastroCriadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarCadastroCriadorActionPerformed
        TelaPrincipal principal = new TelaPrincipal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarCadastroCriadorActionPerformed

    private void jTextFieldEnderecoCriadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEnderecoCriadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEnderecoCriadorActionPerformed

    private void jButtonCadastrarCriadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarCriadorActionPerformed
        String nomeUsuario = jTextFieldNomeCriador.getText();
        String endereco = jTextFieldEnderecoCriador.getText();
        String cpf = jFormattedTextFieldCpfCriador.getText();
        String senha = new String(jPasswordFieldSenhaCriador.getPassword());
        String senhaReal = new String(jPasswordFieldConfirmarSenhaCriador.getPassword());
        String sexo = jComboBoxSexoCriador.getSelectedItem().toString();
        String email = jTextFieldEmailCriador.getText();
        String telefone = jFormattedTextFieldTelfoneCriados.getText();

        if(senha.equals(senhaReal)){
            CriadorController controlador = new CriadorController();
            int cadastrado = controlador.cadastrarCriador(nomeUsuario, endereco, cpf, senha, email, sexo, telefone);
            if(cadastrado == 1){
                JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!");
                TelaPrincipal principal = new TelaPrincipal();
                principal.setVisible(true);
                principal.setLocationRelativeTo(null);
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this, "CPF já cadastrado!!");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Senhas não compatíveis");
            System.out.println("tela de erro de senha");
        }

    }//GEN-LAST:event_jButtonCadastrarCriadorActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroCriador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCriador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCriador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCriador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroCriador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrarCriador;
    private javax.swing.JButton jButtonCancelarCadastroCriador;
    private javax.swing.JComboBox<String> jComboBoxSexoCriador;
    private javax.swing.JFormattedTextField jFormattedTextFieldCpfCriador;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelfoneCriados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPasswordFieldConfirmarSenhaCriador;
    private javax.swing.JPasswordField jPasswordFieldSenhaCriador;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldEmailCriador;
    private javax.swing.JTextField jTextFieldEnderecoCriador;
    private javax.swing.JTextField jTextFieldNomeCriador;
    // End of variables declaration//GEN-END:variables
}
