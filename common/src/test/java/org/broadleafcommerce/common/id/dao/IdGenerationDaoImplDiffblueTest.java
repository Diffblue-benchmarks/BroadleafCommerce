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
package org.broadleafcommerce.common.id.dao;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IdGenerationDaoImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IdGenerationDaoImpl#setDefaultBatchSize(Long)}
   *   <li>{@link IdGenerationDaoImpl#setDefaultBatchStart(Long)}
   *   <li>{@link IdGenerationDaoImpl#getDefaultBatchSize()}
   *   <li>{@link IdGenerationDaoImpl#getDefaultBatchStart()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    IdGenerationDaoImpl idGenerationDaoImpl = new IdGenerationDaoImpl();

    // Act
    idGenerationDaoImpl.setDefaultBatchSize(3L);
    idGenerationDaoImpl.setDefaultBatchStart(1L);
    Long actualDefaultBatchSize = idGenerationDaoImpl.getDefaultBatchSize();

    // Assert that nothing has changed
    assertEquals(1L, idGenerationDaoImpl.getDefaultBatchStart().longValue());
    assertEquals(3L, actualDefaultBatchSize.longValue());
  }
}
