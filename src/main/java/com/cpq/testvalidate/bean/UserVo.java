package com.cpq.testvalidate.bean;

import java.util.List;

public class UserVo extends User {

    private Friend friend;
    private Family family;
    private Goddess goddess;
    private List<String> hobbyList;
    private List<Dream> dreamList;
    private List<Baobao> baoBaoList;

    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Goddess getGoddess() {
        return goddess;
    }

    public void setGoddess(Goddess goddess) {
        this.goddess = goddess;
    }

    public List<String> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<String> hobbyList) {
        this.hobbyList = hobbyList;
    }

    public List<Dream> getDreamList() {
        return dreamList;
    }

    public void setDreamList(List<Dream> dreamList) {
        this.dreamList = dreamList;
    }

    public List<Baobao> getBaoBaoList() {
        return baoBaoList;
    }

    public void setBaoBaoList(List<Baobao> baoBaoList) {
        this.baoBaoList = baoBaoList;
    }
}


