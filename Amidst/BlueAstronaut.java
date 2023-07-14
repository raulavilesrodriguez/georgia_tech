import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate{
    private int numTasks;
    private int taskSpeed;
    private static final int DEFAULT_susLevel = 15;
    private static final int DEFAULT_numTasks = 6;
    private static final int DEFAULT_taskSpeed = 10;

    /*Constructor methods*/
    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed){
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed > 0 ? taskSpeed : 1;
    }

    public BlueAstronaut(String name){
        super(name, DEFAULT_susLevel);
        this.numTasks = DEFAULT_numTasks;
        this.taskSpeed = DEFAULT_taskSpeed;
    }

    /*Methods*/
    void emergencyMeeting(){
        if (this.isFrozen()){
            return;
        }else {
            Player [] players = getPlayers();
            Player [] temp = new Player[players.length];
            int size = 0;
            for (Player player : players){
                if(!player.isFrozen()){
                    temp[size++] = player;
                }
            }
            Player [] filterPlayers = size == players.length ? players : Arrays.copyOf(temp, size);
            Arrays.sort(filterPlayers);
            if(!this.equals(filterPlayers[filterPlayers.length-1]) &&
            filterPlayers[filterPlayers.length-1].compareTo(filterPlayers[filterPlayers.length-2])!=0){
                for (Player player : players){
                    if (player.equals(filterPlayers[filterPlayers.length-1])){
                        player.setFrozen(true);
                        this.gameOver();
                    }
                }
            }
        }
    }

    public void completeTask(){
        if(this.isFrozen()){
            return;
        } else {
            if(this.taskSpeed > 20){
                this.numTasks -= 2;
            } else {
                this.numTasks -= 1;
            }
            if(this.numTasks < 0) {this.numTasks = 0;}
            if(this.numTasks == 0){
                System.out.println("I have completed all my tasks");
                double newSusLevel = this.getSusLevel() * 0.5;
                this.setSusLevel((int) newSusLevel);
                return;
            }
        }
    }

    public boolean equals(Object o){
        if (o instanceof BlueAstronaut) {
            BlueAstronaut player = (BlueAstronaut) o;
            return this.getName().equals(player.getName()) && this.isFrozen() == player.isFrozen()
                    && this.getSusLevel() == player.getSusLevel() && this.numTasks == player.numTasks
                    && this.taskSpeed == player.taskSpeed;
        }
        return false;
    }

    @Override
    public String toString(){
        String string = super.toString() + " I have " + this.numTasks + " left over.";
        if (this.getSusLevel() <= 15){
            return string;
        } else {
            return string.toUpperCase();
        }
    }

    public void setNumTasks(int numTasks){
        this.numTasks = numTasks;
    }

    public int getNumTasks(){
        return numTasks;
    }

    /**
     * how to declare a variable positive, non zero integer number in java
     * https://stackoverflow.com/questions/28423350/how-do-i-keep-an-int-variable-positive-or-0-in-java
     */
    public void setTaskSpeed(int taskSpeed){
        this.taskSpeed = taskSpeed > 0 ? taskSpeed : 1;
    }

    public int getTaskSpeed(){
        return taskSpeed;
    }

}
