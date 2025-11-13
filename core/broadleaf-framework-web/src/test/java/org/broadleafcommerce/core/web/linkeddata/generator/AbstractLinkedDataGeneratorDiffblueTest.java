package org.broadleafcommerce.core.web.linkeddata.generator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.web.BaseUrlResolver;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;

@RunWith(MockitoJUnitRunner.class)
public class AbstractLinkedDataGeneratorDiffblueTest {
  @Mock private BaseUrlResolver baseUrlResolver;

  @InjectMocks private CategoryLinkedDataGeneratorImpl categoryLinkedDataGeneratorImpl;

  @Mock private Environment environment;

  /**
   * Test {@link AbstractLinkedDataGenerator#getSiteBaseUrl()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractLinkedDataGenerator#getSiteBaseUrl()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractLinkedDataGenerator.getSiteBaseUrl()"})
  public void testGetSiteBaseUrl_thenReturnHttpsExampleOrgExample() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act
    String actualSiteBaseUrl = categoryLinkedDataGeneratorImpl.getSiteBaseUrl();

    // Assert
    verify(baseUrlResolver).getSiteBaseUrl();
    assertEquals("https://example.org/example", actualSiteBaseUrl);
  }

  /**
   * Test {@link AbstractLinkedDataGenerator#getStructuredDataContext()}.
   *
   * <ul>
   *   <li>Then return {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractLinkedDataGenerator#getStructuredDataContext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractLinkedDataGenerator.getStructuredDataContext()"})
  public void testGetStructuredDataContext_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn("Property");

    // Act
    String actualStructuredDataContext = categoryLinkedDataGeneratorImpl.getStructuredDataContext();

    // Assert
    verify(environment).getProperty("structured.data.context", "http://schema.org/");
    assertEquals("Property", actualStructuredDataContext);
  }
}
