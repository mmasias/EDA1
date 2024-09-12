package listas.genericaInterfaz;

class Ejemplo {

    public static void main(String[] args) {
        
        Participant JohnAppleseed = new Participant("John Appleseed", "United States", null);
        Participant JohnDoe = new Participant("John Doe", "Canada", null);
        Participant JaneDoe = new Participant("Jane Doe", "United Kingdom", null);
        Participant RogerWilco = new Participant("Roger Wilco", "United Kingdom", null);
        
        Marathon marathon = new Marathon();

        marathon.addParticipant(JohnAppleseed);
        marathon.addParticipant(JohnDoe);
        marathon.addParticipant(JaneDoe);
        marathon.addParticipant(RogerWilco);

        Node<String> participant = marathon.getParticipantNames().getFirst();
        while (participant != null) {
            System.out.println(participant.getData());
            participant = participant.getNext();
        }
    }
}
