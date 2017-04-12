var express = require('express');
var path = require('path');
var http = require('http');
var proxy = require('express-http-proxy');
var multer = require('multer');

var fileUploadPath = process.env.FILE_UPLOAD_PATH || path.join(__dirname,'../' ,'FrontEndUI/uploads/');
var backendServiceAddr = process.env.BKD_SERVER_ADDR || '127.0.0.1:8081';
var imageServerAddr = process.env.IMG_SERVER_ADDR || '/uploads/';
var expressServerPort = process.env.EXPRESS_SERVER_PORT || 80;

var storage = multer.diskStorage({
    destination: function (req, file, cb) {
        cb(null, fileUploadPath);    // 保存的路径，备注：需要自己创建
    },
    filename: function (req, file, cb) {
        var fileNameArr = file.originalname.split('.');
        var fileName = Date.now() + "." + fileNameArr[fileNameArr.length - 1];
        cb(null, fileName);  
    }
});

var upload = multer({ storage :storage});

var app = express();

app.set('port', expressServerPort);

app.use('/', express.static(path.join(__dirname,'../' ,'FrontEndUI')));

app.use('/', proxy(backendServiceAddr,{
  filter: function(req, res) {
     return req.url.indexOf('/api/') == 0 && req.url.indexOf('/api/Image/v1/upload') != 0;
  },
  forwardPath: function(req, res) {
    return require('url').parse(req.url).path;
  }
}));

app.post('/api/Image/v1/upload',upload.single('file'),function (req, res, next) {
  var fileName = imageServerAddr + req.file.filename;
  res.send(JSON.stringify(fileName));
});


http.createServer(app).listen(app.get('port'), function() {
  console.log('静态资源服务器已启动,监听端口:' + app.get('port'));
});
