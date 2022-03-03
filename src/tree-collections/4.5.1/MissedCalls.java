import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {
    private Map<LocalDateTime, String> missedCalls = new TreeMap<>();

    public void addMissedCalls(String phoneNumber){
        missedCalls.put(LocalDateTime.now(), phoneNumber);
    }

    public Map<LocalDateTime, String> getMissedCalls() {
        return missedCalls;
    }

    public void printMissedCalls(PhoneBook2 phoneBook){
        for (Map.Entry<LocalDateTime, String> entryMissedCalls: missedCalls.entrySet()) {
            String nameContact = phoneBook.findContactByPhoneNumber(entryMissedCalls.getValue());
            if (nameContact == null) nameContact = entryMissedCalls.getValue();
            System.out.println("Пропущенный звонок в " + entryMissedCalls.getKey().toString() + " от " + nameContact);
        }
    }
}
