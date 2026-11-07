
public class Main {

    public static void main(String[] args) {

        // 1. Patrones de entrada de la compuerta OR
        int[][] entradas = {
            {0, 0},
            {0, 1},
            {1, 0},
            {1, 1}
        };

        // 2. Salidas esperadas de la compuerta OR
        int[] salidasEsperadas = {
            0,
            1,
            1,
            1
        };

        // 3. Parametros iniciales del perceptron
        double w1Inicial = 0.0;
        double w2Inicial = 0.0;
        double biasInicial = 0.0;

        // Velocidad de aprendizaje
        double velocidadAprendizaje = 0.1;

        // Limite de epocas
        int maxEpocas = 100;

        // 4. Crear el objeto perceptron
        Perceptron perceptron = new Perceptron(
            w1Inicial,
            w2Inicial,
            biasInicial,
            velocidadAprendizaje
        );

        // 5. Mostrar la configuracion inicial
        System.out.println("==================================");
        System.out.println("   PERCEPTRON - COMPUERTA OR");
        System.out.println("==================================");

        System.out.println("\nParametros iniciales:");
        System.out.println("w1 = " + w1Inicial);
        System.out.println("w2 = " + w2Inicial);
        System.out.println("Bias = " + biasInicial);
        System.out.println("Velocidad de aprendizaje = "
                + velocidadAprendizaje);

        // 6. Entrenar el perceptron
        perceptron.entrenar(
            entradas,
            salidasEsperadas,
            maxEpocas
        );

        // 7. Verificar las clasificaciones finales
        perceptron.probar(
            entradas,
            salidasEsperadas
        );
    }
}
