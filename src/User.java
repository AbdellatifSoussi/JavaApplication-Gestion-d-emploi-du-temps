import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class User extends javax.swing.JFrame {
        Connection cnx;Statement st;PreparedStatement pst;ResultSet rs;
    //private Authentification login = new Authentification();
    String url,req;
    public User() {
        initComponents();
        setSize(1260,610); 
        TypeSalle4.setSize(1250,600);
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            url="jdbc:sqlserver://ABDEELSOO\\SQLEXPRESS;user=Abdeel;password=1234;DatabaseName=EMP_TEMPS";
            cnx=DriverManager.getConnection(url);
        }catch(Exception ex){JOptionPane.showMessageDialog(this, ex.getMessage());}
        
        try{
            comboFilliiere.removeAll();
            String req="select nom_filliere from filliere";
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            while(rs.next())
            {
                comboFilliiere.addItem(rs.getString(1));
            }
        }catch(Exception ex){}
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        TypeSalle4 = new javax.swing.JPanel();
        t20 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        t3 = new javax.swing.JTextField();
        t4 = new javax.swing.JTextField();
        t5 = new javax.swing.JTextField();
        t6 = new javax.swing.JTextField();
        t7 = new javax.swing.JTextField();
        t8 = new javax.swing.JTextField();
        t9 = new javax.swing.JTextField();
        t10 = new javax.swing.JTextField();
        t11 = new javax.swing.JTextField();
        t12 = new javax.swing.JTextField();
        t13 = new javax.swing.JTextField();
        t14 = new javax.swing.JTextField();
        t15 = new javax.swing.JTextField();
        t16 = new javax.swing.JTextField();
        t17 = new javax.swing.JTextField();
        t18 = new javax.swing.JTextField();
        t19 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        comboFilliiere = new java.awt.Choice();
        jLabel49 = new javax.swing.JLabel();
        comboGroupe = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Utilisateur");
        setBackground(new java.awt.Color(153, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(900, 550));
        getContentPane().setLayout(null);
        getContentPane().add(filler1);
        filler1.setBounds(249, 50, 0, 0);

        TypeSalle4.setBackground(new java.awt.Color(204, 204, 255));
        TypeSalle4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        TypeSalle4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                TypeSalle4ComponentShown(evt);
            }
        });
        TypeSalle4.setLayout(null);

        t20.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t20.setDisabledTextColor(java.awt.Color.darkGray);
        t20.setEnabled(false);
        TypeSalle4.add(t20);
        t20.setBounds(930, 460, 260, 60);

        jLabel31.setBackground(new java.awt.Color(204, 255, 204));
        jLabel31.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        jLabel31.setForeground(java.awt.Color.darkGray);
        jLabel31.setText("Jeudi");
        TypeSalle4.add(jLabel31);
        jLabel31.setBounds(20, 400, 60, 30);

        jLabel32.setBackground(new java.awt.Color(204, 255, 204));
        jLabel32.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        jLabel32.setForeground(java.awt.Color.darkGray);
        jLabel32.setText("Mardi");
        TypeSalle4.add(jLabel32);
        jLabel32.setBounds(20, 230, 80, 30);

        jLabel33.setBackground(new java.awt.Color(204, 255, 204));
        jLabel33.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        jLabel33.setForeground(java.awt.Color.darkGray);
        jLabel33.setText("Vendredi");
        TypeSalle4.add(jLabel33);
        jLabel33.setBounds(20, 480, 120, 30);

        jLabel34.setBackground(new java.awt.Color(204, 255, 204));
        jLabel34.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        jLabel34.setForeground(java.awt.Color.darkGray);
        jLabel34.setText("Mercredi");
        TypeSalle4.add(jLabel34);
        jLabel34.setBounds(20, 310, 120, 30);

        jLabel35.setBackground(new java.awt.Color(204, 255, 204));
        jLabel35.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel35.setForeground(java.awt.Color.darkGray);
        jLabel35.setText("08-10");
        TypeSalle4.add(jLabel35);
        jLabel35.setBounds(220, 90, 60, 30);

        jLabel36.setBackground(new java.awt.Color(204, 255, 204));
        jLabel36.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel36.setForeground(java.awt.Color.darkGray);
        jLabel36.setText("10-12");
        TypeSalle4.add(jLabel36);
        jLabel36.setBounds(490, 90, 60, 30);

        jLabel37.setBackground(new java.awt.Color(204, 255, 204));
        jLabel37.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel37.setForeground(java.awt.Color.darkGray);
        jLabel37.setText("14-16");
        TypeSalle4.add(jLabel37);
        jLabel37.setBounds(760, 90, 60, 30);

        jLabel38.setBackground(new java.awt.Color(204, 255, 204));
        jLabel38.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel38.setForeground(java.awt.Color.darkGray);
        jLabel38.setText("16-18");
        TypeSalle4.add(jLabel38);
        jLabel38.setBounds(1020, 90, 60, 30);

        t1.setEditable(false);
        t1.setBackground(new java.awt.Color(255, 255, 255));
        t1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t1.setDisabledTextColor(java.awt.Color.darkGray);
        t1.setEnabled(false);
        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });
        TypeSalle4.add(t1);
        t1.setBounds(390, 140, 260, 60);

        t2.setEditable(false);
        t2.setBackground(new java.awt.Color(255, 255, 255));
        t2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t2.setDisabledTextColor(java.awt.Color.darkGray);
        t2.setEnabled(false);
        TypeSalle4.add(t2);
        t2.setBounds(130, 140, 260, 60);

        t3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t3.setDisabledTextColor(java.awt.Color.darkGray);
        t3.setEnabled(false);
        TypeSalle4.add(t3);
        t3.setBounds(930, 140, 260, 60);

        t4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t4.setDisabledTextColor(java.awt.Color.darkGray);
        t4.setEnabled(false);
        TypeSalle4.add(t4);
        t4.setBounds(670, 140, 260, 60);

        t5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t5.setDisabledTextColor(java.awt.Color.darkGray);
        t5.setEnabled(false);
        TypeSalle4.add(t5);
        t5.setBounds(130, 220, 260, 60);

        t6.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t6.setDisabledTextColor(java.awt.Color.darkGray);
        t6.setEnabled(false);
        TypeSalle4.add(t6);
        t6.setBounds(390, 220, 260, 60);

        t7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t7.setDisabledTextColor(java.awt.Color.darkGray);
        t7.setEnabled(false);
        TypeSalle4.add(t7);
        t7.setBounds(670, 220, 260, 60);

        t8.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t8.setDisabledTextColor(java.awt.Color.darkGray);
        t8.setEnabled(false);
        TypeSalle4.add(t8);
        t8.setBounds(930, 220, 260, 60);

        t9.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t9.setDisabledTextColor(java.awt.Color.darkGray);
        t9.setEnabled(false);
        TypeSalle4.add(t9);
        t9.setBounds(130, 300, 260, 60);

        t10.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t10.setDisabledTextColor(java.awt.Color.darkGray);
        t10.setEnabled(false);
        TypeSalle4.add(t10);
        t10.setBounds(390, 300, 260, 60);

        t11.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t11.setDisabledTextColor(java.awt.Color.darkGray);
        t11.setEnabled(false);
        TypeSalle4.add(t11);
        t11.setBounds(670, 300, 260, 60);

        t12.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t12.setDisabledTextColor(java.awt.Color.darkGray);
        t12.setEnabled(false);
        TypeSalle4.add(t12);
        t12.setBounds(930, 300, 260, 60);

        t13.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t13.setDisabledTextColor(java.awt.Color.darkGray);
        t13.setEnabled(false);
        TypeSalle4.add(t13);
        t13.setBounds(130, 380, 260, 60);

        t14.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t14.setDisabledTextColor(java.awt.Color.darkGray);
        t14.setEnabled(false);
        TypeSalle4.add(t14);
        t14.setBounds(390, 380, 260, 60);

        t15.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t15.setDisabledTextColor(java.awt.Color.darkGray);
        t15.setEnabled(false);
        TypeSalle4.add(t15);
        t15.setBounds(670, 380, 260, 60);

        t16.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t16.setDisabledTextColor(java.awt.Color.darkGray);
        t16.setEnabled(false);
        TypeSalle4.add(t16);
        t16.setBounds(930, 380, 260, 60);

        t17.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t17.setDisabledTextColor(java.awt.Color.darkGray);
        t17.setEnabled(false);
        TypeSalle4.add(t17);
        t17.setBounds(130, 460, 260, 60);

        t18.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t18.setDisabledTextColor(java.awt.Color.darkGray);
        t18.setEnabled(false);
        TypeSalle4.add(t18);
        t18.setBounds(390, 460, 260, 60);

        t19.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t19.setDisabledTextColor(java.awt.Color.darkGray);
        t19.setEnabled(false);
        TypeSalle4.add(t19);
        t19.setBounds(670, 460, 260, 60);

        jLabel48.setBackground(new java.awt.Color(204, 255, 204));
        jLabel48.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        jLabel48.setForeground(java.awt.Color.darkGray);
        jLabel48.setText("Lundi");
        TypeSalle4.add(jLabel48);
        jLabel48.setBounds(20, 150, 80, 30);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jLabel30.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel30.setText("Fillière :");
        jPanel1.add(jLabel30);
        jLabel30.setBounds(215, 10, 90, 50);

        comboFilliiere.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboFilliiereItemStateChanged(evt);
            }
        });
        jPanel1.add(comboFilliiere);
        comboFilliiere.setBounds(340, 20, 186, 70);

        jLabel49.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel49.setText("Groupe :");
        jPanel1.add(jLabel49);
        jLabel49.setBounds(610, 20, 120, 30);

        comboGroupe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboGroupeItemStateChanged(evt);
            }
        });
        jPanel1.add(comboGroupe);
        comboGroupe.setBounds(740, 20, 185, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/404-200.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 0, 130, 80);

        TypeSalle4.add(jPanel1);
        jPanel1.setBounds(0, 0, 1260, 80);

        getContentPane().add(TypeSalle4);
        TypeSalle4.setBounds(-10, 0, 1220, 580);

        jMenuBar1.setBackground(new java.awt.Color(255, 204, 255));
        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        File.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        File.setText("File");
        File.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileActionPerformed(evt);
            }
        });
        File.add(jSeparator1);

        jMenuItem1.setForeground(new java.awt.Color(51, 51, 255));
        jMenuItem1.setText("Admin");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        File.add(jMenuItem1);
        File.add(jSeparator2);

        jMenuItem3.setForeground(new java.awt.Color(255, 51, 51));
        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        File.add(jMenuItem3);

        jMenuBar1.add(File);

        Help.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        Help.setText("Help");
        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileActionPerformed
       
    }//GEN-LAST:event_FileActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
         new Authentification(this, true, this).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void comboFilliiereItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboFilliiereItemStateChanged
        try{
            comboGroupe.removeAllItems();
            String req="select nom_groupe from groupe,filliere \n" +
            "where groupe.num_filliere=filliere.num_filliere\n" +
            "and filliere.nom_filliere=?";
            pst=cnx.prepareStatement(req) ;
            pst.setString(1, (String) comboFilliiere.getSelectedItem());
            rs= pst.executeQuery();
            ArrayList L=new ArrayList();
            int i=0;
            while(rs.next())
            {
                L.add(rs.getString(1));

            }
            String Groupe[]=new String[L.size()];
            for(Object o:L)
            {Groupe[i]=o.toString();
                i++;}
            comboGroupe.setModel(new DefaultComboBoxModel<>(Groupe));

        }catch(Exception ex){JOptionPane.showMessageDialog(this,"","Erreur ",
            JOptionPane.ERROR_MESSAGE);   }
        comboGroupe.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                try{
                    
                    String req2="select distinct joursemaine,seance,nom_mat,nom_groupe,descrip,nom,emploi.num_salle,type_salle.descrip\n" +
                                "from emploi,matiere,salle,type_salle,professeur,groupe\n" +
                                "where emploi.code_mat=matiere.code_mat\n" +
                                "and groupe.num_groupe=emploi.num_groupe\n" +
                                "and emploi.num_salle=salle.num_salle\n" +
                                "and salle.num_type=type_salle.num_type\n" +
                                "and matiere.id_prof=professeur.id_prof\n" +
                                "and nom_groupe=?";
                    
                    pst=cnx.prepareStatement(req2) ;
                    pst.setString(1,comboGroupe.getSelectedItem().toString());
                    rs= pst.executeQuery();
                    pst.clearParameters();
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    t8.setText("");
                    t9.setText("");
                    t10.setText("");
                    t11.setText("");
                    t12.setText("");
                    t13.setText("");
                    t14.setText("");
                    t15.setText("");
                    t16.setText("");
                    t17.setText("");
                    t18.setText("");
                    t19.setText("");
                    t20.setText("");
                    while(rs.next())
                    {
                        if(rs.getString(1).equals("Lundi"))
                        {
                            if(rs.getString(2).equals("1"))
                            {
                                t1.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("2"))
                            {
                                t2.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("3"))
                            {
                                t3.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("4"))
                            {
                                t4.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                                
                        }
                        if(rs.getString(1).equals("Mardi"))
                        {
                            if(rs.getString(2).equals("1"))
                            {
                                t5.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("2"))
                            {
                                t6.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("3"))
                            {
                                t7.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("4"))
                            {
                                t8.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }        
                        }
                        if(rs.getString(1).equals("Mercredi"))
                        {
                            if(rs.getString(2).equals("1"))
                            {
                                t9.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("2"))
                            {
                                t10.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("3"))
                            {
                                t11.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("4"))
                            {
                                t12.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }        
                        }
                        if(rs.getString(1).equals("Jeudi"))
                        {
                            if(rs.getString(2).equals("1"))
                            {
                                t13.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("2"))
                            {
                                t14.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("3"))
                            {
                                t15.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("4"))
                            {
                                t16.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }        
                        }
                        if(rs.getString(1).equals("Vendredi"))
                        {
                            if(rs.getString(2).equals("1"))
                            {
                                t17.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("2"))
                            {
                                t18.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("3"))
                            {
                                t19.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("4"))
                            {
                                t20.setText(rs.getString(3)+" | "+rs.getString(6)+" | "+rs.getString(8)+rs.getInt(7));
                            }        
                        }
                        
                        //t1.setText(rs.getString(3)+"\n"+rs.getString(5)+"\n"+rs.getString(6));
                        
                    }
                   
      
                }catch(Exception ex){}
            }
        });
    }//GEN-LAST:event_comboFilliiereItemStateChanged

    private void TypeSalle4ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_TypeSalle4ComponentShown

    }//GEN-LAST:event_TypeSalle4ComponentShown

    private void comboGroupeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboGroupeItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboGroupeItemStateChanged

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t1ActionPerformed

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
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu File;
    private javax.swing.JMenu Help;
    private javax.swing.JPanel TypeSalle4;
    private java.awt.Choice comboFilliiere;
    private javax.swing.JComboBox<String> comboGroupe;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t10;
    private javax.swing.JTextField t11;
    private javax.swing.JTextField t12;
    private javax.swing.JTextField t13;
    private javax.swing.JTextField t14;
    private javax.swing.JTextField t15;
    private javax.swing.JTextField t16;
    private javax.swing.JTextField t17;
    private javax.swing.JTextField t18;
    private javax.swing.JTextField t19;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t20;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    private javax.swing.JTextField t5;
    private javax.swing.JTextField t6;
    private javax.swing.JTextField t7;
    private javax.swing.JTextField t8;
    private javax.swing.JTextField t9;
    // End of variables declaration//GEN-END:variables
}
