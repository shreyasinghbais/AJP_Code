package com.chatapp.dao;

import com.chatapp.model.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class GroupDAOImpl implements GroupDAO {
    private SessionFactory sessionFactory;

    public GroupDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addGroup(Group group) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(group);
            tx.commit();
        }
    }

    @Override
    public Group getGroup(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Group.class, id);
        }
    }

    @Override
    public Group getGroupByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Group WHERE name = :name", Group.class)
                    .setParameter("name", name)
                    .uniqueResult();
        }
    }

    @Override
    public List<Group> getAllGroups() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Group", Group.class).list();
        }
    }
}
