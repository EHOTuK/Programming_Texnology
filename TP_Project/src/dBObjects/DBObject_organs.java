package dBObjects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс описывает поля таблицы БД organs и доступ к этим полям
 */
public class DBObject_organs {

    private int o_id;
    private int s_id;
    private String title;
    private String desc;
    private int pic_id;

    public DBObject_organs() {
    }

    /**
     * Метод получения информации из БД по id записи и присваивание значений
     * переменным, описанным в классе DBObject_organs(объекту)
     *
     * @param id - идентефикатор записи в таблице БД
     */
    public void getDBObject_organs(int id) { //получает id в качестве параметра
        DB_Connect dbcon = new DB_Connect(); //создаем объект класса соединения
        String query = "SELECT * from organs where o_id = " + id; //запрос по идентефикатору
        Statement stmt = null; //для выполнения простых запросов без параметров
        ResultSet rs = null; //переменная для хранения результатов запроса
        Connection con = dbcon.getConnection(); //получаем соединение с БД
        try {
            stmt = con.createStatement();

            rs = stmt.executeQuery(query);//выполняет запрос
            if (rs.next()) {
                //присваиваем значение переменным объекта
                o_id = rs.getInt(1);//из результата запроса извлекаем 1 - значение поля o_id
                s_id = rs.getInt(2);//из результата запроса извлекаем 2 - значение поля s_id
                title = rs.getString(3);//из результата запроса извлекаем 3 - значение поля title
                desc = rs.getString(4);//и т.д. для каждой переменной
                pic_id = rs.getInt(5);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBObject_organs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPic_id() {
        return pic_id;
    }

    public void setPic_id(int pic_id) {
        this.pic_id = pic_id;
    }

}
