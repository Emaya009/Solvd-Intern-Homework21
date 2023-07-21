package com.zebrunner.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;
import org.testng.annotations.Test;

//Created to perform create,Retrieve,update,delete requests of an employee
@Test
@Endpoint(url = "${base_url}/api/v1/employee/${id}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/_get/rsDummyAPI.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetEmployeeMethod extends AbstractApiMethodV2 {

    public GetEmployeeMethod(int employeeId) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("base"));
        replaceUrlPlaceholder("id",String.valueOf(employeeId));
            }
    }
