package homework;

public class Executions {
    
    Execution execution;
    
    public Executions(
        Execution execution
        ){
            this.execution = execution;
    }
    
    @Override
    public String toString() {
        return "{"
                + "execution=" + this.execution + ""
                + "}";
    }
    
}