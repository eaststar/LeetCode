package word.breaks2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solutions {

	/**
	 * @param args
	 */
		HashSet<String> map = null;

		public ArrayList<String> wordBreak(String s, Set<String> dict) {
		    ArrayList<String> res = new ArrayList<String>();
		    if(s == null || s.length() == 0)
		        return res;

		    map = new HashSet<String>();//map”√”⁄ºÙ÷¶
		    res = recBreak(s, dict);

		    return (res != null)?res:new ArrayList<String>();
		}

		private ArrayList<String> recBreak(String s, Set<String> dict){
		    if(map.contains(s))
		        return null;

		    ArrayList<String> list = new ArrayList<String>();

		    ArrayList<String> temp = null;

		    for(int i =1; i<= s.length(); i++){
		        temp = new ArrayList<String>();
		        String str = s.substring(0, i);
		        if(dict.contains(str)){
		            if(i < s.length())
		                temp = recBreak(s.substring(i, s.length()), dict);
		            if(temp != null){
		                if(temp.size() == 0)
		                    list.add(str);
		                else{
		                    for(int j = 0; j< temp.size(); j++){
		                        list.add(str+" "+temp.get(j));
		                    }
		                }
		            }else{
		                map.add(s.substring(i, s.length()));
		            }
		        }
		    }

		    return (list.size() > 0)?list:null;

		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
