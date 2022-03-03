import java.util.NavigableSet;
import java.util.TreeSet;

public class CandidatMain {
    public static void main(String[] args) {
        Candidate candidate1 = new Candidate("Иванов Петр Семенович", "М", "32", 1, 2);
        Candidate candidate2 = new Candidate("Петров Владимир Иванович", "М", "33", 1, 3);
        Candidate candidate3 = new Candidate("Смирнов Илья Васильевич", "М", "34", 2, 2);
        Candidate candidate4 = new Candidate("Сидоров Сергей Владимирович", "М", "35", 3, 1);
        Candidate candidate5 = new Candidate("Спирюхов Азамат Григорьевич", "М", "36", 4, 4);
        Candidate candidate6 = new Candidate("Давыдов Давыд Альбертович", "М", "37", 5, 5);
        Candidate candidate7 = new Candidate("Семенов Николай Николаевич", "М", "38", 2, 4);
        Candidate candidate8 = new Candidate("Пройденко Светлана Семеновна", "Ж", "39", 4, 3);
        Candidate candidate9 = new Candidate("Гадя Петрович Хренова", "М", "40", 5, 3);
        Candidate candidate10 = new Candidate("Головач Елена Артуровна", "Ж", "41", 2, 5);

        NavigableSet<Candidate> candidates = new TreeSet<>(new CandidatComparator());

        candidates.add(candidate1);
        candidates.add(candidate2);
        candidates.add(candidate3);
        candidates.add(candidate4);
        candidates.add(candidate5);
        candidates.add(candidate6);
        candidates.add(candidate7);
        candidates.add(candidate8);
        candidates.add(candidate9);
        candidates.add(candidate10);

        for (Candidate candidate : candidates) {
            System.out.println(candidate);
        }
    }
}
