package tech.icey.util;

public class Pair<T1, T2> extends Tuple {
    private T1 first;
    private T2 second;
    
    public Pair(T1 first, T2 second) {
        this.first = first;
        this.setSecond(second);
    }

    public T1 first() {
        return first;
    }

    public T2 second() {
        return second;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }

    @Override
    public int length() {
        return 2;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T component(int index) throws ClassCastException, IndexOutOfBoundsException {
        switch (index) {
            case 0: return (T)first;
            case 1: return (T)second;
            default: throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Class<?> componentType(int index) throws IndexOutOfBoundsException {
        switch (index) {
            case 0: return first.getClass();
            case 1: return second.getClass();
            default: throw new IndexOutOfBoundsException();
        }
    }
}
