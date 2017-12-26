package org.ex.service;

import java.util.List;
import javax.annotation.Generated;
import org.ex.entity.Dept;

import static org.ex.entity.DeptNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link Dept}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2017/11/26 19:07:22")
public class DeptService extends AbstractService<Dept> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param id
     *            識別子
     * @return エンティティ
     */
    public Dept findById(Long id) {
        return select().id(id).getSingleResult();
    }

    /**
     * 識別子とバージョン番号でエンティティを検索します。
     * 
     * @param id
     *            識別子
     * @param versionNo
     *            バージョン番号
     * @return エンティティ
     */
    public Dept findByIdVersion(Long id, Integer versionNo) {
        return select().id(id).version(versionNo).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<Dept> findAllOrderById() {
        return select().orderBy(asc(id())).getResultList();
    }
}