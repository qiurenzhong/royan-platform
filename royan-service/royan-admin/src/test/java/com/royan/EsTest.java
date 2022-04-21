//package com.royan;
//
//import com.frameworkset.orm.annotation.ESId;
//import com.frameworkset.orm.annotation.ESIndex;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.frameworkset.elasticsearch.ElasticSearchHelper;
//import org.frameworkset.elasticsearch.boot.BBossESStarter;
//import org.frameworkset.elasticsearch.client.ClientInterface;
//import org.frameworkset.elasticsearch.entity.ESDatas;
//import org.frameworkset.elasticsearch.scroll.HandlerInfo;
//import org.frameworkset.elasticsearch.scroll.ParralBreakableScrollHandler;
//import org.frameworkset.elasticsearch.scroll.ScrollHandler;
//import org.frameworkset.elasticsearch.scroll.SerialBreakableScrollHandler;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.*;
//import java.util.concurrent.atomic.AtomicInteger;
//
//
///**
// * @author Qiurz
// * @date 2021/4/26
// */
//@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class EsTest {
//
//    @Autowired
//    private BBossESStarter bbossESStarter;
//
//
//    @Test
//    public void testClient() throws Exception {
//
//        ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
//
//        Assert.assertNotNull(clientUtil);
//
//
//    }
//
//
//    @Test
//    public void testCreateIndex(){
//        //通过bbossESStarter获取ClientInterface接口实例：Build a create/modify/get/delete document client object, single instance multi-thread security
//        ClientInterface clientUtil = bbossESStarter.getRestClient();
//
//        TAgentInfo agentInfo = new TAgentInfo() ;
//        agentInfo.setIp("192.168.137.1");//ip属性作为文档唯一标识，根据ip值对应的索引文档存在与否来决定添加或者修改操作
//        //设置地理位置坐标
//        agentInfo.setLocation("28.292781,117.238963");
//        //设置其他属性
//        //添加/修改文档
//        clientUtil.addDocument("agentinfo",//索引名称
//                "agentinfo",//索引类型
//                agentInfo);//索引数据对象
//
//        clientUtil.addDocument("agentinfo",//索引名称
//                "agentinfo",//索引类型
//                agentInfo,//索引数据对象
//                "refresh=true");//强制实时刷新
//
//
//        //删除索引文档
//        clientUtil.deleteDocument("agentinfo",//索引表
//                "agentinfo",//索引类型
//                "192.168.137.1");//文档id
//
//        //批量删除索引文档
//        clientUtil.deleteDocuments("agentinfo",//索引表
//                "agentinfo",//索引类型
//                new String[]{"192.168.137.1","192.168.137.2","192.168.137.3"});//文档ids
//    }
//
//
//    //TAgentInfo的结构如下：
//    @Data
//    public class TAgentInfo implements java.io.Serializable{
//        private String hostname;
//        @ESId   //ip属性作为文档唯一标识，根据ip值对应的索引文档存在与否来决定添加或者修改操作
//        private String ip;
//        private String ports;
//        private String agentId;
//        private String location;
//        private String applicationName;
//        private int serviceType;
//        private int pid;
//        private String agentVersion;
//        private String vmVersion;
//        //日期类型
//        private Date startTimestampDate;
//        private Date endTimestampDate;
//        private long startTimestamp;
//        private long endTimestamp;
//        private int endStatus;
//        private String serverMetaData;
//        private String jvmInfo;
//    }
//
//    @Data
//    @NoArgsConstructor
//    @ESIndex(name="demo",type="demo")
//    static class Demo implements java.io.Serializable{
//        @ESId
//        private long demoId;
//        private Date agentStarttime;
//        private String applicationName;
//        private String contentbody;
//        private String name;
//    }
//
//
//    @Test
//    public void testBatchCreateIndex(){
//        ClientInterface clientUtil = bbossESStarter.getRestClient();
//
//        List<Demo> demos = new ArrayList<>();
//        Demo demo = new Demo();
//        demo.setDemoId(2l);
//        demo.setAgentStarttime(new Date());
//        demo.setApplicationName("blackcatdemo2");
//        demo.setContentbody("this is content body2");
//        demo.setName("刘德华");
//        demos.add(demo);
//        demo = new Demo();
//        demo.setDemoId(3l);
//        demo.setAgentStarttime(new Date());
//        demo.setApplicationName("blackcatdemo3");
//        demo.setContentbody("四大天王，这种文化很好，中华人民共和国");
//        demo.setName("张学友");
//        demos.add(demo);
//        //批量添加/修改文档
//        String response = clientUtil.addDocuments("demo",//索引表
//                demos);
//        System.out.println(response);
//
//    }
//
//
//    @Test
//    public void testGetDemo(){
//        ClientInterface clientUtil = bbossESStarter.getRestClient();
//        //根据文档id获取文档对象，返回Demo对象
//        Demo demo = clientUtil.getDocument("demo",//索引表
//                "2",//文档id
//                Demo.class);
//        System.out.println(demo);
//        //根据文档id获取文档对象，返回Map对象
//        Map map = clientUtil.getDocument("demo",//索引表
//                "3",//文档id
//                Map.class);
//        System.out.println(map);
//
//    }
//
//
//    @Test
//    public void testDelDemo(){
//
//        ClientInterface clientUtil = bbossESStarter.getRestClient();
//
//        //删除索引文档
//        clientUtil.deleteDocumentNew("demo","3");
//
//        //批量删除文档
//        clientUtil.deleteDocuments("demo",//索引表
//                new String[]{"2","3"});//批量删除文档ids
//
//
//    }
//
//    /**
//     *  分页查询
//     */
//    @SneakyThrows
//    @Test
//    public void testSearch(){
//
//        //创建加载配置文件的客户端工具，用来检索文档，单实例多线程安全
//        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/demo.xml");
//
//        Map<String,Object> params = new HashMap<String,Object>();
//        //设置applicationName1和applicationName2两个变量的值
//        params.put("applicationName1","blackcatdemo2");
//        params.put("applicationName2","blackcatdemo3");
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        //设置时间范围,时间参数接受long值
//        params.put("startTime",dateFormat.parse("2017-09-02 00:00:00"));
//        params.put("endTime",new Date());
//
//        ESDatas<Demo> esDatas = null;//返回的文档封装对象类型
//        //保存总记录数
//        long totalSize = 0;
//        //保存每页结果对象列表，最多返回1000条记录
//        List<Demo> demos = null;
//        int i = 0; //页码
//        do{//遍历获取每页的记录
//            //设置分页参数
//            params.put("from",i * 1000);//分页起点
//            params.put("size",1000);//每页返回1000条
//            i ++;//往前加页码
//            //执行查询，demo为索引表，_search为检索操作action
//            esDatas =  //ESDatas包含当前检索的记录集合，最多1000条记录，由dsl中的size属性指定
//                    clientUtil.searchList("demo/_search",//demo为索引表，_search为检索操作action
//                            "searchPagineDatas",//esmapper/demo.xml中定义的dsl语句
//                            params,//变量参数
//                            Demo.class);//返回的文档封装对象类型
//            demos = esDatas.getDatas();//每页结果对象列表，最多返回1000条记录
//            System.out.println(demos);
//            totalSize = esDatas.getTotalSize();//总记录数
//            if(i * 1000 > totalSize)
//                break;
//        }while(true);
//
//        System.out.println(totalSize);
//
//    }
//
//    @Test
//    public void testSimleScrollAPI(){
//        ClientInterface clientInterface = ElasticSearchHelper.getConfigRestClientUtil("esmapper/scroll.xml");
//
//        // scroll分页检索
//        Map params = new HashMap();
//        //每页10000条记录
//        params.put("size",10000);
//        //scroll上下文有效期1分钟,每次scroll检索的结果都会合并到总得结果集中；
//        //数据量大时存在oom内存溢出风险，大数据量时可以采用handler函数来处理每次scroll检索的结果(后面介绍)
//        ESDatas<Map> response = clientInterface.scroll("demo/_search","scrollQuery","1m",params,Map.class);
//
//        List<Map> datas = response.getDatas();
//        long realTotalSize = datas.size();
//        long totalSize = response.getTotalSize();
//        System.out.println(datas);
//        System.out.println("totalSize:"+totalSize);
//        System.out.println("realTotalSize:"+realTotalSize);
//        System.out.println("countAll:"+clientInterface.countAll("demo"));
//
//
//    }
//
//
//    // 串行
//    @Test
//    public void testSimleScrollAPIHandler(){
//        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/scroll.xml");
//        //scroll分页检索
//
//        Map params = new HashMap();
//        params.put("size", 5000);//每页5000条记录
//        //采用自定义handler函数处理每个scroll的结果集后，response中只会包含总记录数，不会包含记录集合
//        //scroll上下文有效期1分钟；大数据量时可以采用handler函数来处理每次scroll检索的结果，规避数据量大时存在的oom内存溢出风险
//        ESDatas<Map> response = clientUtil.scroll("demo/_search", "scrollQuery", "1m", params, Map.class, new ScrollHandler<Map>() {
//            public void handle(ESDatas<Map> response, HandlerInfo handlerInfo) throws Exception {//自己处理每次scroll的结果
//                List<Map> datas = response.getDatas();
//                long totalSize = response.getTotalSize();
//                System.out.println("totalSize:"+totalSize+",datas.size:"+datas.size());
//            }
//        });
//
//        System.out.println("response realzie:"+response.getTotalSize());
//
//    }
//
//
//    @Test
//    public void testSimleBreakableScrollAPIHandler(){
//        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/scroll.xml");
//        //scroll分页检索
//        Map params = new HashMap();
//        params.put("size", 10);//每页5000条记录
//        //采用自定义handler函数处理每个scroll的结果集后，response中只会包含总记录数，不会包含记录集合
//        //scroll上下文有效期1分钟
//        final AtomicInteger count = new AtomicInteger();
//        ESDatas<Map> response = clientUtil.scroll("demo/_search", "scrollQuery", "1m", params, Map.class, new SerialBreakableScrollHandler<Map>() {
//            public void handle(ESDatas<Map> response, HandlerInfo handlerInfo) throws Exception {//自己处理每次scroll的结果
//                List<Map> datas = response.getDatas();
//                long totalSize = response.getTotalSize();
//                int test = count.incrementAndGet();
//                //final AtomicInteger count = new AtomicInteger();
//                if(test % 2 == 1) //到第三条数据时，中断scroll执行
//                    this.setBreaked(true);
//                System.out.println("totalSize:"+totalSize+",datas.size:"+datas.size());
//            }
//        });
//
//        System.out.println("response realzie:"+response.getTotalSize());
//
//    }
//
//
//    //并行
//    @Test
//    public void testSimleScrollParallelAPIHandler(){
//        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/scroll.xml");
//        //scroll分页检索
//        Map params = new HashMap();
//        params.put("size", 5000);//每页5000条记录
//        //采用自定义handler函数处理每个scroll的结果集后，response中只会包含总记录数，不会包含记录集合
//        //scroll上下文有效期1分钟
//        ESDatas<Map> response = clientUtil.scrollParallel("demo/_search", "scrollQuery", "1m", params, Map.class, new ScrollHandler<Map>() {
//            public void handle(ESDatas<Map> response, HandlerInfo handlerInfo) throws Exception {//自己处理每次scroll的结果
//                List<Map> datas = response.getDatas();
//                long totalSize = response.getTotalSize();
//                System.out.println("totalSize:"+totalSize+",datas.size:"+datas.size());
//            }
//        });
//
//        System.out.println("response realzie:"+response.getTotalSize());
//
//    }
//
//
//    //并行中断
//    @Test
//    public void testSimleBreakableScrollParallelAPIHandler(){
//        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/scroll.xml");
//        //scroll分页检索
//        Map params = new HashMap();
//        params.put("size", 10);//每页5000条记录
//        //采用自定义handler函数处理每个scroll的结果集后，response中只会包含总记录数，不会包含记录集合
//        final AtomicInteger count = new AtomicInteger();
//        //scroll上下文有效期1分钟
//        ESDatas<Map> response = clientUtil.scrollParallel("demo/_search", "scrollQuery", "1m", params, Map.class, new ParralBreakableScrollHandler<Map>() {
//            public void handle(ESDatas<Map> response, HandlerInfo handlerInfo) throws Exception {//自己处理每次scroll的结果
//                List<Map> datas = response.getDatas();
//                long totalSize = response.getTotalSize();
//                int test = count.incrementAndGet();
//                if(test % 2 == 1) //到第三条数据时，中断scroll执行
//                    this.setBreaked(true);
//                System.out.println("totalSize:"+totalSize+",datas.size:"+datas.size());
//            }
//        });
//
//        System.out.println("response realzie:"+response.getTotalSize());
//
//    }
//
//}
