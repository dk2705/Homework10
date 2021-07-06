package homework;

public class Plugins {
    
    Plugin plugin;
    
    public Plugins(
        Plugin plugin
        ){
            this.plugin = plugin;
    }
    
    @Override
    public String toString() {
        return "{"
                + "plugin=" + this.plugin + ""
                + "}";
    }
    
}