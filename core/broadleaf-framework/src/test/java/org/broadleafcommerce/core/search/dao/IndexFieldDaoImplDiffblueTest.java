package org.broadleafcommerce.core.search.dao;

import org.broadleafcommerce.core.search.domain.Field;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class IndexFieldDaoImplDiffblueTest {
  @Autowired
  private IndexFieldDaoImpl indexFieldDaoImpl;

  /**
   * Test {@link IndexFieldDaoImpl#readIndexFieldForField(Field)}.
   * <p>
   * Method under test: {@link IndexFieldDaoImpl#readIndexFieldForField(Field)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadIndexFieldForField() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5700 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.IndexFieldDaoImpl indexFieldDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    IndexFieldDaoImpl indexFieldDaoImpl2 = new IndexFieldDaoImpl();

    // Act
    indexFieldDaoImpl2.readIndexFieldForField(new FieldImpl());
  }

  /**
   * Test {@link IndexFieldDaoImpl#readIndexFieldByFieldId(Long)}.
   * <p>
   * Method under test: {@link IndexFieldDaoImpl#readIndexFieldByFieldId(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadIndexFieldByFieldId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5685 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.IndexFieldDaoImpl indexFieldDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new IndexFieldDaoImpl()).readIndexFieldByFieldId(1L);
  }

  /**
   * Test {@link IndexFieldDaoImpl#readAllIndexFieldsByFieldId(Long)}.
   * <p>
   * Method under test:
   * {@link IndexFieldDaoImpl#readAllIndexFieldsByFieldId(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllIndexFieldsByFieldId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5611 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.IndexFieldDaoImpl indexFieldDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new IndexFieldDaoImpl()).readAllIndexFieldsByFieldId(1L);
  }

  /**
   * Test {@link IndexFieldDaoImpl#readFieldsByEntityType(FieldEntity)}.
   * <p>
   * Method under test:
   * {@link IndexFieldDaoImpl#readFieldsByEntityType(FieldEntity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadFieldsByEntityType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5626 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.IndexFieldDaoImpl indexFieldDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new IndexFieldDaoImpl()).readFieldsByEntityType(FieldEntity.CATEGORY);
  }

  /**
   * Test {@link IndexFieldDaoImpl#readSearchableFieldsByEntityType(FieldEntity)}.
   * <p>
   * Method under test:
   * {@link IndexFieldDaoImpl#readSearchableFieldsByEntityType(FieldEntity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadSearchableFieldsByEntityType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5713 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.IndexFieldDaoImpl indexFieldDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new IndexFieldDaoImpl()).readSearchableFieldsByEntityType(FieldEntity.CATEGORY);
  }

  /**
   * Test {@link IndexFieldDaoImpl#getIndexFieldTypesByAbbreviation(String)}.
   * <p>
   * Method under test:
   * {@link IndexFieldDaoImpl#getIndexFieldTypesByAbbreviation(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetIndexFieldTypesByAbbreviation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5534 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.IndexFieldDaoImpl indexFieldDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new IndexFieldDaoImpl()).getIndexFieldTypesByAbbreviation("Abbreviation");
  }

  /**
   * Test
   * {@link IndexFieldDaoImpl#getIndexFieldTypesByAbbreviationAndEntityType(String, FieldEntity)}.
   * <p>
   * Method under test:
   * {@link IndexFieldDaoImpl#getIndexFieldTypesByAbbreviationAndEntityType(String, FieldEntity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetIndexFieldTypesByAbbreviationAndEntityType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5564 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.IndexFieldDaoImpl indexFieldDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new IndexFieldDaoImpl()).getIndexFieldTypesByAbbreviationAndEntityType("Abbreviation", FieldEntity.CATEGORY);
  }

  /**
   * Test
   * {@link IndexFieldDaoImpl#getIndexFieldTypesByAbbreviationOrPropertyName(String)}.
   * <p>
   * Method under test:
   * {@link IndexFieldDaoImpl#getIndexFieldTypesByAbbreviationOrPropertyName(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetIndexFieldTypesByAbbreviationOrPropertyName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5581 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.IndexFieldDaoImpl indexFieldDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new IndexFieldDaoImpl()).getIndexFieldTypesByAbbreviationOrPropertyName("Name");
  }

  /**
   * Test {@link IndexFieldDaoImpl#getIndexFieldTypes(FieldType)}.
   * <p>
   * Method under test: {@link IndexFieldDaoImpl#getIndexFieldTypes(FieldType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetIndexFieldTypes() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5514 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.IndexFieldDaoImpl indexFieldDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new IndexFieldDaoImpl()).getIndexFieldTypes(FieldType.BOOLEAN);
  }

  /**
   * Test {@link IndexFieldDaoImpl#readIndexFieldByAbbreviation(String)}.
   * <p>
   * Method under test:
   * {@link IndexFieldDaoImpl#readIndexFieldByAbbreviation(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadIndexFieldByAbbreviation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5638 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.IndexFieldDaoImpl indexFieldDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new IndexFieldDaoImpl()).readIndexFieldByAbbreviation("Abbreviation");
  }

  /**
   * Test
   * {@link IndexFieldDaoImpl#readIndexFieldByAbbreviationAndEntityType(String, FieldEntity)}.
   * <p>
   * Method under test:
   * {@link IndexFieldDaoImpl#readIndexFieldByAbbreviationAndEntityType(String, FieldEntity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadIndexFieldByAbbreviationAndEntityType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5668 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.IndexFieldDaoImpl indexFieldDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new IndexFieldDaoImpl()).readIndexFieldByAbbreviationAndEntityType("Abbreviation", FieldEntity.CATEGORY);
  }
}
