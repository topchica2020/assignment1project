package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class School {
    private List<Person> members;

    public School() {
        members = new ArrayList<>();
    }

    public void addMember(Person person) {
        members.add(person);
    }

    public List<Person> getMembers() {
        return members; // Возвращаем список участников
    }

    public void sortMembersBySurname() {
        Collections.sort(members, Comparator.comparing(Person::getSurname));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Person member : members) {
            result.append(member.toString()).append("\n");
        }
        return result.toString();
    }
}
