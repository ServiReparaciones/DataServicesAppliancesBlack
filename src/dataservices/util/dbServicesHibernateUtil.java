/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataservices.util;

import com.logger.L;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author luis
 */
public class dbServicesHibernateUtil {
    
    private final static L log = new L(dbServicesHibernateUtil.class);
    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry sessionServiceRegistry;
    
    //procuraduria_hibernate.cfg
    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("/dbServices.cfg.xml");
            sessionServiceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(sessionServiceRegistry);
        } catch (Throwable ex) {
            log.level.info("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void init() {
        if (sessionFactory == null) {
            throw new NullPointerException("No se inicializo el tipo de producto previamente. No se creo la conexion.");
        } else {
            log.level.info("Se ha iniciado la sesion de Hiberate");
        }
    }
    
}
