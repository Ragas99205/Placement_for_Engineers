package com.dzone.placement_for_engineers;

public class coreCompanyRecyclerItems {
    private String name;
    private String ctc;
    private String pref_stream;
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

    public String getPref_stream() {
        return pref_stream;
    }

    public void setPref_stream(String pref_stream) {
        this.pref_stream = pref_stream;
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

    public coreCompanyRecyclerItems(String name, String ctc, String pref_stream, String url, String wiki) {
        this.name = name;
        this.ctc = ctc;
        this.pref_stream = pref_stream;
        this.url = url;
        this.wiki = wiki;
    }
}
