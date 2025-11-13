package org.broadleafcommerce.cms.web.deeplink;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.structure.dto.StructuredContentDTO;
import org.broadleafcommerce.common.web.BaseUrlResolver;
import org.broadleafcommerce.common.web.deeplink.DeepLink;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ContentDeepLinkServiceImplDiffblueTest {
  @Mock private BaseUrlResolver baseUrlResolver;

  @InjectMocks private ContentDeepLinkServiceImpl contentDeepLinkServiceImpl;

  /**
   * Test {@link ContentDeepLinkServiceImpl#getLinksInternal(StructuredContentDTO)} with {@code
   * StructuredContentDTO}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ContentDeepLinkServiceImpl#getLinksInternal(StructuredContentDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ContentDeepLinkServiceImpl.getLinksInternal(StructuredContentDTO)"})
  public void testGetLinksInternalWithStructuredContentDTO_thenReturnSizeIsOne() {
    // Arrange
    when(baseUrlResolver.getAdminBaseUrl()).thenReturn("https://example.org/example");

    StructuredContentDTO item = new StructuredContentDTO();
    item.setContentName("Not all who wander are lost");
    item.setContentType("text/plain");
    item.setId(1L);
    item.setItemCriteriaDTOList(new ArrayList<>());
    item.setLocaleCode("en");
    item.setPriority(1);
    item.setRuleExpression("Rule Expression");
    item.setValues(new HashMap<>());

    // Act
    List<DeepLink> actualLinksInternal = contentDeepLinkServiceImpl.getLinksInternal(item);

    // Assert
    verify(baseUrlResolver).getAdminBaseUrl();
    assertEquals(1, actualLinksInternal.size());
    DeepLink getResult = actualLinksInternal.get(0);
    assertEquals("Edit", getResult.getDisplayText());
    assertEquals("https://example.org/example", getResult.getAdminBaseUrl());
    assertEquals("https://example.org/example/null1", getResult.getFullUrl());
    assertEquals("null1", getResult.getUrlFragment());
    assertSame(item, getResult.getSourceObject());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ContentDeepLinkServiceImpl}
   *   <li>{@link ContentDeepLinkServiceImpl#setStructuredContentAdminPath(String)}
   *   <li>{@link ContentDeepLinkServiceImpl#getStructuredContentAdminPath()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ContentDeepLinkServiceImpl.<init>()",
    "String ContentDeepLinkServiceImpl.getStructuredContentAdminPath()",
    "void ContentDeepLinkServiceImpl.setStructuredContentAdminPath(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ContentDeepLinkServiceImpl actualContentDeepLinkServiceImpl = new ContentDeepLinkServiceImpl();
    actualContentDeepLinkServiceImpl.setStructuredContentAdminPath("Not all who wander are lost");

    // Assert
    assertEquals(
        "Not all who wander are lost",
        actualContentDeepLinkServiceImpl.getStructuredContentAdminPath());
  }
}
