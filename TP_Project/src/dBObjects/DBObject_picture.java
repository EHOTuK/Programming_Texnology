package dBObjects;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Класс описывает поля таблицы БД picture и доступ к этим полям
 */
public class DBObject_picture {

    private int pic_id;

    public DBObject_picture() {
    }

    /**
     * Метод получения картинки из таблицы по ее id
     *
     * @param id - идентефикатор, получаемый из класса MainPanel по нажатию мыши
     * @param con - открытое соединение с БД
     * @return картинку
     */
    public BufferedImage getDBObject_picture(int id, Connection con) {
        BufferedImage pic = null;
        String pic_query = "SELECT * from picture where pic_id = ?";
        ResultSet rs = null;
        try {
            con.setAutoCommit(false); // работа с BLOB в Postgres должна идти без autocommit
            PreparedStatement pst = con.prepareStatement(pic_query);
            pst.setInt(1, id);

            rs = pst.executeQuery();//выполняет запрос
            if (rs.next()) {
                //считываем картинку и устанавливаем значение переменной pic
                byte[] imgBytes = rs.getBytes(2);
                pic = ImageIO.read(new ByteArrayInputStream(imgBytes));
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(DBObject_picture.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pic;
    }

    public int getPic_id() {
        return pic_id;
    }

    public void setPic_id(int pic_id) {
        this.pic_id = pic_id;
    }

}
