package word.breaks2;

import java.util.ArrayList;
import java.util.Set;

public class Solution {

	/**
	 * @param args
	 */
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
    	ArrayList<String> breaks = new ArrayList<String>();
    	if(s == null || s.length()==0){
    		return breaks;
    	}
    	helper(s,dict,0,"",breaks);
    	return breaks;
    }
    private void helper(String s,Set<String> dict,int start,String item,ArrayList<String> breaks){
    	if(start>=s.length()){
    		breaks.add(item);
    		return;
    	}
    	StringBuffer str = new StringBuffer();
    	for(int i=start;i<s.length();i++){
    		str.append(s.charAt(i));
    		if(dict.contains(str.toString()))
    		{
    			String newitem = item.length()>0?(item+" "+str.toString()):str.toString();
    			helper(s,dict,i+1,newitem,breaks);
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
