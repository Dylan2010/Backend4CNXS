# User 相关

名称 | 路径 | 方法 | 实例
-- | -- | -- | --
登陆 | /User/Login | Post |
登出 | /User/Logoff/{userid} | Get
创建 | /User | Post |

# 文章相关

名称 | 路径 | 方法 | 实例 | 备注
-- | -- | -- | -- | -- |
获取某种类别文章 | Articles/type/{type}?offset=&limit= | Get | | max limit?
创建某种类别文章 | Articles/type/{type} | Post
更新某篇文章 | Articles/type/{type}/id/{id} | Post
获取最新动态 | Articles/news | Get 