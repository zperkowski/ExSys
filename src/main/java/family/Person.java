package family;

public class Person {
    public enum Gender {UNDEFINED, MEN, WOMEN};
    public String name;
    public Gender gender;

    public Person(String name) {
        this.name = name;
        this.gender = Gender.UNDEFINED;
    }

    public String toString() {
        return name;
    }
}
