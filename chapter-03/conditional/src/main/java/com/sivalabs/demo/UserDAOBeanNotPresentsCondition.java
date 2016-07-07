/**
 * 
 */
package com.sivalabs.demo;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Siva
 *
 */
public class UserDAOBeanNotPresentsCondition implements Condition
{

	@Override
	public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata)
	{
		UserDAO userDAO = conditionContext.getBeanFactory().getBean(UserDAO.class);
		return (userDAO == null);		
	}

}
