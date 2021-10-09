package com.sherin.soapdemo.api.models.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by Sherin P Saleem
 */

@Root(name = "Multiply", strict = false)
@Namespace(reference = "http://tempuri.org")
public class MultiplyRequestData {

    @Element(name = "intA", required = false)
    private String intA;
    @Element(name = "intB", required = false)
    private String intB;

    public String getIntA() {
        return intA;
    }

    public void setIntA(String intA) {
        this.intA = intA;
    }

    public String getIntB() {
        return intB;
    }

    public void setIntB(String intB) {
        this.intB = intB;
    }

}
