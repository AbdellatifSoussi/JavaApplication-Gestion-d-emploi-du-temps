import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Admin extends javax.swing.JFrame {

    Connection cnx;Statement st;PreparedStatement pst;ResultSet rs;
    //private Authentification login = new Authentification();
    String url,descrip_diplome;
    String numtype,numdiplome,idprof,numdetaildip,codemat,numfilliere,numgroupe,numemploi;
    public Admin() {
        //new Authentification();
        initComponents();
        setSize(1220,610); 
        x.setSize(1200,600);
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            url="jdbc:sqlserver://ABDEELSOO\\SQLEXPRESS;user=Abdeel;password=1234;DatabaseName=EMP_TEMPS";
            cnx=DriverManager.getConnection(url);

            ComboType.removeAllItems();
            String req="select * from type_salle";
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            while(rs.next())
            {
                ComboType.addItem(rs.getString(2));
            }
        }catch(Exception ex){JOptionPane.showMessageDialog(this, ex.getMessage());}
        //************************
       
        
        //****************************
        ComboType.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                try{
            
                    String req2="select * from type_salle where descrip=?";
                    pst=cnx.prepareStatement(req2) ;
                    pst.setString(1, ComboType.getSelectedItem().toString());
                    rs= pst.executeQuery();
                    pst.clearParameters();
                    while(rs.next())
                    {
                        TxtNomSalle.setText(rs.getString(1));
                    }
                }catch(Exception ex){} 
            }
        });
        
        try{
            ComboIdProf.removeAllItems();
            String req="select nom from professeur";
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            while(rs.next())
            {
                ComboIdProf.addItem(rs.getString(1));
            }
        }catch(Exception ex){}
        
        ComboIdProf.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                try{
            
                    String req2="select * from professeur where nom=?";
                    pst=cnx.prepareStatement(req2) ;
                    pst.setString(1,ComboIdProf.getSelectedItem().toString());
                    rs= pst.executeQuery();
                    pst.clearParameters();
                    while(rs.next())
                    {
                        TxtNomProfesseur.setText(rs.getString(1));
                    }
                }catch(Exception ex){} 
            }
        });
        try{
            ComboNumFill.removeAllItems();
            String req="select nom_filliere from filliere";
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            while(rs.next())
            {
                ComboNumFill.addItem(rs.getString(1));
            }
        }catch(Exception ex){}
        ComboNumFill.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                try{
            
                    String req2="select * from filliere where nom_filliere=?";
                    pst=cnx.prepareStatement(req2) ;
                    pst.setString(1, ComboNumFill.getSelectedItem().toString());
                    rs= pst.executeQuery();
                    pst.clearParameters();
                    while(rs.next())
                    {
                        TxtNomFilliere.setText(rs.getString(1));
                    }
                }catch(Exception ex){} 
            }
        });
        try{
            ComboNumSalle.removeAllItems();
            String req="select * from salle";
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            while(rs.next())
            {
                ComboNumSalle.addItem(rs.getString(1));
            }
        }catch(Exception ex){}
        ComboNumSalle.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){    
                try{
            
                    String req2="select distinct type_salle.* from type_salle,salle where type_salle.num_type=salle.num_type and Salle.num_salle=?";
                    pst=cnx.prepareStatement(req2) ;
                    pst.setInt(1, Integer.parseInt(ComboNumSalle.getSelectedItem().toString()));
                    rs= pst.executeQuery();
                    pst.clearParameters();
                    while(rs.next())
                    {
                        TxtNomSalle2.setText(rs.getString(2));
                    }
                }catch(Exception ex){} 
            }
        });
        try{
            ComboCodeMat.removeAllItems();
            String req="select nom_mat from matiere";
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            while(rs.next())
            {
                ComboCodeMat.addItem(rs.getString(1));
            }
        }catch(Exception ex){}
        ComboCodeMat.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    String req2="select * from matiere where nom_mat=?";
                    pst=cnx.prepareStatement(req2) ;
                    pst.setString(1, ComboCodeMat.getSelectedItem().toString());
                    rs= pst.executeQuery();
                    pst.clearParameters();
                    while(rs.next())
                    {
                        TxtNomMatiere.setText(rs.getString(1));
                        
                    }
                }catch(Exception ex){} 
            }
        });
        try{
            ComboNumGroupe.removeAllItems();
            String req="select nom_groupe from groupe";
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            while(rs.next())
            {
                ComboNumGroupe.addItem(rs.getString(1));
            }
        }catch(Exception ex){}
        
        ComboNumGroupe.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){                
                try{
                    
                    String req2="select * from groupe where nom_groupe=?";
                    pst=cnx.prepareStatement(req2) ;
                    pst.setString(1, ComboNumGroupe.getSelectedItem().toString());
                    rs= pst.executeQuery();
                    pst.clearParameters();
                    while(rs.next())
                    {
                        TxtNomGroupe2.setText(rs.getString(1));
                    }
                    t1.setText(null);
                }catch(Exception ex){} 
            }
        });
            
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
        
        try{
            comboProfesseur.removeAll();
            String req="select nom from professeur";
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            while(rs.next())
            {
                comboProfesseur.addItem(rs.getString(1));
            }
        }catch(Exception ex){}
        comboProfesseur.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                try{
                    
                    String req2="select distinct joursemaine,seance,nom_mat,nom_groupe,descrip,nom,emploi.num_salle,type_salle.descrip\n" +
                                "from emploi,matiere,salle,type_salle,professeur,groupe\n" +
                                "where emploi.code_mat=matiere.code_mat\n" +
                                "and groupe.num_groupe=emploi.num_groupe\n" +
                                "and emploi.num_salle=salle.num_salle\n" +
                                "and salle.num_type=type_salle.num_type \n" +
                                "and matiere.id_prof=professeur.id_prof\n" +
                                "and professeur.nom=?";
                    
                    pst=cnx.prepareStatement(req2) ;
                    pst.setString(1,comboProfesseur.getSelectedItem().toString());
                    rs= pst.executeQuery();
                    pst.clearParameters();
                    t21.setText("");
                    t22.setText("");
                    t23.setText("");
                    t24.setText("");
                    t25.setText("");
                    t26.setText("");
                    t27.setText("");
                    t28.setText("");
                    t29.setText("");
                    t30.setText("");
                    t31.setText("");
                    t32.setText("");
                    t33.setText("");
                    t34.setText("");
                    t35.setText("");
                    t36.setText("");
                    t37.setText("");
                    t38.setText("");
                    t39.setText("");
                    t40.setText("");
                    while(rs.next())
                    {
                        if(rs.getString(1).equals("Lundi"))
                        {
                            if(rs.getString(2).equals("1"))
                            {
                                t22.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("2"))
                            {
                                t23.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("3"))
                            {
                                t24.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("4"))
                            {
                                t25.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                                
                        }
                        if(rs.getString(1).equals("Mardi"))
                        {
                            if(rs.getString(2).equals("1"))
                            {
                                t26.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("2"))
                            {
                                t27.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("3"))
                            {
                                t28.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("4"))
                            {
                                t29.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }        
                        }
                        if(rs.getString(1).equals("Mercredi"))
                        {
                            if(rs.getString(2).equals("1"))
                            {
                                t30.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("2"))
                            {
                                t31.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("3"))
                            {
                                t32.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("4"))
                            {
                                t33.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }        
                        }
                        if(rs.getString(1).equals("Jeudi"))
                        {
                            if(rs.getString(2).equals("1"))
                            {
                                t34.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("2"))
                            {
                                t35.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("3"))
                            {
                                t36.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("4"))
                            {
                                t37.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }        
                        }
                        if(rs.getString(1).equals("Vendredi"))
                        {
                            if(rs.getString(2).equals("1"))
                            {
                                t38.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("2"))
                            {
                                t39.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("3"))
                            {
                                t40.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }
                            if(rs.getString(2).equals("4"))
                            {
                                t21.setText(rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(8)+rs.getInt(7));
                            }        
                        }    
                    }
                }catch(Exception ex){}
            }
        });    
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
                    }
                }catch(Exception ex){}
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jSeparator1 = new javax.swing.JSeparator();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        x = new javax.swing.JTabbedPane();
        TypeSalle = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        TxtNumType = new javax.swing.JTextField();
        TxtDescrip = new javax.swing.JTextField();
        BtVider = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        BTModifier = new javax.swing.JButton();
        BTREchercher = new javax.swing.JButton();
        BtAjouter = new javax.swing.JButton();
        BTSupprimer = new javax.swing.JButton();
        Salle = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        TxtNomSalle = new javax.swing.JTextField();
        TxtNumSalle = new javax.swing.JTextField();
        ComboType = new javax.swing.JComboBox<>();
        TxtNbrTable = new javax.swing.JTextField();
        TxtNbrChaise = new javax.swing.JTextField();
        BtVider1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BtAjouter1 = new javax.swing.JButton();
        BTREchercher1 = new javax.swing.JButton();
        BTModifier1 = new javax.swing.JButton();
        BTSupprimer1 = new javax.swing.JButton();
        TypeSalle2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        TxtNomMat = new javax.swing.JTextField();
        ComboIdProf = new javax.swing.JComboBox<>();
        TxtNomProfesseur = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        TxtCodeMat = new javax.swing.JTextField();
        BtVider5 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        BtAjouter5 = new javax.swing.JButton();
        BTModifier5 = new javax.swing.JButton();
        BTREchercher5 = new javax.swing.JButton();
        BTSupprimer5 = new javax.swing.JButton();
        TypeSalle1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        TxtIdProf = new javax.swing.JTextField();
        TxtNomProf = new javax.swing.JTextField();
        TxtPrenomProf = new javax.swing.JTextField();
        BtVider3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        BtAjouter3 = new javax.swing.JButton();
        BTREchercher3 = new javax.swing.JButton();
        BTSupprimer3 = new javax.swing.JButton();
        BTModifier3 = new javax.swing.JButton();
        TypeSalle3 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        TxtNumFill = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        TxtNomMat1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        BtVider6 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        BtAjouter6 = new javax.swing.JButton();
        BTSupprimer6 = new javax.swing.JButton();
        BTModifier6 = new javax.swing.JButton();
        BTREchercher6 = new javax.swing.JButton();
        Salle1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        TxtNumGroupe = new javax.swing.JTextField();
        TxtNomGroupe = new javax.swing.JTextField();
        TxtNbrEtudiant = new javax.swing.JTextField();
        ComboNumFill = new javax.swing.JComboBox<>();
        TxtNomFilliere = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        BtVider2 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        BtAjouter2 = new javax.swing.JButton();
        BTSupprimer2 = new javax.swing.JButton();
        BTModifier2 = new javax.swing.JButton();
        BTREchercher2 = new javax.swing.JButton();
        Salle2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        Salle3 = new javax.swing.JPanel();
        BtAjouter7 = new javax.swing.JButton();
        BtVider7 = new javax.swing.JButton();
        BTSupprimer7 = new javax.swing.JButton();
        BTModifier7 = new javax.swing.JButton();
        BTREchercher7 = new javax.swing.JButton();
        TxtNumSalle2 = new javax.swing.JTextField();
        TxtNbrChaise2 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        TxtNbrTable2 = new javax.swing.JTextField();
        ComboType2 = new javax.swing.JComboBox<>();
        jPanel14 = new javax.swing.JPanel();
        ComboNumGroupe = new javax.swing.JComboBox<>();
        ComboCodeMat = new javax.swing.JComboBox<>();
        TxtNomSalle2 = new javax.swing.JTextField();
        ComboNumSalle = new javax.swing.JComboBox<>();
        TxtSeance = new javax.swing.JTextField();
        TxtJourSem = new javax.swing.JTextField();
        TxtNumEmp = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        BtVider4 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        BtAjouter4 = new javax.swing.JButton();
        BTSupprimer4 = new javax.swing.JButton();
        BTModifier4 = new javax.swing.JButton();
        BTREchercher4 = new javax.swing.JButton();
        TxtNomGroupe2 = new javax.swing.JTextField();
        TxtNomMatiere = new javax.swing.JTextField();
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
        jPanel16 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        comboGroupe = new javax.swing.JComboBox<>();
        comboFilliiere = new java.awt.Choice();
        jLabel30 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        TypeSalle5 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        t21 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        t22 = new javax.swing.JTextField();
        t23 = new javax.swing.JTextField();
        t24 = new javax.swing.JTextField();
        t25 = new javax.swing.JTextField();
        t26 = new javax.swing.JTextField();
        t27 = new javax.swing.JTextField();
        t28 = new javax.swing.JTextField();
        t29 = new javax.swing.JTextField();
        t30 = new javax.swing.JTextField();
        t31 = new javax.swing.JTextField();
        t32 = new javax.swing.JTextField();
        t33 = new javax.swing.JTextField();
        t34 = new javax.swing.JTextField();
        t35 = new javax.swing.JTextField();
        t36 = new javax.swing.JTextField();
        t37 = new javax.swing.JTextField();
        t38 = new javax.swing.JTextField();
        t39 = new javax.swing.JTextField();
        t40 = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        comboProfesseur = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jMenu5.setText("jMenu5");

        jMenu6.setText("jMenu6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrateur");
        getContentPane().setLayout(null);

        x.setBackground(new java.awt.Color(255, 153, 204));
        x.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        x.setName(""); // NOI18N
        x.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xMouseClicked(evt);
            }
        });

        TypeSalle.setBackground(new java.awt.Color(204, 204, 255));
        TypeSalle.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                TypeSalleComponentShown(evt);
            }
        });
        TypeSalle.setLayout(null);

        jTable1.setBackground(new java.awt.Color(255, 255, 204));
        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Num_type", "Description"
            }
        ));
        jTable1.setEnabled(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        TypeSalle.add(jScrollPane2);
        jScrollPane2.setBounds(520, 100, 670, 390);

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.setLayout(null);
        jPanel4.add(TxtNumType);
        TxtNumType.setBounds(210, 100, 210, 40);
        jPanel4.add(TxtDescrip);
        TxtDescrip.setBounds(210, 160, 210, 40);

        BtVider.setBackground(new java.awt.Color(204, 204, 204));
        BtVider.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        BtVider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vider.png"))); // NOI18N
        BtVider.setText("Vider");
        BtVider.setToolTipText("");
        BtVider.setAlignmentY(0.7F);
        BtVider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtViderActionPerformed(evt);
            }
        });
        jPanel4.add(BtVider);
        BtVider.setBounds(140, 230, 170, 50);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Num_Type");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(80, 100, 140, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Description");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(80, 160, 120, 40);

        jPanel19.setBackground(new java.awt.Color(204, 204, 255));
        jPanel19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel19.setLayout(null);

        jLabel51.setBackground(new java.awt.Color(204, 204, 255));
        jLabel51.setFont(new java.awt.Font("SimSun", 3, 24)); // NOI18N
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salle-(2).png"))); // NOI18N
        jLabel51.setText("GESTION TYPE DE SALLE");
        jPanel19.add(jLabel51);
        jLabel51.setBounds(70, 0, 340, 50);

        jPanel4.add(jPanel19);
        jPanel19.setBounds(0, 0, 500, 50);

        TypeSalle.add(jPanel4);
        jPanel4.setBounds(10, 100, 500, 390);

        jPanel5.setBackground(new java.awt.Color(153, 153, 255));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, java.awt.Color.lightGray));
        jPanel5.setToolTipText("");
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel5.setLayout(null);

        BTModifier.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTModifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refrech.png"))); // NOI18N
        BTModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTModifierActionPerformed(evt);
            }
        });
        jPanel5.add(BTModifier);
        BTModifier.setBounds(620, 10, 180, 60);

        BTREchercher.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTREchercher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        BTREchercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTREchercherActionPerformed(evt);
            }
        });
        jPanel5.add(BTREchercher);
        BTREchercher.setBounds(380, 10, 180, 60);

        BtAjouter.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BtAjouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        BtAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAjouterActionPerformed(evt);
            }
        });
        jPanel5.add(BtAjouter);
        BtAjouter.setBounds(140, 10, 180, 60);

        BTSupprimer.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delet.png"))); // NOI18N
        BTSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSupprimerActionPerformed(evt);
            }
        });
        jPanel5.add(BTSupprimer);
        BTSupprimer.setBounds(860, 10, 180, 60);

        TypeSalle.add(jPanel5);
        jPanel5.setBounds(0, 0, 1210, 80);

        x.addTab("Type-salle", null, TypeSalle, "");

        Salle.setBackground(new java.awt.Color(204, 204, 255));
        Salle.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                SalleComponentShown(evt);
            }
        });
        Salle.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                SalleVetoableChange(evt);
            }
        });
        Salle.setLayout(null);

        jTable2.setBackground(new java.awt.Color(255, 255, 204));
        jTable2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Num_Salle", "Nombre Chaise", "Nombre Table", "Num_Type"
            }
        ));
        jTable2.setEnabled(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        Salle.add(jScrollPane3);
        jScrollPane3.setBounds(520, 100, 670, 390);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setLayout(null);

        TxtNomSalle.setEnabled(false);
        TxtNomSalle.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                TxtNomSalleComponentShown(evt);
            }
        });
        TxtNomSalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNomSalleActionPerformed(evt);
            }
        });
        jPanel1.add(TxtNomSalle);
        TxtNomSalle.setBounds(360, 76, 100, 30);
        jPanel1.add(TxtNumSalle);
        TxtNumSalle.setBounds(200, 100, 210, 40);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, ComboType, org.jdesktop.beansbinding.ELProperty.create("${selectedItem}"), ComboType, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        ComboType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboTypeItemStateChanged(evt);
            }
        });
        ComboType.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                ComboTypeHierarchyChanged(evt);
            }
        });
        ComboType.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                ComboTypeAncestorMoved(evt);
            }
        });
        ComboType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ComboTypeFocusGained(evt);
            }
        });
        ComboType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboTypeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ComboTypeMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ComboTypeMousePressed(evt);
            }
        });
        ComboType.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ComboTypeComponentShown(evt);
            }
        });
        ComboType.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                ComboTypeCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                ComboTypeInputMethodTextChanged(evt);
            }
        });
        ComboType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTypeActionPerformed(evt);
            }
        });
        ComboType.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ComboTypePropertyChange(evt);
            }
        });
        ComboType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComboTypeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ComboTypeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ComboTypeKeyTyped(evt);
            }
        });
        ComboType.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                ComboTypeVetoableChange(evt);
            }
        });
        jPanel1.add(ComboType);
        ComboType.setBounds(200, 150, 210, 40);
        jPanel1.add(TxtNbrTable);
        TxtNbrTable.setBounds(200, 200, 210, 41);
        jPanel1.add(TxtNbrChaise);
        TxtNbrChaise.setBounds(200, 260, 210, 41);

        BtVider1.setBackground(new java.awt.Color(204, 204, 204));
        BtVider1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BtVider1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vider.png"))); // NOI18N
        BtVider1.setText("Vider");
        BtVider1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtVider1ActionPerformed(evt);
            }
        });
        jPanel1.add(BtVider1);
        BtVider1.setBounds(140, 320, 180, 50);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nombre de chaise");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 200, 150, 50);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Nombre de table");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 270, 140, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Type Salle");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 160, 150, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Num Salle");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 100, 150, 40);

        jPanel18.setBackground(new java.awt.Color(204, 204, 255));
        jPanel18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel18.setLayout(null);

        jLabel29.setBackground(new java.awt.Color(204, 204, 255));
        jLabel29.setFont(new java.awt.Font("SimSun", 3, 24)); // NOI18N
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salle-(2).png"))); // NOI18N
        jLabel29.setText("GESTION DES SALLES");
        jPanel18.add(jLabel29);
        jLabel29.setBounds(90, 0, 320, 50);

        jPanel1.add(jPanel18);
        jPanel18.setBounds(0, 0, 500, 50);

        Salle.add(jPanel1);
        jPanel1.setBounds(10, 100, 500, 390);

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setLayout(null);

        BtAjouter1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BtAjouter1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        BtAjouter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAjouter1ActionPerformed(evt);
            }
        });
        jPanel3.add(BtAjouter1);
        BtAjouter1.setBounds(140, 10, 180, 60);

        BTREchercher1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTREchercher1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        BTREchercher1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTREchercher1ActionPerformed(evt);
            }
        });
        jPanel3.add(BTREchercher1);
        BTREchercher1.setBounds(380, 10, 180, 60);

        BTModifier1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTModifier1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refrech.png"))); // NOI18N
        BTModifier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTModifier1ActionPerformed(evt);
            }
        });
        jPanel3.add(BTModifier1);
        BTModifier1.setBounds(630, 10, 181, 60);

        BTSupprimer1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTSupprimer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delet.png"))); // NOI18N
        BTSupprimer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSupprimer1ActionPerformed(evt);
            }
        });
        jPanel3.add(BTSupprimer1);
        BTSupprimer1.setBounds(870, 10, 180, 60);

        Salle.add(jPanel3);
        jPanel3.setBounds(0, 0, 1210, 80);

        x.addTab("Salle", Salle);

        TypeSalle2.setBackground(new java.awt.Color(204, 204, 255));
        TypeSalle2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                TypeSalle2ComponentShown(evt);
            }
        });
        TypeSalle2.setLayout(null);

        jTable5.setBackground(new java.awt.Color(255, 255, 204));
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Code Matiere", "Nom Matiere", "ID Professeur"
            }
        ));
        jTable5.setEnabled(false);
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(2).setHeaderValue("ID Professeur");
        }

        TypeSalle2.add(jScrollPane7);
        jScrollPane7.setBounds(520, 100, 670, 390);

        jPanel8.setBackground(new java.awt.Color(153, 153, 255));
        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel8.setLayout(null);
        jPanel8.add(TxtNomMat);
        TxtNomMat.setBounds(210, 160, 220, 40);

        ComboIdProf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboIdProfMouseClicked(evt);
            }
        });
        ComboIdProf.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ComboIdProfComponentShown(evt);
            }
        });
        ComboIdProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboIdProfActionPerformed(evt);
            }
        });
        jPanel8.add(ComboIdProf);
        ComboIdProf.setBounds(210, 220, 220, 41);

        TxtNomProfesseur.setEnabled(false);
        TxtNomProfesseur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNomProfesseurActionPerformed(evt);
            }
        });
        jPanel8.add(TxtNomProfesseur);
        TxtNomProfesseur.setBounds(0, 340, 20, 40);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Nom Professeur");
        jPanel8.add(jLabel18);
        jLabel18.setBounds(70, 220, 140, 40);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Nom Matière");
        jPanel8.add(jLabel17);
        jLabel17.setBounds(70, 160, 130, 40);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Code Matière");
        jPanel8.add(jLabel16);
        jLabel16.setBounds(70, 100, 150, 40);

        TxtCodeMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCodeMatActionPerformed(evt);
            }
        });
        jPanel8.add(TxtCodeMat);
        TxtCodeMat.setBounds(210, 100, 220, 39);

        BtVider5.setBackground(new java.awt.Color(204, 204, 204));
        BtVider5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BtVider5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vider.png"))); // NOI18N
        BtVider5.setText("Vider");
        BtVider5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtVider5ActionPerformed(evt);
            }
        });
        jPanel8.add(BtVider5);
        BtVider5.setBounds(150, 290, 190, 50);

        jPanel20.setBackground(new java.awt.Color(204, 204, 255));
        jPanel20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel20.setLayout(null);

        jLabel52.setBackground(new java.awt.Color(204, 204, 255));
        jLabel52.setFont(new java.awt.Font("SimSun", 3, 24)); // NOI18N
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Matiere.png"))); // NOI18N
        jLabel52.setText("GESTION DES MATIERES");
        jPanel20.add(jLabel52);
        jLabel52.setBounds(70, 0, 350, 50);

        jPanel8.add(jPanel20);
        jPanel20.setBounds(0, 0, 500, 50);

        TypeSalle2.add(jPanel8);
        jPanel8.setBounds(10, 100, 500, 390);

        jPanel9.setBackground(new java.awt.Color(153, 153, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(990, 82));
        jPanel9.setLayout(null);

        BtAjouter5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BtAjouter5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        BtAjouter5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAjouter5ActionPerformed(evt);
            }
        });
        jPanel9.add(BtAjouter5);
        BtAjouter5.setBounds(140, 10, 180, 60);

        BTModifier5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTModifier5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refrech.png"))); // NOI18N
        BTModifier5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTModifier5ActionPerformed(evt);
            }
        });
        jPanel9.add(BTModifier5);
        BTModifier5.setBounds(630, 10, 180, 60);

        BTREchercher5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTREchercher5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        BTREchercher5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTREchercher5ActionPerformed(evt);
            }
        });
        jPanel9.add(BTREchercher5);
        BTREchercher5.setBounds(380, 10, 180, 60);

        BTSupprimer5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTSupprimer5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delet.png"))); // NOI18N
        BTSupprimer5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSupprimer5ActionPerformed(evt);
            }
        });
        jPanel9.add(BTSupprimer5);
        BTSupprimer5.setBounds(870, 10, 180, 60);

        TypeSalle2.add(jPanel9);
        jPanel9.setBounds(0, 0, 1210, 80);

        x.addTab("Matière", TypeSalle2);

        TypeSalle1.setBackground(new java.awt.Color(204, 204, 255));
        TypeSalle1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                TypeSalle1ComponentShown(evt);
            }
        });
        TypeSalle1.setLayout(null);

        jTable4.setBackground(new java.awt.Color(255, 255, 204));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id_Professeur", "Nom", "Prénom"
            }
        ));
        jTable4.setEnabled(false);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable4);

        TypeSalle1.add(jScrollPane5);
        jScrollPane5.setBounds(520, 100, 670, 390);

        jPanel6.setBackground(new java.awt.Color(153, 153, 255));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel6.setLayout(null);
        jPanel6.add(TxtIdProf);
        TxtIdProf.setBounds(210, 100, 210, 40);
        jPanel6.add(TxtNomProf);
        TxtNomProf.setBounds(210, 160, 210, 40);
        jPanel6.add(TxtPrenomProf);
        TxtPrenomProf.setBounds(210, 220, 210, 40);

        BtVider3.setBackground(new java.awt.Color(204, 204, 204));
        BtVider3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BtVider3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vider.png"))); // NOI18N
        BtVider3.setText("Vider");
        BtVider3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtVider3ActionPerformed(evt);
            }
        });
        jPanel6.add(BtVider3);
        BtVider3.setBounds(150, 290, 180, 50);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Prénom");
        jPanel6.add(jLabel11);
        jLabel11.setBounds(70, 220, 120, 40);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Nom");
        jPanel6.add(jLabel10);
        jLabel10.setBounds(70, 170, 120, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Id_Professeur");
        jPanel6.add(jLabel9);
        jLabel9.setBounds(70, 100, 140, 40);

        jPanel21.setBackground(new java.awt.Color(204, 204, 255));
        jPanel21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel21.setLayout(null);

        jLabel53.setBackground(new java.awt.Color(204, 204, 255));
        jLabel53.setFont(new java.awt.Font("SimSun", 3, 24)); // NOI18N
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prof.png"))); // NOI18N
        jLabel53.setText("GESTION DES PROFESSEURS");
        jPanel21.add(jLabel53);
        jLabel53.setBounds(60, 0, 380, 50);

        jPanel6.add(jPanel21);
        jPanel21.setBounds(0, 0, 500, 50);

        TypeSalle1.add(jPanel6);
        jPanel6.setBounds(10, 100, 500, 390);

        jPanel7.setBackground(new java.awt.Color(153, 153, 255));
        jPanel7.setLayout(null);

        BtAjouter3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BtAjouter3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        BtAjouter3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAjouter3ActionPerformed(evt);
            }
        });
        jPanel7.add(BtAjouter3);
        BtAjouter3.setBounds(140, 10, 180, 60);

        BTREchercher3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTREchercher3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        BTREchercher3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTREchercher3ActionPerformed(evt);
            }
        });
        jPanel7.add(BTREchercher3);
        BTREchercher3.setBounds(380, 10, 180, 60);

        BTSupprimer3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTSupprimer3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delet.png"))); // NOI18N
        BTSupprimer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSupprimer3ActionPerformed(evt);
            }
        });
        jPanel7.add(BTSupprimer3);
        BTSupprimer3.setBounds(870, 10, 180, 60);

        BTModifier3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTModifier3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refrech.png"))); // NOI18N
        BTModifier3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTModifier3ActionPerformed(evt);
            }
        });
        jPanel7.add(BTModifier3);
        BTModifier3.setBounds(630, 10, 180, 60);

        TypeSalle1.add(jPanel7);
        jPanel7.setBounds(0, 0, 1220, 80);

        x.addTab("Professeur", TypeSalle1);

        TypeSalle3.setBackground(new java.awt.Color(204, 204, 255));
        TypeSalle3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                TypeSalle3ComponentShown(evt);
            }
        });
        TypeSalle3.setLayout(null);

        jTable6.setBackground(new java.awt.Color(255, 255, 204));
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Num Fillière", "Nom Fillière"
            }
        ));
        jTable6.setEnabled(false);
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTable6);

        TypeSalle3.add(jScrollPane8);
        jScrollPane8.setBounds(520, 100, 670, 390);

        jPanel10.setBackground(new java.awt.Color(153, 153, 255));
        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel10.setLayout(null);
        jPanel10.add(TxtNumFill);
        TxtNumFill.setBounds(210, 100, 210, 42);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Num Fillière");
        jPanel10.add(jLabel19);
        jLabel19.setBounds(70, 100, 140, 40);
        jPanel10.add(TxtNomMat1);
        TxtNomMat1.setBounds(210, 170, 210, 41);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Nom Fillière");
        jPanel10.add(jLabel20);
        jLabel20.setBounds(70, 180, 120, 30);

        BtVider6.setBackground(new java.awt.Color(204, 204, 204));
        BtVider6.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BtVider6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vider.png"))); // NOI18N
        BtVider6.setText("Vider");
        BtVider6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtVider6ActionPerformed(evt);
            }
        });
        jPanel10.add(BtVider6);
        BtVider6.setBounds(150, 240, 170, 50);

        jPanel22.setBackground(new java.awt.Color(204, 204, 255));
        jPanel22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel22.setLayout(null);

        jLabel54.setBackground(new java.awt.Color(204, 204, 255));
        jLabel54.setFont(new java.awt.Font("SimSun", 3, 24)); // NOI18N
        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/filiere.png"))); // NOI18N
        jLabel54.setText("GESTION DES FILLIERES");
        jPanel22.add(jLabel54);
        jLabel54.setBounds(70, 0, 360, 50);

        jPanel10.add(jPanel22);
        jPanel22.setBounds(0, 0, 500, 50);

        TypeSalle3.add(jPanel10);
        jPanel10.setBounds(10, 100, 500, 390);

        jPanel11.setBackground(new java.awt.Color(153, 153, 255));
        jPanel11.setLayout(null);

        BtAjouter6.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BtAjouter6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        BtAjouter6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAjouter6ActionPerformed(evt);
            }
        });
        jPanel11.add(BtAjouter6);
        BtAjouter6.setBounds(140, 10, 180, 60);

        BTSupprimer6.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTSupprimer6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delet.png"))); // NOI18N
        BTSupprimer6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSupprimer6ActionPerformed(evt);
            }
        });
        jPanel11.add(BTSupprimer6);
        BTSupprimer6.setBounds(870, 10, 180, 60);

        BTModifier6.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTModifier6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refrech.png"))); // NOI18N
        BTModifier6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTModifier6ActionPerformed(evt);
            }
        });
        jPanel11.add(BTModifier6);
        BTModifier6.setBounds(630, 10, 180, 60);

        BTREchercher6.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTREchercher6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        BTREchercher6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTREchercher6ActionPerformed(evt);
            }
        });
        jPanel11.add(BTREchercher6);
        BTREchercher6.setBounds(380, 10, 180, 60);

        TypeSalle3.add(jPanel11);
        jPanel11.setBounds(0, 0, 1220, 80);

        x.addTab("Fillière", TypeSalle3);

        Salle1.setBackground(new java.awt.Color(204, 204, 255));
        Salle1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                Salle1ComponentShown(evt);
            }
        });
        Salle1.setLayout(null);

        jTable7.setBackground(new java.awt.Color(255, 255, 204));
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Num Groupe", "Nom Groupe", "Nombre Etudiant", "Num Fillière"
            }
        ));
        jTable7.setEnabled(false);
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable7);

        Salle1.add(jScrollPane4);
        jScrollPane4.setBounds(520, 100, 670, 390);

        jPanel12.setBackground(new java.awt.Color(153, 153, 255));
        jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel12.setLayout(null);
        jPanel12.add(TxtNumGroupe);
        TxtNumGroupe.setBounds(230, 100, 190, 30);
        jPanel12.add(TxtNomGroupe);
        TxtNomGroupe.setBounds(230, 150, 190, 30);
        jPanel12.add(TxtNbrEtudiant);
        TxtNbrEtudiant.setBounds(230, 200, 190, 30);

        ComboNumFill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboNumFillMouseClicked(evt);
            }
        });
        ComboNumFill.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ComboNumFillComponentShown(evt);
            }
        });
        ComboNumFill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNumFillActionPerformed(evt);
            }
        });
        jPanel12.add(ComboNumFill);
        ComboNumFill.setBounds(230, 250, 190, 30);

        TxtNomFilliere.setEnabled(false);
        jPanel12.add(TxtNomFilliere);
        TxtNomFilliere.setBounds(230, 290, 190, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Nom Fillière");
        jPanel12.add(jLabel7);
        jLabel7.setBounds(80, 260, 100, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Nombre Etudiant");
        jPanel12.add(jLabel8);
        jLabel8.setBounds(80, 200, 120, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Nom Groupe");
        jPanel12.add(jLabel13);
        jLabel13.setBounds(80, 150, 120, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Num Groupe");
        jPanel12.add(jLabel12);
        jLabel12.setBounds(80, 100, 120, 30);

        BtVider2.setBackground(new java.awt.Color(204, 204, 204));
        BtVider2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BtVider2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vider.png"))); // NOI18N
        BtVider2.setText("Vider");
        BtVider2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtVider2ActionPerformed(evt);
            }
        });
        jPanel12.add(BtVider2);
        BtVider2.setBounds(160, 300, 170, 50);

        jPanel23.setBackground(new java.awt.Color(204, 204, 255));
        jPanel23.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel23.setLayout(null);

        jLabel55.setBackground(new java.awt.Color(204, 204, 255));
        jLabel55.setFont(new java.awt.Font("SimSun", 3, 24)); // NOI18N
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/groupe-(2).png"))); // NOI18N
        jLabel55.setText("GESTION DES GROUPES");
        jPanel23.add(jLabel55);
        jLabel55.setBounds(80, 0, 340, 50);

        jPanel12.add(jPanel23);
        jPanel23.setBounds(0, 0, 500, 50);

        Salle1.add(jPanel12);
        jPanel12.setBounds(10, 100, 500, 390);

        jPanel13.setBackground(new java.awt.Color(153, 153, 255));
        jPanel13.setLayout(null);

        BtAjouter2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BtAjouter2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        BtAjouter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAjouter2ActionPerformed(evt);
            }
        });
        jPanel13.add(BtAjouter2);
        BtAjouter2.setBounds(140, 10, 180, 60);

        BTSupprimer2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTSupprimer2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delet.png"))); // NOI18N
        BTSupprimer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSupprimer2ActionPerformed(evt);
            }
        });
        jPanel13.add(BTSupprimer2);
        BTSupprimer2.setBounds(870, 10, 180, 60);

        BTModifier2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTModifier2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refrech.png"))); // NOI18N
        BTModifier2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTModifier2ActionPerformed(evt);
            }
        });
        jPanel13.add(BTModifier2);
        BTModifier2.setBounds(630, 10, 180, 60);

        BTREchercher2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTREchercher2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        BTREchercher2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTREchercher2ActionPerformed(evt);
            }
        });
        jPanel13.add(BTREchercher2);
        BTREchercher2.setBounds(380, 10, 180, 60);

        Salle1.add(jPanel13);
        jPanel13.setBounds(0, 0, 1210, 80);

        x.addTab("Groupe", Salle1);

        Salle2.setBackground(new java.awt.Color(204, 204, 255));
        Salle2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                Salle2ComponentShown(evt);
            }
        });
        Salle2.setLayout(null);

        jTable9.setBackground(new java.awt.Color(255, 255, 204));
        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Num Emploi", "Jour de Semaine", "Seance", "Numero Salle", "Code Matière", "Numero Groupe"
            }
        ));
        jTable9.setEnabled(false);
        jTable9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable9MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable9);

        Salle2.add(jScrollPane6);
        jScrollPane6.setBounds(520, 100, 670, 390);

        Salle3.setBackground(new java.awt.Color(204, 204, 255));
        Salle3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                Salle3ComponentShown(evt);
            }
        });
        Salle3.setLayout(null);

        BtAjouter7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BtAjouter7.setText("Ajouter");
        BtAjouter7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAjouter7ActionPerformed(evt);
            }
        });
        Salle3.add(BtAjouter7);
        BtAjouter7.setBounds(20, 0, 120, 50);

        BtVider7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BtVider7.setText("Vider");
        BtVider7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtVider7ActionPerformed(evt);
            }
        });
        Salle3.add(BtVider7);
        BtVider7.setBounds(160, 0, 110, 50);

        BTSupprimer7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTSupprimer7.setText("Supprimer");
        BTSupprimer7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSupprimer7ActionPerformed(evt);
            }
        });
        Salle3.add(BTSupprimer7);
        BTSupprimer7.setBounds(290, 0, 130, 50);

        BTModifier7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTModifier7.setText("Modifier");
        BTModifier7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTModifier7ActionPerformed(evt);
            }
        });
        Salle3.add(BTModifier7);
        BTModifier7.setBounds(430, 0, 120, 50);

        BTREchercher7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTREchercher7.setText("Rechercher");
        BTREchercher7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTREchercher7ActionPerformed(evt);
            }
        });
        Salle3.add(BTREchercher7);
        BTREchercher7.setBounds(560, 0, 130, 50);
        Salle3.add(TxtNumSalle2);
        TxtNumSalle2.setBounds(320, 80, 180, 30);
        Salle3.add(TxtNbrChaise2);
        TxtNbrChaise2.setBounds(320, 200, 180, 30);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Num Type");
        Salle3.add(jLabel23);
        jLabel23.setBounds(170, 125, 90, 20);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Nombre de chaise");
        Salle3.add(jLabel24);
        jLabel24.setBounds(170, 200, 110, 30);

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Num_Salle", "Nombre Chaise", "Nombre Table", "Num_Type"
            }
        ));
        jTable8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable8MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTable8);

        Salle3.add(jScrollPane9);
        jScrollPane9.setBounds(120, 270, 490, 130);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Num Salle");
        Salle3.add(jLabel25);
        jLabel25.setBounds(170, 80, 110, 30);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Nombre de table");
        Salle3.add(jLabel26);
        jLabel26.setBounds(170, 160, 110, 30);
        Salle3.add(TxtNbrTable2);
        TxtNbrTable2.setBounds(320, 160, 180, 30);

        ComboType2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboType2MouseClicked(evt);
            }
        });
        ComboType2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ComboType2ComponentShown(evt);
            }
        });
        ComboType2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboType2ActionPerformed(evt);
            }
        });
        Salle3.add(ComboType2);
        ComboType2.setBounds(320, 120, 180, 30);

        Salle2.add(Salle3);
        Salle3.setBounds(0, 0, 0, 0);

        jPanel14.setBackground(new java.awt.Color(153, 153, 255));
        jPanel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel14.setLayout(null);

        ComboNumGroupe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboNumGroupeMouseClicked(evt);
            }
        });
        ComboNumGroupe.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ComboNumGroupeComponentShown(evt);
            }
        });
        ComboNumGroupe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNumGroupeActionPerformed(evt);
            }
        });
        jPanel14.add(ComboNumGroupe);
        ComboNumGroupe.setBounds(240, 300, 200, 30);

        ComboCodeMat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboCodeMatMouseClicked(evt);
            }
        });
        ComboCodeMat.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ComboCodeMatComponentShown(evt);
            }
        });
        ComboCodeMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCodeMatActionPerformed(evt);
            }
        });
        jPanel14.add(ComboCodeMat);
        ComboCodeMat.setBounds(240, 260, 200, 30);

        TxtNomSalle2.setEnabled(false);
        jPanel14.add(TxtNomSalle2);
        TxtNomSalle2.setBounds(240, 220, 200, 30);

        ComboNumSalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboNumSalleMouseClicked(evt);
            }
        });
        ComboNumSalle.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ComboNumSalleComponentShown(evt);
            }
        });
        ComboNumSalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNumSalleActionPerformed(evt);
            }
        });
        jPanel14.add(ComboNumSalle);
        ComboNumSalle.setBounds(240, 190, 200, 30);
        jPanel14.add(TxtSeance);
        TxtSeance.setBounds(240, 150, 200, 30);
        jPanel14.add(TxtJourSem);
        TxtJourSem.setBounds(240, 110, 200, 30);
        jPanel14.add(TxtNumEmp);
        TxtNumEmp.setBounds(240, 70, 200, 30);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Num Emploi");
        jPanel14.add(jLabel21);
        jLabel21.setBounds(90, 70, 130, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Jour Semaine");
        jPanel14.add(jLabel14);
        jLabel14.setBounds(90, 120, 110, 20);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Seance");
        jPanel14.add(jLabel22);
        jLabel22.setBounds(90, 150, 130, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Num Salle");
        jPanel14.add(jLabel15);
        jLabel15.setBounds(90, 190, 130, 30);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Nom Matière");
        jPanel14.add(jLabel27);
        jLabel27.setBounds(90, 260, 130, 30);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Nom Groupe");
        jPanel14.add(jLabel28);
        jLabel28.setBounds(90, 300, 130, 30);

        BtVider4.setBackground(new java.awt.Color(204, 204, 204));
        BtVider4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BtVider4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vider.png"))); // NOI18N
        BtVider4.setText("Vider");
        BtVider4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtVider4ActionPerformed(evt);
            }
        });
        jPanel14.add(BtVider4);
        BtVider4.setBounds(160, 340, 170, 50);

        jPanel24.setBackground(new java.awt.Color(204, 204, 255));
        jPanel24.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel24.setLayout(null);

        jLabel56.setBackground(new java.awt.Color(204, 204, 255));
        jLabel56.setFont(new java.awt.Font("SimSun", 3, 24)); // NOI18N
        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emploi.png"))); // NOI18N
        jLabel56.setText("GESTION DES EMPLOIS");
        jPanel24.add(jLabel56);
        jLabel56.setBounds(80, 0, 320, 50);

        jPanel14.add(jPanel24);
        jPanel24.setBounds(0, 0, 500, 50);

        Salle2.add(jPanel14);
        jPanel14.setBounds(10, 100, 500, 390);

        jPanel15.setBackground(new java.awt.Color(153, 153, 255));
        jPanel15.setLayout(null);

        BtAjouter4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BtAjouter4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        BtAjouter4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAjouter4ActionPerformed(evt);
            }
        });
        jPanel15.add(BtAjouter4);
        BtAjouter4.setBounds(140, 10, 180, 60);

        BTSupprimer4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTSupprimer4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delet.png"))); // NOI18N
        BTSupprimer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSupprimer4ActionPerformed(evt);
            }
        });
        jPanel15.add(BTSupprimer4);
        BTSupprimer4.setBounds(870, 10, 180, 60);

        BTModifier4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTModifier4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refrech.png"))); // NOI18N
        BTModifier4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTModifier4ActionPerformed(evt);
            }
        });
        jPanel15.add(BTModifier4);
        BTModifier4.setBounds(630, 10, 180, 60);

        BTREchercher4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BTREchercher4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        BTREchercher4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTREchercher4ActionPerformed(evt);
            }
        });
        jPanel15.add(BTREchercher4);
        BTREchercher4.setBounds(380, 10, 180, 60);

        Salle2.add(jPanel15);
        jPanel15.setBounds(0, 0, 1210, 80);

        TxtNomGroupe2.setEnabled(false);
        Salle2.add(TxtNomGroupe2);
        TxtNomGroupe2.setBounds(530, 420, 200, 30);

        TxtNomMatiere.setEnabled(false);
        TxtNomMatiere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNomMatiereActionPerformed(evt);
            }
        });
        Salle2.add(TxtNomMatiere);
        TxtNomMatiere.setBounds(530, 350, 200, 30);

        x.addTab("Emplois", Salle2);

        TypeSalle4.setBackground(new java.awt.Color(204, 204, 255));
        TypeSalle4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
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
        t20.setBounds(920, 460, 270, 60);

        jLabel31.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel31.setForeground(java.awt.Color.darkGray);
        jLabel31.setText("Jeudi");
        TypeSalle4.add(jLabel31);
        jLabel31.setBounds(0, 390, 90, 30);

        jLabel32.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel32.setForeground(java.awt.Color.darkGray);
        jLabel32.setText("Mardi");
        TypeSalle4.add(jLabel32);
        jLabel32.setBounds(0, 240, 90, 30);

        jLabel33.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel33.setForeground(java.awt.Color.darkGray);
        jLabel33.setText("Vendredi");
        TypeSalle4.add(jLabel33);
        jLabel33.setBounds(0, 470, 90, 30);

        jLabel34.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel34.setForeground(java.awt.Color.darkGray);
        jLabel34.setText("Mercredi");
        TypeSalle4.add(jLabel34);
        jLabel34.setBounds(0, 310, 90, 30);

        jLabel35.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel35.setForeground(java.awt.Color.darkGray);
        jLabel35.setText("8-10");
        TypeSalle4.add(jLabel35);
        jLabel35.setBounds(200, 100, 90, 22);

        jLabel36.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel36.setForeground(java.awt.Color.darkGray);
        jLabel36.setText("10-12");
        TypeSalle4.add(jLabel36);
        jLabel36.setBounds(450, 100, 90, 22);

        jLabel37.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel37.setForeground(java.awt.Color.darkGray);
        jLabel37.setText("14-16");
        TypeSalle4.add(jLabel37);
        jLabel37.setBounds(750, 100, 90, 22);

        jLabel38.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel38.setForeground(java.awt.Color.darkGray);
        jLabel38.setText("16-18");
        TypeSalle4.add(jLabel38);
        jLabel38.setBounds(1010, 100, 90, 22);

        t1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t1.setDisabledTextColor(java.awt.Color.darkGray);
        t1.setEnabled(false);
        TypeSalle4.add(t1);
        t1.setBounds(90, 130, 270, 60);

        t2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t2.setDisabledTextColor(java.awt.Color.darkGray);
        t2.setEnabled(false);
        TypeSalle4.add(t2);
        t2.setBounds(360, 130, 270, 60);

        t3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t3.setDisabledTextColor(java.awt.Color.darkGray);
        t3.setEnabled(false);
        TypeSalle4.add(t3);
        t3.setBounds(650, 130, 270, 60);

        t4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t4.setDisabledTextColor(java.awt.Color.darkGray);
        t4.setEnabled(false);
        t4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t4ActionPerformed(evt);
            }
        });
        TypeSalle4.add(t4);
        t4.setBounds(920, 130, 270, 60);

        t5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t5.setDisabledTextColor(java.awt.Color.darkGray);
        t5.setEnabled(false);
        TypeSalle4.add(t5);
        t5.setBounds(90, 220, 270, 60);

        t6.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t6.setDisabledTextColor(java.awt.Color.darkGray);
        t6.setEnabled(false);
        TypeSalle4.add(t6);
        t6.setBounds(360, 220, 270, 60);

        t7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t7.setDisabledTextColor(java.awt.Color.darkGray);
        t7.setEnabled(false);
        TypeSalle4.add(t7);
        t7.setBounds(650, 220, 270, 60);

        t8.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t8.setDisabledTextColor(java.awt.Color.darkGray);
        t8.setEnabled(false);
        TypeSalle4.add(t8);
        t8.setBounds(920, 220, 270, 60);

        t9.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t9.setDisabledTextColor(java.awt.Color.darkGray);
        t9.setEnabled(false);
        TypeSalle4.add(t9);
        t9.setBounds(90, 300, 270, 60);

        t10.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t10.setDisabledTextColor(java.awt.Color.darkGray);
        t10.setEnabled(false);
        TypeSalle4.add(t10);
        t10.setBounds(360, 300, 270, 60);

        t11.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t11.setDisabledTextColor(java.awt.Color.darkGray);
        t11.setEnabled(false);
        TypeSalle4.add(t11);
        t11.setBounds(650, 300, 270, 60);

        t12.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t12.setDisabledTextColor(java.awt.Color.darkGray);
        t12.setEnabled(false);
        TypeSalle4.add(t12);
        t12.setBounds(920, 300, 270, 60);

        t13.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t13.setDisabledTextColor(java.awt.Color.darkGray);
        t13.setEnabled(false);
        TypeSalle4.add(t13);
        t13.setBounds(90, 380, 270, 60);

        t14.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t14.setDisabledTextColor(java.awt.Color.darkGray);
        t14.setEnabled(false);
        TypeSalle4.add(t14);
        t14.setBounds(360, 380, 270, 60);

        t15.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t15.setDisabledTextColor(java.awt.Color.darkGray);
        t15.setEnabled(false);
        TypeSalle4.add(t15);
        t15.setBounds(650, 380, 270, 60);

        t16.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t16.setDisabledTextColor(java.awt.Color.darkGray);
        t16.setEnabled(false);
        TypeSalle4.add(t16);
        t16.setBounds(920, 380, 270, 60);

        t17.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t17.setDisabledTextColor(java.awt.Color.darkGray);
        t17.setEnabled(false);
        TypeSalle4.add(t17);
        t17.setBounds(90, 460, 270, 60);

        t18.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t18.setDisabledTextColor(java.awt.Color.darkGray);
        t18.setEnabled(false);
        TypeSalle4.add(t18);
        t18.setBounds(360, 460, 270, 60);

        t19.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t19.setDisabledTextColor(java.awt.Color.darkGray);
        t19.setEnabled(false);
        TypeSalle4.add(t19);
        t19.setBounds(650, 460, 270, 60);

        jLabel48.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel48.setForeground(java.awt.Color.darkGray);
        jLabel48.setText("Lundi");
        TypeSalle4.add(jLabel48);
        jLabel48.setBounds(0, 150, 100, 30);

        jPanel16.setBackground(new java.awt.Color(153, 153, 255));
        jPanel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel16.setLayout(null);

        jLabel49.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel49.setText("Groupe :");
        jPanel16.add(jLabel49);
        jLabel49.setBounds(690, 20, 80, 30);

        jPanel16.add(comboGroupe);
        comboGroupe.setBounds(820, 20, 188, 30);

        comboFilliiere.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboFilliiereItemStateChanged(evt);
            }
        });
        jPanel16.add(comboFilliiere);
        comboFilliiere.setBounds(260, 20, 230, 40);

        jLabel30.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel30.setText("Fillière :");
        jPanel16.add(jLabel30);
        jLabel30.setBounds(160, 20, 90, 30);

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/404-200.png"))); // NOI18N
        jPanel16.add(jLabel58);
        jLabel58.setBounds(0, 0, 120, 80);

        TypeSalle4.add(jPanel16);
        jPanel16.setBounds(0, 0, 1210, 80);

        x.addTab("Emplois des fillières", TypeSalle4);

        TypeSalle5.setBackground(new java.awt.Color(204, 204, 255));
        TypeSalle5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        TypeSalle5.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                TypeSalle5ComponentShown(evt);
            }
        });
        TypeSalle5.setLayout(null);

        jLabel39.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel39.setForeground(java.awt.Color.darkGray);
        jLabel39.setText("Lundi");
        TypeSalle5.add(jLabel39);
        jLabel39.setBounds(0, 130, 90, 50);

        t21.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t21.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t21.setDisabledTextColor(java.awt.Color.darkGray);
        t21.setEnabled(false);
        TypeSalle5.add(t21);
        t21.setBounds(920, 450, 270, 60);

        jLabel40.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel40.setForeground(java.awt.Color.darkGray);
        jLabel40.setText("Jeudi");
        TypeSalle5.add(jLabel40);
        jLabel40.setBounds(0, 380, 90, 30);

        jLabel41.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel41.setForeground(java.awt.Color.darkGray);
        jLabel41.setText("Mardi");
        TypeSalle5.add(jLabel41);
        jLabel41.setBounds(0, 230, 90, 30);

        jLabel42.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel42.setForeground(java.awt.Color.darkGray);
        jLabel42.setText("Vendredi");
        TypeSalle5.add(jLabel42);
        jLabel42.setBounds(0, 460, 90, 30);

        jLabel43.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel43.setForeground(java.awt.Color.darkGray);
        jLabel43.setText("Mercredi");
        TypeSalle5.add(jLabel43);
        jLabel43.setBounds(0, 290, 90, 50);

        jLabel44.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel44.setForeground(java.awt.Color.darkGray);
        jLabel44.setText("8-10");
        TypeSalle5.add(jLabel44);
        jLabel44.setBounds(200, 80, 90, 40);

        jLabel45.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel45.setForeground(java.awt.Color.darkGray);
        jLabel45.setText("10-12");
        TypeSalle5.add(jLabel45);
        jLabel45.setBounds(450, 80, 90, 40);

        jLabel46.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel46.setForeground(java.awt.Color.darkGray);
        jLabel46.setText("14-16");
        TypeSalle5.add(jLabel46);
        jLabel46.setBounds(730, 80, 100, 40);

        jLabel47.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel47.setForeground(java.awt.Color.darkGray);
        jLabel47.setText("16-18");
        TypeSalle5.add(jLabel47);
        jLabel47.setBounds(1010, 80, 110, 40);

        t22.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t22.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t22.setDisabledTextColor(java.awt.Color.darkGray);
        t22.setEnabled(false);
        TypeSalle5.add(t22);
        t22.setBounds(650, 120, 270, 60);

        t23.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t23.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t23.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t23.setDisabledTextColor(java.awt.Color.darkGray);
        t23.setEnabled(false);
        TypeSalle5.add(t23);
        t23.setBounds(90, 120, 270, 60);

        t24.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t24.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t24.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t24.setDisabledTextColor(java.awt.Color.darkGray);
        t24.setEnabled(false);
        TypeSalle5.add(t24);
        t24.setBounds(360, 120, 270, 60);

        t25.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t25.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t25.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t25.setDisabledTextColor(java.awt.Color.darkGray);
        t25.setEnabled(false);
        TypeSalle5.add(t25);
        t25.setBounds(920, 120, 270, 60);

        t26.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t26.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t26.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t26.setDisabledTextColor(java.awt.Color.darkGray);
        t26.setEnabled(false);
        TypeSalle5.add(t26);
        t26.setBounds(90, 210, 270, 60);

        t27.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t27.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t27.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t27.setDisabledTextColor(java.awt.Color.darkGray);
        t27.setEnabled(false);
        TypeSalle5.add(t27);
        t27.setBounds(360, 210, 270, 60);

        t28.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t28.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t28.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t28.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t28.setDisabledTextColor(java.awt.Color.darkGray);
        t28.setEnabled(false);
        TypeSalle5.add(t28);
        t28.setBounds(650, 210, 270, 60);

        t29.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t29.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t29.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t29.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t29.setDisabledTextColor(java.awt.Color.darkGray);
        t29.setEnabled(false);
        TypeSalle5.add(t29);
        t29.setBounds(920, 210, 270, 60);

        t30.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t30.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t30.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t30.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t30.setDisabledTextColor(java.awt.Color.darkGray);
        t30.setEnabled(false);
        TypeSalle5.add(t30);
        t30.setBounds(90, 290, 270, 60);

        t31.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t31.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t31.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t31.setDisabledTextColor(java.awt.Color.darkGray);
        t31.setEnabled(false);
        TypeSalle5.add(t31);
        t31.setBounds(360, 290, 270, 60);

        t32.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t32.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t32.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t32.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t32.setDisabledTextColor(java.awt.Color.darkGray);
        t32.setEnabled(false);
        TypeSalle5.add(t32);
        t32.setBounds(650, 290, 270, 60);

        t33.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t33.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t33.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t33.setDisabledTextColor(java.awt.Color.darkGray);
        t33.setEnabled(false);
        TypeSalle5.add(t33);
        t33.setBounds(920, 290, 270, 60);

        t34.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t34.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t34.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t34.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t34.setDisabledTextColor(java.awt.Color.darkGray);
        t34.setEnabled(false);
        TypeSalle5.add(t34);
        t34.setBounds(90, 370, 270, 60);

        t35.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t35.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t35.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t35.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t35.setDisabledTextColor(java.awt.Color.darkGray);
        t35.setEnabled(false);
        TypeSalle5.add(t35);
        t35.setBounds(360, 370, 270, 60);

        t36.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t36.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t36.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t36.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t36.setDisabledTextColor(java.awt.Color.darkGray);
        t36.setEnabled(false);
        TypeSalle5.add(t36);
        t36.setBounds(650, 370, 270, 60);

        t37.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t37.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t37.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t37.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t37.setDisabledTextColor(java.awt.Color.darkGray);
        t37.setEnabled(false);
        TypeSalle5.add(t37);
        t37.setBounds(920, 370, 270, 60);

        t38.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t38.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t38.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t38.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t38.setDisabledTextColor(java.awt.Color.darkGray);
        t38.setEnabled(false);
        TypeSalle5.add(t38);
        t38.setBounds(90, 450, 270, 60);

        t39.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t39.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t39.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t39.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t39.setDisabledTextColor(java.awt.Color.darkGray);
        t39.setEnabled(false);
        TypeSalle5.add(t39);
        t39.setBounds(360, 450, 270, 60);

        t40.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        t40.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t40.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t40.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        t40.setDisabledTextColor(java.awt.Color.darkGray);
        t40.setEnabled(false);
        TypeSalle5.add(t40);
        t40.setBounds(650, 450, 270, 60);

        jPanel17.setBackground(new java.awt.Color(153, 153, 255));
        jPanel17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel17.setLayout(null);

        comboProfesseur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboProfesseurMouseClicked(evt);
            }
        });
        comboProfesseur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProfesseurActionPerformed(evt);
            }
        });
        jPanel17.add(comboProfesseur);
        comboProfesseur.setBounds(290, 20, 190, 40);

        jLabel50.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel50.setText("Nom Professeur :");
        jPanel17.add(jLabel50);
        jLabel50.setBounds(120, 20, 160, 40);

        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/404-200.png"))); // NOI18N
        jPanel17.add(jLabel59);
        jLabel59.setBounds(0, 0, 120, 80);

        TypeSalle5.add(jPanel17);
        jPanel17.setBounds(340, 0, 510, 80);

        x.addTab("Emplois des professeurs", TypeSalle5);

        getContentPane().add(x);
        x.setBounds(0, 0, 1290, 570);
        x.getAccessibleContext().setAccessibleName("");
        x.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(150, 110, 100, 70);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void xMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseClicked
    }//GEN-LAST:event_xMouseClicked

    private void TypeSalle1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_TypeSalle1ComponentShown
        professeur();
    }//GEN-LAST:event_TypeSalle1ComponentShown

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable4MouseClicked

    private void BTREchercher3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTREchercher3ActionPerformed
        try{
            String req="select * from professeur where id_prof=?";
            idprof=JOptionPane.showInputDialog("Entrer l'Id du professeur à chercher : ");
            if(idprof!=null){
            pst=cnx.prepareStatement(req) ;
            pst.setString(1, idprof);
            rs= pst.executeQuery();
            pst.clearParameters();
            while(rs.next())
            {
                TxtIdProf.setText(String.valueOf(rs.getInt(1)));
                TxtNomProf.setText(rs.getString(2));
                TxtPrenomProf.setText(rs.getString(3));

            }
            }
        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez Entrer le ID Prof valide","Erreur ",
         JOptionPane.ERROR_MESSAGE);   }
    }//GEN-LAST:event_BTREchercher3ActionPerformed

    private void BTModifier3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTModifier3ActionPerformed
        try{
            //  BTREchercherActionPerformed(evt);
            String req="update professeur set nom=?, prenom=? where id_prof=?";
            pst=cnx.prepareStatement(req);
            pst.setString(1, TxtNomProf.getText());
            pst.setString(2, TxtPrenomProf.getText());
            pst.setInt(3, Integer.parseInt(TxtIdProf.getText()));
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            professeur();

        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez entrer l'Id prof valide à modifier","Erreur ",
         JOptionPane.ERROR_MESSAGE);   }
    }//GEN-LAST:event_BTModifier3ActionPerformed

    private void BTSupprimer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSupprimer3ActionPerformed
        String req="delete from professeur where id_prof=?";
        try{

            pst=cnx.prepareStatement(req) ;
            pst.setInt(1, Integer.parseInt(TxtIdProf.getText()));
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            professeur();
        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez entrer l'Id prof valide à supprimer","Erreur ",
         JOptionPane.ERROR_MESSAGE);  }
    }//GEN-LAST:event_BTSupprimer3ActionPerformed

    private void BtVider3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtVider3ActionPerformed
        vider();
    }//GEN-LAST:event_BtVider3ActionPerformed

    private void BtAjouter3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAjouter3ActionPerformed
        try{
            String req="insert into professeur values(?,?,?)";
            pst=cnx.prepareStatement(req);
            pst.setInt(1, Integer.parseInt(TxtIdProf.getText()));
            pst.setString(2, TxtNomProf.getText());
            pst.setString(3, TxtPrenomProf.getText());
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            professeur();

        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuillez Saisir des données valides ou le Id Prof est déja attribué");   }
    }//GEN-LAST:event_BtAjouter3ActionPerformed

    private void SalleComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_SalleComponentShown
        salle();        
        TxtNomSalle.setVisible(false);
    }//GEN-LAST:event_SalleComponentShown

    private void ComboTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTypeActionPerformed
    }//GEN-LAST:event_ComboTypeActionPerformed

    private void ComboTypeComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ComboTypeComponentShown
    }//GEN-LAST:event_ComboTypeComponentShown

    private void ComboTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboTypeMouseClicked
 
    }//GEN-LAST:event_ComboTypeMouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

    }//GEN-LAST:event_jTable2MouseClicked

    private void BTREchercher1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTREchercher1ActionPerformed
        try{
            String numsalle;
            String req="select salle.*,descrip from salle,type_salle where salle.num_type=type_salle.num_type and salle.num_salle=?";
            numsalle=(String)JOptionPane.showInputDialog("Entrer le numéro de salle à chercher : ");
            if(numsalle != null) {
                pst=cnx.prepareStatement(req) ;
                pst.setString(1, numsalle);
                rs= pst.executeQuery();
                pst.clearParameters();
                while(rs.next())
                {

                    TxtNumSalle.setText(String.valueOf(rs.getInt(1)));
                    TxtNbrTable.setText(String.valueOf(rs.getInt(2)));
                    TxtNbrChaise.setText(String.valueOf(rs.getInt(3)));
                    for (int i = 0; i < ComboType.getItemCount(); i++) {
                        if (ComboType.getItemAt(i).equals(rs.getString(5))) {
                            ComboType.setSelectedIndex(i);
                            return;
                        }
                    }
                }
            }
        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez Entrer le N° de salle valide","Erreur ",
         JOptionPane.ERROR_MESSAGE);  }
    }//GEN-LAST:event_BTREchercher1ActionPerformed

    private void BTModifier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTModifier1ActionPerformed
        try{

            String req="update salle set nbrtable=?, nbrchaise=? where num_salle=?";
            pst=cnx.prepareStatement(req);
            pst.setInt(1, Integer.parseInt(TxtNbrTable.getText()));
            pst.setInt(2, Integer.parseInt(TxtNbrChaise.getText()));
            pst.setInt(3, Integer.parseInt(TxtNumSalle.getText()));
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            salle();

        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez entrer le numéro de salle valide à modifier","Erreur ",
         JOptionPane.ERROR_MESSAGE);  }
    }//GEN-LAST:event_BTModifier1ActionPerformed

    private void BTSupprimer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSupprimer1ActionPerformed
        String req="delete from salle where num_salle=?";
        try{

            pst=cnx.prepareStatement(req) ;
            pst.setInt(1, Integer.parseInt(TxtNumSalle.getText()));
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            salle();
        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez entrer le numéro de salle valide à supprimer","Erreur ",
         JOptionPane.ERROR_MESSAGE);   }
    }//GEN-LAST:event_BTSupprimer1ActionPerformed

    private void BtVider1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtVider1ActionPerformed
        vider();
    }//GEN-LAST:event_BtVider1ActionPerformed

    private void BtAjouter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAjouter1ActionPerformed
        try{
            String req="insert into salle values(?,?,?,?)";
            pst=cnx.prepareStatement(req);
            pst.setInt(1, Integer.parseInt(TxtNumSalle.getText()));
            pst.setInt(2, Integer.parseInt(TxtNbrTable.getText()));
            pst.setInt(3, Integer.parseInt(TxtNbrChaise.getText()));
            pst.setInt(4, Integer.parseInt(TxtNomSalle.getText()));
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            salle();

        }catch(Exception ex){JOptionPane.showMessageDialog(null,"Vérifier que les champs sont correctes","Erreur ",
         JOptionPane.ERROR_MESSAGE);  }
    }//GEN-LAST:event_BtAjouter1ActionPerformed

    private void TypeSalleComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_TypeSalleComponentShown
        type_salle();
    }//GEN-LAST:event_TypeSalleComponentShown

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void BTREchercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTREchercherActionPerformed

        try{
            String req="select * from Type_salle where num_type=?";
            numtype=JOptionPane.showInputDialog("Entrer le numéro de type_salle à chercher : ");
            if(numtype!=null){
            pst=cnx.prepareStatement(req) ;
            pst.setString(1, numtype);
            rs= pst.executeQuery();
            pst.clearParameters();
            while(rs.next())
            {
                TxtDescrip.setText(String.valueOf(rs.getInt(1)));
                TxtNumType.setText(rs.getString(2));

            }
            }
        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez Entrer le N° Type valide","Erreur ",
         JOptionPane.ERROR_MESSAGE);   }
    }//GEN-LAST:event_BTREchercherActionPerformed

    private void BTModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTModifierActionPerformed
        try{
            //  BTREchercherActionPerformed(evt);
            String req="update Type_salle set descrip=? where num_type=?";
            pst=cnx.prepareStatement(req);
            pst.setString(1, TxtNumType.getText());
            pst.setInt(2, Integer.parseInt(TxtDescrip.getText()));
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            type_salle();

        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez entrer le numéro de type valide à modifier","Erreur ",
         JOptionPane.ERROR_MESSAGE);   }
    }//GEN-LAST:event_BTModifierActionPerformed

    private void BTSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSupprimerActionPerformed
        String req="delete from type_salle where num_type=?";
        try{

            pst=cnx.prepareStatement(req) ;
            pst.setInt(1, Integer.parseInt(TxtDescrip.getText()));
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            type_salle();
            
        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez entrer le numéro de type valide à supprimer","Erreur ",
         JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_BTSupprimerActionPerformed

    private void BtViderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtViderActionPerformed
        vider();
    }//GEN-LAST:event_BtViderActionPerformed

    private void BtAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAjouterActionPerformed
        try{
            String req="insert into type_salle values(?,?)";
            pst=cnx.prepareStatement(req);
            pst.setInt(1, Integer.parseInt(TxtNumType.getText()));
            pst.setString(2, TxtDescrip.getText());
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            type_salle();
            
        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Vérifier que les champs sont correctes","Erreur ",
         JOptionPane.ERROR_MESSAGE);   }
    }//GEN-LAST:event_BtAjouterActionPerformed

    private void BtAjouter5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAjouter5ActionPerformed
        try{
            String req="insert into matiere values(?,?,?)";
            pst=cnx.prepareStatement(req);
            pst.setInt(1, Integer.parseInt(TxtCodeMat.getText()));
            pst.setString(2, TxtNomMat.getText());
            pst.setInt(3, Integer.parseInt(TxtNomProfesseur.getText()));
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            matiere();

        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez Entrer le code matière valide","Erreur ",
         JOptionPane.ERROR_MESSAGE);   }
    }//GEN-LAST:event_BtAjouter5ActionPerformed

    private void BtVider5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtVider5ActionPerformed
        vider();
    }//GEN-LAST:event_BtVider5ActionPerformed

    private void BTSupprimer5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSupprimer5ActionPerformed
        String req="delete from matiere where code_mat=?";
        try{
            pst=cnx.prepareStatement(req) ;
            pst.setInt(1, Integer.parseInt(TxtCodeMat.getText()));
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            matiere();

        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez entrer le code matière valide à supprimer","Erreur ",
        JOptionPane.ERROR_MESSAGE);   }
    }//GEN-LAST:event_BTSupprimer5ActionPerformed

    private void BTModifier5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTModifier5ActionPerformed
        try{

            String req="update matiere set nom_mat=?, id_prof=? where code_mat=?";
            pst=cnx.prepareStatement(req);
            pst.setString(1,TxtNomMat.getText());
            pst.setInt(2, Integer.parseInt(TxtNomProfesseur.getText()));
            pst.setInt(3, Integer.parseInt(TxtCodeMat.getText()));
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            matiere();


        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez entrer le code matière valide à modifier","Erreur ",
         JOptionPane.ERROR_MESSAGE);   }
    }//GEN-LAST:event_BTModifier5ActionPerformed

    private void BTREchercher5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTREchercher5ActionPerformed
        try{
            String req="select matiere.*,nom from matiere,professeur where matiere.id_prof=professeur.id_prof and code_mat=?";
            codemat=JOptionPane.showInputDialog("Entrer Le code matière à chercher : ");
            if(codemat!=null){
            pst=cnx.prepareStatement(req) ;
            pst.setString(1, codemat);
            rs= pst.executeQuery();
            pst.clearParameters();
            while(rs.next())
                {

                    TxtCodeMat.setText(String.valueOf(rs.getInt(1)));
                    TxtNomMat.setText(rs.getString(2));
                    //TxtNomProfesseur.setText(String.valueOf(rs.getInt(3)));
                    for (int i = 0; i < ComboIdProf.getItemCount(); i++) {
                        if (ComboIdProf.getItemAt(i).equals(rs.getString(4))) {
                            ComboIdProf.setSelectedIndex(i);
                            return;
                        }
                    }
                }
            }
        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez Entrer le code matière valide","Erreur ",
         JOptionPane.ERROR_MESSAGE);  }
    }//GEN-LAST:event_BTREchercher5ActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable5MouseClicked

    private void TypeSalle2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_TypeSalle2ComponentShown
        matiere();
        TxtNomProfesseur.setVisible(false);
    }//GEN-LAST:event_TypeSalle2ComponentShown

    private void ComboIdProfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboIdProfMouseClicked
    }//GEN-LAST:event_ComboIdProfMouseClicked

    private void ComboIdProfComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ComboIdProfComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboIdProfComponentShown

    private void ComboIdProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboIdProfActionPerformed
    }//GEN-LAST:event_ComboIdProfActionPerformed

    private void BtAjouter6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAjouter6ActionPerformed
        try{
            String req="insert into filliere values(?,?)";
            pst=cnx.prepareStatement(req);
            pst.setInt(1, Integer.parseInt(TxtNumFill.getText()));
            pst.setString(2, TxtNomMat1.getText());
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            filiere();

        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez Entrer le numéro de fillière valide","Erreur ",
         JOptionPane.ERROR_MESSAGE);   }
    }//GEN-LAST:event_BtAjouter6ActionPerformed

    private void BtVider6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtVider6ActionPerformed
        vider();
    }//GEN-LAST:event_BtVider6ActionPerformed

    private void BTSupprimer6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSupprimer6ActionPerformed
        String req="delete from filliere where num_filliere=?";
        try{

            pst=cnx.prepareStatement(req) ;
            pst.setInt(1, Integer.parseInt(TxtNumFill.getText()));
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            filiere();
        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez entrer le numéro de fillière valide à supprimer","Erreur ",
         JOptionPane.ERROR_MESSAGE);   }
    }//GEN-LAST:event_BTSupprimer6ActionPerformed

    private void BTModifier6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTModifier6ActionPerformed
        try{

            String req="update filliere set nom_filliere=? where num_filliere=?";
            pst=cnx.prepareStatement(req);
            pst.setString(1,TxtNomMat1.getText());
            pst.setInt(2, Integer.parseInt(TxtNumFill.getText()));
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            filiere();
        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez entrer le numéro de fillière valide à modifier","Erreur ",
         JOptionPane.ERROR_MESSAGE);   }
    }//GEN-LAST:event_BTModifier6ActionPerformed

    private void BTREchercher6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTREchercher6ActionPerformed
        try{
            String req="select * from filliere where num_filliere=?";
            numfilliere=JOptionPane.showInputDialog("Entrer Le numéro de fillière à chercher : ");
            if(numfilliere!=null){
            pst=cnx.prepareStatement(req) ;
            pst.setString(1, numfilliere);
            rs= pst.executeQuery();
            pst.clearParameters();
            while(rs.next())
            {
                TxtNumFill.setText(String.valueOf(rs.getInt(1)));
                TxtNomMat1.setText(rs.getString(2));

            }
            }
        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez Entrer le numéro de fillière valide","Erreur ",
         JOptionPane.ERROR_MESSAGE);   }
    }//GEN-LAST:event_BTREchercher6ActionPerformed

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable6MouseClicked

    private void TypeSalle3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_TypeSalle3ComponentShown
        filiere();
    }//GEN-LAST:event_TypeSalle3ComponentShown

    private void BtAjouter2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAjouter2ActionPerformed
        try{
            String req="insert into groupe values(?,?,?,?)";
            pst=cnx.prepareStatement(req);
            pst.setInt(1, Integer.parseInt(TxtNumGroupe.getText()));
            pst.setString(2,TxtNomGroupe.getText());
            pst.setInt(3, Integer.parseInt(TxtNbrEtudiant.getText()));
            pst.setInt(4, Integer.parseInt(TxtNomFilliere.getText()));
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            groupe();

        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez Entrer le numéro de groupe valide","Erreur ",
         JOptionPane.ERROR_MESSAGE);   }
    }//GEN-LAST:event_BtAjouter2ActionPerformed

    private void BtVider2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtVider2ActionPerformed
        vider();
    }//GEN-LAST:event_BtVider2ActionPerformed

    private void BTSupprimer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSupprimer2ActionPerformed
        String req="delete from groupe where num_groupe=?";
        try{

            pst=cnx.prepareStatement(req) ;
            pst.setInt(1, Integer.parseInt(TxtNumGroupe.getText()));
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            groupe();
        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez entrer le numéro de groupe valide à supprimer","Erreur ",
         JOptionPane.ERROR_MESSAGE);   }

    }//GEN-LAST:event_BTSupprimer2ActionPerformed

    private void BTModifier2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTModifier2ActionPerformed
        try{

            String req="update groupe set nom_groupe=?, nbr_etudiant=?, num_filliere=? where num_groupe=?";
            pst=cnx.prepareStatement(req);
            pst.setString(1,TxtNomGroupe.getText());
            pst.setInt(2, Integer.parseInt(TxtNbrEtudiant.getText()));
            pst.setInt(3, Integer.parseInt(TxtNomFilliere.getText()));
            pst.setInt(4, Integer.parseInt(TxtNumGroupe.getText()));
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            groupe();

        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez entrer le numéro de groupe valide à modifier","Erreur ",
         JOptionPane.ERROR_MESSAGE);   }
    }//GEN-LAST:event_BTModifier2ActionPerformed

    private void BTREchercher2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTREchercher2ActionPerformed
        try{
            String req="select groupe.*,nom_filliere from groupe,filliere where groupe.num_filliere=filliere.num_filliere and num_groupe=?";
            numgroupe=JOptionPane.showInputDialog("Entrer Le numéro du groupe à chercher : ");
            if(numgroupe!=null){
            pst=cnx.prepareStatement(req) ;
            pst.setString(1, numgroupe);
            rs= pst.executeQuery();
            pst.clearParameters();
            while(rs.next())
                {
                    TxtNumGroupe.setText(String.valueOf(rs.getInt(1)));
                    TxtNomGroupe.setText(rs.getString(2));
                    TxtNbrEtudiant.setText(String.valueOf(rs.getInt(3)));
                    
                    for (int i = 0; i < ComboNumFill.getItemCount(); i++) {
                        if (ComboNumFill.getItemAt(i).equals(rs.getString(5))) {
                            ComboNumFill.setSelectedIndex(i);
                            return;
                        }
                    }
                }
            }

        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez Entrer le numéro de groupe valide","Erreur ",
         JOptionPane.ERROR_MESSAGE);   }
    }//GEN-LAST:event_BTREchercher2ActionPerformed

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable7MouseClicked

    private void ComboNumFillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboNumFillMouseClicked
    }//GEN-LAST:event_ComboNumFillMouseClicked

    private void ComboNumFillComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ComboNumFillComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNumFillComponentShown

    private void ComboNumFillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNumFillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNumFillActionPerformed

    private void Salle1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_Salle1ComponentShown
        groupe();
        TxtNomFilliere.setVisible(false);
    }//GEN-LAST:event_Salle1ComponentShown

    private void BtAjouter4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAjouter4ActionPerformed
        try{
            String req="insert into emploi values(?,?,?,?,?,?)";
            pst=cnx.prepareStatement(req);
            pst.setInt(1, Integer.parseInt(TxtNumEmp.getText()));
            pst.setString(2,TxtJourSem.getText());
            pst.setInt(3, Integer.parseInt(TxtSeance.getText()));
            pst.setInt(4, Integer.parseInt(ComboNumSalle.getSelectedItem().toString()));
            pst.setInt(5, Integer.parseInt(TxtNomMatiere.getText()));
            pst.setInt(6, Integer.parseInt(TxtNomGroupe2.getText()));
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            emplois();

        }catch(Exception ex){
         ex.getMessage();   }
    }//GEN-LAST:event_BtAjouter4ActionPerformed

    private void BtVider4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtVider4ActionPerformed
        vider();
    }//GEN-LAST:event_BtVider4ActionPerformed

    private void BTSupprimer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSupprimer4ActionPerformed
        String req="delete from emploi where num_emp=?";
        try{
            pst=cnx.prepareStatement(req) ;
            pst.setInt(1, Integer.parseInt(TxtNumEmp.getText()));
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            emplois();
        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez Entrer le numéro d'emploi valide à modifier","Erreur ",
         JOptionPane.ERROR_MESSAGE);   }
    }//GEN-LAST:event_BTSupprimer4ActionPerformed

    private void BTModifier4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTModifier4ActionPerformed
        try{
            String req="update emploi set joursemaine=?, seance=? where num_emp=?";
            pst=cnx.prepareStatement(req);
            pst.setString(1,TxtJourSem.getText());
            pst.setInt(2, Integer.parseInt(TxtSeance.getText()));
            pst.setInt(3, Integer.parseInt(TxtNumEmp.getText()));
            pst.executeUpdate();
            pst.clearParameters();
            vider();
            emplois();

        }catch(Exception ex){JOptionPane.showMessageDialog(this, "Veuilez entrer le numéro d'emploi valide à supprimer","Erreur ",
         JOptionPane.ERROR_MESSAGE);   }
    }//GEN-LAST:event_BTModifier4ActionPerformed

    private void BTREchercher4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTREchercher4ActionPerformed
        try{                   
            String req="select emploi.*,nom_mat,nom_groupe\n" +
                        "from emploi,groupe,matiere\n" +
                        "where emploi.num_groupe=groupe.num_groupe\n" +
                        "and emploi.code_mat=matiere.code_mat\n" +
                        "and emploi.num_emp=?";
            numemploi=JOptionPane.showInputDialog("Entrer Le numéro d'emploi à chercher : ");
            if(numemploi!=null){
            pst=cnx.prepareStatement(req) ;
            pst.setString(1, numemploi);
            rs= pst.executeQuery();
            pst.clearParameters();
            while(rs.next())
                {   
                    //JOptionPane.showMessageDialog(this, "num groupe: " +String.valueOf(rs.getString(7)) + "  code mat: " + String.valueOf(rs.getString(8)));
                    TxtNumEmp.setText(String.valueOf(rs.getInt(1)));
                    TxtJourSem.setText(rs.getString(2));
                    TxtSeance.setText(String.valueOf(rs.getInt(3)));
                    TxtNomMatiere.setText(String.valueOf(rs.getInt(5)));
                    TxtNomGroupe2.setText(String.valueOf(rs.getInt(6)));
                    ComboNumSalle.setSelectedItem(String.valueOf(rs.getInt(4)));
                    //ComboCodeMat.setSelectedItem(String.valueOf(rs.getString(7)));
                    
                    
                    /*for (int j = 0; j < ComboNumGroupe.getItemCount(); j++) {
                            if (ComboNumGroupe.getItemAt(j).equals(String.valueOf(rs.getString(8))))
                            {
                                ComboNumGroupe.setSelectedIndex(j);
                                return;
                                
                            }
                            
                    }    
                    
                    /*for (int i = 0; i < ComboCodeMat.getItemCount(); i++) {
                            if (ComboCodeMat.getItemAt(i).equals(String.valueOf(rs.getString(7)))) {
                                ComboCodeMat.setSelectedIndex(i);break;
                            }
                        }*/
                }     
            }
        }catch(SQLException ex){  }
    }//GEN-LAST:event_BTREchercher4ActionPerformed

    private void jTable9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable9MouseClicked

    private void ComboNumGroupeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboNumGroupeMouseClicked
    }//GEN-LAST:event_ComboNumGroupeMouseClicked

    private void ComboNumGroupeComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ComboNumGroupeComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNumGroupeComponentShown

    private void ComboNumGroupeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNumGroupeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNumGroupeActionPerformed

    private void Salle2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_Salle2ComponentShown
        emplois();
        TxtNomMatiere.setVisible(true);
        TxtNomGroupe2.setVisible(true);
    }//GEN-LAST:event_Salle2ComponentShown

    private void BtAjouter7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAjouter7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtAjouter7ActionPerformed

    private void BtVider7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtVider7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtVider7ActionPerformed

    private void BTSupprimer7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSupprimer7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTSupprimer7ActionPerformed

    private void BTModifier7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTModifier7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTModifier7ActionPerformed

    private void BTREchercher7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTREchercher7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTREchercher7ActionPerformed

    private void jTable8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable8MouseClicked

    private void ComboType2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboType2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboType2MouseClicked

    private void ComboType2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ComboType2ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboType2ComponentShown

    private void ComboType2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboType2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboType2ActionPerformed

    private void Salle3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_Salle3ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_Salle3ComponentShown

    private void ComboNumSalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboNumSalleMouseClicked
    }//GEN-LAST:event_ComboNumSalleMouseClicked

    private void ComboNumSalleComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ComboNumSalleComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNumSalleComponentShown

    private void ComboNumSalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNumSalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNumSalleActionPerformed

    private void ComboCodeMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboCodeMatMouseClicked
    }//GEN-LAST:event_ComboCodeMatMouseClicked

    private void ComboCodeMatComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ComboCodeMatComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboCodeMatComponentShown

    private void ComboCodeMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCodeMatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboCodeMatActionPerformed

    private void ComboTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboTypeItemStateChanged
          
    }//GEN-LAST:event_ComboTypeItemStateChanged

    private void ComboTypePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ComboTypePropertyChange
    }//GEN-LAST:event_ComboTypePropertyChange

    private void ComboTypeAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ComboTypeAncestorMoved
        
    }//GEN-LAST:event_ComboTypeAncestorMoved

    private void TxtNomSalleComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_TxtNomSalleComponentShown
 
    }//GEN-LAST:event_TxtNomSalleComponentShown

    private void ComboTypeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_ComboTypeInputMethodTextChanged
    }//GEN-LAST:event_ComboTypeInputMethodTextChanged

    private void ComboTypeHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_ComboTypeHierarchyChanged
    }//GEN-LAST:event_ComboTypeHierarchyChanged

    private void ComboTypeCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_ComboTypeCaretPositionChanged
    }//GEN-LAST:event_ComboTypeCaretPositionChanged

    private void ComboTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboTypeKeyPressed
    }//GEN-LAST:event_ComboTypeKeyPressed

    private void ComboTypeVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_ComboTypeVetoableChange
    }//GEN-LAST:event_ComboTypeVetoableChange

    private void SalleVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_SalleVetoableChange
    }//GEN-LAST:event_SalleVetoableChange

    private void ComboTypeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ComboTypeFocusGained
    }//GEN-LAST:event_ComboTypeFocusGained

    private void TypeSalle4ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_TypeSalle4ComponentShown
        
    }//GEN-LAST:event_TypeSalle4ComponentShown

    private void ComboTypeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboTypeKeyReleased
    }//GEN-LAST:event_ComboTypeKeyReleased

    private void ComboTypeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboTypeKeyTyped
    }//GEN-LAST:event_ComboTypeKeyTyped
    private void ComboTypeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboTypeMouseEntered
  
    }//GEN-LAST:event_ComboTypeMouseEntered

    private void ComboTypeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboTypeMousePressed
    }//GEN-LAST:event_ComboTypeMousePressed

    private void TxtNomSalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNomSalleActionPerformed
        
    }//GEN-LAST:event_TxtNomSalleActionPerformed

    private void comboProfesseurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboProfesseurMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProfesseurMouseClicked

    private void comboProfesseurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProfesseurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProfesseurActionPerformed

    private void TypeSalle5ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_TypeSalle5ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_TypeSalle5ComponentShown

    private void TxtCodeMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCodeMatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCodeMatActionPerformed

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
    }//GEN-LAST:event_comboFilliiereItemStateChanged

    private void t4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t4ActionPerformed

    private void TxtNomProfesseurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNomProfesseurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNomProfesseurActionPerformed

    private void TxtNomMatiereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNomMatiereActionPerformed
    }//GEN-LAST:event_TxtNomMatiereActionPerformed
   
    /*public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
               
            }
        });
    }*/
     private void vider() {
       TxtDescrip.setText(null);
       TxtNumType.setText(null);
       TxtNumSalle.setText(null);
       TxtNbrTable.setText(null);
       TxtNbrChaise.setText(null);
       TxtIdProf.setText(null);
       TxtNomProf.setText(null);
       TxtPrenomProf.setText(null);
       TxtNumFill.setText(null);
       TxtNomMat1.setText(null);
       TxtCodeMat.setText(null);
       TxtNomMat.setText(null);
       TxtNumGroupe.setText(null);
       TxtNomGroupe.setText(null);
       TxtNbrEtudiant.setText(null);
       TxtNumEmp.setText(null);
       TxtJourSem.setText(null);
       TxtSeance.setText(null);
       TxtNomSalle.setText(null);
       TxtNomProfesseur.setText(null);
       TxtNomFilliere.setText(null);
       TxtNomSalle2.setText(null);
       TxtNomMatiere.setText(null);
       TxtNomGroupe2.setText(null);    
    }
    private void type_salle(){
         try{
            String req="select * from type_salle";
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            ArrayList<Object []> L=new ArrayList<Object[]>();
            while(rs.next())
            {  Object[] T=new Object[2];
                T[0]=rs.getInt(1);
                T[1]=rs.getString(2);
                L.add(T);
            }
            Object[][]Donnee=new Object[L.size()][2];
            int ligne=0;
            for(Object[] T : L)
            {
                Donnee[ligne][0]=T[0];
                Donnee[ligne][1]=T[1];

                ligne++;
            }
            String[]Entete=   new String[2];
            Entete[0]="Num Type";
            Entete[1]="Description";

            jTable1.setModel(new DefaultTableModel(Donnee,Entete));            
        }catch(Exception ex){JOptionPane.showMessageDialog(this, ex.getMessage());   }
    }                                        
    private void salle(){
        try{
            String req="select distinct * from salle";
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            ArrayList<Object []> L=new ArrayList<Object[]>();
            while(rs.next())
            {  Object[] T=new Object[4];
                T[0]=rs.getInt(1);
                T[1]=rs.getInt(2);
                T[2]=rs.getInt(3);
                T[3]=rs.getInt(4);
                L.add(T);
            }
            Object[][]Donnee=new Object[L.size()][4];
            int ligne=0;
            for(Object[] T : L)
            {
                Donnee[ligne][0]=T[0];
                Donnee[ligne][1]=T[1];
                Donnee[ligne][2]=T[2];
                Donnee[ligne][3]=T[3];

                ligne++;
            }
            String[]Entete=   new String[4];
            Entete[0]="Num Salle";
            Entete[1]="Nombre chaise";
            Entete[2]="Nombre table";
            Entete[3]="Num Type";

            jTable2.setModel(new DefaultTableModel(Donnee,Entete));
        }catch(Exception ex){JOptionPane.showMessageDialog(this, ex.getMessage());   }
    }
    private void professeur(){
        try{
            String req="select * from professeur";
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            ArrayList<Object []> L=new ArrayList<Object[]>();
            while(rs.next())
            {  Object[] T=new Object[3];
                T[0]=rs.getInt(1);
                T[1]=rs.getString(2);
                T[2]=rs.getString(3);
                L.add(T);
            }
            Object[][]Donnee=new Object[L.size()][3];
            int ligne=0;
            for(Object[] T : L)
            {
                Donnee[ligne][0]=T[0];
                Donnee[ligne][1]=T[1];
                Donnee[ligne][2]=T[2];
                ligne++;
            }
            String[]Entete=   new String[3];
            Entete[0]="ID Prof";
            Entete[1]="Nom";
            Entete[2]="Prénom";

            jTable4.setModel(new DefaultTableModel(Donnee,Entete));
        }catch(Exception ex){JOptionPane.showMessageDialog(this, ex.getMessage());   }
    }
    private void matiere(){
        try{
            String req="select * from matiere";
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            ArrayList<Object []> L=new ArrayList<Object[]>();
            while(rs.next())
            {  Object[] T=new Object[3];
                T[0]=rs.getInt(1);
                T[1]=rs.getString(2);
                T[2]=rs.getInt(3);
                L.add(T);
            }
            Object[][]Donnee=new Object[L.size()][3];
            int ligne=0;
            for(Object[] T : L)
            {
                Donnee[ligne][0]=T[0];
                Donnee[ligne][1]=T[1];
                Donnee[ligne][2]=T[2];
                ligne++;
            }
            String[]Entete=   new String[3];
            Entete[0]="Code Matiere";
            Entete[1]="Nom Matiere";
            Entete[2]="ID Professeur";

            jTable5.setModel(new DefaultTableModel(Donnee,Entete));
        }catch(Exception ex){JOptionPane.showMessageDialog(this, ex.getMessage());   }
    }
    private void filiere(){
        try{
            String req="select * from filliere";
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            ArrayList<Object []> L=new ArrayList<Object[]>();
            while(rs.next())
            {  Object[] T=new Object[2];
                T[0]=rs.getInt(1);
                T[1]=rs.getString(2);
                
                L.add(T);
            }
            Object[][]Donnee=new Object[L.size()][2];
            int ligne=0;
            for(Object[] T : L)
            {
                Donnee[ligne][0]=T[0];
                Donnee[ligne][1]=T[1];
                ligne++;
            }
            String[]Entete=   new String[2];
            Entete[0]="Num Fillière";
            Entete[1]="Nom Fillière";

            jTable6.setModel(new DefaultTableModel(Donnee,Entete));
        }catch(Exception ex){JOptionPane.showMessageDialog(this, ex.getMessage());   }
    }
    private void groupe(){
        try{
            String req="select * from groupe";
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            ArrayList<Object []> L=new ArrayList<Object[]>();
            while(rs.next())
            {  Object[] T=new Object[4];
                T[0]=rs.getInt(1);
                T[1]=rs.getString(2);
                T[2]=rs.getInt(3);
                T[3]=rs.getInt(4);
                L.add(T);
            }
            Object[][]Donnee=new Object[L.size()][4];
            int ligne=0;
            for(Object[] T : L)
            {
                Donnee[ligne][0]=T[0];
                Donnee[ligne][1]=T[1];
                Donnee[ligne][2]=T[2];
                Donnee[ligne][3]=T[3];
                ligne++;
            }
            String[]Entete=   new String[4];
            Entete[0]="Num Groupe";
            Entete[1]="Nom Groupe";
            Entete[2]="Nombre Etudiant";
            Entete[3]="Num Fillière";
            jTable7.setModel(new DefaultTableModel(Donnee,Entete));
        }catch(Exception ex){JOptionPane.showMessageDialog(this, ex.getMessage());   }
    }
    private void emplois(){
        try{
            String req="select * from emploi order by num_emp";
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            ArrayList<Object []> L=new ArrayList<Object[]>();
            while(rs.next())
            {  Object[] T=new Object[6];
                T[0]=rs.getInt(1);
                T[1]=rs.getString(2);
                T[2]=rs.getInt(3);
                T[3]=rs.getInt(4);
                T[4]=rs.getInt(5);
                T[5]=rs.getInt(6);
                L.add(T);
            }
            Object[][]Donnee=new Object[L.size()][6];
            int ligne=0;
            for(Object[] T : L)
            {
                Donnee[ligne][0]=T[0];
                Donnee[ligne][1]=T[1];
                Donnee[ligne][2]=T[2];
                Donnee[ligne][3]=T[3];
                Donnee[ligne][4]=T[4];
                Donnee[ligne][5]=T[5];
                
                ligne++;
            }
            String[]Entete=   new String[6];
            Entete[0]="Num Emploi";
            Entete[1]="Jour";
            Entete[2]="Seance";
            Entete[3]="Num Salle";
            Entete[4]="Code Matière" ;
            Entete[5]="Num Groupe";

            jTable9.setModel(new DefaultTableModel(Donnee,Entete));
        }catch(Exception ex){JOptionPane.showMessageDialog(this, ex.getMessage());   }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTModifier;
    private javax.swing.JButton BTModifier1;
    private javax.swing.JButton BTModifier2;
    private javax.swing.JButton BTModifier3;
    private javax.swing.JButton BTModifier4;
    private javax.swing.JButton BTModifier5;
    private javax.swing.JButton BTModifier6;
    private javax.swing.JButton BTModifier7;
    private javax.swing.JButton BTREchercher;
    private javax.swing.JButton BTREchercher1;
    private javax.swing.JButton BTREchercher2;
    private javax.swing.JButton BTREchercher3;
    private javax.swing.JButton BTREchercher4;
    private javax.swing.JButton BTREchercher5;
    private javax.swing.JButton BTREchercher6;
    private javax.swing.JButton BTREchercher7;
    private javax.swing.JButton BTSupprimer;
    private javax.swing.JButton BTSupprimer1;
    private javax.swing.JButton BTSupprimer2;
    private javax.swing.JButton BTSupprimer3;
    private javax.swing.JButton BTSupprimer4;
    private javax.swing.JButton BTSupprimer5;
    private javax.swing.JButton BTSupprimer6;
    private javax.swing.JButton BTSupprimer7;
    private javax.swing.JButton BtAjouter;
    private javax.swing.JButton BtAjouter1;
    private javax.swing.JButton BtAjouter2;
    private javax.swing.JButton BtAjouter3;
    private javax.swing.JButton BtAjouter4;
    private javax.swing.JButton BtAjouter5;
    private javax.swing.JButton BtAjouter6;
    private javax.swing.JButton BtAjouter7;
    private javax.swing.JButton BtVider;
    private javax.swing.JButton BtVider1;
    private javax.swing.JButton BtVider2;
    private javax.swing.JButton BtVider3;
    private javax.swing.JButton BtVider4;
    private javax.swing.JButton BtVider5;
    private javax.swing.JButton BtVider6;
    private javax.swing.JButton BtVider7;
    private javax.swing.JComboBox<String> ComboCodeMat;
    private javax.swing.JComboBox<String> ComboIdProf;
    private javax.swing.JComboBox<String> ComboNumFill;
    private javax.swing.JComboBox<String> ComboNumGroupe;
    private javax.swing.JComboBox<String> ComboNumSalle;
    private javax.swing.JComboBox<String> ComboType;
    private javax.swing.JComboBox<String> ComboType2;
    private javax.swing.JPanel Salle;
    private javax.swing.JPanel Salle1;
    private javax.swing.JPanel Salle2;
    private javax.swing.JPanel Salle3;
    private javax.swing.JTextField TxtCodeMat;
    private javax.swing.JTextField TxtDescrip;
    private javax.swing.JTextField TxtIdProf;
    private javax.swing.JTextField TxtJourSem;
    private javax.swing.JTextField TxtNbrChaise;
    private javax.swing.JTextField TxtNbrChaise2;
    private javax.swing.JTextField TxtNbrEtudiant;
    private javax.swing.JTextField TxtNbrTable;
    private javax.swing.JTextField TxtNbrTable2;
    private javax.swing.JTextField TxtNomFilliere;
    private javax.swing.JTextField TxtNomGroupe;
    private javax.swing.JTextField TxtNomGroupe2;
    private javax.swing.JTextField TxtNomMat;
    private javax.swing.JTextField TxtNomMat1;
    private javax.swing.JTextField TxtNomMatiere;
    private javax.swing.JTextField TxtNomProf;
    private javax.swing.JTextField TxtNomProfesseur;
    private javax.swing.JTextField TxtNomSalle;
    private javax.swing.JTextField TxtNomSalle2;
    private javax.swing.JTextField TxtNumEmp;
    private javax.swing.JTextField TxtNumFill;
    private javax.swing.JTextField TxtNumGroupe;
    private javax.swing.JTextField TxtNumSalle;
    private javax.swing.JTextField TxtNumSalle2;
    private javax.swing.JTextField TxtNumType;
    private javax.swing.JTextField TxtPrenomProf;
    private javax.swing.JTextField TxtSeance;
    private javax.swing.JPanel TypeSalle;
    private javax.swing.JPanel TypeSalle1;
    private javax.swing.JPanel TypeSalle2;
    private javax.swing.JPanel TypeSalle3;
    private javax.swing.JPanel TypeSalle4;
    private javax.swing.JPanel TypeSalle5;
    private java.awt.Choice comboFilliiere;
    private javax.swing.JComboBox<String> comboGroupe;
    private javax.swing.JComboBox<String> comboProfesseur;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
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
    private javax.swing.JTextField t21;
    private javax.swing.JTextField t22;
    private javax.swing.JTextField t23;
    private javax.swing.JTextField t24;
    private javax.swing.JTextField t25;
    private javax.swing.JTextField t26;
    private javax.swing.JTextField t27;
    private javax.swing.JTextField t28;
    private javax.swing.JTextField t29;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t30;
    private javax.swing.JTextField t31;
    private javax.swing.JTextField t32;
    private javax.swing.JTextField t33;
    private javax.swing.JTextField t34;
    private javax.swing.JTextField t35;
    private javax.swing.JTextField t36;
    private javax.swing.JTextField t37;
    private javax.swing.JTextField t38;
    private javax.swing.JTextField t39;
    private javax.swing.JTextField t4;
    private javax.swing.JTextField t40;
    private javax.swing.JTextField t5;
    private javax.swing.JTextField t6;
    private javax.swing.JTextField t7;
    private javax.swing.JTextField t8;
    private javax.swing.JTextField t9;
    private javax.swing.JTabbedPane x;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
