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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class StaticAssetDescriptionImplDiffblueTest {
  /**
   * Test {@link StaticAssetDescriptionImpl#cloneEntity()}.
   *
   * <p>Method under test: {@link StaticAssetDescriptionImpl#cloneEntity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StaticAssetDescription StaticAssetDescriptionImpl.cloneEntity()"})
  public void testCloneEntity() {
    // Arrange and Act
    StaticAssetDescription actualCloneEntityResult = new StaticAssetDescriptionImpl().cloneEntity();

    // Assert
    assertTrue(actualCloneEntityResult instanceof StaticAssetDescriptionImpl);
    assertNull(actualCloneEntityResult.getId());
    assertNull(actualCloneEntityResult.getDescription());
    assertNull(actualCloneEntityResult.getLongDescription());
  }

  /**
   * Test {@link StaticAssetDescriptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * StaticAssetDescriptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse StaticAssetDescriptionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    StaticAssetDescriptionImpl staticAssetDescriptionImpl = new StaticAssetDescriptionImpl();

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new StaticAssetDescriptionImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StaticAssetDescription> actualCreateOrRetrieveCopyInstanceResult =
        staticAssetDescriptionImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link StaticAssetDescriptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * StaticAssetDescriptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse StaticAssetDescriptionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    StaticAssetDescriptionImpl staticAssetDescriptionImpl = new StaticAssetDescriptionImpl();

    StaticAssetDescriptionImpl staticAssetDescriptionImpl2 = new StaticAssetDescriptionImpl();
    staticAssetDescriptionImpl2.setDescription("The characteristics of someone or something");
    staticAssetDescriptionImpl2.setId(1L);
    staticAssetDescriptionImpl2.setLongDescription("Long Description");
    CreateResponse<Object> createResponse =
        new CreateResponse<>(staticAssetDescriptionImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StaticAssetDescription> actualCreateOrRetrieveCopyInstanceResult =
        staticAssetDescriptionImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StaticAssetDescriptionImpl}
   *   <li>{@link StaticAssetDescriptionImpl#setDescription(String)}
   *   <li>{@link StaticAssetDescriptionImpl#setId(Long)}
   *   <li>{@link StaticAssetDescriptionImpl#setLongDescription(String)}
   *   <li>{@link StaticAssetDescriptionImpl#getDescription()}
   *   <li>{@link StaticAssetDescriptionImpl#getId()}
   *   <li>{@link StaticAssetDescriptionImpl#getLongDescription()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetDescriptionImpl.<init>()",
    "String StaticAssetDescriptionImpl.getDescription()",
    "Long StaticAssetDescriptionImpl.getId()",
    "String StaticAssetDescriptionImpl.getLongDescription()",
    "void StaticAssetDescriptionImpl.setDescription(String)",
    "void StaticAssetDescriptionImpl.setId(Long)",
    "void StaticAssetDescriptionImpl.setLongDescription(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StaticAssetDescriptionImpl actualStaticAssetDescriptionImpl = new StaticAssetDescriptionImpl();
    actualStaticAssetDescriptionImpl.setDescription("The characteristics of someone or something");
    actualStaticAssetDescriptionImpl.setId(1L);
    actualStaticAssetDescriptionImpl.setLongDescription("Long Description");
    String actualDescription = actualStaticAssetDescriptionImpl.getDescription();
    Long actualId = actualStaticAssetDescriptionImpl.getId();

    // Assert
    assertEquals("Long Description", actualStaticAssetDescriptionImpl.getLongDescription());
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(1L, actualId.longValue());
  }
}
