//package com.royan;
//
//import cn.hutool.core.bean.BeanUtil;
//import cn.hutool.core.date.StopWatch;
//import com.alibaba.excel.EasyExcel;
//import com.alibaba.excel.read.listener.PageReadListener;
//import com.alibaba.fastjson.JSON;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.toolkit.Wrappers;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.royan.admin.api.model.SysUser;
//import com.royan.admin.api.pojo.vo.SysPermissionVO;
//import com.royan.admin.api.pojo.vo.excel.SysUserExcel;
//import com.royan.admin.provider.service.SysPermissionService;
//import com.royan.admin.provider.service.SysUserService;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Qiurz
// * @date 2020/4/4
// */
//@Slf4j
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//public class AppTest {
//
//    @Autowired
//    SysUserService sysUserService;
//    @Autowired
//    SysPermissionService sysPermissionService;
//
//
//    private List<SysUser> list = new ArrayList<>();
//    // 计数工具
//    private StopWatch sw = new StopWatch();
//
//    @Test
//    public void testUser() {
//        sw.start("批量查询 sql");
//        sysUserService.list();
//        sw.stop();
//        log.info("all cost info:{}", sw.prettyPrint());
//    }
//
//    @Test
//    public void testPageUser() {
//        log.info("----------------------------------baseMapper 自带分页-------------------------------------------------------");
//        sw.start("分页查询");
//        Page<SysUser> page = new Page<>(1, 500);
//        Page<SysUser> userIPage = sysUserService.getBaseMapper().selectPage(
//                page, Wrappers.<SysUser>lambdaQuery().like(SysUser::getUsername, "Van")
//        );
//        Assert.assertEquals(page, userIPage);
//        log.error("总条数 -------------> {}", userIPage.getTotal());
//        log.error("当前页数 -------------> {}", userIPage.getCurrent());
//        log.error("当前每页显示数 -------------> {}", userIPage.getSize());
//        List<SysUser> records = userIPage.getRecords();
//        Assert.assertNotNull(records);
//        sw.stop();
//        log.info("all cost info:{}", sw.prettyPrint());
//
//    }
//
//    @Test
//    public void testPermission() {
//        List<SysPermissionVO> list = sysPermissionService.listForRolePermission();
//        System.out.println(list);
//    }
//
//    @Test
//    public void batchInsert() {
//        sw.start("批量插入 sql");
//        sysUserService.saveBatch(list);
//        sw.stop();
//        log.info("all cost info:{}", sw.prettyPrint());
//    }
//
//    @Before
//    public void assemblyData() {
//        list = assemblyData(30000);
//    }
//
//    private List<SysUser> assemblyData(int count) {
//        List<SysUser> list = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            SysUser user = new SysUser();
//            user.setUsername("Van" + i);
//            user.setNickname("风尘博客" + i);
//            user.setMobile("17098705" + i);
//            user.setPassword("password" + i);
//            user.setDeptId(234 + i);
//            list.add(user);
//        }
//        return list;
//    }
//
//    /**
//     * 最简单的读
//     * <p>1. 创建excel对应的实体对象 参照{}
//     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link PageReadListener}
//     * <p>3. 直接读即可
//     */
//    @Test
//    public void simpleRead() {
//        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
//        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//
//        EasyExcel.read(fileName, SysUser.class, new PageReadListener<SysUser>(dataList -> {
//            for (SysUser user : dataList) {
//                log.info("读取到一条数据{}", JSON.toJSONString(user));
//            }
//        })).sheet().doRead();
//    }
//
//
//    /**
//     * 最简单的写
//     * <p>1. 创建excel对应的实体对象 参照{}
//     * <p>2. 直接写即可
//     */
//    @Test
//    public void simpleWrite() {
//        String fileName = TestFileUtil.getPath() + "write" + System.currentTimeMillis() + ".xlsx";
//        // 这里 需要指定写用哪个class去读，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
//        // 如果这里想使用03 则 传入excelType参数即可
//        EasyExcel.write(fileName, SysUserExcel.class).sheet("模板").doWrite(data());
//    }
//
//    private List<SysUserExcel> data() {
//        QueryWrapper<SysUser> wrapper = new QueryWrapper();
//        wrapper.last("limit 1000000");
//
//        List<SysUserExcel> list = new ArrayList<>();
//        List<SysUser> result = sysUserService.list(wrapper);
//        for (SysUser user : result) {
//            SysUserExcel excel = new SysUserExcel();
//            BeanUtil.copyProperties(user, excel);
//            list.add(excel);
//        }
//        return list;
//    }
//}
