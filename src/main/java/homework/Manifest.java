package homework;

public class Manifest {

    String mainClass;
    
    public Manifest (String mainClass){
        this.mainClass = mainClass;
    }

    @Override
    public String toString() {
        return "{"
                + "mainClass='" + this.mainClass + "'"
                + "}";
    }
    
}
