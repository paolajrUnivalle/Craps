package co.edu.univalle.poe.mvc.model;

public class Lanzamiento {
    private int valorDado1;
    private int valorDado2;

    public Lanzamiento(int valorDado1, int valorDado2){
        this.valorDado1 = valorDado1;
        this.valorDado2 = valorDado2;
    }

    public int calcularSuma(){
        return valorDado1 + valorDado2;
    }

    public int getDado1() {
        return valorDado1;
    }

    public int getDado2() {
        return valorDado2;
    }
}
