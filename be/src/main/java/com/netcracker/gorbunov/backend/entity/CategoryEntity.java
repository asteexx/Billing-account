package com.netcracker.gorbunov.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "space_chanels", catalog = "")
public class CategoryEntity {
    private int id;
    private String nameCategory;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name_category")
    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return id == that.id &&
                Objects.equals(nameCategory, that.nameCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameCategory);
    }
}
