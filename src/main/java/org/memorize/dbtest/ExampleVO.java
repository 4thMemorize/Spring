package org.memorize.dbtest;

public class ExampleVO {
    private Integer id;
    private String name;
    private String tel;
    private String postcode;

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "ExampleVO [id: " + Integer.toString(id) + ", name: " + name + ", tel: " + tel + ", postcode: " + postcode + "]";
    }
}
