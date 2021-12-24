/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Deneme {
       static int sayac=0; //Genel nesne sayisi
       static int dsay=0; //Daire sayisi
       static int dksay=0; //Dikdortgen sayisi
       static int ssay=0; //Silindir sayisi
       static double cevreMax=0;
       static double cevreMin=9999.0;
       static double alanMin=9999.0;
       static double alanMax=0;
       static double hacimMax=0;
       static double hacimMin=9999.0;
       static double alanOrt;
       static double cevreOrt;
       static double hacimOrt;
       
       
       
    public static double alanOrtalama(GeometrikNesne[] o){
      double top=0;
        for (int i = 0; i <= sayac; i++) {
            top+=o[i].alanHesapla();
            
        }alanOrt=top/(sayac+1);
        return alanOrt;
    }
    
    
    public static double cevreOrtalama(GeometrikNesne[] o){
        double top=0;
        for (int i = 0; i <= sayac; i++) {
            top+=o[i].cevreHesapla();
            
        }cevreOrt=top/(sayac+1);
        return cevreOrt;
    }
    
    
    public static double hacimOrtalama(GeometrikNesne[] o){
    double top=0;
        for (int i = 0; i <= ssay; i++) {
            if(o==null){
                break;
            }
            top+=((Silindir) o[i]).hacimHesapla();
            
        }hacimOrt=top/(ssay+1);
        return hacimOrt;
    }
    
    
    
    public static void polymorphicYazdir(GeometrikNesne nesne){
        System.out.println("Nesne bilgileri:"
                +nesne+"/nAlani: "+nesne.alanHesapla()+"/nCevresi: "+nesne.cevreHesapla());
       if(nesne instanceof Silindir ){
           System.out.println("Nesne bilgileri:"+ nesne+"/nAlani: "+nesne.alanHesapla()+ "/nCevresi"+ ((Silindir) nesne).cevreHesapla()+"/nHacimi"+ ((Silindir) nesne).hacimHesapla());
       }
   
    }
     public static void karsilastir(GeometrikNesne o1,GeometrikNesne o2){
           switch (o1.compareTo(o2)) {
               case -1:
                   System.out.println("Ikincinin alani daha fazla");
                   ;
                   break;
               case 1:
                   System.out.println("Birincinin alani daha fazla");
                   break;
               default:
                   System.out.println("esitler");
                   break;
           }
             
         }
     public static double[] ucDegerBul(GeometrikNesne[] o){ //Burada max min alan,cevre,hacim ve alan-hacim-cevre ortalamalarini kaydediyoruz

         for (int i = 0; i <sayac ; i++) {
             if(cevreMax <= o[i].cevreHesapla()){
                 cevreMax=o[i].cevreHesapla();
             }
             if(cevreMin >= o[i].cevreHesapla()){
                 cevreMin=o[i].cevreHesapla();
             }
             if(alanMax<= o[i].alanHesapla()){
                 alanMax=o[i].alanHesapla();
             }
             if(alanMin >= o[i].alanHesapla()){
                 alanMin=o[i].alanHesapla();
             }
             if(o[i].getEtiket().contains("silindir")){
                if(hacimMax <=((Silindir) o[i]).hacimHesapla()){
                 hacimMax=((Silindir) o[i]).hacimHesapla();
             }
                if(hacimMin >=((Silindir) o[i]).hacimHesapla()){
                 hacimMin=((Silindir) o[i]).hacimHesapla();
             } 
             }
             
         }
           double[]  ucDegerler={cevreOrt,alanOrt,hacimOrt,cevreMin,cevreMax,alanMax,alanMin}; // max min alan,cevre,hacim ve alan-hacim-cevre ortalamalarini tuttugumuz yer
     
    return ucDegerler; }        
         
     
    public static void main(String[] args) {
        String satir=null; // Txt dosyamizda bir satir
        String[] parametre=null; //satirlari parcaladigimiz array
        double[] ucDegerler;
        GeometrikNesne[] gn=new GeometrikNesne[50]; //Geometrik nesnelerin hepsi burada tutuluyor
        GeometrikNesne[] dn=new GeometrikNesne[10]; //Daireler icin ozel dizi
        GeometrikNesne[] dkn=new GeometrikNesne[10]; //Dikdortgenler icin
        GeometrikNesne[] sn=new GeometrikNesne[10]; // Silindirler icin
       
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\proje1\\src\\proje1\\Yeni Metin Belgesi.txt"));
            try {
                while (br.ready()) { //satir var mi yok mu kontrolu
                    satir=br.readLine();
                parametre=satir.split(" ");
                    if(parametre[0].contains("daire")){  //etiketi kontrol ediyoruz ,kontrole gore atama yapiyoruz                     
                        GeometrikNesne dai1 = new Daire(Double.parseDouble(parametre[2]), parametre[1],
                                new Date(Integer.parseInt(parametre[4]), Integer.parseInt(parametre[5]),
                                Integer.parseInt(parametre[6])));
                        gn[sayac]=dai1; //Olusan daireyi hem tum GeoNesnelere attim hem de Daire dizisine attim
                        dn[dsay]=dai1;
                        sayac++;
                        dsay++;
                    }
                    
                    else if(parametre[0].contains("dikdortgen")){                       
                        GeometrikNesne dik = new Dikdortgen(Double.parseDouble(parametre[2]),Double.parseDouble(parametre[3]), parametre[1],
                                new Date(Integer.parseInt(parametre[5]), Integer.parseInt(parametre[6]),
                                Integer.parseInt(parametre[7])));
                        gn[sayac]=dik;
                        dkn[dksay]=dik;
                        dksay++;
                        sayac++;}
                    else if(parametre[0].contains("silindir")){
                        GeometrikNesne sil = new Silindir(Double.parseDouble(parametre[2]),Double.parseDouble(parametre[3]), parametre[1],
                                new Date(Integer.parseInt(parametre[5]), Integer.parseInt(parametre[6]),
                                        Integer.parseInt(parametre[7])));
                        gn[sayac]=sil;
                        sn[ssay]=sil;
                        ssay++;
                        sayac++;
                    } else {System.out.println("Okumada bir sorun var");                      
                    }
                       
                        
                                 
                    
                       
                }      
            } catch (IOException ex) {
                Logger.getLogger(Deneme.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Deneme.class.getName()).log(Level.SEVERE, null, ex);
        }
        ssay--;
        dsay--;
        dksay--;
        GeometrikNesne dai4 = new Daire((Daire)dn[dsay]);//Dire 4 u kopyaladim 
        gn[sayac]=dai4;//Diziye attim
        dn[++dsay]=dai4;
        sayac++;
        GeometrikNesne dik3= new Dikdortgen((Dikdortgen)dkn[dksay++]); //Dikdortgen kopya
        gn[sayac]=dik3;
        dkn[dksay]=dik3;
        sayac++;
        GeometrikNesne sil3 = new Silindir((Silindir)sn[ssay++]);
        gn[sayac]=sil3;
        sn[ssay]=sil3;
        karsilastir(dn[0], dn[dsay]); //Ilk daire ile son daire kiyasi
        karsilastir(dn[dsay-1], dn[dsay]); //Son daire ve ondan oncesi
        karsilastir(dkn[0], dkn[dksay]); //Son dikdorgen ve oncesi
        karsilastir(dkn[dksay-1], dkn[dksay]); //ilk dikdorgen ve son
        karsilastir(sn[0], sn[ssay]); //Ilk silindir ve son
        karsilastir(sn[ssay-1], sn[ssay]);//SON SILINDIR VE ONCESI
        polymorphicYazdir(sn[0]); // Rastgele nesne yazan bir metot. Silindir icin karismasin diye silindir dizisinden gonderdim
        System.out.println("Alan Ortalamasi: "+alanOrtalama(gn)); 
        System.out.println("Cevre Ortalamasi: "+cevreOrtalama(gn));
        System.out.println("Hacim Ortalamasi: "+hacimOrtalama(sn));   
       
        ucDegerler=ucDegerBul(gn);//Ekrana basilmasi istenen dizi
        String[] format ={"Cevre Ortalamasi:" ,"Alan Ortalamasi:  ","Hacim Ortalamasi: ","Min Cevre : ","Max Cevre:  ","Max Alan:  ","Min Alan "};
        for (int i = 0; i < 7; i++) {
            System.out.println(format[i]+ucDegerler[i]);
        }
        
        
    }
}
        
    
/*Daire dai1= new Daire(5.0,"daire1", new Date(10,01,2000)); cevreOrt,alanOrt,hacimOrt,cevreMin,cevreMax,alanMax,alanMin
    Daire dai2= new Daire(7.0,"daire2", new Date(8,03,2000));
    Daire dai3= new Daire(3.0,"daire2", new Date(5,04,2000));
    Dikdortgen dik1= new Dikdortgen(2.0, 3.0, "dikdortgen1", new Date(20,07,2000));
    Dikdortgen dik2= new Dikdortgen(4.0, 5.0, "dikdortgen2", new Date(28,07,2000));
    Silindir sil1= new Silindir(9.0,3.0, "silindir1", new Date(14,05,1999));
    Silindir sil2= new Silindir(5.0,3.0, "silindir2", new Date(15,04,1999));
    Dikdortgen dik3= new Dikdortgen(9.0, 8.0, "dikdortgen3", new Date(27,07,2000));
    Daire kopyaDai3= new Daire(dai3);
    Dikdortgen kopyaDik2= new Dikdortgen(dik2);
    Silindir kopyaSil3= new Silindir(sil2);
    
    GeometrikNesne[] nesneler = {dai1,dai2,dik1,dik2,dik3,sil1,sil2,kopyaDai3,kopyaSil3,kopyaDik2}; */
