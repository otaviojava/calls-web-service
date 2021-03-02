package my.compary.service;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class CallFilter {

    @QueryParam("type")
    private TypeCall type;

    @QueryParam("page")
    @DefaultValue("10")
    private int page;

    public TypeCall getType() {
        return type;
    }

    public void setType(TypeCall type) {
        this.type = type;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "CallFilter{" +
                "type=" + type +
                ", page=" + page +
                '}';
    }
}
