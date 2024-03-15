public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;  // 当前位置的行
        int col = 0;  // 当前位置的列

        while (row < rows && col < cols) {
            System.out.print(matrix[row][col] + " ");

            // 斜向上遍历
            if (row > 0 && col < cols - 1) {
                row--;
                col++;
            }
            // 斜向下遍历
            else if (row < rows - 1 && col >= 0) {
                row++;
                col--;
            }
            // 到达边界，需要转向
            else {
                if (col < cols - 1) {
                    col++;
                } else {
                    row++;
                }
            }
        }
    }
}
