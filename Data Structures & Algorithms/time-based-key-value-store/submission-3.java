class TimeMap {
    private static class TimeValue {
        int timestamp;
        String value;

        TimeValue(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<TimeValue>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new TimeValue(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<TimeValue> records = map.get(key);
        if (records == null)
            return "";
        int left = 0;
        int right = records.size() - 1;
        String result = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (records.get(mid).timestamp <= timestamp) {
                result = records.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
