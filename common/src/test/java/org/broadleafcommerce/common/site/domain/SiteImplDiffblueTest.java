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
package org.broadleafcommerce.common.site.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.persistence.ArchiveStatus;
import org.broadleafcommerce.common.site.service.type.SiteResolutionType;
import org.junit.Test;

public class SiteImplDiffblueTest {
  /**
   * Test {@link SiteImpl#getName()}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#getName()}
   */
  @Test
  public void testGetName_givenSiteImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteImpl()).getName());
  }

  /**
   * Test {@link SiteImpl#getName()}.
   * <ul>
   *   <li>Given {@link SiteResolutionType} {@link SiteResolutionType#getType()}
   * return {@code Type}.</li>
   *   <li>Then calls {@link SiteResolutionType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#getName()}
   */
  @Test
  public void testGetName_givenSiteResolutionTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteResolutionType siteResolutionType = mock(SiteResolutionType.class);
    when(siteResolutionType.getType()).thenReturn("Type");

    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setSiteResolutionType(siteResolutionType);

    // Act
    String actualName = siteImpl.getName();

    // Assert
    verify(siteResolutionType).getType();
    assertNull(actualName);
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
  public void testGetSiteResolutionType_givenSiteImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteImpl()).getSiteResolutionType());
  }

  /**
   * Test {@link SiteImpl#getSiteResolutionType()}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor) DefaultLocale is
   * {@link Locale}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#getSiteResolutionType()}
   */
  @Test
  public void testGetSiteResolutionType_givenSiteImplDefaultLocaleIsLocale() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setCatalogs(new ArrayList<>());
    siteImpl.setDeactivated(true);
    siteImpl.setDefaultLocale(mock(Locale.class));
    siteImpl.setId(1L);
    siteImpl.setName("Name");
    siteImpl.setSiteIdentifierValue("42");
    siteImpl.setSiteResolutionType(SiteResolutionType.DOMAIN);
    siteImpl.setSiteIdentifierType("foo");

    // Act and Assert
    assertNull(siteImpl.getSiteResolutionType());
  }

  /**
   * Test {@link SiteImpl#getSiteResolutionType()}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor) DefaultLocale is
   * {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#getSiteResolutionType()}
   */
  @Test
  public void testGetSiteResolutionType_givenSiteImplDefaultLocaleIsLocaleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setCatalogs(new ArrayList<>());
    siteImpl.setDeactivated(true);
    siteImpl.setDefaultLocale(new LocaleImpl());
    siteImpl.setId(1L);
    siteImpl.setName("Name");
    siteImpl.setSiteIdentifierValue("42");
    siteImpl.setSiteResolutionType(SiteResolutionType.DOMAIN);
    siteImpl.setSiteIdentifierType("foo");

    // Act and Assert
    assertNull(siteImpl.getSiteResolutionType());
  }

  /**
   * Test {@link SiteImpl#setSiteResolutionType(SiteResolutionType)}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor) Catalogs is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#setSiteResolutionType(SiteResolutionType)}
   */
  @Test
  public void testSetSiteResolutionType_givenSiteImplCatalogsIsArrayList_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    siteImpl.setSiteResolutionType(null);

    // Assert
    assertNull(siteImpl.getSiteIdentifierType());
    assertNull(siteImpl.getSiteResolutionType());
  }

  /**
   * Test {@link SiteImpl#setSiteResolutionType(SiteResolutionType)}.
   * <ul>
   *   <li>When {@link SiteResolutionType#DOMAIN}.</li>
   *   <li>Then {@link SiteImpl} (default constructor) SiteIdentifierType is
   * {@code DOMAIN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#setSiteResolutionType(SiteResolutionType)}
   */
  @Test
  public void testSetSiteResolutionType_whenDomain_thenSiteImplSiteIdentifierTypeIsDomain() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    SiteResolutionType siteResolutionType = SiteResolutionType.DOMAIN;

    // Act
    siteImpl.setSiteResolutionType(siteResolutionType);

    // Assert
    assertEquals("DOMAIN", siteImpl.getSiteIdentifierType());
    SiteResolutionType expectedSiteResolutionType = siteResolutionType.DOMAIN;
    assertSame(expectedSiteResolutionType, siteImpl.getSiteResolutionType());
  }

  /**
   * Test {@link SiteImpl#getArchived()}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#getArchived()}
   */
  @Test
  public void testGetArchived_givenSiteImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('N', (new SiteImpl()).getArchived().charValue());
  }

  /**
   * Test {@link SiteImpl#getArchived()}.
   * <ul>
   *   <li>Given {@link SiteResolutionType} {@link SiteResolutionType#getType()}
   * return {@code Type}.</li>
   *   <li>Then calls {@link SiteResolutionType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#getArchived()}
   */
  @Test
  public void testGetArchived_givenSiteResolutionTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteResolutionType siteResolutionType = mock(SiteResolutionType.class);
    when(siteResolutionType.getType()).thenReturn("Type");

    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setSiteResolutionType(siteResolutionType);

    // Act
    Character actualArchived = siteImpl.getArchived();

    // Assert
    verify(siteResolutionType).getType();
    assertEquals('N', actualArchived.charValue());
  }

  /**
   * Test {@link SiteImpl#setArchived(Character)}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived_givenSiteImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteImpl siteImpl = new SiteImpl();

    // Act
    siteImpl.setArchived('A');

    // Assert
    assertEquals('A', siteImpl.getArchiveStatus().getArchived().charValue());
    assertEquals('A', siteImpl.getArchived().charValue());
  }

  /**
   * Test {@link SiteImpl#setArchived(Character)}.
   * <ul>
   *   <li>Given {@link SiteResolutionType} {@link SiteResolutionType#getType()}
   * return {@code Type}.</li>
   *   <li>Then calls {@link SiteResolutionType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived_givenSiteResolutionTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteResolutionType siteResolutionType = mock(SiteResolutionType.class);
    when(siteResolutionType.getType()).thenReturn("Type");

    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setSiteResolutionType(siteResolutionType);

    // Act
    siteImpl.setArchived('A');

    // Assert
    verify(siteResolutionType).getType();
    assertEquals('A', siteImpl.getArchiveStatus().getArchived().charValue());
    assertEquals('A', siteImpl.getArchived().charValue());
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

    // Assert that nothing has changed
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
  public void testIsActive_givenSiteImplArchivedIsY_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setArchived('Y');

    // Act and Assert
    assertFalse(siteImpl.isActive());
  }

  /**
   * Test {@link SiteImpl#isActive()}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor) DefaultLocale is
   * {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#isActive()}
   */
  @Test
  public void testIsActive_givenSiteImplDefaultLocaleIsLocaleImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setCatalogs(new ArrayList<>());
    siteImpl.setDefaultLocale(new LocaleImpl());
    siteImpl.setId(1L);
    siteImpl.setName("Name");
    siteImpl.setSiteIdentifierType("Site Identifier Type");
    siteImpl.setSiteIdentifierValue("42");
    siteImpl.setSiteResolutionType(SiteResolutionType.DOMAIN);
    siteImpl.setDeactivated(true);
    siteImpl.setArchived(null);

    // Act and Assert
    assertFalse(siteImpl.isActive());
  }

  /**
   * Test {@link SiteImpl#isActive()}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor) DefaultLocale is
   * {@link LocaleImpl}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#isActive()}
   */
  @Test
  public void testIsActive_givenSiteImplDefaultLocaleIsLocaleImpl_thenReturnFalse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setCatalogs(new ArrayList<>());
    siteImpl.setDefaultLocale(mock(LocaleImpl.class));
    siteImpl.setId(1L);
    siteImpl.setName("Name");
    siteImpl.setSiteIdentifierType("Site Identifier Type");
    siteImpl.setSiteIdentifierValue("42");
    siteImpl.setSiteResolutionType(SiteResolutionType.DOMAIN);
    siteImpl.setDeactivated(true);
    siteImpl.setArchived(null);

    // Act and Assert
    assertFalse(siteImpl.isActive());
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
  public void testIsActive_givenSiteImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SiteImpl()).isActive());
  }

  /**
   * Test {@link SiteImpl#isDeactivated()}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor) DefaultLocale is
   * {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#isDeactivated()}
   */
  @Test
  public void testIsDeactivated_givenSiteImplDefaultLocaleIsLocaleImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setCatalogs(new ArrayList<>());
    siteImpl.setDefaultLocale(new LocaleImpl());
    siteImpl.setId(1L);
    siteImpl.setName("Name");
    siteImpl.setSiteIdentifierType("Site Identifier Type");
    siteImpl.setSiteIdentifierValue("42");
    siteImpl.setSiteResolutionType(SiteResolutionType.DOMAIN);
    siteImpl.setDeactivated(true);

    // Act and Assert
    assertTrue(siteImpl.isDeactivated());
  }

  /**
   * Test {@link SiteImpl#isDeactivated()}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor) DefaultLocale is
   * {@link LocaleImpl}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#isDeactivated()}
   */
  @Test
  public void testIsDeactivated_givenSiteImplDefaultLocaleIsLocaleImpl_thenReturnTrue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setCatalogs(new ArrayList<>());
    siteImpl.setDefaultLocale(mock(LocaleImpl.class));
    siteImpl.setId(1L);
    siteImpl.setName("Name");
    siteImpl.setSiteIdentifierType("Site Identifier Type");
    siteImpl.setSiteIdentifierValue("42");
    siteImpl.setSiteResolutionType(SiteResolutionType.DOMAIN);
    siteImpl.setDeactivated(true);

    // Act and Assert
    assertTrue(siteImpl.isDeactivated());
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
  public void testIsDeactivated_givenSiteImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SiteImpl()).isDeactivated());
  }

  /**
   * Test {@link SiteImpl#setDeactivated(boolean)}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#setDeactivated(boolean)}
   */
  @Test
  public void testSetDeactivated_givenSiteImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteImpl siteImpl = new SiteImpl();

    // Act
    siteImpl.setDeactivated(true);

    // Assert
    assertTrue(siteImpl.deactivated);
  }

  /**
   * Test {@link SiteImpl#setDeactivated(boolean)}.
   * <ul>
   *   <li>Given {@link SiteResolutionType} {@link SiteResolutionType#getType()}
   * return {@code Type}.</li>
   *   <li>Then calls {@link SiteResolutionType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#setDeactivated(boolean)}
   */
  @Test
  public void testSetDeactivated_givenSiteResolutionTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteResolutionType siteResolutionType = mock(SiteResolutionType.class);
    when(siteResolutionType.getType()).thenReturn("Type");

    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setSiteResolutionType(siteResolutionType);

    // Act
    siteImpl.setDeactivated(true);

    // Assert
    verify(siteResolutionType).getType();
    assertTrue(siteImpl.deactivated);
  }

  /**
   * Test {@link SiteImpl#clone()}.
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor) Catalogs is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link SiteImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#clone()}
   */
  @Test
  public void testClone_givenSiteImplCatalogsIsArrayList_thenReturnSiteImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setCatalogs(new ArrayList<>());
    siteImpl.setDefaultLocale(new LocaleImpl());
    siteImpl.setId(1L);
    siteImpl.setName("Name");
    siteImpl.setSiteIdentifierValue("42");
    siteImpl.setSiteResolutionType(SiteResolutionType.DOMAIN);
    siteImpl.setSiteIdentifierType("foo");
    siteImpl.setDeactivated(true);
    siteImpl.setArchived(null);

    // Act
    Site actualCloneResult = siteImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof SiteImpl);
    assertEquals(siteImpl, actualCloneResult);
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
  public void testClone_givenSiteImpl_thenReturnSiteIdentifierTypeIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testClone_thenReturnSiteIdentifierTypeIsDomain() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setSiteResolutionType(SiteResolutionType.DOMAIN);

    // Act
    Site actualCloneResult = siteImpl.clone();

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
   * <ul>
   *   <li>Given {@link SiteImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenSiteImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteImpl()).getMainEntityName());
  }

  /**
   * Test {@link SiteImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link SiteResolutionType} {@link SiteResolutionType#getType()}
   * return {@code Type}.</li>
   *   <li>Then calls {@link SiteResolutionType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenSiteResolutionTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteResolutionType siteResolutionType = mock(SiteResolutionType.class);
    when(siteResolutionType.getType()).thenReturn("Type");

    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setSiteResolutionType(siteResolutionType);

    // Act
    String actualMainEntityName = siteImpl.getMainEntityName();

    // Assert
    verify(siteResolutionType).getType();
    assertNull(actualMainEntityName);
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
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setCatalogs(new ArrayList<>());
    siteImpl.setDeactivated(true);
    siteImpl.setDefaultLocale(mock(Locale.class));
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
  public void testNewSiteImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SiteImpl actualSiteImpl = new SiteImpl();

    // Assert
    assertEquals('N', actualSiteImpl.getArchiveStatus().getArchived().charValue());
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
