/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacegrafica;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author renatowsilva
 */
public class TelaMenu extends javax.swing.JFrame {

    /**
     * Creates new form TelaMenu
     */
    public TelaMenu() {
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastroGeral = new javax.swing.JMenu();
        jMenuItemCadastroModelo = new javax.swing.JMenuItem();
        jMenuItemCadastroMarca = new javax.swing.JMenuItem();
        jMenuItemCadastroVeiculo = new javax.swing.JMenuItem();
        jMenuItemCadastroClientes = new javax.swing.JMenuItem();
        jMenuLocacao = new javax.swing.JMenu();
        jMenuItemRealizarLocacao = new javax.swing.JMenuItem();
        jMenuItemRealizarDevolucao = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemPesquisarClientes = new javax.swing.JMenuItem();
        jMenuItemPesquisarVeiculos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setAlignmentX(344.0F);
        jDesktopPane1.setAlignmentY(345.0F);

        jMenuBar1.setAlignmentX(0.0F);
        jMenuBar1.setAutoscrolls(true);
        jMenuBar1.setMinimumSize(new java.awt.Dimension(344, 344));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(1000, 25));

        jMenuCadastroGeral.setText("Cadastros");

        jMenuItemCadastroModelo.setLabel("Modelo");
        jMenuItemCadastroModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroModeloActionPerformed(evt);
            }
        });
        jMenuCadastroGeral.add(jMenuItemCadastroModelo);

        jMenuItemCadastroMarca.setLabel("Marca");
        jMenuItemCadastroMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroMarcaActionPerformed(evt);
            }
        });
        jMenuCadastroGeral.add(jMenuItemCadastroMarca);

        jMenuItemCadastroVeiculo.setText("Veiculo");
        jMenuItemCadastroVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroVeiculoActionPerformed(evt);
            }
        });
        jMenuCadastroGeral.add(jMenuItemCadastroVeiculo);

        jMenuItemCadastroClientes.setText("Cliente");
        jMenuItemCadastroClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroClientesActionPerformed(evt);
            }
        });
        jMenuCadastroGeral.add(jMenuItemCadastroClientes);

        jMenuBar1.add(jMenuCadastroGeral);

        jMenuLocacao.setText("Locação");

        jMenuItemRealizarLocacao.setText("Realizar Locação");
        jMenuItemRealizarLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRealizarLocacaoActionPerformed(evt);
            }
        });
        jMenuLocacao.add(jMenuItemRealizarLocacao);

        jMenuItemRealizarDevolucao.setText("Realizar Devolução");
        jMenuItemRealizarDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRealizarDevolucaoActionPerformed(evt);
            }
        });
        jMenuLocacao.add(jMenuItemRealizarDevolucao);

        jMenuBar1.add(jMenuLocacao);

        jMenu1.setText("Pesquisar");

        jMenuItemPesquisarClientes.setText("Clientes");
        jMenuItemPesquisarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPesquisarClientesActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemPesquisarClientes);

        jMenuItemPesquisarVeiculos.setText("Veiculos");
        jMenuItemPesquisarVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPesquisarVeiculosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemPesquisarVeiculos);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Marcas");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1082, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCadastroModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroModeloActionPerformed
        TelaCadastroDeModelo tela = new TelaCadastroDeModelo();
        jDesktopPane1.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroModeloActionPerformed

    private void jMenuItemCadastroMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroMarcaActionPerformed
        TelaCadastroDeMarca tela = new TelaCadastroDeMarca();
        jDesktopPane1.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroMarcaActionPerformed

    private void jMenuItemCadastroVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroVeiculoActionPerformed
        TelaCadastroDeVeiculo tela = new TelaCadastroDeVeiculo();
        jDesktopPane1.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroVeiculoActionPerformed

    private void jMenuItemRealizarLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRealizarLocacaoActionPerformed
        TelaLocacao tela = new TelaLocacao();
        jDesktopPane1.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItemRealizarLocacaoActionPerformed

    private void jMenuItemCadastroClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroClientesActionPerformed
        TelaClienteCadastro tela = new TelaClienteCadastro();
        jDesktopPane1.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroClientesActionPerformed

    private void jMenuItemRealizarDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRealizarDevolucaoActionPerformed
        TelaDevolucao tela = new TelaDevolucao();
        jDesktopPane1.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItemRealizarDevolucaoActionPerformed

    private void jMenuItemPesquisarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPesquisarClientesActionPerformed
        TelaClientePesquisa tela = null;
        try {
            tela = new TelaClientePesquisa();
        } catch (Exception ex) {
            Logger.getLogger(TelaMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDesktopPane1.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItemPesquisarClientesActionPerformed

    private void jMenuItemPesquisarVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPesquisarVeiculosActionPerformed
        TelaPesquisaVeiculo tela = new TelaPesquisaVeiculo();
        jDesktopPane1.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItemPesquisarVeiculosActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        try {
            TelaMarca tela;
            tela = new TelaMarca();
            jDesktopPane1.add(tela);
            tela.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar abrir Tela de Marcas!");
        }
    }//GEN-LAST:event_jMenu2MouseClicked

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
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastroGeral;
    private javax.swing.JMenuItem jMenuItemCadastroClientes;
    private javax.swing.JMenuItem jMenuItemCadastroMarca;
    private javax.swing.JMenuItem jMenuItemCadastroModelo;
    private javax.swing.JMenuItem jMenuItemCadastroVeiculo;
    private javax.swing.JMenuItem jMenuItemPesquisarClientes;
    private javax.swing.JMenuItem jMenuItemPesquisarVeiculos;
    private javax.swing.JMenuItem jMenuItemRealizarDevolucao;
    private javax.swing.JMenuItem jMenuItemRealizarLocacao;
    private javax.swing.JMenu jMenuLocacao;
    // End of variables declaration//GEN-END:variables
}
