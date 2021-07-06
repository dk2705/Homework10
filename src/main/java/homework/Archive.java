package homework;

public class Archive {
    
    Manifest manifest;
    
    public Archive(
        Manifest manifest
        ){
            this.manifest = manifest;
    }
    
    @Override
    public String toString() {
        return "{"
                + "manifest=" + this.manifest + ""
                + "}";
    }
    
}