package com.jshio.breadboard.service;

import javax.persistence.TransactionRequiredException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jshio.breadboard.domain.NaverProfile;

@Component
public class BbService 
{
	private static final Logger logger = LoggerFactory.getLogger(BbService.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void setNaverProfile(NaverProfile naverProfile)
	{
		try ( Session session = sessionFactory.openSession() )
		{
			Transaction transaction = session.getTransaction();
			transaction.begin();
			session.saveOrUpdate(naverProfile);
			transaction.commit();
		}
		catch(TransactionRequiredException e)
		{
			logger.error(e.getMessage());
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
	}
	
	public NaverProfile getNaverProfile(long id)
	{
		try ( Session session = sessionFactory.openSession() )
		{
			NaverProfile naverProfile = session.get(NaverProfile.class, id);
			return naverProfile;
		}
		catch(TransactionRequiredException e)
		{
			logger.error(e.getMessage());
			return null;
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			return null;
		}
	}
	
}