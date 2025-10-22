import java.util.*;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    int k = ans.get(i - 1).get(j) + ans.get(i - 1).get(j - 1);
                    temp.add(k);
                }
            }
            ans.add(temp);
        }

        return ans;
    }

    public static void main(String[] args) {
        PascalTriangle sol = new PascalTriangle();
        int numRows = 7;

        List<List<Integer>> triangle = sol.generate(numRows);

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows - i - 1; j++) {
                System.out.print(" ");
            }

            for (int num : triangle.get(i)) {
                System.out.print(num + " ");
            }

            System.out.println();
        }
    }
}
