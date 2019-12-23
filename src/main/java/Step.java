import java.util.Objects;

public class Step {
    private String processor;
    private Configuration configuration;

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Step)) return false;
        Step step = (Step) o;
        return processor.equals(step.processor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(processor);
    }

    @Override
    public String toString() {
        return "Step{" +
                "processor='" + processor + '\'' +
                ", configuration=" + configuration +
                '}';
    }
}