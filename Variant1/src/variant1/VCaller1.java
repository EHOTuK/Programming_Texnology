/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package variant1;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author oam2
 */
public class VCaller1 {

    private ArrayList<String> data;

    public VCaller1() {
        data = new ArrayList();
    }

    /**
     * Метод добавления элементов в список
     *
     * @param el - элемент, который добавляем
     */
    public void addElementList(String el) {
        data.add(el);
    }

    /**
     * Выбирает из вектора элементы, содержащие заданную строку
     *
     * @param s заданная строка
     * @return вектор выбранных элементов
     */
    public ArrayList<String> filter(String s) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < data.size(); ++i) {
            String s1 = data.get(i);
            if (s1.contains(s)) {
                res.add(s1);
            }
        }
        return res;
    }

    /**
     * Метод должен изменять порядок элементов вектора data
     *
     * @return false, если порядок изменен не верно, true - верно
     */
    public boolean reverse() {
        ArrayList<String> rev = new ArrayList<>();
        boolean flag = false;
        for (int i = data.size() - 1; i >= 0; i--) {
            rev.add(data.get(i));
        }
        /**
         * один из способов, как это можно реализовать:
         *
         */
        ArrayList<String> dataRev = data;//присваиваем dataRev значения списка data
        Collections.reverse(dataRev);//меняем порядок элементов
        if (rev.equals(dataRev)) {//если rev и dataRev равны
            flag = true;//то меняем флаг на true
        }
        return flag;
    }

    /**
     * второй способ, которым можно реализовать
     *
     * @return false, если порядок изменен не верно, true - верно
     */
    public boolean reverse2() {
        ArrayList<String> rev = new ArrayList<>();
        boolean flag = true;
        for (int i = data.size() - 1; i >= 0; i--) {
            rev.add(data.get(i));
        }
        /**
         * Сравниваю по элементу сначала исходного списка с каждым элементом с
         * конца реверсивного списка. Если есть несовпадения, то меняем флаг на
         * false
         */
        int sizeList = data.size();
        for (int j = 1; j <= sizeList; j++) {
            if (data.get(j - 1) != rev.get(sizeList - j)) {
                flag = false;
            }
        }
        return flag;
    }
}
