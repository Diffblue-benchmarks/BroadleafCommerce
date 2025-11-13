package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.extension.BasicFieldPersistenceProviderExtensionManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.AddSearchMappingRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {MapFieldPersistenceProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MapFieldPersistenceProviderDiffblueTest {
  @MockBean(name = "blBasicFieldPersistenceProviderExtensionManager")
  private BasicFieldPersistenceProviderExtensionManager
      basicFieldPersistenceProviderExtensionManager;

  @Autowired private MapFieldPersistenceProvider mapFieldPersistenceProvider;

  /**
   * Test {@link MapFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * MapFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.addSearchMapping(AddSearchMappingRequest, List)"
  })
  public void testAddSearchMapping_givenFilterMapping_whenArrayListAddFilterMapping() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    AddSearchMappingRequest addSearchMappingRequest =
        new AddSearchMappingRequest(
            persistencePerspective,
            requestedCto,
            "Dr Jane Doe",
            mergedProperties,
            "Property Name",
            fieldManager,
            dataFormatProvider,
            new AdornedTargetListPersistenceModule(),
            mock(RestrictionFactory.class));

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.NOT_HANDLED,
        mapFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, filterMappings));
  }

  /**
   * Test {@link MapFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * MapFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.addSearchMapping(AddSearchMappingRequest, List)"
  })
  public void testAddSearchMapping_givenFilterMapping_whenArrayListAddFilterMapping2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    AddSearchMappingRequest addSearchMappingRequest =
        new AddSearchMappingRequest(
            persistencePerspective,
            requestedCto,
            "Dr Jane Doe",
            mergedProperties,
            "Property Name",
            fieldManager,
            dataFormatProvider,
            new AdornedTargetListPersistenceModule(),
            mock(RestrictionFactory.class));

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.NOT_HANDLED,
        mapFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, filterMappings));
  }

  /**
   * Test {@link MapFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MapFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.addSearchMapping(AddSearchMappingRequest, List)"
  })
  public void testAddSearchMapping_whenArrayList() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    AddSearchMappingRequest addSearchMappingRequest =
        new AddSearchMappingRequest(
            persistencePerspective,
            requestedCto,
            "Dr Jane Doe",
            mergedProperties,
            "Property Name",
            fieldManager,
            dataFormatProvider,
            new AdornedTargetListPersistenceModule(),
            mock(RestrictionFactory.class));

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.NOT_HANDLED,
        mapFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, new ArrayList<>()));
  }

  /**
   * Test {@link MapFieldPersistenceProvider#getOrder()}.
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int MapFieldPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.MAP_FIELD, new MapFieldPersistenceProvider().getOrder());
  }
}
