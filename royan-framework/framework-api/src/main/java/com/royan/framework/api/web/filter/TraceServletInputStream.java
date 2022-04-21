package com.royan.framework.api.web.filter;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.IOException;

/**
 * @author Qiurz
 * @date 2020/4/15
 */
public class TraceServletInputStream extends ServletInputStream {

    ServletInputStream servletInputStream;
    private StringBuilder buffer;

    public TraceServletInputStream(ServletInputStream inputStream) {
        this.servletInputStream = inputStream;
        this.buffer = new StringBuilder();
    }

    @Override
    public int read() throws IOException {
        int data = this.servletInputStream.read();
        this.buffer.append((char)data);
        return data;
    }

    public int read(byte[] b) throws IOException {
        int data = this.servletInputStream.read(b);
        if (data > 0) {
            this.buffer.append(new String(b));
        }

        return data;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        int data = this.servletInputStream.read(b, off, len);
        if (data > 0) {
            this.buffer.append(new String(b, off, data));
        }

        return data;
    }

    public int readLine(byte[] b, int off, int len) throws IOException {
        int data = this.servletInputStream.readLine(b, off, len);
        if (data > 0) {
            this.buffer.append(new String(b, off, data));
        }

        return data;
    }

    public String getContent() {
        return this.buffer.toString();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setReadListener(ReadListener readListener) {

    }

}
