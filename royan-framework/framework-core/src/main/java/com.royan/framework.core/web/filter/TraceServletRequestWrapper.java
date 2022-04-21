package com.royan.framework.core.web.filter;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

/**
 * @author Qiurz
 */
public class TraceServletRequestWrapper extends HttpServletRequestWrapper {

    TraceServletInputStream traceServletInputStream;

    public TraceServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (null == this.traceServletInputStream) {
            this.traceServletInputStream = new TraceServletInputStream(super.getInputStream());
        }
        return this.traceServletInputStream;
    }

    public TraceServletInputStream getTraceServletInputStream() {
        return this.traceServletInputStream;
    }
}
