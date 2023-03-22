package mobileum.serviceframework.serviceframework.types;

public class StringFieldType<T> implements GenericFieldType{

    @Override
    public String generateRandomValue() {
        return "This is a String";
    }
}
