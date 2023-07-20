public class Cat extends Pet{
    private int miceCaught;
    private static final int DEFAULT_miceCaught = 0;

    /*Constructor methods*/
    public Cat(String name, double health, int painLevel, int miceCaught){
        super(name, health, painLevel);
        this.miceCaught = miceCaught < 0 ? 0 : miceCaught;
    }
    public Cat(String name, double health, int painLevel){
        super(name, health, painLevel);
        this.miceCaught = DEFAULT_miceCaught;
    }

    /*Methods*/
    int treat(){
        this.heal();
        if(this.miceCaught < 4){
            return (int) Math.ceil(this.getPainLevel() * 2 / this.getHealth());
        } else if (this.miceCaught >= 4 && this.miceCaught <= 7){
            return (int) Math.ceil(this.getPainLevel() / this.getHealth());
        } else if (this.miceCaught > 7){
            return (int) Math.ceil(this.getPainLevel() / (this.getHealth() * 2));
        }

        return (int) Math.ceil(this.getPainLevel() / (this.getHealth() * 2));
    }

    public void speak(){
        this.speak();
        String meow = "meow ";
        for (int i = 0; i < this.miceCaught; i++){
            if(this.getPainLevel() > 5){
                System.out.print(meow.toUpperCase());
            } else {
                System.out.print(meow);
            }
        }
    }

    public boolean equals(Object o){
        if (o instanceof Cat){
            Cat pet = (Cat) o;
            return this.equals(pet) && this.miceCaught == pet.miceCaught;
        }
        return false;
    }

    public int getMiceCaught(){
        return miceCaught;
    }

    public void setMiceCaught(int miceCaught){
        this.miceCaught = miceCaught;
    }
    
}
