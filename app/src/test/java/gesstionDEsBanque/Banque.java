package gesstionDEsBanque;

import java.util.Hashtable;
import java.util.Map;

public class Banque {
    private Map<String,Compte> comptes;
    public Banque(){
        this.comptes=new Hashtable<>();
    }

    public int Indicecompte(    String code) {
        for (int i = 0; i < comptes.size(); i++) {
            if (comptes.containsValue(code)) {
                return i;
            }
            }
        return -1;

    }
    public void ajouter(Compte c)throws Exception{
        if (!comptes.containsKey(c.getCode())){
           comptes.put(c.getCode(),c);
        }else throw new Exception("se compte est dija cres sur la boutique");
    }
public void afficher(){
        System.out.println(comptes);
}
public int nombreDescomptes(){
        int count=0;
        for (Compte c:comptes.values()){
            if(c instanceof SimpleCompte){
                count++;
            }
        }return count;
}

}
