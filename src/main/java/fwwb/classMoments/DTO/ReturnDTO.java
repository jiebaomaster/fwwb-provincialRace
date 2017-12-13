package fwwb.classMoments.DTO;

/**
 * Created by hongcj on 2017/4/29.
 */
public class ReturnDTO {
    private String request_type;

    private String status;

    private Object body;

    public ReturnDTO() {
    }

    public ReturnDTO(String request_type, String status, Object body) {
        this.request_type = request_type;
        this.status = status;
        this.body = body;
    }

    public String getRequest_type() {
        return request_type;
    }

    public void setRequest_type(String request_type) {
        this.request_type = request_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
