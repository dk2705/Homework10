package homework;

public class Properties {
    
    String projectBuildSourceEncodingListElement;
    String mavenCompilerSourceListElement;
    String mavenCompilerTargetListElement;
    
    public Properties(
        String projectBuildSourceEncodingListElement,
        String mavenCompilerSourceListElement,
        String mavenCompilerTargetListElement
        ){
            this.projectBuildSourceEncodingListElement = projectBuildSourceEncodingListElement;
            this.mavenCompilerSourceListElement = mavenCompilerSourceListElement;
            this.mavenCompilerTargetListElement = mavenCompilerTargetListElement;
    }
    
    @Override
    public String toString() {
        return "{"
                + "project.build.sourceEncoding='" + this.projectBuildSourceEncodingListElement + "'"
                + ", maven.compiler.source='" + this.mavenCompilerSourceListElement + "'"
                + ", maven.compiler.target='" + this.mavenCompilerTargetListElement + "'"
                + "}";
    }
    
}