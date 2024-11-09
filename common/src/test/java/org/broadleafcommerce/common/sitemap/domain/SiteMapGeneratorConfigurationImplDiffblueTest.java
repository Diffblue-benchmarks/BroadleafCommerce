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
package org.broadleafcommerce.common.sitemap.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType;
import org.junit.Test;

public class SiteMapGeneratorConfigurationImplDiffblueTest {
  /**
   * Test {@link SiteMapGeneratorConfigurationImpl#getSiteMapChangeFreq()}.
   * <p>
   * Method under test:
   * {@link SiteMapGeneratorConfigurationImpl#getSiteMapChangeFreq()}
   */
  @Test
  public void testGetSiteMapChangeFreq() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapGeneratorConfigurationImpl siteMapGeneratorConfigurationImpl = new SiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfigurationImpl.setDisabled(true);
    siteMapGeneratorConfigurationImpl.setId(1L);
    siteMapGeneratorConfigurationImpl.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfigurationImpl.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    siteMapGeneratorConfigurationImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapGeneratorConfigurationImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);

    // Act
    SiteMapChangeFreqType actualSiteMapChangeFreq = siteMapGeneratorConfigurationImpl.getSiteMapChangeFreq();

    // Assert
    assertSame(actualSiteMapChangeFreq.ALWAYS, actualSiteMapChangeFreq);
  }

  /**
   * Test {@link SiteMapGeneratorConfigurationImpl#getSiteMapChangeFreq()}.
   * <p>
   * Method under test:
   * {@link SiteMapGeneratorConfigurationImpl#getSiteMapChangeFreq()}
   */
  @Test
  public void testGetSiteMapChangeFreq2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapGeneratorConfigurationImpl siteMapGeneratorConfigurationImpl = new SiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfigurationImpl.setDisabled(true);
    siteMapGeneratorConfigurationImpl.setId(1L);
    siteMapGeneratorConfigurationImpl.setSiteMapConfiguration(mock(SiteMapConfiguration.class));
    siteMapGeneratorConfigurationImpl.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    siteMapGeneratorConfigurationImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapGeneratorConfigurationImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);

    // Act
    SiteMapChangeFreqType actualSiteMapChangeFreq = siteMapGeneratorConfigurationImpl.getSiteMapChangeFreq();

    // Assert
    assertSame(actualSiteMapChangeFreq.ALWAYS, actualSiteMapChangeFreq);
  }

  /**
   * Test {@link SiteMapGeneratorConfigurationImpl#getSiteMapChangeFreq()}.
   * <ul>
   *   <li>Given {@link SiteMapGeneratorConfigurationImpl} (default
   * constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapGeneratorConfigurationImpl#getSiteMapChangeFreq()}
   */
  @Test
  public void testGetSiteMapChangeFreq_givenSiteMapGeneratorConfigurationImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteMapGeneratorConfigurationImpl()).getSiteMapChangeFreq());
  }

  /**
   * Test
   * {@link SiteMapGeneratorConfigurationImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}.
   * <ul>
   *   <li>Then {@link SiteMapGeneratorConfigurationImpl} (default constructor)
   * {@link SiteMapGeneratorConfigurationImpl#changeFreq} is {@code ALWAYS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapGeneratorConfigurationImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}
   */
  @Test
  public void testSetSiteMapChangeFreq_thenSiteMapGeneratorConfigurationImplChangeFreqIsAlways() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapGeneratorConfigurationImpl siteMapGeneratorConfigurationImpl = new SiteMapGeneratorConfigurationImpl();
    SiteMapChangeFreqType siteMapChangeFreq = SiteMapChangeFreqType.ALWAYS;

    // Act
    siteMapGeneratorConfigurationImpl.setSiteMapChangeFreq(siteMapChangeFreq);

    // Assert
    assertEquals("ALWAYS", siteMapGeneratorConfigurationImpl.changeFreq);
    SiteMapChangeFreqType expectedSiteMapChangeFreq = siteMapChangeFreq.ALWAYS;
    assertSame(expectedSiteMapChangeFreq, siteMapGeneratorConfigurationImpl.getSiteMapChangeFreq());
  }

  /**
   * Test
   * {@link SiteMapGeneratorConfigurationImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}.
   * <ul>
   *   <li>Then {@link SiteMapGeneratorConfigurationImpl} (default constructor)
   * {@link SiteMapGeneratorConfigurationImpl#changeFreq} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapGeneratorConfigurationImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}
   */
  @Test
  public void testSetSiteMapChangeFreq_thenSiteMapGeneratorConfigurationImplChangeFreqIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapGeneratorConfigurationImpl siteMapGeneratorConfigurationImpl = new SiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfigurationImpl.setDisabled(true);
    siteMapGeneratorConfigurationImpl.setId(1L);
    siteMapGeneratorConfigurationImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapGeneratorConfigurationImpl.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfigurationImpl.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    siteMapGeneratorConfigurationImpl.setSiteMapPriority(SiteMapPriorityType.ONE);

    // Act
    siteMapGeneratorConfigurationImpl.setSiteMapChangeFreq(null);

    // Assert
    assertNull(siteMapGeneratorConfigurationImpl.changeFreq);
    assertNull(siteMapGeneratorConfigurationImpl.getSiteMapChangeFreq());
  }

  /**
   * Test {@link SiteMapGeneratorConfigurationImpl#getSiteMapPriority()}.
   * <p>
   * Method under test:
   * {@link SiteMapGeneratorConfigurationImpl#getSiteMapPriority()}
   */
  @Test
  public void testGetSiteMapPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapGeneratorConfigurationImpl siteMapGeneratorConfigurationImpl = new SiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfigurationImpl.setDisabled(true);
    siteMapGeneratorConfigurationImpl.setId(1L);
    siteMapGeneratorConfigurationImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapGeneratorConfigurationImpl.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfigurationImpl.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    siteMapGeneratorConfigurationImpl.setSiteMapPriority(SiteMapPriorityType.ONE);

    // Act
    SiteMapPriorityType actualSiteMapPriority = siteMapGeneratorConfigurationImpl.getSiteMapPriority();

    // Assert
    assertSame(actualSiteMapPriority.ONE, actualSiteMapPriority);
  }

  /**
   * Test {@link SiteMapGeneratorConfigurationImpl#getSiteMapPriority()}.
   * <ul>
   *   <li>Given {@link SiteMapGeneratorConfigurationImpl} (default
   * constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapGeneratorConfigurationImpl#getSiteMapPriority()}
   */
  @Test
  public void testGetSiteMapPriority_givenSiteMapGeneratorConfigurationImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteMapGeneratorConfigurationImpl()).getSiteMapPriority());
  }

  /**
   * Test {@link SiteMapGeneratorConfigurationImpl#getSiteMapPriority()}.
   * <ul>
   *   <li>Then calls {@link SiteMapChangeFreqType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapGeneratorConfigurationImpl#getSiteMapPriority()}
   */
  @Test
  public void testGetSiteMapPriority_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapChangeFreqType siteMapChangeFreq = mock(SiteMapChangeFreqType.class);
    when(siteMapChangeFreq.getType()).thenReturn("Type");

    SiteMapGeneratorConfigurationImpl siteMapGeneratorConfigurationImpl = new SiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfigurationImpl.setDisabled(true);
    siteMapGeneratorConfigurationImpl.setId(1L);
    siteMapGeneratorConfigurationImpl.setSiteMapChangeFreq(siteMapChangeFreq);
    siteMapGeneratorConfigurationImpl.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfigurationImpl.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    siteMapGeneratorConfigurationImpl.setSiteMapPriority(SiteMapPriorityType.ONE);

    // Act
    SiteMapPriorityType actualSiteMapPriority = siteMapGeneratorConfigurationImpl.getSiteMapPriority();

    // Assert
    verify(siteMapChangeFreq).getType();
    assertSame(actualSiteMapPriority.ONE, actualSiteMapPriority);
  }

  /**
   * Test
   * {@link SiteMapGeneratorConfigurationImpl#setSiteMapPriority(SiteMapPriorityType)}.
   * <ul>
   *   <li>Then {@link SiteMapGeneratorConfigurationImpl} (default constructor)
   * {@link SiteMapGeneratorConfigurationImpl#priority} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapGeneratorConfigurationImpl#setSiteMapPriority(SiteMapPriorityType)}
   */
  @Test
  public void testSetSiteMapPriority_thenSiteMapGeneratorConfigurationImplPriorityIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapGeneratorConfigurationImpl siteMapGeneratorConfigurationImpl = new SiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfigurationImpl.setDisabled(true);
    siteMapGeneratorConfigurationImpl.setId(1L);
    siteMapGeneratorConfigurationImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapGeneratorConfigurationImpl.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfigurationImpl.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    siteMapGeneratorConfigurationImpl.setSiteMapPriority(SiteMapPriorityType.ONE);

    // Act
    siteMapGeneratorConfigurationImpl.setSiteMapPriority(null);

    // Assert
    assertNull(siteMapGeneratorConfigurationImpl.priority);
    assertNull(siteMapGeneratorConfigurationImpl.getSiteMapPriority());
  }

  /**
   * Test
   * {@link SiteMapGeneratorConfigurationImpl#setSiteMapPriority(SiteMapPriorityType)}.
   * <ul>
   *   <li>When {@link SiteMapPriorityType#ONE}.</li>
   *   <li>Then {@link SiteMapGeneratorConfigurationImpl} (default constructor)
   * {@link SiteMapGeneratorConfigurationImpl#priority} is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapGeneratorConfigurationImpl#setSiteMapPriority(SiteMapPriorityType)}
   */
  @Test
  public void testSetSiteMapPriority_whenOne_thenSiteMapGeneratorConfigurationImplPriorityIs10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapGeneratorConfigurationImpl siteMapGeneratorConfigurationImpl = new SiteMapGeneratorConfigurationImpl();
    SiteMapPriorityType siteMapPriority = SiteMapPriorityType.ONE;

    // Act
    siteMapGeneratorConfigurationImpl.setSiteMapPriority(siteMapPriority);

    // Assert
    assertEquals("1.0", siteMapGeneratorConfigurationImpl.priority);
    SiteMapPriorityType expectedSiteMapPriority = siteMapPriority.ONE;
    assertSame(expectedSiteMapPriority, siteMapGeneratorConfigurationImpl.getSiteMapPriority());
  }

  /**
   * Test {@link SiteMapGeneratorConfigurationImpl#getSiteMapGeneratorType()}.
   * <p>
   * Method under test:
   * {@link SiteMapGeneratorConfigurationImpl#getSiteMapGeneratorType()}
   */
  @Test
  public void testGetSiteMapGeneratorType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapGeneratorConfigurationImpl siteMapGeneratorConfigurationImpl = new SiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfigurationImpl.setDisabled(true);
    siteMapGeneratorConfigurationImpl.setId(1L);
    siteMapGeneratorConfigurationImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapGeneratorConfigurationImpl.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfigurationImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapGeneratorConfigurationImpl.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);

    // Act
    SiteMapGeneratorType actualSiteMapGeneratorType = siteMapGeneratorConfigurationImpl.getSiteMapGeneratorType();

    // Assert
    assertSame(actualSiteMapGeneratorType.CATEGORY, actualSiteMapGeneratorType);
  }

  /**
   * Test {@link SiteMapGeneratorConfigurationImpl#getSiteMapGeneratorType()}.
   * <ul>
   *   <li>Then calls {@link SiteMapChangeFreqType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapGeneratorConfigurationImpl#getSiteMapGeneratorType()}
   */
  @Test
  public void testGetSiteMapGeneratorType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapChangeFreqType siteMapChangeFreq = mock(SiteMapChangeFreqType.class);
    when(siteMapChangeFreq.getType()).thenReturn("Type");

    SiteMapGeneratorConfigurationImpl siteMapGeneratorConfigurationImpl = new SiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfigurationImpl.setDisabled(true);
    siteMapGeneratorConfigurationImpl.setId(1L);
    siteMapGeneratorConfigurationImpl.setSiteMapChangeFreq(siteMapChangeFreq);
    siteMapGeneratorConfigurationImpl.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfigurationImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapGeneratorConfigurationImpl.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);

    // Act
    SiteMapGeneratorType actualSiteMapGeneratorType = siteMapGeneratorConfigurationImpl.getSiteMapGeneratorType();

    // Assert
    verify(siteMapChangeFreq).getType();
    assertSame(actualSiteMapGeneratorType.CATEGORY, actualSiteMapGeneratorType);
  }

  /**
   * Test {@link SiteMapGeneratorConfigurationImpl#getSiteMapGeneratorType()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapGeneratorConfigurationImpl#getSiteMapGeneratorType()}
   */
  @Test
  public void testGetSiteMapGeneratorType_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteMapGeneratorConfigurationImpl()).getSiteMapGeneratorType());
  }

  /**
   * Test
   * {@link SiteMapGeneratorConfigurationImpl#setSiteMapGeneratorType(SiteMapGeneratorType)}.
   * <p>
   * Method under test:
   * {@link SiteMapGeneratorConfigurationImpl#setSiteMapGeneratorType(SiteMapGeneratorType)}
   */
  @Test
  public void testSetSiteMapGeneratorType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapGeneratorConfigurationImpl siteMapGeneratorConfigurationImpl = new SiteMapGeneratorConfigurationImpl();
    SiteMapGeneratorType siteMapGeneratorType = SiteMapGeneratorType.CATEGORY;

    // Act
    siteMapGeneratorConfigurationImpl.setSiteMapGeneratorType(siteMapGeneratorType);

    // Assert
    assertEquals("CATEGORY", siteMapGeneratorConfigurationImpl.generatorType);
    SiteMapGeneratorType expectedSiteMapGeneratorType = siteMapGeneratorType.CATEGORY;
    assertSame(expectedSiteMapGeneratorType, siteMapGeneratorConfigurationImpl.getSiteMapGeneratorType());
  }

  /**
   * Test
   * {@link SiteMapGeneratorConfigurationImpl#setSiteMapGeneratorType(SiteMapGeneratorType)}.
   * <p>
   * Method under test:
   * {@link SiteMapGeneratorConfigurationImpl#setSiteMapGeneratorType(SiteMapGeneratorType)}
   */
  @Test
  public void testSetSiteMapGeneratorType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapGeneratorConfigurationImpl siteMapGeneratorConfigurationImpl = new SiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfigurationImpl.setDisabled(true);
    siteMapGeneratorConfigurationImpl.setId(1L);
    siteMapGeneratorConfigurationImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapGeneratorConfigurationImpl.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfigurationImpl.setSiteMapGeneratorType(SiteMapGeneratorType.CATEGORY);
    siteMapGeneratorConfigurationImpl.setSiteMapPriority(SiteMapPriorityType.ONE);

    // Act
    siteMapGeneratorConfigurationImpl.setSiteMapGeneratorType(null);

    // Assert
    assertNull(siteMapGeneratorConfigurationImpl.generatorType);
    assertNull(siteMapGeneratorConfigurationImpl.getSiteMapGeneratorType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link SiteMapGeneratorConfigurationImpl}
   *   <li>{@link SiteMapGeneratorConfigurationImpl#setDisabled(Boolean)}
   *   <li>{@link SiteMapGeneratorConfigurationImpl#setId(Long)}
   *   <li>
   * {@link SiteMapGeneratorConfigurationImpl#setSiteMapConfiguration(SiteMapConfiguration)}
   *   <li>{@link SiteMapGeneratorConfigurationImpl#getId()}
   *   <li>{@link SiteMapGeneratorConfigurationImpl#getSiteMapConfiguration()}
   *   <li>{@link SiteMapGeneratorConfigurationImpl#isDisabled()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SiteMapGeneratorConfigurationImpl actualSiteMapGeneratorConfigurationImpl = new SiteMapGeneratorConfigurationImpl();
    actualSiteMapGeneratorConfigurationImpl.setDisabled(true);
    actualSiteMapGeneratorConfigurationImpl.setId(1L);
    SiteMapConfigurationImpl siteMapConfiguration = new SiteMapConfigurationImpl();
    actualSiteMapGeneratorConfigurationImpl.setSiteMapConfiguration(siteMapConfiguration);
    Long actualId = actualSiteMapGeneratorConfigurationImpl.getId();
    SiteMapConfiguration actualSiteMapConfiguration = actualSiteMapGeneratorConfigurationImpl.getSiteMapConfiguration();
    Boolean actualIsDisabledResult = actualSiteMapGeneratorConfigurationImpl.isDisabled();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertTrue(actualIsDisabledResult);
    assertSame(siteMapConfiguration, actualSiteMapConfiguration);
  }
}
