public class Passageiro extends Vagao {
    private int numeroPassageiros;

    public Passageiro(float comprimento, float peso, int numeroPassageiros) {
        super(comprimento, peso); //metodo construtor herdado da classe Vagao
        this.numeroPassageiros = numeroPassageiros;
    }

    public int getNumeroPassageiros() {
        return numeroPassageiros;
    }

    public void setNumeroPassageiros(int numeroPassageiros) {
        this.numeroPassageiros = numeroPassageiros;
    }

    @Override
    //public void print(){
    //    super.print();
    //    System.out.println("Número de Passageiros: " + numeroPassageiros);
    //}
}