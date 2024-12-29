package Models;

import java.util.ArrayList;
import java.util.List;

public class School {
    public List<Person> members;

    public School() {
        members = new ArrayList<>();
    }

    public void addMember(Person member) {
        members.add(member);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person member : members) {
            sb.append(member.toString()).append("\n");
        }
        return sb.toString();
    }
}



