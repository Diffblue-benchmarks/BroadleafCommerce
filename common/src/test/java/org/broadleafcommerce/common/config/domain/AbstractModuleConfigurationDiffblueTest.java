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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.config.service.type.ModuleConfigurationType;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
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
public class AbstractModuleConfigurationDiffblueTest {
  @Autowired
  private AbstractModuleConfiguration abstractModuleConfiguration;

  /**
   * Test {@link AbstractModuleConfiguration#getId()}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long AbstractModuleConfiguration.getId()"})
  public void testGetId() {
    // Arrange, Act and Assert
    assertNull(abstractModuleConfiguration.getId());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setId(Long)}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setId(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractModuleConfiguration.setId(Long)"})
  public void testSetId() {
    // Arrange and Act
    abstractModuleConfiguration.setId(1L);

    // Assert
    assertTrue(abstractModuleConfiguration instanceof SiteMapConfigurationImpl);
    assertEquals(1L, abstractModuleConfiguration.getId().longValue());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getModuleName()}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getModuleName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractModuleConfiguration.getModuleName()"})
  public void testGetModuleName() {
    // Arrange, Act and Assert
    assertNull(abstractModuleConfiguration.getModuleName());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setModuleName(String)}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setModuleName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractModuleConfiguration.setModuleName(String)"})
  public void testSetModuleName() {
    // Arrange and Act
    abstractModuleConfiguration.setModuleName("Name");

    // Assert
    assertTrue(abstractModuleConfiguration instanceof SiteMapConfigurationImpl);
    assertEquals("Name", abstractModuleConfiguration.getModuleName());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getIsDefault()}.
   * <ul>
   *   <li>Given {@link AbstractModuleConfiguration} IsDefault is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getIsDefault()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean AbstractModuleConfiguration.getIsDefault()"})
  public void testGetIsDefault_givenAbstractModuleConfigurationIsDefaultIsNull_thenReturnFalse() {
    // Arrange
    abstractModuleConfiguration.setIsDefault(null);

    // Act and Assert
    assertFalse(abstractModuleConfiguration.getIsDefault());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getIsDefault()}.
   * <ul>
   *   <li>Given {@link AbstractModuleConfiguration} IsDefault is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getIsDefault()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean AbstractModuleConfiguration.getIsDefault()"})
  public void testGetIsDefault_givenAbstractModuleConfigurationIsDefaultIsTrue_thenReturnTrue() {
    // Arrange
    abstractModuleConfiguration.setIsDefault(true);

    // Act and Assert
    assertTrue(abstractModuleConfiguration.getIsDefault());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getIsDefault()}.
   * <ul>
   *   <li>Given {@link AbstractModuleConfiguration}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getIsDefault()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean AbstractModuleConfiguration.getIsDefault()"})
  public void testGetIsDefault_givenAbstractModuleConfiguration_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(abstractModuleConfiguration.getIsDefault());
  }

  /**
   * Test {@link AbstractModuleConfiguration#isDefault()}.
   * <ul>
   *   <li>Given {@link AbstractModuleConfiguration} IsDefault is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#isDefault()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractModuleConfiguration.isDefault()"})
  public void testIsDefault_givenAbstractModuleConfigurationIsDefaultIsNull_thenReturnFalse() {
    // Arrange
    abstractModuleConfiguration.setIsDefault(null);

    // Act and Assert
    assertFalse(abstractModuleConfiguration.isDefault());
  }

  /**
   * Test {@link AbstractModuleConfiguration#isDefault()}.
   * <ul>
   *   <li>Given {@link AbstractModuleConfiguration} IsDefault is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#isDefault()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractModuleConfiguration.isDefault()"})
  public void testIsDefault_givenAbstractModuleConfigurationIsDefaultIsTrue_thenReturnTrue() {
    // Arrange
    abstractModuleConfiguration.setIsDefault(true);

    // Act and Assert
    assertTrue(abstractModuleConfiguration.isDefault());
  }

  /**
   * Test {@link AbstractModuleConfiguration#isDefault()}.
   * <ul>
   *   <li>Given {@link AbstractModuleConfiguration}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#isDefault()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractModuleConfiguration.isDefault()"})
  public void testIsDefault_givenAbstractModuleConfiguration_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(abstractModuleConfiguration.isDefault());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setIsDefault(Boolean)}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setIsDefault(Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractModuleConfiguration.setIsDefault(Boolean)"})
  public void testSetIsDefault() {
    // Arrange and Act
    abstractModuleConfiguration.setIsDefault(true);

    // Assert
    assertTrue(abstractModuleConfiguration instanceof SiteMapConfigurationImpl);
    assertTrue(abstractModuleConfiguration.getIsDefault());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setModuleConfigurationType(ModuleConfigurationType)}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setModuleConfigurationType(ModuleConfigurationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractModuleConfiguration.setModuleConfigurationType(ModuleConfigurationType)"})
  public void testSetModuleConfigurationType() {
    // Arrange
    ModuleConfigurationType moduleConfigurationType = ModuleConfigurationType.ADDRESS_VERIFICATION;

    // Act
    abstractModuleConfiguration.setModuleConfigurationType(moduleConfigurationType);

    // Assert
    assertTrue(abstractModuleConfiguration instanceof SiteMapConfigurationImpl);
    assertEquals("ADDRESS_VERIFICATION", ((SiteMapConfigurationImpl) abstractModuleConfiguration).configType);
    ModuleConfigurationType expectedModuleConfigurationType = moduleConfigurationType.ADDRESS_VERIFICATION;
    assertSame(expectedModuleConfigurationType, abstractModuleConfiguration.getModuleConfigurationType());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getModuleConfigurationType()}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getModuleConfigurationType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ModuleConfigurationType AbstractModuleConfiguration.getModuleConfigurationType()"})
  public void testGetModuleConfigurationType() {
    // Arrange and Act
    ModuleConfigurationType actualModuleConfigurationType = abstractModuleConfiguration.getModuleConfigurationType();

    // Assert
    assertSame(actualModuleConfigurationType.SITE_MAP, actualModuleConfigurationType);
  }

  /**
   * Test {@link AbstractModuleConfiguration#setAuditable(Auditable)}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setAuditable(Auditable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractModuleConfiguration.setAuditable(Auditable)"})
  public void testSetAuditable() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    // Act
    abstractModuleConfiguration.setAuditable(auditable);

    // Assert
    assertTrue(abstractModuleConfiguration instanceof SiteMapConfigurationImpl);
    assertSame(auditable, abstractModuleConfiguration.getAuditable());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getAuditable()}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getAuditable()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Auditable AbstractModuleConfiguration.getAuditable()"})
  public void testGetAuditable() {
    // Arrange, Act and Assert
    assertSame(abstractModuleConfiguration.auditable, abstractModuleConfiguration.getAuditable());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setArchived(Character)}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setArchived(Character)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractModuleConfiguration.setArchived(Character)"})
  public void testSetArchived() {
    // Arrange and Act
    abstractModuleConfiguration.setArchived('A');

    // Assert
    assertTrue(abstractModuleConfiguration instanceof SiteMapConfigurationImpl);
    assertEquals('A', abstractModuleConfiguration.getArchived().charValue());
    assertEquals('A', ((SiteMapConfigurationImpl) abstractModuleConfiguration).archiveStatus.getArchived().charValue());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getArchived()}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getArchived()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Character AbstractModuleConfiguration.getArchived()"})
  public void testGetArchived() {
    // Arrange, Act and Assert
    assertEquals('N', abstractModuleConfiguration.getArchived().charValue());
  }

  /**
   * Test {@link AbstractModuleConfiguration#isActive()}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#isActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractModuleConfiguration.isActive()"})
  public void testIsActive() {
    // Arrange
    abstractModuleConfiguration.setArchived(null);
    abstractModuleConfiguration
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    abstractModuleConfiguration
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(abstractModuleConfiguration.isActive());
  }

  /**
   * Test {@link AbstractModuleConfiguration#isActive()}.
   * <ul>
   *   <li>Given {@link AbstractModuleConfiguration} Archived is {@code Y}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#isActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractModuleConfiguration.isActive()"})
  public void testIsActive_givenAbstractModuleConfigurationArchivedIsY_thenReturnFalse() {
    // Arrange
    abstractModuleConfiguration.setArchived('Y');
    abstractModuleConfiguration
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    abstractModuleConfiguration.setActiveEndDate(null);

    // Act and Assert
    assertFalse(abstractModuleConfiguration.isActive());
  }

  /**
   * Test {@link AbstractModuleConfiguration#isActive()}.
   * <ul>
   *   <li>Given {@link AbstractModuleConfiguration}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#isActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractModuleConfiguration.isActive()"})
  public void testIsActive_givenAbstractModuleConfiguration_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(abstractModuleConfiguration.isActive());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setActiveStartDate(Date)}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setActiveStartDate(Date)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractModuleConfiguration.setActiveStartDate(Date)"})
  public void testSetActiveStartDate() {
    // Arrange
    Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    abstractModuleConfiguration.setActiveStartDate(startDate);

    // Assert
    assertTrue(abstractModuleConfiguration instanceof SiteMapConfigurationImpl);
    assertSame(startDate, abstractModuleConfiguration.getActiveStartDate());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getActiveStartDate()}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getActiveStartDate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date AbstractModuleConfiguration.getActiveStartDate()"})
  public void testGetActiveStartDate() {
    // Arrange, Act and Assert
    assertNull(abstractModuleConfiguration.getActiveStartDate());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setActiveEndDate(Date)}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setActiveEndDate(Date)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractModuleConfiguration.setActiveEndDate(Date)"})
  public void testSetActiveEndDate() {
    // Arrange
    Date endDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    abstractModuleConfiguration.setActiveEndDate(endDate);

    // Assert
    assertTrue(abstractModuleConfiguration instanceof SiteMapConfigurationImpl);
    assertSame(endDate, abstractModuleConfiguration.getActiveEndDate());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getActiveEndDate()}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getActiveEndDate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date AbstractModuleConfiguration.getActiveEndDate()"})
  public void testGetActiveEndDate() {
    // Arrange, Act and Assert
    assertNull(abstractModuleConfiguration.getActiveEndDate());
  }

  /**
   * Test {@link AbstractModuleConfiguration#getPriority()}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#getPriority()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer AbstractModuleConfiguration.getPriority()"})
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(100, abstractModuleConfiguration.getPriority().intValue());
  }

  /**
   * Test {@link AbstractModuleConfiguration#setPriority(Integer)}.
   * <p>
   * Method under test: {@link AbstractModuleConfiguration#setPriority(Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractModuleConfiguration.setPriority(Integer)"})
  public void testSetPriority() {
    // Arrange and Act
    abstractModuleConfiguration.setPriority(1);

    // Assert
    assertTrue(abstractModuleConfiguration instanceof SiteMapConfigurationImpl);
    assertEquals(1, abstractModuleConfiguration.getPriority().intValue());
  }
}
