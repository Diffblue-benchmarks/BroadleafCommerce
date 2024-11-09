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
package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.AddSearchMappingRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.mockito.Mockito;

public class BasicFieldPersistenceProviderDiffblueTest {
  /**
   * Test
   * {@link BasicFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testCanHandlePersistence_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddSearchMappingRequest addSearchMappingRequest = mock(AddSearchMappingRequest.class);
    when(addSearchMappingRequest.getPropertyName()).thenReturn("Property Name");
    when(addSearchMappingRequest.getMergedProperties()).thenReturn(new HashMap<>());

    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    basicFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, new ArrayList<>());
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    boolean actualCanHandlePersistenceResult = basicFieldPersistenceProvider.canHandlePersistence(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(addSearchMappingRequest).getMergedProperties();
    verify(addSearchMappingRequest).getPropertyName();
    assertFalse(actualCanHandlePersistenceResult);
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#ADDITIONAL_FOREIGN_KEY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType_givenAdditional_foreign_key() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.ADDITIONAL_FOREIGN_KEY);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#ASSET_URL}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is
   * {@link SupportedFieldType#ASSET_URL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType_givenAsset_url_whenBasicFieldMetadataFieldTypeIsAsset_url() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.ASSET_URL);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#BOOLEAN}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is
   * {@link SupportedFieldType#BOOLEAN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType_givenBoolean_whenBasicFieldMetadataFieldTypeIsBoolean() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.BOOLEAN);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#CODE}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is
   * {@link SupportedFieldType#CODE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType_givenCode_whenBasicFieldMetadataFieldTypeIsCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.CODE);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@code ---}.</li>
   *   <li>When {@link Property#Property()} Name is {@code ---}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType_givenDashDashDash_whenPropertyNameIsDashDashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.BOOLEAN);

    Property property = new Property();
    property.setName("---");

    // Act and Assert
    assertFalse(basicFieldPersistenceProvider.detectBasicType(md, property));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#DATE}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is
   * {@link SupportedFieldType#DATE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType_givenDate_whenBasicFieldMetadataFieldTypeIsDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.DATE);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#DECIMAL}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is
   * {@link SupportedFieldType#DECIMAL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType_givenDecimal_whenBasicFieldMetadataFieldTypeIsDecimal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.DECIMAL);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#EMAIL}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is
   * {@link SupportedFieldType#EMAIL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType_givenEmail_whenBasicFieldMetadataFieldTypeIsEmail() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.EMAIL);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#FOREIGN_KEY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType_givenForeign_key() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.FOREIGN_KEY);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#HTML_BASIC}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is
   * {@link SupportedFieldType#HTML_BASIC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType_givenHtml_basic_whenBasicFieldMetadataFieldTypeIsHtml_basic() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.HTML_BASIC);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#HTML}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is
   * {@link SupportedFieldType#HTML}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType_givenHtml_whenBasicFieldMetadataFieldTypeIsHtml() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.HTML);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#ID}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is
   * {@link SupportedFieldType#ID}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType_givenId_whenBasicFieldMetadataFieldTypeIsId_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.ID);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#INTEGER}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is
   * {@link SupportedFieldType#INTEGER}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType_givenInteger_whenBasicFieldMetadataFieldTypeIsInteger() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.INTEGER);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#MONEY}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is
   * {@link SupportedFieldType#MONEY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType_givenMoney_whenBasicFieldMetadataFieldTypeIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.MONEY);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#STRING}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is
   * {@link SupportedFieldType#STRING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType_givenString_whenBasicFieldMetadataFieldTypeIsString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.STRING);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>When {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType_whenAdornedTargetCollectionMetadata_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertFalse(basicFieldPersistenceProvider.detectBasicType(md, new Property()));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#BROADLEAF_ENUMERATION}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}
   */
  @Test
  public void testDetectAdditionalSearchTypes_givenBroadleaf_enumeration_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.BROADLEAF_ENUMERATION);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectAdditionalSearchTypes(md, null));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@code ---}.</li>
   *   <li>When {@link Property#Property()} Name is {@code ---}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}
   */
  @Test
  public void testDetectAdditionalSearchTypes_givenDashDashDash_whenPropertyNameIsDashDashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.BROADLEAF_ENUMERATION);

    Property property = new Property();
    property.setName("---");

    // Act and Assert
    assertFalse(basicFieldPersistenceProvider.detectAdditionalSearchTypes(md, property));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#DATA_DRIVEN_ENUMERATION}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}
   */
  @Test
  public void testDetectAdditionalSearchTypes_givenData_driven_enumeration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.DATA_DRIVEN_ENUMERATION);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectAdditionalSearchTypes(md, null));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#EXPLICIT_ENUMERATION}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}
   */
  @Test
  public void testDetectAdditionalSearchTypes_givenExplicit_enumeration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.EXPLICIT_ENUMERATION);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectAdditionalSearchTypes(md, null));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}.
   * <ul>
   *   <li>When {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}
   */
  @Test
  public void testDetectAdditionalSearchTypes_whenAdornedTargetCollectionMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertFalse(basicFieldPersistenceProvider.detectAdditionalSearchTypes(md, new Property()));
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddSearchMappingRequest addSearchMappingRequest = mock(AddSearchMappingRequest.class);
    when(addSearchMappingRequest.getPropertyName()).thenReturn("Property Name");
    when(addSearchMappingRequest.getMergedProperties()).thenReturn(new HashMap<>());

    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    basicFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, new ArrayList<>());
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    basicFieldPersistenceProvider.canHandleExtraction(extractValueRequest, new Property());

    // Assert
    verify(addSearchMappingRequest).getMergedProperties();
    verify(addSearchMappingRequest).getPropertyName();
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction_givenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddSearchMappingRequest addSearchMappingRequest = mock(AddSearchMappingRequest.class);
    when(addSearchMappingRequest.getPropertyName()).thenReturn("Property Name");
    when(addSearchMappingRequest.getMergedProperties()).thenReturn(new HashMap<>());

    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    basicFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, new ArrayList<>());
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(null);

    // Act
    boolean actualCanHandleExtractionResult = basicFieldPersistenceProvider.canHandleExtraction(extractValueRequest,
        new Property());

    // Assert
    verify(addSearchMappingRequest).getMergedProperties();
    verify(addSearchMappingRequest).getPropertyName();
    verify(extractValueRequest).getMetadata();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#canHandleSearchMapping(AddSearchMappingRequest, List)}.
   * <ul>
   *   <li>Given {@code FOREIGNKEY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#canHandleSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  public void testCanHandleSearchMapping_givenForeignkey_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    doNothing().when(persistencePerspective)
        .addPersistencePerspectiveItem(Mockito.<PersistencePerspectiveItemType>any(),
            Mockito.<PersistencePerspectiveItem>any());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    AddSearchMappingRequest addSearchMappingRequest = new AddSearchMappingRequest(persistencePerspective, requestedCto,
        "Dr Jane Doe", mergedProperties, "Property Name", fieldManager, dataFormatProvider,
        new AdornedTargetListPersistenceModule(), mock(RestrictionFactory.class));

    // Act
    boolean actualCanHandleSearchMappingResult = basicFieldPersistenceProvider
        .canHandleSearchMapping(addSearchMappingRequest, new ArrayList<>());

    // Assert
    verify(persistencePerspective).addPersistencePerspectiveItem(eq(PersistencePerspectiveItemType.FOREIGNKEY),
        isA(PersistencePerspectiveItem.class));
    assertFalse(actualCanHandleSearchMappingResult);
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddSearchMappingRequest addSearchMappingRequest = mock(AddSearchMappingRequest.class);
    when(addSearchMappingRequest.getPropertyName()).thenReturn("Property Name");
    when(addSearchMappingRequest.getMergedProperties()).thenReturn(new HashMap<>());

    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    basicFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, new ArrayList<>());
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    MetadataProviderResponse actualPopulateValueResult = basicFieldPersistenceProvider
        .populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(addSearchMappingRequest).getMergedProperties();
    verify(addSearchMappingRequest).getPropertyName();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualPopulateValueResult);
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddSearchMappingRequest addSearchMappingRequest = mock(AddSearchMappingRequest.class);
    when(addSearchMappingRequest.getPropertyName()).thenReturn("Property Name");
    when(addSearchMappingRequest.getMergedProperties()).thenReturn(new HashMap<>());

    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    basicFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, new ArrayList<>());
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    basicFieldPersistenceProvider.extractValue(extractValueRequest, new Property());

    // Assert
    verify(addSearchMappingRequest).getMergedProperties();
    verify(addSearchMappingRequest).getPropertyName();
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_givenNull_thenReturnNotHandled() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddSearchMappingRequest addSearchMappingRequest = mock(AddSearchMappingRequest.class);
    when(addSearchMappingRequest.getPropertyName()).thenReturn("Property Name");
    when(addSearchMappingRequest.getMergedProperties()).thenReturn(new HashMap<>());

    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    basicFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, new ArrayList<>());
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(null);

    // Act
    MetadataProviderResponse actualExtractValueResult = basicFieldPersistenceProvider.extractValue(extractValueRequest,
        new Property());

    // Assert
    verify(addSearchMappingRequest).getMergedProperties();
    verify(addSearchMappingRequest).getPropertyName();
    verify(extractValueRequest).getMetadata();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}.
   * <ul>
   *   <li>Given {@code FOREIGNKEY}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  public void testAddSearchMapping_givenForeignkey_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    doNothing().when(persistencePerspective)
        .addPersistencePerspectiveItem(Mockito.<PersistencePerspectiveItemType>any(),
            Mockito.<PersistencePerspectiveItem>any());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    AddSearchMappingRequest addSearchMappingRequest = new AddSearchMappingRequest(persistencePerspective, requestedCto,
        "Dr Jane Doe", mergedProperties, "Property Name", fieldManager, dataFormatProvider,
        new AdornedTargetListPersistenceModule(), mock(RestrictionFactory.class));

    // Act
    MetadataProviderResponse actualAddSearchMappingResult = basicFieldPersistenceProvider
        .addSearchMapping(addSearchMappingRequest, new ArrayList<>());

    // Assert
    verify(persistencePerspective).addPersistencePerspectiveItem(eq(PersistencePerspectiveItemType.FOREIGNKEY),
        isA(PersistencePerspectiveItem.class));
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualAddSearchMappingResult);
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#getDateFormatToPopulateValue(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@link SimpleDateFormat#SimpleDateFormat(String)} with
   * {@code yyyy/mm/dd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#getDateFormatToPopulateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testGetDateFormatToPopulateValue_thenReturnSimpleDateFormatWithYyyyMmDd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddSearchMappingRequest addSearchMappingRequest = mock(AddSearchMappingRequest.class);
    when(addSearchMappingRequest.getPropertyName()).thenReturn("Property Name");
    when(addSearchMappingRequest.getMergedProperties()).thenReturn(new HashMap<>());

    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    basicFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, new ArrayList<>());
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/mm/dd");
    when(adornedTargetListPersistenceModule.getSimpleDateFormatter()).thenReturn(simpleDateFormat);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getDataFormatProvider()).thenReturn(adornedTargetListPersistenceModule);

    // Act
    SimpleDateFormat actualDateFormatToPopulateValue = basicFieldPersistenceProvider
        .getDateFormatToPopulateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(adornedTargetListPersistenceModule).getSimpleDateFormatter();
    verify(addSearchMappingRequest).getMergedProperties();
    verify(addSearchMappingRequest).getPropertyName();
    verify(populateValueRequest).getDataFormatProvider();
    assertSame(simpleDateFormat, actualDateFormatToPopulateValue);
  }

  /**
   * Test
   * {@link BasicFieldPersistenceProvider#getDateFormatToExtractValue(ExtractValueRequest)}.
   * <ul>
   *   <li>Then return {@link SimpleDateFormat#SimpleDateFormat(String)} with
   * {@code yyyy/mm/dd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldPersistenceProvider#getDateFormatToExtractValue(ExtractValueRequest)}
   */
  @Test
  public void testGetDateFormatToExtractValue_thenReturnSimpleDateFormatWithYyyyMmDd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddSearchMappingRequest addSearchMappingRequest = mock(AddSearchMappingRequest.class);
    when(addSearchMappingRequest.getPropertyName()).thenReturn("Property Name");
    when(addSearchMappingRequest.getMergedProperties()).thenReturn(new HashMap<>());

    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    basicFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, new ArrayList<>());
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/mm/dd");
    when(adornedTargetListPersistenceModule.getSimpleDateFormatter()).thenReturn(simpleDateFormat);
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getDataFormatProvider()).thenReturn(adornedTargetListPersistenceModule);

    // Act
    SimpleDateFormat actualDateFormatToExtractValue = basicFieldPersistenceProvider
        .getDateFormatToExtractValue(extractValueRequest);

    // Assert
    verify(adornedTargetListPersistenceModule).getSimpleDateFormatter();
    verify(addSearchMappingRequest).getMergedProperties();
    verify(addSearchMappingRequest).getPropertyName();
    verify(extractValueRequest).getDataFormatProvider();
    assertSame(simpleDateFormat, actualDateFormatToExtractValue);
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#getOrder()}.
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.BASIC, (new BasicFieldPersistenceProvider()).getOrder());
  }
}
