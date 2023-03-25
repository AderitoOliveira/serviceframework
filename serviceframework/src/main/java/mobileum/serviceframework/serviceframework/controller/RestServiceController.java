package mobileum.serviceframework.serviceframework.controller;


import mobileum.serviceframework.serviceframework.types.FieldType;
import mobileum.serviceframework.serviceframework.types.FieldTypeJsonWrapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestServiceController {

    @PostMapping("/logmessage")
    public void logMessage (@RequestBody String message) {
        System.out.println("THIS IS THE MESSAGE: " + message);
    }

    @GetMapping("/example")
    public String returnTestMessage() {
        return "TEST MESSAGE!!!!!!";
    }

    @PostMapping("/createfile")
    public boolean createFile(@RequestBody FieldTypeJsonWrapper fields) {

        List<FieldType> fieldsToCreate = fields.getFields();

        for(FieldType fieldType : fieldsToCreate) {
            System.out.println(fieldType.getFieldType());
            System.out.println(fieldType.isRandom());
        }
        /*
        for(FieldTypeJson filedType : filedTypeList) {
            System.out.println(filedTypeList.getFieldType());
            System.out.println(filedTypeList.isRandom());
        }
        */

        return true;
    }

}
