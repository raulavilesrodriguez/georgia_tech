public class Dog extends Pet{
    private double droolRate;
    private static final double DEFAULT_droolRate = 5.0; 

    /*Constructor methods*/
    public Dog(String name, double health, int painLevel, double droolRate){
        super(name, health, painLevel);
        this.droolRate = droolRate <= 0 ? 0.5 : droolRate;
    }
    public Dog(String name, double health, int painLevel){
        super(name, health, painLevel);
        this.droolRate = DEFAULT_droolRate;
    }

    /*Methods*/
    int treat(){
        this.heal();
        if(this.droolRate < 3.5){
            return (int) Math.ceil((this.getPainLevel() * 2) / this.getHealth());
        } else if (this.droolRate >= 3.5 && this.droolRate <= 7.5){
            return (int) Math.ceil(this.getPainLevel()/this.getHealth());
        } else if (this.droolRate > 7.5){
            return (int) Math.ceil(this.getPainLevel() / (this.getHealth() * 2));
        }
        return (int) Math.ceil(this.getPainLevel() / (this.getHealth() * 2));
    }

    public void speak(){
        super.speak();
        String bark = "bark ";
        for (int i = 0; i < this.getPainLevel(); i++){
            if(this.getPainLevel() > 5){
                System.out.print(bark.toUpperCase());
            } else {
                System.out.print(bark);
            }
        }
    }

    public boolean equals(Object o){
        if (o instanceof Dog){
            Dog peti = (Dog) o;
            return this.equals(peti) && this.droolRate == peti.droolRate;
        }
        return false;
    }

    public double getDroolRate(){
        return droolRate;
    }

    public void setDroolRate(double droolRate){
        this.droolRate = droolRate;
    }

}
