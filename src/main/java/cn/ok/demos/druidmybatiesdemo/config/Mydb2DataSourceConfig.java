package cn.ok.demos.druidmybatiesdemo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

import static cn.ok.demos.druidmybatiesdemo.config.PrimaryDataSourceConfig.getSqlSessionFactory;

/**
 * 配置第二数据源
 *
 * @author kyou on 2018-12-06 22:53
 */
@Configuration
@MapperScan(basePackages = "cn.ok.demos.druidmybatiesdemo.mapper.mydb2", sqlSessionFactoryRef = "mydb2SqlSessionFactory")
public class Mydb2DataSourceConfig {


    @Bean("mydb2DataSource")
    @ConfigurationProperties("spring.datasource.druid.mydb2")
    public DataSource mydb2DataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "mydb2TransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("mydb2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "mydb2SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("mydb2DataSource") DataSource dataSource) {
        return getSqlSessionFactory(dataSource);
    }
}
