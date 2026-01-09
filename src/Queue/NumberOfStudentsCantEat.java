package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfStudentsCantEat {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] prefers = new int[2];
        for (int student : students) {
            prefers[student]++;
        }

        for (int sandwich : sandwiches) {
            if (prefers[sandwich] > 0) {
                prefers[sandwich]--;
            } else {
                break;
            }
        }

        return  prefers[0] + prefers[1];
    }

    public static void main(String[] args) {
        // int[] students = new int[] { 1, 1, 0, 0 };
        // int[] sandwiches = new int[] { 0, 1, 0, 1};

        int[] students = new int[] { 1, 1, 1, 0, 0, 1 };
        int[] sandwiches = new int[] { 1, 0, 0, 0, 1, 1};

        int count = new NumberOfStudentsCantEat().countStudents(students, sandwiches);
        System.out.println("count = " + count);
    }
}
