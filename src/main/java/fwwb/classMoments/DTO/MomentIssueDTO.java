package fwwb.classMoments.DTO;

import fwwb.classMoments.model.Source;

import java.util.List;

/**
 * Created by hongcj on 2017/5/1.
 */
public class MomentIssueDTO {

    private String content;

    private boolean is_top;

    private Source[] sources;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getIs_top() {
        return is_top;
    }

    public void setIs_top(boolean is_top) {
        this.is_top = is_top;
    }

    public Source[] getSources() {
        return sources;
    }

    public void setSources(Source[] sources) {
        this.sources = sources;
    }
}
