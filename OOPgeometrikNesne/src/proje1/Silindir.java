/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje1;

/**
 *
 * @author Lenovo
 */
public class Silindir extends GeometrikNesne{
    private double uzunluk,yaricap;

   
    @Override
    public String toString() {
        return "Silindir{" + "uzunluk=" + uzunluk + ", yaricap=" + yaricap + '}';
    }

    public Silindir(double uzunluk, double yaricap, String etiket, Date tarih) {
        super(etiket, tarih);
        this.uzunluk = uzunluk;
        this.yaricap = yaricap;
    }

    public Silindir(Silindir copy) {
        super(copy);
        this.uzunluk = copy.uzunluk;
        this.yaricap = copy.yaricap;
        tarih=new Date(copy.tarih);
    }

    public Silindir() {
        uzunluk = 1.0;
        yaricap = 1.0;
    }

    

    public double getUzunluk() {
        return uzunluk;
    }

    public void setUzunluk(double uzunluk) {
        this.uzunluk = uzunluk;
    }

    public double getYaricap() {
        return yaricap;
    }

    public void setYaricap(double yaricap) {
        this.yaricap = yaricap;
    }
    


 
    @Override
    public double alanHesapla() {
 return 2 * yaricap *Math.PI *(yaricap + uzunluk); }


    @Override
    public double cevreHesapla() {
return (2 * 2 * yaricap * Math.PI) + (2 * uzunluk);}
    
public double hacimHesapla() {
    return Math.PI * yaricap *yaricap * uzunluk;
}
    
    @Override
    public int compareTo(Object o) {
Silindir obje = (Silindir) o;
        if (obje.hacimHesapla()<this.hacimHesapla()) {return 1;}
        else if(obje.hacimHesapla()==this.hacimHesapla()) {return 0;}
        else
        {{return -1;}}}
    
    
}
