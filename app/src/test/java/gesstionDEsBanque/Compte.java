package gesstionDEsBanque;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

public abstract class  Compte implements iCompte{
private String code;
protected double solde;
public static int nmbrcompt;
private Status status;
private ArrayList<Operatoin>Listoperation=new ArrayList<>();
public Compte(){

}
public Compte(double solde,Status status,String code){
    this.code=code;
    this.solde=solde;
    this.status=status;
    this.Listoperation=new ArrayList<>();
    //this.status=Status.CREATED;
}



//la methode retirer() :

    public String getCode(){
        return this.code;
    }
    //la methode consulterSolde() :
    public double getSolde(){
        return this.solde;
    }
    //la methode updatSolde() :
    public void setSolde(double solde){
        this.solde=solde;
    }
    //la methodes verser() :
    public void verser(double mt){
        if (mt>0){
            this.solde+=mt;
            Listoperation.add(new Retrait(new Date(),mt));
        }
    }
    public void retirer(double mt)throws Exception{
        if (mt > 0) {
            if (this instanceof ComptEpargn) {
                if (mt <= solde) {
                    solde -= mt;
                    Listoperation.add(new Retrait(new Date(), mt));
                } else {
                   // throw new soldinsiffusionException("Solde insuffisant.");
                    System.out.println("Solde insuffisant");
                }
            } else if (this instanceof SimpleCompte) {
                if (solde +((SimpleCompte) this).getDecouvert() >= mt) {
//                    System.out.println(((CompteCourant) this).getDecouvert());

                    solde -= mt;
                    Listoperation.add(new Retrait(new Date(), mt));
                } else {
                    System.out.println("Solde insuffisant");
                    //throw new soldinsiffusionException("Solde insuffisant");
                }
            }
        }//else throw new montantnegativeException("montant negative !");
        System.out.println("montant negative !");

    }
//la methode versement() :
    public void versment(int mt,Compte c)throws Exception{
    solde-=mt;
    c.verser(mt);
    }

    public void operation(){
    for (Operatoin Operation:Listoperation){
        System.out.println(" "+Operation.getNumero()+" "+Operation.getOperation()+" "+Operation.getMt());
    }
    }
    //la methode totalVersement() :
    public double totalVersement(){
        double T=0;
        for (Operatoin oper : Listoperation){
             T+=oper.getMt();
        }
        return T;
    }
    public double totalRetrait(){
        double T=0;
        for (Operatoin oper : Listoperation){
             T+=oper.getMt();
        }
        return T;
    }



//    public String stringSolde() {
//        return ("solde=" + solde);
//    }


//    public Status getStatus(){
//    return this.status;
//    }
//    public void setStatus(Status status){
//    this.status=status;
//    }
    public ArrayList<Operatoin> getListoperation(){
    return Listoperation;
    }
    public void setListoperation(ArrayList<Operatoin> Listoperation){
    this.Listoperation=Listoperation;
    }

    public abstract void setSolde();

    public void enregistrait(){
        try{
            PrintWriter out=new PrintWriter(new FileWriter("C:\\Users\\otmane\\AndroidStudioProjects\\Compte\\app\\src\\androidTest\\java\\compte\\out.txt"));

            for (Operatoin operatoin:Listoperation) {
                out.println(operatoin);
            }out.close();
        }catch (FileNotFoundException e){
            System.out.println("fichier introuvable");
        }catch(IOException e){
            e.getMessage();
        }
    }
//la list de operation :
//    public ArrayList op=new ArrayList();

}

