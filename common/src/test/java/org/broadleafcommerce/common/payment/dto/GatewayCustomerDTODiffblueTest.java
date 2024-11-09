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
import static org.junit.Assert.assertFalse;
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

@ContextConfiguration(classes = {GatewayCustomerDTO.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class GatewayCustomerDTODiffblueTest {
  @Autowired
  private GatewayCustomerDTO<Object> gatewayCustomerDTO;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayCustomerDTO#GatewayCustomerDTO()}
   *   <li>{@link GatewayCustomerDTO#companyName(String)}
   *   <li>{@link GatewayCustomerDTO#customerId(String)}
   *   <li>{@link GatewayCustomerDTO#email(String)}
   *   <li>{@link GatewayCustomerDTO#fax(String)}
   *   <li>{@link GatewayCustomerDTO#firstName(String)}
   *   <li>{@link GatewayCustomerDTO#lastName(String)}
   *   <li>{@link GatewayCustomerDTO#mobile(String)}
   *   <li>{@link GatewayCustomerDTO#phone(String)}
   *   <li>{@link GatewayCustomerDTO#website(String)}
   *   <li>{@link GatewayCustomerDTO#getAdditionalFields()}
   *   <li>{@link GatewayCustomerDTO#getCompanyName()}
   *   <li>{@link GatewayCustomerDTO#getCustomerId()}
   *   <li>{@link GatewayCustomerDTO#getEmail()}
   *   <li>{@link GatewayCustomerDTO#getFax()}
   *   <li>{@link GatewayCustomerDTO#getFirstName()}
   *   <li>{@link GatewayCustomerDTO#getLastName()}
   *   <li>{@link GatewayCustomerDTO#getMobile()}
   *   <li>{@link GatewayCustomerDTO#getPhone()}
   *   <li>{@link GatewayCustomerDTO#getWebsite()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    GatewayCustomerDTO<Object> actualGatewayCustomerDTO = new GatewayCustomerDTO<>();
    GatewayCustomerDTO<Object> actualCompanyNameResult = actualGatewayCustomerDTO.companyName("Company Name");
    GatewayCustomerDTO<Object> actualCustomerIdResult = actualGatewayCustomerDTO.customerId("42");
    GatewayCustomerDTO<Object> actualEmailResult = actualGatewayCustomerDTO.email("jane.doe@example.org");
    GatewayCustomerDTO<Object> actualFaxResult = actualGatewayCustomerDTO.fax("Fax");
    GatewayCustomerDTO<Object> actualFirstNameResult = actualGatewayCustomerDTO.firstName("Jane");
    GatewayCustomerDTO<Object> actualLastNameResult = actualGatewayCustomerDTO.lastName("Doe");
    GatewayCustomerDTO<Object> actualMobileResult = actualGatewayCustomerDTO.mobile("Mobile");
    GatewayCustomerDTO<Object> actualPhoneResult = actualGatewayCustomerDTO.phone("6625550144");
    GatewayCustomerDTO<Object> actualWebsiteResult = actualGatewayCustomerDTO.website("Website");
    Map<String, Object> actualAdditionalFields = actualGatewayCustomerDTO.getAdditionalFields();
    String actualCompanyName = actualGatewayCustomerDTO.getCompanyName();
    String actualCustomerId = actualGatewayCustomerDTO.getCustomerId();
    String actualEmail = actualGatewayCustomerDTO.getEmail();
    String actualFax = actualGatewayCustomerDTO.getFax();
    String actualFirstName = actualGatewayCustomerDTO.getFirstName();
    String actualLastName = actualGatewayCustomerDTO.getLastName();
    String actualMobile = actualGatewayCustomerDTO.getMobile();
    String actualPhone = actualGatewayCustomerDTO.getPhone();

    // Assert
    assertEquals("42", actualCustomerId);
    assertEquals("6625550144", actualPhone);
    assertEquals("Company Name", actualCompanyName);
    assertEquals("Doe", actualLastName);
    assertEquals("Fax", actualFax);
    assertEquals("Jane", actualFirstName);
    assertEquals("Mobile", actualMobile);
    assertEquals("Website", actualGatewayCustomerDTO.getWebsite());
    assertEquals("jane.doe@example.org", actualEmail);
    assertTrue(actualAdditionalFields.isEmpty());
    assertSame(actualGatewayCustomerDTO, actualCompanyNameResult);
    assertSame(actualGatewayCustomerDTO, actualCustomerIdResult);
    assertSame(actualGatewayCustomerDTO, actualEmailResult);
    assertSame(actualGatewayCustomerDTO, actualFaxResult);
    assertSame(actualGatewayCustomerDTO, actualFirstNameResult);
    assertSame(actualGatewayCustomerDTO, actualLastNameResult);
    assertSame(actualGatewayCustomerDTO, actualMobileResult);
    assertSame(actualGatewayCustomerDTO, actualPhoneResult);
    assertSame(actualGatewayCustomerDTO, actualWebsiteResult);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayCustomerDTO#GatewayCustomerDTO(Object)}
   *   <li>{@link GatewayCustomerDTO#companyName(String)}
   *   <li>{@link GatewayCustomerDTO#customerId(String)}
   *   <li>{@link GatewayCustomerDTO#email(String)}
   *   <li>{@link GatewayCustomerDTO#fax(String)}
   *   <li>{@link GatewayCustomerDTO#firstName(String)}
   *   <li>{@link GatewayCustomerDTO#lastName(String)}
   *   <li>{@link GatewayCustomerDTO#mobile(String)}
   *   <li>{@link GatewayCustomerDTO#phone(String)}
   *   <li>{@link GatewayCustomerDTO#website(String)}
   *   <li>{@link GatewayCustomerDTO#getAdditionalFields()}
   *   <li>{@link GatewayCustomerDTO#getCompanyName()}
   *   <li>{@link GatewayCustomerDTO#getCustomerId()}
   *   <li>{@link GatewayCustomerDTO#getEmail()}
   *   <li>{@link GatewayCustomerDTO#getFax()}
   *   <li>{@link GatewayCustomerDTO#getFirstName()}
   *   <li>{@link GatewayCustomerDTO#getLastName()}
   *   <li>{@link GatewayCustomerDTO#getMobile()}
   *   <li>{@link GatewayCustomerDTO#getPhone()}
   *   <li>{@link GatewayCustomerDTO#getWebsite()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenNull_field() {
    // Arrange and Act
    GatewayCustomerDTO<Object> actualGatewayCustomerDTO = new GatewayCustomerDTO<>(BLCFieldUtils.NULL_FIELD);
    GatewayCustomerDTO<Object> actualCompanyNameResult = actualGatewayCustomerDTO.companyName("Company Name");
    GatewayCustomerDTO<Object> actualCustomerIdResult = actualGatewayCustomerDTO.customerId("42");
    GatewayCustomerDTO<Object> actualEmailResult = actualGatewayCustomerDTO.email("jane.doe@example.org");
    GatewayCustomerDTO<Object> actualFaxResult = actualGatewayCustomerDTO.fax("Fax");
    GatewayCustomerDTO<Object> actualFirstNameResult = actualGatewayCustomerDTO.firstName("Jane");
    GatewayCustomerDTO<Object> actualLastNameResult = actualGatewayCustomerDTO.lastName("Doe");
    GatewayCustomerDTO<Object> actualMobileResult = actualGatewayCustomerDTO.mobile("Mobile");
    GatewayCustomerDTO<Object> actualPhoneResult = actualGatewayCustomerDTO.phone("6625550144");
    GatewayCustomerDTO<Object> actualWebsiteResult = actualGatewayCustomerDTO.website("Website");
    Map<String, Object> actualAdditionalFields = actualGatewayCustomerDTO.getAdditionalFields();
    String actualCompanyName = actualGatewayCustomerDTO.getCompanyName();
    String actualCustomerId = actualGatewayCustomerDTO.getCustomerId();
    String actualEmail = actualGatewayCustomerDTO.getEmail();
    String actualFax = actualGatewayCustomerDTO.getFax();
    String actualFirstName = actualGatewayCustomerDTO.getFirstName();
    String actualLastName = actualGatewayCustomerDTO.getLastName();
    String actualMobile = actualGatewayCustomerDTO.getMobile();
    String actualPhone = actualGatewayCustomerDTO.getPhone();

    // Assert
    assertEquals("42", actualCustomerId);
    assertEquals("6625550144", actualPhone);
    assertEquals("Company Name", actualCompanyName);
    assertEquals("Doe", actualLastName);
    assertEquals("Fax", actualFax);
    assertEquals("Jane", actualFirstName);
    assertEquals("Mobile", actualMobile);
    assertEquals("Website", actualGatewayCustomerDTO.getWebsite());
    assertEquals("jane.doe@example.org", actualEmail);
    assertTrue(actualAdditionalFields.isEmpty());
    assertSame(actualGatewayCustomerDTO, actualCompanyNameResult);
    assertSame(actualGatewayCustomerDTO, actualCustomerIdResult);
    assertSame(actualGatewayCustomerDTO, actualEmailResult);
    assertSame(actualGatewayCustomerDTO, actualFaxResult);
    assertSame(actualGatewayCustomerDTO, actualFirstNameResult);
    assertSame(actualGatewayCustomerDTO, actualLastNameResult);
    assertSame(actualGatewayCustomerDTO, actualMobileResult);
    assertSame(actualGatewayCustomerDTO, actualPhoneResult);
    assertSame(actualGatewayCustomerDTO, actualWebsiteResult);
  }

  /**
   * Test {@link GatewayCustomerDTO#done()}.
   * <p>
   * Method under test: {@link GatewayCustomerDTO#done()}
   */
  @Test
  public void testDone() {
    // Arrange
    GatewayCustomerDTO<Object> gatewayCustomerDTO = new GatewayCustomerDTO<>();

    // Act and Assert
    assertNull(gatewayCustomerDTO.done());
  }

  /**
   * Test {@link GatewayCustomerDTO#additionalFields(String, Object)}.
   * <p>
   * Method under test:
   * {@link GatewayCustomerDTO#additionalFields(String, Object)}
   */
  @Test
  public void testAdditionalFields() {
    // Arrange, Act and Assert
    assertSame(gatewayCustomerDTO, gatewayCustomerDTO.additionalFields("Key", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link GatewayCustomerDTO#customerPopulated()}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()} additionalFields
   * {@code Key} and {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayCustomerDTO#customerPopulated()}
   */
  @Test
  public void testCustomerPopulated_givenGatewayCustomerDTOAdditionalFieldsKeyAndNull_field() {
    // Arrange
    GatewayCustomerDTO<Object> gatewayCustomerDTO = new GatewayCustomerDTO<>();
    gatewayCustomerDTO.additionalFields("Key", BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertTrue(gatewayCustomerDTO.customerPopulated());
  }

  /**
   * Test {@link GatewayCustomerDTO#customerPopulated()}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()} companyName
   * {@code Company Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayCustomerDTO#customerPopulated()}
   */
  @Test
  public void testCustomerPopulated_givenGatewayCustomerDTOCompanyNameCompanyName() {
    // Arrange
    GatewayCustomerDTO<Object> gatewayCustomerDTO = new GatewayCustomerDTO<>();
    gatewayCustomerDTO.companyName("Company Name");

    // Act and Assert
    assertTrue(gatewayCustomerDTO.customerPopulated());
  }

  /**
   * Test {@link GatewayCustomerDTO#customerPopulated()}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()} customerId
   * {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayCustomerDTO#customerPopulated()}
   */
  @Test
  public void testCustomerPopulated_givenGatewayCustomerDTOCustomerId42_thenReturnTrue() {
    // Arrange
    GatewayCustomerDTO<Object> gatewayCustomerDTO = new GatewayCustomerDTO<>();
    gatewayCustomerDTO.customerId("42");

    // Act and Assert
    assertTrue(gatewayCustomerDTO.customerPopulated());
  }

  /**
   * Test {@link GatewayCustomerDTO#customerPopulated()}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()} email
   * {@code jane.doe@example.org}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayCustomerDTO#customerPopulated()}
   */
  @Test
  public void testCustomerPopulated_givenGatewayCustomerDTOEmailJaneDoeExampleOrg() {
    // Arrange
    GatewayCustomerDTO<Object> gatewayCustomerDTO = new GatewayCustomerDTO<>();
    gatewayCustomerDTO.email("jane.doe@example.org");

    // Act and Assert
    assertTrue(gatewayCustomerDTO.customerPopulated());
  }

  /**
   * Test {@link GatewayCustomerDTO#customerPopulated()}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()} fax
   * {@code Fax}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayCustomerDTO#customerPopulated()}
   */
  @Test
  public void testCustomerPopulated_givenGatewayCustomerDTOFaxFax_thenReturnTrue() {
    // Arrange
    GatewayCustomerDTO<Object> gatewayCustomerDTO = new GatewayCustomerDTO<>();
    gatewayCustomerDTO.fax("Fax");

    // Act and Assert
    assertTrue(gatewayCustomerDTO.customerPopulated());
  }

  /**
   * Test {@link GatewayCustomerDTO#customerPopulated()}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()} firstName
   * {@code Jane}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayCustomerDTO#customerPopulated()}
   */
  @Test
  public void testCustomerPopulated_givenGatewayCustomerDTOFirstNameJane_thenReturnTrue() {
    // Arrange
    GatewayCustomerDTO<Object> gatewayCustomerDTO = new GatewayCustomerDTO<>();
    gatewayCustomerDTO.firstName("Jane");

    // Act and Assert
    assertTrue(gatewayCustomerDTO.customerPopulated());
  }

  /**
   * Test {@link GatewayCustomerDTO#customerPopulated()}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()} lastName
   * {@code Doe}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayCustomerDTO#customerPopulated()}
   */
  @Test
  public void testCustomerPopulated_givenGatewayCustomerDTOLastNameDoe_thenReturnTrue() {
    // Arrange
    GatewayCustomerDTO<Object> gatewayCustomerDTO = new GatewayCustomerDTO<>();
    gatewayCustomerDTO.lastName("Doe");

    // Act and Assert
    assertTrue(gatewayCustomerDTO.customerPopulated());
  }

  /**
   * Test {@link GatewayCustomerDTO#customerPopulated()}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()} mobile
   * {@code Mobile}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayCustomerDTO#customerPopulated()}
   */
  @Test
  public void testCustomerPopulated_givenGatewayCustomerDTOMobileMobile_thenReturnTrue() {
    // Arrange
    GatewayCustomerDTO<Object> gatewayCustomerDTO = new GatewayCustomerDTO<>();
    gatewayCustomerDTO.mobile("Mobile");

    // Act and Assert
    assertTrue(gatewayCustomerDTO.customerPopulated());
  }

  /**
   * Test {@link GatewayCustomerDTO#customerPopulated()}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()} phone
   * {@code 6625550144}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayCustomerDTO#customerPopulated()}
   */
  @Test
  public void testCustomerPopulated_givenGatewayCustomerDTOPhone6625550144_thenReturnTrue() {
    // Arrange
    GatewayCustomerDTO<Object> gatewayCustomerDTO = new GatewayCustomerDTO<>();
    gatewayCustomerDTO.phone("6625550144");

    // Act and Assert
    assertTrue(gatewayCustomerDTO.customerPopulated());
  }

  /**
   * Test {@link GatewayCustomerDTO#customerPopulated()}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()} website
   * {@code Website}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayCustomerDTO#customerPopulated()}
   */
  @Test
  public void testCustomerPopulated_givenGatewayCustomerDTOWebsiteWebsite_thenReturnTrue() {
    // Arrange
    GatewayCustomerDTO<Object> gatewayCustomerDTO = new GatewayCustomerDTO<>();
    gatewayCustomerDTO.website("Website");

    // Act and Assert
    assertTrue(gatewayCustomerDTO.customerPopulated());
  }

  /**
   * Test {@link GatewayCustomerDTO#customerPopulated()}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayCustomerDTO#customerPopulated()}
   */
  @Test
  public void testCustomerPopulated_givenGatewayCustomerDTO_thenReturnFalse() {
    // Arrange
    GatewayCustomerDTO<Object> gatewayCustomerDTO = new GatewayCustomerDTO<>();

    // Act and Assert
    assertFalse(gatewayCustomerDTO.customerPopulated());
  }
}
