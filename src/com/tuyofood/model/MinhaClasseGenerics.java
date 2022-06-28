public class MinhaClasse<T extends Number> { // T agora dá um extends na classe Number

    T numClasse;

    public MinhaClasse(T numClasse) {
        this.numClasse = numClasse;
    }

    // O erro que aparecia aqui agora some
    Double aoQuadrado() {
        return numClasse.intValue() * numClasse.doubleValue();
    }

    // Outro exemplo agora usando <?> que vou explicar abaixo
    boolean saoIguais(MinhaClasse<?> obj) {
        if(Math.abs(numClasse.doubleValue()) == Math
                .abs(obj.numClasse.doubleValue())) {
            return true;
        }
        return false;
    }
}