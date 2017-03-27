# User 相关

名称 | 路径 | 方法 | 实例 | 返回数据 | 备注
-- | -- | -- | -- | -- |
登陆 | /User/login | Post |
登出 | /User/logoff/{userid} | Get | 暂未实现
创建 | /User | Post |

# 文章相关

名称 | 路径 | 方法 | 实例 | 返回数据 | 备注 
-- | -- | -- | -- | -- | -- |
获取某种类别文章 | api/Articles/Type/{type}?offset=&limit= | Get | api/Articles/v1/Type/Info/list | max limit=50 默认limit=10
创建某种类别文章 | Articles/Type/{type} | Post | api/Articles/v1/Type/Info |
更新某篇文章 | Articles/Type/{type}/id/{id} | Post | api/Articles/v1/Type/Info/id/10
获取最新动态 | /api/Articles/v1/News | Get  | 

目前三种文章类型：Events,Experts,Info

# 图片相关
名称 | 路径 | 方法 | 实例 | 返回数据 | 备注
-- | -- | -- | -- | -- | -- |
上传图片 | api/Image/v1/upload | Post | 参见后台index页面


初始用户：
account: initialAccount
password: testPassword
