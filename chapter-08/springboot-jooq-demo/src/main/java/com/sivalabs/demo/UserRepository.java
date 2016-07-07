/**
 * 
 */
package com.sivalabs.demo;

import static com.sivalabs.demo.jooq.domain.tables.Users.USERS;

import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.demo.jooq.domain.tables.records.UsersRecord;

/**
 * @author Siva
 *
 */
@Repository
public class UserRepository
{
		
	@Autowired
	private DSLContext dsl;
	
	@Transactional(readOnly=true)
	public List<User> findAll() {
		Result<Record> result = dsl.select().from(USERS).fetch();
		List<User> users = new ArrayList<>();
		for (Record r : result) {
		    Integer id = r.getValue(USERS.ID, Integer.class);
		    String name = r.getValue(USERS.NAME, String.class);
		    String email = r.getValue(USERS.EMAIL, String.class);

		    users.add(new User(id, name, email));
		}
		return users;		
	}

	@Transactional(readOnly=true)
	public User findUserById(int id) {
		Record record = dsl.select().from(USERS).where(USERS.ID.eq(id)).fetchOne();
		if(record != null){
			Integer idVal = record.getValue(USERS.ID, Integer.class);
		    String name = record.getValue(USERS.NAME, String.class);
		    String email = record.getValue(USERS.EMAIL, String.class);
		    
		    return new User(idVal, name, email);
		}
		return null;
	}

	public User create(final User user) {
		
		UsersRecord usersRecord = dsl.insertInto(USERS)
			.set(USERS.NAME, user.getName())
			.set(USERS.EMAIL, user.getEmail())
			.returning(USERS.ID)
			.fetchOne();
		
		user.setId(usersRecord.getId());
		return user;
	}
}
