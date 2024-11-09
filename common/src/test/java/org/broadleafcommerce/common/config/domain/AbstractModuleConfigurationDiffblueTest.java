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
package org.broadleafcommerce.common.config.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.config.service.type.ModuleConfigurationType;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class AbstractModuleConfigurationDiffblueTest {
  /**
   * Test {@link AbstractModuleConfiguration#getId()}.
   * <ul>
   *   <li>Given {@link ModuleConfigurationType}
   * {@link ModuleConfigurationType#getType()} return {@code Type}.</li>
   *   <li>Then calls {@link ModuleConfigurationType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getId()}
   */
  @Test
  public void testGetId_givenModuleConfigurationTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ModuleConfigurationType moduleConfigurationType = mock(ModuleConfigurationType.class);
    when(moduleConfigurationType.getType()).thenReturn("Type");

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setModuleConfigurationType(moduleConfigurationType);

    // Act
    Long actualId = siteMapConfigurationImpl.getId();

    // Assert
    verify(moduleConfigurationType).getType();
    assertNull(actualId);
  }

  /**
   * Test {@link AbstractModuleConfiguration#getId()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getId()}
   */
  @Test
  public void testGetId_givenSiteMapConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteMapConfigurationImpl()).getId());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setId(Long)}.
   * <ul>
   *   <li>Given {@link ModuleConfigurationType}
   * {@link ModuleConfigurationType#getType()} return {@code Type}.</li>
   *   <li>Then calls {@link ModuleConfigurationType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setId(Long)}
   */
  @Test
  public void testSetId_givenModuleConfigurationTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ModuleConfigurationType moduleConfigurationType = mock(ModuleConfigurationType.class);
    when(moduleConfigurationType.getType()).thenReturn("Type");

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setModuleConfigurationType(moduleConfigurationType);

    // Act
    siteMapConfigurationImpl.setId(1L);

    // Assert
    verify(moduleConfigurationType).getType();
    assertEquals(1L, siteMapConfigurationImpl.getId().longValue());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setId(Long)}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setId(Long)}
   */
  @Test
  public void testSetId_givenSiteMapConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();

    // Act
    siteMapConfigurationImpl.setId(1L);

    // Assert
    assertEquals(1L, siteMapConfigurationImpl.getId().longValue());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getModuleName()}.
   * <ul>
   *   <li>Given {@link ModuleConfigurationType}
   * {@link ModuleConfigurationType#getType()} return {@code Type}.</li>
   *   <li>Then calls {@link ModuleConfigurationType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getModuleName()}
   */
  @Test
  public void testGetModuleName_givenModuleConfigurationTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ModuleConfigurationType moduleConfigurationType = mock(ModuleConfigurationType.class);
    when(moduleConfigurationType.getType()).thenReturn("Type");

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setModuleConfigurationType(moduleConfigurationType);

    // Act
    String actualModuleName = siteMapConfigurationImpl.getModuleName();

    // Assert
    verify(moduleConfigurationType).getType();
    assertNull(actualModuleName);
  }

  /**
   * Test {@link AbstractModuleConfiguration#getModuleName()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getModuleName()}
   */
  @Test
  public void testGetModuleName_givenSiteMapConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteMapConfigurationImpl()).getModuleName());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setModuleName(String)}.
   * <ul>
   *   <li>Given {@link ModuleConfigurationType}
   * {@link ModuleConfigurationType#getType()} return {@code Type}.</li>
   *   <li>Then calls {@link ModuleConfigurationType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setModuleName(String)}
   */
  @Test
  public void testSetModuleName_givenModuleConfigurationTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ModuleConfigurationType moduleConfigurationType = mock(ModuleConfigurationType.class);
    when(moduleConfigurationType.getType()).thenReturn("Type");

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setModuleConfigurationType(moduleConfigurationType);

    // Act
    siteMapConfigurationImpl.setModuleName("Name");

    // Assert
    verify(moduleConfigurationType).getType();
    assertEquals("Name", siteMapConfigurationImpl.getModuleName());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setModuleName(String)}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setModuleName(String)}
   */
  @Test
  public void testSetModuleName_givenSiteMapConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();

    // Act
    siteMapConfigurationImpl.setModuleName("Name");

    // Assert
    assertEquals("Name", siteMapConfigurationImpl.getModuleName());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getIsDefault()}.
   * <ul>
   *   <li>Given {@link ModuleConfigurationType}
   * {@link ModuleConfigurationType#getType()} return {@code Type}.</li>
   *   <li>Then calls {@link ModuleConfigurationType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getIsDefault()}
   */
  @Test
  public void testGetIsDefault_givenModuleConfigurationTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ModuleConfigurationType moduleConfigurationType = mock(ModuleConfigurationType.class);
    when(moduleConfigurationType.getType()).thenReturn("Type");

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setModuleConfigurationType(moduleConfigurationType);

    // Act
    Boolean actualIsDefault = siteMapConfigurationImpl.getIsDefault();

    // Assert
    verify(moduleConfigurationType).getType();
    assertFalse(actualIsDefault);
  }

  /**
   * Test {@link AbstractModuleConfiguration#getIsDefault()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor) IsDefault is
   * {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getIsDefault()}
   */
  @Test
  public void testGetIsDefault_givenSiteMapConfigurationImplIsDefaultIsNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setIsDefault(null);

    // Act and Assert
    assertFalse(siteMapConfigurationImpl.getIsDefault());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getIsDefault()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor) IsDefault is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getIsDefault()}
   */
  @Test
  public void testGetIsDefault_givenSiteMapConfigurationImplIsDefaultIsTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setIsDefault(true);

    // Act and Assert
    assertTrue(siteMapConfigurationImpl.getIsDefault());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getIsDefault()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getIsDefault()}
   */
  @Test
  public void testGetIsDefault_givenSiteMapConfigurationImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SiteMapConfigurationImpl()).getIsDefault());
  }

  /**
   * Test {@link AbstractModuleConfiguration#isDefault()}.
   * <ul>
   *   <li>Given {@link ModuleConfigurationType}
   * {@link ModuleConfigurationType#getType()} return {@code Type}.</li>
   *   <li>Then calls {@link ModuleConfigurationType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#isDefault()}
   */
  @Test
  public void testIsDefault_givenModuleConfigurationTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ModuleConfigurationType moduleConfigurationType = mock(ModuleConfigurationType.class);
    when(moduleConfigurationType.getType()).thenReturn("Type");

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setModuleConfigurationType(moduleConfigurationType);

    // Act
    boolean actualIsDefaultResult = siteMapConfigurationImpl.isDefault();

    // Assert
    verify(moduleConfigurationType).getType();
    assertFalse(actualIsDefaultResult);
  }

  /**
   * Test {@link AbstractModuleConfiguration#isDefault()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor) IsDefault is
   * {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#isDefault()}
   */
  @Test
  public void testIsDefault_givenSiteMapConfigurationImplIsDefaultIsNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setIsDefault(null);

    // Act and Assert
    assertFalse(siteMapConfigurationImpl.isDefault());
  }

  /**
   * Test {@link AbstractModuleConfiguration#isDefault()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor) IsDefault is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#isDefault()}
   */
  @Test
  public void testIsDefault_givenSiteMapConfigurationImplIsDefaultIsTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setIsDefault(true);

    // Act and Assert
    assertTrue(siteMapConfigurationImpl.isDefault());
  }

  /**
   * Test {@link AbstractModuleConfiguration#isDefault()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#isDefault()}
   */
  @Test
  public void testIsDefault_givenSiteMapConfigurationImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SiteMapConfigurationImpl()).isDefault());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setIsDefault(Boolean)}.
   * <ul>
   *   <li>Given {@link ModuleConfigurationType}
   * {@link ModuleConfigurationType#getType()} return {@code Type}.</li>
   *   <li>Then calls {@link ModuleConfigurationType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setIsDefault(Boolean)}
   */
  @Test
  public void testSetIsDefault_givenModuleConfigurationTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ModuleConfigurationType moduleConfigurationType = mock(ModuleConfigurationType.class);
    when(moduleConfigurationType.getType()).thenReturn("Type");

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setModuleConfigurationType(moduleConfigurationType);

    // Act
    siteMapConfigurationImpl.setIsDefault(true);

    // Assert
    verify(moduleConfigurationType).getType();
    assertTrue(siteMapConfigurationImpl.getIsDefault());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setIsDefault(Boolean)}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setIsDefault(Boolean)}
   */
  @Test
  public void testSetIsDefault_givenSiteMapConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();

    // Act
    siteMapConfigurationImpl.setIsDefault(true);

    // Assert
    assertTrue(siteMapConfigurationImpl.getIsDefault());
  }

  /**
   * Test
   * {@link AbstractModuleConfiguration#setModuleConfigurationType(ModuleConfigurationType)}.
   * <p>
   * Method under test:
   * {@link AbstractModuleConfiguration#setModuleConfigurationType(ModuleConfigurationType)}
   */
  @Test
  public void testSetModuleConfigurationType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    ModuleConfigurationType moduleConfigurationType = ModuleConfigurationType.ADDRESS_VERIFICATION;

    // Act
    siteMapConfigurationImpl.setModuleConfigurationType(moduleConfigurationType);

    // Assert
    assertEquals("ADDRESS_VERIFICATION", siteMapConfigurationImpl.configType);
    ModuleConfigurationType expectedModuleConfigurationType = moduleConfigurationType.ADDRESS_VERIFICATION;
    assertSame(expectedModuleConfigurationType, siteMapConfigurationImpl.getModuleConfigurationType());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getModuleConfigurationType()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor).</li>
   *   <li>Then return {@link ModuleConfigurationType#SITE_MAP}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractModuleConfiguration#getModuleConfigurationType()}
   */
  @Test
  public void testGetModuleConfigurationType_givenSiteMapConfigurationImpl_thenReturnSite_map() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ModuleConfigurationType actualModuleConfigurationType = (new SiteMapConfigurationImpl())
        .getModuleConfigurationType();

    // Assert
    assertSame(actualModuleConfigurationType.SITE_MAP, actualModuleConfigurationType);
  }

  /**
   * Test {@link AbstractModuleConfiguration#setAuditable(Auditable)}.
   * <ul>
   *   <li>Then {@link SiteMapConfigurationImpl} (default constructor) Auditable is
   * {@link Auditable} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractModuleConfiguration#setAuditable(Auditable)}
   */
  @Test
  public void testSetAuditable_thenSiteMapConfigurationImplAuditableIsAuditable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    // Act
    siteMapConfigurationImpl.setAuditable(auditable);

    // Assert
    assertSame(auditable, siteMapConfigurationImpl.getAuditable());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setAuditable(Auditable)}.
   * <ul>
   *   <li>Then {@link SiteMapConfigurationImpl} (default constructor) Auditable is
   * {@link Auditable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractModuleConfiguration#setAuditable(Auditable)}
   */
  @Test
  public void testSetAuditable_thenSiteMapConfigurationImplAuditableIsAuditable2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    // Act
    siteMapConfigurationImpl.setAuditable(auditable);

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    assertSame(auditable, siteMapConfigurationImpl.getAuditable());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getAuditable()}.
   * <ul>
   *   <li>Given {@link ModuleConfigurationType}
   * {@link ModuleConfigurationType#getType()} return {@code Type}.</li>
   *   <li>Then calls {@link ModuleConfigurationType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getAuditable()}
   */
  @Test
  public void testGetAuditable_givenModuleConfigurationTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ModuleConfigurationType moduleConfigurationType = mock(ModuleConfigurationType.class);
    when(moduleConfigurationType.getType()).thenReturn("Type");

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setModuleConfigurationType(moduleConfigurationType);

    // Act
    Auditable actualAuditable = siteMapConfigurationImpl.getAuditable();

    // Assert
    verify(moduleConfigurationType).getType();
    assertSame(siteMapConfigurationImpl.auditable, actualAuditable);
  }

  /**
   * Test {@link AbstractModuleConfiguration#getAuditable()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getAuditable()}
   */
  @Test
  public void testGetAuditable_givenSiteMapConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();

    // Act and Assert
    assertSame(siteMapConfigurationImpl.auditable, siteMapConfigurationImpl.getAuditable());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setArchived(Character)}.
   * <ul>
   *   <li>Given {@link ModuleConfigurationType}
   * {@link ModuleConfigurationType#getType()} return {@code Type}.</li>
   *   <li>Then calls {@link ModuleConfigurationType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setArchived(Character)}
   */
  @Test
  public void testSetArchived_givenModuleConfigurationTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ModuleConfigurationType moduleConfigurationType = mock(ModuleConfigurationType.class);
    when(moduleConfigurationType.getType()).thenReturn("Type");

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setModuleConfigurationType(moduleConfigurationType);

    // Act
    siteMapConfigurationImpl.setArchived('A');

    // Assert
    verify(moduleConfigurationType).getType();
    assertEquals('A', siteMapConfigurationImpl.getArchived().charValue());
    assertEquals('A', siteMapConfigurationImpl.archiveStatus.getArchived().charValue());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setArchived(Character)}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setArchived(Character)}
   */
  @Test
  public void testSetArchived_givenSiteMapConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();

    // Act
    siteMapConfigurationImpl.setArchived('A');

    // Assert
    assertEquals('A', siteMapConfigurationImpl.getArchived().charValue());
    assertEquals('A', siteMapConfigurationImpl.archiveStatus.getArchived().charValue());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getArchived()}.
   * <ul>
   *   <li>Given {@link ModuleConfigurationType}
   * {@link ModuleConfigurationType#getType()} return {@code Type}.</li>
   *   <li>Then calls {@link ModuleConfigurationType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getArchived()}
   */
  @Test
  public void testGetArchived_givenModuleConfigurationTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ModuleConfigurationType moduleConfigurationType = mock(ModuleConfigurationType.class);
    when(moduleConfigurationType.getType()).thenReturn("Type");

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setModuleConfigurationType(moduleConfigurationType);

    // Act
    Character actualArchived = siteMapConfigurationImpl.getArchived();

    // Assert
    verify(moduleConfigurationType).getType();
    assertEquals('N', actualArchived.charValue());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getArchived()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getArchived()}
   */
  @Test
  public void testGetArchived_givenSiteMapConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('N', (new SiteMapConfigurationImpl()).getArchived().charValue());
  }

  /**
   * Test {@link AbstractModuleConfiguration#isActive()}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#isActive()}
   */
  @Test
  public void testIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setArchived(null);
    siteMapConfigurationImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(siteMapConfigurationImpl.isActive());
  }

  /**
   * Test {@link AbstractModuleConfiguration#isActive()}.
   * <ul>
   *   <li>Given {@link ModuleConfigurationType}
   * {@link ModuleConfigurationType#getType()} return {@code Type}.</li>
   *   <li>Then calls {@link ModuleConfigurationType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#isActive()}
   */
  @Test
  public void testIsActive_givenModuleConfigurationTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ModuleConfigurationType moduleConfigurationType = mock(ModuleConfigurationType.class);
    when(moduleConfigurationType.getType()).thenReturn("Type");

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setModuleConfigurationType(moduleConfigurationType);

    // Act
    boolean actualIsActiveResult = siteMapConfigurationImpl.isActive();

    // Assert
    verify(moduleConfigurationType).getType();
    assertFalse(actualIsActiveResult);
  }

  /**
   * Test {@link AbstractModuleConfiguration#isActive()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor) Archived is
   * {@code Y}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#isActive()}
   */
  @Test
  public void testIsActive_givenSiteMapConfigurationImplArchivedIsY_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setArchived('Y');
    siteMapConfigurationImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapConfigurationImpl.setActiveEndDate(null);

    // Act and Assert
    assertFalse(siteMapConfigurationImpl.isActive());
  }

  /**
   * Test {@link AbstractModuleConfiguration#isActive()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#isActive()}
   */
  @Test
  public void testIsActive_givenSiteMapConfigurationImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SiteMapConfigurationImpl()).isActive());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setActiveStartDate(Date)}.
   * <p>
   * Method under test:
   * {@link AbstractModuleConfiguration#setActiveStartDate(Date)}
   */
  @Test
  public void testSetActiveStartDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    siteMapConfigurationImpl.setActiveStartDate(startDate);

    // Assert
    assertSame(startDate, siteMapConfigurationImpl.getActiveStartDate());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setActiveStartDate(Date)}.
   * <ul>
   *   <li>Then {@link SiteMapConfigurationImpl} (default constructor)
   * ActiveStartDate is {@link java.sql.Date}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractModuleConfiguration#setActiveStartDate(java.util.Date)}
   */
  @Test
  public void testSetActiveStartDate_thenSiteMapConfigurationImplActiveStartDateIsDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    java.sql.Date startDate = mock(java.sql.Date.class);

    // Act
    siteMapConfigurationImpl.setActiveStartDate(startDate);

    // Assert
    assertSame(startDate, siteMapConfigurationImpl.getActiveStartDate());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getActiveStartDate()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate_givenSiteMapConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteMapConfigurationImpl()).getActiveStartDate());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getActiveStartDate()}.
   * <ul>
   *   <li>Then calls {@link ModuleConfigurationType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ModuleConfigurationType moduleConfigurationType = mock(ModuleConfigurationType.class);
    when(moduleConfigurationType.getType()).thenReturn("Type");

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setModuleConfigurationType(moduleConfigurationType);

    // Act
    Date actualActiveStartDate = siteMapConfigurationImpl.getActiveStartDate();

    // Assert
    verify(moduleConfigurationType).getType();
    assertNull(actualActiveStartDate);
  }

  /**
   * Test {@link AbstractModuleConfiguration#setActiveEndDate(Date)}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setActiveEndDate(Date)}
   */
  @Test
  public void testSetActiveEndDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    Date endDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    siteMapConfigurationImpl.setActiveEndDate(endDate);

    // Assert
    assertSame(endDate, siteMapConfigurationImpl.getActiveEndDate());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setActiveEndDate(Date)}.
   * <ul>
   *   <li>When {@link java.sql.Date}.</li>
   *   <li>Then {@link SiteMapConfigurationImpl} (default constructor) ActiveEndDate
   * is {@link java.sql.Date}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractModuleConfiguration#setActiveEndDate(java.util.Date)}
   */
  @Test
  public void testSetActiveEndDate_whenDate_thenSiteMapConfigurationImplActiveEndDateIsDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    java.sql.Date endDate = mock(java.sql.Date.class);

    // Act
    siteMapConfigurationImpl.setActiveEndDate(endDate);

    // Assert
    assertSame(endDate, siteMapConfigurationImpl.getActiveEndDate());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getActiveEndDate()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate_givenSiteMapConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteMapConfigurationImpl()).getActiveEndDate());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getActiveEndDate()}.
   * <ul>
   *   <li>Then calls {@link ModuleConfigurationType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ModuleConfigurationType moduleConfigurationType = mock(ModuleConfigurationType.class);
    when(moduleConfigurationType.getType()).thenReturn("Type");

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setModuleConfigurationType(moduleConfigurationType);

    // Act
    Date actualActiveEndDate = siteMapConfigurationImpl.getActiveEndDate();

    // Assert
    verify(moduleConfigurationType).getType();
    assertNull(actualActiveEndDate);
  }

  /**
   * Test {@link AbstractModuleConfiguration#getPriority()}.
   * <ul>
   *   <li>Given {@link ModuleConfigurationType}
   * {@link ModuleConfigurationType#getType()} return {@code Type}.</li>
   *   <li>Then calls {@link ModuleConfigurationType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getPriority()}
   */
  @Test
  public void testGetPriority_givenModuleConfigurationTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ModuleConfigurationType moduleConfigurationType = mock(ModuleConfigurationType.class);
    when(moduleConfigurationType.getType()).thenReturn("Type");

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setModuleConfigurationType(moduleConfigurationType);

    // Act
    Integer actualPriority = siteMapConfigurationImpl.getPriority();

    // Assert
    verify(moduleConfigurationType).getType();
    assertEquals(100, actualPriority.intValue());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getPriority()}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getPriority()}
   */
  @Test
  public void testGetPriority_givenSiteMapConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(100, (new SiteMapConfigurationImpl()).getPriority().intValue());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setPriority(Integer)}.
   * <ul>
   *   <li>Given {@link ModuleConfigurationType}
   * {@link ModuleConfigurationType#getType()} return {@code Type}.</li>
   *   <li>Then calls {@link ModuleConfigurationType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setPriority(Integer)}
   */
  @Test
  public void testSetPriority_givenModuleConfigurationTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ModuleConfigurationType moduleConfigurationType = mock(ModuleConfigurationType.class);
    when(moduleConfigurationType.getType()).thenReturn("Type");

    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setModuleConfigurationType(moduleConfigurationType);

    // Act
    siteMapConfigurationImpl.setPriority(1);

    // Assert
    verify(moduleConfigurationType).getType();
    assertEquals(1, siteMapConfigurationImpl.getPriority().intValue());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setPriority(Integer)}.
   * <ul>
   *   <li>Given {@link SiteMapConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setPriority(Integer)}
   */
  @Test
  public void testSetPriority_givenSiteMapConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();

    // Act
    siteMapConfigurationImpl.setPriority(1);

    // Assert
    assertEquals(1, siteMapConfigurationImpl.getPriority().intValue());
  }
}
