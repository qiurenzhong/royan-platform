package com.royan.framework.api.web.filter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Qiurz
 * @date 2020/4/15
 */
public class TraceServletResponseWrapper extends HttpServletResponseWrapper {

    TraceServletOutputStream traceServletOutputStream;
    HttpServletResponse response;

    public TraceServletResponseWrapper(HttpServletResponse response) {
        super(response);
        this.response = response;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return super.getWriter();
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if (!FilterUtils.shouldTracer((HttpServletRequest)null, this.response)) {
            return super.getOutputStream();
        } else {
            if (null == this.traceServletOutputStream) {
                this.traceServletOutputStream = new TraceServletOutputStream(super.getOutputStream());
            }

            return this.traceServletOutputStream;
        }
    }

    public TraceServletOutputStream getTraceServletOutputStream() {
        return this.traceServletOutputStream;
    }
}
