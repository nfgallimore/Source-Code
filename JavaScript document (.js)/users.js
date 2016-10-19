var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
  var Parse = require('parse').Parse;
  Parse.initialize("sD4tDFzNyuas8Vg0VhoXeF5OSnLHMkJRLxuHOkUL", "ntKIRdfzedSkLFGaj99qrC2lG2VNOXdWIrONcVIP");
  var query = new Parse.Query(Parse.User);
  query.find({
    success: function(users) {
      for (var i = 0; i < users.length; ++i) {
          console.log(users[i].get('lname'));
          console.log(users[i].get('id'));
      }
      res.send(users);
    }
  });
});
module.exports = router;
