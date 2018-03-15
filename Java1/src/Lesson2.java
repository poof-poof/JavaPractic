/**
 * 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
 * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и
 * условия заменить 0 на 1, 1 на 0;
 * 2. Задать пустой целочисленный массив размером 8.
 * С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
 * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
 * пройти по нему циклом, и числа меньшие 6 умножить на 2;
 * 4. Создать квадратный двумерный целочисленный массив
 * (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
 * заполнить его диагональные элементы единицами;
 5. ** Задать одномерный массив и найти в нем минимальный и
 максимальный элементы (без помощи интернета);
 6. ** Написать метод, в который передается не пустой одномерный
 целочисленный массив, метод должен вернуть true если в массиве
 есть место, в котором сумма левой и правой части массива равны.
 Примеры: checkBalance([1, 1, 1, || 2, 1]) → true,
 checkBalance ([2, 1, 1, 2, 1]) → false,
 checkBalance ([10, || 10]) → true,
 граница показана символами ||, эти символы в массив не входят.
 7. **** Написать метод, которому на вход подается
 одномерный массив и число n (может быть положительным, или отрицательным),
 при этом метод должен сместить все элементымассива на n позиций. Для усложнения
 задачи нельзя пользоваться вспомогательными массивами.
 */
public class Lesson2 {
    public static void main(String[] args) {
        int[] arr0 = {1,0,0,1};
        int[] arr1 = new int[8];
        int[] arr2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] arr3 = new int[4][4];
    }

    void method1(int[] arr){
        for (int i = 0 ; i < arr.length; i++)
            arr[i] ^= 1;
    }
    void method2(int[] arr){
        for (int i = 0, value = 0; i < arr.length; i++, value += 3)
            arr[i] = value;
    }

    void method3(int[] arr){
        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 6)
                arr[i] <<= 1;
    }

    void method4(int[][] arr){
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                if (i == j || i + j + 1 == arr.length)
                    arr[i][j] = 1;
    }

    int min(int[] arr){
        int min = arr[0];
        for (int a : arr) {
            if (min > a)
                min = a;
        }
        return min;
    }

    int max(int[] arr){
        int max = arr[0];
        for (int a : arr) {
            if (max < a)
                max = a;
        }
        return max;
    }

    boolean checkBalance(int[] arr){
        int left = 0;
        int right = 0;
        for (int i = 0; i < arr.length; i++){
            left += arr[i];
            for (int j = i + 1; j < arr.length; j++)
                right += arr[j];
            if (left == right)
                return true;
            else right = 0;
        }
        return false;
    }

    void offsetOfElements(int[] arr, int n){
        int offset;
        for (int i = 0; i < Math.abs(n); i++){
            offset = arr[(n >= 0) ? arr.length - 1 : 0];
            for (int j = (n >= 0) ? arr.length - 1 : 0; (n >= 0) ? j > 0 : j < arr.length - 1; j = (n >= 0) ? j - 1 : j + 1)
                arr[j] = arr[(n >= 0) ? j - 1 : j + 1];
            arr[(n >= 0 ? 0 : arr.length - 1)] = offset;
        }
    }

}
