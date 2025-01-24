package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldNotAvailableException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.AddFilterPropertiesRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.AddSearchMappingRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.hibernate.engine.spi.SessionImplementor;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FieldPersistenceProviderAdapter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FieldPersistenceProviderAdapterDiffblueTest {
  @Autowired
  private FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter;

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#addSearchMapping(AddSearchMappingRequest, List)}.
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#addSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  public void testAddSearchMapping() {
    // Arrange
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
    MetadataProviderResponse actualAddSearchMappingResult = fieldPersistenceProviderAdapter
        .addSearchMapping(addSearchMappingRequest, new ArrayList<>());

    // Assert
    verify(persistencePerspective).addPersistencePerspectiveItem(eq(PersistencePerspectiveItemType.FOREIGNKEY),
        isA(PersistencePerspectiveItem.class));
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualAddSearchMappingResult);
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue() {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    MetadataProviderResponse actualPopulateValueResult = fieldPersistenceProviderAdapter
        .populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    Property property2 = populateValueRequest.getProperty();
    assertNull(property2.getOriginalDisplayValue());
    assertNull(property2.getOriginalValue());
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualPopulateValueResult);
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue2() throws PersistenceException {
    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider = new DefaultFieldPersistenceProvider();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, false, new Entity());

    // Act
    defaultFieldPersistenceProvider.populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertTrue(populateValueRequest.getProperty().getIsDirty());
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue3() throws PersistenceException {
    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider = new DefaultFieldPersistenceProvider();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    defaultFieldPersistenceProvider.populateValue(populateValueRequest, FilterAndSortCriteria.FIRST_ID_PARAMETER);

    // Assert
    Property property2 = populateValueRequest.getProperty();
    assertEquals("firstId", property2.getOriginalDisplayValue());
    assertEquals("firstId", property2.getOriginalValue());
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue4() throws PersistenceException {
    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider = new DefaultFieldPersistenceProvider();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    defaultFieldPersistenceProvider.populateValue(populateValueRequest, "42");

    // Assert
    Property property2 = populateValueRequest.getProperty();
    assertEquals("42", property2.getOriginalDisplayValue());
    assertEquals("42", property2.getOriginalValue());
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenReturnNotHandled() {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();
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
        fieldPersistenceProviderAdapter.extractValue(extractValueRequest, new Property()));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(new Entity());

    HashMap<String, FieldMetadata> properties = new HashMap<>();
    properties.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        fieldPersistenceProviderAdapter.filterProperties(addFilterPropertiesRequest, properties));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties_whenHashMap() {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(new Entity());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        fieldPersistenceProviderAdapter.filterProperties(addFilterPropertiesRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  public void testCheckDirtyState_givenDot_whenNull_thenReturnFalse() throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertFalse(fieldPersistenceProviderAdapter.checkDirtyState(new PopulateValueRequest(true, fieldManager, property,
        metadata, returnType, "42", persistenceManager, dataFormatProvider, true, new Entity()), null, "Check Value"));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  public void testCheckDirtyState_givenDot_whenOne_thenReturnFalse() throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertFalse(fieldPersistenceProviderAdapter.checkDirtyState(new PopulateValueRequest(true, fieldManager, property,
        metadata, returnType, "42", persistenceManager, dataFormatProvider, true, new Entity()), 1, "Check Value"));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When {@link Property#Property()} Name is {@code .}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  public void testCheckDirtyState_givenDot_whenPropertyNameIsDot_thenReturnFalse() throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertFalse(
        fieldPersistenceProviderAdapter.checkDirtyState(new PopulateValueRequest(true, fieldManager, property, metadata,
            returnType, "42", persistenceManager, dataFormatProvider, true, new Entity()), "Instance", "Check Value"));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When {@link Property#Property()} Name is {@code .}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  public void testCheckDirtyState_givenDot_whenPropertyNameIsDot_thenReturnFalse2() throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertFalse(fieldPersistenceProviderAdapter.checkDirtyState(new PopulateValueRequest(true, fieldManager, property,
        metadata, returnType, "42", persistenceManager, dataFormatProvider, true, new Entity()), "Check Value",
        "Check Value"));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  public void testCheckDirtyState_givenDot_whenSlash_thenReturnFalse() throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertFalse(fieldPersistenceProviderAdapter.checkDirtyState(new PopulateValueRequest(true, fieldManager, property,
        metadata, returnType, "42", persistenceManager, dataFormatProvider, true, new Entity()), " /", "Check Value"));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  public void testCheckDirtyState_thenReturnTrue() throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertTrue(
        fieldPersistenceProviderAdapter.checkDirtyState(new PopulateValueRequest(true, fieldManager, property, metadata,
            returnType, "42", persistenceManager, dataFormatProvider, false, new Entity()), "Instance", "Check Value"));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest, Object, Object)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest, Object, Object)}
   */
  @Test
  public void testIsFieldDirty_givenDot_whenNull_thenReturnTrue()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertTrue(fieldPersistenceProviderAdapter.isFieldDirty(new PopulateValueRequest(true, fieldManager, property,
        metadata, returnType, "42", persistenceManager, dataFormatProvider, true, new Entity()), null, "Check Value"));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest, Object, Object)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest, Object, Object)}
   */
  @Test
  public void testIsFieldDirty_givenDot_whenOne_thenReturnTrue()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertTrue(fieldPersistenceProviderAdapter.isFieldDirty(new PopulateValueRequest(true, fieldManager, property,
        metadata, returnType, "42", persistenceManager, dataFormatProvider, true, new Entity()), 1, "Check Value"));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest, Object, Object)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When {@link Property#Property()} Name is {@code .}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest, Object, Object)}
   */
  @Test
  public void testIsFieldDirty_givenDot_whenPropertyNameIsDot_thenReturnFalse()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertFalse(fieldPersistenceProviderAdapter.isFieldDirty(new PopulateValueRequest(true, fieldManager, property,
        metadata, returnType, "42", persistenceManager, dataFormatProvider, true, new Entity()), "Check Value",
        "Check Value"));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest, Object, Object)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When {@link Property#Property()} Name is {@code .}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest, Object, Object)}
   */
  @Test
  public void testIsFieldDirty_givenDot_whenPropertyNameIsDot_thenReturnTrue()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertTrue(
        fieldPersistenceProviderAdapter.isFieldDirty(new PopulateValueRequest(true, fieldManager, property, metadata,
            returnType, "42", persistenceManager, dataFormatProvider, true, new Entity()), "Instance", "Check Value"));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest, Object, Object)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest, Object, Object)}
   */
  @Test
  public void testIsFieldDirty_givenDot_whenSlash_thenReturnTrue()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertTrue(fieldPersistenceProviderAdapter.isFieldDirty(new PopulateValueRequest(true, fieldManager, property,
        metadata, returnType, "42", persistenceManager, dataFormatProvider, true, new Entity()), " /", "Check Value"));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#setNonDisplayableValues(PopulateValueRequest)}.
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#setNonDisplayableValues(PopulateValueRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetNonDisplayableValues() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Unable to create a SessionDelegatorBaseImpl from different Session/SessionImplementor references
    //       at org.hibernate.engine.spi.SessionDelegatorBaseImpl.<init>(SessionDelegatorBaseImpl.java:100)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    FieldManager fieldManager = new FieldManager(entityConfiguration,
        new SessionDelegatorBaseImpl(mock(SessionImplementor.class), mock(Session.class)));

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act
    fieldPersistenceProviderAdapter.setNonDisplayableValues(new PopulateValueRequest(true, fieldManager, property,
        metadata, returnType, "42", persistenceManager, dataFormatProvider, true, new Entity()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link FieldPersistenceProviderAdapter}
   *   <li>{@link FieldPersistenceProviderAdapter#getOrder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.BASIC, (new FieldPersistenceProviderAdapter()).getOrder());
  }
}
