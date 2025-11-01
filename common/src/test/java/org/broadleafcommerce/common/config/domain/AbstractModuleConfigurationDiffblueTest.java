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
   * Method under test: {@link AbstractModuleConfiguration#getId()}
   */
  @Test
  public void testGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteMapConfigurationImpl()).getId());
  }

  /**
   * Method under test: {@link AbstractModuleConfiguration#getId()}
   */
  @Test
  public void testGetId2() {
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
   * Method under test: {@link AbstractModuleConfiguration#setId(Long)}
   */
  @Test
  public void testSetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();

    // Act
    siteMapConfigurationImpl.setId(1L);

    // Assert
    assertEquals(1L, siteMapConfigurationImpl.getId().longValue());
  }

  /**
   * Method under test: {@link AbstractModuleConfiguration#setId(Long)}
   */
  @Test
  public void testSetId2() {
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
   * Method under test: {@link AbstractModuleConfiguration#getModuleName()}
   */
  @Test
  public void testGetModuleName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteMapConfigurationImpl()).getModuleName());
  }

  /**
   * Method under test: {@link AbstractModuleConfiguration#getModuleName()}
   */
  @Test
  public void testGetModuleName2() {
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
   * Method under test: {@link AbstractModuleConfiguration#setModuleName(String)}
   */
  @Test
  public void testSetModuleName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();

    // Act
    siteMapConfigurationImpl.setModuleName("Name");

    // Assert
    assertEquals("Name", siteMapConfigurationImpl.getModuleName());
  }

  /**
   * Method under test: {@link AbstractModuleConfiguration#setModuleName(String)}
   */
  @Test
  public void testSetModuleName2() {
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
   * Method under test: {@link AbstractModuleConfiguration#getIsDefault()}
   */
  @Test
  public void testGetIsDefault() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SiteMapConfigurationImpl()).getIsDefault());
  }

  /**
   * Method under test: {@link AbstractModuleConfiguration#getIsDefault()}
   */
  @Test
  public void testGetIsDefault2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setIsDefault(null);

    // Act and Assert
    assertFalse(siteMapConfigurationImpl.getIsDefault());
  }

  /**
   * Method under test: {@link AbstractModuleConfiguration#getIsDefault()}
   */
  @Test
  public void testGetIsDefault3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setIsDefault(true);

    // Act and Assert
    assertTrue(siteMapConfigurationImpl.getIsDefault());
  }

  /**
   * Method under test: {@link AbstractModuleConfiguration#getIsDefault()}
   */
  @Test
  public void testGetIsDefault4() {
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
   * Method under test: {@link AbstractModuleConfiguration#isDefault()}
   */
  @Test
  public void testIsDefault() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SiteMapConfigurationImpl()).isDefault());
  }

  /**
   * Method under test: {@link AbstractModuleConfiguration#isDefault()}
   */
  @Test
  public void testIsDefault2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setIsDefault(null);

    // Act and Assert
    assertFalse(siteMapConfigurationImpl.isDefault());
  }

  /**
   * Method under test: {@link AbstractModuleConfiguration#isDefault()}
   */
  @Test
  public void testIsDefault3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();
    siteMapConfigurationImpl.setIsDefault(true);

    // Act and Assert
    assertTrue(siteMapConfigurationImpl.isDefault());
  }

  /**
   * Method under test: {@link AbstractModuleConfiguration#isDefault()}
   */
  @Test
  public void testIsDefault4() {
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
   * Method under test: {@link AbstractModuleConfiguration#setIsDefault(Boolean)}
   */
  @Test
  public void testSetIsDefault() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();

    // Act
    siteMapConfigurationImpl.setIsDefault(true);

    // Assert
    assertTrue(siteMapConfigurationImpl.getIsDefault());
  }

  /**
   * Method under test: {@link AbstractModuleConfiguration#setIsDefault(Boolean)}
   */
  @Test
  public void testSetIsDefault2() {
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
   * Method under test:
   * {@link AbstractModuleConfiguration#getModuleConfigurationType()}
   */
  @Test
  public void testGetModuleConfigurationType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ModuleConfigurationType actualModuleConfigurationType = (new SiteMapConfigurationImpl())
        .getModuleConfigurationType();

    // Assert
    assertSame(actualModuleConfigurationType.SITE_MAP, actualModuleConfigurationType);
  }

  /**
   * Method under test:
   * {@link AbstractModuleConfiguration#setAuditable(Auditable)}
   */
  @Test
  public void testSetAuditable() {
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
   * Method under test:
   * {@link AbstractModuleConfiguration#setAuditable(Auditable)}
   */
  @Test
  public void testSetAuditable2() {
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
   * Method under test: {@link AbstractModuleConfiguration#getAuditable()}
   */
  @Test
  public void testGetAuditable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();

    // Act and Assert
    assertSame(siteMapConfigurationImpl.auditable, siteMapConfigurationImpl.getAuditable());
  }

  /**
   * Method under test: {@link AbstractModuleConfiguration#getAuditable()}
   */
  @Test
  public void testGetAuditable2() {
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
   * Method under test: {@link AbstractModuleConfiguration#setArchived(Character)}
   */
  @Test
  public void testSetArchived() {
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
   * Method under test: {@link AbstractModuleConfiguration#setArchived(Character)}
   */
  @Test
  public void testSetArchived2() {
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
   * Method under test: {@link AbstractModuleConfiguration#getArchived()}
   */
  @Test
  public void testGetArchived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('N', (new SiteMapConfigurationImpl()).getArchived().charValue());
  }

  /**
   * Method under test: {@link AbstractModuleConfiguration#getArchived()}
   */
  @Test
  public void testGetArchived2() {
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
   * Method under test: {@link AbstractModuleConfiguration#isActive()}
   */
  @Test
  public void testIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SiteMapConfigurationImpl()).isActive());
  }

  /**
   * Method under test: {@link AbstractModuleConfiguration#isActive()}
   */
  @Test
  public void testIsActive2() {
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
   * Method under test: {@link AbstractModuleConfiguration#isActive()}
   */
  @Test
  public void testIsActive3() {
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
   * Method under test: {@link AbstractModuleConfiguration#isActive()}
   */
  @Test
  public void testIsActive4() {
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
   * Method under test:
   * {@link AbstractModuleConfiguration#setActiveStartDate(java.util.Date)}
   */
  @Test
  public void testSetActiveStartDate2() {
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
   * Method under test: {@link AbstractModuleConfiguration#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteMapConfigurationImpl()).getActiveStartDate());
  }

  /**
   * Method under test: {@link AbstractModuleConfiguration#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate2() {
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
   * Method under test:
   * {@link AbstractModuleConfiguration#setActiveEndDate(java.util.Date)}
   */
  @Test
  public void testSetActiveEndDate2() {
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
   * Method under test: {@link AbstractModuleConfiguration#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteMapConfigurationImpl()).getActiveEndDate());
  }

  /**
   * Method under test: {@link AbstractModuleConfiguration#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate2() {
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
   * Method under test: {@link AbstractModuleConfiguration#getPriority()}
   */
  @Test
  public void testGetPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(100, (new SiteMapConfigurationImpl()).getPriority().intValue());
  }

  /**
   * Method under test: {@link AbstractModuleConfiguration#getPriority()}
   */
  @Test
  public void testGetPriority2() {
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
   * Method under test: {@link AbstractModuleConfiguration#setPriority(Integer)}
   */
  @Test
  public void testSetPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapConfigurationImpl siteMapConfigurationImpl = new SiteMapConfigurationImpl();

    // Act
    siteMapConfigurationImpl.setPriority(1);

    // Assert
    assertEquals(1, siteMapConfigurationImpl.getPriority().intValue());
  }

  /**
   * Method under test: {@link AbstractModuleConfiguration#setPriority(Integer)}
   */
  @Test
  public void testSetPriority2() {
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
}
