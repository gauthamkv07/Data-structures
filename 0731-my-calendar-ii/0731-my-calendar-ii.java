class MyCalendarTwo {
    TreeMap<Integer, Integer> map;
    int maxOverlapBooking;

    public MyCalendarTwo() {
        map = new TreeMap<>();
        maxOverlapBooking = 2;
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int overlapBooking = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            overlapBooking += entry.getValue();

            if (overlapBooking > maxOverlapBooking) {
                map.put(start, map.getOrDefault(start, 0) - 1);
                map.put(end, map.getOrDefault(end, 0) + 1);

                if(map.get(start) == 0) map.remove(start);

                return false;
            }
        }

        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */