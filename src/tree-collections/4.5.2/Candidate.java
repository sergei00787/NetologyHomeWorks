public class Candidate {
    private String name;
    private String male;
    private String age;
    private int relevance;
    private int rating;

    public Candidate(String name, String male, String age, int relevance, int rating) {
        this.name = name;
        this.male = male;
        this.age = age;
        this.relevance = relevance;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name + ", " + relevance + ", " + rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getRelevance() {
        return relevance;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
