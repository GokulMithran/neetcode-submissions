class TimeMap {
    private static Map<String, String> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        StringBuilder sb = new StringBuilder();
        sb.append(key);
        sb.append("#");
        sb.append(timestamp);
        map.putIfAbsent(sb.toString(), value);
    }

    public String get(String key, int timestamp) {
        StringBuilder sb = new StringBuilder();
        sb.append(key);
        sb.append("#");
        int digitCount = String.valueOf(timestamp).length();
        while (timestamp >= 0) {
            sb.append(timestamp);
            if (map.containsKey(sb.toString())) {
                return map.get(sb.toString());
            } else {
                digitCount = String.valueOf(timestamp).length();
                sb.delete(sb.length() - digitCount, sb.length());
            }
            timestamp--;
        }
        return "";
    }
}
