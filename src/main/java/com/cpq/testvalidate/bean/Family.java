package com.cpq.testvalidate.bean;

public class Family{
    private Integer num;
    private Mom mom;
    private House house;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Mom getMom() {
        return mom;
    }

    public void setMom(Mom mom) {
        this.mom = mom;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    static class Mom {
        private String momName;
        private String kindness;

        public String getMomName() {
            return momName;
        }

        public void setMomName(String momName) {
            this.momName = momName;
        }

        public String getKindness() {
            return kindness;
        }

        public void setKindness(String kindness) {
            this.kindness = kindness;
        }
    }
}
