/**
 * 
 */
package com.sivalabs.demo.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.demo.entities.Role;
import com.sivalabs.demo.entities.User;
import com.sivalabs.demo.repositories.UserRepository;



/**
 * @author Siva
 *
 */
@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService
{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		User user = userRepository.findByEmail(userName);
		if(user == null){
			throw new UsernameNotFoundException("Email "+userName+" not found");
		}
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(), 
				user.getPassword(),
				getAuthorities(user)
				);
	}

	
	private static Collection<? extends GrantedAuthority> getAuthorities(User user)
	{
		Set<String> userRoles = new HashSet<>();
		List<Role> roles = user.getRoles();
		
		for (Role role : roles)
		{
			userRoles.add(role.getName());
		}
		String[] roleNames = new String[userRoles.size()];
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles.toArray(roleNames));
		return authorities;
	}
}
