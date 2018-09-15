package org.ganiev.springboottest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ganiev.springboottest.config.DataSourceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource({ "classpath:application-test.properties" })
@ContextConfiguration(classes = DataSourceConfig.class)
@Sql(scripts = {"classpath:schema-h2.sql", "classpath:data-h2.sql"})
public class InMemoryTransactionTest {

    private static final Log LOGGER = LogFactory.getLog(InMemoryTransactionTest.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void testProcess_Mainflow_dataInserted() {

        jdbcTemplate.queryForList("select * from student");

    }

}
