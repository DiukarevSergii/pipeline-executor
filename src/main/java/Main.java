import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String args[]) {

        PipelineDescriptor pipelineDescriptor = new PipelineDescriptor();

        // todo extend it to the separate file
        String json = "{\n" +
                "\"steps\": [\n" +
                "  {\n" +
                "   \"processor\": \"AddField\",\n" +
                "   \"configuration\" : {\n" +
                "    \"fieldName\": \"accountName\",\n" +
                "    \"fieldValue\": \"Facebook\"\n" +
                "} },\n" +
                "  {\n" +
                "   \"processor\": \"RemoveField\",\n" +
                "   \"configuration\" : {\n" +
                "    \"fieldName\": \"userName\"\n" +
                "   }\n" +
                "}, {\n" +
                "   \"processor\": \"CountNumOfFields\",\n" +
                "   \"configuration\" : {\n" +
                "    \"targetFieldName\": \"numOfFields\"\n" +
                "   }\n" +
                "} ]\n" +
                "}";

        //converting JSON String to Java object
        pipelineDescriptor.populateStepsfromJson(json);

        // check that it was populated
        System.out.println("Populate pipelineDescriptor first time: " + pipelineDescriptor);

        // update json
        // todo extend it to the separate file
        json = "{\n" +
                "\"steps\": [\n" +
                "  {\n" +
                "   \"processor\": \"AddField 2\",\n" +
                "   \"configuration\" : {\n" +
                "    \"fieldName\": \"accountName\",\n" +
                "                \"fieldValue\": \"Facebook\"\n" +
                "} }]\n" +
                "}";

        // extend with new steps
        pipelineDescriptor.populateStepsfromJson(json);

        // check that it was extended
        System.out.println("Populate pipelineDescriptor second time: " +  pipelineDescriptor);

        PipelineExecutor pipelineExecutor = new PipelineExecutor();
        Map<String, Object> jsonDocument = new HashMap<>();

        pipelineExecutor.transform(pipelineDescriptor, jsonDocument);

        // check that jsonDocument map was populated
        System.out.println("Populate jsonDocument: " + jsonDocument);
        System.out.println("Get configuration from jsonDocument: " + jsonDocument.get("AddField"));

        // todo write tests for each class
        // todo add java documentation
    }
}
