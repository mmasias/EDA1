class Tema001Arrays2D {
    public static void main(String[] args) {

        String uno = "1";
        String dos = uno + uno;

        String[] vector = { uno, dos, "3", "4" };
        System.out.println(vector[0]);

        String[] otroVector = vector;
        System.out.println(otroVector[3]);

        otroVector[3] = "X";
        System.out.println(vector[3]);

        String[][] matriz = {
                { "1", "2", "3", "4" },
                vector,
                otroVector
        };
        imprimeMatriz(matriz);

        dos = "2";
        imprimeMatriz(matriz);

        matriz[0][2] = "JA!";
        imprimeMatriz(matriz);

        matriz[1][2] = "JO!";
        imprimeMatriz(matriz);
    }

    static void imprimeMatriz(String[][] unaMatriz) {
        for (int fila = 0; fila < unaMatriz.length; fila++) {
            for (int columna = 0; columna < unaMatriz[fila].length; columna++) {
                System.out.print(unaMatriz[fila][columna] + " : ");
            }
            System.out.println();
        }
        System.out.println("=".repeat(20));
    }

}