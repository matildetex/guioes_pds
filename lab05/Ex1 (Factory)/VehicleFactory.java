public class VehicleFactory{

    public static Veiculo createMotociclo(String matricula, String marca, String modelo, int potencia, String cavalos) {
        return new Motociclo(matricula, marca, modelo, potencia ,cavalos);
    }

    public static Veiculo createAutomovelLigeiro(String matricula, String marca, String modelo, int potencia, String numeroSerie,
    int capacidadeBagageira) {
        return new AutomovelLigeiro(matricula, marca, modelo, potencia, numeroSerie, capacidadeBagageira);
    }

    public static Veiculo createTaxi(String matricula, String marca, String modelo, int potencia, String numeroSerie, int capacidadeBagageira,
    String numeroLicenca) {
        return new Taxi(matricula, marca,modelo, potencia, numeroSerie, capacidadeBagageira, numeroLicenca);
    }

    public static Veiculo  createPPEletrico(String matricula, String marca, String modelo, int potencia, int capacidadeBateria, String numeroSerie, int autonomia, int custoDiario, int custoMensal) {
        return new PesadoPassageirosEletrico(matricula, marca, modelo, potencia,capacidadeBateria, numeroSerie, autonomia, custoDiario, custoMensal);
    }

    public static Veiculo createALEletrico(String matricula, String marca, String modelo, int potencia, String numeroSerie, int capacidadeBagageira,
            int autonomia, int capacidadeBateria) {
        return new AutomovelLigeiroEletrico(matricula, marca, modelo, potencia, numeroSerie, capacidadeBagageira, autonomia, capacidadeBateria);
    }

    public static Veiculo createPesadoMercadorias(String matricula, String marca, String modelo, int potencia, String numeroSerie,
            int cargaMaxima, int nLitros) {
        return new PesadoMercadorias(matricula, marca, modelo, potencia,numeroSerie, cargaMaxima, nLitros);
    }

    public static Veiculo createPesadoPassageiros(String matricula, String marca, String modelo, int potencia, int cargaMaxima,
            String numeroSerie, int numeroMaxPassageiros) {
        return new PesadoPassageiros(matricula, marca, modelo, potencia, cargaMaxima, numeroSerie, numeroMaxPassageiros);
    }
    
}
