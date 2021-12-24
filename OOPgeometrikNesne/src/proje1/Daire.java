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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Lenovo
 */
public class Daire extends GeometrikNesne {
    private double yaricap=1.0;

    public Daire(double yaricap, String etiket, Date tarih) {
        super(etiket, tarih);
        this.yaricap = yaricap;
    }

 
    public double getYaricap() {
        return yaricap;
    }

    public void setYaricap(double yaricap) {
        this.yaricap = yaricap;
    }
    

    public Daire() {
        yaricap=1.0;
    }

    public Daire(Daire copy) {
        super(copy);
        tarih=new Date(copy.tarih);
        yaricap=copy.yaricap;
    }
    

  
 

    @Override
    public String toString() {
        return "Daire{" + "yaricap=" + yaricap + '}';
    }
    
    

    @Override
    public double alanHesapla() {return Math.PI*yaricap*yaricap;}

    @Override
    public double cevreHesapla() {return 2*Math.PI*yaricap;}



    @Override
    public int compareTo(Object o) {
        Daire obje=(Daire) o;
        if (obje.yaricap<yaricap) {return 1;}
        else if(obje.yaricap==yaricap){return 0;}
        else{{return -1;}}

 
    }


}
