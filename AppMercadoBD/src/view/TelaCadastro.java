/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import entity.Pessoa;
import entity.Usuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import persist.PessoaDAO;
import util.ValidaCPF;

/**
 *
 * @author andre
 */
public class TelaCadastro extends javax.swing.JFrame {
    
    private PessoaDAO pdao;
    
    /**
     * Creates new form TelaCadastro
     */
    public TelaCadastro() {
        initComponents();
        pdao = PessoaDAO.getInstance();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dadosPessoaisPanel = new javax.swing.JPanel();
        nomeFTF = new javax.swing.JFormattedTextField();
        nomeLabel = new javax.swing.JLabel();
        cpfLabel = new javax.swing.JLabel();
        dataLabel = new javax.swing.JLabel();
        MaskFormatter CpfMask = null;
        try{
            CpfMask= new MaskFormatter("###.###.###-##");
        } catch (Exception e){
            e.printStackTrace();
        }
        cpfFTF = new javax.swing.JFormattedTextField(CpfMask);
        MaskFormatter dataMask = null;
        try{
            dataMask= new MaskFormatter("##/##/####");
        } catch (Exception e){
            e.printStackTrace();
        }
        dataFTF = new javax.swing.JFormattedTextField(dataMask);
        cadastroPanel = new javax.swing.JPanel();
        confirmaEmailFTF = new javax.swing.JFormattedTextField();
        confirmaEmailLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        emailFTF = new javax.swing.JFormattedTextField();
        senhaLabel = new javax.swing.JLabel();
        confirmarSenhaLabel = new javax.swing.JLabel();
        confirmarSenhaPF = new javax.swing.JPasswordField();
        senhaPF = new javax.swing.JPasswordField();
        confirmarSenhaLabel1 = new javax.swing.JLabel();
        confirmarSenhaLabel2 = new javax.swing.JLabel();
        logarButton = new javax.swing.JButton();
        cadastrarButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro");

        dadosPessoaisPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));

        nomeLabel.setText("Nome Completo");

        cpfLabel.setText("CPF");

        dataLabel.setText("Data Nascimento");

        javax.swing.GroupLayout dadosPessoaisPanelLayout = new javax.swing.GroupLayout(dadosPessoaisPanel);
        dadosPessoaisPanel.setLayout(dadosPessoaisPanelLayout);
        dadosPessoaisPanelLayout.setHorizontalGroup(
            dadosPessoaisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosPessoaisPanelLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(dadosPessoaisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataFTF, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfFTF, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfLabel)
                    .addComponent(nomeLabel)
                    .addComponent(nomeFTF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataLabel))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        dadosPessoaisPanelLayout.setVerticalGroup(
            dadosPessoaisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosPessoaisPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(cpfLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cpfFTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeFTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dataLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dataFTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        cadastroPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro"));

        confirmaEmailLabel.setText("Confirmar Email");

        emailLabel.setText("Email");

        senhaLabel.setText("Senha");

        confirmarSenhaLabel.setText("Confirmar Senha");

        confirmarSenhaLabel1.setText("(minimo 8 digitos)");

        confirmarSenhaLabel2.setText("(minimo 8 digitos)");

        javax.swing.GroupLayout cadastroPanelLayout = new javax.swing.GroupLayout(cadastroPanel);
        cadastroPanel.setLayout(cadastroPanelLayout);
        cadastroPanelLayout.setHorizontalGroup(
            cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastroPanelLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(cadastroPanelLayout.createSequentialGroup()
                        .addComponent(confirmarSenhaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmarSenhaLabel2))
                    .addComponent(emailLabel)
                    .addComponent(confirmaEmailLabel)
                    .addComponent(confirmaEmailFTF)
                    .addGroup(cadastroPanelLayout.createSequentialGroup()
                        .addComponent(senhaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmarSenhaLabel1))
                    .addComponent(emailFTF)
                    .addComponent(confirmarSenhaPF, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(senhaPF, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        cadastroPanelLayout.setVerticalGroup(
            cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastroPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(emailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailFTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirmaEmailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmaEmailFTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaLabel)
                    .addComponent(confirmarSenhaLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senhaPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmarSenhaLabel)
                    .addComponent(confirmarSenhaLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmarSenhaPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        logarButton.setText("Já possui um cadastro? Aperte aqui para entrar!");
        logarButton.setToolTipText("");
        logarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logarButtonActionPerformed(evt);
            }
        });

        cadastrarButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cadastrarButton.setText("Cadastrar");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/APP-MERCADO__IFRStore_-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(logarButton)
                    .addComponent(cadastrarButton)
                    .addComponent(cadastroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dadosPessoaisPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dadosPessoaisPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadastroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cadastrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(logarButton)
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logarButtonActionPerformed
        new TelaLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logarButtonActionPerformed

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        boolean status = true;

        String cpf = cpfFTF.getText();
        if (cpf.isEmpty() || !ValidaCPF.isValido(cpf)) {
            JOptionPane.showMessageDialog(this, "Erro ao informar o cpf");
            cpfFTF.grabFocus();
            status = false;
        }

        String nome = nomeFTF.getText();
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Erro ao informar o nome");
            nomeFTF.grabFocus();
            status = false;
        }

        String data = dataFTF.getText();
        LocalDate dataAniversario = null;
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            dataAniversario = LocalDate.parse(data, formato);
            if (dataAniversario.compareTo(hoje) > 0) {
                status = false;
                JOptionPane.showMessageDialog(this, "A data de aniversario deve ser anterior ao dia de hoje");
            }

        } catch (DateTimeParseException dex) {
            JOptionPane.showMessageDialog(this, "Erro ao informar a data de aniversario");
            status = false;
        }

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String email = emailFTF.getText();
        if (!email.matches(EMAIL_PATTERN)) {
            JOptionPane.showMessageDialog(null, "Endereço de email errado!");
            status = false;
        }

        String email2 = emailFTF.getText();
        if (!email.equals(email2)) {
            JOptionPane.showMessageDialog(this, "Os emails não conferem");
            confirmaEmailFTF.grabFocus();
            status = false;
        }

        String senha = senhaPF.getText();
        if (senha.isEmpty() || senha.length() < 8) {
            JOptionPane.showMessageDialog(this, "A senha deve ter pelo menos 8 digitos");
            senhaPF.grabFocus();
            status = false;
        }

        String senha2 = confirmarSenhaPF.getText();
        if (!senha.equals(senha2)) {
            JOptionPane.showMessageDialog(this, "As senhas não conferem");
            confirmarSenhaPF.grabFocus();
            status = false;
        }
        
        if(status){
            Pessoa pessoa = new Pessoa(cpf, nome, dataAniversario);
            Usuario usuario = new Usuario(email, senha);
            pessoa.setUser(usuario);
            if(pdao.read(pessoa.getCpf()) != null){
                JOptionPane.showMessageDialog(this, "Usuário já existente!");
                return;
            }
            if(pdao.create(pessoa)){
                JOptionPane.showMessageDialog(this, "Cadastrado com sucesso");
                new TelaLoja(pessoa.getCpf()).setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar");
            }
        }
    }//GEN-LAST:event_cadastrarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JPanel cadastroPanel;
    private javax.swing.JFormattedTextField confirmaEmailFTF;
    private javax.swing.JLabel confirmaEmailLabel;
    private javax.swing.JLabel confirmarSenhaLabel;
    private javax.swing.JLabel confirmarSenhaLabel1;
    private javax.swing.JLabel confirmarSenhaLabel2;
    private javax.swing.JPasswordField confirmarSenhaPF;
    private javax.swing.JFormattedTextField cpfFTF;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JPanel dadosPessoaisPanel;
    private javax.swing.JFormattedTextField dataFTF;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JFormattedTextField emailFTF;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton logarButton;
    private javax.swing.JFormattedTextField nomeFTF;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JLabel senhaLabel;
    private javax.swing.JPasswordField senhaPF;
    // End of variables declaration//GEN-END:variables

    public boolean getValores(){
        
        return false;
        
    }
    
}
