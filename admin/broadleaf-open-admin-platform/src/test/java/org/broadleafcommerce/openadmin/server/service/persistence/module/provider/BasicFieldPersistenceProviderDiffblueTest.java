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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.extension.BasicFieldPersistenceProviderExtensionManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.AddSearchMappingRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BasicFieldPersistenceProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BasicFieldPersistenceProviderDiffblueTest {
  @Autowired
  private BasicFieldPersistenceProvider basicFieldPersistenceProvider;

  @MockBean(name = "blBasicFieldPersistenceProviderExtensionManager")
  private BasicFieldPersistenceProviderExtensionManager basicFieldPersistenceProviderExtensionManager;

  /**
   * Test {@link BasicFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"})
  public void testCanHandlePersistence_thenReturnFalse() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act and Assert
    assertFalse(
        basicFieldPersistenceProvider.canHandlePersistence(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#ADDITIONAL_FOREIGN_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectBasicType(FieldMetadata, Property)"})
  public void testDetectBasicType_givenAdditional_foreign_key() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.ADDITIONAL_FOREIGN_KEY);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#ASSET_URL}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is {@link SupportedFieldType#ASSET_URL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectBasicType(FieldMetadata, Property)"})
  public void testDetectBasicType_givenAsset_url_whenBasicFieldMetadataFieldTypeIsAsset_url() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.ASSET_URL);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#BOOLEAN}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is {@link SupportedFieldType#BOOLEAN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectBasicType(FieldMetadata, Property)"})
  public void testDetectBasicType_givenBoolean_whenBasicFieldMetadataFieldTypeIsBoolean() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.BOOLEAN);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#BOOLEAN}.</li>
   *   <li>When {@link Property#Property(String, String)} with {@code Name} and value is {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectBasicType(FieldMetadata, Property)"})
  public void testDetectBasicType_givenBoolean_whenPropertyWithNameAndValueIs42_thenReturnTrue() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.BOOLEAN);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, new Property("Name", "42")));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#CODE}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is {@link SupportedFieldType#CODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectBasicType(FieldMetadata, Property)"})
  public void testDetectBasicType_givenCode_whenBasicFieldMetadataFieldTypeIsCode() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.CODE);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@code ---}.</li>
   *   <li>When {@link Property#Property()} Name is {@code ---}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectBasicType(FieldMetadata, Property)"})
  public void testDetectBasicType_givenDashDashDash_whenPropertyNameIsDashDashDash() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.BOOLEAN);

    Property property = new Property();
    property.setName("---");

    // Act and Assert
    assertFalse(basicFieldPersistenceProvider.detectBasicType(md, property));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#DATE}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is {@link SupportedFieldType#DATE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectBasicType(FieldMetadata, Property)"})
  public void testDetectBasicType_givenDate_whenBasicFieldMetadataFieldTypeIsDate() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.DATE);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#DECIMAL}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is {@link SupportedFieldType#DECIMAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectBasicType(FieldMetadata, Property)"})
  public void testDetectBasicType_givenDecimal_whenBasicFieldMetadataFieldTypeIsDecimal() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.DECIMAL);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#EMAIL}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is {@link SupportedFieldType#EMAIL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectBasicType(FieldMetadata, Property)"})
  public void testDetectBasicType_givenEmail_whenBasicFieldMetadataFieldTypeIsEmail() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.EMAIL);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#FOREIGN_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectBasicType(FieldMetadata, Property)"})
  public void testDetectBasicType_givenForeign_key() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.FOREIGN_KEY);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#HTML_BASIC}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is {@link SupportedFieldType#HTML_BASIC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectBasicType(FieldMetadata, Property)"})
  public void testDetectBasicType_givenHtml_basic_whenBasicFieldMetadataFieldTypeIsHtml_basic() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.HTML_BASIC);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#HTML}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is {@link SupportedFieldType#HTML}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectBasicType(FieldMetadata, Property)"})
  public void testDetectBasicType_givenHtml_whenBasicFieldMetadataFieldTypeIsHtml() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.HTML);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#ID}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is {@link SupportedFieldType#ID}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectBasicType(FieldMetadata, Property)"})
  public void testDetectBasicType_givenId_whenBasicFieldMetadataFieldTypeIsId_thenReturnTrue() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.ID);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#INTEGER}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is {@link SupportedFieldType#INTEGER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectBasicType(FieldMetadata, Property)"})
  public void testDetectBasicType_givenInteger_whenBasicFieldMetadataFieldTypeIsInteger() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.INTEGER);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#MONEY}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is {@link SupportedFieldType#MONEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectBasicType(FieldMetadata, Property)"})
  public void testDetectBasicType_givenMoney_whenBasicFieldMetadataFieldTypeIsMoney() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.MONEY);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#STRING}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is {@link SupportedFieldType#STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectBasicType(FieldMetadata, Property)"})
  public void testDetectBasicType_givenString_whenBasicFieldMetadataFieldTypeIsString() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.STRING);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectBasicType(md, null));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>When {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectBasicType(FieldMetadata, Property)"})
  public void testDetectBasicType_whenAdornedTargetCollectionMetadata_thenReturnFalse() {
    // Arrange
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertFalse(basicFieldPersistenceProvider.detectBasicType(md, new Property()));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectBasicType(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectBasicType(FieldMetadata, Property)"})
  public void testDetectBasicType_whenBasicFieldMetadata_thenReturnFalse() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();

    // Act and Assert
    assertFalse(basicFieldPersistenceProvider.detectBasicType(md, new Property()));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@code ---}.</li>
   *   <li>When {@link Property#Property()} Name is {@code ---}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectAdditionalSearchTypes(FieldMetadata, Property)"})
  public void testDetectAdditionalSearchTypes_givenDashDashDash_whenPropertyNameIsDashDashDash() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.BROADLEAF_ENUMERATION);

    Property property = new Property();
    property.setName("---");

    // Act and Assert
    assertFalse(basicFieldPersistenceProvider.detectAdditionalSearchTypes(md, property));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#DATA_DRIVEN_ENUMERATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectAdditionalSearchTypes(FieldMetadata, Property)"})
  public void testDetectAdditionalSearchTypes_givenData_driven_enumeration() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.DATA_DRIVEN_ENUMERATION);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectAdditionalSearchTypes(md, null));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}.
   * <ul>
   *   <li>Given {@link SupportedFieldType#EXPLICIT_ENUMERATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectAdditionalSearchTypes(FieldMetadata, Property)"})
  public void testDetectAdditionalSearchTypes_givenExplicit_enumeration() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.EXPLICIT_ENUMERATION);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectAdditionalSearchTypes(md, null));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}.
   * <ul>
   *   <li>When {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectAdditionalSearchTypes(FieldMetadata, Property)"})
  public void testDetectAdditionalSearchTypes_whenAdornedTargetCollectionMetadata() {
    // Arrange
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertFalse(basicFieldPersistenceProvider.detectAdditionalSearchTypes(md, new Property()));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectAdditionalSearchTypes(FieldMetadata, Property)"})
  public void testDetectAdditionalSearchTypes_whenBasicFieldMetadata_thenReturnFalse() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();

    // Act and Assert
    assertFalse(basicFieldPersistenceProvider.detectAdditionalSearchTypes(md, new Property()));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectAdditionalSearchTypes(FieldMetadata, Property)"})
  public void testDetectAdditionalSearchTypes_whenNull_thenReturnTrue() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.BROADLEAF_ENUMERATION);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectAdditionalSearchTypes(md, null));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}.
   * <ul>
   *   <li>When {@link Property#Property(String, String)} with {@code Name} and value is {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#detectAdditionalSearchTypes(FieldMetadata, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.detectAdditionalSearchTypes(FieldMetadata, Property)"})
  public void testDetectAdditionalSearchTypes_whenPropertyWithNameAndValueIs42_thenReturnTrue() {
    // Arrange
    BasicFieldMetadata md = new BasicFieldMetadata();
    md.setFieldType(SupportedFieldType.BROADLEAF_ENUMERATION);

    // Act and Assert
    assertTrue(basicFieldPersistenceProvider.detectAdditionalSearchTypes(md, new Property("Name", "42")));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"})
  public void testCanHandleExtraction() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act and Assert
    assertFalse(basicFieldPersistenceProvider.canHandleExtraction(extractValueRequest, new Property()));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls {@link ExtractValueRequest#getMetadata()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"})
  public void testCanHandleExtraction_givenNull_thenCallsGetMetadata() {
    // Arrange
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(null);

    // Act
    boolean actualCanHandleExtractionResult = basicFieldPersistenceProvider.canHandleExtraction(extractValueRequest,
        new Property());

    // Assert
    verify(extractValueRequest).getMetadata();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#canHandleSearchMapping(AddSearchMappingRequest, List)}.
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#canHandleSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.canHandleSearchMapping(AddSearchMappingRequest, List)"})
  public void testCanHandleSearchMapping_givenFilterMapping_whenArrayListAddFilterMapping() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    AddSearchMappingRequest addSearchMappingRequest = new AddSearchMappingRequest(persistencePerspective, requestedCto,
        "Dr Jane Doe", mergedProperties, "Property Name", fieldManager, dataFormatProvider,
        new AdornedTargetListPersistenceModule(), mock(RestrictionFactory.class));

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertFalse(basicFieldPersistenceProvider.canHandleSearchMapping(addSearchMappingRequest, filterMappings));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#canHandleSearchMapping(AddSearchMappingRequest, List)}.
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#canHandleSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.canHandleSearchMapping(AddSearchMappingRequest, List)"})
  public void testCanHandleSearchMapping_givenFilterMapping_whenArrayListAddFilterMapping2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    AddSearchMappingRequest addSearchMappingRequest = new AddSearchMappingRequest(persistencePerspective, requestedCto,
        "Dr Jane Doe", mergedProperties, "Property Name", fieldManager, dataFormatProvider,
        new AdornedTargetListPersistenceModule(), mock(RestrictionFactory.class));

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertFalse(basicFieldPersistenceProvider.canHandleSearchMapping(addSearchMappingRequest, filterMappings));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#canHandleSearchMapping(AddSearchMappingRequest, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#canHandleSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicFieldPersistenceProvider.canHandleSearchMapping(AddSearchMappingRequest, List)"})
  public void testCanHandleSearchMapping_whenArrayList_thenReturnFalse() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    AddSearchMappingRequest addSearchMappingRequest = new AddSearchMappingRequest(persistencePerspective, requestedCto,
        "Dr Jane Doe", mergedProperties, "Property Name", fieldManager, dataFormatProvider,
        new AdornedTargetListPersistenceModule(), mock(RestrictionFactory.class));

    // Act and Assert
    assertFalse(basicFieldPersistenceProvider.canHandleSearchMapping(addSearchMappingRequest, new ArrayList<>()));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse BasicFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"})
  public void testPopulateValue_thenReturnNotHandled() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        basicFieldPersistenceProvider.populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse BasicFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"})
  public void testExtractValue() throws PersistenceException {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        basicFieldPersistenceProvider.extractValue(extractValueRequest, new Property()));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls {@link ExtractValueRequest#getMetadata()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse BasicFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"})
  public void testExtractValue_givenNull_thenCallsGetMetadata() throws PersistenceException {
    // Arrange
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(null);

    // Act
    MetadataProviderResponse actualExtractValueResult = basicFieldPersistenceProvider.extractValue(extractValueRequest,
        new Property());

    // Assert
    verify(extractValueRequest).getMetadata();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}.
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse BasicFieldPersistenceProvider.addSearchMapping(AddSearchMappingRequest, List)"})
  public void testAddSearchMapping_givenFilterMapping_whenArrayListAddFilterMapping() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    AddSearchMappingRequest addSearchMappingRequest = new AddSearchMappingRequest(persistencePerspective, requestedCto,
        "Dr Jane Doe", mergedProperties, "Property Name", fieldManager, dataFormatProvider,
        new AdornedTargetListPersistenceModule(), mock(RestrictionFactory.class));

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        basicFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, filterMappings));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}.
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse BasicFieldPersistenceProvider.addSearchMapping(AddSearchMappingRequest, List)"})
  public void testAddSearchMapping_givenFilterMapping_whenArrayListAddFilterMapping2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    AddSearchMappingRequest addSearchMappingRequest = new AddSearchMappingRequest(persistencePerspective, requestedCto,
        "Dr Jane Doe", mergedProperties, "Property Name", fieldManager, dataFormatProvider,
        new AdornedTargetListPersistenceModule(), mock(RestrictionFactory.class));

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        basicFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, filterMappings));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse BasicFieldPersistenceProvider.addSearchMapping(AddSearchMappingRequest, List)"})
  public void testAddSearchMapping_whenArrayList_thenReturnNotHandled() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    AddSearchMappingRequest addSearchMappingRequest = new AddSearchMappingRequest(persistencePerspective, requestedCto,
        "Dr Jane Doe", mergedProperties, "Property Name", fieldManager, dataFormatProvider,
        new AdornedTargetListPersistenceModule(), mock(RestrictionFactory.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        basicFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, new ArrayList<>()));
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#getDateFormatToPopulateValue(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then NumberFormat return {@link DecimalFormat}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#getDateFormatToPopulateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "SimpleDateFormat BasicFieldPersistenceProvider.getDateFormatToPopulateValue(PopulateValueRequest, Serializable)"})
  public void testGetDateFormatToPopulateValue_thenNumberFormatReturnDecimalFormat() {
    // Arrange
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
    assertTrue(actualDateFormatToPopulateValue.getNumberFormat() instanceof DecimalFormat);
    Calendar calendar = actualDateFormatToPopulateValue.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    assertEquals("yyyy.MM.dd HH:mm:ss", actualDateFormatToPopulateValue.toPattern());
    assertNull(actualDateFormatToPopulateValue.getTimeZone());
    assertNull(calendar.getTimeZone());
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#getDateFormatToPopulateValue(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@link SimpleDateFormat#SimpleDateFormat(String)} with {@code yyyy/mm/dd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#getDateFormatToPopulateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "SimpleDateFormat BasicFieldPersistenceProvider.getDateFormatToPopulateValue(PopulateValueRequest, Serializable)"})
  public void testGetDateFormatToPopulateValue_thenReturnSimpleDateFormatWithYyyyMmDd() {
    // Arrange
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
    verify(populateValueRequest).getDataFormatProvider();
    assertSame(simpleDateFormat, actualDateFormatToPopulateValue);
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#getDateFormatToExtractValue(ExtractValueRequest)}.
   * <ul>
   *   <li>Then NumberFormat return {@link DecimalFormat}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#getDateFormatToExtractValue(ExtractValueRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SimpleDateFormat BasicFieldPersistenceProvider.getDateFormatToExtractValue(ExtractValueRequest)"})
  public void testGetDateFormatToExtractValue_thenNumberFormatReturnDecimalFormat() {
    // Arrange
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
    assertTrue(actualDateFormatToExtractValue.getNumberFormat() instanceof DecimalFormat);
    Calendar calendar = actualDateFormatToExtractValue.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    assertEquals("yyyy.MM.dd HH:mm:ss", actualDateFormatToExtractValue.toPattern());
    assertNull(actualDateFormatToExtractValue.getTimeZone());
    assertNull(calendar.getTimeZone());
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#getDateFormatToExtractValue(ExtractValueRequest)}.
   * <ul>
   *   <li>Then return {@link SimpleDateFormat#SimpleDateFormat(String)} with {@code yyyy/mm/dd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#getDateFormatToExtractValue(ExtractValueRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SimpleDateFormat BasicFieldPersistenceProvider.getDateFormatToExtractValue(ExtractValueRequest)"})
  public void testGetDateFormatToExtractValue_thenReturnSimpleDateFormatWithYyyyMmDd() {
    // Arrange
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
    verify(extractValueRequest).getDataFormatProvider();
    assertSame(simpleDateFormat, actualDateFormatToExtractValue);
  }

  /**
   * Test {@link BasicFieldPersistenceProvider#getOrder()}.
   * <p>
   * Method under test: {@link BasicFieldPersistenceProvider#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int BasicFieldPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.BASIC, (new BasicFieldPersistenceProvider()).getOrder());
  }
}
