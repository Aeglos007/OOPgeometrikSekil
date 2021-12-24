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
public abstract class GeometrikNesne implements Comparable {
    private String etiket;
    public Date tarih;
    
    public GeometrikNesne(){
        tarih=new Date();
    }
    public GeometrikNesne(String etiket, Date tarih){
        this.etiket=etiket;
        this.tarih=new Date(tarih);
    }
    public GeometrikNesne(GeometrikNesne copy){
        if(copy==null){
            System.out.println("HATA");
            System.exit(0);
        }
        etiket= copy.getEtiket();
        tarih=new Date(copy.getTarih());
        
    }

    @Override
    public String toString() {
        return "GeometrikNesne{" + "etiket=" + etiket + ", tarih=" + tarih + '}';
    }

    
    

    public String getEtiket() {
        
        return etiket;
    }

    public Date getTarih() {
        return new Date(tarih);
    }

    public void setTarih(Date tarih) {
       
        this.tarih = new Date(tarih);;
        
    }

    public void setEtiket(String etiket) {
        this.etiket = etiket;
    } 
   public abstract double alanHesapla();
   public abstract double cevreHesapla();
    @Override
   public abstract int compareTo(Object o);
        
    
   
   
   
}

