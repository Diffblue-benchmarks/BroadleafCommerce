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
package org.broadleafcommerce.cms.file.dao;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Blob;
import org.broadleafcommerce.cms.file.domain.StaticAssetStorage;
import org.broadleafcommerce.cms.file.domain.StaticAssetStorageImpl;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StaticAssetStorageDaoImplDiffblueTest {
  @Mock
  private EntityConfiguration entityConfiguration;

  @InjectMocks
  private StaticAssetStorageDaoImpl staticAssetStorageDaoImpl;

  /**
   * Test {@link StaticAssetStorageDaoImpl#create()}.
   * <p>
   * Method under test: {@link StaticAssetStorageDaoImpl#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StaticAssetStorage StaticAssetStorageDaoImpl.create()"})
  public void testCreate() {
    // Arrange
    StaticAssetStorageImpl staticAssetStorageImpl = new StaticAssetStorageImpl();
    staticAssetStorageImpl.setFileData(mock(Blob.class));
    staticAssetStorageImpl.setId(1L);
    staticAssetStorageImpl.setStaticAssetId(1L);
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(staticAssetStorageImpl);

    // Act
    StaticAssetStorage actualCreateResult = staticAssetStorageDaoImpl.create();

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.cms.file.domain.StaticAssetStorage"));
    assertSame(staticAssetStorageImpl, actualCreateResult);
  }
}
