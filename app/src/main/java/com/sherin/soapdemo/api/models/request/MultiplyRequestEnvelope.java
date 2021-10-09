package com.sherin.soapdemo.api.models.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by Sherin
 */

@Root(name = "soap12:Envelope")
@NamespaceList({
        @Namespace( prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace( prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace( prefix = "soap12", reference = "http://schemas.xmlsoap.org/soap/envelope")
})
public class MultiplyRequestEnvelope {

    @Element(name = "soap12:Body", required = false)
    private MultiplyRequestBody body;

    public MultiplyRequestBody getBody() {
        return body;
    }

    public void setBody(MultiplyRequestBody body) {
        this.body = body;
    }
}
