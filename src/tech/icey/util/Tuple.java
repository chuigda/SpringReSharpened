package tech.icey.util;

public abstract class Tuple {
    public abstract int length();
    public abstract <T> T component(int index) throws ClassCastException, IndexOutOfBoundsException;
    public abstract Class<?> componentType(int index) throws IndexOutOfBoundsException;
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int len = length();
        
        sb.append("Tuple<");
        for (int i = 0; i < len; i++) {
            sb.append(componentType(i).getName());
            if (i != len - 1) {
                sb.append(",");
            }
        }
        sb.append(">(");
        
        for (int i = 0; i < len; i++) {
            sb.append(component(i).toString());
            if (i != len - 1) {
                sb.append(",");
            }
        }
        sb.append(")");

        return sb.toString();
    }
}
