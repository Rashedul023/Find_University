package com.example.find_university;

public class MainModel {
    private String name;
    private String area;
    private String cgpa;
    private String country;
    private String fee;
    private String student;
    private String ielts;
    private String url;

    private String rank;

    public MainModel() {
        // Default constructor required for Firebase
    }

    public MainModel(String name, Long area, Double cgpa, String country, Long fee, Long student, Double ielts, String url,Long rank) {
        this.name = name;
        this.area = String.valueOf(area);
        this.cgpa = String.valueOf(cgpa);
        this.country = country;
        this.fee = String.valueOf(fee);
        this.student = String.valueOf(student);
        this.ielts = String.valueOf(ielts);
        this.url = url;
        this.rank = String.valueOf(rank);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getArea() {
        return Long.parseLong(area);
    }

    public void setArea(Long area) {
        this.area = String.valueOf(area);
    }

    public Double getCgpa() {
        return Double.parseDouble(cgpa);
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = String.valueOf(cgpa);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getFee() {
        return Long.parseLong(fee);
    }

    public void setFee(Long fee) {
        this.fee = String.valueOf(fee);
    }

    public Long getStudent() {
        return Long.parseLong(student);
    }

    public void setStudent(Long student) {
        this.student = String.valueOf(student);
    }

    public Double getIelts() {
        return Double.parseDouble(ielts);
    }

    public void setIelts(Double ielts) {
        this.ielts = String.valueOf(ielts);
    }

    public Long getRank(){
        return Long.parseLong(rank);
    }
    public void setRank(Long rank){
        this.rank = String.valueOf(rank);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
