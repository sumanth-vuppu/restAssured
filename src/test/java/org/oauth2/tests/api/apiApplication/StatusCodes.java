package org.oauth2.tests.api.apiApplication;

public enum StatusCodes {
    CODE_200(200,"OK"),CODE_201(201,"Created"),
    CODE_400(400,"Missing required field: name"),
CODE_401(401,"Invalid access token");
public int code;
public String status;
    StatusCodes(int code, String status) {
        this.code=code;
        this.status=status;
    }
}
