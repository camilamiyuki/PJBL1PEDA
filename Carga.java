public class Carga extends Vagao {
    private double carga;

    public Carga(float comprimento, float peso) {
        super(comprimento, peso);
        this.carga = peso * 0.75; // carga é 75% do peso
    }

    public double getCapacidadeCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    @Override
    //public void print(){
    //    super.print();
    //    System.out.println("Capacidade de Carga: " + capacidadeCarga);
    //}
}