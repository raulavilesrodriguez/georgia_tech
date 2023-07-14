public class Gameplay {
    
    public static void main(String[] args){
        BlueAstronaut BobBlue = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut HeathBlue = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut AlbertBlue = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut AngelBlue = new BlueAstronaut("Angel", 0, 1, 0);

        RedAstronaut LiamRed = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut SuspiciousRed = new RedAstronaut("Suspicious Person", 100, "expert");

        LiamRed.sabotage(BobBlue);
        System.out.println(BobBlue.toString());
    }
}
