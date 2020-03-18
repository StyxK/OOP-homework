package matchingZodiac;

import java.util.Date;

public class Person {
    private String name;
    private String lastName;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private String zodiac;

    public Person(String fullInfo) {
        String[] info = fullInfo.split(";");
        this.name = info[0].split(" ")[0];
        this.lastName = info[0].split(" ")[1];
        this.birthDay = Integer.parseInt(info[1].split("/")[0]);
        this.birthMonth = Integer.parseInt(info[1].split("/")[1]);
        this.birthYear = Integer.parseInt(info[1].split("/")[2]);
        setZodiac();
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public int getBirthYear() {
        return birthYear;
    }
    
    public int getAge(){
        return new Date().getYear() - birthYear;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", lastName=" + lastName + ", birthDay=" + birthDay + ", birthMonth=" + birthMonth + ", birthYear=" + birthYear + '}';
    }
    
    public String getBirthDayBE(){
        return ""+getBirthDay()+getBirthMonth()+(getBirthYear()+543);
    }
    
    public void setZodiac(){
        if(birthDay < 20){
            switch(birthMonth){
                case 1 : this.zodiac = "CAPRICORNUS";break;
                case 2 : this.zodiac = "AQUARIUS";break;
                case 3 : this.zodiac = "PISCES";break;
                case 4 : this.zodiac = "ARIES";break;
                case 5 : this.zodiac = "TAURUS";break;
                case 6 : this.zodiac = "GEMINI";break;
                case 7 : this.zodiac = "CANCER";break;
                case 8 : this.zodiac = "LEO";break;
                case 9 : this.zodiac = "VIRGO";break;
                case 10 : this.zodiac = "LIBRA";break;
                case 11 : this.zodiac = "SCORPIO";break;
                case 12 : this.zodiac = "SAGITARIUS";break;
            }
        }
        else{
            switch(birthMonth){
                case 1 : this.zodiac = "AQUARIUS";break;
                case 2 : this.zodiac = "PISCES";break;
                case 3 : this.zodiac = "ARIES";break;
                case 4 : this.zodiac = "TAURUS";break;
                case 5 : this.zodiac = "GEMINI";break;
                case 6 : this.zodiac = "CANCER";break;
                case 7 : this.zodiac = "LEO";break;
                case 8 : this.zodiac = "VIRGO";break;
                case 9 : this.zodiac = "LIBRA";break;
                case 10 : this.zodiac = "SCORPIO";break;
                case 11 : this.zodiac = "SAGITARIUS";break;
                case 12 : this.zodiac = "CAPRICORNUS";break;
            }
        }
    }
    
    public String getZodiac(){
        return this.zodiac;
    }
  
}
