package org.broadleafcommerce.core.util;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {EntityIdentifierUtil.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EntityIdentifierUtilDiffblueTest {
  @Autowired private EntityIdentifierUtil entityIdentifierUtil;

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldName(Class)} with {@code clazz}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdentifierUtil#getIdentifierFieldName(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityIdentifierUtil.getIdentifierFieldName(Class)"})
  public void testGetIdentifierFieldNameWithClazz_thenReturnNull() {
    // Arrange
    Class<EntityIdentifierUtil> clazz = EntityIdentifierUtil.class;

    // Act and Assert
    assertNull(entityIdentifierUtil.getIdentifierFieldName(clazz));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldName(Object)} with {@code entity}.
   *
   * <ul>
   *   <li>When {@code Entity}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdentifierUtil#getIdentifierFieldName(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityIdentifierUtil.getIdentifierFieldName(Object)"})
  public void testGetIdentifierFieldNameWithEntity_whenEntity_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(entityIdentifierUtil.getIdentifierFieldName("Entity"));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldName(Object)} with {@code entity}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdentifierUtil#getIdentifierFieldName(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityIdentifierUtil.getIdentifierFieldName(Object)"})
  public void testGetIdentifierFieldNameWithEntity_whenFive_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(entityIdentifierUtil.getIdentifierFieldName(5));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldValue(Object)}.
   *
   * <ul>
   *   <li>When {@code Entity}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdentifierUtil#getIdentifierFieldValue(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.Serializable EntityIdentifierUtil.getIdentifierFieldValue(Object)"})
  public void testGetIdentifierFieldValue_whenEntity_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(entityIdentifierUtil.getIdentifierFieldValue("Entity"));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldValue(Object)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdentifierUtil#getIdentifierFieldValue(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.Serializable EntityIdentifierUtil.getIdentifierFieldValue(Object)"})
  public void testGetIdentifierFieldValue_whenFive_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(entityIdentifierUtil.getIdentifierFieldValue(5));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifyFieldValue(Object, String)}.
   *
   * <ul>
   *   <li>When {@code Entity}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdentifierUtil#getIdentifyFieldValue(Object, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.io.Serializable EntityIdentifierUtil.getIdentifyFieldValue(Object, String)"
  })
  public void testGetIdentifyFieldValue_whenEntity_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(entityIdentifierUtil.getIdentifyFieldValue("Entity", "Primary Key Field Name"));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifyFieldValue(Object, String)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdentifierUtil#getIdentifyFieldValue(Object, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.io.Serializable EntityIdentifierUtil.getIdentifyFieldValue(Object, String)"
  })
  public void testGetIdentifyFieldValue_whenFive_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(entityIdentifierUtil.getIdentifyFieldValue(5, "Primary Key Field Name"));
  }

  /**
   * Test {@link EntityIdentifierUtil#findIdentifierField(Class)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdentifierUtil#findIdentifierField(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.reflect.Field EntityIdentifierUtil.findIdentifierField(Class)"})
  public void testFindIdentifierField_thenReturnNull() {
    // Arrange
    Class<EntityIdentifierUtil> clazz = EntityIdentifierUtil.class;

    // Act and Assert
    assertNull(entityIdentifierUtil.findIdentifierField(clazz));
  }
}
