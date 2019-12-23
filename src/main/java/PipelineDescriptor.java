import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

public class PipelineDescriptor {
    private Set<Step> steps = new HashSet<>();

    Set<Step> getSteps() {
        return steps;
    }

    void populateStepsfromJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(json);
            // get root node
            String stepsJson = node.get("steps").toString();

            // convert JSON array to Array objects
            Step[] stepsArray = mapper.readValue(stepsJson, Step[].class);

            // convert JSON array to List of objects
            List<Step> stepsList = Arrays.asList(stepsArray);

            // each step have to be unique so convert it to Set
            Set<Step> stepsSet = new HashSet<>(stepsList);

            // populate current steps with new steps
            steps.addAll(stepsSet);


            steps.addAll(stepsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "PipelineDescriptor{" +
                "steps=" + steps +
                '}';
    }
}

