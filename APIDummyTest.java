package com.zebrunner.carina.demo;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.api.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class APIDummyTest implements IAbstractTest {
        @Test()
        @MethodOwner(owner = "emaya")
        public void testCreateEmployee() throws Exception {
            CreateEmployeeMethod createEmployeeMethod = new CreateEmployeeMethod();

            createEmployeeMethod.setProperties("api/users/employeeDummyAPI.properties");
            createEmployeeMethod.callAPIExpectSuccess();
            createEmployeeMethod.validateResponse();
        }

        @Test()
        @MethodOwner(owner = "emaya")
        public void testGetEmployee() {
            GetEmployeeMethod getEmployeeMethods = new GetEmployeeMethod(7);
            getEmployeeMethods.callAPIExpectSuccess();
            getEmployeeMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
            getEmployeeMethods.validateResponseAgainstSchema("api/users/_get/rsDummyAPI.schema");
        }
    @Test()
    @MethodOwner(owner = "Emaya")
    public void testUpdateEmployee() {
        PutEmployeeMethod putEmployeeMethod = new PutEmployeeMethod(21);
        putEmployeeMethod.callAPIExpectSuccess();
        putEmployeeMethod.validateResponse();
    }

        @Test()
        @MethodOwner(owner = "Emaya")
        public void testDeleteEmployee() {
            DeleteEmployeeMethod deleteEmployeeMethod = new DeleteEmployeeMethod();
            deleteEmployeeMethod.callAPIExpectSuccess();
            deleteEmployeeMethod.validateResponse();
        }
    }

