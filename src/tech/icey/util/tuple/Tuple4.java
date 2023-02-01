package tech.icey.util.tuple;

import tech.icey.util.Tuple;

public class Tuple4<T1, T2, T3, T4> extends Tuple {
    private T1 c0;
    private T2 c1;
    private T3 c2;
    private T4 c3;

    public Tuple4(T1 c0, T2 c1, T3 c2, T4 c3) {
        this.c0 = c0;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }
    
    public T1 component0() {
        return c0;
    }
    
    public T2 component1() {
        return c1;
    }
    
    public T3 component2() {
        return c2;
    }
    
    public T4 component3() {
        return c3;
    }
    
    public void setComponent0(T1 c0) {
        this.c0 = c0;
    }
    
    public void setComponent1(T2 c1) {
        this.c1 = c1;
    }
    
    public void setComponent2(T3 c2) {
        this.c2 = c2;
    }
    
    public void setComponent3(T4 c3) {
        this.c3 = c3;
    }
    
    @Override
    public int length() {
        return 4;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public <T> T component(int index) throws ClassCastException, IndexOutOfBoundsException {
        switch (index) {
            case 0: return (T)c0;
            case 1: return (T)c1;
            case 2: return (T)c2;
            case 3: return (T)c3;
            default: throw new IndexOutOfBoundsException();
        }
    }
    
    @Override
    public Class<?> componentType(int index) throws IndexOutOfBoundsException {
        switch (index) {
            case 0: return c0.getClass();
            case 1: return c1.getClass();
            case 2: return c2.getClass();
            case 3: return c3.getClass();
            default: throw new IndexOutOfBoundsException();
        }
    }
}
