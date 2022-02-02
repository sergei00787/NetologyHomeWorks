import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneContacts {
    private final Set<String> groups = new HashSet<String>();
    private final Map<Object, List<Contact>> mapContacts = new HashMap<Object, List<Contact>>();
    private final List<Contact> contacts = new ArrayList<>();

    public boolean isANewGroups(String group) {
        return !groups.contains(group);
    }

    public boolean isANewContact(Contact newContact) {
        return !contacts.contains(newContact);
    }

    public void addGroupContact(String newGroupContact) {
        if (isANewGroups(newGroupContact)) {
            groups.add(newGroupContact);
            mapContacts.put(newGroupContact, new ArrayList<Contact>());
        } else {
            System.out.println("Такая группа уже была добавлена ранее");
        }
    }

    public void addContactToGroup(Contact contact, String groupString) {
        String[] groupsArr = groupString.split(" ");
        for (String group : groupsArr) {
            if (groups.contains(group)) {
                mapContacts.get(group).add(contact);
            } else {
                groups.add(group);
                mapContacts.put(group, new ArrayList<Contact>(Arrays.asList(contact)));
            }
        }
    }

    public Contact createContactFromString(String lineContact) {

        String phoneNumber = null;
        String name;
        try {
            phoneNumber = findPhoneNumber(lineContact);
            name = findContactName(lineContact, phoneNumber);
        } catch (Exception e) {
            name = lineContact;
        }

        Contact newContact = Contact.createContact(name, phoneNumber);
        if (isANewContact(newContact)) {
            contacts.add(newContact);
            return newContact;
        } else {
            System.out.println("Такой контакт уже существует");
            return contacts.get(contacts.indexOf(newContact));
        }
    }

    private String findContactName(String lineContact, String phoneNumber) {
        return lineContact.substring(0, lineContact.indexOf(phoneNumber) - 1);
    }

    private String findPhoneNumber(String lineContact) throws Exception {
        //String patterns = "\\+\\d{11}";
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
            for (Contact contact : mapContacts.get(group)) {
                System.out.println();
                System.out.printf("     Имя:%s Телефон:%s", contact.getName(), contact.getPhoneNumber());
            }
        }
    }

}
