package mobileum.serviceframework.serviceframework.services;

import mobileum.serviceframework.serviceframework.types.GenericFieldType;
import mobileum.serviceframework.serviceframework.types.StringFieldType;

import java.util.ArrayList;
import java.util.List;

public class FileGeneratorService {

    public String createFile () {
        List<GenericFieldType> fieldsToCreate = new ArrayList<>();
        StringFieldType randomString = new StringFieldType<>();
        String xpto = randomString.generateRandomValue();
        return "";
    }
}
