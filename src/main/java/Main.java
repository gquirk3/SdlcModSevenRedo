import entity.Tasks;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("HelloWorld");
    }
    public static List showList()
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        List list = new ArrayList();

        try{
            transaction.begin();

            list = entityManager.createQuery("SELECT a FROM Tasks a", Tasks.class).getResultList();

            for (Object task : list)
            {
                System.out.println(task);
            }

            transaction.commit();
        }finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return list;
    }
    public static void addItem(String item)
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

            Tasks tasks = new Tasks();
            tasks.setItem(item);
            entityManager.persist(tasks);
//            String add = "INSERT INTO " + Tasks.class.getName() + " (item)" + " VALUES (" + item + ")";
//            Query query = entityManager.createQuery(add);
//            query.executeUpdate();

            transaction.commit();
        }finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
    public static void removeItem(Integer index)
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

            String delete = "DELETE FROM " + Tasks.class.getName() + " i WHERE i.id=:id";
            Query query = entityManager.createQuery(delete).setParameter("id", index);
            query.executeUpdate();

            transaction.commit();
        }finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
    public static void searchItem(String index)  //injection experiment
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

//            String search = "SELECT * FROM tasks WHERE item= " + item;
//            entityManager.createQuery("DELETE a From Tasks a", Tasks.class);
            Query deleteTest = entityManager.createNativeQuery("DELETE FROM tasks WHERE item = :item");
            deleteTest.setParameter("item", index);
            deleteTest.executeUpdate();
//            String search = "DELETE FROM " + Tasks.class.getName() +" i WHERE i.item=:item";
//            Query query = entityManager.createQuery(search).setParameter("item", index);
//            query.executeUpdate();

            transaction.commit();
        }finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
