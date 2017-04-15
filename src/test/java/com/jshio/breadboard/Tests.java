package com.jshio.breadboard;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jshio.breadboard.domain.Board;

public class Tests
{
	private static final Logger logger = LoggerFactory.getLogger(Tests.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void test()
	{
		Board board = null;
		try ( Session session = sessionFactory.openSession() ) 
		{
			board = session.get(Board.class, 1);
			
			System.out.println( board.getTitle() );
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		assertNotNull(new String(""));
		
	}
}
