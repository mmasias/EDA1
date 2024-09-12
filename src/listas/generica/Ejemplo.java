package listas.generica;

public class Ejemplo {
    public static void main(String[] args) {
        
        GenericList<String> listaDeSobrinos = new GenericList<String>();

        listaDeSobrinos.insertEnd("Juanito");
        listaDeSobrinos.insertEnd("Pepito");
        listaDeSobrinos.insertEnd("Anita");
        listaDeSobrinos.insertEnd("Luisito");

        viewLine(listaDeSobrinos);
        System.out.println("PRIMERO:" + listaDeSobrinos.getFirst().getValue());        
        System.out.println("ULTIMO :" + listaDeSobrinos.getLast().getValue());

        GenericList<Integer> listaDeNumeros = new GenericList<Integer>();

        listaDeNumeros.insertEnd(5);
        listaDeNumeros.insertEnd(6);
        listaDeNumeros.insertEnd(7);
        listaDeNumeros.insertEnd(8);

        viewLine(listaDeNumeros);
        System.out.println("PRIMERO:" + listaDeNumeros.getFirst().getValue());        
        System.out.println("ULTIMO :" + listaDeNumeros.getLast().getValue());

    }

    static void viewLine(GenericList unaLista) {
        Object[] larray = unaLista.listAll();
        System.out.println("LA LISTA" + "-".repeat(18));
        for (Object sobrino : larray){
            System.out.println(sobrino);
        }
        System.out.println("-".repeat(25));
    }
}
