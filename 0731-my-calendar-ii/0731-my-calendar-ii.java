class MyCalendarTwo {

    private List<int[]> bookings;
    private List<int[]> overlapBookings;

    public boolean doesOverLap(int start1, int end1, int start2, int end2) {
        return Math.max(start1, start2) < Math.min(end1, end2);
    }

    public int[] getOverlappedBooking(int start1, int end1, int start2, int end2) {
        return new int[]{Math.max(start1, start2), Math.min(end1, end2)};
    }

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlapBookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] booking: overlapBookings) {
            int start1 = booking[0];
            int end1 = booking[1];
            if(doesOverLap(start1, end1, start, end)) return false;
        }

        for(int[] booking: bookings) {
            int start1 = booking[0];
            int end1 = booking[1];
            if(doesOverLap(start1, end1, start, end)) overlapBookings.add(getOverlappedBooking(start1, end1, start, end));
        }

        bookings.add(new int[]{start, end});

        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */