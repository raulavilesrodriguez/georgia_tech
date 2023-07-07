public class Fly extends Pond {
    // Constant to define mass and speed
    public static final double MASS_DEFAULT = 5.0;
    public static final double SPEED_DEFAULT = 10.0;

    private double mass;
    private double speed;
    
    /* Constructor method */
    public Fly (double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    public Fly (double mass){
        this(mass, SPEED_DEFAULT);
    }

    public Fly (){
        this(MASS_DEFAULT, SPEED_DEFAULT);
    }

    /* METHODS */
    // Setters and Getters
    public void setMass(double mass){this.mass = mass;}
    public double getMass(){return mass;}

    public void setSpeed(double speed){this.speed = speed;}
    public double getSpeed(){return speed;}
   
    public String toString(){
        if (mass == 0){
            return "I\u0027m dead, but I used to be a fly with a speed of " + String.format("%.2f", speed);
        } else {
            return "I\u0027m a speedy fly with " + String.format("%.2f", speed) + " speed and " + String.format("%.2f", mass) + " mass.";
        }        
    }
    
    public void grow(int addedMass){
        mass += addedMass;
        int res = Math.abs(20 - (int) mass);
		if(mass < 20.0){
            while(res > 0){
                speed += 1;
                res--;
            }
		} else if(mass == 20.0) {
			speed -= 0.5;
		} else if (mass > 20.0){
            while(res > 0){
                speed -= 0.5;
                res--;
            }
        }
    }

    public boolean isDead(){
        if(mass == 0.0){
            return true;
        } else {
            return false;
        }
    }

}
