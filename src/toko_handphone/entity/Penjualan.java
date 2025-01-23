/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko_handphone.entity;

import java.util.Date;
/**
 *
 * @author Haykal Aditya
 */
public class Penjualan {
    private String nomor;
    private Date tanggal;
    private Integer total;
    private Pelanggan pelanggan;
    
    public String getNomor() {
        return nomor;
    }
    
    public void setNomor(String nomor){
        this.nomor = nomor;
    }

    public Date getTanggal(){
        return tanggal;
    }
    
    public void setTanggal(Date tanggal){
        this.tanggal = tanggal;
    }
    
    public Integer getTotal(){
        return total;
    }
    
    public void setTotal(Integer total){
        this.total = total;
    }
    
    public Pelanggan getPelaggan(){
        return pelanggan;
    }
    
    public void setPelanggan(Pelanggan pelanggan){
        this.pelanggan = pelanggan;
    }
    
}
