package lesson2.arrays;

class InvalidArrayStateException extends RuntimeException {
    InvalidArrayStateException(int index, int arraySize) {
        super(String.format("Invalid index value %d; array size is %d", index, arraySize));
    }
}
