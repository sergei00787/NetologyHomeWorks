import java.util.Comparator;

public class CandidatComparator implements Comparator<Candidate> {
    @Override
    public int compare(Candidate o1, Candidate o2) {
        int last = - Integer.compare(o1.getRelevance(), o2.getRelevance());
        return last == 0 ? - Integer.compare(o1.getRating(), o2.getRating()) : last;
    }
}
