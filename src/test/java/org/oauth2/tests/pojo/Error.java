
package org.oauth2.tests.pojo;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Error {

    @JsonProperty("error")
    private ErrorInner errorInner;

    @JsonProperty("error")
    public ErrorInner getError() {
        return errorInner;
    }

    @JsonProperty("error")
    public void setError(ErrorInner error) {
        this.errorInner = error;
    }

}
