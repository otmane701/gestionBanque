package gesstionDEsBanque;

public class ComptePayent extends Compte{
    public ComptePayent(){
        super();
    }
    public void verser(int mt){
        this.solde+=mt;
    }
    public void retirer(int mt){
        if(mt<solde){
            if (mt>0){
                this.solde+=mt;
            }
        }
    }
    public String tostring(){
        return (super.tostring());
    }
}
