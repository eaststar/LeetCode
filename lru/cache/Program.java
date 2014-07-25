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
	Link<K, V> firstLink=new Link<K, V>();//����ͷ���
	Link<K, V> lastLink=new Link<K, V>();//����β���
	Link<K, V> P=new Link<K, V>();//������Ϊ������ı�Ǳ���
	Link<K, V> R=new Link<K, V>();//������Ϊ�����ڵ�ı�Ǳ���
	static int count=0;//����ĵ�ǰ����
	int maxCount;//�������󳤶�
	//���캯��
	public LRUCache2(int maxCount){
		this.maxCount=maxCount;
		//��ʼ��˫������ͷ���ָ��β��㣬β���ָ��ͷ���
		firstLink.nextLink=lastLink;
		lastLink.preLink=firstLink;
	}
	//�������в���Ԫ��
	@SuppressWarnings("unchecked")
	public void put(K key,V value){
		Link<K, V> Q=new Link<K, V>();//�˽��������ʼ����������Ľڵ�
		Q.data.put(key, value);//Ϊ��������Ľ�㸳ֵ
		P=firstLink.nextLink;//��P���ָ��ͷ���ĺ���һ�����
		Q.nextLink=P;
		P.preLink=Q;
		firstLink.nextLink=Q;
		Q.preLink=firstLink;
		this.count++;
		//ɾ��������û��ʹ�õĽ��
		if(removeEldEst(this.maxCount)){
			//�����һ���ڵ�ɾ����Ҳ���ǽ�β���ָ�����ڶ�����ֵ�Ľ�㲢�ҽ������һ
			lastLink.preLink.preLink.nextLink=lastLink;
			lastLink.preLink=lastLink.preLink.preLink;
			this.count--;
		}
	}
	//����keyֵ��ȡ����value���ҽ��˽�����ͷ���ĺ���
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
	//��ӡ���н��
	@SuppressWarnings("unchecked")
	public void printAll(){
		this.R=firstLink.nextLink;
		for(int i=0;i<this.count;i++){
			System.out.println(R.data);
			R=R.nextLink;
		}
	}
	//�ж��Ƿ���Ҫɾ��������û��ʹ�õĽ��
	protected boolean removeEldEst(int maxCount){
		return this.count>maxCount;
	}	
}
//����˫�������������ֵ��HashMap��ʾ
class Link<K,V>{
	Link preLink;
	Link nextLink;
	HashMap<K, V> data=new HashMap<K, V>();
}