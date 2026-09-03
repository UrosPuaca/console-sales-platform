/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package komunikacija;

import java.io.Serializable;

/**
 *
 * @author puaca
 */
public enum Operacija implements Serializable{
    LOGIN,
    UCITAJ_GRADOVE, 
    UCITAJ_STR_SPREMA, 
    UCITAJ_KONZOLE, 
    UCITAJ_KUPCE, 
    UCITAJ_PRODAVCE, 
    OBRISI_KONZOLU, 
    OBRISI_STR_SPREMA, 
    OBRISI_KUPAC, 
    OBRISI_GRAD, 
    OBRISI_PRODAVCA, 
    DODAJ_GRAD, 
    DODAJ_PRODAVCA, 
    DODAJ_KONZOLU, 
    UBACI_STR_SPREMA, 
    DODAJ_KUPCA, 
    AZURIRAJ_KONZOLU, 
    AZURIRAJ_GRAD, 
    AZURIRAJ_STR_SPREMA, 
    AZURIRAJ_PRODAVCA, 
    AZURIRAJ_KUPCA, 
    UCITAJ_GRADOVE_PO_NAZIVU, 
    UCITAJ_STR_SPREMA_PO_NAZIVU, 
    UCITAJ_PRODAVCE_PO_PREZIMENU, 
    UCITAJ_KUPAC_PO_PREZIMENU, 
    UCITAJ_KONZOLE_PO_NAZIVU, 
    UCITAJ_RACUN, 
    DODAJ_RACUN, 
    VRATI_RACUN, 
    UCITAJ_RACUN_PO_PRODAVCU, 
    UCITAJ_RACUN_PO_KUPCU, 
    UCITAJ_KUPAC_PO_GRADU,
    AZURIRAJ_RACUN;
}
