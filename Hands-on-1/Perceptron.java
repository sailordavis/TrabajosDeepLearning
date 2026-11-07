
public class Perceptron {

    // Atributos del perceptron
    private double w1;
    private double w2;
    private double bias;

    // Constructor: inicializa los parametros
    public Perceptron(double w1, double w2, double bias) {
        this.w1 = w1;
        this.w2 = w2;
        this.bias = bias;
    }

    // Calcula la suma ponderada
    public double sumaPonderada(int x1, int x2) {
        return (x1 * w1) + (x2 * w2) + bias;
    }

    // Funcion de activacion escalon
    public int activar(double suma) {
        return suma > 0 ? 1 : 0;
    }

    // Entrena el perceptron con los patrones proporcionados
    public void entrenar(int[][] entradas, int[] salidasEsperadas,
                         int maxEpocas) {

        boolean convergio = false;

        for (int epoca = 1; epoca <= maxEpocas; epoca++) {

            int errores = 0;

            System.out.println("\n========== EPOCA "
                    + epoca + " ==========");

            for (int i = 0; i < entradas.length; i++) {

                int x1 = entradas[i][0];
                int x2 = entradas[i][1];
                int salidaEsperada = salidasEsperadas[i];

                // Calcula la prediccion actual
                double suma = sumaPonderada(x1, x2);
                int prediccion = activar(suma);

                // Calcula el error de clasificacion
                int error = salidaEsperada - prediccion;

                System.out.println("\nPatron: (" + x1 + ", " + x2 + ")");
                System.out.println("Suma ponderada: "
                        + x1 + " * " + w1 + " + "
                        + x2 + " * " + w2 + " + "
                        + bias + " = " + suma);

                System.out.println("Funcion de activacion: "
                        + suma + " > 0 -> " + prediccion);

                System.out.println("Salida esperada: "
                        + salidaEsperada);

                System.out.println("Error: " + error);

                // Actualiza los parametros sin velocidad de aprendizaje
                if (error != 0) {
                    w1 = w1 + (error * x1);
                    w2 = w2 + (error * x2);
                    bias = bias + error;

                    errores++;
                }

                System.out.println("Pesos despues de actualizar: w1="
                        + w1 + ", w2=" + w2 + ", bias=" + bias);
            }

            // Si no hubo errores, el perceptron aprendio los patrones
            if (errores == 0) {
                convergio = true;
                System.out.println("\nEl perceptron convergio en la epoca "
                        + epoca + ".");
                break;
            }
        }

        if (!convergio) {
            System.out.println("\nNo se logro converger dentro del limite "
                    + maxEpocas + " epocas.");
        }

        System.out.println("\n========== PARAMETROS FINALES ==========");
        System.out.println("w1 = " + w1);
        System.out.println("w2 = " + w2);
        System.out.println("Bias = " + bias);
    }

    // Comprueba la clasificacion final de todos los patrones
    public void probar(int[][] entradas, int[] salidasEsperadas) {

        System.out.println("\n========== PRUEBA FINAL AND ==========");

        boolean todasCorrectas = true;

        for (int i = 0; i < entradas.length; i++) {

            int x1 = entradas[i][0];
            int x2 = entradas[i][1];

            double suma = sumaPonderada(x1, x2);
            int prediccion = activar(suma);
            int esperada = salidasEsperadas[i];

            System.out.println("\nPatron: (" + x1 + ", " + x2 + ")");
            System.out.println("Suma ponderada: ("
                    + x1 + " * " + w1 + ") + ("
                    + x2 + " * " + w2 + ") + ("
                    + bias + ") = " + suma);

            System.out.println("Funcion de activacion: "
                    + prediccion);
            System.out.println("Salida esperada: " + esperada);

            if (prediccion == esperada) {
                System.out.println("Resultado: CORRECTO");
            } else {
                System.out.println("Resultado: INCORRECTO");
                todasCorrectas = false;
            }
        }

        if (todasCorrectas) {
            System.out.println("\nTodos los patrones AND se clasificaron "
                    + "correctamente.");
        } else {
            System.out.println("\nEl perceptron aun tiene clasificaciones "
                    + "incorrectas.");
        }
    }
}
