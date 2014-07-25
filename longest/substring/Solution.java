package longest.substring;

public class Solution {

	/**
	 * @param args
	 */
    public int lengthOfLongestSubstring(String s) {
        int max = 0,count = 0;
        char[] c = s.toCharArray();
        if(1==s.length())
        	return 1;
        int start = 0;
        int[] arr = new int[256];
        for(int i=0;i<s.length()-1;i++){
        	if(arr[c[i]]==0 && arr[c[i]]>=start){
        		start = arr[c[i]];
        		count = i-start+1;
        		arr[c[i]] = i+1;
        	}
        	else{
        		arr[c[i]] = i+1;
        		count++;
        	}
        }
        if(count>max)
            max=count;
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco");
		}

}
