package word.breaks;

import java.util.Set;

public class Solution {

	/**
	 * @param args
	 */
    public boolean wordBreak(String s, Set<String> dict) {
        for(int i=0;i<s.length();i++){
        	for(int j=i+1;j<s.length();j++){
	        	if(dict.contains(s.substring(i, j))){
	        		return true;
	        	}
        	}
        }
    	return false;
    }
    public boolean wordBreakRight(String s, Set<String> dict) {
        int length = s.length();
        boolean[] can = new boolean[length+1];
        can[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && dict.contains(s.substring(j, i))) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[length];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
