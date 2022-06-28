public class MinhaClasseGenericsTeste {

    public static void main(String[] args) throws Exception {
        MinhaClasse<Integer> inteiro = new MinhaClasse<>(5);
        MinhaClasse<Double> doubleTipo = new MinhaClasse<>(5.0);
        System.out.println(inteiro.aoQuadrado() + " | " + doubleTipo.aoQuadrado());

        System.out.println(inteiro.saoIguais(doubleTipo));
    }
}

/* output:
	25.0 | 25.0
	true
*/