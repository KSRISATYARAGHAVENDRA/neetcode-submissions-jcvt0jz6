class TimeMap {
    private Map<String, List<Pair<Integer, String>>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));  
    }
    
    public String get(String key, int timestamp) {
        String result  = "";

        List<Pair<Integer, String>> list = map.getOrDefault(key, new ArrayList<>());

        int l = 0, r = list.size() - 1;

        while(l <= r){
            int m = l + ((r - l) / 2);

            if(list.get(m).getKey() <= timestamp){
                result = list.get(m).getValue();
                l = m + 1;
            }
            else{
                r = m - 1;
            }
        }
        return result;
    }

    private static class Pair<K, V>{
        private final K key;
        private final V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }
    }
}

