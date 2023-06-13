package com.example.relaxwikiapi.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class AddOnDTO {
    @NotEmpty
    private String type;
    private String category;
    private List<String> name;

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
