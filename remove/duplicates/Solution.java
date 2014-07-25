package remove.duplicates;

public class Solution {

    public int[] removeDuplicates(int[] A) {
        for(int i=0;i<A.length;i++){
        	if(A[i+1]==A[i]){
        		A[i+1]=A[i+2];
        	}
        }
        return A;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
