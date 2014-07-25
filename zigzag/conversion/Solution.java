package zigzag.conversion;

public class Solution {

	/**
	 * @param args
	 */
    public String convert(String s, int nRows) {
        if (s==null||s.length()==0||nRows<=1) return s;
        String[] array= new String[nRows];
        for (int i=0;i<nRows;i++)
            array[i]="";
        for (int i=0;i<s.length();i++){
            int position = i%(2*nRows-2);
            if (position<nRows)
                array[position]=new StringBuilder(array[position]).append(s.charAt(i)).toString();
            else 
                array[2*nRows-2-position]=new StringBuilder(array[2*nRows-2-position]).append(s.charAt(i)).toString();
        }
        for (int i=1;i<nRows;i++)
            array[0]= new StringBuilder(array[0]).append(array[i]).toString();
        return array[0]; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.convert("PAYPALISHIRING", 3));
	}

}
