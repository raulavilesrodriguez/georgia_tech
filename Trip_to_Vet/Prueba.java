import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Scanner;

public class Prueba {
    
    public static void main(String[] args){
        ArrayList<String> patients = new ArrayList<>();
        String [] tokensPatient = null;

        patients.add("Freckles,Cat,5,Day 2,1243,1249,0.68,4");
        patients.add("Spots,Dog,6.6,Day 1,1713,1727,0.7,10,Day 3,1240,1245,0.8,4");

        //String x = "Spots,Dog,6.6,Day 1,1713,1727,0.7,10,Day 3,1240,1245,0.8,4";
        String retval = "Spots,Cat,84,Day 2,1655, 1700,0.4,4";
        tokensPatient = retval.split(",");

        System.out.println("Array:" + patients);
        for(String patient: patients){
            System.out.println(patient);
            if (patient.contains(tokensPatient[0])){
                System.out.println("holaa");
            } else {
                System.out.println("not WORK");
            }
        }

        String stringput;
        boolean isValid = false;
        double numD = 0.0;
        Scanner userInput = new Scanner(System.in);
        while (isValid == false){
            System.out.print("Enter an float value: ");
            stringput = userInput.nextLine();
            try {
             numD = Double.parseDouble(stringput);
             isValid = true;
            } catch (NumberFormatException e) {
             System.out.println("not number float especified ji");
            }
         }

         System.out.println(numD);

         userInput.close();  

    }
}
