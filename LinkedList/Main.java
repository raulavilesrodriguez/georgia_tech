public class Main {
    public static void main(String[] args){
        LinkedList <String> lista = new LinkedList < > ();
        lista.add("angela");
        lista.add("chita");
        lista.add("foca");
        System.out.println(lista.toString());

        // check addAtIndex method
        lista.addAtIndex("picara", 2);
        System.out.println(lista.toString());
        System.out.println("Size: " + lista.size());

        // check getAtIndex method
        System.out.println("GET INDEX: " + lista.getAtIndex(3));

        // check removeAtIndex method
        System.out.println("REMOVED INDEX: " + lista.removeAtIndex(3));
        System.out.println(lista.toString());

        // check remove method
        lista.add("cachorrita");
        System.out.println(lista.toString());
        System.out.println("REMOVED: " + lista.remove("cachorrita"));
        System.out.println(lista.toString());

        // check clear method
        System.out.println("IS EMPTY: " + lista.isEmpty());
        System.out.println("HEAD: " + lista.getHead().getData());
        System.out.println("TAIL: " + lista.getTail().getData());
        lista.clear();
        System.out.println("CLEAR ALL: " + lista.toString());
        System.out.println("IS EMPTY: " + lista.isEmpty());
        //System.out.println("HEAD: " + lista.getHead().getData());
        //System.out.println("TAIL: " + lista.getTail());
        System.out.println("Size: " + lista.size());

        LinkedList <Integer> listaNum = new LinkedList <Integer> ();
        listaNum.add(1);
        listaNum.add(2);
        listaNum.add(6);
        System.out.println(listaNum.toString());

        // check addAtIndex method
        listaNum.addAtIndex(89, 2);
        System.out.println(listaNum.toString());
        System.out.println("Size: " + listaNum.size());

        // check getAtIndex method
        System.out.println("GET INDEX: " + listaNum.getAtIndex(3));

        // check removeAtIndex method
        System.out.println("REMOVED INDEX: " + listaNum.removeAtIndex(3));
        System.out.println(listaNum.toString());

        // check remove method
        listaNum.add(69);
        System.out.println(listaNum.toString());
        System.out.println("REMOVED: " + listaNum.remove(69));
        System.out.println(listaNum.toString());

        // check clear method
        System.out.println("IS EMPTY: " + listaNum.isEmpty());
        System.out.println("HEAD: " + listaNum.getHead().getData());
        System.out.println("TAIL: " + listaNum.getTail().getData());
        listaNum.clear();
        System.out.println("CLEAR ALL: " + listaNum.toString());
        System.out.println("IS EMPTY: " + listaNum.isEmpty());
        //System.out.println("HEAD: " + listaNum.getHead().getData());
        //System.out.println("TAIL: " + listaNum.getTail().getData());
        System.out.println("Size: " + listaNum.size());

    }
}
