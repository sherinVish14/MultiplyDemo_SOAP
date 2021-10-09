package com.sherin.soapdemo.api.models.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by Sherin P Saleem
 */

@Root(name = "soap12:Envelope")
@NamespaceList({
        @Namespace( prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace( prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace( prefix = "soap12", reference = "http://schemas.xmlsoap.org/soap/envelope")
})
public class MultiplyResponseEnvelope {

    @Element(name = "Body", required = false)
    private MultiplyResponseBody body;

    public MultiplyResponseBody getBody() {
        return body;
    }

    public void setBody(MultiplyResponseBody body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "MultiplyResponseEnvelope{" +
                "body=" + body +
                '}';
    }
}
