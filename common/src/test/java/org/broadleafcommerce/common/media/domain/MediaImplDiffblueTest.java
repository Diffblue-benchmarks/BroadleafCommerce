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
package org.broadleafcommerce.common.media.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.util.UnknownUnwrapTypeException;
import org.junit.Test;
import org.mockito.Mockito;

public class MediaImplDiffblueTest {
  /**
   * Test {@link MediaImpl#getTitle()}.
   * <p>
   * Method under test: {@link MediaImpl#getTitle()}
   */
  @Test
  public void testGetTitle() {
    // Arrange, Act and Assert
    assertNull((new MediaImpl()).getTitle());
  }

  /**
   * Test {@link MediaImpl#getAltText()}.
   * <p>
   * Method under test: {@link MediaImpl#getAltText()}
   */
  @Test
  public void testGetAltText() {
    // Arrange, Act and Assert
    assertNull((new MediaImpl()).getAltText());
  }

  /**
   * Test {@link MediaImpl#isUnwrappableAs(Class)}.
   * <p>
   * Method under test: {@link MediaImpl#isUnwrappableAs(Class)}
   */
  @Test
  public void testIsUnwrappableAs() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    Class<Object> unwrapType = Object.class;

    // Act and Assert
    assertFalse(mediaImpl.isUnwrappableAs(unwrapType));
  }

  /**
   * Test {@link MediaImpl#unwrap(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then throw {@link UnknownUnwrapTypeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaImpl#unwrap(Class)}
   */
  @Test
  public void testUnwrap_whenJavaLangObject_thenThrowUnknownUnwrapTypeException() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    Class<Object> unwrapType = Object.class;

    // Act and Assert
    assertThrows(UnknownUnwrapTypeException.class, () -> mediaImpl.unwrap(unwrapType));
  }

  /**
   * Test {@link MediaImpl#equals(Object)}, and {@link MediaImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MediaImpl#equals(Object)}
   *   <li>{@link MediaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(1L);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(mediaImpl, mediaImpl2);
    int expectedHashCodeResult = mediaImpl.hashCode();
    assertEquals(expectedHashCodeResult, mediaImpl2.hashCode());
  }

  /**
   * Test {@link MediaImpl#equals(Object)}, and {@link MediaImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MediaImpl#equals(Object)}
   *   <li>{@link MediaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(null);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(mediaImpl, mediaImpl2);
    int expectedHashCodeResult = mediaImpl.hashCode();
    assertEquals(expectedHashCodeResult, mediaImpl2.hashCode());
  }

  /**
   * Test {@link MediaImpl#equals(Object)}, and {@link MediaImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MediaImpl#equals(Object)}
   *   <li>{@link MediaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(1L);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(null);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(mediaImpl, mediaImpl2);
    int expectedHashCodeResult = mediaImpl.hashCode();
    assertEquals(expectedHashCodeResult, mediaImpl2.hashCode());
  }

  /**
   * Test {@link MediaImpl#equals(Object)}, and {@link MediaImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MediaImpl#equals(Object)}
   *   <li>{@link MediaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText(null);
    mediaImpl.setId(null);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText(null);
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(mediaImpl, mediaImpl2);
    int expectedHashCodeResult = mediaImpl.hashCode();
    assertEquals(expectedHashCodeResult, mediaImpl2.hashCode());
  }

  /**
   * Test {@link MediaImpl#equals(Object)}, and {@link MediaImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MediaImpl#equals(Object)}
   *   <li>{@link MediaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(null);
    mediaImpl.setTags(null);
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags(null);
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(mediaImpl, mediaImpl2);
    int expectedHashCodeResult = mediaImpl.hashCode();
    assertEquals(expectedHashCodeResult, mediaImpl2.hashCode());
  }

  /**
   * Test {@link MediaImpl#equals(Object)}, and {@link MediaImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MediaImpl#equals(Object)}
   *   <li>{@link MediaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(1L);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(mediaImpl, mediaImpl);
    int expectedHashCodeResult = mediaImpl.hashCode();
    assertEquals(expectedHashCodeResult, mediaImpl.hashCode());
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(2L);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, mediaImpl2);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Dr");
    mediaImpl.setId(null);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, mediaImpl2);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText(null);
    mediaImpl.setId(null);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, mediaImpl2);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(null);
    mediaImpl.setTags("Dr");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, mediaImpl2);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(null);
    mediaImpl.setTags(null);
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, mediaImpl2);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(null);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Mr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, mediaImpl2);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(null);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle(null);
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, mediaImpl2);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(null);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("Dr");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, mediaImpl2);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(null);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl(null);

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, mediaImpl2);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(1L);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, null);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(1L);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, "Different type to MediaImpl");
  }

  /**
   * Test {@link MediaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link MediaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(BLCFieldUtils.NULL_FIELD, true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<MediaImpl> actualCreateOrRetrieveCopyInstanceResult = mediaImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link MediaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then return not AlreadyPopulated.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenReturnNotAlreadyPopulated() throws CloneNotSupportedException {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<MediaImpl> actualCreateOrRetrieveCopyInstanceResult = mediaImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.common.media.domain.MediaImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(mediaImpl, actualCreateOrRetrieveCopyInstanceResult.getClone());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MediaImpl}
   *   <li>{@link MediaImpl#setAltText(String)}
   *   <li>{@link MediaImpl#setId(Long)}
   *   <li>{@link MediaImpl#setTags(String)}
   *   <li>{@link MediaImpl#setTitle(String)}
   *   <li>{@link MediaImpl#setUrl(String)}
   *   <li>{@link MediaImpl#getId()}
   *   <li>{@link MediaImpl#getTags()}
   *   <li>{@link MediaImpl#getUrl()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MediaImpl actualMediaImpl = new MediaImpl();
    actualMediaImpl.setAltText("Alt Text");
    actualMediaImpl.setId(1L);
    actualMediaImpl.setTags("Tags");
    actualMediaImpl.setTitle("Dr");
    actualMediaImpl.setUrl("https://example.org/example");
    Long actualId = actualMediaImpl.getId();
    String actualTags = actualMediaImpl.getTags();

    // Assert that nothing has changed
    assertEquals("Tags", actualTags);
    assertEquals("https://example.org/example", actualMediaImpl.getUrl());
    assertEquals(1L, actualId.longValue());
  }
}
