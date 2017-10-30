package com.book.demo.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Controllers")
@XmlType(propOrder = {"Controller"})
public class Controllers implements Serializable {

    private static final long serialVersionUID = 1858480386705537937L;

    private List<Controller> Controller;

    public List<com.book.demo.domain.Controller> getController() {
        return Controller;
    }

    public void setController(List<com.book.demo.domain.Controller> controller) {
        Controller = controller;
    }

    @Override
    public String toString() {
        return "Controllers{" +
                "Controller=" + Controller +
                '}';
    }
}
