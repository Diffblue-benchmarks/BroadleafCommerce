/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.dialect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.sql.BasicBinder;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;
import org.junit.Test;

public class PostgreSQLClobTypeDescriptorDiffblueTest {
  /**
   * Test {@link PostgreSQLClobTypeDescriptor#getClobBinder(JavaTypeDescriptor)}.
   * <p>
   * Method under test:
   * {@link PostgreSQLClobTypeDescriptor#getClobBinder(JavaTypeDescriptor)}
   */
  @Test
  public void testGetClobBinder() {
    // Arrange
    PostgreSQLClobTypeDescriptor postgreSQLClobTypeDescriptor = new PostgreSQLClobTypeDescriptor();
    JavaTypeDescriptor<Object> javaTypeDescriptor = mock(JavaTypeDescriptor.class);

    // Act
    BasicBinder<Object> actualClobBinder = postgreSQLClobTypeDescriptor.getClobBinder(javaTypeDescriptor);

    // Assert
    SqlTypeDescriptor sqlDescriptor = actualClobBinder.getSqlDescriptor();
    assertTrue(sqlDescriptor instanceof PostgreSQLClobTypeDescriptor);
    assertEquals(2005, sqlDescriptor.getSqlType());
    assertSame(postgreSQLClobTypeDescriptor, sqlDescriptor);
    assertSame(javaTypeDescriptor, actualClobBinder.getJavaDescriptor());
  }

  /**
   * Test new {@link PostgreSQLClobTypeDescriptor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PostgreSQLClobTypeDescriptor}
   */
  @Test
  public void testNewPostgreSQLClobTypeDescriptor() {
    // Arrange, Act and Assert
    assertEquals(2005, (new PostgreSQLClobTypeDescriptor()).getSqlType());
  }
}
