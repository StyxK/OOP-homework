package personalaccountingsoftware;

import java.util.Date;

public class RecieveItem {
    private String name;
    private double bath;
    private Date date;
    
    public RecieveItem(String name,double bath,Date date){
        this.name = name;
        this.bath = bath;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBath() {
        return bath;
    }

    public void setBath(double bath) {
        this.bath = bath;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
