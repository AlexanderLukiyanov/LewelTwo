import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String line = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String[][] arrayString = new String[4][4];
        int arrayOperations;
        try {
            arrayString = conversionToStringArray(line);
            System.out.println("Результат преобразования строки в двумерный массив типа String:");
            for (String[] s : arrayString) {
                System.out.println(Arrays.toString(s));
            }
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        try {
            arrayOperations = conversionToIntArray(arrayString);
            System.out.println("Результат математических операций с массивом: " + arrayOperations);
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }


    public static String[][] conversionToStringArray(String lineToConvert) throws MyArraySizeException {
        final int SIZEARRAY = 4;

        String[] array;
        String[][] arrayString = new String[SIZEARRAY][1];
        String[][] arrayStringTwo = new String[SIZEARRAY][SIZEARRAY];
        String[] arr = new String[1];
        String charToString = "";
        int countSpace;

        //преобразование строки в двумерный массив типа String
        array = lineToConvert.split("\n", SIZEARRAY);
        for (int i = 0; i < arrayString.length; i++) {
            System.arraycopy(array, i, arrayString[i], 0, 1);
        }
        for (int i = 0; i < SIZEARRAY; i++) {
            for (int j = 0; j < arrayString[j].length; j++) {
                arr[0] = arrayString[i][j];
                countSpace = arr[0].indexOf(" ");
                for (int l = 0; l < SIZEARRAY; l++) {
                    for (int k = 0; k < countSpace; k++) {
                        charToString += String.valueOf(arr[0].charAt(k));

                    }
                    arrayStringTwo[i][l] = charToString;
                    if (l < 3) {
                        arr[0] = arr[0].substring(countSpace + 1);
                    }
                    countSpace = arr[0].indexOf(" ");
                    if (countSpace < 0) {
                        countSpace = Math.abs(countSpace);
                    }
                    charToString = "";
                }
            }
        }
        // проверка на соответствие полученной матрицы размерам 4*4
        if (arrayStringTwo.length != SIZEARRAY) {
            throw new MyArraySizeException("Размер полученной матрицы не 4*4");
        }
        for (String[] s : arrayStringTwo) {
            if (s.length != SIZEARRAY) {
                throw new MyArraySizeException("Размер полученной матрицы не 4*4");
            }
        }
        return arrayStringTwo;
    }

        //преобразование массива из String в int, проведение математических операций
        public static int conversionToIntArray (String[][] arrayString) throws MyArrayDataException {
            Integer[][] arrayInt = new Integer[4][4];
            int count = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                        arrayInt[i][j] = Integer.parseInt(arrayString[i][j]);
                        if (arrayInt[i][j] instanceof Integer) {
                            count += arrayInt[i][j];
                        } else {
                            throw new MyArrayDataException("Один из элементов массива не преобразован в тип int");
                        }
                }
            }
            return count / 2;
        }
    }