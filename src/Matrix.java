import java.util.Scanner;

public class Matrix {
    private final int m, n;
    private double[][] matrix;
    private final Scanner scanner = new Scanner(System.in);

    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
        this.matrix = new double[m][n];
    }

    public void fill() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
    }

    public void print() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void multiplyConstant(double cons) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] *= cons;
            }
        }
    }

    public void add(Matrix matrixB) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.matrix[i][j] += matrixB.matrix[i][j];
            }
        }
    }

    public void multiply(Matrix matrix1, Matrix matrix2) {
        for (int i = 0; i < matrix1.getM(); i++) {
            for (int j = 0; j < matrix2.getN(); j++) {
                for (int k = 0; k < matrix1.getN(); k++)
                    matrix[i][j] += matrix1.getMatrix()[i][k] * matrix2.getMatrix()[k][j];
            }
        }
    }

    public void transpose() {
        double[][] temp = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][i] = matrix[i][j];
            }
        }
        matrix = temp;
    }

    public void transposeSide() {
        double temp = 0;
        for(int col = 0; col < matrix.length - 1; col++) {
            for (int row = 0; row < matrix.length - 1 - col; row++) {
                temp = matrix[row][col];
                matrix[row][col] = matrix[matrix.length - 1 - col][matrix.length - 1 - row];
                matrix[matrix.length - 1 - col][matrix.length - 1 - row] = temp;
            }
        }
    }

    public void transposeVertical() {
        double[][] temp = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][n - j - 1] = matrix[i][j];
            }
        }
        matrix = temp;
    }

    public void transposeHorizontal() {
        double[][] temp = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[m - i - 1][j] = matrix[i][j];
            }
        }
        matrix = temp;
    }

    public double determinant() {
        double det = 0;
        if (m == 2 && n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        for (int i = 0; i < n; i++) {
            Matrix temp = new Matrix(n - 1, m - 1);
            int ro = -1;
            for (int r = 0; r < n; r++) {
                int co = 0;
                for (int c = 0; c < m; c++) {
                    if (r != 0 && c != i) {
                        temp.matrix[ro][co] = this.matrix[r][c];
                        co++;
                    }
                }
                ro++;
            }
            det += Math.pow(-1, i) * matrix[0][i] * temp.determinant();
        }
        return det;
    }

    public double cofactor(int i, int j) {
        Matrix cofactorTemp = new Matrix(m - 1, n - 1);
        for (int r = 0, oldRow = 0; r < cofactorTemp.getM(); r++, oldRow++) {
            for (int c = 0, oldColumn = 0; c < cofactorTemp.getN(); c++, oldColumn++) {
                // skip ith row
                if (oldRow == i) {
                    oldRow++;
                }
                // skip jth column
                if (oldColumn == j) {
                    oldColumn++;
                }
                cofactorTemp.matrix[r][c] = this.matrix[oldRow][oldColumn];
            }
        }
        return Math.pow(-1, (i + j)) * cofactorTemp.determinant();
    }

    public void inverse() {
        double d = this.determinant();
        if (d == 0) {
            System.out.println("This matrix doesn't have an inverse");
            return;
        }
        Matrix inverseMatrix = new Matrix(m, n);
        for (int i = 0; i < inverseMatrix.getM(); i++) {
            for (int j = 0; j < inverseMatrix.getN(); j++) {
                inverseMatrix.matrix[j][i] = (1 / d) * this.cofactor(i, j);
            }
        }
        inverseMatrix.print();
    }


    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public double[][] getMatrix() {
        return matrix;
    }
}
