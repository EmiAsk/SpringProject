package ru.tinkoff.edu.java.scrapper.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "chat")
@Getter
@Setter
@Accessors(chain = true)
public class Chat {

    @Id
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "chat_link",
            joinColumns = @JoinColumn(name = "chat_id"),
            inverseJoinColumns = @JoinColumn(name = "link_id")
    )
    private Set<Link> links = new HashSet<>();

}
