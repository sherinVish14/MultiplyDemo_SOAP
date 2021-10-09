package com.sherin.soapdemo.api.models.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by Sherin P Saleem
 */

@Root(name = "MultiplyResponse", strict = false)
@Namespace(reference = "http://tempuri.org")
public class MultiplyResponseData {

    @Element(name = "MultiplyResult", required = false)
    private String multiplyResult;

    public String getMultiplyResult() {
        return multiplyResult;
    }

    public void setMultiplyResult(String brailleTextResult) {
        this.multiplyResult = brailleTextResult;
    }

    @Override
    public String toString() {
        return "MultiplyResponseData{" +
                "MultiplyResult=" + multiplyResult +
                '}';
    }
}
