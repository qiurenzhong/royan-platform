package com.royan.framework.api.web.filter;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.IOException;

/**
 * @author Qiurz
 * @date 2020/4/15
 */
public class TraceServletOutputStream extends ServletOutputStream {

    private ServletOutputStream outputStream;
    private StringBuilder buffer;

    public TraceServletOutputStream(ServletOutputStream outputStream) {
        this.outputStream = outputStream;
        this.buffer = new StringBuilder();
    }

    public void write(int b) throws IOException {
        this.outputStream.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        super.write(b, off, len);
        if (b.length > 0) {
            this.buffer.append(new String(b, off, len));
        }

    }

    public void write(byte[] b) throws IOException {
        super.write(b);
        if (b.length > 0) {
            this.buffer.append(new String(b));
        }

    }

    public boolean isReady() {
        return false;
    }

    public void setWriteListener(WriteListener writeListener) {
    }

    public String getContent() {
        return this.buffer.toString();
    }
}
