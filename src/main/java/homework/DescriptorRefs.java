package homework;

public class DescriptorRefs {

    String descriptorRef;
    
    public DescriptorRefs (String descriptorRef){
        this.descriptorRef = descriptorRef;
    }

    @Override
    public String toString() {
        return "{"
                + "descriptorRef='" + this.descriptorRef + "'"
                + "}";
    }
    
}
