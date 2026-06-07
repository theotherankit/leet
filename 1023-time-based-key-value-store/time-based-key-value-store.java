class TimeMap {

    class TimeValue {
        int timestamp;
        String value;
        TimeValue(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    HashMap<String, ArrayList<TimeValue>> db;

    public TimeMap() {
        db = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        db.putIfAbsent(key, new ArrayList<>());
        db.get(key).add(new TimeValue(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!db.containsKey(key))
            return "";

        ArrayList<TimeValue> list = db.get(key);
        int l = 0, r = list.size() - 1;
        String res = "";
        
        while(l <= r) {
            int mid = (l + r) / 2;
            if(list.get(mid).timestamp <= timestamp) {
                res = list.get(mid).value;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }

        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */