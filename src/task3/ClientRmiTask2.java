package task3;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;

public class ClientRmiTask2 {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry();
            EventManagement stub = (EventManagement) registry.lookup("EventManagement");

            // Example: Add a new event
            Event event = new Event("Meeting", LocalDateTime.now(), "Work", false, LocalDateTime.now().plusHours(1));
            stub.addEvent(event);

            // Example: Get all events
            System.out.println("All events:");
            stub.getAllEvents().forEach(System.out::println);

            // Example: Delete an event
            stub.deleteEvent("Meeting");

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
