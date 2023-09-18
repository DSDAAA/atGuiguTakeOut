# API

###1.商品列表

```
GET /buyer/product/list
```
参数
```
无
```
返回  //查询的是foodType ，关联查询food表
```
{
    "code": 0,
    "msg": "成功",
    "data": [
        {
            "name": "主食",
            "type": 1,
            "foods": [
                {
                    "id": "123456",
                    "name": "包子",
                    "price": 4.5,
                    "description": "好吃的包子",
                    "icon": "http://xxx.com/ha.png"
                }
            ]
        },
        {
            "name": "甜食",
            "type": 2,
            "foods": [
                {
                    "id": "123458",
                    "name": "蛋糕",
                    "price": 9.9,
                    "description": "超级美味爽口",
                    "icon": "http://xxx.com/he.png"
                }
            ]
        }
    ]
}


```

###2.创建订单

```
POST /buyer/order/create
```

参数

```
name: 张三
phone: 18822223333
address: 北科
openid: ew3euwhd7sjw9diwkq //用户的微信openid
items: [{
    productId: f101,
    productQuantity: 2 //购买数量
}]

```

返回

```
{
  "code": 0,
  "msg": "成功",
  "data": {
      "orderId": "147283992738221" 
  }
}
```

###3.订单列表

```
GET /buyer/order/list
```

参数

```
openid: wx110
page: 0 //从第0页开始
size: 10
```

返回

```
{
  "code": 0,
  "msg": "成功",
  "data": [
    {
      "orderId": "161873371171128066",
      "buyerName": "赵六",
      "buyerPhone": "18868877111",
      "buyerAddress": "北科",
      "buyerOpenid": "18eu2jwk2kse3r42e2e",
      "orderAmount": 0,
      "orderStatus": 0,
      "payStatus": 0,
      "createTime": 1490171219,
      "updateTime": 1490171219,
      "orderDetailList": null
    },
    {
      "orderId": "161873371171128076",
      "buyerName": "张三",
      "buyerPhone": "18868877111",
      "buyerAddress": "北京通州",
      "buyerOpenid": "18eu2jwk2kse3r42e2e",
      "orderAmount": 0,
      "orderStatus": 0,
      "payStatus": 0,
      "createTime": 1490171219,
      "updateTime": 1490171219,
      "orderDetailList": null
    }]
}
```

###4.查询订单详情

```
GET /buyer/order/detail
```

参数

```
openid: 18eu2jwk2kse3r42e2e
orderId: 161899085773669366
```

返回

```
{
    "code": 0,
    "msg": "成功",
    "data": {
          "orderId": "161899085773669363",
          "buyerName": "李四",
          "buyerPhone": "18868877111",
          "buyerAddress": "北科",
          "buyerOpenid": "18eu2jwk2kse3r42e2e",
          "orderAmount": 18,
          "orderStatus": 0,
          "payStatus": 0,
          "createTime": 1490177352,
          "updateTime": 1490177352,
          "orderDetailList": [
            {
                "detailId": "161899085974995851",
                "orderId": "161899085773669363",
                "productId": "157875196362360019",
                "productName": "馒头",
                "productPrice": 1.5,
                "productQuantity": 2,
                "productIcon": "http://xxx.com/mantou.png",
                "productImage": "http://xxx.com/mantou.jpg"
            }
        ]
    }
}
```

###5.取消订单

```
POST /buyer/order/cancel
```

参数

```
openid: 18eu2jwk2kse3r42e2e
orderId: 161899085773669363
```

返回

```
{
    "code": 0,
    "msg": "成功",
    "data": null
}
```

###6.获取openid

```
重定向到 /sell/wechat/authorize
```

参数

```
returnUrl: http://xxx.com/abc  //【必填】
```

返回

```
http://xxx.com/abc?openid=oZxSYw5ldcxv6H0EU67GgSXOUrVg
```


