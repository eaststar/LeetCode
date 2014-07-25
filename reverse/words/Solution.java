package reverse.words;

import java.util.ArrayList;

public class Solution {

	/**
	 * @param args
	 */
    public String reverseWords(String s) {
        String input = s.trim();
        String output;
        StringBuffer outbuf = new StringBuffer();
        ArrayList<String> a = new ArrayList<String>();
        String[] inputsplit = input.split(" ");
        for(int i=inputsplit.length-1;i>=0;i--){
        	if(!inputsplit[i].equals("")&&!inputsplit[i].equals(" ")){
        		System.out.println(inputsplit[i]);
        		a.add(inputsplit[i]);
        	}
        }
        for(int i=0;i<a.size();i++){
        	outbuf.append(a.get(i)+" ");
        }
        output = outbuf.toString().trim();
        return output;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.reverseWords("   a   b "));
	}

}
