/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko_handphone.view;

/**
 *
 * @author Haykal Aditya
 */
import javax.swing.table.DefaultTableCellRenderer;
import java.text.NumberFormat;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import toko_handphone.DBConnection;
import toko_handphone.entity.Barang;
import toko_handphone.entity.Pelanggan;
import toko_handphone.entity.Penjualan;
import toko_handphone.entity.PenjualanDetail;
import toko_handphone.model.PenjualanDetailTableModel;
import toko_handphone.model.PenjualanModel;
import toko_handphone.model.PenjualanDetailModel;
public class PenjualanForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form PenjualanForm
     */
    private Connection connection;
    private PelangganData pelangganData;
    private BarangData barangData;
    private PenjualanDetailTableModel penjualanDetailTableModel;
    
    private PenjualanModel penjualanModel;
    private PenjualanDetailModel penjualanDetailModel;
    
    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) "> 
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel. 
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        */ 
        
        try{
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(ClassNotFoundException ex){
            java.util.logging.Logger.getLogger(PenjualanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }catch(InstantiationException ex){
            java.util.logging.Logger.getLogger(PenjualanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }catch(IllegalAccessException ex){
            java.util.logging.Logger.getLogger(PenjualanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }catch(javax.swing.UnsupportedLookAndFeelException ex){
            java.util.logging.Logger.getLogger(PenjualanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //</editor-fold> 
        /* Create and display the dialog */ 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                JFrame frame = new JFrame();
                frame.addWindowListener(new java.awt.event.WindowAdapter(){
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e){
                        System.exit(0);
                    }
                });
                
                PenjualanForm form = new PenjualanForm();
                frame.add(form);
                form.setVisible(true);
                
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
    }
    
    
    public PenjualanForm() {
        initComponents();
        
        connection = DBConnection.newInstant();
        pelangganData = new PelangganData(null, true);
        barangData = new BarangData(null, true);
        penjualanDetailTableModel = new PenjualanDetailTableModel(new ArrayList<PenjualanDetail>());
        
        tableRender();
        
        penjualanModel = new PenjualanModel(connection);
        penjualanDetailModel = new PenjualanDetailModel(connection);
    }

    private void tableRender(){
        tabelBarangRincian.setModel(penjualanDetailTableModel);
        //untuk pengaturan lebar kolom
        
        tabelBarangRincian.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabelBarangRincian.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabelBarangRincian.getColumnModel().getColumn(2).setPreferredWidth(40);
        tabelBarangRincian.getColumnModel().getColumn(3).setPreferredWidth(40);
        tabelBarangRincian.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer(){
            @Override
            public void setValue(Object value){
                NumberFormat formatter = NumberFormat.getInstance();
                setText((value == null) ? "0" : formatter.format(value));
                setHorizontalAlignment(RIGHT);
            }
        }); 
        tabelBarangRincian.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer(){
            @Override
            public void setValue(Object value){
                NumberFormat formatter = NumberFormat.getInstance();
                setText((value == null) ? "0" : formatter.format(value));
                setHorizontalAlignment(RIGHT);
            }
        });
    }
    
    
    private Integer hitungJumlah(){
        Integer qty = Integer.valueOf(String.valueOf(textBarangKuantiti.getValue()));
        Integer hargaSatuan = Integer.valueOf(String.valueOf(textBarangHarga.getValue()));
        
        Integer jumlah = qty * hargaSatuan;
        return jumlah;
    }
    
    public Integer hitungTotal(){
        int total = 0;
        for(PenjualanDetail detail : penjualanDetailTableModel.getRows()){
            total = total + (detail.getHarga() * detail.getKuantiti());
        }
        return total;
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
        jLabel2 = new javax.swing.JLabel();
        textPenjualanNomor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        textPenjualanTanggal = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        buttonPelangganFind = new javax.swing.JButton();
        textPelangganKode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textPelangganNama = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        textStorage = new javax.swing.JTextField();
        textBarangHarga = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        textImeiHp = new javax.swing.JTextField();
        textMerkHp = new javax.swing.JTextField();
        textBarangKuantiti = new javax.swing.JSpinner();
        buttonBarangFind = new javax.swing.JButton();
        buttonBarangSisipkan = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textBarangJumlah = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarangRincian = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        textPenjualanTotal = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        buttonPenjualanBaru = new javax.swing.JButton();
        buttonPenjualanSimpan = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Tanggal");

        textPenjualanNomor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPenjualanNomorActionPerformed(evt);
            }
        });

        jLabel1.setText("No. Transaksi");

        textPenjualanTanggal.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1731544848835L), null, null, java.util.Calendar.DAY_OF_WEEK_IN_MONTH));
        textPenjualanTanggal.setEditor(new javax.swing.JSpinner.DateEditor(textPenjualanTanggal, "dd/MM/yyyy"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textPenjualanNomor, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textPenjualanTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textPenjualanNomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(textPenjualanTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dijual Kepada"));
        jPanel2.setToolTipText("");

        buttonPelangganFind.setText("...");
        buttonPelangganFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPelangganFindActionPerformed(evt);
            }
        });

        textPelangganKode.setEditable(false);
        textPelangganKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPelangganKodeActionPerformed(evt);
            }
        });

        jLabel3.setText("Pelanggan");

        textPelangganNama.setEditable(false);
        textPelangganNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPelangganNamaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addComponent(textPelangganKode, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPelangganNama, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPelangganFind)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textPelangganKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPelangganNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPelangganFind))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Barang Yang Dijual"));

        textStorage.setEditable(false);
        textStorage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textStorageActionPerformed(evt);
            }
        });

        textBarangHarga.setEditable(false);
        textBarangHarga.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        textBarangHarga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textBarangHarga.setValue(0
        );
        textBarangHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBarangHargaActionPerformed(evt);
            }
        });

        jLabel4.setText("Merk Handphone");

        textImeiHp.setEditable(false);
        textImeiHp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textImeiHpActionPerformed(evt);
            }
        });

        textMerkHp.setEditable(false);
        textMerkHp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMerkHpActionPerformed(evt);
            }
        });

        textBarangKuantiti.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        textBarangKuantiti.setEditor(new javax.swing.JSpinner.NumberEditor(textBarangKuantiti, "0"));
        textBarangKuantiti.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                textBarangKuantitiStateChanged(evt);
            }
        });

        buttonBarangFind.setText("...");
        buttonBarangFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBarangFindActionPerformed(evt);
            }
        });

        buttonBarangSisipkan.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        buttonBarangSisipkan.setText("SISIPKAN");
        buttonBarangSisipkan.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                buttonBarangSisipkanStateChanged(evt);
            }
        });
        buttonBarangSisipkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBarangSisipkanActionPerformed(evt);
            }
        });

        jLabel6.setText("Kuantiti");

        jLabel5.setText("Storage");

        jLabel7.setText("Harga");

        jLabel8.setText("Jumlah");

        textBarangJumlah.setEditable(false);
        textBarangJumlah.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        textBarangJumlah.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textBarangJumlah.setValue(0
        );
        textBarangJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBarangJumlahActionPerformed(evt);
            }
        });

        jLabel11.setText("Imei");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textImeiHp, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(textMerkHp, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonBarangFind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textStorage, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(171, 171, 171)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textBarangKuantiti, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textBarangHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(textBarangJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonBarangSisipkan))
                    .addComponent(jLabel8))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textImeiHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textMerkHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBarangFind)
                    .addComponent(textStorage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textBarangKuantiti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textBarangHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textBarangJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBarangSisipkan))
                .addContainerGap())
        );

        jLabel9.setText("Rincian Barang Yang Dijual");

        tabelBarangRincian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelBarangRincian);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        textPenjualanTotal.setEditable(false);
        textPenjualanTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        textPenjualanTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textPenjualanTotal.setValue(0);
        textPenjualanTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPenjualanTotalActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("TOTAL BAYAR");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(textPenjualanTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textPenjualanTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        buttonPenjualanBaru.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        buttonPenjualanBaru.setText("BARU");
        buttonPenjualanBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPenjualanBaruActionPerformed(evt);
            }
        });

        buttonPenjualanSimpan.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        buttonPenjualanSimpan.setText("SIMPAN");
        buttonPenjualanSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPenjualanSimpanActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("CETAK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonPenjualanBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPenjualanSimpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPenjualanSimpan)
                    .addComponent(buttonPenjualanBaru)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textPelangganNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPelangganNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPelangganNamaActionPerformed

    private void textPelangganKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPelangganKodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPelangganKodeActionPerformed

    private void buttonPelangganFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPelangganFindActionPerformed
        // TODO add your handling code here:
        pelangganData.show();
        Pelanggan pelanggan = pelangganData.getSelectionRow();
        if (pelanggan != null){
            textPelangganKode.setText(pelanggan.getKode());
            textPelangganNama.setText(pelanggan.getNama());
        }    
    }//GEN-LAST:event_buttonPelangganFindActionPerformed

    private void textPenjualanNomorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPenjualanNomorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPenjualanNomorActionPerformed

    private void textImeiHpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textImeiHpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textImeiHpActionPerformed

    private void textMerkHpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMerkHpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMerkHpActionPerformed

    private void buttonBarangFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBarangFindActionPerformed
        // TODO add your handling code here:
        barangData.show();
        Barang barang = barangData.getSelectionRow();
        if (barang != null){
            textImeiHp.setText(barang.getImei());
            textMerkHp.setText(barang.getMerk_hp());
            textStorage.setText(barang.getStorage());
            textBarangKuantiti.setValue(1);
            
            textBarangHarga.setValue(barang.getHarga());
            textBarangJumlah.setValue(hitungJumlah());
        }    
    }//GEN-LAST:event_buttonBarangFindActionPerformed

    private void textStorageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textStorageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textStorageActionPerformed

    private void textBarangHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBarangHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBarangHargaActionPerformed

    private void buttonBarangSisipkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBarangSisipkanActionPerformed
        // TODO add your handling code here:
        Barang barang = new Barang();
        barang.setImei(textImeiHp.getText());
        barang.setMerk_hp(textMerkHp.getText());
        barang.setStorage(textStorage.getText());
        
        barang.setHarga(Integer.valueOf(String.valueOf(textBarangHarga.getValue())));

        PenjualanDetail penjualanDetail = new PenjualanDetail();
        penjualanDetail.setBarang(barang);

        penjualanDetail.setKuantiti(Integer.valueOf(String.valueOf(textBarangKuantiti.getValue())));
        penjualanDetail.setHarga(Integer.valueOf(String.valueOf(textBarangHarga.getValue())));

        boolean add = true;
        for (PenjualanDetail penjualanDetailOld : penjualanDetailTableModel.getRows()) {
            if (penjualanDetailOld.getBarang().getImei().equals(penjualanDetail.getBarang().getImei())) {
                add = false;
                Integer kuantiti = penjualanDetailOld.getKuantiti() + penjualanDetail.getKuantiti();
                penjualanDetailOld.setKuantiti(kuantiti);
                penjualanDetailOld.setHarga(penjualanDetail.getHarga());
                break;
            }
        }
        if (add) {
            penjualanDetailTableModel.getRows().add(penjualanDetail);
            penjualanDetailTableModel.fireTableDataChanged();
            textPenjualanTotal.setValue(hitungTotal());
        }

        textImeiHp.setText(null);
        textMerkHp.setText(null);
        textStorage.setText(null);
        textBarangKuantiti.setValue(1);
        textBarangHarga.setValue(0);
        textBarangJumlah.setValue(hitungJumlah());
    }//GEN-LAST:event_buttonBarangSisipkanActionPerformed

    private void textPenjualanTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPenjualanTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPenjualanTotalActionPerformed

    private void buttonPenjualanBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPenjualanBaruActionPerformed
        // TODO add your handling code here:                                                   

        textPenjualanTanggal.setValue(new Date());
        textPelangganKode.setText(null);
        textPelangganNama.setText(null);
        textImeiHp.setText(null);
        textMerkHp.setText(null);
        textStorage.setText(null);
        textBarangKuantiti.setValue(1);
        textBarangHarga.setValue(0);
        textBarangJumlah.setValue(hitungJumlah());
    
    penjualanDetailTableModel.setRows(new ArrayList<PenjualanDetail>());
    penjualanDetailTableModel.fireTableDataChanged();

    }//GEN-LAST:event_buttonPenjualanBaruActionPerformed

    private void buttonPenjualanSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPenjualanSimpanActionPerformed
        // TODO add your handling code here:
        try{
            connection.setAutoCommit(false);
            //insert penjualan
            Penjualan penjualan = new Penjualan();
            penjualan.setNomor(textPenjualanNomor.getText());
            penjualan.setTanggal((Date)textPenjualanTanggal.getValue());
            penjualan.setTotal(Integer.valueOf(String.valueOf(textPenjualanTotal.getValue())));
            
            Pelanggan pelanggan = new Pelanggan();
            pelanggan.setKode(textPelangganKode.getText());
            pelanggan.setNama(textPelangganNama.getText());
            
            penjualan.setPelanggan(pelanggan);
            penjualanModel.insert(penjualan);
            
            //insert penjualanDetail
            for(PenjualanDetail detail:penjualanDetailTableModel.getRows()){
                detail.setPenjualan(penjualan);
                penjualanDetailModel.insert(detail);
            }
            connection.commit();
            JOptionPane.showMessageDialog(this, "DATA BERHASIL DISIMPAN!", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(this, "DATA GAGAl DISIMPAN!", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
           ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonPenjualanSimpanActionPerformed

    private void textBarangKuantitiStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_textBarangKuantitiStateChanged
        // TODO add your handling code here:
        textBarangJumlah.setValue(hitungJumlah());
    }//GEN-LAST:event_textBarangKuantitiStateChanged

    private void buttonBarangSisipkanStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_buttonBarangSisipkanStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonBarangSisipkanStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        HashMap parameter = new HashMap();
        Vector<HashMap> penjualan = new Vector<HashMap>();
        int no = 0;

        for (PenjualanDetail penjualan_detail : penjualanDetailTableModel.getRows()) {
            HashMap detail = new HashMap();

            detail.put("penjualan_nomor", textPenjualanNomor.getText());
            detail.put("penjualan_tanggal", (Date) textPenjualanTanggal.getValue());
            detail.put("penjualan_total", Integer.valueOf(String.valueOf(textPenjualanTotal.getValue())));
            detail.put("penjualan_nama", textPelangganNama.getText());
            detail.put("no", ++no);
            detail.put("barang_kode", penjualan_detail.getBarang().getImei());
            detail.put("barang_nama", penjualan_detail.getBarang().getMerk_hp());
            detail.put("barang_kuantiti", penjualan_detail.getKuantiti());
            detail.put("barang_storage", penjualan_detail.getBarang().getStorage());
            detail.put("barang_harga", penjualan_detail.getHarga());
            detail.put("barang_jumlah", penjualan_detail.getHarga() * penjualan_detail.getKuantiti());
            penjualan.add(detail);
        }
        try {
            JRDataSource dataSource = new JRBeanCollectionDataSource(penjualan);
            InputStream file = getClass().getResourceAsStream("PenjualanNota.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(file, parameter, dataSource);
            JasperViewer.viewReport(jasperPrint, true);

        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textBarangJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBarangJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBarangJumlahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBarangFind;
    private javax.swing.JButton buttonBarangSisipkan;
    private javax.swing.JButton buttonPelangganFind;
    private javax.swing.JButton buttonPenjualanBaru;
    private javax.swing.JButton buttonPenjualanSimpan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelBarangRincian;
    private javax.swing.JFormattedTextField textBarangHarga;
    private javax.swing.JFormattedTextField textBarangJumlah;
    private javax.swing.JSpinner textBarangKuantiti;
    private javax.swing.JTextField textImeiHp;
    private javax.swing.JTextField textMerkHp;
    private javax.swing.JTextField textPelangganKode;
    private javax.swing.JTextField textPelangganNama;
    private javax.swing.JTextField textPenjualanNomor;
    private javax.swing.JSpinner textPenjualanTanggal;
    private javax.swing.JFormattedTextField textPenjualanTotal;
    private javax.swing.JTextField textStorage;
    // End of variables declaration//GEN-END:variables
}
