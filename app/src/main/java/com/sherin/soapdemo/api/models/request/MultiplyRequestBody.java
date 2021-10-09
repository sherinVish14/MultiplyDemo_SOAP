package com.sherin.soapdemo.api.models.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Sherin
 */

@Root(name = "soap12:Body", strict = false)
public class MultiplyRequestBody {

    @Element(name = "Multiply",required = false)
    private MultiplyRequestData multiplyRequestData;

    public MultiplyRequestData getMultiplyRequestData() {
        return multiplyRequestData;
    }

    public void setMultiplyRequestData(MultiplyRequestData multiplyRequestData) {
        this.multiplyRequestData = multiplyRequestData;
    }
}
