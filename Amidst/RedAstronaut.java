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

    void freeze(Player p){
        if (p instanceof Impostor || p.isFrozen()){
            return;
        }

    }

}
