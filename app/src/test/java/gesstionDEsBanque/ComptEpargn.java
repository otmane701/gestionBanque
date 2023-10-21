package gesstionDEsBanque;

public class ComptEpargn extends Compte{
    private int taux=5;
    public ComptEpargn(int taux,double solde,int code,Status status){
        super(solde,status, String.valueOf(code));
        this.taux=taux;
    }

    public void calculInteret(float taux){
        solde*=(1+taux/100);
    }

    @Override
    public void setSolde() {
        super.setSolde((float) (super.getSolde()*(1+taux/100)));
    }
//    public String tostring(){
//        return (super.tostring()+"le taux est :"+taux);
//    }

//    public void versment(int i, ComptEpargn c2) {
//    }
}
