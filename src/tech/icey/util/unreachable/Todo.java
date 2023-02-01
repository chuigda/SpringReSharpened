package tech.icey.util.unreachable;

public class Todo extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    private String reason;
    
    public Todo() {
        this.reason = "this_piece_of_code_is_incomplete";
    }
    
    public Todo(String reason) {
        this.reason = reason;
    }
    
    @Override
    public String toString() {
        return "Todo(" + reason + ")";
    }
    
    public static <T> T todo() throws Todo {
        throw new Todo();
    }
    
    public static <T> T todo(String reason) throws Todo {
        throw new Todo(reason);
    }
}
