import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook2 {
    private final Set<String> groups = new HashSet<String>();
    private final Map<String, List<Contact2>> mapContacts = new HashMap<>();

    public boolean isANewGroups(String group) {
        return !groups.contains(group);
    }

    public void addGroupContact(String newGroupContact) {
        if (isANewGroups(newGroupContact)) {
            groups.add(newGroupContact);
            mapContacts.put(newGroupContact, new ArrayList<Contact2>());
        } else {
            System.out.println("Такая группа уже была добавлена ранее");
        }
    }

    public void addContactToGroup(Contact2 contact, String groupString) {
        String[] groupsArr = groupString.split(" ");
        for (String group : groupsArr) {
            if (groups.contains(group)) {
                mapContacts.get(group).add(contact);
            } else {
                groups.add(group);
                mapContacts.put(group, new ArrayList<Contact2>(Arrays.asList(contact)));
            }
        }
    }

    public List<Contact2> findContactsByGroup(String groupName) {
        return mapContacts.get(groupName);
    }

    public String findContactByPhoneNumber(String phoneNumber) {
        for (Map.Entry<String, List<Contact2>> entry : mapContacts.entrySet()) {
            for (Contact2 contact : entry.getValue()) {
                if (phoneNumber.equals(contact.getPhoneNumber())) {
                    return contact.getName();
                }
            }
        }
        return null;
    }

    private String findContactName(String lineContact, String phoneNumber) {
        return lineContact.substring(0, lineContact.indexOf(phoneNumber) - 1);
    }

    private String findPhoneNumber(String lineContact) throws Exception {
        String patterns = "\\+\\d{1}\\(\\d{3}\\)\\d{3}\\-\\d{2}\\-\\d{2}";
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(lineContact);
        if (matcher.find()) {
            System.out.println(lineContact.substring(matcher.start()));
            return lineContact.substring(matcher.start());
        } else {
            throw new Exception("Телефон не найден");
        }
    }

    public void printGroupContacts() {
        System.out.println("Группы в справочнике:");
        for (String group : groups) {
            System.out.println();
            System.out.printf("- %s:", group);
            for (Contact2 contact : mapContacts.get(group)) {
                System.out.println();
                System.out.printf("     Имя:%s Телефон:%s", contact.getName(), contact.getPhoneNumber());
            }
        }
    }

}
