package family;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public enum Gender {UNDEFINED, MEN, WOMEN};
    public String name;
    public Gender gender;
    public List<Relation> inRelations = new ArrayList<>();

    public Person(String name) {
        this.name = name;
        this.gender = Gender.UNDEFINED;
    }

    public void addRelation(Relation relation) {
        inRelations.add(relation);
    }

    public String toString() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }
}
