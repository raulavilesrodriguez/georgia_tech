import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Clinic {
    private File patientFile;
    private int day;

    /*Constructor methods*/
    public Clinic(File file){
        this.patientFile = file;
        this.day = 1;
    }
    public Clinic(String fileName){
        this(new File(fileName));
    }

    /*Methods*/
    public String nextDay(File f) throws FileNotFoundException{
            Scanner fileScan = new Scanner(f);
            String [] tokens = null;
            String line = null;
            ArrayList<String> appointments = new ArrayList<>();
            String result = "Arechito,Dog,9.6,Day 3,6699,5599,0.5,5";

            while(fileScan.hasNextLine()){
                line = fileScan.nextLine();
                appointments.add(line);
            }
            fileScan.close();

            Scanner input = new Scanner(System.in);
            for (String appintment : appointments){
                tokens = appintment.split(",");

                // input health value
                String string = "Consultation for " + tokens[0] + 
                " the " + tokens[1] + " at " + tokens[3] + 
                ".\nWhat is the health of " + tokens[0] + "?";
                System.out.println(string);
                
                if(!tokens[1].contains("Dog")){
                    if(!tokens[1].contains("Cat")){
                        input.close();
                        throw new InvalidPetException();
                    }
                }

                boolean success = false;
                String stringout1;
                double healthNew = 0.0;
                while(!success){
                    try{
                        stringout1 = input.nextLine();
                        healthNew = Double.parseDouble(stringout1);
                        success = true;
                    } catch(NumberFormatException e){
                        System.out.println("Sorry, that was not an number decimal");
                    }
                }

                // input painLevel value
                success = false;
                System.out.println("On a scale of 1 to 10, how much pain is " + tokens[0] + " in right now?");
                String stringout2;
                int painLevelNew = 0;
                while(!success){
                    try{
                        stringout2 = input.nextLine();
                        painLevelNew = Integer.parseInt(stringout2);
                        success = true;
                    } catch(NumberFormatException e){
                        System.out.println("Sorry, that was not an number decimal");
                        System.out.println("Please try again");
                    }
                }

                System.out.println(healthNew);
                System.out.println(painLevelNew);
            }

            this.day++;
            input.close();
            return result;
    }


    public String nextDay(String fileName) throws FileNotFoundException{
        File f = new File(fileName);
        return nextDay(f);
    }

    public boolean addToFile(String patientInfo){
        ArrayList<String> patients = new ArrayList<>();
        String line = null;
        String [] tokensPatient = null;
        try{
            Scanner fileScan = new Scanner(patientFile);
            while(fileScan.hasNextLine()){
                line = fileScan.nextLine();
                patients.add(line);
            }
            fileScan.close();
        }  catch (IOException e){
            System.out.println(e.getMessage());
            return false;
        }
        PrintWriter filePrint = null;
        tokensPatient = patientInfo.split(",");
        boolean flag = false;
        try {
            filePrint = new PrintWriter(patientFile);
            for (String patient : patients){
                if(patient.contains(tokensPatient[0])){
                    flag = true;
                    String x = tokensPatient[0] + "," + tokensPatient[1] + 
                    "," + tokensPatient[2] + ",";
                    String filtrado = "," + patientInfo.replace(x, "");
                    String patientJoin = patient.concat(filtrado);
                    filePrint.println(patientJoin);
                } else {
                    filePrint.println(patient);
                }
            }
            if(!flag){
                filePrint.println(patientInfo);
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            if (filePrint != null){
                filePrint.close();
            }
        }           
        return true;
    }

    protected String addTime(String timeIn, int treatmentTime){
        int timeOut = Integer.parseInt(timeIn) + treatmentTime;
        return String.valueOf(timeOut);
    }


}
