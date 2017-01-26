package com.apn.sefma;

import java.net.URL;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.apn.sefma.dao.Domain;
import com.apn.sefma.dao.MotifCluster;
import com.apn.sefma.dao.Tffamily;

public class DataProvider {

	private static SessionFactory sessionFactory;
	
	private static SessionFactory getSessionFactory(){
		if(sessionFactory == null){
			URL url = Test.class.getResource("hibernate.cfg.xml");
			sessionFactory = new Configuration().configure(url).buildSessionFactory();
//			sessionFactory.openSession();
		}
		return sessionFactory;
	}
	
	private static Session getSession(){
		return getSessionFactory().openSession();
	} 
	
	
	public static List<Tffamily> getFamilies(){
		return getSession()
				.createCriteria(Tffamily.class)
				.addOrder(Order.asc("name"))
				.list();
	}
	
	public static Tffamily getFamily(int tffamilyId){
		return getSession().find(Tffamily.class, tffamilyId);
	}
	
	
	public static List<MotifCluster> getMotifClusters(int tffamilyId){
		return getSession()
				.createCriteria(MotifCluster.class)
				.add(Restrictions.eq("tfFamilyId", tffamilyId))
				.list();
	}
	
	public static List<Domain> getDomains(int tffamilyId){
		return getSession().createSQLQuery("select d.* from Domain d join TFFamily2Domain using(domainId) where familyId=" + tffamilyId)
				.addEntity(Domain.class)
				.list();
	}
	
	
}
