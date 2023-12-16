package com.eventmanagement.restapi.model;

import jakarta.persistence.*;

import java.util.Set;
@Entity (name ="espaco")

public class EspacoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 50)
    public String name;
    @Column(nullable = false, length = 50)
    public String location;
    @Column(nullable = false, length = 50)
    public String capacity;
    @Column(nullable = false, length = 50)
    public String resources;


    @ManyToOne
    @JoinColumn(name = "evento_id")
    private EventoModel evento;

    @ManyToOne
    @JoinColumn(name = "edicao_id")
    private EdicaoModel edicao;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public EventoModel getEvento() {
        return evento;
    }

    public void setEvento(EventoModel evento) {
        this.evento = evento;
    }

    public EdicaoModel getEdicao() {
        return edicao;
    }

    public void setEdicao(EdicaoModel edicao) {
        this.edicao = edicao;
    }
}



