
package crudc030322107;


// IMPORT LIBRARY
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;
        

public class Form extends javax.swing.JFrame {

//===========================================================================================================================================
    
// CLEAR   
private void clear(){
    txNim.setText(null);
    txNama.setText(null);
    txProdi.setSelectedIndex(0);
    txAlamat.setText(null);
    txEmail.setText(null);
           
}

//LOAD DATA
private void LoadData(){
    
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("No");
    model.addColumn("NIM");
    model.addColumn("NAMA");
    model.addColumn("PRODI");
    model.addColumn("ALAMAT");
    model.addColumn("EMAIL");
    
    try{
        int no = 1;
        String sql = "select * from t_mhs";
        java.sql.Connection conn =(Connection)koneksi.BukaKoneksi();
        java.sql.Statement stm =conn.createStatement();
        java.sql.ResultSet res =stm.executeQuery(sql);
        
        while(res.next()){
            model.addRow(new Object[]{
                no++,
                res.getString(1),
                res.getString(2),
                res.getString(3),
                res.getString(4),
                res.getString(5)
            });
        }
        tblMahasiswa.setModel(model);
    }catch (SQLException e){
        
    }
    
}

// INSERT DATA
private void insert(){
    try{
            String sql = "insert into t_mhs Values ('"+txNim.getText()+
                    "','"+txNama.getText()+
                    "','"+txProdi.getSelectedItem()+
                    "','"+txAlamat.getText()+
                    "','"+txEmail.getText()+"')";
                java.sql.Connection conn = (Connection)koneksi.BukaKoneksi();
                java.sql.PreparedStatement pst =conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
                LoadData();
                clear();
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }

}

// EDIT DATA
private void edit(){
    try{
            String sql ="update t_mhs set nama='"+txNama.getText()+
                    "',prodi ='"+txProdi.getSelectedItem()+
                    "',alamat ='"+txAlamat.getText()+
                    "',email ='"+txEmail.getText()+
                    "'where nim ='"+txNim.getText()+"'";
            
            java.sql.Connection conn = (Connection)koneksi.BukaKoneksi();
            java.sql.PreparedStatement pst =conn.prepareStatement(sql);
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"Data Berhasil Diedit");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Edit Data Gagal" + e.getMessage());
        }
}

// DELETE DATA
private void delete(){
    try{
            String sql = "delete from t_mhs where nim = '"+txNim.getText()+"'";
            java.sql.Connection conn =(Connection)koneksi.BukaKoneksi();
            java.sql.PreparedStatement pst =conn.prepareStatement(sql);
            
            pst.execute();
            JOptionPane.showMessageDialog(this,"Data Berhasil Dihapus");
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
}

//===========================================================================================================================================

    public Form() {
        initComponents();
        LoadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMahasiswa = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txNim = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txProdi = new javax.swing.JComboBox<>();
        txAlamat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txNama = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txEmail = new javax.swing.JTextField();
        btClear = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btHapus = new javax.swing.JButton();
        btSimpan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblMahasiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIM", "NAMA", "PRODI", "ALAMAT", "EMAIL"
            }
        ));
        tblMahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMahasiswaMouseClicked(evt);
            }
        });
        tblMahasiswa.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tblMahasiswaComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(tblMahasiswa);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("INPUT DATA MAHASISWA ELEKTRO");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("NIM");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("NAMA");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("PRODI");

        txProdi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "D3 TEKNIK LISTRIK", "D3 ELEKTRONIKA", "D3 TEKNIK INFORMATIKA", "D4 SISTEM INFORMASI KOTA CERDAS", "D4 TEKNIK REKAYASA PEMBANGKIT ENERGI" }));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("ALAMAT");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("EMAIL");

        btClear.setText("CLEAR");
        btClear.setActionCommand("CLEAR");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        btEdit.setText("EDIT");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        btHapus.setText("HAPUS");
        btHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHapusActionPerformed(evt);
            }
        });

        btSimpan.setText("TAMBAH");
        btSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txNim)
                            .addComponent(txNama, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txProdi, 0, 330, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(56, 56, 56)
                        .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btClear))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(41, 41, 41)
                        .addComponent(txAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEdit)
                    .addComponent(btHapus)
                    .addComponent(btSimpan)
                    .addComponent(btClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblMahasiswaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblMahasiswaComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_tblMahasiswaComponentShown

    
//===========================================================================================================================================
    
    private void tblMahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMahasiswaMouseClicked
        // TODO add your handling code here:
        int baris = tblMahasiswa.rowAtPoint(evt.getPoint());
        String nim =tblMahasiswa.getValueAt(baris, 1).toString();
        String nama =tblMahasiswa.getValueAt(baris, 2).toString();
        String prodi =tblMahasiswa.getValueAt(baris, 3).toString();
        String alamat =tblMahasiswa.getValueAt(baris, 4).toString();
        String email =tblMahasiswa.getValueAt(baris, 5).toString();
        
        txNim.setText(nim);
        txNama.setText(nama);
        txProdi.setSelectedItem(prodi);
        txAlamat.setText(alamat);
        txEmail.setText(email);
    }//GEN-LAST:event_tblMahasiswaMouseClicked

    // ACTION CLEAR
    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        // TODO add your handling code here:
        clear();
        
    }//GEN-LAST:event_btClearActionPerformed

    //ACTION INSERT
    private void btSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanActionPerformed
        // TODO add your handling code here:
        insert();
        LoadData();
        clear();
    }//GEN-LAST:event_btSimpanActionPerformed

    // ACTION EDIT
    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // TODO add your handling code here:
        edit();
        LoadData();
        clear();
    }//GEN-LAST:event_btEditActionPerformed

    // ACTION DELETE
    private void btHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHapusActionPerformed
        // TODO add your handling code here:
        delete();
        LoadData();
        clear();
    }//GEN-LAST:event_btHapusActionPerformed

//===========================================================================================================================================
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClear;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btHapus;
    private javax.swing.JButton btSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMahasiswa;
    private javax.swing.JTextField txAlamat;
    private javax.swing.JTextField txEmail;
    private javax.swing.JTextField txNama;
    private javax.swing.JTextField txNim;
    private javax.swing.JComboBox<String> txProdi;
    // End of variables declaration//GEN-END:variables
}
