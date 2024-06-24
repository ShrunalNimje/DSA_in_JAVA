package my.mood;

public class Intervals {

    // Representation of Intervals & Overlapping Intervals
    public static class Interval{
        public int start;
        public int end;

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Interval interval = new Interval(2, 6);
        interval = new Interval(3, 8);
        interval = new Interval(7, 9);

    }
}
