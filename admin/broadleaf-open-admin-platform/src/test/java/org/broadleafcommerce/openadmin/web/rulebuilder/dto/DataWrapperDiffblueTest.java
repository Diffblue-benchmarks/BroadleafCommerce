/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.rulebuilder.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;

public class DataWrapperDiffblueTest {
  /**
   * Method under test: {@link DataWrapper#serialize()}
   */
  @Test
  public void testSerialize() throws IOException {
    // Arrange, Act and Assert
    assertEquals("{\"data\":[],\"error\":null,\"rawMvel\":null}", (new DataWrapper()).serialize());
  }

  /**
   * Method under test: {@link DataWrapper#serialize()}
   */
  @Test
  public void testSerialize2() throws IOException {
    // Arrange
    DataWrapper dataWrapper = new DataWrapper();
    dataWrapper.setData(new ArrayList<>());

    // Act and Assert
    assertEquals("{\"data\":[],\"error\":null,\"rawMvel\":null}", dataWrapper.serialize());
  }

  /**
   * Method under test: {@link DataWrapper#serialize()}
   */
  @Test
  public void testSerialize3() throws IOException {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("Condition");
    dataDTO.setContainedPk(1L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    ArrayList<DataDTO> data = new ArrayList<>();
    data.add(dataDTO);

    DataWrapper dataWrapper = new DataWrapper();
    dataWrapper.setData(data);

    // Act and Assert
    assertEquals(
        "{\"data\":[{\"pk\":1,\"containedPk\":1,\"previousPk\":1,\"previousContainedPk\":1,\"quantity\":1,\"condition\":"
            + "\"Condition\",\"createdFromSubGroup\":true,\"rules\":[]}],\"error\":null,\"rawMvel\":null}",
        dataWrapper.serialize());
  }

  /**
   * Method under test: {@link DataWrapper#serialize()}
   */
  @Test
  public void testSerialize4() throws IOException {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("Condition");
    dataDTO.setContainedPk(1L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    DataDTO dataDTO2 = new DataDTO();
    dataDTO2.setCondition("org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataDTO");
    dataDTO2.setContainedPk(1L);
    dataDTO2.setCreatedFromSubGroup(false);
    dataDTO2.setPk(1L);
    dataDTO2.setPreviousContainedPk(1L);
    dataDTO2.setPreviousPk(1L);
    dataDTO2.setQuantity(1);
    dataDTO2.setRules(new ArrayList<>());

    ArrayList<DataDTO> data = new ArrayList<>();
    data.add(dataDTO2);
    data.add(dataDTO);

    DataWrapper dataWrapper = new DataWrapper();
    dataWrapper.setData(data);

    // Act and Assert
    assertEquals(
        "{\"data\":[{\"pk\":1,\"containedPk\":1,\"previousPk\":1,\"previousContainedPk\":1,\"quantity\":1,\"condition\":\"org"
            + ".broadleafcommerce.openadmin.web.rulebuilder.dto.DataDTO\",\"createdFromSubGroup\":false,\"rules\":[]},{"
            + "\"pk\":1,\"containedPk\":1,\"previousPk\":1,\"previousContainedPk\":1,\"quantity\":1,\"condition\":\"Condition\","
            + "\"createdFromSubGroup\":true,\"rules\":[]}],\"error\":null,\"rawMvel\":null}",
        dataWrapper.serialize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataWrapper#equals(Object)}
   *   <li>{@link DataWrapper#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DataWrapper dataWrapper = new DataWrapper();
    DataWrapper dataWrapper2 = new DataWrapper();

    // Act and Assert
    assertEquals(dataWrapper, dataWrapper2);
    int expectedHashCodeResult = dataWrapper.hashCode();
    assertEquals(expectedHashCodeResult, dataWrapper2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataWrapper#equals(Object)}
   *   <li>{@link DataWrapper#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DataWrapper dataWrapper = new DataWrapper();

    // Act and Assert
    assertEquals(dataWrapper, dataWrapper);
    int expectedHashCodeResult = dataWrapper.hashCode();
    assertEquals(expectedHashCodeResult, dataWrapper.hashCode());
  }

  /**
   * Method under test: {@link DataWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DataWrapper dataWrapper = new DataWrapper();
    dataWrapper.setError("An error occurred");

    // Act and Assert
    assertNotEquals(dataWrapper, new DataWrapper());
  }

  /**
   * Method under test: {@link DataWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DataWrapper(), null);
  }

  /**
   * Method under test: {@link DataWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DataWrapper(), "Different type to DataWrapper");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DataWrapper}
   *   <li>{@link DataWrapper#setData(ArrayList)}
   *   <li>{@link DataWrapper#setError(String)}
   *   <li>{@link DataWrapper#setRawMvel(String)}
   *   <li>{@link DataWrapper#getData()}
   *   <li>{@link DataWrapper#getError()}
   *   <li>{@link DataWrapper#getRawMvel()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DataWrapper actualDataWrapper = new DataWrapper();
    ArrayList<DataDTO> data = new ArrayList<>();
    actualDataWrapper.setData(data);
    actualDataWrapper.setError("An error occurred");
    actualDataWrapper.setRawMvel("Raw Mvel");
    ArrayList<DataDTO> actualData = actualDataWrapper.getData();
    String actualError = actualDataWrapper.getError();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualError);
    assertEquals("Raw Mvel", actualDataWrapper.getRawMvel());
    assertSame(data, actualData);
  }
}
