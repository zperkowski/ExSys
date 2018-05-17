package family;

public class Relation {
    public Person[] people = new Person[2];
    public String relation;

    public Relation(Person o1, Person o2, String relation) {
        this.people[0] = o1;
        this.people[1] = o2;
        this.relation = relation;

        o1.addRelation(this);
        o2.addRelation(this);
    }
}
