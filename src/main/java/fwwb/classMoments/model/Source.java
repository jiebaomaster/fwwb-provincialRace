package fwwb.classMoments.model;

public class Source {
    private Integer id;

    private String surl;

    private String stype;

    private Integer inMomentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl == null ? null : surl.trim();
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype == null ? null : stype.trim();
    }

    public Integer getInMomentId() {
        return inMomentId;
    }

    public void setInMomentId(Integer inMomentId) {
        this.inMomentId = inMomentId;
    }
}