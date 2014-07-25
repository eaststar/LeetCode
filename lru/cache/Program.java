package lru.cache;
import java.util.HashMap;
public class Program {

public static void main(String[] args) {
		LRUCache2<Integer, String> lruCache=new LRUCache2<Integer, String>(3);
		lruCache.put(1, "123");
		lruCache.put(2, "234");
		lruCache.put(3, "345");
		lruCache.put(4, "456");
		lruCache.put(5, "567");
		System.out.println(lruCache.get(4));
		lruCache.printAll();
	}
}
class LRUCache2<K,V>{
	Link<K, V> firstLink=new Link<K, V>();//定义头结点
	Link<K, V> lastLink=new Link<K, V>();//定义尾结点
	Link<K, V> P=new Link<K, V>();//这个结点为插入结点的标记变量
	Link<K, V> R=new Link<K, V>();//这个结点为遍历节点的标记变量
	static int count=0;//缓存的当前长度
	int maxCount;//缓存的最大长度
	//构造函数
	public LRUCache2(int maxCount){
		this.maxCount=maxCount;
		//初始化双链表，将头结点指向尾结点，尾结点指向头结点
		firstLink.nextLink=lastLink;
		lastLink.preLink=firstLink;
	}
	//在链表中插入元素
	@SuppressWarnings("unchecked")
	public void put(K key,V value){
		Link<K, V> Q=new Link<K, V>();//此结点用来初始化即将插入的节点
		Q.data.put(key, value);//为即将插入的结点赋值
		P=firstLink.nextLink;//将P结点指向头结点的后面一个结点
		Q.nextLink=P;
		P.preLink=Q;
		firstLink.nextLink=Q;
		Q.preLink=firstLink;
		this.count++;
		//删除最近最久没有使用的结点
		if(removeEldEst(this.maxCount)){
			//将最后一个节点删除，也就是将尾结点指向倒数第二个有值的结点并且结点数减一
			lastLink.preLink.preLink.nextLink=lastLink;
			lastLink.preLink=lastLink.preLink.preLink;
			this.count--;
		}
	}
	//根据key值读取结点的value并且将此结点放在头结点的后面
	@SuppressWarnings("unchecked")
	public V get(K key){
		this.R=firstLink.nextLink;
		for(int i=0;i<this.count;i++){
			if(R.data.keySet().contains(key)){
				Link<K, V> B=R;
				B.preLink.nextLink=B.nextLink;
				B.nextLink.preLink=B.preLink;
				B.nextLink=firstLink.nextLink;
				firstLink.nextLink.preLink=B;
				firstLink.nextLink=B;
				B.preLink=firstLink;
				P=firstLink.nextLink;
				return (V) R.data.get(key);
			}
			R=R.nextLink;
		}
		return null;
	}
	//打印所有结点
	@SuppressWarnings("unchecked")
	public void printAll(){
		this.R=firstLink.nextLink;
		for(int i=0;i<this.count;i++){
			System.out.println(R.data);
			R=R.nextLink;
		}
	}
	//判断是否需要删除最近最久没有使用的结点
	protected boolean removeEldEst(int maxCount){
		return this.count>maxCount;
	}	
}
//定义双链表，并且链表的值用HashMap表示
class Link<K,V>{
	Link preLink;
	Link nextLink;
	HashMap<K, V> data=new HashMap<K, V>();
}