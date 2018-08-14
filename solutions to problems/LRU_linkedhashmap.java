public class LRUCache extends LinkedHashMap<Integer, Integer>{
    public int MAX_SIZE;
    
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.MAX_SIZE = capacity;
    }
    
    public int get(int key) {
        Integer v = super.get(key);
        return v == null ? -1 : v;
    }
    
    public void set(int key, int value) {
        super.put(key, value);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > MAX_SIZE;
    }
}
/*
0.75f is the load factor -The load factor represents at what level the HashMap capacity should be doubled.
https://stackoverflow.com/questions/10901752/what-is-the-significance-of-load-factor-in-hashmap

his override will allow the map to grow up to 100 entries and then delete the eldest entry each time a 
new entry is added, maintaining a steady state of 100 entries.*/