public class Pond {
    
    public static void main(String[] args){
        Frog Peepo = new Frog("Peepo");
        Frog Pepe = new Frog("Pepe", 10, 15);
        Frog Peepaw = new Frog("Peepaw", 4.6, 5);
        Frog Chito = new Frog("Chito");

        Fly Fly1 = new Fly(1, 3);
        Fly Fly2 = new Fly(6);
        Fly Fly3 = new Fly();

        Peepo.setSpecies("1331 Frogs");
        System.out.println(Peepo.toString());
        System.out.println(Fly2.toString());
        Peepo.grow(8);
        Peepo.eat(Fly2);
        System.out.println(Fly2.toString());
        System.out.println(Peepo.toString());
        System.out.println(Chito.toString());
        Peepaw.grow(4);
        System.out.println(Peepaw.toString());
        System.out.println(Pepe.toString());

        System.out.println(Fly1);
        Chito.eat(Fly1);
        System.out.println(Fly1);

        System.out.println(Fly3);

        System.out.println(Peepo.getSpecies());
        System.out.println(Chito.getSpecies());
    }

}
