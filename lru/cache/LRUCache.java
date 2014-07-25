package lru.cache;

import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {

	/**
	 * @param args
	 */
	HashMap<Integer, Integer> cacheMap; // key, value
	ArrayList<Integer> list;//last used key
	int capacity;
    public LRUCache(int capacity) {
    	this.cacheMap = new HashMap<Integer, Integer>();
    	this.list  = new ArrayList<Integer>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
		if(this.cacheMap.containsKey(key)){
			this.list.remove(new Integer(key));
			this.list.add(key);
			return this.cacheMap.get(key);
		}
    	return -1;       
    }
    
    public void set(int key, int value) {
        if(this.cacheMap.containsKey(key)){
            this.cacheMap.remove(key);
            this.cacheMap.put(key, value);
        	this.list.remove(new Integer(key));
        	this.list.add(key);
        }
        else{
        	if(list.size()>=capacity){
        		this.cacheMap.remove(this.list.get(0));
        		this.list.remove(0); 
        	}
            this.cacheMap.put(key, value);
            this.list.add(key);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
