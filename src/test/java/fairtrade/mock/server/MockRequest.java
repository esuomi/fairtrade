package fairtrade.mock.server;

import org.simpleframework.http.*;

import javax.net.ssl.SSLSession;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.channels.ReadableByteChannel;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 20.2.2013
 */
public class MockRequest implements Request {
    private String method;
    private byte[] body;

    public MockRequest(byte[] body) {
        this.body = body;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public boolean isKeepAlive() {
        return false;
    }

    @Override
    public long getRequestTime() {
        return 0;
    }

    @Override
    public SSLSession getSecuritySession() {
        return null;
    }

    @Override
    public InetSocketAddress getClientAddress() {
        return null;
    }

    @Override
    public Map getAttributes() {
        return null;
    }

    @Override
    public Object getAttribute(Object o) {
        return null;
    }

    @Override
    public String getParameter(String s) {
        return null;
    }

    @Override
    public Part getPart(String s) {
        return null;
    }

    @Override
    public List<Part> getParts() {
        return null;
    }

    @Override
    public String getContent() throws IOException {
        return null;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(body);
    }

    @Override
    public ReadableByteChannel getByteChannel() throws IOException {
        return null;
    }

    @Override
    public List<String> getNames() {
        return null;
    }

    @Override
    public int getInteger(String s) {
        return 0;
    }

    @Override
    public long getDate(String s) {
        return 0;
    }

    @Override
    public Cookie getCookie(String s) {
        return null;
    }

    @Override
    public List<Cookie> getCookies() {
        return null;
    }

    @Override
    public String getValue(String s) {
        return null;
    }

    @Override
    public List<String> getValues(String s) {
        return null;
    }

    @Override
    public List<Locale> getLocales() {
        return null;
    }

    @Override
    public boolean contains(String s) {
        return false;
    }

    @Override
    public ContentType getContentType() {
        return null;
    }

    @Override
    public long getContentLength() {
        return body.length;
    }

    @Override
    public CharSequence getHeader() {
        return null;
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public String getTarget() {
        return null;
    }

    @Override
    public Address getAddress() {
        return null;
    }

    @Override
    public Path getPath() {
        return null;
    }

    @Override
    public Query getQuery() {
        return null;
    }

    @Override
    public int getMajor() {
        return 1;
    }

    @Override
    public int getMinor() {
        return 1;
    }
}
