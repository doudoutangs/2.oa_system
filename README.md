# [OA系统](https://gitee.com/doudoutang/bankOA)

## 一、系统简介
本系统为银行内部OA系统，系统分为六大模块：公文管理，资产管理，辅助办公，档案管理，个人中心，系统管理。
本系统有完整的权限验证及灵活的系统配置功能。系统角色默认有管理员，资产管理员，资产盘点员，主任，普通用户
- 管理员（admin/admin）：可以看到和操作所有菜单
- 资产管理员(zichanguanli/zichanguanli)：只可看到和操作资产管理下的资产仓库菜单
- 资产盘点员（pandian/pandian）:可看到和操作资产管理下的资产仓库可资产盘点
- 主任（zhuren/zhuren）：可查看和操作公文管理，资产管理，个人中心
- 普通用户(lwq/liweiqi): 只可查看个人中心下的薪资管理，通讯录管理，工作计划

以上角色及权限都可以由管理员自由灵活配置，操作权限细分到按钮，菜单。数据权限细分到部门。
## 二、角色说明
### 管理员
![管理员](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/r-%E7%AE%A1%E7%90%86%E5%91%98.png)
### 资产管理员
![资产管理员](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/r-%E8%B5%84%E4%BA%A7%E7%AE%A1%E7%90%86%E5%91%98.png)
### 资产盘点员
![资产盘点员](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/r-%E8%B5%84%E4%BA%A7%E7%9B%98%E7%82%B9%E5%91%98.png)
### 主任
![主任](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/r-%E4%B8%BB%E4%BB%BB.png)
### 普通用户
![普通用户](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/r-%E6%99%AE%E9%80%9A%E7%94%A8%E6%88%B7.png)

## 三、系统所有功能
### 1.公文管理
主要包含两个模块，公文收发和会议管理
#### （1）公文收发
主要用于分行收总行公文和总行发文给分行
#### （2）会议管理
预定办公会议

### 2.资产管理
主要有资产仓库和资产盘点两个模块
#### （1）资产仓库
可进行资产的入库，借出，归还等操作。资产的状态自动控制，如已借出的资产不会再有借出按钮。
#### （2）资产盘点
汇总统计资产仓库现有的资产概况，实时汇总

### 3.辅助办公
辅助办公内可进行图书借阅

### 4.档案管理
档案管理包括人事档案和合同管理
#### （1）人事档案
对企业员工资料进行管理
#### （2）合同管理
对企业合同进行管理

### 5.个人中心
个人中心有三个子模块，包括薪资管理，通讯录管理，工作计划
#### （1）薪资管理
管理员工工资
#### （2）通讯录管理
管理企业通讯录
#### （3）工作计划
管理个人工作计划

### 6.系统管理
系统管理子模块:用户管理，角色管理，菜单管理，部门管理和字典管理。
#### （1）用户管理
可为新员工增加系统登录账号，为离职员工删除账号。
#### （2）角色管理
可新增角色，并为角色赋予相应权限
#### （3）菜单管理
管理系统左侧的菜单树，只有管理员可用
#### （4）部门管理
可增加新部门或新成立子公司，通常只有管理员和高级管理领导可用
#### （5）字典管理
管理系统常用字典值，只有管理员可用

## 四、软件架构

基础环境：
1. JDK:1.8
2. MySQL:5.7
3. Maven3.0

使用框架：

1. 核心框架：Spring Boot 2.1.8.RELEASE
2. 视图框架：Spring MVC 5.0
3. ORM框架：MyBatisPlus 3.1.2
4. 数据库连接池：Druid 1.1
5. 安全框架：Apache Shiro 1.4
6. 日志：SLF4J 1.7、Log4j
7. 前端框架：jqury，bootstrap，layui

## 五、安装教程
1. 导入mysql脚本，创建的数据库名称：bank_oa
2. 修改数据库配置：
![修改数据](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/0-99-%E4%BF%AE%E6%94%B9%E6%95%B0%E6%8D%AE%E5%BA%93.png)
3. 启动java工程（执行工程com.bank.Application.class中main方法）
![启动项目](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/0-99-%E5%90%AF%E5%8A%A8%E9%A1%B9%E7%9B%AE.png)
4. 访问：http://localhost:8887（账号admin/admin）


## 六、系统运行效果图
### 0.登录
- 登录地址：http://localhost:8887/
- 账号密码：admin/admin

![登录](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/0-1-%E7%99%BB%E5%BD%95.png)
![首页](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/0-2-%E9%A6%96%E9%A1%B5.png)
![修改密码](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/0-3-%E4%BF%AE%E6%94%B9%E5%AF%86%E7%A0%81.png)
![切换主题](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/0-4-%E5%88%87%E6%8D%A2%E4%B8%BB%E9%A2%98.png)
![个人中心](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/0-5-%E4%B8%AA%E4%BA%BA%E4%B8%AD%E5%BF%83.png)

### 1.绩效考核
#### 1.1公文列表
![公文管理-公文列表-列表](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/1-%E5%85%AC%E6%96%87%E7%AE%A1%E7%90%86-%E5%85%AC%E6%96%87%E5%88%97%E8%A1%A8-%E5%88%97%E8%A1%A8.png)
![公文管理-公文列表-增加](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/1-%E5%85%AC%E6%96%87%E7%AE%A1%E7%90%86-%E5%85%AC%E6%96%87%E5%88%97%E8%A1%A8-%E5%A2%9E%E5%8A%A0.png)
#### 1.2会议管理
![公文管理-会议管理-列表](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/1-%E5%85%AC%E6%96%87%E7%AE%A1%E7%90%86-%E4%BC%9A%E8%AE%AE%E7%AE%A1%E7%90%86-%E5%88%97%E8%A1%A8.png)
![公文管理-会议管理-增加](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/1-%E5%85%AC%E6%96%87%E7%AE%A1%E7%90%86-%E4%BC%9A%E8%AE%AE%E7%AE%A1%E7%90%86-%E5%A2%9E%E5%8A%A0.png)

### 2.资产管理
![资产管理-资产列表-列表](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/2-%E8%B5%84%E4%BA%A7%E7%AE%A1%E7%90%86-%E8%B5%84%E4%BA%A7%E5%88%97%E8%A1%A8-%E5%88%97%E8%A1%A8.png)
![资产管理-资产列表-增加](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/2-%E8%B5%84%E4%BA%A7%E7%AE%A1%E7%90%86-%E8%B5%84%E4%BA%A7%E5%88%97%E8%A1%A8-%E5%A2%9E%E5%8A%A0.png)
![资产管理-资产盘点-统计](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/2-%E8%B5%84%E4%BA%A7%E7%AE%A1%E7%90%86-%E8%B5%84%E4%BA%A7%E7%9B%98%E7%82%B9-%E7%BB%9F%E8%AE%A1.png)

### 3.辅助办公
![辅助办公-图书管理-列表](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/3-%E8%BE%85%E5%8A%A9%E5%8A%9E%E5%85%AC-%E5%9B%BE%E4%B9%A6%E7%AE%A1%E7%90%86-%E5%88%97%E8%A1%A8.png)
![辅助办公-图书管理-增加](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/3-%E8%BE%85%E5%8A%A9%E5%8A%9E%E5%85%AC-%E5%9B%BE%E4%B9%A6%E7%AE%A1%E7%90%86-%E5%A2%9E%E5%8A%A0.png)

### 4.档案管理
#### 4.1人事档案
![档案管理-人事档案-列表](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/4-%E6%A1%A3%E6%A1%88%E7%AE%A1%E7%90%86-%E4%BA%BA%E4%BA%8B%E6%A1%A3%E6%A1%88-%E5%88%97%E8%A1%A8.png)
![档案管理-人事档案-增加](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/4-%E6%A1%A3%E6%A1%88%E7%AE%A1%E7%90%86-%E4%BA%BA%E4%BA%8B%E6%A1%A3%E6%A1%88-%E5%A2%9E%E5%8A%A0.png)
#### 4.2合同管理
![档案管理-合同管理-列表](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/4-%E6%A1%A3%E6%A1%88%E7%AE%A1%E7%90%86-%E5%90%88%E5%90%8C%E7%AE%A1%E7%90%86-%E5%88%97%E8%A1%A8.png)
![档案管理-合同管理-增加](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/4-%E6%A1%A3%E6%A1%88%E7%AE%A1%E7%90%86-%E5%90%88%E5%90%8C%E7%AE%A1%E7%90%86-%E5%A2%9E%E5%8A%A0.png)

### 5.个人中心
#### 5.1通讯录管理
![个人中心-通讯录管理-列表](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/5-%E4%B8%AA%E4%BA%BA%E4%B8%AD%E5%BF%83-%E9%80%9A%E8%AE%AF%E5%BD%95%E7%AE%A1%E7%90%86-%E5%88%97%E8%A1%A8.png)
![个人中心-通讯录管理-增加](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/5-%E4%B8%AA%E4%BA%BA%E4%B8%AD%E5%BF%83-%E9%80%9A%E8%AE%AF%E5%BD%95%E7%AE%A1%E7%90%86-%E5%A2%9E%E5%8A%A0.png)
#### 5.2薪资管理
![个人中心-薪资管理-列表](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/5-%E4%B8%AA%E4%BA%BA%E4%B8%AD%E5%BF%83-%E8%96%AA%E8%B5%84%E7%AE%A1%E7%90%86-%E5%88%97%E8%A1%A8.png)
![个人中心-薪资管理-增加](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/5-%E4%B8%AA%E4%BA%BA%E4%B8%AD%E5%BF%83-%E8%96%AA%E8%B5%84%E7%AE%A1%E7%90%86-%E5%A2%9E%E5%8A%A0.png)
#### 5.3工作计划
![个人中心-工作计划-列表](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/5-%E4%B8%AA%E4%BA%BA%E4%B8%AD%E5%BF%83-%E5%B7%A5%E4%BD%9C%E8%AE%A1%E5%88%92-%E5%88%97%E8%A1%A8.png)
![个人中心-工作计划-增加](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/5-%E4%B8%AA%E4%BA%BA%E4%B8%AD%E5%BF%83-%E5%B7%A5%E4%BD%9C%E8%AE%A1%E5%88%92-%E5%A2%9E%E5%8A%A0.png)

### 6.系统管理
#### 6.1用户管理
![系统管理-用户管理-列表](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/6-%E7%B3%BB%E7%BB%9F%E7%AE%A1%E7%90%86-%E7%94%A8%E6%88%B7%E7%AE%A1%E7%90%86-%E5%88%97%E8%A1%A8.png)
![系统管理-用户管理-增加](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/6-%E7%B3%BB%E7%BB%9F%E7%AE%A1%E7%90%86-%E7%94%A8%E6%88%B7%E7%AE%A1%E7%90%86-%E5%A2%9E%E5%8A%A0.png)
#### 6.2角色管理
![系统管理-角色管理-列表](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/6-%E7%B3%BB%E7%BB%9F%E7%AE%A1%E7%90%86-%E8%A7%92%E8%89%B2%E7%AE%A1%E7%90%86-%E5%88%97%E8%A1%A8.png)
![系统管理-角色管理-增加](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/6-%E7%B3%BB%E7%BB%9F%E7%AE%A1%E7%90%86-%E8%A7%92%E8%89%B2%E7%AE%A1%E7%90%86-%E5%A2%9E%E5%8A%A0.png)
#### 6.3菜单管理
![系统管理-菜单管理-列表](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/6-%E7%B3%BB%E7%BB%9F%E7%AE%A1%E7%90%86-%E8%8F%9C%E5%8D%95%E7%AE%A1%E7%90%86-%E5%88%97%E8%A1%A8.png)
![系统管理-菜单管理-增加](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/6-%E7%B3%BB%E7%BB%9F%E7%AE%A1%E7%90%86-%E8%8F%9C%E5%8D%95%E7%AE%A1%E7%90%86-%E5%A2%9E%E5%8A%A0.png)
#### 6.4部门管理
![系统管理-部门管理-列表](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/6-%E7%B3%BB%E7%BB%9F%E7%AE%A1%E7%90%86-%E9%83%A8%E9%97%A8%E7%AE%A1%E7%90%86-%E5%88%97%E8%A1%A8.png)
![系统管理-部门管理-增加](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/6-%E7%B3%BB%E7%BB%9F%E7%AE%A1%E7%90%86-%E9%83%A8%E9%97%A8%E7%AE%A1%E7%90%86-%E5%A2%9E%E5%8A%A0.png)
#### 6.5字典管理
![系统管理-字典管理-列表](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/6-%E7%B3%BB%E7%BB%9F%E7%AE%A1%E7%90%86-%E5%AD%97%E5%85%B8%E7%AE%A1%E7%90%86-%E5%88%97%E8%A1%A8.png)
![系统管理-字典管理-增加](https://gitee.com/doudoutang/bankOA/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE/6-%E7%B3%BB%E7%BB%9F%E7%AE%A1%E7%90%86-%E5%AD%97%E5%85%B8%E7%AE%A1%E7%90%86-%E5%A2%9E%E5%8A%A0.png)

## 七、特别说明
本项目可做公司内网使用，也可做自学练习亦可作毕业设计。SQL，前端代码以及指导有偿提供，也可付费咨询其他项目，如不愿意付费的勿扰。
如有付费意愿可加QQ详谈，或约QQ语音电话了解详情及靠谱程度后再做决定，QQ:553039957


## 八、提醒
最近有同学反映有人在淘宝，B站等渠道贩卖我的源代码，本人在此郑重声明，目前只有唯一的购买咨询方式就是加我QQ:553039957.
其他渠道都是非法的，您可能花了钱买到的不是完整系统，请各位真心喜欢本项目的朋友不要上当受骗，请走唯一正规渠道，我只对这唯一渠道的服务负责。
## 九、其他项目
1. [OA系统](https://gitee.com/doudoutang/bankOA)
2. [人事管理系统](https://gitee.com/doudoutang/person_system)
3. [薪资管理系统](https://gitee.com/doudoutang/person_system)
