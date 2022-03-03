package config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@SpringBootApplication
@ComponentScan({"controller", "dao"})
@MapperScan("mapper")
public class CRMConfig {
	@Bean
	public DataSource dataSrc() throws SQLException {
		DataSource ds = new EmbeddedDatabaseBuilder().addScript("classpath:potentialLeads.sql").build();
		ds.getConnection().setAutoCommit(true);
		return ds;
	}
	@Bean
    public JdbcTemplate getJdbcTemplate() throws Exception {
        return new JdbcTemplate(dataSrc());
    } 
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setTypeAliasesPackage("vo");
		sessionFactory.setDataSource(dataSrc());
		return sessionFactory.getObject();
	}
}
