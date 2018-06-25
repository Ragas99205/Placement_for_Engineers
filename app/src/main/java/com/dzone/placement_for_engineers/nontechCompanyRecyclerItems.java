package com.dzone.placement_for_engineers;

public class nontechCompanyRecyclerItems {
    private String name;
    private String ctc;
    private String type;
    private String url;
    private String wiki;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCtc() {
        return ctc;
    }

    public void setCtc(String ctc) {
        this.ctc = ctc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWiki() {
        return wiki;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }

    public nontechCompanyRecyclerItems(String name, String ctc, String type, String url, String wiki) {
        this.name = name;
        this.ctc = ctc;
        this.type = type;
        this.url = url;
        this.wiki = wiki;
    }
}
