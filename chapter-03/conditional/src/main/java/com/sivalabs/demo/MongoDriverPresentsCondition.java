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
public class MongoDriverPresentsCondition implements Condition
{

	@Override
	public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata)
	{
		try
		{
			Class.forName("com.mongodb.Server");
			return true;
		} catch (ClassNotFoundException e)
		{
			return false;
		}
	}
}
