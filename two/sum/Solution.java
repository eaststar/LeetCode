package two.sum;

public class Solution {

	/**
	 * @param args
	 */
 public int[] twoSum(int[] numbers, int target) {
	        int[] result = new int[2];
	        for(int i=0;i<numbers.length-1;i++){
	            for(int j=i+1;j<numbers.length;j++){
	                if(target == numbers[i]+numbers[j]){
	                    result[0] = i+1;
	                    result[1] = j+1;
	                }
	            }
	        }
	        return result;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
