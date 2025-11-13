package org.broadleafcommerce.cms.file.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StaticAssetDescriptionImplDiffblueTest {
  /**
   * Test {@link StaticAssetDescriptionImpl#cloneEntity()}.
   *
   * <p>Method under test: {@link StaticAssetDescriptionImpl#cloneEntity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StaticAssetDescription StaticAssetDescriptionImpl.cloneEntity()"})
  public void testCloneEntity() {
    // Arrange and Act
    StaticAssetDescription actualCloneEntityResult = new StaticAssetDescriptionImpl().cloneEntity();

    // Assert
    assertTrue(actualCloneEntityResult instanceof StaticAssetDescriptionImpl);
    assertNull(actualCloneEntityResult.getId());
    assertNull(actualCloneEntityResult.getDescription());
    assertNull(actualCloneEntityResult.getLongDescription());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StaticAssetDescriptionImpl}
   *   <li>{@link StaticAssetDescriptionImpl#setDescription(String)}
   *   <li>{@link StaticAssetDescriptionImpl#setId(Long)}
   *   <li>{@link StaticAssetDescriptionImpl#setLongDescription(String)}
   *   <li>{@link StaticAssetDescriptionImpl#getDescription()}
   *   <li>{@link StaticAssetDescriptionImpl#getId()}
   *   <li>{@link StaticAssetDescriptionImpl#getLongDescription()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetDescriptionImpl.<init>()",
    "String StaticAssetDescriptionImpl.getDescription()",
    "Long StaticAssetDescriptionImpl.getId()",
    "String StaticAssetDescriptionImpl.getLongDescription()",
    "void StaticAssetDescriptionImpl.setDescription(String)",
    "void StaticAssetDescriptionImpl.setId(Long)",
    "void StaticAssetDescriptionImpl.setLongDescription(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StaticAssetDescriptionImpl actualStaticAssetDescriptionImpl = new StaticAssetDescriptionImpl();
    actualStaticAssetDescriptionImpl.setDescription("The characteristics of someone or something");
    actualStaticAssetDescriptionImpl.setId(1L);
    actualStaticAssetDescriptionImpl.setLongDescription("Long Description");
    String actualDescription = actualStaticAssetDescriptionImpl.getDescription();
    Long actualId = actualStaticAssetDescriptionImpl.getId();

    // Assert
    assertEquals("Long Description", actualStaticAssetDescriptionImpl.getLongDescription());
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(1L, actualId.longValue());
  }
}
