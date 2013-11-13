import java.util.*;
public class LRUCache {

    private LRUMap mMap;

    public LRUCache(int capacity) {
        mMap = new LRUMap(capacity);
    }

    public int get(int key) {
        if (mMap.containsKey(key))
            return mMap.get(key);
        else
            return -1;
    }

    public void set(int key, int value) {
        mMap.put(key, value);
    }

    private class LRUMap extends LinkedHashMap<Integer, Integer> {
        private int mCapacity;

        public LRUMap(int capacity) {
            super(capacity, 0.75f, true);
            mCapacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(
                java.util.Map.Entry<Integer, Integer> eldest) {
            return size() > mCapacity;
        }
    }
}