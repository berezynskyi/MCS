package entity;

/**
 * Сутність,яка відповідає таблиці MedicalUnit.
 * @author Anton Netudykhata and Max Berezynskyi
 *         22.03.2015.
 *
 */

public class MedicalUnit extends ConscriptCard {

    /**
     * Ідентифікатор медичної картки
     */
    private Integer idMedicalUnit;

    /**
     * Коментар медичного спеціаліста
     */
    private String comment;

    /**
     * Ідентифікатор картки призовника
     */
    private Integer idConscriptCard;

    /**
     * Ідентифікатор медичного спеціаліста
     */
    private Integer idMedicalSpecialist;

    /**
     *  Конструктор класу MedicalUnit
     * @param comment коментар медичного спеціаліста
     * @param idConscriptCard ідентифікатор картки призовника
     * @param idMedicalSpecialist ідентифікатор медичного спеціаліста
     */
    public MedicalUnit(String comment, int idConscriptCard, int idMedicalSpecialist) {
        this.comment = comment;
        this.idConscriptCard = idConscriptCard;
        this.idMedicalSpecialist = idMedicalSpecialist;
    }

    /**
     *  Пустий конструктор класу MedicalUnit
     */
    public MedicalUnit(){
    }

    //----------GETTERS----------

    /**
     * Повертає ідентифікатор медичної картки
     * @return ідентифікатор медичної картки
     */
    public Integer getIdMedicalUnit() {
        return idMedicalUnit;
    }

    /**
     * Повертає коментар медичного спеціаліста
     * @return коментар медичного спеціаліста
     */
    public String getComment() {
        return comment;
    }

    /**
     * Повертає ідентифікатор картки призовника
     * @return ідентифікатор картки призовника
     */
    public Integer getIdConscriptCard() {
        return idConscriptCard;
    }

    /**
     * Повертає ідентифікатор медичного спеціаліста
     * @return ідентифікатор медичного спеціаліста
     */
    public Integer getIdMedicalSpecialist() {
        return idMedicalSpecialist;
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
     * Встановлює ідентифікатор медичної картки
     * @param idMedicalUnit ідентифікатор медичної картки
     */
    public void setIdMedicalUnit(Integer idMedicalUnit) {
        this.idMedicalUnit = idMedicalUnit;
    }

    /**
     * Встановлює ідентифікатор картки призовника
     * @param idConscriptCard ідентифікатор картки призовника
     */
    public void setIdConscriptCard(Integer idConscriptCard) {
        this.idConscriptCard = idConscriptCard;
    }

    /**
     * Встановлює коментар медичного спеціаліста
     * @param comment коментар медичного спеціаліста
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
