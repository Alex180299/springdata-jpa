package com.api.demo.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad de la escuela persistente en la base por medio de JPA
 */
@Entity
@Table(name = "schools")
public class School implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String website;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private State state;

    /**
     * Constructor vacío
     */
    public School(){}

    /**
     * Constructor con todos los atributos como parámetro
     * @param id Id de la escuela (Por defecto la base lo asigna)
     * @param name Nombre de la escuela
     * @param state Estado donde se encuentra la escuela
     * @param website Sitio web de la escuela
     */
    public School(Long id, String name, String website, State state) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.state = state;
    }

    /**
     * Método getter del estado de la escuela
     * @return Un objeto State
     */
    public State getState() {
        return state;
    }

    /**
     * Método setter del estado de la escuela
     * @param state Estado de la ubicación de la escuela
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Método getter del id de la escuela
     * @return Un objeto Long
     */
    public Long getId() {
        return id;
    }

    /**
     * Método setter del id de la escuela
     * @param id Id de la escuela en la base de datos
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método getter del nombre de la escuela
     * @return Un objeto String
     */
    public String getName() {
        return name;
    }

    /**
     * Método setter del nombre de la escuela
     * @param name Nombre de la escuela
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método getter del website de la escuela
     * @return Un objeto String
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Método setter del estado de la escuela
     * @param website Sitio web de la escuela
     */
    public void setWebsite(String website) {
        this.website = website;
    }
}
