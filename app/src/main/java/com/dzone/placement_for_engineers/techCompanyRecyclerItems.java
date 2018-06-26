package com.dzone.placement_for_engineers;

public class techCompanyRecyclerItems {
    private String name;
    private String ctc;
    private String role;
    private String type;
    private String url;
    private String wiki;

    public techCompanyRecyclerItems(String name, String ctc, String role, String type, String url, String wiki) {
        this.name = name;
        this.ctc = ctc;
        this.role = role;
        this.type = type;
        this.url = url;
        this.wiki = wiki;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
}
