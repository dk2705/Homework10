package homework;

public class Goals {

    String goal;
    
    public Goals (String goal){
        this.goal = goal;
    }

    @Override
    public String toString() {
        return "{"
                + "goal='" + this.goal + "'"
                + "}";
    }
    
}
