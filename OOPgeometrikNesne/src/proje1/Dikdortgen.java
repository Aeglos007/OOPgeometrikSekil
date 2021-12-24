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
public class Dikdortgen extends GeometrikNesne{
    private double en,boy;

    public double getEn() {
        return en;
    }

    public void setEn(double en) {
        this.en = en;
    }

    public double getBoy() {
        return boy;
    }

    public void setBoy(double boy) {
        this.boy = boy;
    }

        public Dikdortgen() {
            this.en = 1;
            this.boy = 1;
        }

    public Dikdortgen(double en, double boy, String etiket, Date tarih) {
        super(etiket, tarih);
        this.en = en;
        this.boy = boy;
    }
     public Dikdortgen(Dikdortgen copy){
         super(copy);
         this.boy= copy.boy;
         this.en=copy.en;
         tarih=new Date(copy.tarih);
     }
    

    @Override
    public double alanHesapla() {return en*boy;}

    @Override
    public double cevreHesapla() {return (en+boy)*2;}

    @Override
    public int compareTo(Object o) {
        Dikdortgen obje = (Dikdortgen) o;
        if (obje.alanHesapla()<this.alanHesapla()) {return 1;}
        else if(obje.alanHesapla()==this.alanHesapla()) {return 0;}
        else
        {{return -1;}}
                
   }

    @Override
    public String toString() {
        return "Dikdortgen{" + "en=" + en + ", boy=" + boy + '}';
    }
    
}

