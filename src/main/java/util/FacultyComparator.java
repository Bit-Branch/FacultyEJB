package util;

import entity.Faculty;

import java.util.Comparator;

public class FacultyComparator implements Comparator<Faculty> {
    @Override
    public int compare(Faculty o1, Faculty o2) {
        return o1.getNumberOfPeople() - o2.getNumberOfPeople();
    }
}
