package com.cpq.testvalidate.bean;

public class House{
    private Double area;
    private String houseName;
    private Window window;

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    static class Window{
        private Integer windowHeight;
        private Integer windowWidth;

        public Integer getWindowHeight() {
            return windowHeight;
        }

        public void setWindowHeight(Integer windowHeight) {
            this.windowHeight = windowHeight;
        }

        public Integer getWindowWidth() {
            return windowWidth;
        }

        public void setWindowWidth(Integer windowWidth) {
            this.windowWidth = windowWidth;
        }
    }
}