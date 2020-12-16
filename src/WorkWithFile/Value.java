package WorkWithFile;

public class Value {

    private String low;
    private String high;
    private String open;
    private String close;

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public Value(String low, String high, String open, String close) {
        this.low = low;
        this.high = high;
        this.open = open;
        this.close = close;
    }
}
