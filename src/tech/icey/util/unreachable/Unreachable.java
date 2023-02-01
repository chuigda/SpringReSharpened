package tech.icey.util.unreachable;

public class Unreachable extends RuntimeException {
    private static final long serialVersionUID = 1L;
   
    private String reason;
    
    public Unreachable() {
        this.reason = "this_piece_of_code_is_considered_unreachable";
    }
    
    public Unreachable(String reason) {
        this.reason = reason;
    }
    
    @Override
    public String toString() {
        return "Unreachable(" + reason + ")";
    }
    
    public static <T> T unreachable() throws Unreachable {
        throw new Unreachable();
    }
    
    public static <T> T unreachable(String reason) throws Unreachable {
        throw new Unreachable(reason);
    }
}
