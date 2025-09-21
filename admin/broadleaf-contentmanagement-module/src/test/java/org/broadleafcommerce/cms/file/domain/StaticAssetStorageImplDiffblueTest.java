/*-
 * #%L
 * BroadleafCommerce CMS Module
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialBlob;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StaticAssetStorageImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageImpl.<init>()",
    "Blob StaticAssetStorageImpl.getFileData()",
    "Long StaticAssetStorageImpl.getId()",
    "Long StaticAssetStorageImpl.getStaticAssetId()",
    "void StaticAssetStorageImpl.setFileData(Blob)",
    "void StaticAssetStorageImpl.setId(Long)",
    "void StaticAssetStorageImpl.setStaticAssetId(Long)"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException, SQLException {
    // Arrange and Act
    StaticAssetStorageImpl actualStaticAssetStorageImpl = new StaticAssetStorageImpl();
    SerialBlob fileData = new SerialBlob("AXAXAXAX".getBytes("UTF-8"));
    actualStaticAssetStorageImpl.setFileData(fileData);
    actualStaticAssetStorageImpl.setId(1L);
    actualStaticAssetStorageImpl.setStaticAssetId(1L);
    Blob actualFileData = actualStaticAssetStorageImpl.getFileData();
    Long actualId = actualStaticAssetStorageImpl.getId();
    Long actualStaticAssetId = actualStaticAssetStorageImpl.getStaticAssetId();

    // Assert
    assertEquals(1L, actualId.longValue());
    assertEquals(1L, actualStaticAssetId.longValue());
    assertSame(fileData, actualFileData);
  }
}
