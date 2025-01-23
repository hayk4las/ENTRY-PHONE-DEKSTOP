/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko_handphone.entity;

public class Barang {
    private String imei;
    private String merk_hp;
    private String storage;
    private Integer harga;

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMerk_hp() {
        return merk_hp;
    }

    public void setMerk_hp(String merk_hp) {
        this.merk_hp = merk_hp;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    
}
