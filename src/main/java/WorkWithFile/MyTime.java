package WorkWithFile;

public class MyTime {
    private int hour;
    private int minute;


    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public MyTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public String toString() {
        return "MyTime{" +
                "hour=" + hour +
                ", minute=" + minute +
                '}';
    }

}
