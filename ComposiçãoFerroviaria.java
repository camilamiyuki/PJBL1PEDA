import java.io.Serializable;
public class ComposiçãoFerroviaria extends Deque implements Serializable{
    private ObjetoPersistente arqComp; //cria obj com o rquivo
    ComposiçãoFerroviaria(int N, String nomeArquivo){
        super(N); //herda o n do deque
        arqComp = new ObjetoPersistente(nomeArquivo);
        carregar();
    }
    private void salvar() {
        arqComp.salvar(this); //usa o metodo salvar do obj persistente pra salvar 
    }

    private void carregar() {
        ComposiçãoFerroviaria cf = (ComposiçãoFerroviaria) arqComp.carregar(); //cria objeto cf e copia os dados do deque
        if (cf != null) {
            this.front = cf.front; //posição do primeiro
            this.rear = cf.rear; //posicao do ultimo
            this.ptr = cf.ptr; //ponteiro de iteracao
            this.size = cf.size; 
            this.N = cf.N;
            this.data = cf.data; //vetor onde os objetos ficam
        }
    }
    public void inserirInicio(Vagao v) {
        addFirst(v); //insere vagao no comeco
        salvar(); //salva
    }

    public void inserirFim(Vagao v) { //vem da main
        addLast(v); //insere vagao no final
        salvar(); //salva
    }

    public Vagao removerInicio() {
        Vagao v = (Vagao) deleteFirst(); //recebe o vagao ja guardado no dec (pra deletar faz sentido)
        salvar();
        return v; //retorna pra mostrar pro usuario "tipo o pop"
    }

    public Vagao removerFim() {
        Vagao v = (Vagao) deleteLast(); //recebe o vagao ja guardado no dec (pra deletar faz sentido)
        salvar();
        return v; //retorna pra mostrar pro usuario "tipo o pop"
    }

    public void criarComposicaoPadrao() {
        while (!isEmpty()) {
            deleteLast();
        }
    
        addLast(new Locomotiva(20, 150, 2500));
    
        for (int i = 0; i < 50; i++) {
            addLast(new Passageiro(24, 40, 30));
        }
    
        for (int i = 0; i < 30; i++) {
            addLast(new Carga(17, 20));
        }
    
        salvar();
    }

    public int contarLocomotivas() {
        int total = 0;
        rewind();
        for (int i = 0; i < getSize(); i++) {
            if (next() instanceof Locomotiva) {
                total++;
            }
        }
        return total;
    }


    public int contarPassageiros() {
        int total = 0;
        rewind();
        for (int i = 0; i < getSize(); i++) {
            if (next() instanceof Passageiro) {
                total++;
            }
        }
        return total;
    }

    public int contarCarga() {
        int total = 0;
        rewind();
        for (int i = 0; i < getSize(); i++) {
            if (next() instanceof Carga) {
                total++;
            }
        }
        return total;
    }

    public double calcularPesoTotal() {
        double total = 0;
        rewind();
        for (int i = 0; i < getSize(); i++) {
            Vagao v = (Vagao) next();
            total += v.getPeso();
        }
        return total;
    }

    public int calcularTotalPassageiros() {
        int total = 0;
        rewind();
        for (int i = 0; i < getSize(); i++) {
            Object obj = next();
            if (obj instanceof Passageiro) {
                total += ((Passageiro) obj).getNumeroPassageiros();
            }
        }
        return total;
    }

    public double calcularCargaTotal() {
        double total = 0;
        rewind();
        for (int i = 0; i < getSize(); i++) {
            Object obj = next();
            if (obj instanceof Carga) {
                total += ((Carga) obj).getCarga();
            }
        }
        return total;
    }






}