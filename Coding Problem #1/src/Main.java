import java.util.Arrays;

/**
 * Given a nested arrays of integers and an integer radius, 
 * compute the minimum sum of the square of the given radius
 * as below
 * 					 
 * 					 124*462
 *                   53***89
 *                   8*****1
 *                   ***o***
 *                   2*****5
 *                   95***76
 *                   856*905  
 */
public class Main {
	
	private static int abs(int num) {
		if(num < 0) {
			return -num;
		}
		return num;
	}
	
	private static int[] compute(int[][] matrix, int radius) {
		int min = 0;
		int s_row = radius - 1; int s_col = radius - 1;
		int e_row = matrix.length - radius; int e_col = matrix[0].length - radius;
		int[] sum_list = new int[(e_row - s_row + 1) * (e_col - s_col + 1)];
		int index = 0;
		
		for(int i = s_row; i <= e_row; i++) {
			for(int j = s_col; j <= e_col; j++) {
				// compute the sum for each (i, j)
				int sum = 0;
				for(int k = -radius + 1; k <= radius - 1; k++) { //-3, -2, -1, 0, 1, 2, 3
					for(int m = abs(k) - (radius - 1); m <= (radius - 1) - abs(k); m++) { // 1
						sum += matrix[i + k][j + m];
					}
				}
				
				sum_list[index] = sum;
				index ++;
			}
		}
		if(sum_list.length <= 3) {
			return sum_list;
		}
		
		// get the three smallest ones
		Arrays.sort(sum_list);
		int[] result = new int[3];
		result[0] = sum_list[sum_list.length - 1];
		result[1] = sum_list[sum_list.length - 2];
		result[2] = sum_list[sum_list.length - 3];
		return result;
	}
	
	public static void main(String[] args) {
		
		int[][] matrix = {{1, 1, 1, 1}, {1, 2, 3, 1}, {1, 1, 1, 1}, {1, 1, 1, 1},  
				{1, 1, 1, 1},  {1, 1, 1, 1}};
		int[][] matrix2 = {{1, 2, 3, 4, 1}, {5, 6, 7, 8, 1}, {9, 10, 11, 12, 1}, {13, 14, 15, 16, 1},  
				{17, 18, 19, 20, 1}};
		int[] result = compute(matrix, 2);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
		System.out.println();
		int[] result2 = compute(matrix2, 3);
		for(int i = 0; i < result2.length; i++) {
			System.out.print(result2[i]);
		}
	}

}
