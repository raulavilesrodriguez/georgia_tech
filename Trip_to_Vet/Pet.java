public abstract class Pet {
    private String name;
    private double health;
    private int painLevel;

    /*Constructor methods*/
    public Pet(String name, double health, int painLevel){
        this.name = name;
        this.health = health > 1.0 ? 1.0 : health < 0.0 ? 0.0 : health;
        this.painLevel = painLevel > 10 ? 10 : painLevel < 1 ? 1 : painLevel;
    }

    /*Methods*/
    /**
     * Should be an abstract method that returns the time taken (in minutes) to treat the pet
     */
    abstract int treat();

    public void speak(){
        String string = "Hello! My name is %s" + name;
        if(painLevel > 5){
            System.out.println(string.toUpperCase());
        }else{
            System.out.println(string);
        }
    }

    public boolean equals(Object o){
        if (o instanceof Pet){
            Pet pet = (Pet) o;
            return this.name.equals(pet.name);
        }
        return false;
    }

    protected void heal(){
        this.health = 1.0;
        this.painLevel = 1;
    }

    // geters and seters
    public String getName(){
        return name;
    }

    public void setHealth(double health){
        this.health = health > 1.0 ? 1.0 : health < 0.0 ? 0.0 : health;
    }

    public double getHealth(){
        return health;
    }

    public int getPainLevel(){
        return painLevel;
    }

    public void setPainLevel(int painLevel){
        this.painLevel = painLevel > 10 ? 10 : painLevel < 1 ? 1 : painLevel;
    }

    
}
