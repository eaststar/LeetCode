package single.number;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {

	/**
	 * @param args
	 */
    public int singleNumber(int[] A) {
        int singlenum = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        LinkedList<Integer> sing = new LinkedList<Integer>();
        if(A.length<=0)
        	singlenum = 0;
        else{
        	for(int i=0;i<A.length;i++){
        		if(map.containsKey(A[i]))
        		{
        			if(map.get(A[i])==2){
        				sing.remove(new Integer(A[i]));
        			}
            		else{
            			map.put(A[i], map.get(A[i])+1);
            		}
        		}
        		else
        		{
        			map.put(A[i], 1);
        			sing.add(A[i]);
        		}
        	}
        }
        singlenum = (Integer) sing.toArray()[0];
        return singlenum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] A = {1,2,3,4,5,1,2,3,4,1,2,3,4};
		System.out.println(s.singleNumber(A));
	}

}
