/**
 * Copyright 2016 SivaLabs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions 
 * and limitations under the License.
 */
package com.sivalabs.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UsersImporter usersImporter;
	
	@Secured("ROLE_ADMIN")
	public void deleteUser(Integer userId)
	{
		userRepository.delete(userId);
	}
	
	@Secured("ROLE_USER")
	public void createUser(User user)
	{
		userRepository.save(user);
	}
	
	//@Secured("IS_AUTHENTICATED_FULLY")
	@PreAuthorize("isAuthenticated()")
	public void updateUser(User user)
	{
		userRepository.save(user);
	}
	
	public UsersImportResponse importUsers() {
		int retryCount = 0;
		int maxRetryCount = 3;
		for (int i = 0; i < maxRetryCount; i++)
		{
			try
			{
				List<User> importUsers = usersImporter.importUsers();
				System.out.println("Import Users: "+importUsers);
				break;
			} catch (UserImportServiceCommunicationFailure e)
			{
				retryCount++;
				System.err.println("Error: "+e.getMessage());
			}
		}
		if(retryCount >= maxRetryCount)
			return new UsersImportResponse(retryCount, "FAILURE");
		else
			return new UsersImportResponse(0, "SUCCESS");
	}
}
