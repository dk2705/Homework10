package homework;

public class Configuration {
    
    DescriptorRefs descriptorRefs;
    Archive archive;
    
    public Configuration(
        DescriptorRefs descriptorRefs,
        Archive archive    
        ){
            this.descriptorRefs = descriptorRefs;
            this.archive = archive;
    }
    
    @Override
    public String toString() {
        return "{"
                + "descriptorRefs=" + this.descriptorRefs + ""
                + ", archive=" + this.archive + ""
                + "}";
    }
    
}