package housekeeper.bd.com.housekeeper.db;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import housekeeper.bd.com.housekeeper.db.Person;
import housekeeper.bd.com.housekeeper.db.Record;
import housekeeper.bd.com.housekeeper.db.Bill;

import housekeeper.bd.com.housekeeper.db.PersonDao;
import housekeeper.bd.com.housekeeper.db.RecordDao;
import housekeeper.bd.com.housekeeper.db.BillDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig personDaoConfig;
    private final DaoConfig recordDaoConfig;
    private final DaoConfig billDaoConfig;

    private final PersonDao personDao;
    private final RecordDao recordDao;
    private final BillDao billDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        personDaoConfig = daoConfigMap.get(PersonDao.class).clone();
        personDaoConfig.initIdentityScope(type);

        recordDaoConfig = daoConfigMap.get(RecordDao.class).clone();
        recordDaoConfig.initIdentityScope(type);

        billDaoConfig = daoConfigMap.get(BillDao.class).clone();
        billDaoConfig.initIdentityScope(type);

        personDao = new PersonDao(personDaoConfig, this);
        recordDao = new RecordDao(recordDaoConfig, this);
        billDao = new BillDao(billDaoConfig, this);

        registerDao(Person.class, personDao);
        registerDao(Record.class, recordDao);
        registerDao(Bill.class, billDao);
    }
    
    public void clear() {
        personDaoConfig.getIdentityScope().clear();
        recordDaoConfig.getIdentityScope().clear();
        billDaoConfig.getIdentityScope().clear();
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public RecordDao getRecordDao() {
        return recordDao;
    }

    public BillDao getBillDao() {
        return billDao;
    }

}
