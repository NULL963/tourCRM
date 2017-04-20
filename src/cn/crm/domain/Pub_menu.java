package cn.crm.domain;

/**
 * Created by LEMON on 2017/4/18.
 */
public class Pub_menu {
    private String id;
    private String text;
    private String uri;
    private int depth;
    private int lft;
    private int rht;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getLft() {
        return lft;
    }

    public void setLft(int lft) {
        this.lft = lft;
    }

    public int getRht() {
        return rht;
    }

    public void setRht(int rht) {
        this.rht = rht;
    }
}
