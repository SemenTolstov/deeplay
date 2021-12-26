import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] testFindLargestNumbers = {-500, 45, 70, 270, 1000, 1300, 2500};
        int[] testDivideOnGroups = {1, 2, -1};
        String testFindSumNumbers = "123456789";
        System.out.println(findThreeLargestNumbers(testFindLargestNumbers));
        divideOnGroups(testDivideOnGroups, 4);
        System.out.println(findSumNumbers(testFindSumNumbers));
    }

    /**
     * Методо находит три наибольших элемента массива и возвраащет их в списке.
     */
    public static List<Integer> findThreeLargestNumbers(int[] numbers) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > max1) {
                max3 = max2;
                max2 = max1;
                max1 = number;
            } else if (number > max2) {
                max3 = max2;
                max2 = number;
            } else if (number > max3) {
                max3 = number;
            }
        }
        return Arrays.asList(max1, max2, max3);
    }

    /**
     * Метод возвращает сумму цифр целого числа.
     */
    public static int findSumNumbers(String str) {
        return str.chars().map(Character::getNumericValue).sum();
    }

    /**
     * Метод рекурсивно пробегает по всем числам из массива и заполняет по очереди контейнеры.
     */
    public static boolean recFunc(int[] ints, int index, List<Integer> containers) {
        System.out.println(index + " : " + containers);
        if (index == ints.length) {
            for (Integer container : containers) {
                if (!containers.get(0).equals(container)) {
                    return false;
                }
            }
            return true;
        }
        for (int i = 0; i < containers.size(); i++) {
            containers.set(i, containers.get(i) + ints[index]);
            if (recFunc(ints, index + 1, containers)) return true;
            containers.set(i, containers.get(i) - ints[index]);
        }
        return false;
    }

    /**
     * Метод который вызывает рекурсивную функцию для работы с массивом чисел
     */
    public static void divideOnGroups(int[] ints, int m) {
        if (m > ints.length) {
            System.out.println("Containers counts shouldn't be more than array length");
        } else {
            List<Integer> containers = Arrays.asList(new Integer[m]);
            for (int i = 0; i < m; i++) {
                containers.set(i, 0);
            }
            System.out.println("result exist = " + recFunc(ints, 0, containers));
        }
    }
}


