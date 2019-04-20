package responsibility;

/**
 * 一个请假请求
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/19 16:38
 */
public class RequestForLeave {
    private String name;
    private String reason;
    private int days;

    public RequestForLeave(String name, String reason, int days) {
        this.name = name;
        this.reason = reason;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
