package ru.hh.school.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;


public class Dao {

    private static volatile SessionFactory sessionFactory;

    public Dao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    //метод объявлен как static, поскульку при вызове synchronazed static метода блокирутеся доступ ко всему
    //объекту типа Dao
    public static synchronized Object save(Object object){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(object);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return object;
    }

    //метод объявлен как static, поскульку при вызове synchronazed static метода блокирутеся доступ ко всему
    //объекту типа Dao
    public static synchronized <TypeOfObject> TypeOfObject findById(Class<TypeOfObject> clazz, Long id){
        Session session = sessionFactory.openSession();
        TypeOfObject object = null;
        object =  session.get(clazz,id);
        session.close();
        return object;
    }

    //метод объявлен как static, поскульку при вызове synchronazed static метода блокирутеся доступ ко всему
    //объекту типа Dao
    public static synchronized List getQueryList(String query, Integer firstNumberOfObject, Integer maxCountObjects){
        Session session = sessionFactory.openSession();
        List listOfObjects = null;
        listOfObjects = session.createQuery(query)
                               .setFirstResult(firstNumberOfObject)
                               .setMaxResults(maxCountObjects)
                               .list();
        session.close();
        return listOfObjects;

    }

    //метод объявлен как static, поскульку при вызове synchronazed static метода блокирутеся доступ ко всему
    //объекту типа Dao
    public static  synchronized  void update(Object object){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(object);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

    //метод объявлен как static, поскульку при вызове synchronazed static метода блокирутеся доступ ко всему
    //объекту типа Dao
    public static  synchronized void delete(Object object){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(object);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

}
