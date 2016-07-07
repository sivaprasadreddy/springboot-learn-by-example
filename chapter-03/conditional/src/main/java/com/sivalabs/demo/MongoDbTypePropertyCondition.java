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
public class MongoDbTypePropertyCondition implements Condition
{

	@Override
	public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata)
	{
		String dbType = conditionContext.getEnvironment().getProperty("app.dbType");
		return "MONGO".equalsIgnoreCase(dbType);
	}
}
