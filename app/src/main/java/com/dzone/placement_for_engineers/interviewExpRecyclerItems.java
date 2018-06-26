package com.dzone.placement_for_engineers;

public class interviewExpRecyclerItems {
    private String name;
    private String title;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public interviewExpRecyclerItems(String name, String title, String desc) {
        name = name;
        this.title = title;
        this.desc = desc;
    }
}
