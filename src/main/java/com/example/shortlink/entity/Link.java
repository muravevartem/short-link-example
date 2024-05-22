package com.example.shortlink.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("link_map")
@Getter
@Setter
public class Link {
    @Id
    @Column("link_id")
    private Integer id;

    @Column("original_link")
    private String original;

    @Column("hash_link")
    private String hash;

    public Link() {
    }

    public Link(String original, String hash) {
        this.original = original;
        this.hash = hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Link that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
