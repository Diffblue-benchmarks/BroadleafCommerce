package org.broadleafcommerce.core.search.service.solr.index;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.search.domain.Field;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class I18nSolrIndexServiceExtensionHandlerDiffblueTest {
  @InjectMocks private I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler;

  @Mock private SolrIndexServiceExtensionManager solrIndexServiceExtensionManager;

  /**
   * Test {@link I18nSolrIndexServiceExtensionHandler#init()}.
   *
   * <p>Method under test: {@link I18nSolrIndexServiceExtensionHandler#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void I18nSolrIndexServiceExtensionHandler.init()"})
  public void testInit() {
    // Arrange
    when(solrIndexServiceExtensionManager.registerHandler(
            Mockito.<SolrIndexServiceExtensionHandler>any()))
        .thenReturn(true);

    // Act
    i18nSolrIndexServiceExtensionHandler.init();

    // Assert
    verify(solrIndexServiceExtensionManager)
        .registerHandler(isA(SolrIndexServiceExtensionHandler.class));
  }

  /**
   * Test {@link I18nSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType,
   * Map, String, List)}.
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor) DefaultCurrency is {@link
   *       BroadleafCurrencyImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link I18nSolrIndexServiceExtensionHandler#addPropertyValues(Indexable,
   * Field, FieldType, Map, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType I18nSolrIndexServiceExtensionHandler.addPropertyValues(Indexable, Field, FieldType, Map, String, List)"
  })
  public void testAddPropertyValues_givenLocaleImplDefaultCurrencyIsBroadleafCurrencyImpl()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();
    HashMap<String, Object> values = new HashMap<>();

    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl.setDefaultFlag(true);
    localeImpl.setFriendlyName("en");
    localeImpl.setUseCountryInSearchIndex(true);
    localeImpl.setLocaleCode("_");

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(localeImpl);

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.addPropertyValues(
            indexable, field, FieldType.BOOLEAN, values, "Property Name", locales));
  }

  /**
   * Test {@link I18nSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType,
   * Map, String, List)}.
   *
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link I18nSolrIndexServiceExtensionHandler#addPropertyValues(Indexable,
   * Field, FieldType, Map, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType I18nSolrIndexServiceExtensionHandler.addPropertyValues(Indexable, Field, FieldType, Map, String, List)"
  })
  public void testAddPropertyValues_thenReturnNotHandled()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();
    HashMap<String, Object> values = new HashMap<>();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.addPropertyValues(
            indexable, field, FieldType.BOOLEAN, values, "Property Name", new ArrayList<>()));
  }

  /**
   * Test {@link I18nSolrIndexServiceExtensionHandler#getLocalePrefix(Field, List)}.
   *
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link I18nSolrIndexServiceExtensionHandler#getLocalePrefix(Field, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType I18nSolrIndexServiceExtensionHandler.getLocalePrefix(Field, List)"
  })
  public void testGetLocalePrefix_thenReturnNotHandled() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        new I18nSolrIndexServiceExtensionHandler();
    FieldImpl field = new FieldImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.getLocalePrefix(field, new ArrayList<>()));
  }

  /**
   * Test {@link I18nSolrIndexServiceExtensionHandler#getPriority()}.
   *
   * <p>Method under test: {@link I18nSolrIndexServiceExtensionHandler#getPriority()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int I18nSolrIndexServiceExtensionHandler.getPriority()"})
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(1000, new I18nSolrIndexServiceExtensionHandler().getPriority());
  }
}
