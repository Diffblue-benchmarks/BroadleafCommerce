package org.broadleafcommerce.common.config.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.cache.Cache;
import javax.cache.CacheManager;
import org.broadleafcommerce.common.config.dao.SystemPropertiesDao;
import org.broadleafcommerce.common.config.domain.NullSystemProperty;
import org.broadleafcommerce.common.config.domain.SystemProperty;
import org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class SystemPropertiesServiceImplDiffblueTest {
  @Mock private CacheManager cacheManager;

  @Mock private SystemPropertiesDao systemPropertiesDao;

  @InjectMocks private SystemPropertiesServiceImpl systemPropertiesServiceImpl;

  /**
   * Test {@link SystemPropertiesServiceImpl#buildKey(String)} with {@code propertyName}.
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#buildKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SystemPropertiesServiceImpl.buildKey(String)"})
  public void testBuildKeyWithPropertyName() {
    // Arrange, Act and Assert
    assertEquals("Property Name", new SystemPropertiesServiceImpl().buildKey("Property Name"));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#buildKey(String, Long, boolean)} with {@code
   * propertyName}, {@code siteId}, {@code forceEnvPrefix}.
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#buildKey(String, Long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SystemPropertiesServiceImpl.buildKey(String, Long, boolean)"})
  public void testBuildKeyWithPropertyNameSiteIdForceEnvPrefix() {
    // Arrange, Act and Assert
    assertEquals(
        "ORIGIN_FROM_ENV-1-Property Name",
        new SystemPropertiesServiceImpl().buildKey("Property Name", 1L, true));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#buildKey(String, Long, boolean)} with {@code
   * propertyName}, {@code siteId}, {@code forceEnvPrefix}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code Property Name}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#buildKey(String, Long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SystemPropertiesServiceImpl.buildKey(String, Long, boolean)"})
  public void testBuildKeyWithPropertyNameSiteIdForceEnvPrefix_whenNull_thenReturnPropertyName() {
    // Arrange, Act and Assert
    assertEquals(
        "Property Name", new SystemPropertiesServiceImpl().buildKey("Property Name", null, false));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#buildKey(String, Long, boolean)} with {@code
   * propertyName}, {@code siteId}, {@code forceEnvPrefix}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 1-Property Name}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#buildKey(String, Long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SystemPropertiesServiceImpl.buildKey(String, Long, boolean)"})
  public void testBuildKeyWithPropertyNameSiteIdForceEnvPrefix_whenOne_thenReturn1PropertyName() {
    // Arrange, Act and Assert
    assertEquals(
        "1-Property Name", new SystemPropertiesServiceImpl().buildKey("Property Name", 1L, false));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#buildKey(String, Long)} with {@code propertyName},
   * {@code siteId}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code Property Name}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#buildKey(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SystemPropertiesServiceImpl.buildKey(String, Long)"})
  public void testBuildKeyWithPropertyNameSiteId_whenNull_thenReturnPropertyName() {
    // Arrange, Act and Assert
    assertEquals(
        "Property Name", new SystemPropertiesServiceImpl().buildKey("Property Name", null));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#buildKey(String, Long)} with {@code propertyName},
   * {@code siteId}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 1-Property Name}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#buildKey(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SystemPropertiesServiceImpl.buildKey(String, Long)"})
  public void testBuildKeyWithPropertyNameSiteId_whenOne_thenReturn1PropertyName() {
    // Arrange, Act and Assert
    assertEquals(
        "1-Property Name", new SystemPropertiesServiceImpl().buildKey("Property Name", 1L));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#buildKey(SystemProperty, boolean)} with {@code
   * systemProperty}, {@code forceEnvPrefix}.
   *
   * <ul>
   *   <li>Then return {@code ORIGIN_FROM_ENV-null}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#buildKey(SystemProperty, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SystemPropertiesServiceImpl.buildKey(SystemProperty, boolean)"})
  public void testBuildKeyWithSystemPropertyForceEnvPrefix_thenReturnOriginFromEnvNull() {
    // Arrange
    SystemPropertiesServiceImpl systemPropertiesServiceImpl = new SystemPropertiesServiceImpl();

    // Act and Assert
    assertEquals(
        "ORIGIN_FROM_ENV-null",
        systemPropertiesServiceImpl.buildKey(new NullSystemProperty(), true));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#buildKey(SystemProperty, boolean)} with {@code
   * systemProperty}, {@code forceEnvPrefix}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#buildKey(SystemProperty, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SystemPropertiesServiceImpl.buildKey(SystemProperty, boolean)"})
  public void testBuildKeyWithSystemPropertyForceEnvPrefix_whenFalse_thenReturnNull() {
    // Arrange
    SystemPropertiesServiceImpl systemPropertiesServiceImpl = new SystemPropertiesServiceImpl();

    // Act and Assert
    assertNull(systemPropertiesServiceImpl.buildKey(new NullSystemProperty(), false));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#buildKey(SystemProperty)} with {@code systemProperty}.
   *
   * <ul>
   *   <li>Given {@link SystemPropertiesServiceImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#buildKey(SystemProperty)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SystemPropertiesServiceImpl.buildKey(SystemProperty)"})
  public void testBuildKeyWithSystemProperty_givenSystemPropertiesServiceImpl_thenReturnNull() {
    // Arrange
    SystemPropertiesServiceImpl systemPropertiesServiceImpl = new SystemPropertiesServiceImpl();

    // Act and Assert
    assertNull(systemPropertiesServiceImpl.buildKey(new NullSystemProperty()));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#getSystemPropertyCache()}.
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#getSystemPropertyCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Cache SystemPropertiesServiceImpl.getSystemPropertyCache()"})
  public void testGetSystemPropertyCache() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache<String, String> actualSystemPropertyCache =
        systemPropertiesServiceImpl.getSystemPropertyCache();

    // Assert
    verify(cacheManager).getCache("blSystemPropertyElements");
    assertNull(actualSystemPropertyCache);
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#getCacheName()}.
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#getCacheName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SystemPropertiesServiceImpl.getCacheName()"})
  public void testGetCacheName() {
    // Arrange, Act and Assert
    assertEquals("blSystemPropertyElements", new SystemPropertiesServiceImpl().getCacheName());
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#findById(Long)}.
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#findById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemProperty SystemPropertiesServiceImpl.findById(Long)"})
  public void testFindById() {
    // Arrange
    NullSystemProperty nullSystemProperty = new NullSystemProperty();
    when(systemPropertiesDao.readById(Mockito.<Long>any())).thenReturn(nullSystemProperty);

    // Act
    SystemProperty actualFindByIdResult = systemPropertiesServiceImpl.findById(1L);

    // Assert
    verify(systemPropertiesDao).readById(1L);
    assertSame(nullSystemProperty, actualFindByIdResult);
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#isValueValidForType(String,
   * SystemPropertyFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertiesServiceImpl.isValueValidForType(String, SystemPropertyFieldType)"
  })
  public void testIsValueValidForType() {
    // Arrange
    SystemPropertiesServiceImpl systemPropertiesServiceImpl = new SystemPropertiesServiceImpl();

    // Act and Assert
    assertFalse(
        systemPropertiesServiceImpl.isValueValidForType(
            "42", new SystemPropertyFieldType("TRUE", "TRUE")));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#isValueValidForType(String,
   * SystemPropertyFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertiesServiceImpl.isValueValidForType(String, SystemPropertyFieldType)"
  })
  public void testIsValueValidForType2() {
    // Arrange
    SystemPropertiesServiceImpl systemPropertiesServiceImpl = new SystemPropertiesServiceImpl();

    // Act and Assert
    assertFalse(
        systemPropertiesServiceImpl.isValueValidForType(
            "42", new SystemPropertyFieldType("BOOLEAN_TYPE", "TRUE")));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   *
   * <ul>
   *   <li>Given {@link SystemPropertiesServiceImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#isValueValidForType(String,
   * SystemPropertyFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertiesServiceImpl.isValueValidForType(String, SystemPropertyFieldType)"
  })
  public void testIsValueValidForType_givenSystemPropertiesServiceImpl_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new SystemPropertiesServiceImpl()
            .isValueValidForType(null, SystemPropertyFieldType.BOOLEAN_TYPE));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   *
   * <ul>
   *   <li>Given {@link SystemPropertiesServiceImpl} (default constructor).
   *   <li>When {@code TRUE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#isValueValidForType(String,
   * SystemPropertyFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertiesServiceImpl.isValueValidForType(String, SystemPropertyFieldType)"
  })
  public void testIsValueValidForType_givenSystemPropertiesServiceImpl_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new SystemPropertiesServiceImpl()
            .isValueValidForType("TRUE", SystemPropertyFieldType.BOOLEAN_TYPE));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   *
   * <ul>
   *   <li>When {@link SystemPropertyFieldType#BOOLEAN_TYPE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#isValueValidForType(String,
   * SystemPropertyFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertiesServiceImpl.isValueValidForType(String, SystemPropertyFieldType)"
  })
  public void testIsValueValidForType_whenBoolean_type_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new SystemPropertiesServiceImpl()
            .isValueValidForType("42", SystemPropertyFieldType.BOOLEAN_TYPE));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   *
   * <ul>
   *   <li>When {@link SystemPropertyFieldType#DOUBLE_TYPE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#isValueValidForType(String,
   * SystemPropertyFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertiesServiceImpl.isValueValidForType(String, SystemPropertyFieldType)"
  })
  public void testIsValueValidForType_whenDouble_type_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new SystemPropertiesServiceImpl()
            .isValueValidForType("TRUE", SystemPropertyFieldType.DOUBLE_TYPE));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   *
   * <ul>
   *   <li>When {@link SystemPropertyFieldType#DOUBLE_TYPE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#isValueValidForType(String,
   * SystemPropertyFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertiesServiceImpl.isValueValidForType(String, SystemPropertyFieldType)"
  })
  public void testIsValueValidForType_whenDouble_type_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new SystemPropertiesServiceImpl()
            .isValueValidForType("1", SystemPropertyFieldType.DOUBLE_TYPE));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   *
   * <ul>
   *   <li>When {@code FALSE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#isValueValidForType(String,
   * SystemPropertyFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertiesServiceImpl.isValueValidForType(String, SystemPropertyFieldType)"
  })
  public void testIsValueValidForType_whenFalse_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new SystemPropertiesServiceImpl()
            .isValueValidForType("FALSE", SystemPropertyFieldType.BOOLEAN_TYPE));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   *
   * <ul>
   *   <li>When {@link SystemPropertyFieldType#INT_TYPE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#isValueValidForType(String,
   * SystemPropertyFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertiesServiceImpl.isValueValidForType(String, SystemPropertyFieldType)"
  })
  public void testIsValueValidForType_whenInt_type_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new SystemPropertiesServiceImpl()
            .isValueValidForType("TRUE", SystemPropertyFieldType.INT_TYPE));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   *
   * <ul>
   *   <li>When {@link SystemPropertyFieldType#INT_TYPE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#isValueValidForType(String,
   * SystemPropertyFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertiesServiceImpl.isValueValidForType(String, SystemPropertyFieldType)"
  })
  public void testIsValueValidForType_whenInt_type_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new SystemPropertiesServiceImpl()
            .isValueValidForType("1", SystemPropertyFieldType.INT_TYPE));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   *
   * <ul>
   *   <li>When {@link SystemPropertyFieldType#LONG_TYPE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#isValueValidForType(String,
   * SystemPropertyFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertiesServiceImpl.isValueValidForType(String, SystemPropertyFieldType)"
  })
  public void testIsValueValidForType_whenLong_type_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new SystemPropertiesServiceImpl()
            .isValueValidForType("TRUE", SystemPropertyFieldType.LONG_TYPE));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   *
   * <ul>
   *   <li>When {@link SystemPropertyFieldType#LONG_TYPE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#isValueValidForType(String,
   * SystemPropertyFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertiesServiceImpl.isValueValidForType(String, SystemPropertyFieldType)"
  })
  public void testIsValueValidForType_whenLong_type_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new SystemPropertiesServiceImpl()
            .isValueValidForType("1", SystemPropertyFieldType.LONG_TYPE));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   *
   * <ul>
   *   <li>When {@link SystemPropertyFieldType#STRING_TYPE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#isValueValidForType(String,
   * SystemPropertyFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertiesServiceImpl.isValueValidForType(String, SystemPropertyFieldType)"
  })
  public void testIsValueValidForType_whenString_type_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new SystemPropertiesServiceImpl()
            .isValueValidForType("1", SystemPropertyFieldType.STRING_TYPE));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   *
   * <ul>
   *   <li>When {@link SystemPropertyFieldType#SystemPropertyFieldType()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#isValueValidForType(String,
   * SystemPropertyFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertiesServiceImpl.isValueValidForType(String, SystemPropertyFieldType)"
  })
  public void testIsValueValidForType_whenSystemPropertyFieldType_thenReturnFalse() {
    // Arrange
    SystemPropertiesServiceImpl systemPropertiesServiceImpl = new SystemPropertiesServiceImpl();

    // Act and Assert
    assertFalse(
        systemPropertiesServiceImpl.isValueValidForType("42", new SystemPropertyFieldType()));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   *
   * <ul>
   *   <li>When {@link SystemPropertyFieldType}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertiesServiceImpl#isValueValidForType(String,
   * SystemPropertyFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertiesServiceImpl.isValueValidForType(String, SystemPropertyFieldType)"
  })
  public void testIsValueValidForType_whenSystemPropertyFieldType_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(
        new SystemPropertiesServiceImpl()
            .isValueValidForType("42", mock(SystemPropertyFieldType.class)));
  }
}
