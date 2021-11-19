package org.helb.baseproject.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "history")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public int user;
    public int song;
}
