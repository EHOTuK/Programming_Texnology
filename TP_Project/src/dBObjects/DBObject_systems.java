package dBObjects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * объекты таблицы "системы"
 */
public class DBObject_systems {

    private int s_id;
    private String title;
    private String desc;
    private int pic_id;

    public DBObject_systems() {
    }

    public void getDBObject_systems(int id, Connection con) throws SQLException {
        String query = "SELECT * from systems where S_ID = " + id;
        Statement stmt = null;//для выполнения простых запросов без параметров
        ResultSet rs = null;
        stmt = con.createStatement();

        rs = stmt.executeQuery(query);//выполняет запрос
        if (rs.next()) {
            s_id = rs.getInt(1);
            title = rs.getString(2);
            desc = rs.getString(3);
            pic_id = rs.getInt(4);
        }
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
