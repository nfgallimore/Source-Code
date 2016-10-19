/**
 * Created by nickgallimore on 8/24/15.
 */
var express = require('express');
var router = express.Router();

router.get('/', function(req, res, next) {
    var Parse = require('parse').Parse;
    Parse.initialize("sD4tDFzNyuas8Vg0VhoXeF5OSnLHMkJRLxuHOkUL", "ntKIRdfzedSkLFGaj99qrC2lG2VNOXdWIrONcVIP");
    var Run = Parse.Object.extend("Run");
    var query = new Parse.Query(Run);
    query.find({
        success: function (results) {
            // Do something with the returned Parse.Object values
            for (var i = 0; i < results.length; i++) {
                var object = results[i];
                console.log(object.get('time'));
            }
            res.send(results);
        },
        error: function (error) {
            alert("Error: " + error.code + " " + error.message);
        }
    });
});

/* GET users listing. */
router.get('/:user', function(req, res, next) {
    var Parse = require('parse').Parse;
    Parse.initialize("sD4tDFzNyuas8Vg0VhoXeF5OSnLHMkJRLxuHOkUL", "ntKIRdfzedSkLFGaj99qrC2lG2VNOXdWIrONcVIP");
    var id = req.params.user;
    if (id) {
        var Run = Parse.Object.extend("Run");
        var query = new Parse.Query(Run);
        query.equalTo("user", id);
        query.find({
            success: function (results) {
                // Do something with the returned Parse.Object values
                for (var i = 0; i < results.length; i++) {
                    var object = results[i];
                    console.log(object.get('time'));
                }
                res.send(results);
            },
            error: function (error) {
                alert("Error: " + error.code + " " + error.message);
            }
        });
    }
    else {
        var Run = Parse.Object.extend("Run");
        var query = new Parse.Query(Run);
        query.find({
            success: function (results) {
                // Do something with the returned Parse.Object values
                for (var i = 0; i < results.length; i++) {
                    var object = results[i];
                    console.log(object.get('time'));
                }
                res.send(results);
            },
            error: function (error) {
                alert("Error: " + error.code + " " + error.message);
            }
        });
        next();
    }
});
module.exports = router;