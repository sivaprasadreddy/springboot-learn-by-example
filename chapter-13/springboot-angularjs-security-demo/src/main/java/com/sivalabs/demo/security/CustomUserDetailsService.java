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
import org.springframework.stereotype.Component;

import com.sivalabs.demo.entities.Role;
import com.sivalabs.demo.entities.User;
import com.sivalabs.demo.repositories.UserRepository;


/**
 * @author Siva
 *
 */
@Component
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException
	{
		User user = repo.findByEmail(email);
		System.out.println("Email: "+email+", User: "+user);
		if(user == null) throw new UsernameNotFoundException("User not found");
		return new org.springframework.security.core.userdetails.User(
                user.getEmail(), 
                user.getPassword(),
                getAuthorities(user)
                );
    }

    
    private Collection<? extends GrantedAuthority> getAuthorities(User user)
    {
        Set<String> userRoles = new HashSet<>();
        List<Role> roles = user.getRoles();
        
        for (Role role : roles)
        {
            userRoles.add(role.getName());
        }
        String[] roleNames = new String[userRoles.size()];
        Collection<GrantedAuthority> authorities = 
            AuthorityUtils.createAuthorityList(userRoles.toArray(roleNames));
        return authorities;
    }
}
