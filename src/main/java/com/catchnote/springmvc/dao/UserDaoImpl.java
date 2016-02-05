package com.catchnote.springmvc.dao;

import com.catchnote.springmvc.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;


@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    public User findById(int id) {
        getSession().beginTransaction();
        User user = getByKey(id);
        getSession().getTransaction().commit();
        return user;

    }

    public void saveUser(User user) {
        getSession().beginTransaction();
        persist(user);
        getSession().getTransaction().commit();
    }

    public void deleteUserByEmail(String email) {
        Query query = getSession().createSQLQuery("delete from Users where email = :email");
        query.setString("email", email);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        getSession().beginTransaction();
        Criteria criteria = createEntityCriteria();
        List<User> users = (List<User>) criteria.list();
        getSession().getTransaction().commit();
        return users;
    }

    public User findUserByEmail(String email) {
        getSession().beginTransaction();
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("email", email));
        User user = (User) criteria.uniqueResult();
        getSession().getTransaction().commit();
        return user;
    }


    public User findUserByName(String name) {
        getSession().getTransaction().begin();
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        User user = (User) criteria.uniqueResult();
        getSession().getTransaction().commit();
        return user;
    }

    public boolean isValidUser(String username, String password) {
        try {
            List users = getSession()
                    .createSQLQuery("select count(1) from users where username=?")
                    .setParameter(1, username).list();
            if (users.size() > 0) {
                User user = (User) users.get(0);
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                String digestOfInput = new BigInteger(md5.digest(password.getBytes())).toString(16);
                if (user.getName().equals(username) && user.getPass().equals(digestOfInput)) return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}