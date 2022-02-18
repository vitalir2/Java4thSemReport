package task6.prototype;

public class A implements Symbol {
    private int timesPrinted = 0;

    public A() {

    }

    private A(int timesPrinted) {
        this.timesPrinted = timesPrinted;
    }

    @Override
    public Object clone() {
        return new A(timesPrinted);
    }

    public void printChar() {
        timesPrinted++;
    }

    public char getTypedChar() {
        return 'A';
    }

    public int getTimesPrinted() {
        return timesPrinted;
    }
}
