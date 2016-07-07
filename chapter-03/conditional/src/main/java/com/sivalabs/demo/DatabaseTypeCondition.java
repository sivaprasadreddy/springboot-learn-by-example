/**
 * 
 */
package com.sivalabs.demo;

import java.util.Map;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Siva
 *
 */
public class DatabaseTypeCondition implements Condition
{
	@Override
	public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata)
	{
		Map<String, Object> attributes = metadata.getAnnotationAttributes(DatabaseType.class.getName());
		String type = (String) attributes.get("value");
		String enabledDBType = System.getProperty("dbType","MYSQL");
		return (enabledDBType != null && type != null && enabledDBType.equalsIgnoreCase(type));		
	}	
}
