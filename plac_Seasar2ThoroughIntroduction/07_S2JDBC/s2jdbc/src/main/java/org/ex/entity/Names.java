package org.ex.entity;

import javax.annotation.Generated;
import org.ex.entity.DeptNames._DeptNames;
import org.ex.entity.EmpNames._EmpNames;

/**
 * 名前クラスの集約です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesAggregateModelFactoryImpl"}, date = "2017/11/26 19:08:08")
public class Names {

    /**
     * {@link Dept}の名前クラスを返します。
     * 
     * @return Deptの名前クラス
     */
    public static _DeptNames dept() {
        return new _DeptNames();
    }

    /**
     * {@link Emp}の名前クラスを返します。
     * 
     * @return Empの名前クラス
     */
    public static _EmpNames emp() {
        return new _EmpNames();
    }
}