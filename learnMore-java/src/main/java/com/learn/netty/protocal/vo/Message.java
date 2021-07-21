package com.learn.netty.protocal.vo;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2021/7/21
 */
public final class Message {
    private Header header;

    private Object body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header myHeader) {
        this.header = myHeader;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Message{" +
                "myHeader=" + header +
                ", body=" + body +
                '}';
    }
}
