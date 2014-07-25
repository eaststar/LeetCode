/*
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
package max.points;
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {

    public int maxPoints(Point[] points) {
    	if(points.length<2)
    		return points.length;
    	int maxnum = 2;
        for(int i=0;i<points.length;i++){
        	int samepoint = 0;
        	for(int j=0;j<points.length;j++){
    			int linemax = 0;
        		if(points[i].x==points[j].x && points[i].y==points[j].y){
        			samepoint ++;
        		}
        		else{
        			for(int k=0;k<points.length;k++){
        				if((points[i].y-points[j].y)*(points[j].x-points[k].x) == (points[j].y-points[k].y)*(points[i].x-points[j].x)){
        					linemax ++;
        				}
        			}
        			maxnum = Math.max(maxnum,linemax);
        		}
        	}
        	maxnum = Math.max(maxnum, samepoint);
        }
        return maxnum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] points = {new Point(1,1),new Point(1,1),new Point(2,3)};
		Solution s = new Solution();
		System.out.println(s.maxPoints(points));
	}

}
class Point {
	 int x;
	 int y;
	 Point() { x = 0; y = 0; }
	 Point(int a, int b) { x = a; y = b; }
}