import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 8032109955967762394L;
	private int cacheSize;

	private LRUCache(int cacheSize) {
		super(cacheSize, 0.75f, true);
		this.cacheSize = cacheSize;
	}
	
	public static <K, V> LRUCache<K,V> newInstance(int cacheSize){
		return new LRUCache<K, V>(cacheSize);		
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
		return size() > cacheSize;		
	}
	
	public static void main(String[] args) {
		LRUCache<String, String> lru = LRUCache.newInstance(5);
		lru.put("1", "1");
		lru.put("2", "2");
		lru.put("3", "3");
		lru.put("4", "4");
		lru.put("5", "5");
		lru.put("2", "2");
		lru.put("3", "3");
		lru.put("6", "6");
		lru.put("7", "7");
		lru.put("1", "1");
		System.out.println(lru);
	}

}
