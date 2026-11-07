
public class Main {

    public static void main(String[] args) {

        // 1. Patrones de entrada de la compuerta logica AND
        int[][] entradas = {
            {0, 0},
            {0, 1},
            {1, 0},
            {1, 1}
        };

        // 2. Salidas esperadas para cada patron
        int[] salidasEsperadas = {
            0,
            0,
            0,
            1
        };

        // 3. Inicializacion de los parametros del perceptron
        double w1Inicial = 0.0;
        double w2Inicial = 0.0;
        double biasInicial = 0.0;

        // 4. Limite maximo de epocas de entrenamiento
        int maxEpocas = 100;

        // 5. Crear el objeto perceptron
        Perceptron perceptron = new Perceptron(
            w1Inicial,
            w2Inicial,
            biasInicial
        );

        // 6. Mostrar los datos iniciales
        System.out.println("==================================");
        System.out.println("   PERCEPTRON - COMPUERTA AND");
        System.out.println("==================================");

        System.out.println("\nParametros iniciales:");
        System.out.println("w1 = " + w1Inicial);
        System.out.println("w2 = " + w2Inicial);
        System.out.println("Bias = " + biasInicial);

        // 7. Entrenar el perceptron
        perceptron.entrenar(
            entradas,
            salidasEsperadas,
            maxEpocas
        );

        // 8. Comprobar las clasificaciones finales
        perceptron.probar(
            entradas,
            salidasEsperadas
        );
    }
}
