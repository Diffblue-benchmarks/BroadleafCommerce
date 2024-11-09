/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Type;
import org.junit.Test;

public class FieldInfoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FieldInfo}
   *   <li>{@link FieldInfo#setGenericType(Type)}
   *   <li>{@link FieldInfo#setManyToManyMappedBy(String)}
   *   <li>{@link FieldInfo#setManyToManyTargetEntity(String)}
   *   <li>{@link FieldInfo#setMapKey(String)}
   *   <li>{@link FieldInfo#setName(String)}
   *   <li>{@link FieldInfo#setOneToManyMappedBy(String)}
   *   <li>{@link FieldInfo#setOneToManyTargetEntity(String)}
   *   <li>{@link FieldInfo#getGenericType()}
   *   <li>{@link FieldInfo#getManyToManyMappedBy()}
   *   <li>{@link FieldInfo#getManyToManyTargetEntity()}
   *   <li>{@link FieldInfo#getMapKey()}
   *   <li>{@link FieldInfo#getName()}
   *   <li>{@link FieldInfo#getOneToManyMappedBy()}
   *   <li>{@link FieldInfo#getOneToManyTargetEntity()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FieldInfo actualFieldInfo = new FieldInfo();
    TypePlaceHolder genericType = new TypePlaceHolder(1);
    actualFieldInfo.setGenericType(genericType);
    actualFieldInfo.setManyToManyMappedBy("Many To Many Mapped By");
    actualFieldInfo.setManyToManyTargetEntity("Many To Many Target Entity");
    actualFieldInfo.setMapKey("Map Key");
    actualFieldInfo.setName("Name");
    actualFieldInfo.setOneToManyMappedBy("One To Many Mapped By");
    actualFieldInfo.setOneToManyTargetEntity("One To Many Target Entity");
    Type actualGenericType = actualFieldInfo.getGenericType();
    String actualManyToManyMappedBy = actualFieldInfo.getManyToManyMappedBy();
    String actualManyToManyTargetEntity = actualFieldInfo.getManyToManyTargetEntity();
    String actualMapKey = actualFieldInfo.getMapKey();
    String actualName = actualFieldInfo.getName();
    String actualOneToManyMappedBy = actualFieldInfo.getOneToManyMappedBy();

    // Assert that nothing has changed
    assertEquals("Many To Many Mapped By", actualManyToManyMappedBy);
    assertEquals("Many To Many Target Entity", actualManyToManyTargetEntity);
    assertEquals("Map Key", actualMapKey);
    assertEquals("Name", actualName);
    assertEquals("One To Many Mapped By", actualOneToManyMappedBy);
    assertEquals("One To Many Target Entity", actualFieldInfo.getOneToManyTargetEntity());
    assertSame(genericType, actualGenericType);
  }
}
