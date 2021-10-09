package com.sherin.soapdemo.api.models.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Sherin
 */

@Root(name = "Body", strict = false)
public class MultiplyResponseBody {

    @Element(name = "MultiplyResponse",required = false)
    private MultiplyResponseData multiplyResponseData;

    public MultiplyResponseData getMultiplyResponseData() {
        return multiplyResponseData;
    }

    public void setMultiplyResponseData(MultiplyResponseData brailleTextResponseData) {
        this.multiplyResponseData = brailleTextResponseData;
    }

    @Override
    public String toString() {
        return "MultiplyResponseBody{" +
                "brailleTextResponseData=" + multiplyResponseData +
                '}';
    }
}
