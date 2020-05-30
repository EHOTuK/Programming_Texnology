package tp_project;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import dBObjects.DBObject_organs;
import dBObjects.DBObject_picture;
import dBObjects.DBObject_systems;
import dBObjects.DB_Connect;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class Interface extends javax.swing.JFrame {

    MainPanel panel;
    MiniPanel miniPanel;
    String flagSystems = null;
    DBObject_organs dbOrgans = new DBObject_organs();
    DBObject_systems dbSystems = new DBObject_systems();
    DBObject_picture dbPicture = new DBObject_picture();
    BufferedImage bimage = null;
    DB_Connect dbcon = new DB_Connect();
    Connection con = dbcon.getConnection();

    /**
     * Констуктор иницилизирует значениями элементы интерфейса, создает пункты
     * меню и отвечает за добавление/перерисовку изображений в зависимости от
     * пункта меню
     */
    public Interface() {
        initComponents();
        //-----заполнение интерфейса при старте программы
        panel = new MainPanel(this);
        jPanel1.add(panel); //добавляем основную картинку
        bimage = dbPicture.getDBObject_picture(38, con); //получаем картинку из БД для JPanel2
        redrawMiniPanel();
        setPreferredSize(new Dimension(950, 1050));//устанавливаем размеры окна
        setResizable(false);//запрет на изменение размеров
        setLocationRelativeTo(null);
        setVisible(true);
        jTextArea2.setLineWrap(true);//для переноса текста
        jTextArea2.setWrapStyleWord(true);
        jTextArea3.setLineWrap(true);
        jTextArea3.setWrapStyleWord(true);
        jTextArea2.setEditable(false);//запрет на изменение текста
        jTextArea3.setEditable(false);
        setBDObject(0);
        jLabel1.setText("");

        Font font = new Font("Verdana", Font.PLAIN, 14);
        JMenu systemsMenu = new JMenu("Системы");
        systemsMenu.setFont(font);

        JMenuItem musclesItem = new JMenuItem("Мышечная");
        musclesItem.setFont(font);
        musclesItem.addActionListener((ActionEvent arg0) -> {
            flagSystems = "MUSCLES";
            redrawMainPanel();
            setBDObject(1);
            bimage = dbPicture.getDBObject_picture(39, con);
            redrawMiniPanel();
            jTextArea2.setText("Здесь будет описание мышцы, которую Вы выберете");
        });
        systemsMenu.add(musclesItem);

        JMenuItem bonesItem = new JMenuItem("Костная");
        bonesItem.setFont(font);
        bonesItem.addActionListener((ActionEvent arg0) -> {
            flagSystems = "BONES";
            redrawMainPanel();
            setBDObject(3);
            bimage = dbPicture.getDBObject_picture(40, con);
            redrawMiniPanel();
            jTextArea2.setText("Здесь будет описание кости, которую Вы выберете");
        });
        systemsMenu.add(bonesItem);

        JMenuItem organsItem = new JMenuItem("Органы");
        organsItem.setFont(font);
        organsItem.addActionListener((ActionEvent arg0) -> {
            flagSystems = "ORGANS";
            redrawMainPanel();
            setBDObject(2);
            bimage = dbPicture.getDBObject_picture(41, con);
            redrawMiniPanel();
            jTextArea2.setText("Здесь будет органа мышцы, который Вы выберете");
        });
        systemsMenu.add(organsItem);
        jMenuBar1.add(systemsMenu);

    }

    /**
     * Перерисовка MainPanel
     */
    public void redrawMainPanel() {
        panel = new MainPanel(this);
        jPanel1.removeAll();
        jPanel1.revalidate();
        jPanel1.repaint();
        jPanel1.add(panel);
    }

    /**
     * Перерисовка MiniPanel
     */
    public void redrawMiniPanel() {
        miniPanel = new MiniPanel(this);
        jPanel2.removeAll();
        jPanel2.revalidate();
        jPanel2.repaint();
        jPanel2.add(miniPanel);
        jLabel2.setText("");
    }

    /**
     * Установка данных, полученных из БД в соответствующие поля систем
     *
     * @param id - номер поля в БД systems
     */
    public void setBDObject(int id) {
        try {
            jTextArea2.setLineWrap(true);
            jTextArea2.setWrapStyleWord(true);
            jTextArea3.setLineWrap(true);
            jTextArea3.setWrapStyleWord(true);
            dbSystems.getDBObject_systems(id, con);
            jLabel1.setText(dbSystems.getTitle());
            jLabel2.setText("");
            if (flagSystems == null) {
                jTextArea2.setText(dbSystems.getTitle());
            }
            jTextArea3.setText(dbSystems.getDesc());
        } catch (SQLException ex) {

        }
    }

    /**
     * Установка данных, полученных из БД в соответствующие поля выбранных по
     * нажатию мышки органов
     *
     * @param id - номер поля в БД organs
     */
    public void setBDObjectOrgans(int id) {
        dbOrgans.getDBObject_organs(id, con);
        bimage = dbPicture.getDBObject_picture(id, con);
        jLabel2.setText(dbOrgans.getTitle());
        jTextArea2.setLineWrap(true);
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setText(dbOrgans.getDesc());
        miniPanel = new MiniPanel(this);
        jPanel2.removeAll();
        jPanel2.revalidate();
        jPanel2.repaint();
        jPanel2.add(miniPanel);
    }

    public String getFlagSystems() {
        return flagSystems;
    }

    public void setFlagSystems(String flagSystems) {
        this.flagSystems = flagSystems;
    }

    public BufferedImage getBimage() {
        return bimage;
    }

    public void setBimage(BufferedImage bimage) {
        this.bimage = bimage;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(950, 1050));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel1.setMinimumSize(new java.awt.Dimension(4, 4));
        jPanel1.setPreferredSize(new java.awt.Dimension(742, 1064));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jButton1.setText("Выход");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("jLabel2");
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//кнопка выхода. Также закрываем соединение с БД
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MousePressed
//при нажатии на крестик закрываем соединение с БД
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}
