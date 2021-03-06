package queryrunner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author mckeem
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
//import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class QueryFrame extends javax.swing.JFrame {
    private Image img;
    private String imgName = "back.jpg";


 /* This is the constructer for QueryFrame. It will initialize the Combobox with
 * the various queries that are part of the QueryData that has been passed to it.
 * It will also set the default state of the Command Buttons and combo boxes.
 * @param queryrunnerObj 
 */

    public QueryFrame(QueryRunner queryrunnerObj){
        loginScreen();

        initComponents();
        m_parmlabels = new JLabel[]{jLabel1, jLabel2, jLabel3, jLabel4, jLabel9, jLabel10, jLabel11, jLabel12,
                jLabel15, jLabel16, jLabel17, jLabel18};
        m_textvals = new JTextField[] { jTextField5, jTextField6,jTextField7,jTextField8,jTextField9,jTextField10,jTextField11,jTextField12,
                                        jTextField15, jTextField16, jTextField17, jTextField18};
        m_queryrunner = queryrunnerObj;
        // Find out how many queries there are and set up combox box
        // If it is a grid query, then enable jtable
        int nAmt = m_queryrunner.GetTotalQueries();

        for (int i=0; i < nAmt; i++) {
            this.jComboBoxQuery.addItem(QueryData.getQueryNames(i));
        }
        jComboBoxQuery.setEnabled(false);
        jBtnRunQuery.setEnabled(false);
        
        jLabel14.setText(m_queryrunner.GetProjectTeamApplication());
     }

     private void loginScreen() {
         //String fileName= getClass().getClassLoader().getResource(imgName).getPath();
         //String fileName = resource.getPath();


         ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
         URL resource = classLoader.getResource(imgName);
         System.out.println(resource.getPath());
         img= Toolkit.getDefaultToolkit().getImage(resource);
     }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldDatabase = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTextHostname = new javax.swing.JTextField();
        jTextFieldUser = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jComboBoxQuery = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jConnectButton = new javax.swing.JButton();
        jBtnRunQuery = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, this);
                //g.drawImage(img, getWidth(),getHeight(),this);
            }
        });
        //todo: Bundling images in your .jar file
        //setLocationRelativeTo(null);

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldDatabase.setNextFocusableComponent(jConnectButton);
        getContentPane().add(jTextFieldDatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 120, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        /*getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 350, 140));
        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 330, 140));*/


        jTextHostname.setNextFocusableComponent(jTextFieldUser);
        getContentPane().add(jTextHostname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 120, -1));

        jTextFieldUser.setNextFocusableComponent(jPasswordField1);
        getContentPane().add(jTextFieldUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 120, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());


        //JPanel
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 26, 149, -1));
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 26, 190, -1));
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 26, 160, -1));
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 64, 150, -1));

        //Far left
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("avx");
        jLabel1.setToolTipText("");
        jLabel1.setForeground(Color.white);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 29, 132, -1));

        //Middle
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("aaa");
        jLabel2.setToolTipText("");
        jLabel2.setForeground(Color.white);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 29, 120, -1));

        //Far right
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("aaa");
        jLabel3.setToolTipText("");
        jLabel3.setForeground(Color.white);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 29, 115, -1));

        //Far left, down 36 pixels
        jLabel4.setBackground(new java.awt.Color(204, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("aaa");
        jLabel4.setToolTipText("");
        jLabel4.setForeground(Color.white);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 65, 132, 18));

        //Middle, down 38 pixels
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("yyy");
        jLabel9.setToolTipText("");
        jLabel9.setForeground(Color.white);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 67, 110, -1));

        //Far right, down 38 pixels
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("rrr");
        jLabel10.setToolTipText("");
        jLabel10.setForeground(Color.white);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 67, 116, -1));

        //Far left, 3rd row, down 35 pixels
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("iii");
        jLabel11.setToolTipText("");
        jLabel11.setForeground(Color.white);
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 102, 123, -1));

        //Middle, 3rd row, down 35 pixels
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("ooo");
        jLabel12.setToolTipText("");
        jLabel12.setForeground(Color.white);
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 102, 100, -1));

        //Far right, 3rd row
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("zzz");
        jLabel15.setToolTipText("");
        jLabel15.setForeground(Color.white);
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 102, 116, -1));

        //Far left, 4th row
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("ooo");
        jLabel16.setToolTipText("");
        jLabel16.setForeground(Color.white);
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 136, 123, -1));

        //Middle, 4th
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("ooo");
        jLabel17.setToolTipText("");
        jLabel17.setForeground(Color.white);
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 136, 116, -1));

        //Far right
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("ooo");
        jLabel18.setToolTipText("");
        jLabel18.setForeground(Color.white);
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 136, 116, -1));

        jPanel1.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 64, 188, -1));
        jPanel1.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 64, 160, -1));
        jPanel1.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 99, 150, -1));
        jPanel1.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 99, 190, -1));

        //right, 3rd row
        jPanel1.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 99, 160, -1));
        //left, 4th row
        jPanel1.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 135, 150, -1));
        //mid, 4th
        jPanel1.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 135, 190, -1));
        //right, 4th
        jPanel1.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 135, 160, -1));


        jBtnRunQuery.setText("Run Query");
        jBtnRunQuery.setForeground(Color.orange);
        jBtnRunQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        //getContentPane().add(jBtnRunQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, -1, -1));
        jLabel13.setText("Output");
        jLabel13.setForeground(Color.white);
        //getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 190, -1, -1));


        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        /*Set up start up screen
        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 350, 140));
        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 330, 140));
        jPanel3.add(jComboBoxQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 120, -1));
        jPanel3.add(jBtnRunQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, -1, -1));
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 190, -1, -1));
        */

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 350, 140));
        //jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 0, 330, 140));
        jPanel3.add(jComboBoxQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 120, -1));
        jPanel3.add(jBtnRunQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));
        //jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, -1, -1));
        jPanel3.setOpaque(false);
        this.jPanel3.setVisible(false);
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 740, 190));



        jPanel1.setOpaque(false);

        //Add panel 1 to the UI
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 980, 200));

        jPanel2.setLayout(new java.awt.BorderLayout());
        //Add panel 2
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 980, 240));

        jComboBoxQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });


        //getContentPane().add(jComboBoxQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 120, -1));


        jLabel5.setText("Database");
        jLabel5.setForeground(Color.white);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 90, 10));

        jLabel6.setText("Hostname");
        jLabel6.setForeground(Color.white);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, -1));

        jLabel7.setText("User");
        jLabel7.setForeground(Color.white);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 100, -1));

        jLabel8.setText("Password");
        jLabel8.setForeground(Color.white);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 80, -1));

        jConnectButton.setText("Connect");
        jConnectButton.setForeground(Color.orange);
        jConnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        getContentPane().add(jConnectButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));



        jPasswordField1.setText("jPasswordField1");
        //jPasswordField1.setNextFocusableComponent(jTextFieldDatabase);
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 120, -1));



        jLabel14.setFont(new java.awt.Font("Tahoma", 8, 18)); // NOI18N
        jLabel14.setText("VVV");
        jLabel14.setForeground(Color.WHITE);
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 180, -1));

        //pack();
        this.setSize(1024,668);
        setDefaultLookAndFeelDecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);


    }// </editor-fold>//GEN-END:initComponents


    
   /**
    * This button will use the data from the textboxes, and attempt to connect to the MYSQL Server.
    * If it is not connected, it will
    * call the CONNECT function, otherwise it will call the DISCONNECT Function.
    * @param evt 
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean  bOK=true; 
        jTextArea2.setText("");
        JFrame f = new JFrame();

        //Connect
        if (jConnectButton.getText() == "Connect") {
            bOK = m_queryrunner.Connect(this.jTextHostname.getText(), this.jTextFieldUser.getText(),
                    String.valueOf(this.jPasswordField1.getPassword()), this.jTextFieldDatabase.getText());
           if (bOK) {
               jConnectButton.setText("Disconnect");
               //Hide log-in credentials
               jTextFieldUser.setVisible(false);
               jPasswordField1.setVisible(false);
               jTextHostname.setVisible(false);
               jTextFieldDatabase.setVisible(false);
               jLabel5.setVisible(false);
               jLabel6.setVisible(false);
               jLabel7.setVisible(false);
               jLabel8.setVisible(false);

               this.jPanel3.setVisible(true);
               jComboBoxQuery.setEnabled(true);
               jBtnRunQuery.setEnabled(true);

               JOptionPane.showMessageDialog(f, "You have been logged in!");


           }
        }
        //Disconnect
        else {
           bOK = m_queryrunner.Disconnect();
           if (bOK) {
               jConnectButton.setText("Connect");
               //Show log-in panes
               jTextFieldUser.setText("");
               jPasswordField1.setText("jPasswordField1");
               jTextFieldUser.setVisible(true);
               jPasswordField1.setVisible(true);
               jTextHostname.setVisible(true);
               jTextFieldDatabase.setVisible(true);
               jLabel5.setVisible(true);
               jLabel6.setVisible(true);
               jLabel7.setVisible(true);
               jLabel8.setVisible(true);

               //Reset
               jComboBoxQuery.setEnabled(false);
               jBtnRunQuery.setEnabled(false);
               this.jPanel3.setVisible(false);
               if(this.jPanel2.isVisible())
                   this.jPanel2.setVisible(false);
               if(this.jPanel1.isVisible())
                   this.jPanel1.setVisible(false);

               JOptionPane.showMessageDialog(f, "You have been logged out!");
           }
        }
        //Print error
        if (!bOK) {
            //this.jTextArea2.setText(m_queryrunner.GetError());
            JOptionPane.showMessageDialog(f, "Wrong username and/or password.");
        }       
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * This event handler recognizes when something has changed regarding the 
     * drop down box. It will recognize which one is selected and get the correct
     * Query Data that it will then use to populate the TextArea that display's the
     * query. It will also recognize if it is a "parameter" query. If it is, it will
     * make the PANEL Control which holds the parameter data to be visible, and will
     * put the appropriate parameter labels along with their textboxes.
     * 
     * @param evt 
     */
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        JFrame f = new JFrame();
        int answer;
        jTextArea2.setText("");
        String szChoice = (String)jComboBoxQuery.getSelectedItem();

        // Orignal code
        // String szStripChoice = szChoice.substring(6);
        // m_queryChoice = Integer.parseInt(szStripChoice)-1;
        // m_queryChoice = m_queryrunner.getQueryNumber(szChoice);

        m_queryChoice = QueryData.getQueryNumber(szChoice);
        String szQuery = QueryData.getQueryNames(m_queryChoice); //GetQueryText(m_queryChoice);
        this.jTextArea1.setText(szQuery);
        System.out.println("choice is " + szChoice);
        this.jPanel2.setVisible(false);

        //Make suure the user adds the blood line first
        if (m_queryChoice == 8) {
            answer = JOptionPane.showConfirmDialog(f, "Do you know the horse's Blood line ID?");
            if (answer == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(f,"Please add the horse's Bloodline first.");
                return;
            }
        }

        if (this.m_queryrunner.isParameterQuery(m_queryChoice)) {
            this.jPanel1.setVisible(true);                        
            int nAmt = this.m_queryrunner.GetParameterAmtForQuery(m_queryChoice);
            for (int i=0; i< nAmt; i++) {
                m_parmlabels[i].setVisible(true);
                m_parmlabels[i].setText("<html>" + m_queryrunner.GetParamText(m_queryChoice, i) + "<html>");
                m_textvals[i].setVisible(true);
                m_textvals[i].setText("");
            }

            //Set other available parm labels to be unavailable
            for (int i = nAmt; i < 12; i++) {
                m_parmlabels[i].setVisible(false);  
                m_textvals[i].setVisible(false);
            }            
        }
        else
        {
            this.jPanel1.setVisible(false);
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed


/**
 * This is the Action handler for the "RUN QUERY" button. It tries to identify
 * If it is an action query first. If it is, it will take the parameter data from
 * the various textboxes and create a parameter array that it will eventually pass
 * to the ExecuteQuery function.
 * 
 * If it is a query that returns a resultset, it will create a JTABLE which is a
 * GUI Control that enables the resultset data to transferred to it.
 * @param evt Java Event Handler
 */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        jTextArea2.setText("");        
        if (!this.m_queryrunner.isActionQuery(m_queryChoice))
            jPanel2.setVisible(true);
        
        int nAmt = this.m_queryrunner.GetParameterAmtForQuery(m_queryChoice);
        String [] parmstring={};
        String [] headers;
        String [][] allData;
        JFrame f = new JFrame();

        boolean  bOK = true;
        
        if (this.m_queryrunner.isParameterQuery(m_queryChoice)) {
            parmstring = new String [nAmt];
            for (int i=0; i< nAmt; i++) {
                parmstring[i] = this.m_textvals[i].getText();
            }                    
        }
        
        if (this.m_queryrunner.isActionQuery(m_queryChoice)) {

            bOK = m_queryrunner.ExecuteUpdate(m_queryChoice, parmstring);
            if (bOK) {
                //this.jTextArea2.setText(("Rows affected = " + m_queryrunner.GetUpdateAmount()));
                JOptionPane.showMessageDialog(f,"Rows affected = " + m_queryrunner.GetUpdateAmount());
            }
            else
            {
                //this.jTextArea2.setText(m_queryrunner.GetError());
                JOptionPane.showMessageDialog(f, m_queryrunner.GetError());
            }
        } else {
            bOK = m_queryrunner.ExecuteQuery(m_queryChoice, parmstring);
            if (bOK) {
                headers = m_queryrunner.GetQueryHeaders();
                allData = m_queryrunner.GetQueryData();
                if (m_scrollPane != null)
                {
                    m_scrollPane.remove(m_jTable);  
                    jPanel2.remove(m_scrollPane);
                }
                m_jTable = new JTable(allData, headers);
                
                m_jTable.setBounds(100, 100, 100, 80);
                Color ivory = new Color(255,255,208);
                m_jTable.setOpaque(false);
                m_jTable.setBackground(ivory);           
                m_scrollPane = new JScrollPane(m_jTable);
                jPanel2.add(m_scrollPane);// add table in panel using add() method                      
                this.jPanel2.setVisible(true);
            } else {
                this.jTextArea2.setText(m_queryrunner.GetError());                
            }
        }                
    }//GEN-LAST:event_jButton2ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jConnectButton;
    private javax.swing.JButton jBtnRunQuery;
    private javax.swing.JComboBox<String> jComboBoxQuery;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel15, jLabel16, jLabel17, jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;

    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextFieldDatabase;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextHostname;
    private javax.swing.JTextField jTextFieldUser;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9, jTextField18, jTextField17, jTextField16, jTextField15;

    // End of variables declaration//GEN-END:variables

    private final JLabel[] m_parmlabels;
    private JTextField [] m_textvals;
    private QueryRunner m_queryrunner;
    private javax.swing.JTable m_jTable;
    JScrollPane m_scrollPane;
    private int m_queryChoice = 0 ; // This is the default query that was selected 

}
