package org.broadleafcommerce.common.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponents.UriTemplateVariables;

@ContextConfiguration(classes = {IdOverrideTableGenerator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class IdOverrideTableGeneratorDiffblueTest {
  @Autowired private IdOverrideTableGenerator idOverrideTableGenerator;

  /**
   * Test {@link IdOverrideTableGenerator#generate(SharedSessionContractImplementor, Object)}.
   *
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IdOverrideTableGenerator#generate(SharedSessionContractImplementor, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.io.Serializable IdOverrideTableGenerator.generate(SharedSessionContractImplementor, Object)"
  })
  public void testGenerate_whenNull_field_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> idOverrideTableGenerator.generate(null, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link IdOverrideTableGenerator#generate(SharedSessionContractImplementor, Object)}.
   *
   * <ul>
   *   <li>When {@link UriComponents.UriTemplateVariables#SKIP_VALUE}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IdOverrideTableGenerator#generate(SharedSessionContractImplementor, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.io.Serializable IdOverrideTableGenerator.generate(SharedSessionContractImplementor, Object)"
  })
  public void testGenerate_whenSkip_value_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> idOverrideTableGenerator.generate(null, UriTemplateVariables.SKIP_VALUE));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link IdOverrideTableGenerator}
   *   <li>{@link IdOverrideTableGenerator#setEntityName(String)}
   *   <li>{@link IdOverrideTableGenerator#getEntityName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IdOverrideTableGenerator.<init>()",
    "String IdOverrideTableGenerator.getEntityName()",
    "void IdOverrideTableGenerator.setEntityName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    IdOverrideTableGenerator actualIdOverrideTableGenerator = new IdOverrideTableGenerator();
    actualIdOverrideTableGenerator.setEntityName("Entity Name");

    // Assert
    assertEquals("Entity Name", actualIdOverrideTableGenerator.getEntityName());
    assertNull(actualIdOverrideTableGenerator.getSegmentColumnName());
    assertNull(actualIdOverrideTableGenerator.getSegmentValue());
    assertNull(actualIdOverrideTableGenerator.getValueColumnName());
    assertNull(actualIdOverrideTableGenerator.getOptimizer());
    assertNull(actualIdOverrideTableGenerator.getIdentifierType());
    assertEquals(0, actualIdOverrideTableGenerator.getIncrementSize());
    assertEquals(0, actualIdOverrideTableGenerator.getInitialValue());
    assertEquals(0, actualIdOverrideTableGenerator.getSegmentValueLength());
    assertEquals(0L, actualIdOverrideTableGenerator.getTableAccessCount());
  }
}
