package Utilities;

import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

public class ymlReader {

    public ymlReader(){

    }

    public String yamlReaderMethod(String key) throws FileNotFoundException {
        String value="";
        Yaml yml=new Yaml();
        InputStream inputStream = new FileInputStream("C:/Users/S_Home/IdeaProjects/CCLearn/src/test/PageObjects/QA.yml");
        HashMap yamlMap = yml.load(inputStream);

        value= (String) yamlMap.get(key);

//        for (Object o : yamlMap.entrySet()) {
//            System.out.println(yamlMap.get("username"));
//        }

        return value;
    }

}
