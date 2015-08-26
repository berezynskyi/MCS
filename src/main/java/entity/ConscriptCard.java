package entity;

/**
 * Сутність,яка відповідає таблиці ConscriptCard.
 * @author Anton Netudykhata and Max Berezynskyi
 *         22.03.2015.
 *
 */

public class ConscriptCard {

    /**
     * Ідентифікатор картки призовника
     */
    private int idconscriptCardId;

    /**
     * Ім'я призовника
     */
    private String name;

    /**
     * Призвіще призовника
     */
    private String surname;

    /**
     * По-батькові призовника
     */
    private String fathersName;

    /**
     * Мобільний номер призовника
     */
    private String phoneNumber;

    /**
     * Паспортні дані призовника
     */
    private String passportData;

    /**
     * Дата народження призовника
     */
    private String dateOfBirth;

    /**
     * Адреса призовника
     */
    private String adress;

    /**
     *  Конструктор класу ConscriptCard
     * @param name ім'я призовника
     * @param surname призвіще призовника
     * @param fathersName по-батькові призовника
     * @param phoneNumber номер телефону призовника
     * @param passportData паспортні дані призовника
     * @param dateOfBirth дата народження призовника
     * @param adress адреса призовника
     */
    public ConscriptCard(String name, String surname, String fathersName, String phoneNumber,
                         String passportData, String dateOfBirth, String adress ) {
        this.name = name;
        this.surname = surname;
        this.fathersName = fathersName;
        this.phoneNumber = phoneNumber;
        this.passportData = passportData;
        this.dateOfBirth = dateOfBirth;
        this.adress = adress;
    }

    /**
     *  Пустий конструктор класу ConscriptCard
     */
    public ConscriptCard() {
    }

//=======GETTERS=========

    /**
     * Повертає ідентифікатор картки призовника
     * @return ідентифікатор картки призовника
     */
    public int getIdconscriptCardId() {
        return idconscriptCardId;
    }

    /**
     * Повертає ім'я призовника
     * @return ім'я призовника
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає дату народження призовника
     * @return дату народження призовника
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Повертає адресу призовника
     * @return адресу призовника
     */
    public String getAdress() {
        return adress;
    }

    /**
     * Повертає призвіще призовника
     * @return призвіще призовника
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Повертає по-батькові призовника
     * @return по-батькові призовника
     */
    public String getFathersName() {
        return fathersName;
    }

    /**
     * Повертає номер телефона призовника
     * @return номер телефона призовника
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Повертає паспортні дані призовника
     * @return паспортні дані призовника
     */
    public String getPassportData() {
        return passportData;
    }

//==========SETERS=========

    /**
     * Встановлює ідентифікатор картки призовника
     * @param idconscriptCardId ідентифікатор картки призовника
     */
    public void setIdconscriptCardId(int idconscriptCardId) {
        this.idconscriptCardId = idconscriptCardId;
    }

    /**
     * Встановлює ім'я призовника
     * @param name ім'я призовника
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Встановлює дату народження призовника
     * @param dateOfBirth дату народження призовника
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Встановлює адресу призовника
     * @param adress адресу призовника
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * Встановлює призвіще призовника
     * @param surname призвіще призовника
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Встановлює по-батькові призовника
     * @param fathersName по-батькові призовника
     */
    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    /**
     * Встановлює номер телефону призовника
     * @param phoneNumber номер телефону призовника
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Встановлює паспортні дані призовника
     * @param passportData паспортні дані призовника
     */
    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }
}
