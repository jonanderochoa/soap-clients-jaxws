
package net.webservicex.biblia;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BibleWebservice", targetNamespace = "http://www.webserviceX.NET", wsdlLocation = "http://www.webservicex.net/BibleWebservice.asmx?WSDL")
public class BibleWebservice
    extends Service
{

    private final static URL BIBLEWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException BIBLEWEBSERVICE_EXCEPTION;
    private final static QName BIBLEWEBSERVICE_QNAME = new QName("http://www.webserviceX.NET", "BibleWebservice");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://www.webservicex.net/BibleWebservice.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BIBLEWEBSERVICE_WSDL_LOCATION = url;
        BIBLEWEBSERVICE_EXCEPTION = e;
    }

    public BibleWebservice() {
        super(__getWsdlLocation(), BIBLEWEBSERVICE_QNAME);
    }

    public BibleWebservice(WebServiceFeature... features) {
        super(__getWsdlLocation(), BIBLEWEBSERVICE_QNAME, features);
    }

    public BibleWebservice(URL wsdlLocation) {
        super(wsdlLocation, BIBLEWEBSERVICE_QNAME);
    }

    public BibleWebservice(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BIBLEWEBSERVICE_QNAME, features);
    }

    public BibleWebservice(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BibleWebservice(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BibleWebserviceSoap
     */
    @WebEndpoint(name = "BibleWebserviceSoap")
    public BibleWebserviceSoap getBibleWebserviceSoap() {
        return super.getPort(new QName("http://www.webserviceX.NET", "BibleWebserviceSoap"), BibleWebserviceSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BibleWebserviceSoap
     */
    @WebEndpoint(name = "BibleWebserviceSoap")
    public BibleWebserviceSoap getBibleWebserviceSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.webserviceX.NET", "BibleWebserviceSoap"), BibleWebserviceSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BIBLEWEBSERVICE_EXCEPTION!= null) {
            throw BIBLEWEBSERVICE_EXCEPTION;
        }
        return BIBLEWEBSERVICE_WSDL_LOCATION;
    }

}
