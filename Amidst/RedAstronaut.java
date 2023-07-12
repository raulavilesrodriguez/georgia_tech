import java.util.Arrays;

public class RedAstronaut extends Player{
    private String skill;
    public static final int DEFAUL_susLevel = 15;
    public static final String DEFAULT_skill = "experienced";

    /*Constructor methods*/
    public RedAstronaut(String name, int susLevel, String skill){
        super(name, susLevel);
        this.skill = skill;
    }
    public RedAstronaut(String name){
        super(name, DEFAUL_susLevel);
        this.skill = DEFAULT_skill;
    }

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

    
    /** 
     * @param p the other player
     */
    void freeze(Player p){
        if (this instanceof Impostor && p instanceof Impostor){
            return;
        } else if (this instanceof Impostor && this.isFrozen()){
            return;
        } else if (p instanceof Impostor || p.isFrozen()){
            return;
        } else {
            if(this.compareTo(p)<0){
            p.setFrozen(true);
            } else {
            int newSusLevel = this.getSusLevel() * 2;
            this.setSusLevel(newSusLevel);
            }
        }
        this.gameOver();
    }

    
    /** 
     * @param p other player
     */
    void sabotage(Player p){
        if (this instanceof Impostor && p instanceof Impostor){
            return;
        } else if (this instanceof Impostor && this.isFrozen()){
            return;
        } else if (p.isFrozen()){
            return;
        } else {
            if (this.getSusLevel() < 20){
                double newSusLevel = p.getSusLevel() * 1.50;
                int intSusLevel = (int) newSusLevel;
                p.setSusLevel(intSusLevel);
            } else {
                double newSusLevel = p.getSusLevel() * 1.25;
                int intSusLevel = (int) newSusLevel;
                p.setSusLevel(intSusLevel);
            }
        }
    }

    
    /** 
     * @param o
     * @return boolean
     */
    public boolean equals(Object o){
        if (o instanceof RedAstronaut) {
            RedAstronaut player = (RedAstronaut) o;
            return this.getName().equals(player.getName()) && this.isFrozen() == player.isFrozen()
                    && this.getSusLevel() == player.getSusLevel() && this.skill == player.skill;
        }
        return false;
    }

    
    /** 
     * @return String
     */
    public String toString(){
        String string = this.toString() + " I am an " + this.skill + " player";
        if (this.getSusLevel() <= 15){
            return string;
        } else {
            return string.toUpperCase();
        }
    }

    
    /** 
     * @return String
     */
    public String getSkill (){
        return skill;
    }

    
    /** 
     * @param skill set
     */
    public void setSkill (String skill){
        this.skill = skill;
    }

}
