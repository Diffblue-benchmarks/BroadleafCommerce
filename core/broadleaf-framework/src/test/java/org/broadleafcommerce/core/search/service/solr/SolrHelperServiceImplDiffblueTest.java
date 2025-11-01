/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.LBHttp2SolrClient;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.search.domain.Field;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.broadleafcommerce.core.search.domain.RequiredFacet;
import org.broadleafcommerce.core.search.domain.RequiredFacetImpl;
import org.broadleafcommerce.core.search.domain.SearchCriteria;
import org.broadleafcommerce.core.search.domain.SearchFacet;
import org.broadleafcommerce.core.search.domain.SearchFacetDTO;
import org.broadleafcommerce.core.search.domain.SearchFacetImpl;
import org.broadleafcommerce.core.search.domain.SearchFacetRange;
import org.broadleafcommerce.core.search.domain.SearchFacetRangeImpl;
import org.junit.Test;
import org.mockito.Mockito;
import org.mvel2.util.InternalNumber;

public class SolrHelperServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#swapActiveCores(SolrConfiguration)}
   */
  @Test
  public void testSwapActiveCores() throws IOException, IllegalStateException, SolrServerException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    LBHttp2SolrClient reindexServer = mock(LBHttp2SolrClient.class);
    when(reindexServer.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any()))
        .thenReturn(new UpdateResponse());
    reindexServer.add("Collection", new ArrayList<>());
    LBHttp2SolrClient solrServer = mock(LBHttp2SolrClient.class);

    // Act
    solrHelperServiceImpl.swapActiveCores(
        new SolrConfiguration(solrServer, reindexServer, new LBHttp2SolrClient(null, "https://example.org/example")));

    // Assert that nothing has changed
    verify(reindexServer).add(eq("Collection"), isA(Collection.class));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#convertPrefixListToString(List)}
   */
  @Test
  public void testConvertPrefixListToString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act and Assert
    assertEquals("", solrHelperServiceImpl.convertPrefixListToString(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#convertPrefixListToString(List)}
   */
  @Test
  public void testConvertPrefixListToString2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    ArrayList<String> prefixList = new ArrayList<>();
    prefixList.add(null);

    // Act and Assert
    assertEquals("", solrHelperServiceImpl.convertPrefixListToString(prefixList));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#convertPrefixListToString(List)}
   */
  @Test
  public void testConvertPrefixListToString3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    ArrayList<String> prefixList = new ArrayList<>();
    prefixList.add("");

    // Act and Assert
    assertEquals("", solrHelperServiceImpl.convertPrefixListToString(prefixList));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#convertPrefixListToString(List)}
   */
  @Test
  public void testConvertPrefixListToString4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    ArrayList<String> prefixList = new ArrayList<>();
    prefixList.add("Prefix List");

    // Act and Assert
    assertEquals("Prefix List_", solrHelperServiceImpl.convertPrefixListToString(prefixList));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#convertPrefixListToString(List)}
   */
  @Test
  public void testConvertPrefixListToString5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    ArrayList<String> prefixList = new ArrayList<>();
    prefixList.add("42");
    prefixList.add("foo");

    // Act and Assert
    assertEquals("42_foo_", solrHelperServiceImpl.convertPrefixListToString(prefixList));
  }

  /**
   * Method under test: {@link SolrHelperServiceImpl#getPrimaryDocumentType()}
   */
  @Test
  public void testGetPrimaryDocumentType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("PRODUCT", (new SolrHelperServiceImpl()).getPrimaryDocumentType());
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getCurrentProductId(Indexable)}
   */
  @Test
  public void testGetCurrentProductId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act and Assert
    assertNull(solrHelperServiceImpl.getCurrentProductId(new ProductBundleImpl()));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getProductForIndexable(Indexable)}
   */
  @Test
  public void testGetProductForIndexable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();

    // Act and Assert
    assertSame(indexable, solrHelperServiceImpl.getProductForIndexable(indexable));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getProductForIndexable(Indexable)}
   */
  @Test
  public void testGetProductForIndexable2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act and Assert
    assertNull(solrHelperServiceImpl.getProductForIndexable(new SkuImpl()));
  }

  /**
   * Method under test: {@link SolrHelperServiceImpl#getTypeFieldName()}
   */
  @Test
  public void testGetTypeFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("type_s", (new SolrHelperServiceImpl()).getTypeFieldName());
  }

  /**
   * Method under test: {@link SolrHelperServiceImpl#getDocumentType(Indexable)}
   */
  @Test
  public void testGetDocumentType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act and Assert
    assertEquals("PRODUCT", solrHelperServiceImpl.getDocumentType(new ProductBundleImpl()));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getPropertyValue(Object, String)}
   */
  @Test
  public void testGetPropertyValue() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SolrHelperServiceImpl()).getPropertyValue("Object", "Property Name"));
    assertNull((new SolrHelperServiceImpl()).getPropertyValue("\\.", "Property Name"));
    assertNull((new SolrHelperServiceImpl()).getPropertyValue(null, "Property Name"));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getPropertyValue(Object, Field)}
   */
  @Test
  public void testGetPropertyValue2() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    FieldImpl field = mock(FieldImpl.class);
    when(field.getPropertyName()).thenReturn("Property Name");

    // Act
    Object actualPropertyValue = solrHelperServiceImpl.getPropertyValue("Object", field);

    // Assert
    verify(field).getPropertyName();
    assertNull(actualPropertyValue);
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getPropertyValue(Object, Field)}
   */
  @Test
  public void testGetPropertyValue3() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    FieldImpl field = mock(FieldImpl.class);
    when(field.getPropertyName()).thenReturn("Property Name");

    // Act
    Object actualPropertyValue = solrHelperServiceImpl.getPropertyValue(null, field);

    // Assert
    verify(field).getPropertyName();
    assertNull(actualPropertyValue);
  }

  /**
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42", (new SolrHelperServiceImpl()).scrubFacetValue("42"));
    assertEquals("\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("\\"));
    assertEquals("\\+", (new SolrHelperServiceImpl()).scrubFacetValue("+"));
    assertEquals("\\-", (new SolrHelperServiceImpl()).scrubFacetValue("-"));
    assertEquals("\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("&&"));
    assertEquals("\\||", (new SolrHelperServiceImpl()).scrubFacetValue("||"));
    assertEquals("\\!", (new SolrHelperServiceImpl()).scrubFacetValue("!"));
    assertEquals("\\(", (new SolrHelperServiceImpl()).scrubFacetValue("("));
    assertEquals("\\*", (new SolrHelperServiceImpl()).scrubFacetValue("*"));
    assertEquals("\\)", (new SolrHelperServiceImpl()).scrubFacetValue(")"));
    assertEquals("\\:", (new SolrHelperServiceImpl()).scrubFacetValue(":"));
    assertEquals("\\{", (new SolrHelperServiceImpl()).scrubFacetValue("{"));
    assertEquals("\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("\\?"));
    assertEquals("\\}", (new SolrHelperServiceImpl()).scrubFacetValue("}"));
    assertEquals("\\]", (new SolrHelperServiceImpl()).scrubFacetValue("]"));
    assertEquals("\\[", (new SolrHelperServiceImpl()).scrubFacetValue("["));
    assertEquals("42\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("42\\"));
    assertEquals("42\\+", (new SolrHelperServiceImpl()).scrubFacetValue("42+"));
    assertEquals("42\\-", (new SolrHelperServiceImpl()).scrubFacetValue("42-"));
    assertEquals("42\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("42&&"));
    assertEquals("42\\||", (new SolrHelperServiceImpl()).scrubFacetValue("42||"));
    assertEquals("42\\!", (new SolrHelperServiceImpl()).scrubFacetValue("42!"));
    assertEquals("42\\(", (new SolrHelperServiceImpl()).scrubFacetValue("42("));
    assertEquals("42\\*", (new SolrHelperServiceImpl()).scrubFacetValue("42*"));
    assertEquals("42\\)", (new SolrHelperServiceImpl()).scrubFacetValue("42)"));
    assertEquals("42\\:", (new SolrHelperServiceImpl()).scrubFacetValue("42:"));
    assertEquals("42\\{", (new SolrHelperServiceImpl()).scrubFacetValue("42{"));
    assertEquals("42\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("42\\?"));
    assertEquals("42\\}", (new SolrHelperServiceImpl()).scrubFacetValue("42}"));
    assertEquals("42\\]", (new SolrHelperServiceImpl()).scrubFacetValue("42]"));
    assertEquals("42\\[", (new SolrHelperServiceImpl()).scrubFacetValue("42["));
    assertEquals("\\\\42", (new SolrHelperServiceImpl()).scrubFacetValue("\\42"));
    assertEquals("\\\\\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("\\\\"));
    assertEquals("\\\\\\+", (new SolrHelperServiceImpl()).scrubFacetValue("\\+"));
    assertEquals("\\\\\\-", (new SolrHelperServiceImpl()).scrubFacetValue("\\-"));
    assertEquals("\\\\\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("\\&&"));
    assertEquals("\\\\\\||", (new SolrHelperServiceImpl()).scrubFacetValue("\\||"));
    assertEquals("\\\\\\!", (new SolrHelperServiceImpl()).scrubFacetValue("\\!"));
    assertEquals("\\\\Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("\\Facet Value"));
    assertEquals("\\\\\\(", (new SolrHelperServiceImpl()).scrubFacetValue("\\("));
    assertEquals("\\\\\\*", (new SolrHelperServiceImpl()).scrubFacetValue("\\*"));
    assertEquals("\\\\\\)", (new SolrHelperServiceImpl()).scrubFacetValue("\\)"));
    assertEquals("\\\\\\:", (new SolrHelperServiceImpl()).scrubFacetValue("\\:"));
    assertEquals("\\\\\\{", (new SolrHelperServiceImpl()).scrubFacetValue("\\{"));
    assertEquals("\\\\\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("\\\\?"));
    assertEquals("\\\\\\}", (new SolrHelperServiceImpl()).scrubFacetValue("\\}"));
    assertEquals("\\\\\\]", (new SolrHelperServiceImpl()).scrubFacetValue("\\]"));
    assertEquals("\\\\\\[", (new SolrHelperServiceImpl()).scrubFacetValue("\\["));
    assertEquals("\\\\desc", (new SolrHelperServiceImpl()).scrubFacetValue("\\desc"));
    assertEquals("\\\\exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("\\exploitProtection.xssEnabled"));
    assertEquals("\\+42", (new SolrHelperServiceImpl()).scrubFacetValue("+42"));
    assertEquals("\\+\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("+\\"));
    assertEquals("\\+\\+", (new SolrHelperServiceImpl()).scrubFacetValue("++"));
    assertEquals("\\+\\-", (new SolrHelperServiceImpl()).scrubFacetValue("+-"));
    assertEquals("\\+\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("+&&"));
    assertEquals("\\+\\||", (new SolrHelperServiceImpl()).scrubFacetValue("+||"));
    assertEquals("\\+\\!", (new SolrHelperServiceImpl()).scrubFacetValue("+!"));
    assertEquals("\\+Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("+Facet Value"));
    assertEquals("\\+\\(", (new SolrHelperServiceImpl()).scrubFacetValue("+("));
    assertEquals("\\+\\*", (new SolrHelperServiceImpl()).scrubFacetValue("+*"));
    assertEquals("\\+\\)", (new SolrHelperServiceImpl()).scrubFacetValue("+)"));
    assertEquals("\\+\\:", (new SolrHelperServiceImpl()).scrubFacetValue("+:"));
    assertEquals("\\+\\{", (new SolrHelperServiceImpl()).scrubFacetValue("+{"));
    assertEquals("\\+\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("+\\?"));
    assertEquals("\\+\\}", (new SolrHelperServiceImpl()).scrubFacetValue("+}"));
    assertEquals("\\+\\]", (new SolrHelperServiceImpl()).scrubFacetValue("+]"));
    assertEquals("\\+\\[", (new SolrHelperServiceImpl()).scrubFacetValue("+["));
    assertEquals("\\+desc", (new SolrHelperServiceImpl()).scrubFacetValue("+desc"));
    assertEquals("\\+exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("+exploitProtection.xssEnabled"));
    assertEquals("\\-42", (new SolrHelperServiceImpl()).scrubFacetValue("-42"));
    assertEquals("\\-\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("-\\"));
    assertEquals("\\-\\+", (new SolrHelperServiceImpl()).scrubFacetValue("-+"));
    assertEquals("\\-\\-", (new SolrHelperServiceImpl()).scrubFacetValue("--"));
    assertEquals("\\-\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("-&&"));
    assertEquals("\\-\\||", (new SolrHelperServiceImpl()).scrubFacetValue("-||"));
    assertEquals("\\-\\!", (new SolrHelperServiceImpl()).scrubFacetValue("-!"));
    assertEquals("\\-Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("-Facet Value"));
    assertEquals("\\-\\(", (new SolrHelperServiceImpl()).scrubFacetValue("-("));
    assertEquals("\\-\\*", (new SolrHelperServiceImpl()).scrubFacetValue("-*"));
    assertEquals("\\-\\)", (new SolrHelperServiceImpl()).scrubFacetValue("-)"));
    assertEquals("\\-\\:", (new SolrHelperServiceImpl()).scrubFacetValue("-:"));
    assertEquals("\\-\\{", (new SolrHelperServiceImpl()).scrubFacetValue("-{"));
    assertEquals("\\-\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("-\\?"));
    assertEquals("\\-\\}", (new SolrHelperServiceImpl()).scrubFacetValue("-}"));
    assertEquals("\\-\\]", (new SolrHelperServiceImpl()).scrubFacetValue("-]"));
    assertEquals("\\-\\[", (new SolrHelperServiceImpl()).scrubFacetValue("-["));
    assertEquals("\\-desc", (new SolrHelperServiceImpl()).scrubFacetValue("-desc"));
    assertEquals("\\-exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("-exploitProtection.xssEnabled"));
    assertEquals("\\&&42", (new SolrHelperServiceImpl()).scrubFacetValue("&&42"));
    assertEquals("\\&&\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("&&\\"));
    assertEquals("\\&&\\+", (new SolrHelperServiceImpl()).scrubFacetValue("&&+"));
    assertEquals("\\&&\\-", (new SolrHelperServiceImpl()).scrubFacetValue("&&-"));
    assertEquals("\\&&\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("&&&&"));
    assertEquals("\\&&\\||", (new SolrHelperServiceImpl()).scrubFacetValue("&&||"));
    assertEquals("\\&&\\!", (new SolrHelperServiceImpl()).scrubFacetValue("&&!"));
    assertEquals("\\&&Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("&&Facet Value"));
    assertEquals("\\&&\\(", (new SolrHelperServiceImpl()).scrubFacetValue("&&("));
    assertEquals("\\&&\\*", (new SolrHelperServiceImpl()).scrubFacetValue("&&*"));
    assertEquals("\\&&\\)", (new SolrHelperServiceImpl()).scrubFacetValue("&&)"));
    assertEquals("\\&&\\:", (new SolrHelperServiceImpl()).scrubFacetValue("&&:"));
    assertEquals("\\&&\\{", (new SolrHelperServiceImpl()).scrubFacetValue("&&{"));
    assertEquals("\\&&\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("&&\\?"));
    assertEquals("\\&&\\}", (new SolrHelperServiceImpl()).scrubFacetValue("&&}"));
    assertEquals("\\&&\\]", (new SolrHelperServiceImpl()).scrubFacetValue("&&]"));
    assertEquals("\\&&\\[", (new SolrHelperServiceImpl()).scrubFacetValue("&&["));
    assertEquals("\\&&desc", (new SolrHelperServiceImpl()).scrubFacetValue("&&desc"));
    assertEquals("\\&&exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("&&exploitProtection.xssEnabled"));
    assertEquals("\\||42", (new SolrHelperServiceImpl()).scrubFacetValue("||42"));
    assertEquals("\\||\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("||\\"));
    assertEquals("\\||\\+", (new SolrHelperServiceImpl()).scrubFacetValue("||+"));
    assertEquals("\\||\\-", (new SolrHelperServiceImpl()).scrubFacetValue("||-"));
    assertEquals("\\||\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("||&&"));
    assertEquals("\\||\\||", (new SolrHelperServiceImpl()).scrubFacetValue("||||"));
    assertEquals("\\||\\!", (new SolrHelperServiceImpl()).scrubFacetValue("||!"));
    assertEquals("\\||Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("||Facet Value"));
    assertEquals("\\||\\(", (new SolrHelperServiceImpl()).scrubFacetValue("||("));
    assertEquals("\\||\\*", (new SolrHelperServiceImpl()).scrubFacetValue("||*"));
    assertEquals("\\||\\)", (new SolrHelperServiceImpl()).scrubFacetValue("||)"));
    assertEquals("\\||\\:", (new SolrHelperServiceImpl()).scrubFacetValue("||:"));
    assertEquals("\\||\\{", (new SolrHelperServiceImpl()).scrubFacetValue("||{"));
    assertEquals("\\||\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("||\\?"));
    assertEquals("\\||\\}", (new SolrHelperServiceImpl()).scrubFacetValue("||}"));
    assertEquals("\\||\\]", (new SolrHelperServiceImpl()).scrubFacetValue("||]"));
    assertEquals("\\||\\[", (new SolrHelperServiceImpl()).scrubFacetValue("||["));
    assertEquals("\\||desc", (new SolrHelperServiceImpl()).scrubFacetValue("||desc"));
    assertEquals("\\||exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("||exploitProtection.xssEnabled"));
    assertEquals("\\!42", (new SolrHelperServiceImpl()).scrubFacetValue("!42"));
    assertEquals("\\!\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("!\\"));
    assertEquals("\\!\\+", (new SolrHelperServiceImpl()).scrubFacetValue("!+"));
    assertEquals("\\!\\-", (new SolrHelperServiceImpl()).scrubFacetValue("!-"));
    assertEquals("\\!\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("!&&"));
    assertEquals("\\!\\||", (new SolrHelperServiceImpl()).scrubFacetValue("!||"));
    assertEquals("\\!\\!", (new SolrHelperServiceImpl()).scrubFacetValue("!!"));
    assertEquals("\\!Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("!Facet Value"));
    assertEquals("\\!\\(", (new SolrHelperServiceImpl()).scrubFacetValue("!("));
    assertEquals("\\!\\*", (new SolrHelperServiceImpl()).scrubFacetValue("!*"));
    assertEquals("\\!\\)", (new SolrHelperServiceImpl()).scrubFacetValue("!)"));
    assertEquals("\\!\\:", (new SolrHelperServiceImpl()).scrubFacetValue("!:"));
    assertEquals("\\!\\{", (new SolrHelperServiceImpl()).scrubFacetValue("!{"));
    assertEquals("\\!\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("!\\?"));
    assertEquals("\\!\\}", (new SolrHelperServiceImpl()).scrubFacetValue("!}"));
    assertEquals("\\!\\]", (new SolrHelperServiceImpl()).scrubFacetValue("!]"));
    assertEquals("\\!\\[", (new SolrHelperServiceImpl()).scrubFacetValue("!["));
    assertEquals("\\!desc", (new SolrHelperServiceImpl()).scrubFacetValue("!desc"));
    assertEquals("\\!exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("!exploitProtection.xssEnabled"));
    assertEquals("Facet Value\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value\\"));
    assertEquals("Facet Value\\+", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value+"));
    assertEquals("Facet Value\\-", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value-"));
    assertEquals("Facet Value\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value&&"));
    assertEquals("Facet Value\\||", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value||"));
    assertEquals("Facet Value\\!", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value!"));
    assertEquals("Facet Value\\(", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value("));
    assertEquals("Facet Value\\*", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value*"));
    assertEquals("Facet Value\\)", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value)"));
    assertEquals("Facet Value\\:", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value:"));
    assertEquals("Facet Value\\{", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value{"));
    assertEquals("Facet Value\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value\\?"));
    assertEquals("Facet Value\\}", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value}"));
    assertEquals("Facet Value\\]", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value]"));
    assertEquals("Facet Value\\[", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value["));
    assertEquals("\\(42", (new SolrHelperServiceImpl()).scrubFacetValue("(42"));
    assertEquals("\\(\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("(\\"));
    assertEquals("\\(\\+", (new SolrHelperServiceImpl()).scrubFacetValue("(+"));
    assertEquals("\\(\\-", (new SolrHelperServiceImpl()).scrubFacetValue("(-"));
    assertEquals("\\(\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("(&&"));
    assertEquals("\\(\\||", (new SolrHelperServiceImpl()).scrubFacetValue("(||"));
    assertEquals("\\(\\!", (new SolrHelperServiceImpl()).scrubFacetValue("(!"));
    assertEquals("\\(Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("(Facet Value"));
    assertEquals("\\(\\(", (new SolrHelperServiceImpl()).scrubFacetValue("(("));
    assertEquals("\\(\\*", (new SolrHelperServiceImpl()).scrubFacetValue("(*"));
    assertEquals("\\(\\)", (new SolrHelperServiceImpl()).scrubFacetValue("()"));
    assertEquals("\\(\\:", (new SolrHelperServiceImpl()).scrubFacetValue("(:"));
    assertEquals("\\(\\{", (new SolrHelperServiceImpl()).scrubFacetValue("({"));
    assertEquals("\\(\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("(\\?"));
    assertEquals("\\(\\}", (new SolrHelperServiceImpl()).scrubFacetValue("(}"));
    assertEquals("\\(\\]", (new SolrHelperServiceImpl()).scrubFacetValue("(]"));
    assertEquals("\\(\\[", (new SolrHelperServiceImpl()).scrubFacetValue("(["));
    assertEquals("\\(desc", (new SolrHelperServiceImpl()).scrubFacetValue("(desc"));
    assertEquals("\\(exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("(exploitProtection.xssEnabled"));
    assertEquals("\\*42", (new SolrHelperServiceImpl()).scrubFacetValue("*42"));
    assertEquals("\\*\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("*\\"));
    assertEquals("\\*\\+", (new SolrHelperServiceImpl()).scrubFacetValue("*+"));
    assertEquals("\\*\\-", (new SolrHelperServiceImpl()).scrubFacetValue("*-"));
    assertEquals("\\*\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("*&&"));
    assertEquals("\\*\\||", (new SolrHelperServiceImpl()).scrubFacetValue("*||"));
    assertEquals("\\*\\!", (new SolrHelperServiceImpl()).scrubFacetValue("*!"));
    assertEquals("\\*Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("*Facet Value"));
    assertEquals("\\*\\(", (new SolrHelperServiceImpl()).scrubFacetValue("*("));
    assertEquals("\\*\\*", (new SolrHelperServiceImpl()).scrubFacetValue("**"));
    assertEquals("\\*\\)", (new SolrHelperServiceImpl()).scrubFacetValue("*)"));
    assertEquals("\\*\\:", (new SolrHelperServiceImpl()).scrubFacetValue("*:"));
    assertEquals("\\*\\{", (new SolrHelperServiceImpl()).scrubFacetValue("*{"));
    assertEquals("\\*\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("*\\?"));
    assertEquals("\\*\\}", (new SolrHelperServiceImpl()).scrubFacetValue("*}"));
    assertEquals("\\*\\]", (new SolrHelperServiceImpl()).scrubFacetValue("*]"));
    assertEquals("\\*\\[", (new SolrHelperServiceImpl()).scrubFacetValue("*["));
    assertEquals("\\*desc", (new SolrHelperServiceImpl()).scrubFacetValue("*desc"));
    assertEquals("\\*exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("*exploitProtection.xssEnabled"));
    assertEquals("\\)42", (new SolrHelperServiceImpl()).scrubFacetValue(")42"));
    assertEquals("\\)\\\\", (new SolrHelperServiceImpl()).scrubFacetValue(")\\"));
    assertEquals("\\)\\+", (new SolrHelperServiceImpl()).scrubFacetValue(")+"));
    assertEquals("\\)\\-", (new SolrHelperServiceImpl()).scrubFacetValue(")-"));
    assertEquals("\\)\\&&", (new SolrHelperServiceImpl()).scrubFacetValue(")&&"));
    assertEquals("\\)\\||", (new SolrHelperServiceImpl()).scrubFacetValue(")||"));
    assertEquals("\\)\\!", (new SolrHelperServiceImpl()).scrubFacetValue(")!"));
    assertEquals("\\)Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue(")Facet Value"));
    assertEquals("\\)\\(", (new SolrHelperServiceImpl()).scrubFacetValue(")("));
    assertEquals("\\)\\*", (new SolrHelperServiceImpl()).scrubFacetValue(")*"));
    assertEquals("\\)\\)", (new SolrHelperServiceImpl()).scrubFacetValue("))"));
    assertEquals("\\)\\:", (new SolrHelperServiceImpl()).scrubFacetValue("):"));
    assertEquals("\\)\\{", (new SolrHelperServiceImpl()).scrubFacetValue("){"));
    assertEquals("\\)\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue(")\\?"));
    assertEquals("\\)\\}", (new SolrHelperServiceImpl()).scrubFacetValue(")}"));
    assertEquals("\\)\\]", (new SolrHelperServiceImpl()).scrubFacetValue(")]"));
    assertEquals("\\)\\[", (new SolrHelperServiceImpl()).scrubFacetValue(")["));
    assertEquals("\\)desc", (new SolrHelperServiceImpl()).scrubFacetValue(")desc"));
    assertEquals("\\)exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue(")exploitProtection.xssEnabled"));
    assertEquals("\\:42", (new SolrHelperServiceImpl()).scrubFacetValue(":42"));
    assertEquals("\\:\\\\", (new SolrHelperServiceImpl()).scrubFacetValue(":\\"));
    assertEquals("\\:\\+", (new SolrHelperServiceImpl()).scrubFacetValue(":+"));
    assertEquals("\\:\\-", (new SolrHelperServiceImpl()).scrubFacetValue(":-"));
    assertEquals("\\:\\&&", (new SolrHelperServiceImpl()).scrubFacetValue(":&&"));
    assertEquals("\\:\\||", (new SolrHelperServiceImpl()).scrubFacetValue(":||"));
    assertEquals("\\:\\!", (new SolrHelperServiceImpl()).scrubFacetValue(":!"));
    assertEquals("\\:Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue(":Facet Value"));
    assertEquals("\\:\\(", (new SolrHelperServiceImpl()).scrubFacetValue(":("));
    assertEquals("\\:\\*", (new SolrHelperServiceImpl()).scrubFacetValue(":*"));
    assertEquals("\\:\\)", (new SolrHelperServiceImpl()).scrubFacetValue(":)"));
    assertEquals("\\:\\:", (new SolrHelperServiceImpl()).scrubFacetValue("::"));
    assertEquals("\\:\\{", (new SolrHelperServiceImpl()).scrubFacetValue(":{"));
    assertEquals("\\:\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue(":\\?"));
    assertEquals("\\:\\}", (new SolrHelperServiceImpl()).scrubFacetValue(":}"));
    assertEquals("\\:\\]", (new SolrHelperServiceImpl()).scrubFacetValue(":]"));
    assertEquals("\\:\\[", (new SolrHelperServiceImpl()).scrubFacetValue(":["));
    assertEquals("\\:desc", (new SolrHelperServiceImpl()).scrubFacetValue(":desc"));
    assertEquals("\\:exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue(":exploitProtection.xssEnabled"));
    assertEquals("\\{42", (new SolrHelperServiceImpl()).scrubFacetValue("{42"));
    assertEquals("\\{\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("{\\"));
    assertEquals("\\{\\+", (new SolrHelperServiceImpl()).scrubFacetValue("{+"));
    assertEquals("\\{\\-", (new SolrHelperServiceImpl()).scrubFacetValue("{-"));
    assertEquals("\\{\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("{&&"));
    assertEquals("\\{\\||", (new SolrHelperServiceImpl()).scrubFacetValue("{||"));
    assertEquals("\\{\\!", (new SolrHelperServiceImpl()).scrubFacetValue("{!"));
    assertEquals("\\{Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("{Facet Value"));
    assertEquals("\\{\\(", (new SolrHelperServiceImpl()).scrubFacetValue("{("));
    assertEquals("\\{\\*", (new SolrHelperServiceImpl()).scrubFacetValue("{*"));
    assertEquals("\\{\\)", (new SolrHelperServiceImpl()).scrubFacetValue("{)"));
    assertEquals("\\{\\:", (new SolrHelperServiceImpl()).scrubFacetValue("{:"));
    assertEquals("\\{\\{", (new SolrHelperServiceImpl()).scrubFacetValue("{{"));
    assertEquals("\\{\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("{\\?"));
    assertEquals("\\{\\}", (new SolrHelperServiceImpl()).scrubFacetValue("{}"));
    assertEquals("\\{\\]", (new SolrHelperServiceImpl()).scrubFacetValue("{]"));
    assertEquals("\\{\\[", (new SolrHelperServiceImpl()).scrubFacetValue("{["));
    assertEquals("\\{desc", (new SolrHelperServiceImpl()).scrubFacetValue("{desc"));
    assertEquals("\\{exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("{exploitProtection.xssEnabled"));
    assertEquals("\\\\\\?42", (new SolrHelperServiceImpl()).scrubFacetValue("\\?42"));
    assertEquals("\\\\\\?\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("\\?\\"));
    assertEquals("\\\\\\?\\+", (new SolrHelperServiceImpl()).scrubFacetValue("\\?+"));
    assertEquals("\\\\\\?\\-", (new SolrHelperServiceImpl()).scrubFacetValue("\\?-"));
    assertEquals("\\\\\\?\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("\\?&&"));
    assertEquals("\\\\\\?\\||", (new SolrHelperServiceImpl()).scrubFacetValue("\\?||"));
    assertEquals("\\\\\\?\\!", (new SolrHelperServiceImpl()).scrubFacetValue("\\?!"));
    assertEquals("\\\\\\?Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("\\?Facet Value"));
    assertEquals("\\\\\\?\\(", (new SolrHelperServiceImpl()).scrubFacetValue("\\?("));
    assertEquals("\\\\\\?\\*", (new SolrHelperServiceImpl()).scrubFacetValue("\\?*"));
    assertEquals("\\\\\\?\\)", (new SolrHelperServiceImpl()).scrubFacetValue("\\?)"));
    assertEquals("\\\\\\?\\:", (new SolrHelperServiceImpl()).scrubFacetValue("\\?:"));
    assertEquals("\\\\\\?\\{", (new SolrHelperServiceImpl()).scrubFacetValue("\\?{"));
    assertEquals("\\\\\\?\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("\\?\\?"));
    assertEquals("\\\\\\?\\}", (new SolrHelperServiceImpl()).scrubFacetValue("\\?}"));
    assertEquals("\\\\\\?\\]", (new SolrHelperServiceImpl()).scrubFacetValue("\\?]"));
    assertEquals("\\\\\\?\\[", (new SolrHelperServiceImpl()).scrubFacetValue("\\?["));
    assertEquals("\\\\\\?desc", (new SolrHelperServiceImpl()).scrubFacetValue("\\?desc"));
    assertEquals("\\\\\\?exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("\\?exploitProtection.xssEnabled"));
    assertEquals("\\}42", (new SolrHelperServiceImpl()).scrubFacetValue("}42"));
    assertEquals("\\}\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("}\\"));
    assertEquals("\\}\\+", (new SolrHelperServiceImpl()).scrubFacetValue("}+"));
    assertEquals("\\}\\-", (new SolrHelperServiceImpl()).scrubFacetValue("}-"));
    assertEquals("\\}\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("}&&"));
    assertEquals("\\}\\||", (new SolrHelperServiceImpl()).scrubFacetValue("}||"));
    assertEquals("\\}\\!", (new SolrHelperServiceImpl()).scrubFacetValue("}!"));
    assertEquals("\\}Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("}Facet Value"));
    assertEquals("\\}\\(", (new SolrHelperServiceImpl()).scrubFacetValue("}("));
    assertEquals("\\}\\*", (new SolrHelperServiceImpl()).scrubFacetValue("}*"));
    assertEquals("\\}\\)", (new SolrHelperServiceImpl()).scrubFacetValue("})"));
    assertEquals("\\}\\:", (new SolrHelperServiceImpl()).scrubFacetValue("}:"));
    assertEquals("\\}\\{", (new SolrHelperServiceImpl()).scrubFacetValue("}{"));
    assertEquals("\\}\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("}\\?"));
    assertEquals("\\}\\}", (new SolrHelperServiceImpl()).scrubFacetValue("}}"));
    assertEquals("\\}\\]", (new SolrHelperServiceImpl()).scrubFacetValue("}]"));
    assertEquals("\\}\\[", (new SolrHelperServiceImpl()).scrubFacetValue("}["));
    assertEquals("\\}desc", (new SolrHelperServiceImpl()).scrubFacetValue("}desc"));
    assertEquals("\\}exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("}exploitProtection.xssEnabled"));
    assertEquals("\\]42", (new SolrHelperServiceImpl()).scrubFacetValue("]42"));
    assertEquals("\\]\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("]\\"));
    assertEquals("\\]\\+", (new SolrHelperServiceImpl()).scrubFacetValue("]+"));
    assertEquals("\\]\\-", (new SolrHelperServiceImpl()).scrubFacetValue("]-"));
    assertEquals("\\]\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("]&&"));
    assertEquals("\\]\\||", (new SolrHelperServiceImpl()).scrubFacetValue("]||"));
    assertEquals("\\]\\!", (new SolrHelperServiceImpl()).scrubFacetValue("]!"));
    assertEquals("\\]Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("]Facet Value"));
    assertEquals("\\]\\(", (new SolrHelperServiceImpl()).scrubFacetValue("]("));
    assertEquals("\\]\\*", (new SolrHelperServiceImpl()).scrubFacetValue("]*"));
    assertEquals("\\]\\)", (new SolrHelperServiceImpl()).scrubFacetValue("])"));
    assertEquals("\\]\\:", (new SolrHelperServiceImpl()).scrubFacetValue("]:"));
    assertEquals("\\]\\{", (new SolrHelperServiceImpl()).scrubFacetValue("]{"));
    assertEquals("\\]\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("]\\?"));
    assertEquals("\\]\\}", (new SolrHelperServiceImpl()).scrubFacetValue("]}"));
  }

  /**
   * Method under test: {@link SolrHelperServiceImpl#sanitizeQuery(String)}
   */
  @Test
  public void testSanitizeQuery() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Query", (new SolrHelperServiceImpl()).sanitizeQuery("Query"));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}
   */
  @Test
  public void testIsFacetAvailable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetImpl facet = new SearchFacetImpl();

    // Act and Assert
    assertTrue(solrHelperServiceImpl.isFacetAvailable(facet, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}
   */
  @Test
  public void testIsFacetAvailable2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getRequiredFacets()).thenReturn(new ArrayList<>());

    // Act
    boolean actualIsFacetAvailableResult = solrHelperServiceImpl.isFacetAvailable(facet, new HashMap<>());

    // Assert
    verify(facet).getRequiredFacets();
    assertTrue(actualIsFacetAvailableResult);
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}
   */
  @Test
  public void testIsFacetAvailable3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    ArrayList<RequiredFacet> requiredFacetList = new ArrayList<>();
    requiredFacetList.add(new RequiredFacetImpl());
    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getRequiredFacets()).thenReturn(requiredFacetList);

    // Act
    boolean actualIsFacetAvailableResult = solrHelperServiceImpl.isFacetAvailable(facet, new HashMap<>());

    // Assert
    verify(facet).getRequiredFacets();
    assertFalse(actualIsFacetAvailableResult);
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}
   */
  @Test
  public void testIsFacetAvailable4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetImpl requiredFacet = mock(SearchFacetImpl.class);
    when(requiredFacet.getField()).thenReturn(new FieldImpl());

    RequiredFacetImpl requiredFacetImpl = new RequiredFacetImpl();
    requiredFacetImpl.setRequiredFacet(requiredFacet);

    ArrayList<RequiredFacet> requiredFacetList = new ArrayList<>();
    requiredFacetList.add(requiredFacetImpl);
    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getRequiresAllDependentFacets()).thenReturn(true);
    when(facet.getRequiredFacets()).thenReturn(requiredFacetList);

    HashMap<String, String[]> params = new HashMap<>();
    params.put("42", new String[]{"foo"});

    // Act
    boolean actualIsFacetAvailableResult = solrHelperServiceImpl.isFacetAvailable(facet, params);

    // Assert
    verify(requiredFacet).getField();
    verify(facet, atLeast(1)).getRequiredFacets();
    verify(facet).getRequiresAllDependentFacets();
    assertFalse(actualIsFacetAvailableResult);
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrRangeString(String, BigDecimal, BigDecimal)}
   */
  @Test
  public void testGetSolrRangeString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    BigDecimal minValue = new BigDecimal("2.3");

    // Act and Assert
    assertEquals("Field Name:[2.3 TO 2.3]",
        solrHelperServiceImpl.getSolrRangeString("Field Name", minValue, new BigDecimal("2.3")));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrRangeString(String, BigDecimal, BigDecimal)}
   */
  @Test
  public void testGetSolrRangeString2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Field Name:[* TO *]", (new SolrHelperServiceImpl()).getSolrRangeString("Field Name", null, null));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrRangeString(String, BigDecimal, BigDecimal)}
   */
  @Test
  public void testGetSolrRangeString3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    InternalNumber minValue = mock(InternalNumber.class);
    when(minValue.toPlainString()).thenReturn("2.3");

    // Act
    String actualSolrRangeString = solrHelperServiceImpl.getSolrRangeString("Field Name", minValue,
        new BigDecimal("2.3"));

    // Assert
    verify(minValue).toPlainString();
    assertEquals("Field Name:[2.3 TO 2.3]", actualSolrRangeString);
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrRangeFunctionString(BigDecimal, BigDecimal)}
   */
  @Test
  public void testGetSolrRangeFunctionString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    BigDecimal minValue = new BigDecimal("2.3");

    // Act and Assert
    assertEquals("frange incl=false l=2.3 u=2.3",
        solrHelperServiceImpl.getSolrRangeFunctionString(minValue, new BigDecimal("2.3")));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrRangeFunctionString(BigDecimal, BigDecimal)}
   */
  @Test
  public void testGetSolrRangeFunctionString2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act and Assert
    assertEquals("frange incl=false l=2.3",
        solrHelperServiceImpl.getSolrRangeFunctionString(new BigDecimal("2.3"), null));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrRangeFunctionString(BigDecimal, BigDecimal)}
   */
  @Test
  public void testGetSolrRangeFunctionString3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    InternalNumber minValue = mock(InternalNumber.class);
    when(minValue.toPlainString()).thenReturn("2.3");

    // Act
    String actualSolrRangeFunctionString = solrHelperServiceImpl.getSolrRangeFunctionString(minValue,
        new BigDecimal("2.3"));

    // Assert
    verify(minValue).toPlainString();
    assertEquals("frange incl=false l=2.3 u=2.3", actualSolrRangeFunctionString);
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrFieldTag() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new SolrHelperServiceImpl()).getSolrFieldTag(null, null, null));
    assertEquals("", (new SolrHelperServiceImpl()).getSolrFieldTag("Field Name", null, null));
    assertEquals("{!Param=Field Name}", (new SolrHelperServiceImpl()).getSolrFieldTag("Field Name", "Param", null));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrFieldTag2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    SearchFacetRangeImpl range = new SearchFacetRangeImpl();
    range.setId(1L);
    range.setMinValue(new BigDecimal("2.3"));
    range.setSearchFacet(new SearchFacetImpl());
    range.setMaxValue(null);

    // Act and Assert
    assertEquals("{!ex=Field Name Param=Field Name[2.3:*] frange incl=false l=2.3}",
        solrHelperServiceImpl.getSolrFieldTag("Field Name", "Param", range));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrFieldTag3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    SearchFacetRangeImpl range = new SearchFacetRangeImpl();
    range.setId(1L);
    range.setMinValue(new BigDecimal("2.3"));
    range.setSearchFacet(new SearchFacetImpl());
    range.setMaxValue(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals("{!ex=Field Name Param=Field Name[2.3:2.3] frange incl=false l=2.3 u=2.3}",
        solrHelperServiceImpl.getSolrFieldTag("Field Name", "Param", range));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrFieldTag4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetRangeImpl range = mock(SearchFacetRangeImpl.class);
    when(range.getMaxValue()).thenReturn(new BigDecimal("2.3"));
    when(range.getMinValue()).thenReturn(new BigDecimal("2.3"));

    // Act
    String actualSolrFieldTag = solrHelperServiceImpl.getSolrFieldTag("Field Name", "Param", range);

    // Assert
    verify(range, atLeast(1)).getMaxValue();
    verify(range, atLeast(1)).getMinValue();
    assertEquals("{!ex=Field Name Param=Field Name[2.3:2.3] frange incl=false l=2.3 u=2.3}", actualSolrFieldTag);
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrFieldTag5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetRangeImpl range = mock(SearchFacetRangeImpl.class);
    when(range.getMaxValue()).thenReturn(new BigDecimal("2.3"));
    when(range.getMinValue()).thenReturn(new BigDecimal("2.3"));

    // Act
    String actualSolrFieldTag = solrHelperServiceImpl.getSolrFieldTag(" u=", "Param", range);

    // Assert
    verify(range, atLeast(1)).getMaxValue();
    verify(range, atLeast(1)).getMinValue();
    assertEquals("{!ex= u= Param= u=[2.3:2.3] frange incl=false l=2.3 u=2.3}", actualSolrFieldTag);
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#buildSolrFacetField(String, String)}
   */
  @Test
  public void testBuildSolrFacetField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("{!Param=Field Name}", (new SolrHelperServiceImpl()).buildSolrFacetField("Field Name", "Param"));
    assertEquals("{!ex=Field Name}", (new SolrHelperServiceImpl()).buildSolrFacetField("Field Name", null));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)}
   */
  @Test
  public void testBuildSolrFacetQuery() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetRangeImpl range = mock(SearchFacetRangeImpl.class);
    when(range.getMaxValue()).thenReturn(new BigDecimal("2.3"));
    when(range.getMinValue()).thenReturn(new BigDecimal("2.3"));

    // Act
    String actualBuildSolrFacetQueryResult = solrHelperServiceImpl.buildSolrFacetQuery("Field Name", range, true,
        "Param");

    // Assert
    verify(range, atLeast(1)).getMaxValue();
    verify(range, atLeast(1)).getMinValue();
    assertEquals("{!ex=Field Name Param=Field Name[2.3:2.3] frange incl=false l=2.3 u=2.3}",
        actualBuildSolrFacetQueryResult);
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)}
   */
  @Test
  public void testBuildSolrFacetQuery2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetRangeImpl range = mock(SearchFacetRangeImpl.class);
    when(range.getMaxValue()).thenReturn(null);
    when(range.getMinValue()).thenReturn(new BigDecimal("2.3"));

    // Act
    String actualBuildSolrFacetQueryResult = solrHelperServiceImpl.buildSolrFacetQuery("Field Name", range, true,
        "Param");

    // Assert
    verify(range, atLeast(1)).getMaxValue();
    verify(range, atLeast(1)).getMinValue();
    assertEquals("{!ex=Field Name Param=Field Name[2.3:*] frange incl=false l=2.3}", actualBuildSolrFacetQueryResult);
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)}
   */
  @Test
  public void testBuildSolrFacetQuery3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetRangeImpl range = mock(SearchFacetRangeImpl.class);
    when(range.getMaxValue()).thenReturn(new BigDecimal("2.3"));
    when(range.getMinValue()).thenReturn(new BigDecimal("2.3"));

    // Act
    String actualBuildSolrFacetQueryResult = solrHelperServiceImpl.buildSolrFacetQuery("Field Name", range, false,
        "Param");

    // Assert
    verify(range, atLeast(1)).getMaxValue();
    verify(range, atLeast(1)).getMinValue();
    assertEquals("{Param=Field Name[2.3:2.3] frange incl=false l=2.3 u=2.3}", actualBuildSolrFacetQueryResult);
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)}
   */
  @Test
  public void testBuildSolrFacetQuery4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetRangeImpl range = mock(SearchFacetRangeImpl.class);
    when(range.getMaxValue()).thenReturn(new BigDecimal("2.3"));
    when(range.getMinValue()).thenReturn(new BigDecimal("2.3"));

    // Act
    String actualBuildSolrFacetQueryResult = solrHelperServiceImpl.buildSolrFacetQuery("Field Name", range, true,
        " u=");

    // Assert
    verify(range, atLeast(1)).getMaxValue();
    verify(range, atLeast(1)).getMinValue();
    assertEquals("{!ex=Field Name  u==Field Name[2.3:2.3] frange incl=false l=2.3 u=2.3}",
        actualBuildSolrFacetQueryResult);
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)}
   */
  @Test
  public void testBuildSolrFacetQuery5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetRangeImpl range = mock(SearchFacetRangeImpl.class);
    when(range.getMaxValue()).thenReturn(new BigDecimal("2.3"));
    when(range.getMinValue()).thenReturn(new BigDecimal("2.3"));

    // Act
    String actualBuildSolrFacetQueryResult = solrHelperServiceImpl.buildSolrFacetQuery("Field Name", range, true, null);

    // Assert
    verify(range, atLeast(1)).getMaxValue();
    verify(range, atLeast(1)).getMinValue();
    assertEquals("{!ex=Field Name key=Field Name[2.3:2.3] frange incl=false l=2.3 u=2.3}",
        actualBuildSolrFacetQueryResult);
  }

  /**
   * Method under test: {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map)}
   */
  @Test
  public void testAttachFacets() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SolrQuery query = mock(SolrQuery.class);
    when(query.addTermsField(Mockito.<String>any())).thenReturn(new SolrQuery("foo"));
    when(query.setFacet(anyBoolean())).thenReturn(new SolrQuery("foo"));
    query.addTermsField("42");

    // Act
    solrHelperServiceImpl.attachFacets(query, new HashMap<>());

    // Assert
    verify(query).addTermsField(eq("42"));
    verify(query).setFacet(eq(true));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map, SearchCriteria)}
   */
  @Test
  public void testAttachFacets2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SolrQuery query = mock(SolrQuery.class);
    when(query.addTermsField(Mockito.<String>any())).thenReturn(new SolrQuery("foo"));
    when(query.setFacet(anyBoolean())).thenReturn(new SolrQuery("foo"));
    query.addTermsField("42");
    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();

    // Act
    solrHelperServiceImpl.attachFacets(query, namedFacetMap, new SearchCriteria());

    // Assert
    verify(query).addTermsField(eq("42"));
    verify(query).setFacet(eq(true));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrTaggedFieldString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("null", (new SolrHelperServiceImpl()).getSolrTaggedFieldString(null, null, null));
    assertEquals("Index Field", (new SolrHelperServiceImpl()).getSolrTaggedFieldString("Index Field", null, null));
    assertEquals("{!Tag=Index Field}Index Field",
        (new SolrHelperServiceImpl()).getSolrTaggedFieldString("Index Field", "Tag", null));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrTaggedFieldString2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act and Assert
    assertEquals("field(null)", solrHelperServiceImpl.getSolrTaggedFieldString(null, null, new SearchFacetRangeImpl()));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrTaggedFieldString3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    SearchFacetRangeImpl range = new SearchFacetRangeImpl();
    range.setId(1L);
    range.setMinValue(new BigDecimal("2.3"));
    range.setSearchFacet(new SearchFacetImpl());
    range.setMaxValue(null);

    // Act and Assert
    assertEquals("{!ex=Index Field Tag=Index Field[2.3:*] frange incl=false l=2.3}field(Index Field)",
        solrHelperServiceImpl.getSolrTaggedFieldString("Index Field", "Tag", range));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrTaggedFieldString4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    SearchFacetRangeImpl range = new SearchFacetRangeImpl();
    range.setId(1L);
    range.setMinValue(new BigDecimal("2.3"));
    range.setSearchFacet(new SearchFacetImpl());
    range.setMaxValue(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals("{!ex=Index Field Tag=Index Field[2.3:2.3] frange incl=false l=2.3 u=2.3}field(Index Field)",
        solrHelperServiceImpl.getSolrTaggedFieldString("Index Field", "Tag", range));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrTaggedFieldString5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetRangeImpl range = mock(SearchFacetRangeImpl.class);
    when(range.getMaxValue()).thenReturn(new BigDecimal("2.3"));
    when(range.getMinValue()).thenReturn(new BigDecimal("2.3"));

    // Act
    String actualSolrTaggedFieldString = solrHelperServiceImpl.getSolrTaggedFieldString("Index Field", "Tag", range);

    // Assert
    verify(range, atLeast(1)).getMaxValue();
    verify(range, atLeast(1)).getMinValue();
    assertEquals("{!ex=Index Field Tag=Index Field[2.3:2.3] frange incl=false l=2.3 u=2.3}field(Index Field)",
        actualSolrTaggedFieldString);
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrTaggedFieldString6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetRangeImpl range = mock(SearchFacetRangeImpl.class);
    when(range.getMaxValue()).thenReturn(new BigDecimal("2.3"));
    when(range.getMinValue()).thenReturn(new BigDecimal("2.3"));

    // Act
    String actualSolrTaggedFieldString = solrHelperServiceImpl.getSolrTaggedFieldString(" u=", "Tag", range);

    // Assert
    verify(range, atLeast(1)).getMaxValue();
    verify(range, atLeast(1)).getMinValue();
    assertEquals("{!ex= u= Tag= u=[2.3:2.3] frange incl=false l=2.3 u=2.3}field( u=)", actualSolrTaggedFieldString);
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getResponseDocuments(QueryResponse)}
   */
  @Test
  public void testGetResponseDocuments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act and Assert
    assertNull(solrHelperServiceImpl.getResponseDocuments(new QueryResponse()));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getResponseDocuments(QueryResponse)}
   */
  @Test
  public void testGetResponseDocuments2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act and Assert
    assertNull(solrHelperServiceImpl.getResponseDocuments(new QueryResponse(mock(LBHttp2SolrClient.class))));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getResponseDocuments(QueryResponse)}
   */
  @Test
  public void testGetResponseDocuments3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    new SolrServerException("An error occurred");
    QueryResponse response = mock(QueryResponse.class);
    when(response.getGroupResponse()).thenReturn(new GroupResponse());

    // Act
    List<SolrDocument> actualResponseDocuments = solrHelperServiceImpl.getResponseDocuments(response);

    // Assert
    verify(response, atLeast(1)).getGroupResponse();
    assertTrue(actualResponseDocuments.isEmpty());
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getResponseDocuments(QueryResponse)}
   */
  @Test
  public void testGetResponseDocuments4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    new SolrServerException("An error occurred");

    GroupResponse groupResponse = new GroupResponse();
    groupResponse.add(new GroupCommand("Name", 1));
    QueryResponse response = mock(QueryResponse.class);
    when(response.getGroupResponse()).thenReturn(groupResponse);

    // Act
    List<SolrDocument> actualResponseDocuments = solrHelperServiceImpl.getResponseDocuments(response);

    // Assert
    verify(response, atLeast(1)).getGroupResponse();
    assertTrue(actualResponseDocuments.isEmpty());
  }

  /**
   * Method under test: {@link SolrHelperServiceImpl#getSortableFieldTypes()}
   */
  @Test
  public void testGetSortableFieldTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    List<String> actualSortableFieldTypes = (new SolrHelperServiceImpl()).getSortableFieldTypes();

    // Assert
    assertEquals(5, actualSortableFieldTypes.size());
    assertEquals("i", actualSortableFieldTypes.get(3));
    assertEquals("l", actualSortableFieldTypes.get(4));
    assertEquals("p", actualSortableFieldTypes.get(2));
    assertEquals("s", actualSortableFieldTypes.get(1));
    assertEquals("sort", actualSortableFieldTypes.get(0));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSortOrder(String[], String)}
   */
  @Test
  public void testGetSortOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(SolrQuery.ORDER.asc,
        (new SolrHelperServiceImpl()).getSortOrder(new String[]{"Sort Fields Segments"}, "Sort Query"));
    assertEquals(SolrQuery.ORDER.desc,
        (new SolrHelperServiceImpl()).getSortOrder(new String[]{"Sort Fields Segments", "desc"}, null));
    assertEquals(SolrQuery.ORDER.asc, (new SolrHelperServiceImpl()).getSortOrder(
        new String[]{"Solr sortquery received was ", ", but no sorting tokens could be extracted."}, "Sort Query"));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}
   */
  @Test
  public void testGetSolrFieldKeyMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchCriteria searchCriteria = new SearchCriteria();

    // Act and Assert
    assertTrue(solrHelperServiceImpl.getSolrFieldKeyMap(searchCriteria, new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}
   */
  @Test
  public void testGetSolrFieldKeyMap2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchCriteria searchCriteria = mock(SearchCriteria.class);

    // Act and Assert
    assertTrue(solrHelperServiceImpl.getSolrFieldKeyMap(searchCriteria, new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}
   */
  @Test
  public void testGetSolrFieldKeyMap3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchCriteria searchCriteria = new SearchCriteria();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertTrue(solrHelperServiceImpl.getSolrFieldKeyMap(searchCriteria, fields).isEmpty());
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}
   */
  @Test
  public void testGetSolrFieldKeyMap4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchCriteria searchCriteria = new SearchCriteria();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertTrue(solrHelperServiceImpl.getSolrFieldKeyMap(searchCriteria, fields).isEmpty());
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getNamedFacetMap(List, SearchCriteria)}
   */
  @Test
  public void testGetNamedFacetMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();

    // Act and Assert
    assertTrue(solrHelperServiceImpl.getNamedFacetMap(facets, new SearchCriteria()).isEmpty());
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getNamedFacetMap(List, SearchCriteria)}
   */
  @Test
  public void testGetNamedFacetMap2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act and Assert
    assertTrue(solrHelperServiceImpl.getNamedFacetMap(new ArrayList<>(), mock(SearchCriteria.class)).isEmpty());
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#attachActiveFacetFilters(SolrQuery, Map, SearchCriteria)}
   */
  @Test
  public void testAttachActiveFacetFilters() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SolrQuery query = mock(SolrQuery.class);
    when(query.addTermsField(Mockito.<String>any())).thenReturn(new SolrQuery("foo"));
    query.addTermsField("42");
    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();

    // Act
    solrHelperServiceImpl.attachActiveFacetFilters(query, namedFacetMap, new SearchCriteria());

    // Assert that nothing has changed
    verify(query).addTermsField(eq("42"));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#getPropertyValueInternal(Object, String[], int)}
   */
  @Test
  public void testGetPropertyValueInternal()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SolrHelperServiceImpl()).getPropertyValueInternal(null, new String[]{"Components"}, 1));
    assertNull((new SolrHelperServiceImpl()).getPropertyValueInternal("Object", new String[]{"Components"}, 0));
    assertNull((new SolrHelperServiceImpl()).getPropertyValueInternal("Object",
        new String[]{"Components", "exploitProtection.xssEnabled"}, 1));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#copyPropertyToCollection(Collection, Object)}
   */
  @Test
  public void testCopyPropertyToCollection() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    ArrayList<Object> collection = new ArrayList<>();

    // Act
    solrHelperServiceImpl.copyPropertyToCollection(collection, "42");

    // Assert
    assertEquals(1, collection.size());
    assertEquals("42", collection.get(0));
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#copyPropertyToCollection(Collection, Object)}
   */
  @Test
  public void testCopyPropertyToCollection2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    ArrayList<Object> collection = new ArrayList<>();

    // Act
    solrHelperServiceImpl.copyPropertyToCollection(collection, null);

    // Assert that nothing has changed
    assertTrue(collection.isEmpty());
  }

  /**
   * Method under test:
   * {@link SolrHelperServiceImpl#copyPropertyToCollection(Collection, Object)}
   */
  @Test
  public void testCopyPropertyToCollection3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act
    solrHelperServiceImpl.copyPropertyToCollection(collection, "42");

    // Assert
    assertEquals(2, collection.size());
    assertEquals("42", collection.get(0));
    assertEquals("42", collection.get(1));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SolrHelperServiceImpl#getCatalogFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getCatalogOverridesFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getCategoryFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getExplicitCategoryFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getGlobalFacetTagField()}
   *   <li>{@link SolrHelperServiceImpl#getIdFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getIndexableIdFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getNamespaceFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getSandBoxChangeTypeFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getSandBoxFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getSandBoxPriorityFieldName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act
    String actualCatalogFieldName = solrHelperServiceImpl.getCatalogFieldName();
    String actualCatalogOverridesFieldName = solrHelperServiceImpl.getCatalogOverridesFieldName();
    String actualCategoryFieldName = solrHelperServiceImpl.getCategoryFieldName();
    String actualExplicitCategoryFieldName = solrHelperServiceImpl.getExplicitCategoryFieldName();
    String actualGlobalFacetTagField = solrHelperServiceImpl.getGlobalFacetTagField();
    String actualIdFieldName = solrHelperServiceImpl.getIdFieldName();
    String actualIndexableIdFieldName = solrHelperServiceImpl.getIndexableIdFieldName();
    String actualNamespaceFieldName = solrHelperServiceImpl.getNamespaceFieldName();
    String actualSandBoxChangeTypeFieldName = solrHelperServiceImpl.getSandBoxChangeTypeFieldName();
    String actualSandBoxFieldName = solrHelperServiceImpl.getSandBoxFieldName();

    // Assert
    assertEquals("a", actualGlobalFacetTagField);
    assertEquals("catalog_overrides", actualCatalogOverridesFieldName);
    assertEquals("catalog_s", actualCatalogFieldName);
    assertEquals("category", actualCategoryFieldName);
    assertEquals("explicitCategory", actualExplicitCategoryFieldName);
    assertEquals("id", actualIdFieldName);
    assertEquals("namespace", actualNamespaceFieldName);
    assertEquals("productId", actualIndexableIdFieldName);
    assertEquals("sandboxChangeType_s", actualSandBoxChangeTypeFieldName);
    assertEquals("sandboxId", actualSandBoxFieldName);
    assertEquals("sandboxPriority", solrHelperServiceImpl.getSandBoxPriorityFieldName());
  }
}
