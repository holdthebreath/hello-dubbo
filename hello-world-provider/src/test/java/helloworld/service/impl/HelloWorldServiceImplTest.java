package helloworld.service.impl;

import helloworld.HelloWorldProviderApplication;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloWorldProviderApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HelloWorldServiceImplTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;

//    @Autowired
//    UserDaoMapper userDaoMapper;

    //初始化hbase client
    Connection connection;
    Admin admin;
    static String userId;
    Table table;

    @Before
    public void setUp() throws Exception {
        // 取得一个数据库连接的配置参数对象
        Configuration conf = HBaseConfiguration.create();
        // 设置连接参数：HBase数据库所在的主机IP
        conf.set("hbase.zookeeper.quorum", "127.0.0.1");
        // 设置连接参数：HBase数据库使用的端口
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        // 取得一个数据库连接对象
        connection = ConnectionFactory.createConnection(conf);
        // 取得一个数据库元数据操作对象
        admin = connection.getAdmin();

        table = connection.getTable(TableName.valueOf("user"));
    }


//    @Test
//    public void contextLoads() throws Exception {
    //数据源
//        System.out.println("数据源： " + dataSource.getClass());
    //获取数据库连接
//        Connection connection = dataSource.getConnection();
//        System.out.println("获取连接： " + connection);
//        List<Map<String,Object>> maps=jdbcTemplate.queryForList("SELECT count(1) from user");
//        System.out.println("结果：" + maps.get(0));

//        getConnection();

//        Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
//        Connection connection = DriverManager.getConnection("jdbc:phoenix:127.0.0.1:2181");
//        System.out.println("phoenix连接为: " + connection);
//    }

    @Test
    public void test1() throws IOException {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * from user");
        userId = (String) maps.get((int) Math.round(Math.random() * maps.size())).get("id");
        System.out.println(userId);
        System.out.println("---------------插入数据 START-----------------");
        Put put = new Put(userId.getBytes());
        put.addColumn("score".getBytes(), "math".getBytes(), ((int) Math.round(Math.random() * 100) + "").getBytes());
        put.addColumn("score".getBytes(), "english".getBytes(), ((int) Math.round(Math.random() * 100) + "").getBytes());
        put.addColumn("score".getBytes(), "chinese".getBytes(), ((int) Math.round(Math.random() * 100) + "").getBytes());
        table.put(put);
        System.out.println("---------------插入数据 END-----------------");
    }

    @Test
    public void test2() throws IOException {
        System.out.println("---------------查询整表数据 START-----------------");
        // 取得表中所有数据
        ResultScanner resultScanner = table.getScanner(new Scan());
        // 循环输出表中的数据
        for (Result result : resultScanner) {
            byte[] row = result.getRow();
            System.out.println("row key is:" + new String(row));
            List<Cell> listCells = result.listCells();
            for (Cell cell : listCells) {
                byte[] familyArray = cell.getFamilyArray();
                byte[] qualifierArray = cell.getQualifierArray();
                byte[] valueArray = cell.getValueArray();
                System.out.println("row value is:" + new String(familyArray) + new String(qualifierArray)
                        + new String(valueArray));
            }
        }
        System.out.println("---------------查询整表数据 END-----------------");
    }

    @Test
    public void test3() throws IOException {
        System.out.println("---------------更新(put)数据 START-----------------");
        Put put = new Put(userId.getBytes());
        put.addColumn("score".getBytes(), "math".getBytes(), ((int) Math.round(Math.random() * 100) + "").getBytes());
        put.addColumn("score".getBytes(), "english".getBytes(), ((int) Math.round(Math.random() * 100) + "").getBytes());
        put.addColumn("score".getBytes(), "chinese".getBytes(), ((int) Math.round(Math.random() * 100) + "").getBytes());
        table.put(put);
        System.out.println("---------------更新(put)数据 END-----------------");
    }

    @Test
    public void test4() throws IOException {
        test2();
    }

    @Test
    public void test5() throws IOException {
        System.out.println("---------------删除数据 START-----------------");
        Delete delete = new Delete(userId.getBytes());
        table.delete(delete);
        System.out.println("---------------删除数据 END-----------------");
    }

    @After
    public void closeConnection() throws IOException {
        table.close();
        connection.close();
        admin.close();
    }
}