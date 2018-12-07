package cn.ok.demos.druidmybatiesdemo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 配置主数据源
 *
 * @author kyou on 2018-12-06 22:53
 */
@Configuration
@MapperScan(basePackages = "cn.ok.demos.druidmybatiesdemo.mapper.primary", sqlSessionFactoryRef = "primarySqlSessionFactory")
public class PrimaryDataSourceConfig {

    static SqlSessionFactory getSqlSessionFactory(DataSource dataSource) {
        final SqlSessionFactoryBean ccmSessionFactoryBean = new SqlSessionFactoryBean();

        org.apache.ibatis.session.Configuration ccmConfig = new org.apache.ibatis.session.Configuration();
        ccmConfig.setMapUnderscoreToCamelCase(true);
        ccmConfig.setCallSettersOnNulls(true);
        ccmSessionFactoryBean.setConfiguration(ccmConfig);
        ccmSessionFactoryBean.setDataSource(dataSource);
        try {
            return ccmSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Primary
    @Bean("primaryDataSource")
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource primaryDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "primaryTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("primaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "primarySqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource) {
        return getSqlSessionFactory(dataSource);
    }
}
