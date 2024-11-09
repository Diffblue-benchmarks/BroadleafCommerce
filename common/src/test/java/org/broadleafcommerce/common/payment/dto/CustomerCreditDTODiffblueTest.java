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
package org.broadleafcommerce.common.payment.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CustomerCreditDTO.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CustomerCreditDTODiffblueTest {
  @Autowired
  private CustomerCreditDTO<Object> customerCreditDTO;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerCreditDTO#CustomerCreditDTO()}
   *   <li>{@link CustomerCreditDTO#customerCreditAccountMasked(String)}
   *   <li>{@link CustomerCreditDTO#customerCreditAccountNum(String)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CustomerCreditDTO<Object> actualCustomerCreditDTO = new CustomerCreditDTO<>();
    CustomerCreditDTO<Object> actualCustomerCreditAccountMaskedResult = actualCustomerCreditDTO
        .customerCreditAccountMasked("3");
    CustomerCreditDTO<Object> actualCustomerCreditAccountNumResult = actualCustomerCreditDTO
        .customerCreditAccountNum("3");

    // Assert
    assertTrue(actualCustomerCreditDTO.additionalFields.isEmpty());
    assertSame(actualCustomerCreditDTO, actualCustomerCreditAccountMaskedResult);
    assertSame(actualCustomerCreditDTO, actualCustomerCreditAccountNumResult);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerCreditDTO#CustomerCreditDTO(Object)}
   *   <li>{@link CustomerCreditDTO#customerCreditAccountMasked(String)}
   *   <li>{@link CustomerCreditDTO#customerCreditAccountNum(String)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenNull_field() {
    // Arrange and Act
    CustomerCreditDTO<Object> actualCustomerCreditDTO = new CustomerCreditDTO<>(BLCFieldUtils.NULL_FIELD);
    CustomerCreditDTO<Object> actualCustomerCreditAccountMaskedResult = actualCustomerCreditDTO
        .customerCreditAccountMasked("3");
    CustomerCreditDTO<Object> actualCustomerCreditAccountNumResult = actualCustomerCreditDTO
        .customerCreditAccountNum("3");

    // Assert
    assertTrue(actualCustomerCreditDTO.additionalFields.isEmpty());
    assertSame(actualCustomerCreditDTO, actualCustomerCreditAccountMaskedResult);
    assertSame(actualCustomerCreditDTO, actualCustomerCreditAccountNumResult);
  }

  /**
   * Test {@link CustomerCreditDTO#done()}.
   * <p>
   * Method under test: {@link CustomerCreditDTO#done()}
   */
  @Test
  public void testDone() {
    // Arrange
    CustomerCreditDTO<Object> customerCreditDTO = new CustomerCreditDTO<>();

    // Act and Assert
    assertNull(customerCreditDTO.done());
  }

  /**
   * Test {@link CustomerCreditDTO#additionalFields(String, Object)}.
   * <p>
   * Method under test: {@link CustomerCreditDTO#additionalFields(String, Object)}
   */
  @Test
  public void testAdditionalFields() {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    CustomerCreditDTO<Object> actualAdditionalFieldsResult = customerCreditDTO.additionalFields("Key", object);

    // Assert
    Map<String, Object> stringObjectMap = customerCreditDTO.additionalFields;
    assertEquals(1, stringObjectMap.size());
    assertSame(customerCreditDTO, actualAdditionalFieldsResult);
    assertSame(object, stringObjectMap.get("Key"));
  }
}
