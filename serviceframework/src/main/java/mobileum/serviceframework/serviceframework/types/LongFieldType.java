package mobileum.serviceframework.serviceframework.types;

public class LongFieldType implements GenericFieldType{
    @Override
    public Long generateRandomValue() {
        return 12344556L;
    }
}
