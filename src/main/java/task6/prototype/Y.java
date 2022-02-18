package task6.prototype;

public class Y implements Symbol {
    private int timesPrinted;

    public Y() {

    }

    private Y(int timesPrinted) {
        this.timesPrinted = timesPrinted;
    }

    @Override
    public Symbol clone() {
        return new Y(timesPrinted);
    }

    public void printChar() {
        timesPrinted++;
    }

    public char getTypedChar() {
        return 'Y';
    }

    public int getTimesPrinted() {
        return timesPrinted;
    }

}
