# royan-platform 

诺言平台介绍
spring cloud alibaba 微服务架构

诺言系统架构
软件架构说明


#### 安装教程

1.  xxxx
2.  xxxx
3.  xxxx

#### 使用说明

1.  xxxx
2.  xxxx
3.  xxxx

#### 引入开源技术

1.  java权限认证框架（http://sa-token.dev33.cn/doc/index.html#/）



knife4j
1.注解说明
Controller层添加注解
@Api
@Api：用在请求的类上，表示对类的说明
tags="说明该类的作用，可以在UI界面上看到的注解"
value="该参数没什么意义，在UI界面上也看到，所以不需要配置"

案例
@Api(tags = "HELLO CONTROLLER 测试功能接口")
@RestController
public class HelloController {

}

@ApiOperation
@ApiOperation：用在请求的方法上，说明方法的用途、作用
value="说明方法的用途、作用"
notes="方法的备注说明"

案例
@ApiOperation(value="用户注册",notes="手机号、密码都是必输项，年龄随边填，但必须是数字")
@PostMapping(value = "/signUp")
public R SignUp(@RequestBody signUpModelVo signUpModelVo) {
}

@ApiParam
@ApiParam使用在方法上或者参数上，字段说明；表示对参数的添加元数据（说明或是否必填等）
name: 参数名
value: 参数说明
required: 是否必填

案例
@ApiOperation( value = "编辑公告", notes = "编辑公告", httpMethod = "POST" )
@PostMapping( value = "/edit")
public RequestResult edit(
@ApiParam(name = "bis_key", value = "bis_key", required = true) String bisKey,
@ApiParam(name = "title", value = "公告标题", required = true) @RequestParam String title,
@ApiParam(name = "content", value = "公告内容", required = true)  String content){

}

@ApiImplicitParams->@ApiImplicitParam
@ApiImplicitParams：用在请求的方法上，表示一组参数说明
@ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
name：参数名
value：参数的汉字说明、解释
required：参数是否必须传
paramType：参数放在哪个地方
· header --> 请求参数的获取：@RequestHeader
· query --> 请求参数的获取：@RequestParam
· path（用于restful接口）--> 请求参数的获取：@PathVariable
· body（不常用）
· form（不常用）    
dataType：参数类型，默认String，其它值dataType="Integer"       
defaultValue：参数的默认值

案例
@ApiImplicitParams({
@ApiImplicitParam(name="mobile",value="手机号",required=true,paramType="form"),
@ApiImplicitParam(name="password",value="密码",required=true,paramType="form"),
@ApiImplicitParam(name="age",value="年龄",required=true,paramType="form",dataType="Integer")
})

@ApiResponses->@ApiResponse
@ApiResponses：用于请求的方法上，表示一组响应
@ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
code：数字，例如400
message：信息，例如"请求参数没填好"
response：抛出异常的类

案例
@ApiOperation(value = "select1请求",notes = "多个参数，多种的查询参数类型")
@ApiResponses({
@ApiResponse(code=400,message="请求参数没填好"),
@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
})




Bean实体类层注解
@ApiModel->ApiModelProperty
@ApiModel：用于响应类上，表示一个返回响应数据的信息
(这种一般用在post创建的时候，使用@RequestBody这样的场景，请求参数无法使用@ApiImplicitParam注解进行描述的时候)
@ApiModelProperty：用在属性上，描述响应类的属性

案例
@ApiModel(description= "返回响应数据")
public class RestMessage implements Serializable{

    @ApiModelProperty(value = "是否成功")
    private boolean success=true;
    @ApiModelProperty(value = "返回对象")
    private Object data;
    @ApiModelProperty(value = "错误编号")
    private Integer errCode;
    @ApiModelProperty(value = "错误信息")
    private String message;
 
    /* getter/setter */
}
