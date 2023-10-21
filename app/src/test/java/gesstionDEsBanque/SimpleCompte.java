package gesstionDEsBanque;

public class SimpleCompte extends Compte {
    private float decouvert;
    public SimpleCompte(float decouvert,String code,double solde,Status statut){
        super(code,statut,solde);
        this.decouvert=decouvert;
    }
    public float getDecouvert(){
        return this.decouvert;
    }
    public void retirer(int mt){
        if(mt<=solde+decouvert){
            if(mt>0){
                solde-=mt;
            }
        }
    }
    @Override
    public void setSolde(){

    }
    public String tostring(){
        return ("decouvert :"+decouvert);
    }
}
