package mobileum.serviceframework.serviceframework.types;

import java.util.List;

public class FieldTypeJsonWrapper {

    List<FieldType> fields;

    public FieldTypeJsonWrapper() {
    }

    public FieldTypeJsonWrapper(List<FieldType> fields) {
        this.fields = fields;
    }

    public List<FieldType> getFields() {
        return fields;
    }

    public void setFields(List<FieldType> fields) {
        this.fields = fields;
    }


}
