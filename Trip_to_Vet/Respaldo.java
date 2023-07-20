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
    private double health;
    private int painLevel;

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
            String result = null;

            while(fileScan.hasNextLine()){
                line = fileScan.nextLine();
                tokens = line.split(",");
                String string = "Consultation for " + tokens[0] + 
                " the " + tokens[1] + " at " + tokens[3] + 
                ".\nWhat is the health of " + tokens[0] + "?\n";
                System.out.println(string);
                
                if(!tokens[1].contains("Dog")){
                    if(!tokens[1].contains("Cat")){
                        fileScan.close();
                        throw new InvalidPetException();
                    }
                }
                
                boolean success = false;
                Scanner input = new Scanner(System.in);
                while(!success){
                    try{
                        health = input.nextDouble();
                        success = true;
                    } catch(InputMismatchException e){
                        input.nextLine();
                        System.out.println("Sorry, that was not an number decimal");
                        System.out.println("Please try again");
                    }
                }
                
                System.out.println("On a scale of 1 to 10, how much pain is " + tokens[0] + " in right now?\n");
                success = false;
                while(!success){
                    try{
                        painLevel = input.nextInt();
                        success = true;
                    } catch(InputMismatchException e){
                        input.nextLine();
                        System.out.println("Sorry, that was not an int");
                        System.out.println("Please try again");
                    }
                }
                input.close();

                if(tokens[1]=="Cat"){
                    Cat cat = new Cat(tokens[0], health, painLevel);
                    cat.speak();
                    int treatmentTime = cat.treat();
                    String timeOut = addTime(tokens[3], treatmentTime);
                    String x = tokens[0] + "," + tokens[1] + "," + tokens[2] + "," +
                    String.valueOf(day) + "," + tokens[3] + "," + timeOut + "," +
                    String.valueOf(cat.getHealth()) + "," + String.valueOf(cat.getPainLevel()) + "\n";
                    result = result.concat(x);            
                } else if (tokens[1] == "Dog"){
                    Dog dog = new Dog(tokens[0], health, painLevel);
                    dog.speak();
                    int treatmentTime = dog.treat();
                    String timeOut = addTime(tokens[3], treatmentTime);
                    String x = tokens[0] + "," + tokens[1] + "," + tokens[2] + "," +
                    String.valueOf(day) + "," + tokens[3] + "," + timeOut + "," +
                    String.valueOf(dog.getHealth()) + "," + String.valueOf(dog.getPainLevel()) + "\n";
                    result = result.concat(x); 
                }
                tokens = null;
                
            }
            day++;
            fileScan.close();
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

