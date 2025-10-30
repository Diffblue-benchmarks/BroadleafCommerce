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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryMediaXrefImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class PromotionMessageImplDiffblueTest {
  @Autowired
  private PromotionMessageImpl promotionMessageImpl;

  /**
   * Test {@link PromotionMessageImpl#getPriority()}.
   * <ul>
   *   <li>Given {@link PromotionMessageImpl} (default constructor).</li>
   *   <li>Then return {@link Integer#MAX_VALUE} less one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessageImpl#getPriority()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int PromotionMessageImpl.getPriority()"})
  public void testGetPriority_givenPromotionMessageImpl_thenReturnMax_valueLessOne() {
    // Arrange, Act and Assert
    assertEquals(2147483646, (new PromotionMessageImpl()).getPriority());
  }

  /**
   * Test {@link PromotionMessageImpl#getPriority()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessageImpl#getPriority()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int PromotionMessageImpl.getPriority()"})
  public void testGetPriority_thenReturnOne() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl2 = new PromotionMessageImpl();
    promotionMessageImpl2
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl2.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl2.setLocale(new LocaleImpl());
    promotionMessageImpl2.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl2.setMessage("Promotion Message");
    promotionMessageImpl2.setMessagePlacement("Message Location");
    promotionMessageImpl2.setName("Name");
    promotionMessageImpl2
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl2.setPriority(1);

    // Act and Assert
    assertEquals(1, promotionMessageImpl2.getPriority());
  }

  /**
   * Test {@link PromotionMessageImpl#getStartDate()}.
   * <ul>
   *   <li>Given {@link PromotionMessageImpl} (default constructor) Archived is {@code Y}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessageImpl#getStartDate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date PromotionMessageImpl.getStartDate()"})
  public void testGetStartDate_givenPromotionMessageImplArchivedIsY_thenReturnNull() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl2 = new PromotionMessageImpl();
    promotionMessageImpl2.setArchived('Y');

    // Act and Assert
    assertNull(promotionMessageImpl2.getStartDate());
  }

  /**
   * Test {@link PromotionMessageImpl#getStartDate()}.
   * <ul>
   *   <li>Given {@link PromotionMessageImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessageImpl#getStartDate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date PromotionMessageImpl.getStartDate()"})
  public void testGetStartDate_givenPromotionMessageImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PromotionMessageImpl()).getStartDate());
  }

  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date PromotionMessageImpl.getEndDate()", "Long PromotionMessageImpl.getId()",
      "Locale PromotionMessageImpl.getLocale()", "Media PromotionMessageImpl.getMedia()",
      "String PromotionMessageImpl.getMessage()", "String PromotionMessageImpl.getMessagePlacement()",
      "String PromotionMessageImpl.getName()", "void PromotionMessageImpl.setEndDate(Date)",
      "void PromotionMessageImpl.setId(Long)", "void PromotionMessageImpl.setLocale(Locale)",
      "void PromotionMessageImpl.setMedia(Media)", "void PromotionMessageImpl.setMessage(String)",
      "void PromotionMessageImpl.setMessagePlacement(String)", "void PromotionMessageImpl.setName(String)",
      "void PromotionMessageImpl.setPriority(Integer)", "void PromotionMessageImpl.setStartDate(Date)"})
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

    // Assert
    assertEquals("Message Location", actualMessagePlacement);
    assertEquals("Name", promotionMessageImpl.getName());
    assertEquals("Promotion Message", actualMessage);
    assertEquals(PromotionMessageImpl.serialVersionUID, actualId.longValue());
    assertSame(locale, actualLocale);
    assertSame(media, actualMedia);
    assertSame(endDate, actualEndDate);
  }

  /**
   * Test {@link PromotionMessageImpl#getArchived()}.
   * <p>
   * Method under test: {@link PromotionMessageImpl#getArchived()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Character PromotionMessageImpl.getArchived()"})
  public void testGetArchived() {
    // Arrange, Act and Assert
    assertEquals('N', (new PromotionMessageImpl()).getArchived().charValue());
  }

  /**
   * Test {@link PromotionMessageImpl#setArchived(Character)}.
   * <p>
   * Method under test: {@link PromotionMessageImpl#setArchived(Character)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PromotionMessageImpl.setArchived(Character)"})
  public void testSetArchived() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl2 = new PromotionMessageImpl();

    // Act
    promotionMessageImpl2.setArchived('A');

    // Assert
    assertEquals('A', promotionMessageImpl2.archiveStatus.getArchived().charValue());
    assertEquals('A', promotionMessageImpl2.getArchived().charValue());
  }

  /**
   * Test {@link PromotionMessageImpl#isActive()}.
   * <p>
   * Method under test: {@link PromotionMessageImpl#isActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PromotionMessageImpl.isActive()"})
  public void testIsActive() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl2 = new PromotionMessageImpl();
    promotionMessageImpl2.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl2.setLocale(new LocaleImpl());
    promotionMessageImpl2.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl2.setMessage("Promotion Message");
    promotionMessageImpl2.setMessagePlacement("Message Location");
    promotionMessageImpl2.setName("Name");
    promotionMessageImpl2.setPriority(1);
    promotionMessageImpl2.setArchived(null);
    promotionMessageImpl2
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl2
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(promotionMessageImpl2.isActive());
  }

  /**
   * Test {@link PromotionMessageImpl#isActive()}.
   * <ul>
   *   <li>Given {@link PromotionMessageImpl} (default constructor) Archived is {@code Y}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessageImpl#isActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PromotionMessageImpl.isActive()"})
  public void testIsActive_givenPromotionMessageImplArchivedIsY_thenReturnFalse() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl2 = new PromotionMessageImpl();
    promotionMessageImpl2.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl2.setLocale(new LocaleImpl());
    promotionMessageImpl2.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl2.setMessage("Promotion Message");
    promotionMessageImpl2.setMessagePlacement("Message Location");
    promotionMessageImpl2.setName("Name");
    promotionMessageImpl2.setPriority(1);
    promotionMessageImpl2.setArchived('Y');
    promotionMessageImpl2
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl2.setEndDate(null);

    // Act and Assert
    assertFalse(promotionMessageImpl2.isActive());
  }

  /**
   * Test {@link PromotionMessageImpl#isActive()}.
   * <ul>
   *   <li>Given {@link PromotionMessageImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessageImpl#isActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PromotionMessageImpl.isActive()"})
  public void testIsActive_givenPromotionMessageImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PromotionMessageImpl()).isActive());
  }

  /**
   * Test {@link PromotionMessageImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link PromotionMessageImpl#getMainEntityName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PromotionMessageImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull((new PromotionMessageImpl()).getMainEntityName());
  }

  /**
   * Test {@link PromotionMessageImpl#equals(Object)}, and {@link PromotionMessageImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessageImpl#equals(Object)}
   *   <li>{@link PromotionMessageImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PromotionMessageImpl.equals(Object)", "int PromotionMessageImpl.hashCode()"})
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
   * Test {@link PromotionMessageImpl#equals(Object)}, and {@link PromotionMessageImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessageImpl#equals(Object)}
   *   <li>{@link PromotionMessageImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PromotionMessageImpl.equals(Object)", "int PromotionMessageImpl.hashCode()"})
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
   * Test {@link PromotionMessageImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessageImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PromotionMessageImpl.equals(Object)", "int PromotionMessageImpl.hashCode()"})
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
   * Test {@link PromotionMessageImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessageImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PromotionMessageImpl.equals(Object)", "int PromotionMessageImpl.hashCode()"})
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
   * Test {@link PromotionMessageImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessageImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PromotionMessageImpl.equals(Object)", "int PromotionMessageImpl.hashCode()"})
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
   * Test {@link PromotionMessageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link PromotionMessageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse PromotionMessageImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    PromotionMessageImpl promotionMessageImpl2 = new PromotionMessageImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PromotionMessage> actualCreateOrRetrieveCopyInstanceResult = promotionMessageImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link PromotionMessageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link PromotionMessageImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse PromotionMessageImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnPromotionMessageImpl() throws CloneNotSupportedException {
    // Arrange
    PromotionMessageImpl promotionMessageImpl2 = new PromotionMessageImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<PromotionMessage> actualCreateOrRetrieveCopyInstanceResult = promotionMessageImpl2
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.core.promotionMessage.domain.PromotionMessageImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    PromotionMessage clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof PromotionMessageImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(promotionMessageImpl2, clone);
  }

  /**
   * Test new {@link PromotionMessageImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link PromotionMessageImpl}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PromotionMessageImpl.<init>()"})
  public void testNewPromotionMessageImpl() {
    // Arrange and Act
    PromotionMessageImpl actualPromotionMessageImpl = new PromotionMessageImpl();

    // Assert
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
