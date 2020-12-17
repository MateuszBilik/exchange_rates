package WorkWithFile;


public class DataForOneMinute {

    private MyDate date;
    private MyTime time;
    private MyValue value;

//    public Integer getOneFromDay (String type, int year, int month, int day) {
//
//
//        switch (type) {
//            case "open":
//
//            case "high":
//
//            case "low":
//
//            case "close":
//
//        }
//
//    }









    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public MyTime getTime() {
        return time;
    }

    public void setTime(MyTime time) {
        this.time = time;
    }

    public MyValue getValue() {
        return value;
    }

    public void setValue(MyValue value) {
        this.value = value;
    }

    public DataForOneMinute(MyDate date, MyTime time, MyValue value) {
        this.date = date;
        this.time = time;
        this.value = value;
    }

    @Override
    public String toString() {
        return "FileOneLine{" +
                "date=" + date +
                ", time=" + time +
                ", value=" + value +
                '}';
    }
}
