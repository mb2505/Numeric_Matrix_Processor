import java.util.Scanner;

public class Operation {
    private final Scanner scanner = new Scanner(System.in);

    public void addMatrices() {
        Matrix matrixA = createMatrix();
        Matrix matrixB = createMatrix();
        try {
            matrixA.add(matrixB);
            System.out.println("The result is:");
            matrixA.print();
        } catch (Exception e) {
            System.out.println("The operation cannot be performed.");
        }
    }

    public void multiplyConstant() {
        Matrix matrix = createMatrix();
        System.out.println("Enter constant:");
        double constant = scanner.nextDouble();
        matrix.multiplyConstant(constant);
        System.out.println("The result is:");
        matrix.print();
    }

    public void multiplyMatrices() {
        Matrix matrixA = createMatrix();
        Matrix matrixB = createMatrix();
        Matrix matrixProduct = new Matrix(matrixA.getM(), matrixB.getN());
        try {
            matrixProduct.multiply(matrixA, matrixB);
            System.out.println("The result is:");
            matrixProduct.print();
        } catch (Exception e) {
            System.out.println("The operation cannot be performed.");
        }
    }

    public Matrix createMatrix() {
        System.out.println("Enter size of first matrix:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        Matrix matrix = new Matrix(a, b);
        System.out.println("Enter first matrix:");
        matrix.fill();
        return matrix;
    }

    public void mainDiagonal() {
        Matrix matrix = createMatrix();
        matrix.transpose();
        matrix.print();
    }

    public void sideDiagonal() {
        Matrix matrix = createMatrix();
        matrix.transposeSide();
        matrix.print();
    }

    public void vertical() {
        Matrix matrix = createMatrix();
        matrix.transposeVertical();
        matrix.print();
    }

    public void horizontal() {
        Matrix matrix = createMatrix();
        matrix.transposeHorizontal();
        matrix.print();
    }

    public void calculateDeterminant() {
        Matrix matrix = createMatrix();
        System.out.println("The result is:");
        System.out.println(matrix.determinant());
    }

    public void inverseMatrix() {
        Matrix matrix = createMatrix();
        matrix.inverse();
    }

}
