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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SiteImplDiffblueTest {
  @Autowired
  private SiteImpl siteImpl;

  /**
   * Test {@link SiteImpl#getName()}.
   * <p>
   * Method under test: {@link SiteImpl#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteImpl.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull((new SiteImpl()).getName());
  }

  /**
   * Test {@link SiteImpl#getSiteResolutionType()}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#getSiteResolutionType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SiteResolutionType SiteImpl.getSiteResolutionType()"})
  public void testGetSiteResolutionType_givenSiteImpl() {
    // Arrange, Act and Assert
    assertNull((new SiteImpl()).getSiteResolutionType());
  }

  /**
   * Test {@link SiteImpl#getSiteResolutionType()}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor) Catalogs is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#getSiteResolutionType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SiteResolutionType SiteImpl.getSiteResolutionType()"})
  public void testGetSiteResolutionType_givenSiteImplCatalogsIsArrayList() {
    // Arrange
    SiteImpl siteImpl2 = new SiteImpl();
    siteImpl2.setCatalogs(new ArrayList<>());
    siteImpl2.setDeactivated(true);
    siteImpl2.setDefaultLocale(new LocaleImpl());
    siteImpl2.setId(1L);
    siteImpl2.setName("Name");
    siteImpl2.setSiteIdentifierValue("42");
    siteImpl2.setSiteResolutionType(SiteResolutionType.DOMAIN);
    siteImpl2.setSiteIdentifierType("foo");

    // Act and Assert
    assertNull(siteImpl2.getSiteResolutionType());
  }

  /**
   * Test {@link SiteImpl#getArchived()}.
   * <p>
   * Method under test: {@link SiteImpl#getArchived()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Character SiteImpl.getArchived()"})
  public void testGetArchived() {
    // Arrange, Act and Assert
    assertEquals('N', (new SiteImpl()).getArchived().charValue());
  }

  /**
   * Test {@link SiteImpl#setArchived(Character)}.
   * <p>
   * Method under test: {@link SiteImpl#setArchived(Character)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteImpl.setArchived(Character)"})
  public void testSetArchived() {
    // Arrange
    SiteImpl siteImpl2 = new SiteImpl();

    // Act
    siteImpl2.setArchived('A');

    // Assert
    assertEquals('A', siteImpl2.getArchiveStatus().getArchived().charValue());
    assertEquals('A', siteImpl2.getArchived().charValue());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ArchiveStatus SiteImpl.getArchiveStatus()", "List SiteImpl.getCatalogs()",
      "Locale SiteImpl.getDefaultLocale()", "Long SiteImpl.getId()", "String SiteImpl.getSiteIdentifierType()",
      "String SiteImpl.getSiteIdentifierValue()", "boolean SiteImpl.isTemplateSite()",
      "void SiteImpl.setCatalogs(List)", "void SiteImpl.setDefaultLocale(Locale)", "void SiteImpl.setId(Long)",
      "void SiteImpl.setName(String)", "void SiteImpl.setSiteIdentifierType(String)",
      "void SiteImpl.setSiteIdentifierValue(String)"})
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
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor) Archived is {@code Y}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#isActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SiteImpl.isActive()"})
  public void testIsActive_givenSiteImplArchivedIsY_thenReturnFalse() {
    // Arrange
    SiteImpl siteImpl2 = new SiteImpl();
    siteImpl2.setArchived('Y');

    // Act and Assert
    assertFalse(siteImpl2.isActive());
  }

  /**
   * Test {@link SiteImpl#isActive()}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor) Catalogs is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#isActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SiteImpl.isActive()"})
  public void testIsActive_givenSiteImplCatalogsIsArrayList_thenReturnFalse() {
    // Arrange
    SiteImpl siteImpl2 = new SiteImpl();
    siteImpl2.setCatalogs(new ArrayList<>());
    siteImpl2.setDefaultLocale(new LocaleImpl());
    siteImpl2.setId(1L);
    siteImpl2.setName("Name");
    siteImpl2.setSiteIdentifierType("Site Identifier Type");
    siteImpl2.setSiteIdentifierValue("42");
    siteImpl2.setSiteResolutionType(SiteResolutionType.DOMAIN);
    siteImpl2.setDeactivated(true);
    siteImpl2.setArchived(null);

    // Act and Assert
    assertFalse(siteImpl2.isActive());
  }

  /**
   * Test {@link SiteImpl#isActive()}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#isActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SiteImpl.isActive()"})
  public void testIsActive_givenSiteImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new SiteImpl()).isActive());
  }

  /**
   * Test {@link SiteImpl#isDeactivated()}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor) Catalogs is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#isDeactivated()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SiteImpl.isDeactivated()"})
  public void testIsDeactivated_givenSiteImplCatalogsIsArrayList_thenReturnTrue() {
    // Arrange
    SiteImpl siteImpl2 = new SiteImpl();
    siteImpl2.setCatalogs(new ArrayList<>());
    siteImpl2.setDefaultLocale(new LocaleImpl());
    siteImpl2.setId(1L);
    siteImpl2.setName("Name");
    siteImpl2.setSiteIdentifierType("Site Identifier Type");
    siteImpl2.setSiteIdentifierValue("42");
    siteImpl2.setSiteResolutionType(SiteResolutionType.DOMAIN);
    siteImpl2.setDeactivated(true);

    // Act and Assert
    assertTrue(siteImpl2.isDeactivated());
  }

  /**
   * Test {@link SiteImpl#isDeactivated()}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#isDeactivated()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SiteImpl.isDeactivated()"})
  public void testIsDeactivated_givenSiteImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new SiteImpl()).isDeactivated());
  }

  /**
   * Test {@link SiteImpl#setDeactivated(boolean)}.
   * <p>
   * Method under test: {@link SiteImpl#setDeactivated(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteImpl.setDeactivated(boolean)"})
  public void testSetDeactivated() {
    // Arrange
    SiteImpl siteImpl2 = new SiteImpl();

    // Act
    siteImpl2.setDeactivated(true);

    // Assert
    assertTrue(siteImpl2.deactivated);
  }

  /**
   * Test {@link SiteImpl#clone()}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor) Catalogs is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link SiteImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Site SiteImpl.clone()"})
  public void testClone_givenSiteImplCatalogsIsArrayList_thenReturnSiteImpl() {
    // Arrange
    SiteImpl siteImpl2 = new SiteImpl();
    siteImpl2.setCatalogs(new ArrayList<>());
    siteImpl2.setDefaultLocale(new LocaleImpl());
    siteImpl2.setId(1L);
    siteImpl2.setName("Name");
    siteImpl2.setSiteIdentifierValue("42");
    siteImpl2.setSiteResolutionType(SiteResolutionType.DOMAIN);
    siteImpl2.setSiteIdentifierType("foo");
    siteImpl2.setDeactivated(true);
    siteImpl2.setArchived(null);

    // Act
    Site actualCloneResult = siteImpl2.clone();

    // Assert
    assertTrue(actualCloneResult instanceof SiteImpl);
    assertEquals(siteImpl2, actualCloneResult);
  }

  /**
   * Test {@link SiteImpl#clone()}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor).</li>
   *   <li>Then return SiteIdentifierType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Site SiteImpl.clone()"})
  public void testClone_givenSiteImpl_thenReturnSiteIdentifierTypeIsNull() {
    // Arrange and Act
    Site actualCloneResult = (new SiteImpl()).clone();

    // Assert
    assertTrue(actualCloneResult instanceof SiteImpl);
    assertEquals('N', actualCloneResult.getArchiveStatus().getArchived().charValue());
    assertEquals('N', actualCloneResult.getArchived().charValue());
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.getName());
    assertNull(actualCloneResult.getSiteIdentifierType());
    assertNull(actualCloneResult.getSiteIdentifierValue());
    assertNull(((SiteImpl) actualCloneResult).getMainEntityName());
    assertNull(((SiteImpl) actualCloneResult).name);
    assertNull(actualCloneResult.getDefaultLocale());
    assertNull(actualCloneResult.getSiteResolutionType());
    assertFalse(((SiteImpl) actualCloneResult).deactivated);
  }

  /**
   * Test {@link SiteImpl#clone()}.
   * <ul>
   *   <li>Then return SiteIdentifierType is {@code DOMAIN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Site SiteImpl.clone()"})
  public void testClone_thenReturnSiteIdentifierTypeIsDomain() {
    // Arrange
    SiteImpl siteImpl2 = new SiteImpl();
    siteImpl2.setSiteResolutionType(SiteResolutionType.DOMAIN);

    // Act
    Site actualCloneResult = siteImpl2.clone();

    // Assert
    assertTrue(actualCloneResult instanceof SiteImpl);
    assertEquals("DOMAIN", actualCloneResult.getSiteIdentifierType());
    SiteResolutionType siteResolutionType = actualCloneResult.getSiteResolutionType();
    assertEquals("DOMAIN", siteResolutionType.getType());
    assertEquals("Domain", siteResolutionType.getFriendlyType());
    assertEquals('N', actualCloneResult.getArchiveStatus().getArchived().charValue());
    assertEquals('N', actualCloneResult.getArchived().charValue());
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.getName());
    assertNull(actualCloneResult.getSiteIdentifierValue());
    assertNull(((SiteImpl) actualCloneResult).getMainEntityName());
    assertNull(((SiteImpl) actualCloneResult).name);
    assertNull(actualCloneResult.getDefaultLocale());
    assertFalse(((SiteImpl) actualCloneResult).deactivated);
  }

  /**
   * Test {@link SiteImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link SiteImpl#getMainEntityName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull((new SiteImpl()).getMainEntityName());
  }

  /**
   * Test {@link SiteImpl#equals(Object)}, and {@link SiteImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteImpl#equals(Object)}
   *   <li>{@link SiteImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    int expectedHashCodeResult = siteImpl.hashCode();
    assertEquals(expectedHashCodeResult, siteImpl2.hashCode());
  }

  /**
   * Test {@link SiteImpl#equals(Object)}, and {@link SiteImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteImpl#equals(Object)}
   *   <li>{@link SiteImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: default or parameterless constructor of {@link SiteImpl}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
