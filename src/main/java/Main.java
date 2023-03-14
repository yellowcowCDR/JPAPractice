import commonCode.OrderStatus;
import domain.Item;
import domain.Member;
import domain.OrderItem;
import domain.Orders;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pracPersistence");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try{
            Member member = new Member();
            member.setName("davids");
            member.setCity("seoul");
            member.setStreet("SiHeungDaeRo");
            member.setZipcode("12345");

            em.persist(member);

            Orders order = new Orders();
            order.setOrderStatus(OrderStatus.ORDER);
            order.changeMember(member);
            order.setOrderDate(LocalDateTime.now());
            em.persist(order);

            Item item = new Item();
            item.setName("apple");
            item.setPrice(9900);
            item.setStockQuantity(100);
            em.persist(item);

            OrderItem orderItem = new OrderItem();
            orderItem.setCount(2);
            orderItem.setOrderPrice(19800);
            orderItem.changeOrder(order);
            orderItem.changeItem(item);
            em.persist(orderItem);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
