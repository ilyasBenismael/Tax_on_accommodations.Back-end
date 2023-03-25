package com.example.taxe_sejour.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "NotificationLocale")
public class NotificationLocale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  String ref;
    @ManyToOne
    private Local locale;
    @ManyToOne
    private Redevable redevable;
    @ManyToOne
    private Notification notification;

    private Double mtBaseEstime;
    private String methodEstime;



    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Local getLocale() {
        return locale;
    }

    public void setLocale(Local locale) {
        this.locale = locale;
    }

    public Redevable getRedevable() {
        return redevable;
    }

    public void setRedevable(Redevable redevable) {
        this.redevable = redevable;
    }

    public Double getMtBaseEstime() {
        return mtBaseEstime;
    }

    public void setMtBaseEstime(Double mtBaseEstime) {
        this.mtBaseEstime = mtBaseEstime;
    }

    public String getMethodEstime() {
        return methodEstime;
    }

    public void setMethodEstime(String methodEstime) {
        this.methodEstime = methodEstime;
    }
}
