package reverse.integer;

public class Solution {

	/**
	 * @param args
	 */
    public int reverse(int x) {
	    String strX = Integer.toString(x);
	    int len = strX.length();
	    StringBuffer dest = new StringBuffer(len);
	    if(x>=0){
	        for(int i = len -1; i >= 0 ; i--){
	            dest.append(strX.charAt(i));
	        }
	    }
	    else{
	        dest.append('-');
	        for(int i = len -1; i >= 1 ; i--){
	            dest.append(strX.charAt(i));
	        }
	    }
//	    if(dest.toString().compareTo("1000000000")>0)
//	    	return 0;
	    return Integer.parseInt(dest.toString());
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.reverse(1000000003));
	}

}
