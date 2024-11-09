/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AdornedTargetCollectionMetadata.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class FieldMetadataDiffblueTest {
  @Autowired
  private FieldMetadata fieldMetadata;

  /**
   * Test {@link FieldMetadata#getAvailableToTypes()}.
   * <p>
   * Method under test: {@link FieldMetadata#getAvailableToTypes()}
   */
  @Test
  public void testGetAvailableToTypes() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getAvailableToTypes());
  }

  /**
   * Test {@link FieldMetadata#setAvailableToTypes(String[])}.
   * <p>
   * Method under test: {@link FieldMetadata#setAvailableToTypes(String[])}
   */
  @Test
  public void testSetAvailableToTypes() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    String[] availableToTypes = new String[]{"Available To Types"};

    // Act
    adornedTargetCollectionMetadata.setAvailableToTypes(availableToTypes);

    // Assert
    assertSame(availableToTypes, adornedTargetCollectionMetadata.getAvailableToTypes());
  }

  /**
   * Test {@link FieldMetadata#getInheritedFromType()}.
   * <p>
   * Method under test: {@link FieldMetadata#getInheritedFromType()}
   */
  @Test
  public void testGetInheritedFromType() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getInheritedFromType());
  }

  /**
   * Test {@link FieldMetadata#setInheritedFromType(String)}.
   * <p>
   * Method under test: {@link FieldMetadata#setInheritedFromType(String)}
   */
  @Test
  public void testSetInheritedFromType() {
    // Arrange and Act
    fieldMetadata.setInheritedFromType("jane.doe@example.org");

    // Assert
    assertTrue(fieldMetadata instanceof AdornedTargetCollectionMetadata);
    assertEquals("jane.doe@example.org", fieldMetadata.getInheritedFromType());
  }

  /**
   * Test {@link FieldMetadata#getExcluded()}.
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#getExcluded()}
   */
  @Test
  public void testGetExcluded_givenAdornedTargetCollectionMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getExcluded());
  }

  /**
   * Test {@link FieldMetadata#getExcluded()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#getExcluded()}
   */
  @Test
  public void testGetExcluded_thenReturnFalse() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setExcluded(false);

    // Act and Assert
    assertFalse(adornedTargetCollectionMetadata.getExcluded());
  }

  /**
   * Test {@link FieldMetadata#getExcluded()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#getExcluded()}
   */
  @Test
  public void testGetExcluded_thenReturnTrue() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setExcluded(true);

    // Act and Assert
    assertTrue(adornedTargetCollectionMetadata.getExcluded());
  }

  /**
   * Test {@link FieldMetadata#setExcluded(Boolean)}.
   * <p>
   * Method under test: {@link FieldMetadata#setExcluded(Boolean)}
   */
  @Test
  public void testSetExcluded() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();

    // Act
    adornedTargetCollectionMetadata.setExcluded(true);

    // Assert
    assertTrue(adornedTargetCollectionMetadata.getExcluded());
  }

  /**
   * Test {@link FieldMetadata#getAdditionalMetadata()}.
   * <p>
   * Method under test: {@link FieldMetadata#getAdditionalMetadata()}
   */
  @Test
  public void testGetAdditionalMetadata() {
    // Arrange, Act and Assert
    assertTrue((new AdornedTargetCollectionMetadata()).getAdditionalMetadata().isEmpty());
  }

  /**
   * Test {@link FieldMetadata#setAdditionalMetadata(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#setAdditionalMetadata(Map)}
   */
  @Test
  public void testSetAdditionalMetadata_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();

    HashMap<String, Object> additionalMetadata = new HashMap<>();
    additionalMetadata.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    adornedTargetCollectionMetadata.setAdditionalMetadata(additionalMetadata);

    // Assert
    assertSame(additionalMetadata, adornedTargetCollectionMetadata.getAdditionalMetadata());
  }

  /**
   * Test {@link FieldMetadata#setAdditionalMetadata(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#setAdditionalMetadata(Map)}
   */
  @Test
  public void testSetAdditionalMetadata_whenHashMap() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    HashMap<String, Object> additionalMetadata = new HashMap<>();

    // Act
    adornedTargetCollectionMetadata.setAdditionalMetadata(additionalMetadata);

    // Assert
    assertSame(additionalMetadata, adornedTargetCollectionMetadata.getAdditionalMetadata());
  }

  /**
   * Test {@link FieldMetadata#populate(FieldMetadata)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return {@link AdornedTargetCollectionMetadata} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate_givenBasicFieldMetadata_thenReturnAdornedTargetCollectionMetadata() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertSame(metadata, basicFieldMetadata.populate(metadata));
  }

  /**
   * Test {@link FieldMetadata#getShowIfProperty()}.
   * <p>
   * Method under test: {@link FieldMetadata#getShowIfProperty()}
   */
  @Test
  public void testGetShowIfProperty() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getShowIfProperty());
  }

  /**
   * Test {@link FieldMetadata#setShowIfProperty(String)}.
   * <p>
   * Method under test: {@link FieldMetadata#setShowIfProperty(String)}
   */
  @Test
  public void testSetShowIfProperty() {
    // Arrange and Act
    fieldMetadata.setShowIfProperty("Show If Property");

    // Assert
    assertTrue(fieldMetadata instanceof AdornedTargetCollectionMetadata);
    assertEquals("Show If Property", fieldMetadata.getShowIfProperty());
  }

  /**
   * Test {@link FieldMetadata#getShowIfFieldEquals()}.
   * <p>
   * Method under test: {@link FieldMetadata#getShowIfFieldEquals()}
   */
  @Test
  public void testGetShowIfFieldEquals() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getShowIfFieldEquals());
  }

  /**
   * Test {@link FieldMetadata#setShowIfFieldEquals(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#setShowIfFieldEquals(Map)}
   */
  @Test
  public void testSetShowIfFieldEquals_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();

    HashMap<String, List<String>> showIfFieldEquals = new HashMap<>();
    showIfFieldEquals.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    adornedTargetCollectionMetadata.setShowIfFieldEquals(showIfFieldEquals);

    // Assert
    assertSame(showIfFieldEquals, adornedTargetCollectionMetadata.getShowIfFieldEquals());
  }

  /**
   * Test {@link FieldMetadata#setShowIfFieldEquals(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#setShowIfFieldEquals(Map)}
   */
  @Test
  public void testSetShowIfFieldEquals_whenHashMap() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    HashMap<String, List<String>> showIfFieldEquals = new HashMap<>();

    // Act
    adornedTargetCollectionMetadata.setShowIfFieldEquals(showIfFieldEquals);

    // Assert
    assertSame(showIfFieldEquals, adornedTargetCollectionMetadata.getShowIfFieldEquals());
  }

  /**
   * Test {@link FieldMetadata#getCurrencyCodeField()}.
   * <p>
   * Method under test: {@link FieldMetadata#getCurrencyCodeField()}
   */
  @Test
  public void testGetCurrencyCodeField() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getCurrencyCodeField());
  }

  /**
   * Test {@link FieldMetadata#setCurrencyCodeField(String)}.
   * <p>
   * Method under test: {@link FieldMetadata#setCurrencyCodeField(String)}
   */
  @Test
  public void testSetCurrencyCodeField() {
    // Arrange and Act
    fieldMetadata.setCurrencyCodeField("GBP");

    // Assert
    assertTrue(fieldMetadata instanceof AdornedTargetCollectionMetadata);
    assertEquals("GBP", fieldMetadata.getCurrencyCodeField());
  }

  /**
   * Test {@link FieldMetadata#getFriendlyName()}.
   * <p>
   * Method under test: {@link FieldMetadata#getFriendlyName()}
   */
  @Test
  public void testGetFriendlyName() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getFriendlyName());
  }

  /**
   * Test {@link FieldMetadata#setFriendlyName(String)}.
   * <p>
   * Method under test: {@link FieldMetadata#setFriendlyName(String)}
   */
  @Test
  public void testSetFriendlyName() {
    // Arrange and Act
    fieldMetadata.setFriendlyName("Friendly Name");

    // Assert
    assertTrue(fieldMetadata instanceof AdornedTargetCollectionMetadata);
    assertEquals("Friendly Name", fieldMetadata.getFriendlyName());
  }

  /**
   * Test {@link FieldMetadata#getAddFriendlyName()}.
   * <p>
   * Method under test: {@link FieldMetadata#getAddFriendlyName()}
   */
  @Test
  public void testGetAddFriendlyName() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getAddFriendlyName());
  }

  /**
   * Test {@link FieldMetadata#setAddFriendlyName(String)}.
   * <p>
   * Method under test: {@link FieldMetadata#setAddFriendlyName(String)}
   */
  @Test
  public void testSetAddFriendlyName() {
    // Arrange and Act
    fieldMetadata.setAddFriendlyName("Add Friendly Name");

    // Assert
    assertTrue(fieldMetadata instanceof AdornedTargetCollectionMetadata);
    assertEquals("Add Friendly Name", fieldMetadata.getAddFriendlyName());
  }

  /**
   * Test {@link FieldMetadata#getSecurityLevel()}.
   * <p>
   * Method under test: {@link FieldMetadata#getSecurityLevel()}
   */
  @Test
  public void testGetSecurityLevel() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getSecurityLevel());
  }

  /**
   * Test {@link FieldMetadata#setSecurityLevel(String)}.
   * <p>
   * Method under test: {@link FieldMetadata#setSecurityLevel(String)}
   */
  @Test
  public void testSetSecurityLevel() {
    // Arrange and Act
    fieldMetadata.setSecurityLevel("Security Level");

    // Assert
    assertTrue(fieldMetadata instanceof AdornedTargetCollectionMetadata);
    assertEquals("Security Level", fieldMetadata.getSecurityLevel());
  }

  /**
   * Test {@link FieldMetadata#getOrder()}.
   * <p>
   * Method under test: {@link FieldMetadata#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getOrder());
  }

  /**
   * Test {@link FieldMetadata#setOrder(Integer)}.
   * <p>
   * Method under test: {@link FieldMetadata#setOrder(Integer)}
   */
  @Test
  public void testSetOrder() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();

    // Act
    adornedTargetCollectionMetadata.setOrder(1);

    // Assert
    assertEquals(1, adornedTargetCollectionMetadata.getOrder().intValue());
  }

  /**
   * Test {@link FieldMetadata#getTargetClass()}.
   * <p>
   * Method under test: {@link FieldMetadata#getTargetClass()}
   */
  @Test
  public void testGetTargetClass() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getTargetClass());
  }

  /**
   * Test {@link FieldMetadata#setTargetClass(String)}.
   * <p>
   * Method under test: {@link FieldMetadata#setTargetClass(String)}
   */
  @Test
  public void testSetTargetClass() {
    // Arrange and Act
    fieldMetadata.setTargetClass("Target Class");

    // Assert
    assertTrue(fieldMetadata instanceof AdornedTargetCollectionMetadata);
    assertEquals("Target Class", fieldMetadata.getTargetClass());
  }

  /**
   * Test {@link FieldMetadata#getFieldName()}.
   * <p>
   * Method under test: {@link FieldMetadata#getFieldName()}
   */
  @Test
  public void testGetFieldName() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getFieldName());
  }

  /**
   * Test {@link FieldMetadata#setFieldName(String)}.
   * <p>
   * Method under test: {@link FieldMetadata#setFieldName(String)}
   */
  @Test
  public void testSetFieldName() {
    // Arrange and Act
    fieldMetadata.setFieldName("Field Name");

    // Assert
    assertTrue(fieldMetadata instanceof AdornedTargetCollectionMetadata);
    assertEquals("Field Name", fieldMetadata.getFieldName());
  }

  /**
   * Test {@link FieldMetadata#getOwningClassFriendlyName()}.
   * <p>
   * Method under test: {@link FieldMetadata#getOwningClassFriendlyName()}
   */
  @Test
  public void testGetOwningClassFriendlyName() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getOwningClassFriendlyName());
  }

  /**
   * Test {@link FieldMetadata#setOwningClassFriendlyName(String)}.
   * <p>
   * Method under test: {@link FieldMetadata#setOwningClassFriendlyName(String)}
   */
  @Test
  public void testSetOwningClassFriendlyName() {
    // Arrange and Act
    fieldMetadata.setOwningClassFriendlyName("Owning Class Friendly Name");

    // Assert
    assertTrue(fieldMetadata instanceof AdornedTargetCollectionMetadata);
    assertEquals("Owning Class Friendly Name", fieldMetadata.getOwningClassFriendlyName());
  }

  /**
   * Test {@link FieldMetadata#getOwningClass()}.
   * <p>
   * Method under test: {@link FieldMetadata#getOwningClass()}
   */
  @Test
  public void testGetOwningClass() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getOwningClass());
  }

  /**
   * Test {@link FieldMetadata#setOwningClass(String)}.
   * <p>
   * Method under test: {@link FieldMetadata#setOwningClass(String)}
   */
  @Test
  public void testSetOwningClass() {
    // Arrange and Act
    fieldMetadata.setOwningClass("Owning Class");

    // Assert
    assertTrue(fieldMetadata instanceof AdornedTargetCollectionMetadata);
    assertEquals("Owning Class", fieldMetadata.getOwningClass());
  }

  /**
   * Test {@link FieldMetadata#getPrefix()}.
   * <p>
   * Method under test: {@link FieldMetadata#getPrefix()}
   */
  @Test
  public void testGetPrefix() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getPrefix());
  }

  /**
   * Test {@link FieldMetadata#setPrefix(String)}.
   * <p>
   * Method under test: {@link FieldMetadata#setPrefix(String)}
   */
  @Test
  public void testSetPrefix() {
    // Arrange and Act
    fieldMetadata.setPrefix("Prefix");

    // Assert
    assertTrue(fieldMetadata instanceof AdornedTargetCollectionMetadata);
    assertEquals("Prefix", fieldMetadata.getPrefix());
  }

  /**
   * Test {@link FieldMetadata#getChildrenExcluded()}.
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#getChildrenExcluded()}
   */
  @Test
  public void testGetChildrenExcluded_givenAdornedTargetCollectionMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getChildrenExcluded());
  }

  /**
   * Test {@link FieldMetadata#getChildrenExcluded()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#getChildrenExcluded()}
   */
  @Test
  public void testGetChildrenExcluded_thenReturnFalse() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setChildrenExcluded(false);

    // Act and Assert
    assertFalse(adornedTargetCollectionMetadata.getChildrenExcluded());
  }

  /**
   * Test {@link FieldMetadata#getChildrenExcluded()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#getChildrenExcluded()}
   */
  @Test
  public void testGetChildrenExcluded_thenReturnTrue() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setChildrenExcluded(true);

    // Act and Assert
    assertTrue(adornedTargetCollectionMetadata.getChildrenExcluded());
  }

  /**
   * Test {@link FieldMetadata#setChildrenExcluded(Boolean)}.
   * <p>
   * Method under test: {@link FieldMetadata#setChildrenExcluded(Boolean)}
   */
  @Test
  public void testSetChildrenExcluded() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();

    // Act
    adornedTargetCollectionMetadata.setChildrenExcluded(true);

    // Assert
    assertTrue(adornedTargetCollectionMetadata.getChildrenExcluded());
  }

  /**
   * Test {@link FieldMetadata#getTab()}.
   * <p>
   * Method under test: {@link FieldMetadata#getTab()}
   */
  @Test
  public void testGetTab() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getTab());
  }

  /**
   * Test {@link FieldMetadata#setTab(String)}.
   * <p>
   * Method under test: {@link FieldMetadata#setTab(String)}
   */
  @Test
  public void testSetTab() {
    // Arrange and Act
    fieldMetadata.setTab("Tab");

    // Assert
    assertTrue(fieldMetadata instanceof AdornedTargetCollectionMetadata);
    assertEquals("Tab", fieldMetadata.getTab());
  }

  /**
   * Test {@link FieldMetadata#getTabOrder()}.
   * <p>
   * Method under test: {@link FieldMetadata#getTabOrder()}
   */
  @Test
  public void testGetTabOrder() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getTabOrder());
  }

  /**
   * Test {@link FieldMetadata#setTabOrder(Integer)}.
   * <p>
   * Method under test: {@link FieldMetadata#setTabOrder(Integer)}
   */
  @Test
  public void testSetTabOrder() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();

    // Act
    adornedTargetCollectionMetadata.setTabOrder(1);

    // Assert
    assertEquals(1, adornedTargetCollectionMetadata.getTabOrder().intValue());
  }

  /**
   * Test {@link FieldMetadata#getGroup()}.
   * <p>
   * Method under test: {@link FieldMetadata#getGroup()}
   */
  @Test
  public void testGetGroup() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getGroup());
  }

  /**
   * Test {@link FieldMetadata#setGroup(String)}.
   * <p>
   * Method under test: {@link FieldMetadata#setGroup(String)}
   */
  @Test
  public void testSetGroup() {
    // Arrange and Act
    fieldMetadata.setGroup("Group");

    // Assert
    assertTrue(fieldMetadata instanceof AdornedTargetCollectionMetadata);
    assertEquals("Group", fieldMetadata.getGroup());
  }

  /**
   * Test {@link FieldMetadata#getGroupOrder()}.
   * <p>
   * Method under test: {@link FieldMetadata#getGroupOrder()}
   */
  @Test
  public void testGetGroupOrder() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getGroupOrder());
  }

  /**
   * Test {@link FieldMetadata#setGroupOrder(Integer)}.
   * <p>
   * Method under test: {@link FieldMetadata#setGroupOrder(Integer)}
   */
  @Test
  public void testSetGroupOrder() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();

    // Act
    adornedTargetCollectionMetadata.setGroupOrder(1);

    // Assert
    assertEquals(1, adornedTargetCollectionMetadata.getGroupOrder().intValue());
  }

  /**
   * Test {@link FieldMetadata#getLazyFetch()}.
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#getLazyFetch()}
   */
  @Test
  public void testGetLazyFetch_givenAdornedTargetCollectionMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getLazyFetch());
  }

  /**
   * Test {@link FieldMetadata#getLazyFetch()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#getLazyFetch()}
   */
  @Test
  public void testGetLazyFetch_thenReturnFalse() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setLazyFetch(false);

    // Act and Assert
    assertFalse(adornedTargetCollectionMetadata.getLazyFetch());
  }

  /**
   * Test {@link FieldMetadata#getLazyFetch()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#getLazyFetch()}
   */
  @Test
  public void testGetLazyFetch_thenReturnTrue() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setLazyFetch(true);

    // Act and Assert
    assertTrue(adornedTargetCollectionMetadata.getLazyFetch());
  }

  /**
   * Test {@link FieldMetadata#setLazyFetch(Boolean)}.
   * <p>
   * Method under test: {@link FieldMetadata#setLazyFetch(Boolean)}
   */
  @Test
  public void testSetLazyFetch() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();

    // Act
    adornedTargetCollectionMetadata.setLazyFetch(true);

    // Assert
    assertTrue(adornedTargetCollectionMetadata.getLazyFetch());
  }

  /**
   * Test {@link FieldMetadata#getManualFetch()}.
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#getManualFetch()}
   */
  @Test
  public void testGetManualFetch_givenAdornedTargetCollectionMetadata_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AdornedTargetCollectionMetadata()).getManualFetch());
  }

  /**
   * Test {@link FieldMetadata#getManualFetch()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#getManualFetch()}
   */
  @Test
  public void testGetManualFetch_thenReturnTrue() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setManualFetch(true);

    // Act and Assert
    assertTrue(adornedTargetCollectionMetadata.getManualFetch());
  }

  /**
   * Test {@link FieldMetadata#setManualFetch(boolean)}.
   * <p>
   * Method under test: {@link FieldMetadata#setManualFetch(boolean)}
   */
  @Test
  public void testSetManualFetch() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();

    // Act
    adornedTargetCollectionMetadata.setManualFetch(true);

    // Assert
    assertTrue(adornedTargetCollectionMetadata.getManualFetch());
  }

  /**
   * Test {@link FieldMetadata#equals(Object)}, and
   * {@link FieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertEquals(adornedTargetCollectionMetadata, adornedTargetCollectionMetadata2);
    int expectedHashCodeResult = adornedTargetCollectionMetadata.hashCode();
    assertEquals(expectedHashCodeResult, adornedTargetCollectionMetadata2.hashCode());
  }

  /**
   * Test {@link FieldMetadata#equals(Object)}, and
   * {@link FieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertEquals(adornedTargetCollectionMetadata, adornedTargetCollectionMetadata);
    int expectedHashCodeResult = adornedTargetCollectionMetadata.hashCode();
    assertEquals(expectedHashCodeResult, adornedTargetCollectionMetadata.hashCode());
  }

  /**
   * Test {@link FieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdornedTargetCollectionMetadata(), 1);
    assertNotEquals(new AdornedTargetCollectionMetadata(), mock(AdornedTargetCollectionMetadata.class));
  }

  /**
   * Test {@link FieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdornedTargetCollectionMetadata(), null);
  }

  /**
   * Test {@link FieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdornedTargetCollectionMetadata(), "Different type to FieldMetadata");
  }
}
