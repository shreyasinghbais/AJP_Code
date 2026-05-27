package com.chatapp.dao;

import com.chatapp.model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class MessageDAOImpl implements MessageDAO {
    private SessionFactory sessionFactory;

    public MessageDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addMessage(Message message) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(message);
            tx.commit();
        }
    }

    @Override
    public List<Message> getMessagesByUser(int userId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Message WHERE sender.id = :userId OR receiver.id = :userId", Message.class)
                    .setParameter("userId", userId)
                    .list();
        }
    }

    @Override
    public List<Message> getMessagesByGroup(int groupId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Message WHERE group.id = :groupId", Message.class)
                    .setParameter("groupId", groupId)
                    .list();
        }
    }
}
