//Sujeito: as plataformas de monitoramento, que coletam os dados dos rio 
//Observadores: as universidades que receberão as informações dos rios monitorados

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Subject {
  private List<Observer> observers = new ArrayList<Observer>();
  
  public void addObserver(Observer observer) {
    observers.add(observer);
  }
  
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }
  
  public void notifyObservers() {
    Iterator it = observers.iterator();
    while (it.hasNext()) {
      Observer obs= (Observer) it.next();
      obs.update(this); 
    }
  }
  
}

interface Observer {
  public void update(Subject s);
}

class PCD extends Subject {
    private String nomeRio;
    private double temperaturaAgua;
    private float pHAgua;
    private float nivelAgua;
    private float umidadeAr;

    public PCD(String nomeRio, double temperaturaAgua, float pHAgua, float nivelAgua, float umidadeAr) {
        this.nomeRio = nomeRio;
        this.temperaturaAgua = temperaturaAgua;
        this.pHAgua = pHAgua;
        this.nivelAgua = nivelAgua;
        this.umidadeAr = umidadeAr;
    }

    public String getNome(){
        return this.nomeRio;
    }

    public double getTemperatura(){
        return this.temperaturaAgua;
    }

    public float getPH(){
        return this.pHAgua;
    }

    public float getNivelAgua(){
        return this.nivelAgua;
    }

    public float getUmidadeAr(){
        return this.umidadeAr;
    }

    public void setTemperatura(double temperaturaAgua){
        if(this.temperaturaAgua == temperaturaAgua){
            return;
        }
        this.temperaturaAgua = temperaturaAgua;
        notifyObservers();
    }

    public void setPH(float pHAgua){
        if(this.pHAgua == pHAgua){
            return;
        }
        this.pHAgua = pHAgua;
        notifyObservers();
    }

    public void setNivelAgua(float nivelAgua){
        if(this.nivelAgua == nivelAgua){
            return;
        }
        this.nivelAgua = nivelAgua;
        notifyObservers();

    }

    public void setUmidadeAr(float umidadeAr){
        if(this.umidadeAr == umidadeAr){
            return;
        }
        this.umidadeAr = umidadeAr;
        notifyObservers();
    }

}

class Universidades implements Observer{
    private String nomeUniversidade;

    public Universidades(String nomeUniversidade) {
        this.nomeUniversidade = nomeUniversidade;
    }

    public void update(Subject s){

        double temperatura = ((PCD) s).getTemperatura();
        float pH = ((PCD) s).getPH();
        float nivelAgua = ((PCD) s).getNivelAgua();
        float umidadeAr = ((PCD) s).getUmidadeAr();
        System.out.println("Dados atualizados para a universidade " + this.nomeUniversidade + ":");
        System.out.println("Temperatura: " + temperatura);
        System.out.println("pH: " + pH);
        System.out.println("Nível da Água: " + nivelAgua);
        System.out.println("Umidade do Ar: " + umidadeAr);

    }
}

public class Main {
    public static void main(String[] args) {
        PCD dados1 = new PCD("Rio Amazonas", 21.3, 7.0f, 3.5f, 80.0f);
        PCD dados2 = new PCD("Rio Negro", 22.0, 6.8f, 2.0f, 75.0f);
        PCD dados3 = new PCD("Rio Tocantins", 25.0, 7.5f, 1.0f, 70.0f);
        Universidades uni1 = new Universidades("Universidade de São Paulo");
        Universidades uni2 = new Universidades("Universidade Federal do Rio de Janeiro");
        Universidades uni3 = new Universidades("Universidade de Brasília");

        dados1.addObserver(uni1);
        dados2.addObserver(uni2);
        dados3.addObserver(uni3);

        dados1.setTemperatura(26.0);
        dados2.setPH(7.2f);
        dados3.setUmidadeAr(70.1f);
    }
}