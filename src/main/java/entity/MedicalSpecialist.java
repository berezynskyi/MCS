package entity;

import java.io.Serializable;

/**
 * Сутність,яка відповідає таблиці MedicalSpecialist.
 * @author Anton Netudykhata and Max Berezynskyi
 *         22.03.2015.
 *
 */

public class MedicalSpecialist extends MedicalUnit implements Serializable {

    /**
     * Ідентифікатор медичного спеціаліста
     */
    private Integer idMedicalSpecialist;

    /**
     * Ім'я медичного спеціаліста
     */
    private String name;

    /**
     * Призвіще медичного спеціаліста
     */
    private String surname;

    /**
     * По-батькові медичного спеціаліста
     */
    private String fathersName;

    /**
     * Пароль медичного спеціаліста
     */
    private String password;

    /**
     * Посада медичного спеціаліста
     */
    private String rank;

    /**
     *  Конструктор класу MedicalSpecialist
     * @param name ім'я медичного спеціаліста
     * @param surname призвіще медичного спеціаліста
     * @param fathersName по-батькові пмедичного спеціаліста
     * @param password пароль медичного спеціаліста
     * @param rank посада медичного спеціаліста
     */
    public MedicalSpecialist(String name, String surname, String fathersName, String password, String rank) {
        this.name = name;
        this.surname = surname;
        this.fathersName = fathersName;
        this.password = password;
        this.rank = rank;
    }

    /**
     *  Пустий конструктор класу MedicalSpecialist
     */
    public MedicalSpecialist(){
    }

    //----------GETTERS----------

    /**
     * Повертає ідентифікатор медичного спеціаліста
     * @return ідентифікатор медичного спеціаліста
     */
    public Integer getIdMedicalSpecialist() {
        return idMedicalSpecialist;
    }

    /**
     * Повертає посаду медичного спеціаліста
     * @return посаду медичного спеціаліста
     */
    public String getRank() {
        return rank;
    }

    /**
     * Повертає ім'я медичного спеціаліста
     * @return ім'я медичного спеціаліста
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає призвіще медичного спеціаліста
     * @return призвіще медичного спеціаліста
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Повертає по-батькові медичного спеціаліста
     * @return по-батькові медичного спеціаліста
     */
    public String getFathersName() {
        return fathersName;
    }

    /**
     * Повертає пароль медичного спеціаліста
     * @return пароль медичного спеціаліста
     */
    public String getPassword() {
        return password;
    }

    //----------SETTERS----------

    /**
     * Встановлює ідентифікатор медичного спеціаліста
     * @param idMedicalSpecialist ідентифікатор медичного спеціаліста
     */
    public void setIdMedicalSpecialist(Integer idMedicalSpecialist) {
        this.idMedicalSpecialist = idMedicalSpecialist;
    }

    /**
     * Встановлює ім'я медичного спеціаліста
     * @param name ім'я медичного спеціаліста
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Встановлює призвіще медичного спеціаліста
     * @param surname призвіще медичного спеціаліста
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Встановлює пароль медичного спеціаліста
     * @param password пароль медичного спеціаліста
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Встановлює посаду медичного спеціаліста
     * @param rank посаду медичного спеціаліста
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * Встановлює по-батькові медичного спеціаліста
     * @param fathersName по-батькові медичного спеціаліста
     */
    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }
}
