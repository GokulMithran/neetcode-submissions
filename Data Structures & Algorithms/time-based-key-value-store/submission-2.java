class TimeMap {
    private static class TimeValue {
        int timeStamp;
        String value;

        TimeValue(int timeStamp, String value) {
            this.timeStamp = timeStamp;
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
            if (records.get(mid).timeStamp <= timestamp) {
                left = mid + 1;
                result = records.get(mid).value;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
