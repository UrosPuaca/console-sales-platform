/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.racun;

import domen.Kupac;
import domen.Prodavac;
import domen.Racun;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author puaca
 */
public class UcitajRacunSO extends ApstraktnaGenerickaOperacija{
    List<Racun> racuni;

    @Override
    protected void preduslovi(Object objekat) throws Exception {

    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        if(kljuc==null){
            racuni = broker.getAll(new Racun(), " r JOIN kupac k ON r.kupac=k.idKupac "
                    + "JOIN prodavac p ON r.prodavac=p.idProdavac JOIN grad g ON k.grad=g.idGrad");
        }
       
        else if(kljuc.equals("prodavci")){
            Prodavac p = (Prodavac) objekat;
            racuni = broker.getAll(new Racun(), " r JOIN kupac k ON r.kupac=k.idKupac "
                    + "JOIN prodavac p ON r.prodavac=p.idProdavac JOIN grad g ON k.grad=g.idGrad "
                    + "WHERE r.prodavac="+p.getIdProdavac());
        }
        else if(kljuc.equals("kupci")){
            Kupac k = (Kupac) objekat;
            racuni = broker.getAll(new Racun(), " r JOIN kupac k ON r.kupac=k.idKupac "
                    + "JOIN prodavac p ON r.prodavac=p.idProdavac JOIN grad g ON k.grad=g.idGrad "
                    + "WHERE r.kupac="+k.getIdKupac());
        }
    }
    
    public List<Racun> getRacuni() {
        return racuni;
    }
    
}
