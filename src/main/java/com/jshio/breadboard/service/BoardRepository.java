package com.jshio.breadboard.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jshio.breadboard.domain.Board;

@Repository
public class BoardRepository implements CrudRepository<Board>
{
	private static final Logger logger = LoggerFactory.getLogger(BoardRepository.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Board findOne(long id)
	{
		
		Board entity = null;
		try ( Session session = sessionFactory.openSession() )
		{
			Query<?> query = session.getNamedQuery("HQL_GET_ALL_BOARD");
			query.setFetchSize(1);
			query.setMaxResults(1);
			entity = (Board)query.getSingleResult();
		}
		catch(Exception e)
		{
			logger.debug(e.getMessage());
		}
		return entity;
	}

	@Override
	public long save(Board entity)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long count()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long exists()
	{
		// TODO Auto-generated method stub
		return 0;
	}
	

}
