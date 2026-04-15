public class Carga extends Vagao {
    private float carga;

    public Carga(float comprimento, float peso) {
        super(comprimento, peso); //metodo construtor herdado da classe Vagao
    }

    public float getCapacidadeCarga() {
        return carga;
    }

    public void setCarga(float carga) {
        carga=peso*0.75 //carga é 75% do peso
        this.carga = carga;
    }

    @Override
    //public void print(){
    //    super.print();
    //    System.out.println("Capacidade de Carga: " + capacidadeCarga);
    //}
}