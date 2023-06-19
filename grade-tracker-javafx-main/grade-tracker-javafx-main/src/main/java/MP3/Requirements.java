package MP3;

import java.util.ArrayList;
import java.util.Arrays;

public class Requirements {
    public static void main(String[] args) {
        ArrayList<Class> a = new ArrayList<Class>();
        a.add(new Class("B", "Teacher", 100, new ArrayList<Assignment>()));
        a.add(new Class("A", "Teacher", 100, new ArrayList<Assignment>()));
        a.add(new Class("C", "Teacher", 100, new ArrayList<Assignment>()));

        for (Class c : insertionSort(a)) {
            System.out.println(c.getName());
        }
    }

    public static void swap(ArrayList<Class> arr, int a, int b) {
        Class temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }

    public static ArrayList<Class> selectionSort(ArrayList<Class> a) {
        ArrayList<Class> newArr = a;

        for (int i = 0; i < newArr.size() - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < newArr.size(); j++) {
                if (newArr.get(j).getName().compareTo(newArr.get(i).getName()) < 0) {
                    minIdx = j;
                }
            }

            swap(newArr, minIdx, i);
        }

        return newArr;
    }

    public static ArrayList<Class> insertionSort(ArrayList<Class> a) {
        ArrayList<Class> newArr = a;

        for (int i = 0; i < newArr.size() - 1; i++) {
            for (int j = i + 1; j >= 0; j--) {
                if (newArr.get(j).getName().compareTo(newArr.get(j - 1).getName()) < 0) {
                    swap(newArr, j, j - 1);
                }
            }
        }

        return newArr;
    }
}
