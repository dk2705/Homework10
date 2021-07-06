package homework;

public class Build {
    
    Plugins plugins;
    
    public Build(
        Plugins plugins
        ){
            this.plugins = plugins;
    }
    
    @Override
    public String toString() {
        return "{"
                + "plugins=" + this.plugins + ""
                + "}";
    }
    
}