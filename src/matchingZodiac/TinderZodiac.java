package matchingZodiac;

import java.util.Scanner;

public class TinderZodiac {
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Person me = null;
        Person crush = null;
        System.out.println("Enter your name and birthdate in format : Name Lastname;dd/mm/yyyy");
        me = new Person(sc.nextLine());
        while(true){
            int[] loves = new int[]{0,0,0,0,0};
            //====== find loves from me ======
            int[] findMyName = findLove(me.getName());
            for(int i=0;i<findMyName.length;i++){
                loves[i] += findMyName[i];
            }
            int[] findMyLastName = findLove(me.getLastName());
            for(int i=0;i<findMyLastName.length;i++){
                loves[i] += findMyLastName[i];
            }
            //=================================
            
            System.out.println("Enter name and birthdate of your lover in format : Name Lastname;dd/mm/yyyy");
            crush = new Person(sc.nextLine());
            //====== find loves from crush ====
            int[] findCrushName = findLove(crush.getName());
            for(int i=0;i<findCrushName.length;i++){
                loves[i] += findCrushName[i];
            }
            int[] findCrushLastName = findLove(crush.getLastName());
            for(int i=0;i<findCrushLastName.length;i++){
                loves[i] += findCrushLastName[i];
            }
            //=================================
            int LO = loves[0]+loves[1];
            int OV = loves[1]+loves[2];
            int VE = loves[2]+loves[3];
            int ES = loves[3]+loves[4];
            int LOOV = LO+OV;
            int OVVE = OV+VE;
            int VEES = VE+ES;
            int first = LOOV+OVVE;
            int second = OVVE+VEES;
            if(first >= 10 || second >= 10){
                System.out.println("The love percentage is: "+(first+second)+"%");
            }
            else{
                System.out.println("The love percentage is: "+first+second+"%");
            }
            
            if(compatZodiac(me.getZodiac(),crush.getZodiac()))
                System.out.println("The zodiac compatibility is: Good");
            else
                System.out.println("The zodiac compatibility is: Bad");
            
            //==========================
            System.out.println("Want to calculate your love with another person? (Y/N)");
            String command = sc.next();
            if(command.equalsIgnoreCase("N")) System.exit(0);
            //==========================
        }
        //Brad Pitt;12/2/1978
        //Angelina Jolie;19/5/1977
        //Nicole Kidman;20/6/1976
    }
    
    public static int[] findLove(String name){
        int l = 0;
        int o = 0;
        int v = 0;
        int e = 0;
        int s = 0;
        for(String alphabet:name.split("")){
            if(alphabet.equalsIgnoreCase("l")) l++;
            else if(alphabet.equalsIgnoreCase("o")) o++;
            else if(alphabet.equalsIgnoreCase("v")) v++;
            else if(alphabet.equalsIgnoreCase("e")) e++;
            else if(alphabet.equalsIgnoreCase("s")) s++;
        }
        return new int[]{l,o,v,e,s};
    }
    
    public static boolean compatZodiac(String myZodiac,String crushZodiac){
        if(myZodiac.equals("CAPRICORNUS")){
            if(crushZodiac.equals("CANCER")||crushZodiac.equals("LEO")) return false;
            else return true;
        }
        if(myZodiac.equals("AQUARIUS")){
            if(crushZodiac.equals("CANCER")||crushZodiac.equals("LEO")||crushZodiac.equals("SCORPIO")) return false;
            else return true;
        }
        if(myZodiac.equals("PISCES")){
            if(crushZodiac.equals("LEO")||crushZodiac.equals("LIBRA")||crushZodiac.equals("AQUARIUS")) return false;
            else return true;
        }
        if(myZodiac.equals("ARIES")){
            if(crushZodiac.equals("CANCER")||crushZodiac.equals("VIRGO")) return false;
            else return true;
        }
        if(myZodiac.equals("TAURUS")){
            if(crushZodiac.equals("LEO")||crushZodiac.equals("LIBRA")) return false;
            else return true;
        }
        if(myZodiac.equals("GEMINI")){
            if(crushZodiac.equals("GEMINI")||crushZodiac.equals("CANCER")||crushZodiac.equals("SCORPIO")) return false;
            else return true;
        }
        if(myZodiac.equals("CANCER")){
            if(crushZodiac.equals("ARIES")||crushZodiac.equals("AQUARIUS")||crushZodiac.equals("SAGITARIUS")) return false;
            else return true;
        }
        if(myZodiac.equals("LEO")){
            if(crushZodiac.equals("TAURUS")||crushZodiac.equals("CAPRICORNUS")) return false;
            else return true;
        }
        if(myZodiac.equals("VIRGO")){
            if(crushZodiac.equals("ARIES")||crushZodiac.equals("LIBRA")) return false;
            else return true;
        }
        if(myZodiac.equals("LIBRA")){
            if(crushZodiac.equals("VIRGO")||crushZodiac.equals("TAURUS")||crushZodiac.equals("PISCES")) return false;
            else return true;
        }
        if(myZodiac.equals("SCORPIO")){
            if(crushZodiac.equals("AQUARIUS")||crushZodiac.equals("GEMINI")||crushZodiac.equals("LEO")) return false;
            else return true;
        }
        if(myZodiac.equals("SAGITARIUS")){
            if(crushZodiac.equals("CANCER")) return false;
            else return true;
        }
        else return true;
    }
    
}
