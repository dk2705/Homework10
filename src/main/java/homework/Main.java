package homework;

//parser of pom.xml (DOM)

import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.IOException;
//import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
        
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.SAXException;

public class Main {
    
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        try{
            Document doc = builder.parse(new File("pom.xml"));
            System.out.println("File pom.xml found");

            NodeList artifactIdList = doc.getElementsByTagName("artifactId");
            NodeList versionList = doc.getElementsByTagName("version");

            // properties
            NodeList projectBuildSourceEncodingList = doc.getElementsByTagName("project.build.sourceEncoding");
            NodeList mavenCompilerSourceList = doc.getElementsByTagName("maven.compiler.source");
            NodeList mavenCompilerTargetList = doc.getElementsByTagName("maven.compiler.target");
            List<Properties> propertiesList = new ArrayList<>();
            for (int i=0; i<projectBuildSourceEncodingList.getLength(); i++){
                Node projectBuildSourceEncodingListNode = projectBuildSourceEncodingList.item(i);
                Element projectBuildSourceEncodingListElement = (Element)projectBuildSourceEncodingListNode;
                Node mavenCompilerSourceListNode = mavenCompilerSourceList.item(i);
                Element mavenCompilerSourceListElement = (Element)mavenCompilerSourceListNode;
                Node mavenCompilerTargetListNode = mavenCompilerTargetList.item(i);
                Element mavenCompilerTargetListElement = (Element)mavenCompilerTargetListNode;
                propertiesList.add(new Properties(
                    projectBuildSourceEncodingListElement.getTextContent(),
                    mavenCompilerSourceListElement.getTextContent(),
                    mavenCompilerTargetListElement.getTextContent()
                ));
            }
            //System.out.println(propertiesList.toString());

            // manifest
            NodeList mainClassList = doc.getElementsByTagName("mainClass");
            List<Manifest> manifestList = new ArrayList<>();
            for (int i=0; i<mainClassList.getLength(); i++){
                Node mainClassListNode = mainClassList.item(i);
                Element mainClassListElement = (Element)mainClassListNode;
                manifestList.add(new Manifest(
                    mainClassListElement.getTextContent()
                ));
            }
            //System.out.println(manifestList.toString());

            // goals
            NodeList goalList = doc.getElementsByTagName("goal");
            List<Goals> goalsList = new ArrayList<>();
            for (int i=0; i<goalList.getLength(); i++){
                Node goalListNode = goalList.item(i);
                Element goalListElement = (Element)goalListNode;
                goalsList.add(new Goals(
                    goalListElement.getTextContent()
                ));
            }
            //System.out.println(goalsList.toString());

            // descriptorRefs
            NodeList descriptorRefList = doc.getElementsByTagName("descriptorRef");
            List<DescriptorRefs> descriptorRefsList = new ArrayList<>();
            for (int i=0; i<descriptorRefList.getLength(); i++){
                Node descriptorRefListNode = descriptorRefList.item(i);
                Element descriptorRefListElement = (Element)descriptorRefListNode;
                descriptorRefsList.add(new DescriptorRefs(
                    descriptorRefListElement.getTextContent()
                ));
            }
            //System.out.println(descriptorRefsList.toString());

            // execution
            NodeList idList = doc.getElementsByTagName("id");
            NodeList phaseList = doc.getElementsByTagName("phase");
            List<Execution> executionList = new ArrayList<>();
            for (int i=0; i<idList.getLength(); i++){
                Node idListNode = idList.item(i);
                Element idListElement = (Element)idListNode;
                Node phaseListNode = phaseList.item(i);
                Element phaseListElement = (Element)phaseListNode;
                executionList.add(new Execution(
                    idListElement.getTextContent(),
                    phaseListElement.getTextContent(),
                    goalsList.get(i)
                ));
            }
            //System.out.println(executionList.toString());

            // executions
            List<Executions> executionsList = new ArrayList<>();
            for (int i=0; i<executionList.size(); i++){
                executionsList.add(new Executions(
                    executionList.get(i)
                ));
            }
            //System.out.println(executionsList.toString());

            // archive
            List<Archive> archiveList = new ArrayList<>();
            for (int i=0; i<manifestList.size(); i++){
                archiveList.add(new Archive(
                    manifestList.get(i)
                ));
            }
            //System.out.println(archiveList.toString());

            // configuration
            List<Configuration> configurationList = new ArrayList<>();
            for (int i=0; i<descriptorRefsList.size(); i++){
                configurationList.add(new Configuration(
                    descriptorRefsList.get(i),
                    archiveList.get(i)
                ));
            }
            //System.out.println(configurationList.toString());

            // plugin
            artifactIdList = doc.getElementsByTagName("artifactId");
            versionList = doc.getElementsByTagName("version");
            List<Plugin> pluginList = new ArrayList<>();
            for (int i=0; i<configurationList.size(); i++){
                Node artifactIdListNode = artifactIdList.item(i+1);
                Element artifactIdListElement = (Element)artifactIdListNode;
                Node versionListNode = versionList.item(i+1);
                Element versionListElement = (Element)versionListNode;
                pluginList.add(new Plugin(
                    artifactIdListElement.getTextContent(),
                    versionListElement.getTextContent(),
                    configurationList.get(i),
                    executionsList.get(i)
                ));
            }
            //System.out.println(pluginList.toString());

            // plugins
            List<Plugins> pluginsList = new ArrayList<>();
            for (int i=0; i<pluginList.size(); i++){
                pluginsList.add(new Plugins(
                    pluginList.get(i)
                ));
            }
            //System.out.println(pluginsList.toString());

            // build
            List<Build> buildList = new ArrayList<>();
            for (int i=0; i<pluginsList.size(); i++){
                buildList.add(new Build(
                    pluginsList.get(i)
                ));
            }
            //System.out.println(buildList.toString());

            // project
            NodeList projectTagList = doc.getElementsByTagName("project");
            NamedNodeMap projectAttributes = projectTagList.item(0).getAttributes();
            
            NodeList modelVersionList = doc.getElementsByTagName("modelVersion");
            NodeList groupIdList = doc.getElementsByTagName("groupId");
            artifactIdList = doc.getElementsByTagName("artifactId");
            versionList = doc.getElementsByTagName("version");
            NodeList packagingList = doc.getElementsByTagName("packaging");
            List<Project> projectList = new ArrayList<>();
            for (int i=0; i<modelVersionList.getLength(); i++){
                Node modelVersionListNode = modelVersionList.item(i);
                Element modelVersionListElement = (Element)modelVersionListNode;
                Node groupIdListNode = groupIdList.item(i);
                Element groupIdListElement = (Element)groupIdListNode;
                Node artifactIdListNode = artifactIdList.item(i);
                Element artifactIdListElement = (Element)artifactIdListNode;
                Node versionListNode = versionList.item(i);
                Element versionListElement = (Element)versionListNode;
                Node packagingListNode = packagingList.item(i);
                Element packagingListElement = (Element)packagingListNode;
                projectList.add(new Project(
                    modelVersionListElement.getTextContent(),
                    groupIdListElement.getTextContent(),
                    artifactIdListElement.getTextContent(),
                    versionListElement.getTextContent(),
                    packagingListElement.getTextContent(),
                    propertiesList.get(i),
                    buildList.get(i),
                    projectAttributes    
                ));
            }
            System.out.println(projectList.toString());

        }catch(IOException ex){
            System.out.println("No file pom.xml in your jar folder");
        }
    }
}