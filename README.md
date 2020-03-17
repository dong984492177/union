# 工会系统

​		这个项目是游戏的工会系统,因为游戏各个系统相关联，用的功能无法实现,因为时间问题，有的功能就不做了。整个项目采用的SpringBoot框架配合前端的layui框架、用于可视化的echarts框架已经用于各种样式和模态框的 Bootstrap 框架

​		项目地址: http://localhost/union/index 

## 功能

### 首页

![](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316175028818.png)

首页只是布局没有什么功能。

### 登录注册

![image-20200316175302512](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316175302512.png)

登录注册写在一个页面上，用一个标签栏做切。

![image-20200316175437548](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316175437548.png)

注册时不能为空

![image-20200316175511283](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316175511283.png)

ajax校验账号

![image-20200316175711535](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316175711535.png)

昵称校验长度限制

![image-20200316175745752](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316175745752.png)

注册成功切换至登录栏

![image-20200316175842412](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316175842412.png)

登录成功跳转至首页，首页获得昵称和图片（图片因为设置本地图库,现在没啥用本地图库的原因无法显示)。

### 个人信息功能

![image-20200316180214109](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316180214109.png)

个人信息功能分为 ：基本信息资料、修改密码、注销账号（未完成）

#### 基本信息

![image-20200316180500857](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316180500857.png)

##### 个人信息展示

##### 个人信息修改

##### 图片上传

#### 密码修改功能

##### 	页面密码显示隐藏

![image-20200316180804774](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316180804774.png)

空值校验，两次密码校验，两次密码校验不正确则无法提交，原密码不正确也无法修改成功。

##### 密码修改

### 工会功能![image-20200316181122745](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316181122745.png)

跳转到新的页面

左侧导航条会因为工会状态不同而不一样上面的是刚注册没有工会的状态

![image-20200316181325928](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316181325928.png)

这是工会会长的导航条，多了我的工会部分，少了创建工会功能

![image-20200316181548649](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316181548649.png)

这是工会副会长的导航条，少了解散工会页面

![image-20200316182308115](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316182308115.png)

这是精英和普通成员的导航条，少了申请管理 和管理工会功能

#### 查看所有工会

##### 工会信息分页展示

![image-20200316182752573](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316182752573.png)

将所有工会页面信息展示出来做成分页形式的。

##### 申请加入工会功能

![image-20200316183116314](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316183116314.png)

每一个工会都可以申请，但是如果有工会按钮将被禁言，如果你再申请的瞬间，你已经加入了其他工会（就是被别的工会同意了 ，就是现在）你将申请失败

#### 创建工会

![image-20200316183438509](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316183438509.png)

##### 工会名字校验

工会的创建肯定离不开拉风的名字，可惜事与愿违，你心仪的名字已经是别人的掌中之物，冒险家换个名字重新开始吧。

##### 工会创建功能

![](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316184110962.png)

当懵懂无知的少年注册好白皮号以后，满很期待的创建带着心仪已旧工会名字的工会，梦想着组建一群志同道合的朋友来一起闯荡游戏，但现实却是泼了少年一盆凉水。没钱？创什么工会。“呸，说什么梦想，到头还是要钱”。

#### 查看工会

但你还在为梦想而奋斗的时候，别人已经实现了你的梦想第一步——————创建工会

##### 工会头部信息展示

![image-20200316185102782](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316185102782.png)

工会的头部信息展示了工会的基本信息，向世人证明了工会的存在

##### 工会成员分页功能

![image-20200316191413695](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316191413695.png)



底部是工会的成员信息，采用分页的显示查看。

工会会长以红色展示，以示绝对权威

工会副会长以绿色展示，因为只有足够绿叶才配为副会长

工会精英以金色展示，表示精英身法的重要性（虽然并不是很重要）

工会普通人以黑色展示，表示普通人还需努力

##### 工会总部总贡献可视化

![image-20200316191618161](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316191618161.png)

没有贡献就没有工会的未来，贡献是一个工会的灵魂，以饼状图展现总贡献的多少，极大的饼状图给与贡献高的成员一种荣耀感，对应贡献低的会引以为耻，努力加油多为工会贡献

#### 申请管理功能

申请管理功能是工会的核心功能，没有申请的新人就没有工会的成员，也就没有工会的发展

##### 申请消息分页

![image-20200316192629356](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316192629356.png)

###### 同意功能

同意该成员的申请，若是该成员已经加入工会则拒绝该成员

##### 拒绝功能

拒绝该成员的申请	

##### 选中全部同意功能

多选，选中的成员的申请全部同意，其中若有成员加入工会则拒绝该成员

##### 选中全部拒绝功能

多选，选中的成员的申请全部拒绝

#### 管理工会功能

##### 工会成员分页

分页，后面跟着操作按钮，但等级不同所管理的半天

![image-20200316193502876](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316193502876.png)

上面是工会会长的，会长无法对自己操作

![image-20200316193656732](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316193656732.png)

上面是副会长的，不仅不能对会长进行操作，还不能对同级的副会长操作

##### 任命功能



![image-20200316193818990](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316193818990.png)

任命也分等级，不要以为你是副会长你可以任命就能为所欲为，你的权限是残缺的，你只要任命 精英和普通成员的份。

![image-20200316194041118](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316194041118.png)

这才是会长的完整功能，不仅还能任命副会长

最重要的是：如何不想干了就可以把工会会长转让，让闲给有志之士

##### 移除工会成员功能

移除工会成员

##### 选中全部移除功能

选择的工会成员全部移除

#### 退出工会功能

![image-20200316194432587](https://github.com/dong984492177/union/%E6%88%AA%E5%9B%BE\image-20200316194432587.png)

如果你是工会会长，你想退出，你得转让工会会长。

你如果不是工会会长，千万不要想不开点这里，不然你会失去你亲爱的工会，成为一个无会人士。

# 未完成功能

#### 账号注销

#### 工会解散

#### 我的申请页查看

#### 我的申请撤销

