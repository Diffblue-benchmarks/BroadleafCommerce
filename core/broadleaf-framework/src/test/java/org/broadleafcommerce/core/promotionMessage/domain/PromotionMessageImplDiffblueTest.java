/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.promotionMessage.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.media.domain.MediaImpl;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryMediaXrefImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class PromotionMessageImplDiffblueTest {
  /**
   * Method under test: {@link PromotionMessageImpl#getPriority()}
   */
  @Test
  public void testGetPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(2147483646, (new PromotionMessageImpl()).getPriority());
  }

  /**
   * Method under test: {@link PromotionMessageImpl#getPriority()}
   */
  @Test
  public void testGetPriority2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl.setLocale(new LocaleImpl());
    promotionMessageImpl.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setPriority(1);

    // Act and Assert
    assertEquals(1, promotionMessageImpl.getPriority());
  }

  /**
   * Method under test: {@link PromotionMessageImpl#getPriority()}
   */
  @Test
  public void testGetPriority3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setEndDate(mock(java.sql.Date.class));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl.setLocale(new LocaleImpl());
    promotionMessageImpl.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl
        .setStartDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setPriority(1);

    // Act and Assert
    assertEquals(1, promotionMessageImpl.getPriority());
  }

  /**
   * Method under test: {@link PromotionMessageImpl#getStartDate()}
   */
  @Test
  public void testGetStartDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PromotionMessageImpl()).getStartDate());
  }

  /**
   * Method under test: {@link PromotionMessageImpl#getStartDate()}
   */
  @Test
  public void testGetStartDate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setArchived('Y');

    // Act and Assert
    assertNull(promotionMessageImpl.getStartDate());
  }

  /**
   * Method under test: {@link PromotionMessageImpl#getArchived()}
   */
  @Test
  public void testGetArchived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('N', (new PromotionMessageImpl()).getArchived().charValue());
  }

  /**
   * Method under test: {@link PromotionMessageImpl#getArchived()}
   */
  @Test
  public void testGetArchived2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setMedia(mock(MediaImpl.class));

    // Act and Assert
    assertEquals('N', promotionMessageImpl.getArchived().charValue());
  }

  /**
   * Method under test: {@link PromotionMessageImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();

    // Act
    promotionMessageImpl.setArchived('A');

    // Assert
    assertEquals('A', promotionMessageImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', promotionMessageImpl.getArchived().charValue());
  }

  /**
   * Method under test: {@link PromotionMessageImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setMedia(mock(MediaImpl.class));

    // Act
    promotionMessageImpl.setArchived('A');

    // Assert
    assertEquals('A', promotionMessageImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', promotionMessageImpl.getArchived().charValue());
  }

  /**
   * Method under test: {@link PromotionMessageImpl#isActive()}
   */
  @Test
  public void testIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PromotionMessageImpl()).isActive());
  }

  /**
   * Method under test: {@link PromotionMessageImpl#isActive()}
   */
  @Test
  public void testIsActive2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl.setLocale(new LocaleImpl());
    promotionMessageImpl.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl.setArchived(null);
    promotionMessageImpl
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(promotionMessageImpl.isActive());
  }

  /**
   * Method under test: {@link PromotionMessageImpl#isActive()}
   */
  @Test
  public void testIsActive3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl.setLocale(new LocaleImpl());
    promotionMessageImpl.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl.setArchived('Y');
    promotionMessageImpl
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setEndDate(null);

    // Act and Assert
    assertFalse(promotionMessageImpl.isActive());
  }

  /**
   * Method under test: {@link PromotionMessageImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PromotionMessageImpl()).getMainEntityName());
  }

  /**
   * Method under test: {@link PromotionMessageImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setMedia(mock(MediaImpl.class));

    // Act and Assert
    assertNull(promotionMessageImpl.getMainEntityName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessageImpl#equals(Object)}
   *   <li>{@link PromotionMessageImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl.setLocale(new LocaleImpl());
    promotionMessageImpl.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    PromotionMessageImpl promotionMessageImpl2 = new PromotionMessageImpl();
    promotionMessageImpl2
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl2.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl2.setLocale(new LocaleImpl());
    promotionMessageImpl2.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl2.setMessage("Promotion Message");
    promotionMessageImpl2.setMessagePlacement("Message Location");
    promotionMessageImpl2.setName("Name");
    promotionMessageImpl2.setPriority(1);
    promotionMessageImpl2
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertEquals(promotionMessageImpl, promotionMessageImpl2);
    int expectedHashCodeResult = promotionMessageImpl.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessageImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessageImpl#equals(Object)}
   *   <li>{@link PromotionMessageImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl.setLocale(mock(Locale.class));
    promotionMessageImpl.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    PromotionMessageImpl promotionMessageImpl2 = new PromotionMessageImpl();
    promotionMessageImpl2
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl2.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl2.setLocale(new LocaleImpl());
    promotionMessageImpl2.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl2.setMessage("Promotion Message");
    promotionMessageImpl2.setMessagePlacement("Message Location");
    promotionMessageImpl2.setName("Name");
    promotionMessageImpl2.setPriority(1);
    promotionMessageImpl2
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertEquals(promotionMessageImpl, promotionMessageImpl2);
    int expectedHashCodeResult = promotionMessageImpl.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessageImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessageImpl#equals(Object)}
   *   <li>{@link PromotionMessageImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl.setLocale(new LocaleImpl());
    promotionMessageImpl.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertEquals(promotionMessageImpl, promotionMessageImpl);
    int expectedHashCodeResult = promotionMessageImpl.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessageImpl.hashCode());
  }

  /**
   * Method under test:
   * {@link PromotionMessageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<PromotionMessage> actualCreateOrRetrieveCopyInstanceResult = promotionMessageImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.core.promotionMessage.domain.PromotionMessageImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    PromotionMessage clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof PromotionMessageImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(promotionMessageImpl, clone);
  }

  /**
   * Method under test:
   * {@link PromotionMessageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PromotionMessage> actualCreateOrRetrieveCopyInstanceResult = promotionMessageImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Method under test:
   * {@link PromotionMessageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setPriority(1);

    PromotionMessageImpl promotionMessageImpl2 = new PromotionMessageImpl();
    promotionMessageImpl2
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl2.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl2.setLocale(new LocaleImpl());
    promotionMessageImpl2.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl2.setMessage("Promotion Message");
    promotionMessageImpl2.setMessagePlacement("Message Location");
    promotionMessageImpl2.setName("Name");
    promotionMessageImpl2.setPriority(1);
    promotionMessageImpl2
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(promotionMessageImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    promotionMessageImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Method under test: {@link PromotionMessageImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(2L);
    promotionMessageImpl.setLocale(new LocaleImpl());
    promotionMessageImpl.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    PromotionMessageImpl promotionMessageImpl2 = new PromotionMessageImpl();
    promotionMessageImpl2
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl2.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl2.setLocale(new LocaleImpl());
    promotionMessageImpl2.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl2.setMessage("Promotion Message");
    promotionMessageImpl2.setMessagePlacement("Message Location");
    promotionMessageImpl2.setName("Name");
    promotionMessageImpl2.setPriority(1);
    promotionMessageImpl2
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertNotEquals(promotionMessageImpl, promotionMessageImpl2);
  }

  /**
   * Method under test: {@link PromotionMessageImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl.setLocale(new LocaleImpl());
    promotionMessageImpl.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertNotEquals(promotionMessageImpl, null);
  }

  /**
   * Method under test: {@link PromotionMessageImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl.setLocale(new LocaleImpl());
    promotionMessageImpl.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertNotEquals(promotionMessageImpl, "Different type to PromotionMessageImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessageImpl#setEndDate(Date)}
   *   <li>{@link PromotionMessageImpl#setId(Long)}
   *   <li>{@link PromotionMessageImpl#setLocale(Locale)}
   *   <li>{@link PromotionMessageImpl#setMedia(Media)}
   *   <li>{@link PromotionMessageImpl#setMessage(String)}
   *   <li>{@link PromotionMessageImpl#setMessagePlacement(String)}
   *   <li>{@link PromotionMessageImpl#setName(String)}
   *   <li>{@link PromotionMessageImpl#setPriority(Integer)}
   *   <li>{@link PromotionMessageImpl#setStartDate(Date)}
   *   <li>{@link PromotionMessageImpl#getEndDate()}
   *   <li>{@link PromotionMessageImpl#getId()}
   *   <li>{@link PromotionMessageImpl#getLocale()}
   *   <li>{@link PromotionMessageImpl#getMedia()}
   *   <li>{@link PromotionMessageImpl#getMessage()}
   *   <li>{@link PromotionMessageImpl#getMessagePlacement()}
   *   <li>{@link PromotionMessageImpl#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    Date endDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    promotionMessageImpl.setEndDate(endDate);
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    LocaleImpl locale = new LocaleImpl();
    promotionMessageImpl.setLocale(locale);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessageImpl.setMedia(media);
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Date actualEndDate = promotionMessageImpl.getEndDate();
    Long actualId = promotionMessageImpl.getId();
    Locale actualLocale = promotionMessageImpl.getLocale();
    Media actualMedia = promotionMessageImpl.getMedia();
    String actualMessage = promotionMessageImpl.getMessage();
    String actualMessagePlacement = promotionMessageImpl.getMessagePlacement();

    // Assert that nothing has changed
    assertEquals("Message Location", actualMessagePlacement);
    assertEquals("Name", promotionMessageImpl.getName());
    assertEquals("Promotion Message", actualMessage);
    assertEquals(PromotionMessageImpl.serialVersionUID, actualId.longValue());
    assertSame(locale, actualLocale);
    assertSame(media, actualMedia);
    assertSame(endDate, actualEndDate);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PromotionMessageImpl}
   */
  @Test
  public void testNewPromotionMessageImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    PromotionMessageImpl actualPromotionMessageImpl = new PromotionMessageImpl();

    // Assert
    assertEquals('N', actualPromotionMessageImpl.archiveStatus.getArchived().charValue());
    assertEquals('N', actualPromotionMessageImpl.getArchived().charValue());
    assertNull(actualPromotionMessageImpl.priority);
    assertNull(actualPromotionMessageImpl.getId());
    assertNull(actualPromotionMessageImpl.getMainEntityName());
    assertNull(actualPromotionMessageImpl.getMessage());
    assertNull(actualPromotionMessageImpl.getMessagePlacement());
    assertNull(actualPromotionMessageImpl.getName());
    assertNull(actualPromotionMessageImpl.getEndDate());
    assertNull(actualPromotionMessageImpl.getStartDate());
    assertNull(actualPromotionMessageImpl.startDate);
    assertNull(actualPromotionMessageImpl.getLocale());
    assertNull(actualPromotionMessageImpl.getMedia());
    assertEquals(2147483646, actualPromotionMessageImpl.getPriority());
  }
}
