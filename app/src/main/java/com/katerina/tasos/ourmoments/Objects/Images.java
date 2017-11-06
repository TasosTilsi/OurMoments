package com.katerina.tasos.ourmoments.Objects;

/**
 * Created by tilsakos on 6/11/2017.
 */

public class Images {
    private int id;
    private String name;
    private String cloudLink;

    public Images() {

    }

    public Images(int id, String name, String cloudLink) {

        this.id = id;
        this.name = name;
        this.cloudLink = cloudLink;
    }

    public Images(String name, String cloudLink) {
        this.name = name;
        this.cloudLink = cloudLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCloudLink() {
        return cloudLink;
    }

    public void setCloudLink(String cloudLink) {
        this.cloudLink = cloudLink;
    }
}
