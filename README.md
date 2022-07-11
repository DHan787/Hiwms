                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/'---'\____
             .'  \\|     |//  '.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  '-'  ___/-. /
         ___'. .'  /--.--\  '. .' ___
      ."" '<  '.___\_<|>_/___.'  >' "".
     | | :  '- \'.;'\ _ /';.'/ -'  : | |
     \  \ '-.   \_ __\ /__ _/   .-' /  /
     ===================================
            佛祖保佑       永无BUG


# ！！请把每次commit内容书写在本文档！！
# commit内容
## 6.30
* 用户的删除 
* goods的问题修正 没有import lombok.Data;
* 二次确认是否删除
* 数据库使用sha加密
> 手动加密密码方法：
> 1. 找utils包里的EncryptUtil类
> 2. 找到main函数，将str赋值为你的密码
> 3. 运行此类的main函数
> 4. 将控制台输出的加密后的复制粘贴到数据库中
  
自动化方法开发中

## 7.1
* 订单管理完成 hj
* 货物新增功能完成 hxy
* 用户添加完成 ymm
* 货物管理完成 hxy
* 订单类型 zls
* 订单创建时间和订单结束时间 zls
* 实现修改功能；解决了界面输入中文乱码的问题 hxy 16:32
* 订单操作员和订单创建人 下拉框 zls
* user界面新增用户的密码加密 hj
* Login界面添加验证码功能 wlx
* users 删除debug hj
* 注意mapping的地址和axios 的URL "http://localhost:8080/users/" + userId 对应为 "http://localhost:8080/users/{id}
* 完成新建订单（时间选择，订单类型选择）hj
* 简陋的页面跳转 
  仓库页面的建立（复制的货品页面 只改了文本部分）zls
* 用户界面的增删改实现 ymm


## 7.2
* 实现使用iframe嵌入网页进行跳转 hxy 10:29
* 更改仓库名 新建market页面 zls
* 超市货物员页面 剩余页面iframe更新 多余注释代码删除 zls 
* 登录界面完善（还有一个小小的BUG）WLX
* 所有查询按钮 所有页面中的增加和编辑方法 所有按钮的icon zls
* 操作员页面 ymm 注意前端prop里的内容一定要和实体类中的名字一致！
* 添加uesrInfo表及相关类，添加userDetail类，连结user类和userInfo类到userDetail
* idGenerator跟据userInfo 的 alter time 和 userid产生 userDetail id hj
* 修改了删除只能删最后一个的bug hxy 17:30
* 更正删除功能 hxy 修改所有编辑删除 zls

## 7.4
* 添加吉祥物 hj
* StockIn StockOut 的save功能 hj
* good->goods 部分查询代码 zls
* number删掉 zls
* 订单自动生成 hj
* stock-in-apply.html 实现前端 ymm
* 完成货物员的入库申请 ymm
* 修正goods页面的问题 zls
* goods模糊查询bug zls

* Stockin 完成 hj
* 完成入库申请订单号前端对接 ymm
> > 一点提示： 前端调用接口的时候一定要注意大小写、单复数，名字不要写错
* stockOut 完成 StockIn 和 StockOut 优化整合 hj
* 个人中心页面跳转



## 7.5
* 提示出入库数量不能为零 ymm
* goods名称的模糊查询 zls
* 用户详情显示存在bug hxy
* inventory页面 下拉菜单 ymm
* 用户详情显示bug完成修复 hj
* 用户详情的查看、编辑、删除完成 hxy
* 用户详情编辑完成；用户详情显示存在bug hxy
* Detail debug order添加update hj
* getByType hj
* orders页面 设置操作员、显示出入库状态 ymm
* 拦截器V1.0 hj
* orders页面 完成确认订单 ymm
* 指名操作员，管理员确认订单debug
* 所有页面的文本框的模糊查询 zls
* 修正users页面 zls
* 拦截器 addPathPatterns("/api/**")配置拦截路径，其中/**表示当前目录以及所有子目录（递归），/*表示当前目录，不包括子目录。
* UsersDetail的getById hj
* 返回主页功能 wlx
* UsersDetail的getById debug 拦截器 disable hj
* orders和inventory的二次渲染 ymm
* 修正方法名 zls
* 恢复被覆盖掉的正版搜索内容 zls
* StockIn前端和后端完成：1.显示订单中入库货物详情;2.入库-修改库存、修改订单状态、删除入库申请记录 hxy
* users 查询的debug UsersDetailController 添加 getByIds hj
* 分页器 zls
* 退出登录功能 wlx
* StockOut前后端完成 （但因出库订单有bug，没有进行测试）hxy
* orders页面能看见订单详情 ymm
* 更正订单和库存页面搜索功能的bug 
  修改login页面”忘了密码？“-》“没有账号？=》点击注册” 修改login页面前端 zls
* userInfo的delete的部分代码，存在bug hxy
* stock-in和stock-out的出入库按钮位置修改 ymm
* 🍺 出入库、订单生成整个流程的完成 hxy & ymm 

## 7.6
* 出库订单的详情信息 ymm
* 个人信息页面 WLX
* 美化菜单栏 wlx
* 更改注册页面前端 zls
* 实现出入库后生成订单结束时间 hxy
* 出入库申请的数字输入框改为空白，并验证输入的是否为数字 ymm
* 判断出入库申请的数量是否为空 ymm
* 判断出库数量不能大于库存数量 ymm
* 添加注册时个人信息填写页面registerInfo（未成功实现） zls
* 新增页面标签页小logo，完整显示header的文字，页面左上角显示logo ymm

## 7.7
* orders页面不可重复确认订单，必须选择操作员才能确认订单 ymm
* 解决分页后无法编辑第二页数据的问题 ymm
    >>核心代码：index = ((this.currentPage-1) * this.pageSize + index)
    > 
    > 将index根据页数重新设置
* 操作员和货物员页面的分页器 zls
* 订单详情显示出入库状态条 ymm
* 修改出入库后订单无法查看详情的问题 hxy
* 增加了首页商品库存柱图 hxy
* 删除打印插件 修正分页器 zls

## 7.8
* 拦截器实现 hj
* 注销用户实现 hj
* 货物页面的excel导入导出 zls
* 其他页面的excel导出 zls
* 实现订单数据可视化的前后端 增加控制台页面 hxy
* 前端页面优化 ch
* 前端页面美化 wlx
* 低库存警告Debug login.html debug hj


## 7.9
* 侧边栏 wlx 
* 侧边栏 ch
* 低库存提醒 zls
*操作员仓库货物员页面更新

## 7.11
* 增加了仪表盘数据；样式待调整 hxy
* 滚动条修改ch
* 首页修改ch
* 仪表盘修改ch
* 修改了柱状图显示不全的bug hxy
* 图表样式修改；对折线图的y轴日期排序 hxy
* 入库申请事件监听，并且在管理员首页显示相关通知 ymm
* 不重要的修改 zls