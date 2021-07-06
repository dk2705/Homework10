package homework;

public class Plugin {
    
    String artifactId;
    String version;
    Configuration configuration;
    Executions executions;
    
    public Plugin(
        String artifactId,
        String version,
        Configuration configuration,
        Executions executions
        ){
            this.artifactId = artifactId;
            this.version = version;
            this.configuration = configuration;
            this.executions = executions;
    }
    
    @Override
    public String toString() {
        return "{"
                + "artifactId='" + this.artifactId + "'"
                + ", version='" + this.version + "'"
                + ", configuration=" + this.configuration + ""
                + ", executions=" + this.executions + ""
                + "}";
    }
    
}