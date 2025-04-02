/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.seuprojeto.classes;

import java.time.LocalDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.io.File;
/**
 *
 * @author Laura
 */
public class telaIdade extends javax.swing.JFrame {

    /**
     * Creates new form telaIdade
     */
       private Connection conn;

    // Conectar ao banco de dados SQLite
   private Connection connect() {
    if (conn == null) {
        try {
            // Registra o driver do SQLite
            Class.forName("org.sqlite.JDBC");

            // Define o caminho completo do banco de dados
            String url = "jdbc:sqlite:C:\\Users\\Laura\\Documents\\NetBeansProjects\\calculadoraIdade\\idade.db";

            // Verifica se o diretório existe, caso contrário, cria
            File databaseFile = new File("C:\\Users\\Laura\\Documents\\NetBeansProjects\\calculadoraIdade");
            if (!databaseFile.exists()) {
                databaseFile.mkdirs();  // Cria o diretório, se não existir
            }

            // Conecta ao banco de dados
            conn = DriverManager.getConnection(url);

            // Criação da tabela, caso não exista
            String sql = "CREATE TABLE IF NOT EXISTS pessoas ("
                    + " id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + " nome TEXT, "
                    + " data_nascimento TEXT, "
                    + " idade INTEGER);";
            conn.createStatement().execute(sql);

        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
    return conn;
}


    // Método para salvar dados no banco de dados
    private void salvarDados(String nome, String dataNascimento, int idade) {
        String sql = "INSERT INTO pessoas (nome, data_nascimento, idade) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connect().prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, dataNascimento);
            pstmt.setInt(3, idade);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Dados salvos com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public telaIdade() {
        initComponents();
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnCalc = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblAno = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        anoN = new javax.swing.JSpinner();
        mesN = new javax.swing.JSpinner();
        diaN = new javax.swing.JSpinner();
        lblMes = new javax.swing.JLabel();
        lblDia = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnConsultaDados = new javax.swing.JButton();
        btnModificarDados = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora de Idade");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Data de Nascimento");

        btnCalc.setBackground(new java.awt.Color(0, 204, 51));
        btnCalc.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnCalc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/inserticon.png"))); // NOI18N
        btnCalc.setText("Armazenar dados");
        btnCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Idade de");

        lblAno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAno.setForeground(new java.awt.Color(255, 0, 0));
        lblAno.setText("0");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/589b4da582250818d81e748f (2) (1).png"))); // NOI18N

        anoN.setModel(new javax.swing.SpinnerNumberModel(2000, 1970, 2024, 1));

        mesN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        diaN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        diaN.setToolTipText("");

        lblMes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMes.setForeground(new java.awt.Color(255, 0, 0));
        lblMes.setText("0");

        lblDia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDia.setForeground(new java.awt.Color(255, 0, 0));
        lblDia.setText("0");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Nome:");

        txtFNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFNome.setForeground(new java.awt.Color(204, 204, 204));
        txtFNome.setText("insira seu nome aqui");
        txtFNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFNomeFocusGained(evt);
            }
        });
        txtFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFNomeActionPerformed(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 0, 0));
        lblNome.setText("Usuário:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("anos");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("meses");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("dias");

        btnConsultaDados.setBackground(new java.awt.Color(0, 204, 204));
        btnConsultaDados.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnConsultaDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/databaseicon.png"))); // NOI18N
        btnConsultaDados.setText("Consultar Dados");
        btnConsultaDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaDadosActionPerformed(evt);
            }
        });

        btnModificarDados.setBackground(new java.awt.Color(204, 0, 204));
        btnModificarDados.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnModificarDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/updateicon.png"))); // NOI18N
        btnModificarDados.setText("Modificar Dados");
        btnModificarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarDadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(anoN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mesN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(diaN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAno, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDia, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConsultaDados, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(anoN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mesN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diaN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(btnCalc)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMes)
                            .addComponent(lblDia)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(lblAno)
                            .addComponent(jLabel9)
                            .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultaDados, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcActionPerformed
        // TODO add your handling code here:
        String nome = txtFNome.getText();  // Captura o nome digitado
        if (nome.isEmpty() || nome.equals("insira seu nome aqui")) {
            JOptionPane.showMessageDialog(this, "Por favor, insira seu nome.");
            return;
        } 
int an = Integer.parseInt(anoN.getValue().toString());
int mn = Integer.parseInt(mesN.getValue().toString());
int dn = Integer.parseInt(diaN.getValue().toString());

LocalDate hoje = LocalDate.now();
int anoAtual = hoje.getYear();
int mesAtual = hoje.getMonthValue();
int diaAtual = hoje.getDayOfMonth();

int ano = anoAtual - an;
int mes = mesAtual - mn;
int dia = diaAtual - dn;

// Ajuste se o aniversário ainda não ocorreu este ano
if (dia < 0) {
        mes--; 
        // Pegando a quantidade de dias do mês anterior
        LocalDate mesPassado = hoje.minusMonths(1);
        int diasNoMesPassado = mesPassado.lengthOfMonth();
        dia += diasNoMesPassado;
    }

    if (mes < 0) {
        ano--;
        mes += 12;
    }

lblAno.setText(Integer.toString(ano));
lblMes.setText(Integer.toString(mes));
lblDia.setText(Integer.toString(dia));


 String dataNascimento = an + "-" + mn + "-" + dn;
        salvarDados(nome, dataNascimento, ano);
    }//GEN-LAST:event_btnCalcActionPerformed

    private void txtFNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFNomeActionPerformed

    private void txtFNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFNomeFocusGained
        // TODO add your handling code here:
        if (txtFNome.getText().equals("insira seu nome aqui")) {
    txtFNome.setText("");
    txtFNome.setForeground(java.awt.Color.BLACK);
}

    }//GEN-LAST:event_txtFNomeFocusGained

    private void btnConsultaDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaDadosActionPerformed
        // TODO add your handling code here:
    consultaDados novaJanela = new consultaDados(); //Criar nova janela
    novaJanela.setVisible(true); //Exibindo nova janela
        novaJanela.loadData(); // 🔥 Aqui carrega os dados na tabela!
    }//GEN-LAST:event_btnConsultaDadosActionPerformed

    private void btnModificarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarDadosActionPerformed
        // TODO add your handling code here:
        modificarDados 
    }//GEN-LAST:event_btnModificarDadosActionPerformed

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
            java.util.logging.Logger.getLogger(telaIdade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaIdade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaIdade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaIdade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaIdade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner anoN;
    private javax.swing.JButton btnCalc;
    private javax.swing.JButton btnConsultaDados;
    private javax.swing.JButton btnModificarDados;
    private javax.swing.JSpinner diaN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNome;
    private javax.swing.JSpinner mesN;
    private javax.swing.JTextField txtFNome;
    // End of variables declaration//GEN-END:variables
}
