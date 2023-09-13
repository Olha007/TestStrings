package task_2_15_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 1. Додайте до пакету testcollections узагальнений клас ArrayBox, який інкапсулює список елементів довільного
 * числового типу та має конструктор, що приймає як параметри розмір списку та рядок-назву типу елементів масиву.
 * 2. Конструктор повинен заповнювати список елементами відповідного типу з випадковими позитивними та негативними значеннями.
 * У разі, якщо параметр назва типу заданий неправильним, конструктор повинен генерувати IllegalArgumentException з
 * відповідним повідомленням.
 * 3. Додайте до класу ArrayBox метод, що повертає список з елементами списку-поля класу із позитивними значеннями.
 * 4. Додайте до методу main() класу Main код, що створює об'єкти класу ArrayBox і перевіряє роботу метода відбору
 * позитивних значень для списків:
 * - Byte з розміром списку 7 елементів.
 * - Integer з розміром списку 6 елементів.
 * - Float з розміром списку 5 елементів.
 * 5. Виконайте програму.
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */
public class ArrayBox<T extends Number> {

    private List<T> list = new ArrayList<>();

    public ArrayBox(int size, String typeName){
        if(typeName.equals("Byte")){
            fillListWithRandomBytes(size);
        } else if (typeName.equals("Integer")) {
            fillListWithRandomInteger(size);
        } else if (typeName.equals("Float")) {
            fillListWithRandomFloat(size);
        } else {
            throw new IllegalArgumentException("Wrong name type ");
        }
    }

    private void fillListWithRandomBytes(int size){
        Random random = new Random();
        for (int i = 0; i < size; i++){
            byte randomByte = (byte) (random.nextInt(256) - 128); // від -128 до 127
            list.add((T) (Number) randomByte);
        }
    }

    private void fillListWithRandomInteger(int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int randomInt = random.nextInt();
            list.add((T) Integer.valueOf(randomInt));
        }
    }

    private void fillListWithRandomFloat(int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int randomIntBits = random.nextInt();
            float randomFloat = Float.intBitsToFloat(randomIntBits);
            list.add((T) Float.valueOf(randomFloat));
        }
    }

    public List<T> getPositiveValues() {
        List<T> positiveValues = new ArrayList<>();
        for (T value : list) {
            if (value.doubleValue() > 0) {
                positiveValues.add(value);
            }
        }
        return positiveValues;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayBox<Byte> byteArrayBox = new ArrayBox<>(7, "Byte");
        ArrayBox<Integer> intArrayBox = new ArrayBox<>(6, "Integer");
        ArrayBox<Float> floatArrayBox = new ArrayBox<>(5, "Float");

        System.out.println("Positive elements for Byte: ");
        List<Byte> positiveBytes = byteArrayBox.getPositiveValues();
        for (Byte value : positiveBytes) {
            System.out.println(value);
        }
        System.out.println();

        System.out.println("Positive elements for Integer: ");
        List<Integer> positiveIntegers = intArrayBox.getPositiveValues();
        for (Integer value : positiveIntegers) {
            System.out.println(value);
        }
        System.out.println();

        System.out.println("Positive elements for Float: ");
        List<Float> positiveFloats = floatArrayBox.getPositiveValues();
        for (Float value : positiveFloats) {
            System.out.println(value);
        }
    }
}

