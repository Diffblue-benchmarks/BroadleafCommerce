/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.file.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import java.sql.Blob;
import org.junit.Test;

public class StaticAssetStorageImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StaticAssetStorageImpl}
   *   <li>{@link StaticAssetStorageImpl#setFileData(Blob)}
   *   <li>{@link StaticAssetStorageImpl#setId(Long)}
   *   <li>{@link StaticAssetStorageImpl#setStaticAssetId(Long)}
   *   <li>{@link StaticAssetStorageImpl#getFileData()}
   *   <li>{@link StaticAssetStorageImpl#getId()}
   *   <li>{@link StaticAssetStorageImpl#getStaticAssetId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StaticAssetStorageImpl actualStaticAssetStorageImpl = new StaticAssetStorageImpl();
    Blob fileData = mock(Blob.class);
    actualStaticAssetStorageImpl.setFileData(fileData);
    actualStaticAssetStorageImpl.setId(1L);
    actualStaticAssetStorageImpl.setStaticAssetId(1L);
    Blob actualFileData = actualStaticAssetStorageImpl.getFileData();
    Long actualId = actualStaticAssetStorageImpl.getId();
    Long actualStaticAssetId = actualStaticAssetStorageImpl.getStaticAssetId();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertEquals(1L, actualStaticAssetId.longValue());
    assertSame(fileData, actualFileData);
  }
}
