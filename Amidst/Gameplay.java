public class Gameplay {
    
    public static void main(String[] args){
        BlueAstronaut BobBlue = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut HeathBlue = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut AlbertBlue = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut AngelBlue = new BlueAstronaut("Angel", 0, 1, 0);

        RedAstronaut LiamRed = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut SuspiciousRed = new RedAstronaut("Suspicious Person", 100, "expert");

        // 1
        System.out.println("Q1");
        LiamRed.sabotage(BobBlue);
        System.out.println(BobBlue.toString());
        // 2
        System.out.println("Q2");
        LiamRed.freeze(SuspiciousRed);
        System.out.println(SuspiciousRed.toString());
        // 3
        System.out.println("Q3");
        LiamRed.freeze(AlbertBlue);
        System.out.println(LiamRed.toString());
        System.out.println(AlbertBlue.toString());
        // 4
        System.out.println("Q4");
        AlbertBlue.emergencyMeeting();
        System.out.println(AlbertBlue.gameOver());
        // 5
        System.out.println("Q5");
        SuspiciousRed.emergencyMeeting();
        System.out.println(BobBlue.toString());
        System.out.println(HeathBlue.toString());
        System.out.println(BobBlue.gameOver());
        // 6
        System.out.println("Q6");
        BobBlue.emergencyMeeting();
        System.out.println(SuspiciousRed.toString());
        System.out.println(BobBlue.gameOver());
        // 7
        System.out.println("Q7");
        HeathBlue.completeTask();
        System.out.println(HeathBlue.toString());
        // 8
        System.out.println("Q8");
        HeathBlue.completeTask();
        System.out.println(HeathBlue.toString());
        // 9
        System.out.println("Q9");
        HeathBlue.completeTask();
        // 10
        System.out.println("Q10");
        LiamRed.freeze(AngelBlue);
        System.out.println(AngelBlue.toString());
        System.out.println(LiamRed.toString());
        // 11
        System.out.println("Q11");
        System.out.println(BobBlue.toString());
        LiamRed.sabotage(BobBlue);
        System.out.println(BobBlue.toString());
        LiamRed.sabotage(BobBlue);
        System.out.println(BobBlue.toString());
        // 12
        System.out.println("Q12");
        LiamRed.freeze(BobBlue);
        System.out.println(BobBlue.toString());
        // 13 Here “Crewmates win!”
        //System.out.println("Q13");
        //AngelBlue.emergencyMeeting();
        //System.out.println(LiamRed.toString());
        // 14 Here “Impostors win!”
        System.out.println("Q14");
        System.out.println(HeathBlue.toString());
        LiamRed.sabotage(HeathBlue);
        System.out.println(HeathBlue.toString());
        LiamRed.sabotage(HeathBlue);
        System.out.println(HeathBlue.toString());
        LiamRed.sabotage(HeathBlue);
        System.out.println(HeathBlue.toString());
        LiamRed.sabotage(HeathBlue);
        System.out.println(HeathBlue.toString());
        LiamRed.sabotage(HeathBlue);
        System.out.println(HeathBlue.toString());
        // 15
        LiamRed.freeze(HeathBlue);
        System.out.println(HeathBlue.toString());

    }
}
