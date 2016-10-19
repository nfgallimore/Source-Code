var express = require('express');
var router = express.Router();
// app, js, master

/* GET home page. */
router.get('/', function(req, res, next) {
    res.render('index', {title: 'Track-Houston'});
});

module.exports = router;