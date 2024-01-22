/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * SPDX-License-Identifier: Apache-2.0
 * Copyright: Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.models.internal.dynamic;

import java.lang.reflect.Member;

import org.hibernate.models.internal.MutableMemberDetails;
import org.hibernate.models.spi.ClassDetails;
import org.hibernate.models.spi.FieldDetails;
import org.hibernate.models.spi.SourceModelBuildingContext;

/**
 * @author Steve Ebersole
 */
public class DynamicFieldDetails extends AbstractAnnotationTarget implements FieldDetails, MutableMemberDetails {
	private final String name;
	private final ClassDetails type;
	private final ClassDetails declaringType;
	private final int modifierFlags;

	public DynamicFieldDetails(
			String name,
			ClassDetails type,
			ClassDetails declaringType,
			int modifierFlags,
			SourceModelBuildingContext buildingContext) {
		super( buildingContext );
		this.name = name;
		this.type = type;
		this.declaringType = declaringType;
		this.modifierFlags = modifierFlags;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ClassDetails getType() {
		return type;
	}

	@Override
	public ClassDetails getDeclaringType() {
		return declaringType;
	}

	@Override
	public int getModifiers() {
		return modifierFlags;
	}

	@Override
	public Member toJavaMember() {
		return null;
	}

	@Override
	public String toString() {
		return "DynamicFieldDetails(" + name + ")";
	}
}
