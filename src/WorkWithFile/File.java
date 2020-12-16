package WorkWithFile;


public class File {

    private Date date;
    private Time time;
    private Value value;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public File(Date date, Time time, Value value) {
        this.date = date;
        this.time = time;
        this.value = value;
    }
}
