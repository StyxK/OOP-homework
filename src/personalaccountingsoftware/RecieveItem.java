package personalaccountingsoftware;

public class RecieveItem {
    private String name;
    private double bath;
    private String date;
    
    public RecieveItem(String name,double bath,String date){
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
