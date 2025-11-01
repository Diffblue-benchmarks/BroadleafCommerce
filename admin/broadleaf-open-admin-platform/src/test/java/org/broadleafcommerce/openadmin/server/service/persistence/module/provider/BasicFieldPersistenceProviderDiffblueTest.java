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
package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertArrayEquals;
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
import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
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
   * Method under test:
   * {@link BasicFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testCanHandlePersistence() {
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
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertFalse(basicFieldPersistenceProvider.detectBasicType(md, new Property()));
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.BOOLEAN);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType3() {
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
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.DATE);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.INTEGER);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.DECIMAL);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.EMAIL);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.FOREIGN_KEY);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.ADDITIONAL_FOREIGN_KEY);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.STRING);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.CODE);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.HTML);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.HTML_BASIC);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.MONEY);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType15() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.ASSET_URL);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  public void testDetectBasicType16() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.ID);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}
   */
  @Test
  public void testDetectAdditionalSearchTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertFalse(basicFieldPersistenceProvider.detectAdditionalSearchTypes(md, new Property()));
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}
   */
  @Test
  public void testDetectAdditionalSearchTypes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.BROADLEAF_ENUMERATION);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectAdditionalSearchTypes(md, null));
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}
   */
  @Test
  public void testDetectAdditionalSearchTypes3() {
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
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}
   */
  @Test
  public void testDetectAdditionalSearchTypes4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.EXPLICIT_ENUMERATION);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectAdditionalSearchTypes(md, null));
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}
   */
  @Test
  public void testDetectAdditionalSearchTypes5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();

    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.DATA_DRIVEN_ENUMERATION);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectAdditionalSearchTypes(md, null));
  }

  /**
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
    boolean actualCanHandleExtractionResult = basicFieldPersistenceProvider.canHandleExtraction(extractValueRequest,
        new Property());

    // Assert
    verify(addSearchMappingRequest).getMergedProperties();
    verify(addSearchMappingRequest).getPropertyName();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction2() {
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
   * Method under test:
   * {@link BasicFieldPersistenceProvider#canHandleSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  public void testCanHandleSearchMapping() {
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
   * Method under test:
   * {@link BasicFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue() {
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
    MetadataProviderResponse actualExtractValueResult = basicFieldPersistenceProvider.extractValue(extractValueRequest,
        new Property());

    // Assert
    verify(addSearchMappingRequest).getMergedProperties();
    verify(addSearchMappingRequest).getPropertyName();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue2() throws PersistenceException {
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
   * Method under test:
   * {@link BasicFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  public void testAddSearchMapping() {
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
   * Method under test:
   * {@link BasicFieldPersistenceProvider#getDateFormatToPopulateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testGetDateFormatToPopulateValue() {
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
    SimpleDateFormat actualDateFormatToPopulateValue = basicFieldPersistenceProvider
        .getDateFormatToPopulateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(addSearchMappingRequest).getMergedProperties();
    verify(addSearchMappingRequest).getPropertyName();
    NumberFormat numberFormat = actualDateFormatToPopulateValue.getNumberFormat();
    assertTrue(numberFormat instanceof DecimalFormat);
    Calendar calendar = actualDateFormatToPopulateValue.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    assertEquals("", ((DecimalFormat) numberFormat).getNegativeSuffix());
    assertEquals("", ((DecimalFormat) numberFormat).getPositivePrefix());
    assertEquals("", ((DecimalFormat) numberFormat).getPositiveSuffix());
    assertEquals("###0", ((DecimalFormat) numberFormat).toLocalizedPattern());
    assertEquals("###0", ((DecimalFormat) numberFormat).toPattern());
    assertEquals("-", ((DecimalFormat) numberFormat).getNegativePrefix());
    DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) numberFormat).getDecimalFormatSymbols();
    assertEquals("E", decimalFormatSymbols.getExponentSeparator());
    DateFormatSymbols dateFormatSymbols = actualDateFormatToPopulateValue.getDateFormatSymbols();
    assertEquals("GyMdkHmsSEDFwWahKzZ", dateFormatSymbols.getLocalPatternChars());
    assertEquals("NaN", decimalFormatSymbols.getNaN());
    Currency currency = numberFormat.getCurrency();
    assertEquals("Unknown Currency", currency.getDisplayName());
    assertEquals("XXX", decimalFormatSymbols.getInternationalCurrencySymbol());
    assertEquals("XXX", currency.getCurrencyCode());
    assertEquals("XXX", currency.toString());
    assertEquals("¤", decimalFormatSymbols.getCurrencySymbol());
    assertEquals("¤", currency.getSymbol());
    assertEquals("∞", decimalFormatSymbols.getInfinity());
    assertEquals("gregory", calendar.getCalendarType());
    assertEquals("yyyy.MM.dd HH:mm:ss", actualDateFormatToPopulateValue.toPattern());
    assertEquals('#', decimalFormatSymbols.getDigit());
    assertEquals('%', decimalFormatSymbols.getPercent());
    assertEquals(',', decimalFormatSymbols.getGroupingSeparator());
    assertEquals('-', decimalFormatSymbols.getMinusSign());
    assertEquals('.', decimalFormatSymbols.getDecimalSeparator());
    assertEquals('.', decimalFormatSymbols.getMonetaryDecimalSeparator());
    assertEquals('0', decimalFormatSymbols.getZeroDigit());
    assertEquals(';', decimalFormatSymbols.getPatternSeparator());
    assertEquals('‰', decimalFormatSymbols.getPerMill());
    assertNull(actualDateFormatToPopulateValue.getTimeZone());
    assertNull(calendar.getTimeZone());
    assertEquals(-1, currency.getDefaultFractionDigits());
    assertEquals(0, numberFormat.getMaximumFractionDigits());
    assertEquals(0, numberFormat.getMinimumFractionDigits());
    assertEquals(1, ((DecimalFormat) numberFormat).getMultiplier());
    assertEquals(1, numberFormat.getMinimumIntegerDigits());
    assertEquals(1, calendar.getFirstDayOfWeek());
    assertEquals(1, calendar.getMinimalDaysInFirstWeek());
    assertEquals(3, ((DecimalFormat) numberFormat).getGroupingSize());
    String[][] zoneStrings = dateFormatSymbols.getZoneStrings();
    assertEquals(602, zoneStrings.length);
    assertEquals(999, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN, numberFormat.getRoundingMode());
    assertFalse(((DecimalFormat) numberFormat).isDecimalSeparatorAlwaysShown());
    assertFalse(((DecimalFormat) numberFormat).isParseBigDecimal());
    assertFalse(numberFormat.isGroupingUsed());
    assertTrue(actualDateFormatToPopulateValue.isLenient());
    assertTrue(numberFormat.isParseIntegerOnly());
    assertTrue(calendar.isLenient());
    assertTrue(calendar.isWeekDateSupported());
    assertEquals(FieldPersistenceProvider.BASIC, numberFormat.getMaximumIntegerDigits());
    assertSame(currency, decimalFormatSymbols.getCurrency());
    assertArrayEquals(new String[]{"AM", "PM"}, dateFormatSymbols.getAmPmStrings());
    assertArrayEquals(new String[]{"BC", "AD"}, dateFormatSymbols.getEras());
    assertArrayEquals(new String[]{"ACT", "Australian Central Standard Time", "ACST",
        "Australian Central Daylight Time", "ACDT", "Central Australia Time", "ACT"}, zoneStrings[18]);
    assertArrayEquals(new String[]{"AET", "Australian Eastern Standard Time", "AEST",
        "Australian Eastern Daylight Time", "AEDT", "Eastern Australia Time", "AET"}, zoneStrings[19]);
    assertArrayEquals(new String[]{"ART", "Eastern European Standard Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[20]);
    assertArrayEquals(
        new String[]{"AST", "Alaska Standard Time", "AKST", "Alaska Daylight Time", "AKDT", "Alaska Time", "AKT"},
        zoneStrings[21]);
    assertArrayEquals(new String[]{"America/Anchorage", "Alaska Standard Time", "AKST", "Alaska Daylight Time", "AKDT",
        "Alaska Time", "AKT"}, zoneStrings[7]);
    assertArrayEquals(new String[]{"America/Argentina/Buenos_Aires", "Argentina Standard Time", "ART",
        "Argentina Summer Time", "ARST", "Argentina Time", "ART"}, zoneStrings[599]);
    assertArrayEquals(new String[]{"America/Argentina/ComodRivadavia", "Argentina Standard Time", "ART",
        "Argentina Summer Time", "ARST", "Argentina Time", "ART"}, zoneStrings[588]);
    assertArrayEquals(new String[]{"America/Chicago", "Central Standard Time", "CST", "Central Daylight Time", "CDT",
        "Central Time", "CT"}, zoneStrings[3]);
    assertArrayEquals(new String[]{"America/Denver", "Mountain Standard Time", "MST", "Mountain Daylight Time", "MDT",
        "Mountain Time", "MT"}, zoneStrings[1]);
    assertArrayEquals(new String[]{"America/Ensenada", "Pacific Standard Time", "PST", "Pacific Daylight Time", "PDT",
        "Pacific Time", "PT"}, zoneStrings[582]);
    assertArrayEquals(new String[]{"America/Halifax", "Atlantic Standard Time", "AST", "Atlantic Daylight Time", "ADT",
        "Atlantic Time", "AT"}, zoneStrings[8]);
    assertArrayEquals(new String[]{"America/Indianapolis", "Eastern Standard Time", "EST", "Eastern Daylight Time",
        "EDT", "Eastern Time", "ET"}, zoneStrings[5]);
    assertArrayEquals(new String[]{"America/Los_Angeles", "Pacific Standard Time", "PST", "Pacific Daylight Time",
        "PDT", "Pacific Time", "PT"}, zoneStrings[0]);
    assertArrayEquals(new String[]{"America/New_York", "Eastern Standard Time", "EST", "Eastern Daylight Time", "EDT",
        "Eastern Time", "ET"}, zoneStrings[4]);
    assertArrayEquals(new String[]{"America/Nuuk", "West Greenland Standard Time", "WGT", "West Greenland Summer Time",
        "WGST", "West Greenland Time", "WGT"}, zoneStrings[591]);
    assertArrayEquals(new String[]{"America/Phoenix", "Mountain Standard Time", "MST", "Mountain Daylight Time", "MDT",
        "Mountain Time", "MT"}, zoneStrings[2]);
    assertArrayEquals(new String[]{"America/Rosario", "Argentina Standard Time", "ART", "Argentina Summer Time", "ARST",
        "Argentina Time", "ART"}, zoneStrings[595]);
    assertArrayEquals(new String[]{"America/Sitka", "Alaska Standard Time", "AKST", "Alaska Daylight Time", "AKDT",
        "Alaska Time", "AKT"}, zoneStrings[9]);
    assertArrayEquals(new String[]{"America/St_Johns", "Newfoundland Standard Time", "NST",
        "Newfoundland Daylight Time", "NDT", "Newfoundland Time", "NT"}, zoneStrings[10]);
    assertArrayEquals(new String[]{"America/Virgin", "Atlantic Standard Time", "AST", "Atlantic Daylight Time", "ADT",
        "Atlantic Time", "AT"}, zoneStrings[583]);
    assertArrayEquals(new String[]{"Asia/Famagusta", "Eastern European Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[589]);
    assertArrayEquals(new String[]{"Asia/Jerusalem", "Israel Standard Time", "IST", "Israel Daylight Time", "IDT",
        "Israel Time", "IT"}, zoneStrings[13]);
    assertArrayEquals(
        new String[]{"Asia/Shanghai", "China Standard Time", "CST", "China Daylight Time", "CDT", "China Time", "CT"},
        zoneStrings[Short.SIZE]);
    assertArrayEquals(new String[]{"Asia/Srednekolymsk", "Srednekolymsk Time", "SRET", "Srednekolymsk Daylight Time",
        "SREDT", "Srednekolymsk Time", "SRET"}, zoneStrings[598]);
    assertArrayEquals(
        new String[]{"Asia/Tokyo", "Japan Standard Time", "JST", "Japan Daylight Time", "JDT", "Japan Time", "JT"},
        zoneStrings[14]);
    assertArrayEquals(
        new String[]{"BET", "Brasilia Standard Time", "BRT", "Brasilia Summer Time", "BRST", "Brasilia Time", "BRT"},
        zoneStrings[22]);
    assertArrayEquals(new String[]{"BST", "Bangladesh Standard Time", "BDT", "Bangladesh Summer Time", "BDST",
        "Bangladesh Time", "BDT"}, zoneStrings[23]);
    assertArrayEquals(new String[]{"CAT", "Central Africa Time", "CAT", "Central African Summer Time", "CAST",
        "Central Africa Time", "CAT"}, zoneStrings[24]);
    assertArrayEquals(new String[]{"Canada/Saskatchewan", "Central Standard Time", "CST", "Central Daylight Time",
        "CDT", "Central Time", "CT"}, zoneStrings[596]);
    assertArrayEquals(new String[]{"EET", "Eastern European Time", "EET", "Eastern European Summer Time", "EEST",
        "Eastern European Time", "EET"}, zoneStrings[594]);
    assertArrayEquals(new String[]{"Egypt", "Eastern European Standard Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[597]);
    assertArrayEquals(new String[]{"Etc/Greenwich", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT",
        "Greenwich Mean Time", "GMT"}, zoneStrings[581]);
    assertArrayEquals(new String[]{"Europe/Astrakhan", "Astrakhan Standard Time", "GMT+04:00",
        "Astrakhan Standard Time", "GMT+04:00", "Astrakhan Time", "GMT+04:00"}, zoneStrings[580]);
    assertArrayEquals(new String[]{"Europe/Bucharest", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[15]);
    assertArrayEquals(new String[]{"Europe/Kyiv", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[585]);
    assertArrayEquals(new String[]{"Europe/Nicosia", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[600]);
    assertArrayEquals(new String[]{"Europe/Paris", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[11]);
    assertArrayEquals(new String[]{"Europe/Ulyanovsk", "Ulyanovsk Standard Time", "GMT+04:00",
        "Ulyanovsk Standard Time", "GMT+04:00", "Ulyanovsk Time", "GMT+04:00"}, zoneStrings[592]);
    assertArrayEquals(
        new String[]{"GMT", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT"},
        zoneStrings[12]);
    assertArrayEquals(new String[]{"Hongkong", "Hong Kong Standard Time", "HKT", "Hong Kong Summer Time", "HKST",
        "Hong Kong Time", "HKT"}, zoneStrings[586]);
    assertArrayEquals(
        new String[]{"Jamaica", "Eastern Standard Time", "EST", "Eastern Daylight Time", "EDT", "Eastern Time", "ET"},
        zoneStrings[578]);
    assertArrayEquals(
        new String[]{"Japan", "Japan Standard Time", "JST", "Japan Daylight Time", "JDT", "Japan Time", "JT"},
        zoneStrings[590]);
    assertArrayEquals(new String[]{"MST", "Mountain Standard Time", "MST", "Mountain Standard Time", "MST",
        "Mountain Standard Time", "MST"}, zoneStrings[584]);
    assertArrayEquals(new String[]{"Pacific/Honolulu", "Hawaii-Aleutian Standard Time", "HST",
        "Hawaii-Aleutian Daylight Time", "HDT", "Hawaii-Aleutian Time", "HST"}, zoneStrings[6]);
    assertArrayEquals(new String[]{"Turkey", "Turkey Time", "TRT", "Turkey Summer Time", "TRST", "Turkey Time", "TRT"},
        zoneStrings[577]);
    assertArrayEquals(new String[]{"UCT", "Coordinated Universal Time", "UTC", "Coordinated Universal Time", "UTC",
        "Coordinated Universal Time", "UTC"}, zoneStrings[587]);
    assertArrayEquals(new String[]{"US/Pacific", "Pacific Standard Time", "PST", "Pacific Daylight Time", "PDT",
        "Pacific Time", "PT"}, zoneStrings[601]);
    assertArrayEquals(new String[]{"UTC", "Coordinated Universal Time", "UTC", "Coordinated Universal Time", "UTC",
        "Coordinated Universal Time", "UTC"}, zoneStrings[17]);
    assertArrayEquals(
        new String[]{"W-SU", "Moscow Standard Time", "MSK", "Moscow Summer Time", "MSD", "Moscow Time", "MT"},
        zoneStrings[593]);
    assertArrayEquals(new String[]{"WET", "Western European Time", "WET", "Western European Summer Time", "WEST",
        "Western European Time", "WET"}, zoneStrings[579]);
    assertArrayEquals(new String[]{"", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"},
        dateFormatSymbols.getShortWeekdays());
    assertArrayEquals(new String[]{"", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"},
        dateFormatSymbols.getWeekdays());
    assertArrayEquals(
        new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", ""},
        dateFormatSymbols.getShortMonths());
    assertArrayEquals(new String[]{"January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December", ""}, dateFormatSymbols.getMonths());
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#getDateFormatToPopulateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testGetDateFormatToPopulateValue2() {
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
   * Method under test:
   * {@link BasicFieldPersistenceProvider#getDateFormatToExtractValue(ExtractValueRequest)}
   */
  @Test
  public void testGetDateFormatToExtractValue() {
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

    // Act
    SimpleDateFormat actualDateFormatToExtractValue = basicFieldPersistenceProvider.getDateFormatToExtractValue(
        new ExtractValueRequest(props, fieldManager, metadata, "Requested Value", "Display Val", persistenceManager,
            recordHelper, new SimpleDateFormat("yyyy/mm/dd"), new String[]{"Custom Criteria"}));

    // Assert
    verify(addSearchMappingRequest).getMergedProperties();
    verify(addSearchMappingRequest).getPropertyName();
    NumberFormat numberFormat = actualDateFormatToExtractValue.getNumberFormat();
    assertTrue(numberFormat instanceof DecimalFormat);
    Calendar calendar = actualDateFormatToExtractValue.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    assertEquals("", ((DecimalFormat) numberFormat).getNegativeSuffix());
    assertEquals("", ((DecimalFormat) numberFormat).getPositivePrefix());
    assertEquals("", ((DecimalFormat) numberFormat).getPositiveSuffix());
    assertEquals("###0", ((DecimalFormat) numberFormat).toLocalizedPattern());
    assertEquals("###0", ((DecimalFormat) numberFormat).toPattern());
    assertEquals("-", ((DecimalFormat) numberFormat).getNegativePrefix());
    DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) numberFormat).getDecimalFormatSymbols();
    assertEquals("E", decimalFormatSymbols.getExponentSeparator());
    DateFormatSymbols dateFormatSymbols = actualDateFormatToExtractValue.getDateFormatSymbols();
    assertEquals("GyMdkHmsSEDFwWahKzZ", dateFormatSymbols.getLocalPatternChars());
    assertEquals("NaN", decimalFormatSymbols.getNaN());
    Currency currency = numberFormat.getCurrency();
    assertEquals("Unknown Currency", currency.getDisplayName());
    assertEquals("XXX", decimalFormatSymbols.getInternationalCurrencySymbol());
    assertEquals("XXX", currency.getCurrencyCode());
    assertEquals("XXX", currency.toString());
    assertEquals("¤", decimalFormatSymbols.getCurrencySymbol());
    assertEquals("¤", currency.getSymbol());
    assertEquals("∞", decimalFormatSymbols.getInfinity());
    assertEquals("gregory", calendar.getCalendarType());
    assertEquals("yyyy.MM.dd HH:mm:ss", actualDateFormatToExtractValue.toPattern());
    assertEquals('#', decimalFormatSymbols.getDigit());
    assertEquals('%', decimalFormatSymbols.getPercent());
    assertEquals(',', decimalFormatSymbols.getGroupingSeparator());
    assertEquals('-', decimalFormatSymbols.getMinusSign());
    assertEquals('.', decimalFormatSymbols.getDecimalSeparator());
    assertEquals('.', decimalFormatSymbols.getMonetaryDecimalSeparator());
    assertEquals('0', decimalFormatSymbols.getZeroDigit());
    assertEquals(';', decimalFormatSymbols.getPatternSeparator());
    assertEquals('‰', decimalFormatSymbols.getPerMill());
    assertNull(actualDateFormatToExtractValue.getTimeZone());
    assertNull(calendar.getTimeZone());
    assertEquals(-1, currency.getDefaultFractionDigits());
    assertEquals(0, numberFormat.getMaximumFractionDigits());
    assertEquals(0, numberFormat.getMinimumFractionDigits());
    assertEquals(1, ((DecimalFormat) numberFormat).getMultiplier());
    assertEquals(1, numberFormat.getMinimumIntegerDigits());
    assertEquals(1, calendar.getFirstDayOfWeek());
    assertEquals(1, calendar.getMinimalDaysInFirstWeek());
    assertEquals(3, ((DecimalFormat) numberFormat).getGroupingSize());
    String[][] zoneStrings = dateFormatSymbols.getZoneStrings();
    assertEquals(602, zoneStrings.length);
    assertEquals(999, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN, numberFormat.getRoundingMode());
    assertFalse(((DecimalFormat) numberFormat).isDecimalSeparatorAlwaysShown());
    assertFalse(((DecimalFormat) numberFormat).isParseBigDecimal());
    assertFalse(numberFormat.isGroupingUsed());
    assertTrue(actualDateFormatToExtractValue.isLenient());
    assertTrue(numberFormat.isParseIntegerOnly());
    assertTrue(calendar.isLenient());
    assertTrue(calendar.isWeekDateSupported());
    assertEquals(FieldPersistenceProvider.BASIC, numberFormat.getMaximumIntegerDigits());
    assertSame(currency, decimalFormatSymbols.getCurrency());
    assertArrayEquals(new String[]{"AM", "PM"}, dateFormatSymbols.getAmPmStrings());
    assertArrayEquals(new String[]{"BC", "AD"}, dateFormatSymbols.getEras());
    assertArrayEquals(new String[]{"ACT", "Australian Central Standard Time", "ACST",
        "Australian Central Daylight Time", "ACDT", "Central Australia Time", "ACT"}, zoneStrings[18]);
    assertArrayEquals(new String[]{"AET", "Australian Eastern Standard Time", "AEST",
        "Australian Eastern Daylight Time", "AEDT", "Eastern Australia Time", "AET"}, zoneStrings[19]);
    assertArrayEquals(new String[]{"ART", "Eastern European Standard Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[20]);
    assertArrayEquals(
        new String[]{"AST", "Alaska Standard Time", "AKST", "Alaska Daylight Time", "AKDT", "Alaska Time", "AKT"},
        zoneStrings[21]);
    assertArrayEquals(new String[]{"America/Anchorage", "Alaska Standard Time", "AKST", "Alaska Daylight Time", "AKDT",
        "Alaska Time", "AKT"}, zoneStrings[7]);
    assertArrayEquals(new String[]{"America/Argentina/Buenos_Aires", "Argentina Standard Time", "ART",
        "Argentina Summer Time", "ARST", "Argentina Time", "ART"}, zoneStrings[599]);
    assertArrayEquals(new String[]{"America/Argentina/ComodRivadavia", "Argentina Standard Time", "ART",
        "Argentina Summer Time", "ARST", "Argentina Time", "ART"}, zoneStrings[588]);
    assertArrayEquals(new String[]{"America/Chicago", "Central Standard Time", "CST", "Central Daylight Time", "CDT",
        "Central Time", "CT"}, zoneStrings[3]);
    assertArrayEquals(new String[]{"America/Denver", "Mountain Standard Time", "MST", "Mountain Daylight Time", "MDT",
        "Mountain Time", "MT"}, zoneStrings[1]);
    assertArrayEquals(new String[]{"America/Ensenada", "Pacific Standard Time", "PST", "Pacific Daylight Time", "PDT",
        "Pacific Time", "PT"}, zoneStrings[582]);
    assertArrayEquals(new String[]{"America/Halifax", "Atlantic Standard Time", "AST", "Atlantic Daylight Time", "ADT",
        "Atlantic Time", "AT"}, zoneStrings[8]);
    assertArrayEquals(new String[]{"America/Indianapolis", "Eastern Standard Time", "EST", "Eastern Daylight Time",
        "EDT", "Eastern Time", "ET"}, zoneStrings[5]);
    assertArrayEquals(new String[]{"America/Los_Angeles", "Pacific Standard Time", "PST", "Pacific Daylight Time",
        "PDT", "Pacific Time", "PT"}, zoneStrings[0]);
    assertArrayEquals(new String[]{"America/New_York", "Eastern Standard Time", "EST", "Eastern Daylight Time", "EDT",
        "Eastern Time", "ET"}, zoneStrings[4]);
    assertArrayEquals(new String[]{"America/Nuuk", "West Greenland Standard Time", "WGT", "West Greenland Summer Time",
        "WGST", "West Greenland Time", "WGT"}, zoneStrings[591]);
    assertArrayEquals(new String[]{"America/Phoenix", "Mountain Standard Time", "MST", "Mountain Daylight Time", "MDT",
        "Mountain Time", "MT"}, zoneStrings[2]);
    assertArrayEquals(new String[]{"America/Rosario", "Argentina Standard Time", "ART", "Argentina Summer Time", "ARST",
        "Argentina Time", "ART"}, zoneStrings[595]);
    assertArrayEquals(new String[]{"America/Sitka", "Alaska Standard Time", "AKST", "Alaska Daylight Time", "AKDT",
        "Alaska Time", "AKT"}, zoneStrings[9]);
    assertArrayEquals(new String[]{"America/St_Johns", "Newfoundland Standard Time", "NST",
        "Newfoundland Daylight Time", "NDT", "Newfoundland Time", "NT"}, zoneStrings[10]);
    assertArrayEquals(new String[]{"America/Virgin", "Atlantic Standard Time", "AST", "Atlantic Daylight Time", "ADT",
        "Atlantic Time", "AT"}, zoneStrings[583]);
    assertArrayEquals(new String[]{"Asia/Famagusta", "Eastern European Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[589]);
    assertArrayEquals(new String[]{"Asia/Jerusalem", "Israel Standard Time", "IST", "Israel Daylight Time", "IDT",
        "Israel Time", "IT"}, zoneStrings[13]);
    assertArrayEquals(
        new String[]{"Asia/Shanghai", "China Standard Time", "CST", "China Daylight Time", "CDT", "China Time", "CT"},
        zoneStrings[Short.SIZE]);
    assertArrayEquals(new String[]{"Asia/Srednekolymsk", "Srednekolymsk Time", "SRET", "Srednekolymsk Daylight Time",
        "SREDT", "Srednekolymsk Time", "SRET"}, zoneStrings[598]);
    assertArrayEquals(
        new String[]{"Asia/Tokyo", "Japan Standard Time", "JST", "Japan Daylight Time", "JDT", "Japan Time", "JT"},
        zoneStrings[14]);
    assertArrayEquals(
        new String[]{"BET", "Brasilia Standard Time", "BRT", "Brasilia Summer Time", "BRST", "Brasilia Time", "BRT"},
        zoneStrings[22]);
    assertArrayEquals(new String[]{"BST", "Bangladesh Standard Time", "BDT", "Bangladesh Summer Time", "BDST",
        "Bangladesh Time", "BDT"}, zoneStrings[23]);
    assertArrayEquals(new String[]{"CAT", "Central Africa Time", "CAT", "Central African Summer Time", "CAST",
        "Central Africa Time", "CAT"}, zoneStrings[24]);
    assertArrayEquals(new String[]{"Canada/Saskatchewan", "Central Standard Time", "CST", "Central Daylight Time",
        "CDT", "Central Time", "CT"}, zoneStrings[596]);
    assertArrayEquals(new String[]{"EET", "Eastern European Time", "EET", "Eastern European Summer Time", "EEST",
        "Eastern European Time", "EET"}, zoneStrings[594]);
    assertArrayEquals(new String[]{"Egypt", "Eastern European Standard Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[597]);
    assertArrayEquals(new String[]{"Etc/Greenwich", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT",
        "Greenwich Mean Time", "GMT"}, zoneStrings[581]);
    assertArrayEquals(new String[]{"Europe/Astrakhan", "Astrakhan Standard Time", "GMT+04:00",
        "Astrakhan Standard Time", "GMT+04:00", "Astrakhan Time", "GMT+04:00"}, zoneStrings[580]);
    assertArrayEquals(new String[]{"Europe/Bucharest", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[15]);
    assertArrayEquals(new String[]{"Europe/Kyiv", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[585]);
    assertArrayEquals(new String[]{"Europe/Nicosia", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[600]);
    assertArrayEquals(new String[]{"Europe/Paris", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[11]);
    assertArrayEquals(new String[]{"Europe/Ulyanovsk", "Ulyanovsk Standard Time", "GMT+04:00",
        "Ulyanovsk Standard Time", "GMT+04:00", "Ulyanovsk Time", "GMT+04:00"}, zoneStrings[592]);
    assertArrayEquals(
        new String[]{"GMT", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT"},
        zoneStrings[12]);
    assertArrayEquals(new String[]{"Hongkong", "Hong Kong Standard Time", "HKT", "Hong Kong Summer Time", "HKST",
        "Hong Kong Time", "HKT"}, zoneStrings[586]);
    assertArrayEquals(
        new String[]{"Jamaica", "Eastern Standard Time", "EST", "Eastern Daylight Time", "EDT", "Eastern Time", "ET"},
        zoneStrings[578]);
    assertArrayEquals(
        new String[]{"Japan", "Japan Standard Time", "JST", "Japan Daylight Time", "JDT", "Japan Time", "JT"},
        zoneStrings[590]);
    assertArrayEquals(new String[]{"MST", "Mountain Standard Time", "MST", "Mountain Standard Time", "MST",
        "Mountain Standard Time", "MST"}, zoneStrings[584]);
    assertArrayEquals(new String[]{"Pacific/Honolulu", "Hawaii-Aleutian Standard Time", "HST",
        "Hawaii-Aleutian Daylight Time", "HDT", "Hawaii-Aleutian Time", "HST"}, zoneStrings[6]);
    assertArrayEquals(new String[]{"Turkey", "Turkey Time", "TRT", "Turkey Summer Time", "TRST", "Turkey Time", "TRT"},
        zoneStrings[577]);
    assertArrayEquals(new String[]{"UCT", "Coordinated Universal Time", "UTC", "Coordinated Universal Time", "UTC",
        "Coordinated Universal Time", "UTC"}, zoneStrings[587]);
    assertArrayEquals(new String[]{"US/Pacific", "Pacific Standard Time", "PST", "Pacific Daylight Time", "PDT",
        "Pacific Time", "PT"}, zoneStrings[601]);
    assertArrayEquals(new String[]{"UTC", "Coordinated Universal Time", "UTC", "Coordinated Universal Time", "UTC",
        "Coordinated Universal Time", "UTC"}, zoneStrings[17]);
    assertArrayEquals(
        new String[]{"W-SU", "Moscow Standard Time", "MSK", "Moscow Summer Time", "MSD", "Moscow Time", "MT"},
        zoneStrings[593]);
    assertArrayEquals(new String[]{"WET", "Western European Time", "WET", "Western European Summer Time", "WEST",
        "Western European Time", "WET"}, zoneStrings[579]);
    assertArrayEquals(new String[]{"", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"},
        dateFormatSymbols.getShortWeekdays());
    assertArrayEquals(new String[]{"", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"},
        dateFormatSymbols.getWeekdays());
    assertArrayEquals(
        new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", ""},
        dateFormatSymbols.getShortMonths());
    assertArrayEquals(new String[]{"January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December", ""}, dateFormatSymbols.getMonths());
  }

  /**
   * Method under test:
   * {@link BasicFieldPersistenceProvider#getDateFormatToExtractValue(ExtractValueRequest)}
   */
  @Test
  public void testGetDateFormatToExtractValue2() {
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
   * Method under test: {@link BasicFieldPersistenceProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.BASIC, (new BasicFieldPersistenceProvider()).getOrder());
  }
}
