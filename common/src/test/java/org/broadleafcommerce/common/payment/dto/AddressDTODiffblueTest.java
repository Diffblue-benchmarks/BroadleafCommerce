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

@ContextConfiguration(classes = {AddressDTO.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AddressDTODiffblueTest {
  @Autowired
  private AddressDTO<Object> addressDTO;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AddressDTO#AddressDTO()}
   *   <li>{@link AddressDTO#addressCityLocality(String)}
   *   <li>{@link AddressDTO#addressCompanyName(String)}
   *   <li>{@link AddressDTO#addressCountryCode(String)}
   *   <li>{@link AddressDTO#addressCounty(String)}
   *   <li>{@link AddressDTO#addressEmail(String)}
   *   <li>{@link AddressDTO#addressFirstName(String)}
   *   <li>{@link AddressDTO#addressFullName(String)}
   *   <li>{@link AddressDTO#addressLastName(String)}
   *   <li>{@link AddressDTO#addressLine1(String)}
   *   <li>{@link AddressDTO#addressLine2(String)}
   *   <li>{@link AddressDTO#addressPhone(String)}
   *   <li>{@link AddressDTO#addressPostalCode(String)}
   *   <li>{@link AddressDTO#addressStateRegion(String)}
   *   <li>{@link AddressDTO#getAdditionalFields()}
   *   <li>{@link AddressDTO#getAddressCityLocality()}
   *   <li>{@link AddressDTO#getAddressCompanyName()}
   *   <li>{@link AddressDTO#getAddressCountryCode()}
   *   <li>{@link AddressDTO#getAddressEmail()}
   *   <li>{@link AddressDTO#getAddressFirstName()}
   *   <li>{@link AddressDTO#getAddressFullName()}
   *   <li>{@link AddressDTO#getAddressLastName()}
   *   <li>{@link AddressDTO#getAddressLine1()}
   *   <li>{@link AddressDTO#getAddressLine2()}
   *   <li>{@link AddressDTO#getAddressPhone()}
   *   <li>{@link AddressDTO#getAddressPostalCode()}
   *   <li>{@link AddressDTO#getAddressStateRegion()}
   *   <li>{@link AddressDTO#getCounty()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AddressDTO<Object> actualAddressDTO = new AddressDTO<>();
    AddressDTO<Object> actualAddressCityLocalityResult = actualAddressDTO.addressCityLocality("42 Main St");
    AddressDTO<Object> actualAddressCompanyNameResult = actualAddressDTO.addressCompanyName("42 Main St");
    AddressDTO<Object> actualAddressCountryCodeResult = actualAddressDTO.addressCountryCode("42 Main St");
    AddressDTO<Object> actualAddressCountyResult = actualAddressDTO.addressCounty("3");
    AddressDTO<Object> actualAddressEmailResult = actualAddressDTO.addressEmail("42 Main St");
    AddressDTO<Object> actualAddressFirstNameResult = actualAddressDTO.addressFirstName("Jane");
    AddressDTO<Object> actualAddressFullNameResult = actualAddressDTO.addressFullName("Dr Jane Doe");
    AddressDTO<Object> actualAddressLastNameResult = actualAddressDTO.addressLastName("Doe");
    AddressDTO<Object> actualAddressLine1Result = actualAddressDTO.addressLine1("42 Main St");
    AddressDTO<Object> actualAddressLine2Result = actualAddressDTO.addressLine2("42 Main St");
    AddressDTO<Object> actualAddressPhoneResult = actualAddressDTO.addressPhone("6625550144");
    AddressDTO<Object> actualAddressPostalCodeResult = actualAddressDTO.addressPostalCode("42 Main St");
    AddressDTO<Object> actualAddressStateRegionResult = actualAddressDTO.addressStateRegion("us-east-2");
    Map<String, Object> actualAdditionalFields = actualAddressDTO.getAdditionalFields();
    String actualAddressCityLocality = actualAddressDTO.getAddressCityLocality();
    String actualAddressCompanyName = actualAddressDTO.getAddressCompanyName();
    String actualAddressCountryCode = actualAddressDTO.getAddressCountryCode();
    String actualAddressEmail = actualAddressDTO.getAddressEmail();
    String actualAddressFirstName = actualAddressDTO.getAddressFirstName();
    String actualAddressFullName = actualAddressDTO.getAddressFullName();
    String actualAddressLastName = actualAddressDTO.getAddressLastName();
    String actualAddressLine1 = actualAddressDTO.getAddressLine1();
    String actualAddressLine2 = actualAddressDTO.getAddressLine2();
    String actualAddressPhone = actualAddressDTO.getAddressPhone();
    String actualAddressPostalCode = actualAddressDTO.getAddressPostalCode();
    String actualAddressStateRegion = actualAddressDTO.getAddressStateRegion();

    // Assert
    assertEquals("3", actualAddressDTO.getCounty());
    assertEquals("42 Main St", actualAddressCityLocality);
    assertEquals("42 Main St", actualAddressCompanyName);
    assertEquals("42 Main St", actualAddressCountryCode);
    assertEquals("42 Main St", actualAddressEmail);
    assertEquals("42 Main St", actualAddressLine1);
    assertEquals("42 Main St", actualAddressLine2);
    assertEquals("42 Main St", actualAddressPostalCode);
    assertEquals("6625550144", actualAddressPhone);
    assertEquals("Doe", actualAddressLastName);
    assertEquals("Dr Jane Doe", actualAddressFullName);
    assertEquals("Jane", actualAddressFirstName);
    assertEquals("us-east-2", actualAddressStateRegion);
    assertTrue(actualAdditionalFields.isEmpty());
    assertSame(actualAddressDTO, actualAddressCityLocalityResult);
    assertSame(actualAddressDTO, actualAddressCompanyNameResult);
    assertSame(actualAddressDTO, actualAddressCountryCodeResult);
    assertSame(actualAddressDTO, actualAddressCountyResult);
    assertSame(actualAddressDTO, actualAddressEmailResult);
    assertSame(actualAddressDTO, actualAddressFirstNameResult);
    assertSame(actualAddressDTO, actualAddressFullNameResult);
    assertSame(actualAddressDTO, actualAddressLastNameResult);
    assertSame(actualAddressDTO, actualAddressLine1Result);
    assertSame(actualAddressDTO, actualAddressLine2Result);
    assertSame(actualAddressDTO, actualAddressPhoneResult);
    assertSame(actualAddressDTO, actualAddressPostalCodeResult);
    assertSame(actualAddressDTO, actualAddressStateRegionResult);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AddressDTO#AddressDTO(Object)}
   *   <li>{@link AddressDTO#addressCityLocality(String)}
   *   <li>{@link AddressDTO#addressCompanyName(String)}
   *   <li>{@link AddressDTO#addressCountryCode(String)}
   *   <li>{@link AddressDTO#addressCounty(String)}
   *   <li>{@link AddressDTO#addressEmail(String)}
   *   <li>{@link AddressDTO#addressFirstName(String)}
   *   <li>{@link AddressDTO#addressFullName(String)}
   *   <li>{@link AddressDTO#addressLastName(String)}
   *   <li>{@link AddressDTO#addressLine1(String)}
   *   <li>{@link AddressDTO#addressLine2(String)}
   *   <li>{@link AddressDTO#addressPhone(String)}
   *   <li>{@link AddressDTO#addressPostalCode(String)}
   *   <li>{@link AddressDTO#addressStateRegion(String)}
   *   <li>{@link AddressDTO#getAdditionalFields()}
   *   <li>{@link AddressDTO#getAddressCityLocality()}
   *   <li>{@link AddressDTO#getAddressCompanyName()}
   *   <li>{@link AddressDTO#getAddressCountryCode()}
   *   <li>{@link AddressDTO#getAddressEmail()}
   *   <li>{@link AddressDTO#getAddressFirstName()}
   *   <li>{@link AddressDTO#getAddressFullName()}
   *   <li>{@link AddressDTO#getAddressLastName()}
   *   <li>{@link AddressDTO#getAddressLine1()}
   *   <li>{@link AddressDTO#getAddressLine2()}
   *   <li>{@link AddressDTO#getAddressPhone()}
   *   <li>{@link AddressDTO#getAddressPostalCode()}
   *   <li>{@link AddressDTO#getAddressStateRegion()}
   *   <li>{@link AddressDTO#getCounty()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenNull_field() {
    // Arrange and Act
    AddressDTO<Object> actualAddressDTO = new AddressDTO<>(BLCFieldUtils.NULL_FIELD);
    AddressDTO<Object> actualAddressCityLocalityResult = actualAddressDTO.addressCityLocality("42 Main St");
    AddressDTO<Object> actualAddressCompanyNameResult = actualAddressDTO.addressCompanyName("42 Main St");
    AddressDTO<Object> actualAddressCountryCodeResult = actualAddressDTO.addressCountryCode("42 Main St");
    AddressDTO<Object> actualAddressCountyResult = actualAddressDTO.addressCounty("3");
    AddressDTO<Object> actualAddressEmailResult = actualAddressDTO.addressEmail("42 Main St");
    AddressDTO<Object> actualAddressFirstNameResult = actualAddressDTO.addressFirstName("Jane");
    AddressDTO<Object> actualAddressFullNameResult = actualAddressDTO.addressFullName("Dr Jane Doe");
    AddressDTO<Object> actualAddressLastNameResult = actualAddressDTO.addressLastName("Doe");
    AddressDTO<Object> actualAddressLine1Result = actualAddressDTO.addressLine1("42 Main St");
    AddressDTO<Object> actualAddressLine2Result = actualAddressDTO.addressLine2("42 Main St");
    AddressDTO<Object> actualAddressPhoneResult = actualAddressDTO.addressPhone("6625550144");
    AddressDTO<Object> actualAddressPostalCodeResult = actualAddressDTO.addressPostalCode("42 Main St");
    AddressDTO<Object> actualAddressStateRegionResult = actualAddressDTO.addressStateRegion("us-east-2");
    Map<String, Object> actualAdditionalFields = actualAddressDTO.getAdditionalFields();
    String actualAddressCityLocality = actualAddressDTO.getAddressCityLocality();
    String actualAddressCompanyName = actualAddressDTO.getAddressCompanyName();
    String actualAddressCountryCode = actualAddressDTO.getAddressCountryCode();
    String actualAddressEmail = actualAddressDTO.getAddressEmail();
    String actualAddressFirstName = actualAddressDTO.getAddressFirstName();
    String actualAddressFullName = actualAddressDTO.getAddressFullName();
    String actualAddressLastName = actualAddressDTO.getAddressLastName();
    String actualAddressLine1 = actualAddressDTO.getAddressLine1();
    String actualAddressLine2 = actualAddressDTO.getAddressLine2();
    String actualAddressPhone = actualAddressDTO.getAddressPhone();
    String actualAddressPostalCode = actualAddressDTO.getAddressPostalCode();
    String actualAddressStateRegion = actualAddressDTO.getAddressStateRegion();

    // Assert
    assertEquals("3", actualAddressDTO.getCounty());
    assertEquals("42 Main St", actualAddressCityLocality);
    assertEquals("42 Main St", actualAddressCompanyName);
    assertEquals("42 Main St", actualAddressCountryCode);
    assertEquals("42 Main St", actualAddressEmail);
    assertEquals("42 Main St", actualAddressLine1);
    assertEquals("42 Main St", actualAddressLine2);
    assertEquals("42 Main St", actualAddressPostalCode);
    assertEquals("6625550144", actualAddressPhone);
    assertEquals("Doe", actualAddressLastName);
    assertEquals("Dr Jane Doe", actualAddressFullName);
    assertEquals("Jane", actualAddressFirstName);
    assertEquals("us-east-2", actualAddressStateRegion);
    assertTrue(actualAdditionalFields.isEmpty());
    assertSame(actualAddressDTO, actualAddressCityLocalityResult);
    assertSame(actualAddressDTO, actualAddressCompanyNameResult);
    assertSame(actualAddressDTO, actualAddressCountryCodeResult);
    assertSame(actualAddressDTO, actualAddressCountyResult);
    assertSame(actualAddressDTO, actualAddressEmailResult);
    assertSame(actualAddressDTO, actualAddressFirstNameResult);
    assertSame(actualAddressDTO, actualAddressFullNameResult);
    assertSame(actualAddressDTO, actualAddressLastNameResult);
    assertSame(actualAddressDTO, actualAddressLine1Result);
    assertSame(actualAddressDTO, actualAddressLine2Result);
    assertSame(actualAddressDTO, actualAddressPhoneResult);
    assertSame(actualAddressDTO, actualAddressPostalCodeResult);
    assertSame(actualAddressDTO, actualAddressStateRegionResult);
  }

  /**
   * Test {@link AddressDTO#done()}.
   * <p>
   * Method under test: {@link AddressDTO#done()}
   */
  @Test
  public void testDone() {
    // Arrange
    AddressDTO<Object> addressDTO = new AddressDTO<>();

    // Act and Assert
    assertNull(addressDTO.done());
  }

  /**
   * Test {@link AddressDTO#additionalFields(String, Object)}.
   * <p>
   * Method under test: {@link AddressDTO#additionalFields(String, Object)}
   */
  @Test
  public void testAdditionalFields() {
    // Arrange, Act and Assert
    assertSame(addressDTO, addressDTO.additionalFields("Key", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link AddressDTO#addressPopulated()}.
   * <ul>
   *   <li>Given {@link AddressDTO#AddressDTO()} additionalFields {@code Key} and
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressDTO#addressPopulated()}
   */
  @Test
  public void testAddressPopulated_givenAddressDTOAdditionalFieldsKeyAndNull_field() {
    // Arrange
    AddressDTO<Object> addressDTO = new AddressDTO<>();
    addressDTO.additionalFields("Key", BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertTrue(addressDTO.addressPopulated());
  }

  /**
   * Test {@link AddressDTO#addressPopulated()}.
   * <ul>
   *   <li>Given {@link AddressDTO#AddressDTO()} addressCityLocality
   * {@code 42 Main St}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressDTO#addressPopulated()}
   */
  @Test
  public void testAddressPopulated_givenAddressDTOAddressCityLocality42MainSt_thenReturnTrue() {
    // Arrange
    AddressDTO<Object> addressDTO = new AddressDTO<>();
    addressDTO.addressCityLocality("42 Main St");

    // Act and Assert
    assertTrue(addressDTO.addressPopulated());
  }

  /**
   * Test {@link AddressDTO#addressPopulated()}.
   * <ul>
   *   <li>Given {@link AddressDTO#AddressDTO()} addressCompanyName
   * {@code 42 Main St}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressDTO#addressPopulated()}
   */
  @Test
  public void testAddressPopulated_givenAddressDTOAddressCompanyName42MainSt_thenReturnTrue() {
    // Arrange
    AddressDTO<Object> addressDTO = new AddressDTO<>();
    addressDTO.addressCompanyName("42 Main St");

    // Act and Assert
    assertTrue(addressDTO.addressPopulated());
  }

  /**
   * Test {@link AddressDTO#addressPopulated()}.
   * <ul>
   *   <li>Given {@link AddressDTO#AddressDTO()} addressCountryCode
   * {@code 42 Main St}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressDTO#addressPopulated()}
   */
  @Test
  public void testAddressPopulated_givenAddressDTOAddressCountryCode42MainSt_thenReturnTrue() {
    // Arrange
    AddressDTO<Object> addressDTO = new AddressDTO<>();
    addressDTO.addressCountryCode("42 Main St");

    // Act and Assert
    assertTrue(addressDTO.addressPopulated());
  }

  /**
   * Test {@link AddressDTO#addressPopulated()}.
   * <ul>
   *   <li>Given {@link AddressDTO#AddressDTO()} addressEmail
   * {@code 42 Main St}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressDTO#addressPopulated()}
   */
  @Test
  public void testAddressPopulated_givenAddressDTOAddressEmail42MainSt_thenReturnTrue() {
    // Arrange
    AddressDTO<Object> addressDTO = new AddressDTO<>();
    addressDTO.addressEmail("42 Main St");

    // Act and Assert
    assertTrue(addressDTO.addressPopulated());
  }

  /**
   * Test {@link AddressDTO#addressPopulated()}.
   * <ul>
   *   <li>Given {@link AddressDTO#AddressDTO()} addressFirstName {@code Jane}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressDTO#addressPopulated()}
   */
  @Test
  public void testAddressPopulated_givenAddressDTOAddressFirstNameJane_thenReturnTrue() {
    // Arrange
    AddressDTO<Object> addressDTO = new AddressDTO<>();
    addressDTO.addressFirstName("Jane");

    // Act and Assert
    assertTrue(addressDTO.addressPopulated());
  }

  /**
   * Test {@link AddressDTO#addressPopulated()}.
   * <ul>
   *   <li>Given {@link AddressDTO#AddressDTO()} addressLastName {@code Doe}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressDTO#addressPopulated()}
   */
  @Test
  public void testAddressPopulated_givenAddressDTOAddressLastNameDoe_thenReturnTrue() {
    // Arrange
    AddressDTO<Object> addressDTO = new AddressDTO<>();
    addressDTO.addressLastName("Doe");

    // Act and Assert
    assertTrue(addressDTO.addressPopulated());
  }

  /**
   * Test {@link AddressDTO#addressPopulated()}.
   * <ul>
   *   <li>Given {@link AddressDTO#AddressDTO()} addressLine1
   * {@code 42 Main St}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressDTO#addressPopulated()}
   */
  @Test
  public void testAddressPopulated_givenAddressDTOAddressLine142MainSt_thenReturnTrue() {
    // Arrange
    AddressDTO<Object> addressDTO = new AddressDTO<>();
    addressDTO.addressLine1("42 Main St");

    // Act and Assert
    assertTrue(addressDTO.addressPopulated());
  }

  /**
   * Test {@link AddressDTO#addressPopulated()}.
   * <ul>
   *   <li>Given {@link AddressDTO#AddressDTO()} addressLine2
   * {@code 42 Main St}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressDTO#addressPopulated()}
   */
  @Test
  public void testAddressPopulated_givenAddressDTOAddressLine242MainSt_thenReturnTrue() {
    // Arrange
    AddressDTO<Object> addressDTO = new AddressDTO<>();
    addressDTO.addressLine2("42 Main St");

    // Act and Assert
    assertTrue(addressDTO.addressPopulated());
  }

  /**
   * Test {@link AddressDTO#addressPopulated()}.
   * <ul>
   *   <li>Given {@link AddressDTO#AddressDTO()} addressPhone
   * {@code 6625550144}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressDTO#addressPopulated()}
   */
  @Test
  public void testAddressPopulated_givenAddressDTOAddressPhone6625550144_thenReturnTrue() {
    // Arrange
    AddressDTO<Object> addressDTO = new AddressDTO<>();
    addressDTO.addressPhone("6625550144");

    // Act and Assert
    assertTrue(addressDTO.addressPopulated());
  }

  /**
   * Test {@link AddressDTO#addressPopulated()}.
   * <ul>
   *   <li>Given {@link AddressDTO#AddressDTO()} addressPostalCode
   * {@code 42 Main St}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressDTO#addressPopulated()}
   */
  @Test
  public void testAddressPopulated_givenAddressDTOAddressPostalCode42MainSt_thenReturnTrue() {
    // Arrange
    AddressDTO<Object> addressDTO = new AddressDTO<>();
    addressDTO.addressPostalCode("42 Main St");

    // Act and Assert
    assertTrue(addressDTO.addressPopulated());
  }

  /**
   * Test {@link AddressDTO#addressPopulated()}.
   * <ul>
   *   <li>Given {@link AddressDTO#AddressDTO()} addressStateRegion
   * {@code us-east-2}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressDTO#addressPopulated()}
   */
  @Test
  public void testAddressPopulated_givenAddressDTOAddressStateRegionUsEast2_thenReturnTrue() {
    // Arrange
    AddressDTO<Object> addressDTO = new AddressDTO<>();
    addressDTO.addressStateRegion("us-east-2");

    // Act and Assert
    assertTrue(addressDTO.addressPopulated());
  }

  /**
   * Test {@link AddressDTO#addressPopulated()}.
   * <ul>
   *   <li>Given {@link AddressDTO#AddressDTO()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressDTO#addressPopulated()}
   */
  @Test
  public void testAddressPopulated_givenAddressDTO_thenReturnFalse() {
    // Arrange
    AddressDTO<Object> addressDTO = new AddressDTO<>();

    // Act and Assert
    assertFalse(addressDTO.addressPopulated());
  }
}
