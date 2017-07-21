package com.openmind.hacadaptor.socket.xml.model.common;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by LiuBin on 2017/6/28.
 */
@XmlRootElement(name = "DocumentProperties")
public class DocumentProperties {
    private String version;
    private String number;

    @XmlElement(name = "Version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlElement(name = "Number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
