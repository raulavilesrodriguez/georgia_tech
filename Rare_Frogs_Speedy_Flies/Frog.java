public class Frog extends Pond {
    private String name;
    private int age; // in months
    private double tongueSpeed;
    private boolean isFroglet = true;
    private static String species = "Rare Pepe";
    // Constant
    public static final int AGE_DEFAULT = 5;
    public static final double TONGUESPEED_DEFAULT = 5.0;

    /* Constructor method */
    public Frog(String name, int age, double tongueSpeed){
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
    }

    public Frog(String name, double ageInYears, double tongueSpeed){
        this(name, (int) (ageInYears * 12), tongueSpeed);
    }

    public Frog(String name){
        this(name, AGE_DEFAULT, TONGUESPEED_DEFAULT);
    }

    /* METHODS */
    public void grow(int addMonths){
        age += addMonths;
        if(age < 12){
            int res1 = Math.abs(12 - age);
            for (int i = 0; i <res1; i++){
                tongueSpeed += 1;
            }
        } else if (age == 30){
            if(tongueSpeed > 5.0){
                tongueSpeed -= 1;
            }
        } else if (age > 30){
            int res2 = Math.abs(30 - age);
            for (int i = 0; i <res2; i++){
                if(tongueSpeed > 5.0){
                    tongueSpeed -= 1;
                }
            }
        }
        if(age > 1 && age < 7){
            this.isFroglet = true;
        } else {
            this.isFroglet = false;
        }
        
    }

    public void grow(){
        age += 1;
        if(age < 12){
            int res1 = Math.abs(12 - age);
            for (int i = 0; i <res1; i++){
                tongueSpeed += 1;
            }
        } else if (age == 30){
            if(tongueSpeed > 5.0){
                tongueSpeed -= 1;
            }
        } else if (age > 30){
            int res2 = Math.abs(30 - age);
            for (int i = 0; i <res2; i++){
                if(tongueSpeed > 5.0){
                    tongueSpeed -= 1;
                }
            }
        }
        if(age > 1 && age < 7){
            this.isFroglet = true;
        } else {
            this.isFroglet = false;
        }
    }

    public void eat(Fly fly){
        if (fly.isDead()){return;}
        if (tongueSpeed > fly.getSpeed()){
            if(fly.getMass()/age >= 0.5){
                grow();
            }
            fly.setMass(0);
        } else {
            fly.grow(1);
        }
    }

    public String toString(){
        if(isFroglet){
            return "My name is " + name + 
            " and I\u0027m a rare froglet! I\u0027m " + age + 
            " months old and my tongue has a speed of " + tongueSpeed;
        } else {
            return "My name is" + name + 
            " and I\u0027m a rare frog. I\u0027m " + age + 
            " months old and my tongue has a speed of " + tongueSpeed;
        }
    }

    // Setter and getter for species
    public void setSpecies(String speciesName){species = speciesName;}
    public String getSpecies(){return species;}

}