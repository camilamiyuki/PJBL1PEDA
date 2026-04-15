public class Locomotiva extends Vagao {
    private float potencia;

    public Locomotiva(float comprimento, float peso, float potencia) {
        super(comprimento, peso); //metodo construtor herdado da classe Vagao
        this.potencia = potencia;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }
    
    @Override
    //public void print(){
    //    super.print();
    //    System.out.println("Potência: " + potencia);
    //}
}