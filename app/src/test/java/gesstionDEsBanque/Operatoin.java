package gesstionDEsBanque;

import java.util.Date;

public class Operatoin {
    private  int numero;
    private Date dateOperation;
    private double mt;
    private  String operation;
    public Operatoin(int numero, Date dateOperation, double mt){
        this.numero=this.numero+1;
        this.dateOperation=dateOperation;
        this.mt=mt;
        this.operation=operation;
    }

    public Operatoin() {

    }

//    public Operatoin(double mt) {
//    }

    public int getNumero(){
        return this.numero;
    }
    public Date getDateOperation(){
        return this.dateOperation;
    }
    public double getMt(){
        return mt;
    }
    public String getOperation(){
        return this.operation;
    }
//    public void setNumero(int numero){
//        this.numero=numero;
//    }
//    public void setDateOperation(Date dateOperation){
//         this.dateOperation=dateOperation;
//    }
//    public void setMt(double mt){
//         this.mt=mt;
//    }
//    public void getOperation(String operation){
//        this.operation=operation;
//    }

}
