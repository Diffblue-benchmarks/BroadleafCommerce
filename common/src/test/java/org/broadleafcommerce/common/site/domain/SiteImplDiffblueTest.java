/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.site.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.persistence.ArchiveStatus;
import org.broadleafcommerce.common.site.service.type.SiteResolutionType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-common-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class SiteImplDiffblueTest {
  @Autowired private SiteImpl siteImpl;

  /**
   * Test {@link SiteImpl#getName()}.
   *
   * <p>Method under test: {@link SiteImpl#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteImpl.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull(siteImpl.getName());
  }

  /**
   * Test {@link SiteImpl#getSiteResolutionType()}.
   *
   * <ul>
   *   <li>Given {@link SiteImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SiteImpl#getSiteResolutionType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SiteResolutionType SiteImpl.getSiteResolutionType()"})
  public void testGetSiteResolutionType_givenSiteImpl() {
    // Arrange, Act and Assert
    assertNull(siteImpl.getSiteResolutionType());
  }

  /**
   * Test {@link SiteImpl#getSiteResolutionType()}.
   *
   * <ul>
   *   <li>Given {@link SiteImpl} SiteIdentifierType is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link SiteImpl#getSiteResolutionType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SiteResolutionType SiteImpl.getSiteResolutionType()"})
  public void testGetSiteResolutionType_givenSiteImplSiteIdentifierTypeIsFoo() {
    // Arrange
    siteImpl.setSiteIdentifierType("foo");

    // Act and Assert
    assertNull(siteImpl.getSiteResolutionType());
  }

  /**
   * Test {@link SiteImpl#setSiteResolutionType(SiteResolutionType)}.
   *
   * <ul>
   *   <li>When {@link SiteResolutionType#DOMAIN}.
   *   <li>Then {@link SiteImpl} SiteIdentifierType is {@code DOMAIN}.
   * </ul>
   *
   * <p>Method under test: {@link SiteImpl#setSiteResolutionType(SiteResolutionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SiteImpl.setSiteResolutionType(SiteResolutionType)"})
  public void testSetSiteResolutionType_whenDomain_thenSiteImplSiteIdentifierTypeIsDomain() {
    // Arrange and Act
    siteImpl.setSiteResolutionType(SiteResolutionType.DOMAIN);

    // Assert
    assertEquals("DOMAIN", siteImpl.getSiteIdentifierType());
    assertSame(SiteResolutionType.DOMAIN, siteImpl.getSiteResolutionType());
  }

  /**
   * Test {@link SiteImpl#setSiteResolutionType(SiteResolutionType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link SiteImpl} SiteIdentifierType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteImpl#setSiteResolutionType(SiteResolutionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SiteImpl.setSiteResolutionType(SiteResolutionType)"})
  public void testSetSiteResolutionType_whenNull_thenSiteImplSiteIdentifierTypeIsNull() {
    // Arrange and Act
    siteImpl.setSiteResolutionType(null);

    // Assert that nothing has changed
    assertNull(siteImpl.getSiteIdentifierType());
    assertNull(siteImpl.getSiteResolutionType());
  }

  /**
   * Test {@link SiteImpl#getArchived()}.
   *
   * <p>Method under test: {@link SiteImpl#getArchived()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Character SiteImpl.getArchived()"})
  public void testGetArchived() {
    // Arrange, Act and Assert
    assertEquals('N', siteImpl.getArchived().charValue());
  }

  /**
   * Test {@link SiteImpl#setArchived(Character)}.
   *
   * <p>Method under test: {@link SiteImpl#setArchived(Character)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SiteImpl.setArchived(Character)"})
  public void testSetArchived() {
    // Arrange and Act
    siteImpl.setArchived('A');

    // Assert
    assertEquals('A', siteImpl.getArchiveStatus().getArchived().charValue());
    assertEquals('A', siteImpl.getArchived().charValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteImpl#setCatalogs(List)}
   *   <li>{@link SiteImpl#setDefaultLocale(Locale)}
   *   <li>{@link SiteImpl#setId(Long)}
   *   <li>{@link SiteImpl#setName(String)}
   *   <li>{@link SiteImpl#setSiteIdentifierType(String)}
   *   <li>{@link SiteImpl#setSiteIdentifierValue(String)}
   *   <li>{@link SiteImpl#getArchiveStatus()}
   *   <li>{@link SiteImpl#getCatalogs()}
   *   <li>{@link SiteImpl#getDefaultLocale()}
   *   <li>{@link SiteImpl#getId()}
   *   <li>{@link SiteImpl#getSiteIdentifierType()}
   *   <li>{@link SiteImpl#getSiteIdentifierValue()}
   *   <li>{@link SiteImpl#isTemplateSite()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ArchiveStatus SiteImpl.getArchiveStatus()",
    "List SiteImpl.getCatalogs()",
    "Locale SiteImpl.getDefaultLocale()",
    "Long SiteImpl.getId()",
    "String SiteImpl.getSiteIdentifierType()",
    "String SiteImpl.getSiteIdentifierValue()",
    "boolean SiteImpl.isTemplateSite()",
    "void SiteImpl.setCatalogs(List)",
    "void SiteImpl.setDefaultLocale(Locale)",
    "void SiteImpl.setId(Long)",
    "void SiteImpl.setName(String)",
    "void SiteImpl.setSiteIdentifierType(String)",
    "void SiteImpl.setSiteIdentifierValue(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    ArrayList<Catalog> catalogs = new ArrayList<>();

    // Act
    siteImpl.setCatalogs(catalogs);
    LocaleImpl defaultLocale = new LocaleImpl();
    siteImpl.setDefaultLocale(defaultLocale);
    siteImpl.setId(1L);
    siteImpl.setName("Name");
    siteImpl.setSiteIdentifierType("Site Identifier Type");
    siteImpl.setSiteIdentifierValue("42");
    ArchiveStatus actualArchiveStatus = siteImpl.getArchiveStatus();
    List<Catalog> actualCatalogs = siteImpl.getCatalogs();
    Locale actualDefaultLocale = siteImpl.getDefaultLocale();
    Long actualId = siteImpl.getId();
    String actualSiteIdentifierType = siteImpl.getSiteIdentifierType();
    String actualSiteIdentifierValue = siteImpl.getSiteIdentifierValue();
    boolean actualIsTemplateSiteResult = siteImpl.isTemplateSite();

    // Assert
    assertEquals("42", actualSiteIdentifierValue);
    assertEquals("Site Identifier Type", actualSiteIdentifierType);
    assertEquals('N', actualArchiveStatus.getArchived().charValue());
    assertEquals(1L, actualId.longValue());
    assertFalse(actualIsTemplateSiteResult);
    assertTrue(actualCatalogs.isEmpty());
    assertSame(catalogs, actualCatalogs);
    assertSame(defaultLocale, actualDefaultLocale);
  }

  /**
   * Test {@link SiteImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link SiteImpl} Archived is {@code Y}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SiteImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SiteImpl.isActive()"})
  public void testIsActive_givenSiteImplArchivedIsY_thenReturnFalse() {
    // Arrange
    siteImpl.setDeactivated(false);
    siteImpl.setArchived('Y');

    // Act and Assert
    assertFalse(siteImpl.isActive());
  }

  /**
   * Test {@link SiteImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link SiteImpl} Deactivated is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SiteImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SiteImpl.isActive()"})
  public void testIsActive_givenSiteImplDeactivatedIsTrue_thenReturnFalse() {
    // Arrange
    siteImpl.setDeactivated(true);
    siteImpl.setArchived(null);

    // Act and Assert
    assertFalse(siteImpl.isActive());
  }

  /**
   * Test {@link SiteImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link SiteImpl}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SiteImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SiteImpl.isActive()"})
  public void testIsActive_givenSiteImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(siteImpl.isActive());
  }

  /**
   * Test {@link SiteImpl#isDeactivated()}.
   *
   * <ul>
   *   <li>Given {@link SiteImpl} Deactivated is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SiteImpl#isDeactivated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SiteImpl.isDeactivated()"})
  public void testIsDeactivated_givenSiteImplDeactivatedIsTrue_thenReturnTrue() {
    // Arrange
    siteImpl.setDeactivated(true);

    // Act and Assert
    assertTrue(siteImpl.isDeactivated());
  }

  /**
   * Test {@link SiteImpl#isDeactivated()}.
   *
   * <ul>
   *   <li>Given {@link SiteImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SiteImpl#isDeactivated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SiteImpl.isDeactivated()"})
  public void testIsDeactivated_givenSiteImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(siteImpl.isDeactivated());
  }

  /**
   * Test {@link SiteImpl#setDeactivated(boolean)}.
   *
   * <p>Method under test: {@link SiteImpl#setDeactivated(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SiteImpl.setDeactivated(boolean)"})
  public void testSetDeactivated() {
    // Arrange and Act
    siteImpl.setDeactivated(true);

    // Assert
    assertTrue(siteImpl.deactivated);
  }

  /**
   * Test {@link SiteImpl#clone()}.
   *
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor) Catalogs is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link SiteImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SiteImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteImpl.clone()"})
  public void testClone_givenSiteImplCatalogsIsArrayList_thenReturnSiteImpl() {
    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setCatalogs(new ArrayList<>());
    siteImpl.setDeactivated(true);
    siteImpl.setDefaultLocale(new LocaleImpl());
    siteImpl.setId(1L);
    siteImpl.setName("Name");
    siteImpl.setSiteIdentifierType("Site Identifier Type");
    siteImpl.setSiteIdentifierValue("42");
    siteImpl.setSiteResolutionType(SiteResolutionType.DOMAIN);

    // Act
    Site actualCloneResult = siteImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof SiteImpl);
    assertEquals(siteImpl, actualCloneResult);
  }

  /**
   * Test {@link SiteImpl#clone()}.
   *
   * <ul>
   *   <li>Given {@link SiteImpl} Deactivated is {@code true}.
   *   <li>Then return Archived is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteImpl.clone()"})
  public void testClone_givenSiteImplDeactivatedIsTrue_thenReturnArchivedIsNull() {
    // Arrange
    siteImpl.setDeactivated(true);
    siteImpl.setSiteIdentifierType("foo");
    siteImpl.setArchived(null);

    // Act
    Site actualCloneResult = siteImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof SiteImpl);
    assertNull(actualCloneResult.getArchived());
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.getName());
    assertNull(actualCloneResult.getSiteIdentifierType());
    assertNull(actualCloneResult.getSiteIdentifierValue());
    assertNull(((SiteImpl) actualCloneResult).getMainEntityName());
    assertNull(((SiteImpl) actualCloneResult).name);
    assertNull(actualCloneResult.getDefaultLocale());
    assertNull(actualCloneResult.getSiteResolutionType());
    assertFalse(actualCloneResult.isTemplateSite());
    assertTrue(actualCloneResult.getCatalogs().isEmpty());
    assertTrue(((SiteImpl) actualCloneResult).deactivated);
  }

  /**
   * Test {@link SiteImpl#clone()}.
   *
   * <ul>
   *   <li>Given {@link SiteImpl}.
   *   <li>Then return Archived charValue is {@code N}.
   * </ul>
   *
   * <p>Method under test: {@link SiteImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteImpl.clone()"})
  public void testClone_givenSiteImpl_thenReturnArchivedCharValueIsN() {
    // Arrange and Act
    Site actualCloneResult = siteImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof SiteImpl);
    assertEquals('N', actualCloneResult.getArchived().charValue());
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.getName());
    assertNull(actualCloneResult.getSiteIdentifierType());
    assertNull(actualCloneResult.getSiteIdentifierValue());
    assertNull(((SiteImpl) actualCloneResult).getMainEntityName());
    assertNull(((SiteImpl) actualCloneResult).name);
    assertNull(actualCloneResult.getDefaultLocale());
    assertNull(actualCloneResult.getSiteResolutionType());
    assertFalse(actualCloneResult.isTemplateSite());
    assertFalse(((SiteImpl) actualCloneResult).deactivated);
    assertTrue(actualCloneResult.getCatalogs().isEmpty());
  }

  /**
   * Test {@link SiteImpl#getMainEntityName()}.
   *
   * <p>Method under test: {@link SiteImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SiteImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull(siteImpl.getMainEntityName());
  }

  /**
   * Test {@link SiteImpl#equals(Object)}, and {@link SiteImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteImpl#equals(Object)}
   *   <li>{@link SiteImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SiteImpl.equals(Object)", "int SiteImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setCatalogs(new ArrayList<>());
    siteImpl.setDeactivated(true);
    siteImpl.setDefaultLocale(new LocaleImpl());
    siteImpl.setId(1L);
    siteImpl.setName("Name");
    siteImpl.setSiteIdentifierType("Site Identifier Type");
    siteImpl.setSiteIdentifierValue("42");
    siteImpl.setSiteResolutionType(SiteResolutionType.DOMAIN);

    SiteImpl siteImpl2 = new SiteImpl();
    siteImpl2.setCatalogs(new ArrayList<>());
    siteImpl2.setDeactivated(true);
    siteImpl2.setDefaultLocale(new LocaleImpl());
    siteImpl2.setId(1L);
    siteImpl2.setName("Name");
    siteImpl2.setSiteIdentifierType("Site Identifier Type");
    siteImpl2.setSiteIdentifierValue("42");
    siteImpl2.setSiteResolutionType(SiteResolutionType.DOMAIN);

    // Act and Assert
    assertEquals(siteImpl, siteImpl2);
    assertEquals(siteImpl.hashCode(), siteImpl2.hashCode());
  }

  /**
   * Test {@link SiteImpl#equals(Object)}, and {@link SiteImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteImpl#equals(Object)}
   *   <li>{@link SiteImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SiteImpl.equals(Object)", "int SiteImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setCatalogs(new ArrayList<>());
    siteImpl.setDeactivated(true);
    siteImpl.setDefaultLocale(new LocaleImpl());
    siteImpl.setId(1L);
    siteImpl.setName("Name");
    siteImpl.setSiteIdentifierType("Site Identifier Type");
    siteImpl.setSiteIdentifierValue("42");
    siteImpl.setSiteResolutionType(SiteResolutionType.DOMAIN);

    // Act and Assert
    assertEquals(siteImpl, siteImpl);
    int expectedHashCodeResult = siteImpl.hashCode();
    assertEquals(expectedHashCodeResult, siteImpl.hashCode());
  }

  /**
   * Test {@link SiteImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SiteImpl.equals(Object)", "int SiteImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setCatalogs(new ArrayList<>());
    siteImpl.setDeactivated(true);
    siteImpl.setDefaultLocale(new LocaleImpl());
    siteImpl.setId(2L);
    siteImpl.setName("Name");
    siteImpl.setSiteIdentifierType("Site Identifier Type");
    siteImpl.setSiteIdentifierValue("42");
    siteImpl.setSiteResolutionType(SiteResolutionType.DOMAIN);

    SiteImpl siteImpl2 = new SiteImpl();
    siteImpl2.setCatalogs(new ArrayList<>());
    siteImpl2.setDeactivated(true);
    siteImpl2.setDefaultLocale(new LocaleImpl());
    siteImpl2.setId(1L);
    siteImpl2.setName("Name");
    siteImpl2.setSiteIdentifierType("Site Identifier Type");
    siteImpl2.setSiteIdentifierValue("42");
    siteImpl2.setSiteResolutionType(SiteResolutionType.DOMAIN);

    // Act and Assert
    assertNotEquals(siteImpl, siteImpl2);
  }

  /**
   * Test {@link SiteImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SiteImpl.equals(Object)", "int SiteImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setCatalogs(new ArrayList<>());
    siteImpl.setDeactivated(true);
    siteImpl.setDefaultLocale(new LocaleImpl());
    siteImpl.setId(null);
    siteImpl.setName("Name");
    siteImpl.setSiteIdentifierType("Site Identifier Type");
    siteImpl.setSiteIdentifierValue("42");
    siteImpl.setSiteResolutionType(SiteResolutionType.DOMAIN);

    SiteImpl siteImpl2 = new SiteImpl();
    siteImpl2.setCatalogs(new ArrayList<>());
    siteImpl2.setDeactivated(true);
    siteImpl2.setDefaultLocale(new LocaleImpl());
    siteImpl2.setId(1L);
    siteImpl2.setName("Name");
    siteImpl2.setSiteIdentifierType("Site Identifier Type");
    siteImpl2.setSiteIdentifierValue("42");
    siteImpl2.setSiteResolutionType(SiteResolutionType.DOMAIN);

    // Act and Assert
    assertNotEquals(siteImpl, siteImpl2);
  }

  /**
   * Test {@link SiteImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SiteImpl.equals(Object)", "int SiteImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setCatalogs(new ArrayList<>());
    siteImpl.setDeactivated(true);
    siteImpl.setDefaultLocale(new LocaleImpl());
    siteImpl.setId(1L);
    siteImpl.setName("Name");
    siteImpl.setSiteIdentifierType("Site Identifier Type");
    siteImpl.setSiteIdentifierValue("42");
    siteImpl.setSiteResolutionType(SiteResolutionType.DOMAIN);

    SiteImpl siteImpl2 = new SiteImpl();
    siteImpl2.setCatalogs(new ArrayList<>());
    siteImpl2.setDeactivated(true);
    siteImpl2.setDefaultLocale(new LocaleImpl());
    siteImpl2.setId(null);
    siteImpl2.setName("Name");
    siteImpl2.setSiteIdentifierType("Site Identifier Type");
    siteImpl2.setSiteIdentifierValue("42");
    siteImpl2.setSiteResolutionType(SiteResolutionType.DOMAIN);

    // Act and Assert
    assertNotEquals(siteImpl, siteImpl2);
  }

  /**
   * Test {@link SiteImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SiteImpl.equals(Object)", "int SiteImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setCatalogs(new ArrayList<>());
    siteImpl.setDeactivated(true);
    siteImpl.setDefaultLocale(new LocaleImpl());
    siteImpl.setId(1L);
    siteImpl.setName("Name");
    siteImpl.setSiteIdentifierType("Site Identifier Type");
    siteImpl.setSiteIdentifierValue("42");
    siteImpl.setSiteResolutionType(SiteResolutionType.DOMAIN);

    // Act and Assert
    assertNotEquals(siteImpl, null);
  }

  /**
   * Test {@link SiteImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SiteImpl.equals(Object)", "int SiteImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setCatalogs(new ArrayList<>());
    siteImpl.setDeactivated(true);
    siteImpl.setDefaultLocale(new LocaleImpl());
    siteImpl.setId(1L);
    siteImpl.setName("Name");
    siteImpl.setSiteIdentifierType("Site Identifier Type");
    siteImpl.setSiteIdentifierValue("42");
    siteImpl.setSiteResolutionType(SiteResolutionType.DOMAIN);

    // Act and Assert
    assertNotEquals(siteImpl, "Different type to SiteImpl");
  }

  /**
   * Test new {@link SiteImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link SiteImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SiteImpl.<init>()"})
  public void testNewSiteImpl() {
    // Arrange and Act
    SiteImpl actualSiteImpl = new SiteImpl();

    // Assert
    assertEquals('N', actualSiteImpl.getArchived().charValue());
    assertNull(actualSiteImpl.getId());
    assertNull(actualSiteImpl.getMainEntityName());
    assertNull(actualSiteImpl.getName());
    assertNull(actualSiteImpl.getSiteIdentifierType());
    assertNull(actualSiteImpl.getSiteIdentifierValue());
    assertNull(actualSiteImpl.name);
    assertNull(actualSiteImpl.getDefaultLocale());
    assertNull(actualSiteImpl.getSiteResolutionType());
    assertFalse(actualSiteImpl.isTemplateSite());
    assertFalse(actualSiteImpl.deactivated);
    assertTrue(actualSiteImpl.getCatalogs().isEmpty());
  }
}
