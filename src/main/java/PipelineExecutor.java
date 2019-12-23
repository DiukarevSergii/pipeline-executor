import java.util.Map;

public class PipelineExecutor {

    public void transform(PipelineDescriptor pipelineDescriptor, Map<String, Object> jsonDocument){
        for(Step step : pipelineDescriptor.getSteps()){
           String key = step.getProcessor();
           Configuration value = step.getConfiguration();
           jsonDocument.put(key, value);
        }
    }
}
