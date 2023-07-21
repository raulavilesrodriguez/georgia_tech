import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileWriter;  //similar to PrintWriter
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Clinic {
    private File patientFile;
    private int day = 1;

    /*Constructor methods*/
    public Clinic(File file){
        this.patientFile = file;
    }
    public Clinic(String fileName){
        this(new File(fileName));
    }

    
    /** 
     * @param f is the appointments file
     * @return String of patients
     * @throws FileNotFoundException
     */
    /*Methods*/
    public String nextDay(File f) throws FileNotFoundException{
            Scanner fileScan = new Scanner(f);
            String [] tokens = null;
            String line = null;
            ArrayList<String> appointments = new ArrayList<>();
            String result = "";

            while(fileScan.hasNextLine()){
                line = fileScan.nextLine();
                appointments.add(line);
            }
            fileScan.close();

            // Array of patients
            ArrayList<String> patients = new ArrayList<>();
            Scanner patientScan = new Scanner(patientFile);
            while(patientScan.hasNextLine()){
                line = patientScan.nextLine();
                patients.add(line);
            }
            patientScan.close();

            Scanner input = new Scanner(System.in);
            for (String appintment : appointments){
                tokens = appintment.split(",");

                // input health value
                String string = "\nConsultation for " + tokens[0] + 
                " the " + tokens[1] + " at " + tokens[3] + 
                ".\nWhat is the health of " + tokens[0] + "?";
                System.out.println(string);

                // trow Invalid Pet Exception
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
                        if (healthNew < 0.0 || healthNew > 1.0){
                            throw new InputMismatchException();
                        }
                        success = true;
                    } 
                    catch (NumberFormatException e){
                        // tell that it's not a digit - number
                        System.out.println("Sorry, that was not an number");
                    }
                    catch(InputMismatchException ime){
                        // Range check
                        System.out.println("The number is not between 0 and 1. Try again");
                    } 
                    catch (Exception e){
                        // to catch all other exceptions
                        System.out.println(e.getMessage());
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
                        if(painLevelNew < 1 || painLevelNew > 10){
                            throw new InputMismatchException();
                        }
                        success = true;
                    } 
                    catch (NumberFormatException e){
                        // tell that it's not a digit - number
                        System.out.println("Sorry, that was not an number integer");
                    }
                    catch(InputMismatchException ime){
                        // Range check
                        System.out.println("The number is not between 1 and 10. Try again");
                    } 
                    catch (Exception e){
                        // to catch all other exceptions
                        System.out.println(e.getMessage());
                    }
                }

                // obtain DAY value
                    int strLastIndex = 0;
                    for (String patient : patients){
                        if (patient.contains(tokens[0])){
                            strLastIndex = patient.lastIndexOf('y');
                            char we = patient.charAt(strLastIndex+2);
                            day = Integer.parseInt(String.valueOf(we)) + 1;
                        } 
                    }

                if(tokens[1].contains("Cat")){
                    Cat cat = new Cat(tokens[0], healthNew, painLevelNew, Integer.parseInt(tokens[2]));
                    cat.speak();
                    int treatmentTime = cat.treat();
                    String timeOut = addTime(tokens[3], treatmentTime);
                    
                    String x = tokens[0] + "," + tokens[1] + "," + tokens[2] + "," +
                    "Day " + day + "," + tokens[3] + "," + timeOut + "," +
                    healthNew + "," + painLevelNew + "\n";
                    result = result + x;            
                } else if (tokens[1].contains("Dog")){
                    Dog dog = new Dog(tokens[0], healthNew, painLevelNew, Double.parseDouble(tokens[2]));
                    dog.speak();
                    int treatmentTime = dog.treat();
                    String timeOut = addTime(tokens[3], treatmentTime);
                    String x = tokens[0] + "," + tokens[1] + "," + tokens[2] + "," +
                    "Day " + day + "," + tokens[3] + "," + timeOut + "," +
                    healthNew + "," + painLevelNew + "\n";
                    result = result + x; 
                }
            }

            input.close();
            //System.out.println("\n" + result);
            return result;
    }


    
    /** 
     * @param fileName the appointments name file
     * @return String
     * @throws FileNotFoundException
     */
    public String nextDay(String fileName) throws FileNotFoundException{
        File f = new File(fileName);
        return nextDay(f);
    }

    
    /** 
     * @param patientInfo is the information of one patient
     * @return boolean
     */
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
