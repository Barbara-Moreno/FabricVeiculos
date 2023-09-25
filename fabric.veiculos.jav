// A classe abstrata Veículo com um construtor padrão e os métodos
abstract class Veiculo implements Cloneable {
    private String modelo;
    private String marca;
    private String cor;
    private int numeroRodas;

    public Veiculo(String modelo, String marca, String cor, int numeroRodas) {
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.numeroRodas = numeroRodas;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public void represent() {
        System.out.println("Modelo: " + modelo + ", Marca: " + marca + ", Cor: " + cor + ", Número de Rodas: " + numeroRodas);
    }
}

class Carro extends Veiculo {
    private int numeroPortas;

    public Carro(String modelo, String marca, String cor, int numeroRodas, int numeroPortas) {
        super(modelo, marca, cor, numeroRodas);
        this.numeroPortas = numeroPortas;
    }

    public void represent() {
        super.represent();
        System.out.println("Número de Portas: " + numeroPortas);
    }
}

class Caminhao extends Veiculo {
    private double capacidadeCarga;

    public Caminhao(String modelo, String marca, String cor, int numeroRodas, double capacidadeCarga) {
        super(modelo, marca, cor, numeroRodas);
        this.capacidadeCarga = capacidadeCarga;
    }

    public void represent() {
        super.represent();
        System.out.println("Capacidade de Carga: " + capacidadeCarga + " toneladas");
    }
}

class Aplicacao {
    public static void main(String[] args) {

        Carro carro = new Carro("Fusca", "Volkswagen", "Azul", 4, 2);
        Caminhao caminhao = new Caminhao("Scania", "Scania", "Vermelho", 6, 10);

        Veiculo[] veiculos = new Veiculo[6];
        veiculos[0] = carro;
        veiculos[1] = caminhao;
        veiculos[2] = (Veiculo) carro.clone();
        veiculos[3] = (Veiculo) caminhao.clone();
        veiculos[4] = (Veiculo) carro.clone();
        veiculos[5] = (Veiculo) caminhao.clone();

        Veiculo[] clones = clonarVeiculos(veiculos);

        for (Veiculo v : clones) {
            v.represent();
            System.out.println();
        }
    }

    public static Veiculo[] clonarVeiculos(Veiculo[] veiculos) {
        Veiculo[] clones = new Veiculo[veiculos.length];
        for (int i = 0; i < veiculos.length; i++) {
            clones[i] = (Veiculo) veiculos[i].clone();
        }
        return clones;
    }
}
