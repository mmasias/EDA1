package listas.genericaInterfaz;

public class Marathon {
    private List<Participant> participants;

    public Marathon() {
        participants = new List<Participant>();
    }

    public void addParticipant(Participant participant) {
        participants.insert(participant, -1);
    }

    public List<String> getParticipantNames() {
        final List<String> names = new List<String>();
        Node<Participant> current = participants.getFirst();
        while (current != null) {
            names.insert(current.getData().getName(), -1);
            current = current.getNext();
        }
        return names;
    }

    public Participant getParticipant(String name) {
        Node<Participant> current = participants.getFirst();
        while (current != null) {

            if (current.getData().getName().equals(name)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }
}
