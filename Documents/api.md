# User 相关

名称 | 路径 | 方法 | 实例 | 返回数据 | 备注
-- | -- | -- | -- | -- | --|
登陆 | /User/v1/login | Post |
登出 | /User/v1/logoff/{userid} | Get | 暂未实现
创建 | /User/v1 | Post |

# 文章相关

名称 | 路径 | 方法 | 实例 | 返回数据 | 备注 
-- | -- | -- | -- | -- | -- |
获取某种类别文章 | api/Articles/v1/Type/{type}/list?offset=&limit= | Get | api/Articles/v1/Type/Info/list | max limit=50 默认limit=10
创建某种类别文章 | api/Articles/v1/Type/{type} | Post | api/Articles/v1/Type/Info |
更新某篇文章 | api/Articles/v1/Type/{type}/id/{id} | Post | api/Articles/v1/Type/Info/id/10
删除某篇文章 | api/Articles/v1/Type/{type}/id/{id} | Delete | api/Articles/v1/Type/Info/id/10
获取最新动态 | /api/Articles/v1/News | Get  | 
获取上一篇/下一篇 | api/Articles/v1/Type/Info/latest?next=&date= |GET|api/Articles/v1/Type/Info/latest?next=false&date=1490671739815 | 若无数据，则返回204，有数据则数据实体+200 next为true或者false，date为时间戳

目前三种文章类型：Events,Experts,Info

# 图片相关
名称 | 路径 | 方法 | 实例 | 返回数据 | 备注
-- | -- | -- | -- | -- | -- |
上传图片 | api/Image/v1/upload | Post | 参见后台index页面


初始用户：
account: initialAccount
password: testPassword
