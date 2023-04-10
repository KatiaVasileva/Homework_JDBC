package hibernate.dao;

import hibernate.config.HibernateSessionFactoryUtil;
import hibernate.model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void addEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT s FROM Employee s").list();
        }
    }

    @Override
    public void updateEmployeeById(int id, Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employee.setId(id);
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            session.delete(employee);
            transaction.commit();
        }
    }
}
