package homework;

import org.w3c.dom.NamedNodeMap;

public class Project {
    
    String modelVersion;
    String groupId;
    String artifactId;
    String version;
    String packaging;
    Properties properties;
    Build build;
    NamedNodeMap projectAttributes;
    
    public Project(
        String modelVersion,
        String groupId,
        String artifactId,
        String version,
        String packaging,
        Properties properties,
        Build build,
        NamedNodeMap projectAttributes
        ){
            this.modelVersion = modelVersion;
            this.groupId = groupId;
            this.artifactId = artifactId;
            this.version = version;
            this.packaging = packaging;
            this.properties = properties;
            this.build = build;
            this.projectAttributes = projectAttributes;
    }
    
    private String projectAttributesToString(NamedNodeMap projectAttributes){
        StringBuilder sb = new StringBuilder("");
        for (int i=0; i<projectAttributes.getLength(); i++){
            sb.append(" " + projectAttributes.item(i));
        }
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return "project"
                + projectAttributesToString(this.projectAttributes)
                + "\n{"
                + "modelVersion='" + this.modelVersion + "'"
                + ", groupId='" + this.groupId + "'"
                + ", artifactId='" + this.artifactId + "'"
                + ", version='" + this.version + "'"
                + ", packaging='" + this.packaging + "'"
                + ", properties=" + this.properties + ""
                + ", build=" + this.build + ""
                + "}";
    }
    
}