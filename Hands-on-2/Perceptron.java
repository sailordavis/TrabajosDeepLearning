
public class Perceptron {

    // Atributos del perceptron
    private double w1;
    private double w2;
    private double bias;
    private double velocidadAprendizaje;

    // Constructor
    public Perceptron(double w1, double w2, double bias,
                      double velocidadAprendizaje) {
        this.w1 = w1;
        this.w2 = w2;
        this.bias = bias;
        this.velocidadAprendizaje = velocidadAprendizaje;
    }

    // Calcula la suma ponderada
    public double sumaPonderada(int x1, int x2) {
        return (x1 * w1) + (x2 * w2) + bias;
    }

    // Funcion de activacion escalon
    public int activar(double suma) {
        return suma > 0 ? 1 : 0;
    }

    // Entrena el perceptron
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
                int esperada = salidasEsperadas[i];

                // Calcular la prediccion con los parametros actuales
                double suma = sumaPonderada(x1, x2);
                int prediccion = activar(suma);
                int error = esperada - prediccion;

                System.out.println("\nPatron: (" + x1 + ", " + x2 + ")");
                System.out.println("Suma ponderada: ("
                        + x1 + " * " + w1 + ") + ("
                        + x2 + " * " + w2 + ") + ("
                        + bias + ") = " + suma);

                System.out.println("Funcion de activacion: "
                        + suma + " > 0 -> " + prediccion);

                System.out.println("Salida esperada: " + esperada);
                System.out.println("Error: " + error);

                // Actualizar pesos y bias si existe un error
                if (error != 0) {

                    w1 = w1 + velocidadAprendizaje * error * x1;
                    w2 = w2 + velocidadAprendizaje * error * x2;
                    bias = bias + velocidadAprendizaje * error;

                    errores++;
                }

                System.out.println("Parametros despues de actualizar:");
                System.out.println("w1 = " + w1);
                System.out.println("w2 = " + w2);
                System.out.println("Bias = " + bias);
            }

            // Convergencia: una epoca completa sin errores
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
        System.out.println("Velocidad de aprendizaje = "
                + velocidadAprendizaje);
    }

    // Comprueba todos los patrones con los parametros finales
    public void probar(int[][] entradas, int[] salidasEsperadas) {

        System.out.println("\n========== PRUEBA FINAL OR ==========");

        boolean todasCorrectas = true;

        for (int i = 0; i < entradas.length; i++) {

            int x1 = entradas[i][0];
            int x2 = entradas[i][1];
            int esperada = salidasEsperadas[i];

            double suma = sumaPonderada(x1, x2);
            int prediccion = activar(suma);

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
            System.out.println("\nTodos los patrones OR se clasificaron "
                    + "correctamente.");
        } else {
            System.out.println("\nEl perceptron aun tiene clasificaciones "
                    + "incorrectas.");
        }
    }
}
