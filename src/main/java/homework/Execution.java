package homework;

public class Execution {
    
    String id;
    String phase;
    Goals goals;
    
    public Execution(
        String id,
        String phase,
        Goals goals
        ){
            this.id = id;
            this.phase = phase;
            this.goals = goals;
    }
    
    @Override
    public String toString() {
        return "{"
                + "id='" + this.id + "'"
                + ", phase='" + this.phase + "'"
                + ", goals=" + this.goals + ""
                + "}";
    }
    
}