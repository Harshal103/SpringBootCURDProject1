package com.secondSpringBootProject.curdOperation.firstPojectCurd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcepation extends RuntimeException{
   private static long serialVersionUID=1L;
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundExcepation(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
