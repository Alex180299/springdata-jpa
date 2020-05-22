package com.api.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad del estado de la escuela persistente en la base por medio de JPA
 */
@Entity
@Table(name = "states")
public class State implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String code;

    @OneToMany(mappedBy = "state", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<School> schools;

    /**
     * Constructor vacio
     */
    public State(){
        schools = new ArrayList<School>();
    }

    /**
     * Constructor con todos los atributos como parámetro
     * @param id Id de la escuela (Por defecto la base lo asigna)
     * @param name Nombre de la escuela
     * @param country País a donde pertenece el estado
     * @param code Codigo del estado
     */
    public State(Long id, String name, String country, String code) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.code = code;
    }

    /**
     * Método para añadir una escuela a la lista de escuelas
     * @param school Escuela que se añadira en la lista
     */
    public void addSchool(School school){
        schools.add(school);
    }

    /**
     * Método getter de la lista de escuelas
     * @return List<School> Una lista de escuelas
     */
    public List<School> getSchools() {
        return schools;
    }

    /**
     * Método setter para la lista de escuelas
     * @param schools Lista de escuelas
     */
    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

    /**
     * Método getter el código del estado
     * @return String con el código del estado
     */
    public String getCode() {
        return code;
    }

    /**
     * Método setter para el código del estado
     * @param code Codigo del estado correspondiente
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Método getter del id del estado
     * @return Long con el id del estado en la base de datos
     */
    public Long getId() {
        return id;
    }

    /**
     * Método setter para el id del estado
     * @param id Este parámetro no importa mucho ya que la base le asigna un id por defecto
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método getter del nombre del estado
     * @return String con el nombre
     */
    public String getName() {
        return name;
    }

    /**
     * Método setter del nombre del estado
     * @param name Nombre del estado
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método getter del país al que pertenece el estado
     * @return String del país al que pertenece
     */
    public String getCountry() {
        return country;
    }

    /**
     * Método setter para el país del estado
     * @param country Nombre del país al que pertenece el estado
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
